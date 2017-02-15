package com.sunx.common.load;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.ByteArrayBuffer;

import com.sunx.common.encoding.CheckEncoding;
import com.sunx.common.files.FileUtils;

public class PagerLoader {
	public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36";
	public static final String CHARSET_REGEX = "(?:<meta.*)(?:charset=)(?:['\\\"]?)(\\w*-?\\d*)";
	public static final String CHARSET_ZHCN = "";
	
	private CloseableHttpClient httpClient;
	private BasicCookieStore cookieStore = null;
	private CheckEncoding check = new CheckEncoding();
	
	private static PagerLoader load = new PagerLoader();
	
	private PagerLoader(){
		initHttpClient();
	}
	
	public static PagerLoader getInstance(){
		return load;
	}
	
	public void initHttpClient(){
		// 
		PoolingHttpClientConnectionManager httpClientConnectionManager = new PoolingHttpClientConnectionManager();
		httpClientConnectionManager.setMaxTotal(20);
		httpClientConnectionManager.setDefaultMaxPerRoute(20);
		
		// 
		LaxRedirectStrategy redirectStrategy = new LaxRedirectStrategy();
		cookieStore = new BasicCookieStore();
		
		httpClient = HttpClients.custom()
				.setConnectionManager(httpClientConnectionManager)
				.setRedirectStrategy(redirectStrategy)
				.setDefaultCookieStore(cookieStore)
				.setUserAgent(USER_AGENT).build();
	}
	
	public String getMethod(String url,Map<String,String> header){
		return getMthodByProxy(url, header, null, 0);
	}
	public String postMethod(String url,Map<String,String> header,Map<String,String> postData){
		return postMethodByProxy(url,header,postData,null,0);
	}
	public String postMethodByProxy(String url,Map<String,String> header,Map<String,String> postData,String host,int port){
		String src = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		HttpPost httpPost = null;
		try {
			url = url.trim();
			
			//
			RequestConfig requestConfig = null;
			if(host == null || "".equals(host) || port <= 0){
				requestConfig = RequestConfig.custom()
				.setConnectTimeout(1000 * 15)
				.setSocketTimeout(1000 * 15)
				.setCookieSpec(CookieSpecs.DEFAULT).build();
			}else{
				requestConfig = RequestConfig.custom()
						.setProxy(new HttpHost(host,port))
						.setConnectTimeout(1000 * 15)
						.setSocketTimeout(1000 * 15)
						.setCookieSpec(CookieSpecs.DEFAULT).build();
			}
			
			httpPost = new HttpPost(url);
			httpPost.setConfig(requestConfig);
			
//			设置请求头
			if(header != null && header.size() > 0){
				for(Entry<String,String> entry : header.entrySet()){
					httpPost.setHeader(entry.getKey(),entry.getValue());
				}
			}
//			设置参数
			if(postData != null && postData.size() > 0){
				List<NameValuePair> nvps = new ArrayList <NameValuePair>();
				for(Entry<String,String> entry : postData.entrySet()){
					nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
				}
				httpPost.setEntity(new UrlEncodedFormEntity(nvps,"UTF-8"));
			}
//			执行请求
			response = httpClient.execute(httpPost);
			entity = response.getEntity();
			//获得响应流
			InputStream is = entity.getContent();
			
			ByteArrayBuffer buffer = new ByteArrayBuffer(4096);
			byte[] tmp = new byte[4096];
			int count;
			try {
				while ((count = is.read(tmp)) != -1) {
					buffer.append(tmp, 0, count);
				}
			} catch (EOFException e) {
				System.err.println("EOFException : " + url);
			}
			
			//使用CheckEncoding来识别编码
			String charset = check.getEncoding(is);
			
//			如果上一步没有获得字符编码。那直接从网页源码中的meta标签中更具正则匹配
			if(!charset.toLowerCase().contains("utf") && !charset.toLowerCase().contains("gb")){
				charset = getCharsetFromMetaTag(buffer, url);
				if(charset == null || "".equals(charset.trim())){
					charset = getCharsetFromResponeTitle(entity,url);
					if(charset == null || "".equals(charset.trim())){
						//强制编码
						charset = "utf-8";
					}
				}
			}
			
			src = new String(buffer.toByteArray(), charset);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(response != null){
				try {
					response.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return src;
	}
	public String getMthodByProxy(String url,Map<String,String> header,String host,int port){
		String src = null;
		CloseableHttpResponse response = null;
		HttpGet httpGet = null;
		HttpEntity entity = null;
		try {
			//
			RequestConfig requestConfig = null;
			if(host == null || "".equals(host) || port <= 0){
				requestConfig = RequestConfig.custom()
				.setConnectTimeout(1000 * 15)
				.setSocketTimeout(1000 * 15)
				.setCookieSpec(CookieSpecs.DEFAULT).build();
			}else{
				requestConfig = RequestConfig.custom()
						.setProxy(new HttpHost(host,port))
						.setConnectTimeout(1000 * 15)
						.setSocketTimeout(1000 * 15)
						.setCookieSpec(CookieSpecs.DEFAULT).build();
			}
			
			httpGet = new HttpGet(url);
			httpGet.setConfig(requestConfig);
			
//			设置请求头
			if(header != null && header.size() > 0){
				for(Entry<String,String> entry : header.entrySet()){
					httpGet.setHeader(entry.getKey(),entry.getValue());
				}
			}
			
//			执行请求
			response = httpClient.execute(httpGet);
			entity = response.getEntity();
			
			//获得响应流
			InputStream is = entity.getContent();
			
			ByteArrayBuffer buffer = new ByteArrayBuffer(4096);
			byte[] tmp = new byte[4096];
			int count;
			try {
				while ((count = is.read(tmp)) != -1) {
					buffer.append(tmp, 0, count);
				}
			} catch (EOFException e) {
				System.err.println("EOFException : " + url);
			}
			
			//使用CheckEncoding来识别编码
			String charset = check.getEncoding(is);
			
//			如果上一步没有获得字符编码。那直接从网页源码中的meta标签中更具正则匹配
			if(!charset.toLowerCase().contains("utf") && !charset.toLowerCase().contains("gb")){
				charset = getCharsetFromMetaTag(buffer, url);
				if(charset == null || "".equals(charset.trim())){
					charset = getCharsetFromResponeTitle(entity,url);
					if(charset == null || "".equals(charset.trim())){
						//强制编码
						charset = "utf-8";
					}
				}
			}
			
			src = new String(buffer.toByteArray(), charset);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(response != null){
				try {
					response.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return src;
	}
	private String getCharsetFromResponeTitle(HttpEntity entity,String url){
		String charset = null;
		ContentType contentType = null;
		try {
			contentType = ContentType.getOrDefault(entity);
			Charset charsets = contentType.getCharset();
			if (charsets != null) {
				charset = charsets.toString();
			}else{
				System.out.println("相应头中无编码格式: " + url);
			}
		} catch (Exception e1) {
			if (CHARSET_ZHCN.equals(e1.getMessage())) {
				charset = CHARSET_ZHCN;
			}
		}
		return charset;
	}
	private String getCharsetFromMetaTag(ByteArrayBuffer buffer,String url){
		String charset = null;
//		如果上一步没有获得字符编码。那直接从网页源码中的meta标签中更具正则匹配
		Pattern p = Pattern.compile(CHARSET_REGEX,
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(new String(buffer.toByteArray()));
		boolean result = m.find();
		if (result) {
			if (m.groupCount() == 1) {
				charset = m.group(1);
			} 
			System.err.println("网页 中的编码:" + charset + "\t url:" + url);
		} else {
			System.err.println("Meta标签中无编码格式: " + url);
		}
		return charset;
	}
	
	public CookieStore getCookieStore(){
		return cookieStore;
	}
	
	public static void main(String[] args) {
		String src = PagerLoader.getInstance().getMethod("http://www.huya.com/1246249821", null);
		FileUtils.writer("F://23.txt", "UTF-8", src);
	}
}

package com.sunx.common.solr;

import java.util.List;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

public class SolrConnectionServer {
	/**
	 * solr server url
	 */
	private String solrUrl = null;
	
	private int timeOut;
	private int perHost;
	private int maxConnections;
	
	private HttpSolrClient client = null;
	/**
	 * 创建单例对象
	 * @author Administrator
	 *
	 */
	private static class SingletonClassInstance {
		private static final SolrConnectionServer instance = new SolrConnectionServer();
	}
	/**
	 * 获取对象
	 * @return
	 */
	public static SolrConnectionServer me(){
		return SingletonClassInstance.instance;
	}
	/**
	 * 创建索引连接
	 */
	public void connecte(){
		client = new HttpSolrClient(solrUrl);
		client.setConnectionTimeout(timeOut);
		client.setDefaultMaxConnectionsPerHost(perHost);
		client.setFollowRedirects(true);
		client.setMaxTotalConnections(maxConnections);
	}
	/**
	 * 向索引中添加一个对象
	 * @param bean
	 * @return
	 */
	public int addBean(Object bean){
		try {
			client.addBean(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commit();
	}
	/**
	 * 向solr中添加一个文档
	 * @param doc
	 * @return
	 */
	public int addDoc(SolrInputDocument doc){
		try {
			client.add(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commit();
	}
	/**
	 * 向索引中添加一个集合
	 * @param bean
	 * @return
	 */
	public int addBean(List<Object> beans){
		try {
			client.addBeans(beans);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commit();
	}
	/**
	 * 根据id,批量删除数据
	 * @param ids
	 * @return
	 */
	public int delete(List<String> ids){
		try {
			client.deleteById(ids);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commit();
	}
	/**
	 * 根据id删除数据
	 * @param id
	 * @return
	 */
	public int delete(String id){
		try {
			client.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commit();
	}
	/**
	 * 根据给定的查询语句删除
	 * @param query
	 * @return
	 */
	public int deleteByQuery(String query){
		try {
			client.deleteByQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commit();
	}
	
	/**
	 * 提交数据
	 * @return
	 */
	public int commit(){
		try {
			UpdateResponse response = client.commit();
			return response.getStatus();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * @param solrUrl
	 * @return
	 */
	public SolrConnectionServer setSolrUrl(String solrUrl){
		this.solrUrl = solrUrl;
		return this;
	}
	public String getSolrUrl() {
		return solrUrl;
	}
	public long getTimeOut() {
		return timeOut;
	}
	public SolrConnectionServer setTimeOut(int timeOut) {
		this.timeOut = timeOut;
		return this;
	}

	public int getPerHost() {
		return perHost;
	}

	public SolrConnectionServer setPerHost(int perHost) {
		this.perHost = perHost;
		return this;
	}

	public int getMaxConnections() {
		return maxConnections;
	}

	public SolrConnectionServer setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
		return this;
	}
}
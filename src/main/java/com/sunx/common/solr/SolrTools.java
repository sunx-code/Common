package com.sunx.common.solr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.common.SolrInputDocument;

public class SolrTools {
	private String solrUrl = null;
	private int timeOut = 1000;
	private int perHost= 10;
	private int maxConnections = 10;
	
	private SolrConnectionServer solrServer = null;
	
	public static void main(String[] args) {
		SolrTools tools = new SolrTools();
		tools.setSolrUrl("http://localhost:8080/solr/solr")
			 .setMaxConnections(10)
			 .setPerHost(10)
			 .setTimeOut(1000)
			 .initSolrServer();
		
//		SolrBean bean = new SolrBean();
//		bean.setId("sunxing123123");
//		bean.setTitle("this is title...");
//		bean.setContent("this is content");

//		tools.addBean(bean);

//		tools.deleteAll();

		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id","1234qwertSDFawert");
		map.put("title","sunx");

		System.out.println(tools.addDoc(map));
	}
	
	/**
	 * 向索引中添加一个文档
	 * @param bean
	 * @return
	 */
	public int addBean(SolrBean bean){
		return solrServer.addBean(bean);
	}
	/**
	 * 向索引中添加一个文档
	 * @param fields
	 * @return
	 */
	public int addDoc(Map<String,Object> fields){
		SolrInputDocument doc = new SolrInputDocument();
		for(Map.Entry<String,Object> entry : fields.entrySet()){
			doc.addField(entry.getKey(), entry.getValue());
		}
		return solrServer.addDoc(doc);
	}
	/**
	 * 从索引中删除数据
	 */
	public void deleteAll(){
		solrServer.deleteByQuery("*:*");
	}
	/**
	 * 从索引中删除数据
	 * @param query
	 */
	public void deleteByQuery(String query){
		solrServer.deleteByQuery(query);
	}
	/**
	 * 从索引中删除数据
	 * @param ids
	 */
	public void deleteByIds(List<String> ids){
		solrServer.delete(ids);
	}
	/**
	 * 从索引中删除数据
	 * @param id
	 */
	public void deleteById(String id){
		solrServer.delete(id);
	}
	/**
	 * 初始化solr实例对象
	 * @return
	 */
	public void initSolrServer(){
//		获取solr实例
		solrServer = SolrConnectionServer.me()
							   .setSolrUrl(solrUrl)
							   .setTimeOut(timeOut)
							   .setPerHost(perHost)
							   .setMaxConnections(maxConnections);
		solrServer.connecte();
	}
	public String getSolrUrl() {
		return solrUrl;
	}
	public SolrTools setSolrUrl(String solrUrl) {
		this.solrUrl = solrUrl;
		return this;
	}
	public int getTimeOut() {
		return timeOut;
	}
	public SolrTools setTimeOut(int timeOut) {
		this.timeOut = timeOut;
		return this;
	}
	public int getPerHost() {
		return perHost;
	}
	public SolrTools setPerHost(int perHost) {
		this.perHost = perHost;
		return this;
	}
	public int getMaxConnections() {
		return maxConnections;
	}
	public SolrTools setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
		return this;
	}
	public SolrConnectionServer getSolrServer() {
		return solrServer;
	}
	public SolrTools setSolrServer(SolrConnectionServer solrServer) {
		this.solrServer = solrServer;
		return this;
	}
}
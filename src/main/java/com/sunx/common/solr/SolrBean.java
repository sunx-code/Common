package com.sunx.common.solr;

import org.apache.solr.client.solrj.beans.Field;

public class SolrBean {
	@Field
	private String id;
	@Field
	private String url;
	@Field
	private String title;
	@Field
	private String text;
	@Field
	private String host;
	@Field
	private String author;
	@Field
	private String sector;
	@Field
	private String time;
	@Field
	private String timeIndex;
	@Field
	private String md5;
	@Field
	private int zhuanzai;
	@Field
	private int replyNum;
	@Field
	private int dianjilv;
	@Field
	private int type;
	@Field
	private int RFflag;
	@Field
	private String mappath_s;
	@Field
	private String address_s;
	@Field
	private long posttime;
	@Field
	private int language_i;
	@Field
	private int contenttype_i;
	@Field
	private int boardDeep_s;
	@Field
	private String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTimeIndex() {
		return timeIndex;
	}
	public void setTimeIndex(String timeIndex) {
		this.timeIndex = timeIndex;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public int getZhuanzai() {
		return zhuanzai;
	}
	public void setZhuanzai(int zhuanzai) {
		this.zhuanzai = zhuanzai;
	}
	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public int getDianjilv() {
		return dianjilv;
	}
	public void setDianjilv(int dianjilv) {
		this.dianjilv = dianjilv;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getRFflag() {
		return RFflag;
	}
	public void setRFflag(int rFflag) {
		RFflag = rFflag;
	}
	public String getMappath_s() {
		return mappath_s;
	}
	public void setMappath_s(String mappath_s) {
		this.mappath_s = mappath_s;
	}
	public String getAddress_s() {
		return address_s;
	}
	public void setAddress_s(String address_s) {
		this.address_s = address_s;
	}
	public long getPosttime() {
		return posttime;
	}
	public void setPosttime(long posttime) {
		this.posttime = posttime;
	}
	public int getLanguage_i() {
		return language_i;
	}
	public void setLanguage_i(int language_i) {
		this.language_i = language_i;
	}
	public int getContenttype_i() {
		return contenttype_i;
	}
	public void setContenttype_i(int contenttype_i) {
		this.contenttype_i = contenttype_i;
	}
	public int getBoardDeep_s() {
		return boardDeep_s;
	}
	public void setBoardDeep_s(int boardDeep_s) {
		this.boardDeep_s = boardDeep_s;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
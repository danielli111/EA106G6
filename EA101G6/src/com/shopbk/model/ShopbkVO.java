package com.shopbk.model;

import java.sql.Timestamp;

public class ShopbkVO implements java.io.Serializable{
	private String shopbkno;
	private String shopno;
	private Integer ofdtable;
	private String shoppds;
	private String shoppde;
	private Integer payinfohr;
	private Integer payinfoday;
	public String getShopbkno() {
		return shopbkno;
	}
	public void setShopbkno(String shopbkno) {
		this.shopbkno = shopbkno;
	}
	public String getShopno() {
		return shopno;
	}
	public void setShopno(String shopno) {
		this.shopno = shopno;
	}
	public Integer getOfdtable() {
		return ofdtable;
	}
	public void setOfdtable(Integer ofdtable) {
		this.ofdtable = ofdtable;
	}
	public String getShoppds() {
		return shoppds;
	}
	public void setShoppds(String shoppds) {
		this.shoppds = shoppds;
	}
	public String getShoppde() {
		return shoppde;
	}
	public void setShoppde(String shoppde) {
		this.shoppde = shoppde;
	}
	public Integer getPayinfohr() {
		return payinfohr;
	}
	public void setPayinfohr(Integer payinfohr) {
		this.payinfohr = payinfohr;
	}
	public Integer getPayinfoday() {
		return payinfoday;
	}
	public void setPayinfoday(Integer payinfoday) {
		this.payinfoday = payinfoday;
	}
	
}

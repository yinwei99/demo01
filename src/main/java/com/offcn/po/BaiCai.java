package com.offcn.po;

import java.util.Date;

import com.mysql.fabric.xmlrpc.base.Data;

public class BaiCai {
	
	private String name;
	private float minprice;
	private float averageprice;
	private float maxprice;
	private Date  releasedate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMinprice() {
		return minprice;
	}
	public void setMinprice(float minprice) {
		this.minprice = minprice;
	}
	public float getAverageprice() {
		return averageprice;
	}
	public void setAverageprice(float averageprice) {
		this.averageprice = averageprice;
	}
	public float getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(float maxprice) {
		this.maxprice = maxprice;
	}
	public Date getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	@Override
	public String toString() {
		return "BaiCai [name=" + name + ", minprice=" + minprice + ", averageprice=" + averageprice + ", maxprice="
				+ maxprice + ", releasedate=" + releasedate + "]";
	}
	

}

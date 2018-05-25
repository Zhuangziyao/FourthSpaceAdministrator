package com.fourth.bean;

import java.util.Date;

public class Good {
	private Long id;
	private String name;
	private String information;
	private String tags;
	private String price;
	private String supplier;
	private String server;
	private String contactWay;
	private Date groundDate;
	private Integer backDeadLine;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getContactWay() {
		return contactWay;
	}
	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}
	public Date getGroundDate() {
		return groundDate;
	}
	public void setGroundDate(Date groundDate) {
		this.groundDate = groundDate;
	}
	public Integer getBackDeadLine() {
		return backDeadLine;
	}
	public void setBackDeadLine(Integer backDeadLine) {
		this.backDeadLine = backDeadLine;
	}
	
	
}

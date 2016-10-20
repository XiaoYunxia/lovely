package com.newer.login.bean;

public class Area {
	private int tb_areaID;
	private String areaName;
	private int areaPid;
	
	
	public int getTb_areaID() {
		return tb_areaID;
	}
	public void setTb_areaID(int tb_areaID) {
		this.tb_areaID = tb_areaID;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public int getAreaPid() {
		return areaPid;
	}
	public void setAreaPid(int areaPid) {
		this.areaPid = areaPid;
	}
	@Override
	public String toString() {
		return "Area [tb_areaID=" + tb_areaID + ", areaName=" + areaName
				+ ", areaPid=" + areaPid + "]";
	}
	
	
	
}

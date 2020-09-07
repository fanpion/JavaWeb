package com.huixingtao.pojo;

public class Order {
	private int oID;
	private String shoppingerId;
	private String pname;
	private String oTime;
	private int oQuality;
	private double oSum;
	private String oSend;
	public int getoID() {
		return oID;
	}
	public int getoQuality() {
		return oQuality;
	}
	public void setoQuality(int oQuality) {
		this.oQuality = oQuality;
	}
	public double getoSum() {
		return oSum;
	}
	public void setoSum(double oSum) {
		this.oSum = oSum;
	}
	public void setoID(int oID) {
		this.oID = oID;
	}
	public String getShoppingerId() {
		return shoppingerId;
	}
	public void setShoppingerId(String shoppingerId) {
		this.shoppingerId = shoppingerId;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getoTime() {
		return oTime;
	}
	public void setoTime(String oTime) {
		this.oTime = oTime;
	}
	public String getoSend() {
		return oSend;
	}
	public void setoSend(String oSend) {
		this.oSend = oSend;
	}
	@Override
	public String toString() {
		return "Order [oID=" + oID + ", shoppingerId=" + shoppingerId + ", pname=" + pname + ", oTime=" + oTime
				+ ", oSend=" + oSend + "]";
	}
}

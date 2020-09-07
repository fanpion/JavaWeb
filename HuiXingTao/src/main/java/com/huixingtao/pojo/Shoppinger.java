package com.huixingtao.pojo;

public class Shoppinger {
	private String shoppingerID;
	private String shoppingerPassword;
	private String shoppingerName;
	private String shoppingerPicture;
	private String lv;
	

	public String getLv() {
		return lv;
	}

	public void setLv(String lv) {
		this.lv = lv;
	}

	public Shoppinger() {
	}

	public Shoppinger(String shoppingerID, String shoppingerPassword, String shoppingerName, String shoppingerPicture) {
		this.shoppingerID = shoppingerID;
		this.shoppingerPassword = shoppingerPassword;
		this.shoppingerName = shoppingerName;
		this.shoppingerPicture = shoppingerPicture;
	}

	public String getShoppingerPicture() {
		return shoppingerPicture;
	}

	public void setShoppingerPicture(String shoppingerPicture) {
		this.shoppingerPicture = shoppingerPicture;
	}

	public String getShoppingerID() {
		return shoppingerID;
	}

	public void setShoppingerID(String shoppingerID) {
		this.shoppingerID = shoppingerID;
	}

	public String getShoppingerPassword() {
		return shoppingerPassword;
	}

	public void setShoppingerPassword(String shoppingerPassword) {
		this.shoppingerPassword = shoppingerPassword;
	}

	public String getShoppingerName() {
		return shoppingerName;
	}

	public void setShoppingerName(String shoppingerName) {
		this.shoppingerName = shoppingerName;
	}

	@Override
	public String toString() {
		return "Shoppinger [shoppingerID=" + shoppingerID + ", shoppingerPassword=" + shoppingerPassword
				+ ", shoppingerName=" + shoppingerName + "]";
	}
}

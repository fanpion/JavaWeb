package com.huixingtao.pojo;

public class Notice {
	private int noticeNumber;
	private String noticeTheme;
	private String noticeDetail;
	private String noticeDate;
	public int getNoticeNumber() {
		return noticeNumber;
	}
	public void setNoticeNumber(int noticeNumber) {
		this.noticeNumber = noticeNumber;
	}
	public String getNoticeTheme() {
		return noticeTheme;
	}
	public void setNoticeTheme(String noticeTheme) {
		this.noticeTheme = noticeTheme;
	}
	public String getNoticeDetail() {
		return noticeDetail;
	}
	public void setNoticeDetail(String noticeDetail) {
		this.noticeDetail = noticeDetail;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	public Notice(int noticeNumber, String noticeTheme, String noticeDetail, String noticeDate) {
		this.noticeNumber = noticeNumber;
		this.noticeTheme = noticeTheme;
		this.noticeDetail = noticeDetail;
		this.noticeDate = noticeDate;
	}
	public Notice() {
	}
	@Override
	public String toString() {
		return "Notice [noticeNumber=" + noticeNumber + ", noticeTheme=" + noticeTheme + ", noticeDetail="
				+ noticeDetail + ", noticeDate=" + noticeDate + "]";
	}

	
	
}

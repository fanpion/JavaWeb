package com.huixingtao.service;

import java.util.List;

import com.huixingtao.pojo.Notice;

public interface NoticeService {
	List<Notice> getList();
	void delete(int noticeNumber);
	void modify(int noticeNumber,String noticeTheme,String noticeDetail,String noticeDate);
	void add(int noticeNumber,String noticeTheme,String noticeDetail,String noticeDate);
	Notice get(int noticeNumber);
}

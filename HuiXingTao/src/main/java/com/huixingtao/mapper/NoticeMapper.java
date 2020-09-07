package com.huixingtao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huixingtao.pojo.Notice;

public interface NoticeMapper {
	List<Notice> getList();
	void delete(int noticeNumber);
	void modify(@Param("noticeNumber")int noticeNumber,@Param("noticeTheme")String noticeTheme,@Param("noticeDetail")String noticeDetail,@Param("noticeDate")String noticeDate);
	void add(@Param("noticeNumber")int noticeNumber,@Param("noticeTheme")String noticeTheme,@Param("noticeDetail")String noticeDetail,@Param("noticeDate")String noticeDate);
	Notice get(int noticeNumber);
}

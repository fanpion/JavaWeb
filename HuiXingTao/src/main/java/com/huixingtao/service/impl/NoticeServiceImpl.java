package com.huixingtao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huixingtao.mapper.NoticeMapper;
import com.huixingtao.pojo.Notice;
import com.huixingtao.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	NoticeMapper noticemapper;
	
	@Override
	public List<Notice> getList() {
		return noticemapper.getList();
	}

	@Override
	public void delete(int number) {
		noticemapper.delete(number);
	}

	@Override
	public void modify(int number, String theme, String detail, String date) {
		noticemapper.modify(number, theme, detail, date);
	}

	@Override
	public void add(int number, String thme, String detail, String date) {
		noticemapper.add(number, thme, detail, date);
	}

	@Override
	public Notice get(int number) {
		return noticemapper.get(number);
	}
	
}

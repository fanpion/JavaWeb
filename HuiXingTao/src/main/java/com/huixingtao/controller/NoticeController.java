package com.huixingtao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.huixingtao.pojo.Notice;
import com.huixingtao.service.NoticeService;

@Controller
@RequestMapping("")
public class NoticeController {
	@Autowired
	NoticeService noticeService;

	@RequestMapping(value = "noticeManage")
	public ModelAndView noticeManage(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		view.setViewName("notice");
		getNotice(request);
		return view;
	}

	@RequestMapping(value = "addNotice", method = RequestMethod.GET)
	public ModelAndView addnotice(HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		view.setViewName("addNotice");
		return view;
	}

	@RequestMapping(value = "addNotice", method = RequestMethod.POST)
	public void addNotice(HttpServletRequest request,String noticeNumber,String noticeTheme,String noticeDetail, String noticeDate) {
		noticeService.add(Integer.parseInt(noticeNumber), noticeTheme, noticeDetail, noticeDate);
		noticeManage(request);
	}
	
	@RequestMapping("viewNotice")
	public ModelAndView viewNotice(String noticeNumber) {
		ModelAndView view = new ModelAndView();
		if (noticeNumber.equals("")) {
			view.setViewName("notice");
		} else {
			Notice notice = noticeService.get(Integer.parseInt(noticeNumber));
			view.addObject("notice", notice);
			view.setViewName("viewNotice");
		}
		return view;
	}

	@RequestMapping(value = "getNotice")
	public void getNotice(HttpServletRequest request) {
		List<Notice> list = noticeService.getList();
		request.getSession().setAttribute("noticeList", list);
	}

	@RequestMapping("modifyNotice")
	public ModelAndView modifyNotice(String noticeNumber, String noticeTheme, String noticeDetail, String noticeDate) {
		ModelAndView view = new ModelAndView();
		view.setViewName("viewNotice");
		noticeService.modify(Integer.parseInt(noticeNumber), noticeTheme, noticeDetail, noticeDate);
		return view;
	}

	@RequestMapping("deleteNotice")
	public ModelAndView deleteNotice(String noticeNumber) {
		ModelAndView view = new ModelAndView();
		view.setViewName("viewNotice");
		noticeService.delete(Integer.parseInt(noticeNumber));
		return view;
	}
}

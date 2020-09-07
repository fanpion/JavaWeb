package com.huixingtao.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.huixingtao.pojo.Shoppinger;
import com.huixingtao.service.ShoppingerService;

@Controller
@RequestMapping("")
public class InfoController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	ShoppingerService shoppingerService;

	@RequestMapping(value = "info")
	public ModelAndView Info() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("info");
		return modelAndView;
	}

	@RequestMapping(value = "uploadPicture")
	public ModelAndView uploadPicture(@RequestParam("fileName") CommonsMultipartFile file, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("info");
		// 获得原始文件名
		String fileName = file.getOriginalFilename();
		// 获得项目的路径
		String path = request.getServletContext().getRealPath("/");
		// 上传位置
		path += "/img/";
		File f = new File(path);
		if (!f.exists())
			f.mkdirs();
		if (!file.isEmpty()) {
			try {
				FileOutputStream fos = new FileOutputStream(path + fileName);
				shoppingerService.setPicture("/HuiXingTao/img/" + fileName,
						((Shoppinger) request.getSession().getAttribute("shoppinger")).getShoppingerID());
				InputStream in = file.getInputStream();
				int b = 0;
				while ((b = in.read()) != -1) {
					fos.write(b);
				}
				fos.close();
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			Shoppinger shoppinger = shoppingerService
					.get(((Shoppinger) (request.getSession().getAttribute("shoppinger"))).getShoppingerID());
			request.getSession().setAttribute("shoppinger", shoppinger);
			request.getRequestDispatcher("info").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;

	}

	@RequestMapping("download")
	public void download(HttpServletRequest request, HttpServletResponse response) {
		File file = new File(((Shoppinger) request.getSession().getAttribute("shoppinger")).getShoppingerPicture());
		
		File file2 = new File("where are you");
		System.out.println(file2.getAbsoluteFile());
		
		if (!file2.exists()) {
			System.out.println("beichaungjianle");
			file2.mkdirs();
		}
		
		if (file.exists()) {
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment;filename=MyPicture.jpg");
			byte[] buffer = new byte[1024];
			FileInputStream fis = null;
			BufferedInputStream bis = null;

			try {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);

				ServletOutputStream os = response.getOutputStream();
				int i = bis.read(buffer);

				while (i != -1) {
					os.write(buffer, 0, i);
					i = bis.read(buffer);
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (bis != null) {
						bis.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				try {
					if (fis != null) {
						fis.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		}

	}

}

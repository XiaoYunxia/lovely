package com.newer.login.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;


import com.newer.login.service.UserService;

public class RepeatServlet extends HttpServlet {

	private static final long serialVersionUID = -2358013000602548064L;
	UserService userService=new UserService();
	DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type=request.getParameter("type");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		if("chkuser".equals(type)){
			//检查用户名是否存在
			String username=request.getParameter("username");
			//调用服务类，完成用户名、密码的校验
			boolean u=userService.chkRepeat(username);
			//ajax响应
			if(u==true){
				//用户名不存在，可用
				out.print(0);
			}else{
				//用户名已存在
				out.print(1);
			}
			out.close();
			
			
			
		}else if("form".equals(type)){
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String[] values=request.getParameterValues("fav");
			String birthday=request.getParameter("birthday");

			
			Date date1;
			String date=null;
			try {
				date1 = df.parse(birthday);
				//date=date1.toString();
				date=df.format(date1);
			} catch (ParseException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

				//以json格式范回
				JSONObject jsonObj=new JSONObject();
				jsonObj.put("username", username);
				jsonObj.put("password", password);
				jsonObj.put("fav", values);
				jsonObj.put("birthday", date);
				//响应
				out.print(jsonObj);
				out.close();
			}
			
			
		

	}

}

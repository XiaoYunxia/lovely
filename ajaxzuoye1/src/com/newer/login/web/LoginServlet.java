package com.newer.login.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newer.login.bean.User;
import com.newer.login.service.UserService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	UserService userService=new UserService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		//2.封装user对象
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		
		//3.调用服务类，完成用户名、密码的校验
		boolean u=userService.login(user);
		
		//ajax响应
		PrintWriter out=response.getWriter();
		
		if(u==true){
			//表示登录成功
			out.print(0);
		}else{
			//登录失败
			out.print(1);
		}
		out.close();
	}

}

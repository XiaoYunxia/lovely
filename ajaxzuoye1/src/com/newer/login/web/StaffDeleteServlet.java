package com.newer.login.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newer.login.service.StaffService;

public class StaffDeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	StaffService service=new StaffService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("id"));
		
		//ajax响应
		PrintWriter out=response.getWriter();
		boolean json=service.delete(id);
		out.print(json);
		out.close();
	}

}

package com.newer.login.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newer.login.bean.Staff;
import com.newer.login.service.StaffService;

public class StaffGetAllServlet extends HttpServlet {


	private static final long serialVersionUID = -4208381004605009416L;
	StaffService service=new StaffService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Staff> list=service.getAll();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/hr.jsp").forward(request, response);
	}

}

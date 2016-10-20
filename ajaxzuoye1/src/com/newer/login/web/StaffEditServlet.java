package com.newer.login.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newer.login.bean.Staff;
import com.newer.login.service.StaffService;

public class StaffEditServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6896054645963070473L;
	StaffService service=new StaffService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String job=request.getParameter("job");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		
		Staff s=new Staff();
		s.setId(id);
		s.setName(name);
		s.setJob(job);
		s.setPhone(phone);
		s.setEmail(email);
		
		service.update(s);
		
		request.getRequestDispatcher("GetAll").forward(request, response);
		
	}

}

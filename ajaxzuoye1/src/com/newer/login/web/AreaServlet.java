package com.newer.login.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

import com.newer.login.bean.Area;
import com.newer.login.service.AreaService;

public class AreaServlet extends HttpServlet {


	private static final long serialVersionUID = -377251562620772798L;
	AreaService service=new AreaService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取省级的pid
        int i = Integer.valueOf(request.getParameter("pid"));
        //查询数据库数据
        List<Area> list = service.getbyArea(i);
        JSONArray jsonArr=JSONArray.fromObject(list);
		
        PrintWriter out=response.getWriter();
        out.print(jsonArr);
       
        out.close();
       

	}

}

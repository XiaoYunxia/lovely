package com.newer.login.service;

import java.util.List;

import com.newer.login.bean.Area;
import com.newer.login.dao.AreaDao;

public class AreaService {
	
	AreaDao areaDao=new AreaDao();
	
	public List<Area> getbyArea(int pid){
		return areaDao.getbyArea(pid);
	}
}

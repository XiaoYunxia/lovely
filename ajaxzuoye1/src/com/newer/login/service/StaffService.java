package com.newer.login.service;

import java.util.ArrayList;


import com.newer.login.bean.Staff;
import com.newer.login.dao.StaffDao;

public class StaffService {
	
	StaffDao staffDao=new StaffDao();
	public boolean add(Staff s){
		return staffDao.add(s);
	}
	
	/*
	 * 遍历得到通讯录的list
	 */
	public ArrayList<Staff> getAll(){
		return staffDao.getAll();
	}
	/*
	 * 通过id查找到联系人
	 */
	public Staff getById(int i){
		return staffDao.getById(i);
	}
	
	/*
	 * 更新某个联系人的内容
	 */
	public boolean update(Staff s){
		return staffDao.update(s);
	}
	
	/*
	 * 删除
	 */
	public boolean delete(int id){
		return staffDao.delete(id);
	}
}

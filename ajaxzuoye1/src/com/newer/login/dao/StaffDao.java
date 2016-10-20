package com.newer.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.newer.login.bean.Staff;

import util.DBUtil;


public class StaffDao {
	/*
	 *增加一个职员
	 */
	public boolean add(Staff s){
		boolean flag=false;
		String sql="insert into staff values(?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, s.getId());
			pst.setString(2, s.getName());
			pst.setString(3, s.getPhone());
			pst.setString(4, s.getEmail());
			pst.setString(5, s.getJob());
			
			int rows=pst.executeUpdate();
			if(rows>0){
				flag=true;
			}
		} catch (Exception e1) {
			// TODO: handle exception
		}finally{
			DBUtil.closeAll(conn, pst, null);
		}
		return flag;
	}
	
	/*
	 * 遍历得到通讯录的list
	 */
	public ArrayList<Staff> getAll(){
		ArrayList<Staff> list=new ArrayList<Staff>();
		String sql="select * from staff";
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
		
			rs=pst.executeQuery();
			while(rs.next()){
				Staff s=new Staff();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setPhone(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setJob(rs.getString(5));
				list.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			DBUtil.closeAll(conn, pst, rs);
		}
		return list;
		
	}
	/*
	 * 通过id查找到联系人
	 */
	public Staff getById(int i){
		String sql="select * from staff where id=?";
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Staff s=new Staff();
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, i);
			rs=pst.executeQuery();
			while(rs.next()){
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setPhone(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setJob(rs.getString(5));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			DBUtil.closeAll(conn, pst, rs);
		}
		return s;
	}
	
	/*
	 * 更新某个联系人的内容
	 */
	public boolean update(Staff s){
		boolean flag=false;
		String sql="update staff set phone=?,email=?,job=? where id=?";
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, s.getPhone());
			pst.setString(2, s.getEmail());
			pst.setString(3, s.getJob());
			pst.setInt(4, s.getId());

			int rows=pst.executeUpdate();
			if(rows>0){
				flag=true;
			}
		} catch (Exception e1) {
			// TODO: handle exception
		}finally{
			DBUtil.closeAll(conn, pst, null);
		}
		return flag;
	}
	
	/*
	 * 删除
	 */
	public boolean delete(int id){
		boolean flag=false;
		String sql="delete from staff where id=?";
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);

			int rows=pst.executeUpdate();
			if(rows>0){
				flag=true;
			}
		} catch (Exception e1) {
			// TODO: handle exception
		}finally{
			DBUtil.closeAll(conn, pst, null);
		}
		return flag;
	}
	
}

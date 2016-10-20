package com.newer.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

import com.newer.login.bean.User;

/*
 * DAO层
 * 与数据库打交道，实现数据库中数据的增删改查
 */
public class LoginDao {


	/**
	 * 验证用户名、密码是否正确
	 * 验证通过返回true
	 */
	public boolean chkUser(User user) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from logininfo where username=? and pwd=?";
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			rs=pst.executeQuery();
			if(rs.next()){
				flag=true;
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(conn, pst, rs);
		}
		return flag;
	}
	

	/*
	 * 检查用户名是否重复，重复返回false，不重复true
	 */
	public boolean chkRepeat(String username) {
		boolean flag=true;
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		//select *效率是最低的，可以用select count(1)效率高。
		String sql="select * from logininfo where username=?";
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, username);
			rs=pst.executeQuery();
			if(rs.next()){
				flag=false;//用户名重复
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(conn, pst, rs);
		}
		return flag;

	}
	
	
	
	
}

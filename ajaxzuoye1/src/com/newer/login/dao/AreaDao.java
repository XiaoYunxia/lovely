package com.newer.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import com.newer.login.bean.Area;

public class AreaDao {
	
	public List<Area> getbyArea(int pid){
		List<Area> list=new ArrayList<Area>();
		String sql="select * from area where areapid=?";
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=DBUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, pid);
			rs=pst.executeQuery();
			while(rs.next()){
				Area area=new Area();
				area.setTb_areaID(rs.getInt(1));
				area.setAreaName(rs.getString(2));
				area.setAreaPid(rs.getInt(3));
				list.add(area);
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(conn, pst, rs);
		}
		return list;
		
	}
}

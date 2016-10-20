package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private final static String DRIVER="oracle.jdbc.OracleDriver";
	private final static String URL="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private final static String USERNAME="scott";
	private final static String PWD="tiger";
	/*
	 * 加载驱动
	 */
	static{
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	/*
	 * 返回数据库连接
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(URL,USERNAME,PWD);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return conn;
		
	}
	/*
	 * 关闭数据库对象
	 */
	public static void closeAll(Connection conn,Statement st,ResultSet rs){
		
		try {
			if(rs!=null){
				rs.close();
			}
			if(st!=null){
				st.close();
			}if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


}

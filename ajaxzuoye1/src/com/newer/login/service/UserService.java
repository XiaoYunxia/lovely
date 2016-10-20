package com.newer.login.service;

import com.newer.login.bean.User;
import com.newer.login.dao.LoginDao;

/*
 * 用户服务类
 */
public class UserService {
	LoginDao logindao=new LoginDao();
/*
 * 登录
 */
	public boolean login(User user){
		return logindao.chkUser(user);
	}
	
	/*
	 * 检查用户名重复
	 */
	public boolean chkRepeat(String username){
		return logindao.chkRepeat(username);
	}
	

}

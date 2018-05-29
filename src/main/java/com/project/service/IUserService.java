package com.project.service;

import com.project.pojo.TUser;

public interface IUserService {
	
	/**
	 * 根据用户名查询用户
	 * @param userName
	 */
	public TUser findUserByName(String userName);
	
	
	/**
	 * 登陆
	 * @param userName 用户名
	 * @param password 密码
	 * @return 失败返回NULL
	 */
	public TUser login(String userName,String password);
}

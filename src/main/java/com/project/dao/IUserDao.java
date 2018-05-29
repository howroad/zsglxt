package com.project.dao;

import com.project.pojo.TUser;

public interface IUserDao extends IBasicDao<TUser, String>{

	/**
	 * 登陆
	 * @param userName 用户名
	 * @param password 密码
	 * @return 失败返回NULL
	 */
	public TUser login(String userName,String password);
}

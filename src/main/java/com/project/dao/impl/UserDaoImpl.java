package com.project.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.dao.IUserDao;
import com.project.pojo.TUser;

@Repository("userDao")
public class UserDaoImpl extends BasicDaoAdapter<TUser, String> implements IUserDao{
	
	@Override
	public TUser login(String userName, String password) {
		String hql = "select u from TUser u where u.userName = ? and u.userPassword = ?";
		return findEntityByHQL(hql, userName,password);
	}
}

package com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IUserDao;
import com.project.pojo.TUser;
import com.project.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao userDao;
	@Override
	public TUser findUserByName(String userName) {
		String hql = "select u from TUser u where userName=?";
		return userDao.findEntityByHQL(hql, userName);
	}
	
	@Override
	public TUser login(String userName, String password) {
		return userDao.login(userName, password);
	}

}

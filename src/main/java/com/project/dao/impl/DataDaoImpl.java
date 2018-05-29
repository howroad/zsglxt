package com.project.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.dao.IDataDao;

import com.project.pojo.TData;

@Repository("dataDao")
public class DataDaoImpl extends BasicDaoAdapter<TData, String> implements IDataDao{
	
	
}

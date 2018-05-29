package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IDataDao;
import com.project.pojo.TData;
import com.project.service.IDataService;
@Service("dataService")
public class DataServiceImpl implements IDataService {
	@Autowired
	private IDataDao dataDao;
	@Override
	public List<TData> findAllData(String type) {
		
		String hql = "from TData d where d.dataType=?";
		
		 List<TData> list= dataDao.listByHQL(hql, type);
		 return list;
	}

}

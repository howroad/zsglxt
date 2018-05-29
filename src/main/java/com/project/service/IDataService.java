package com.project.service;

import java.util.List;

import com.project.pojo.TData;

public interface IDataService {
	
	/**
	 * 查询所有的区域
	 * @return 区域集合
	 */
	public List<TData> findAllData(String type);
	
}

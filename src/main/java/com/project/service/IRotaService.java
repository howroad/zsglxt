package com.project.service;

import com.project.pojo.TRota;
import com.project.util.PageBean;

/**
 * 值班日志service接口
 * @author Administrator
 *
 */
public interface IRotaService {
	
	/**
	 * 添加值班日志
	 * @param rota	要添加的值班日志实体
	 */
	public boolean addRota(TRota rota);
	
	/**
	 * 查询所有值班日志
	 * @param pageNo 页码
	 * @param pageSize	条数
	 * @return 分页实体
	 */
	public PageBean<TRota> findAllRota(int pageNo,int pageSize);
	/**
	 * 根据条件查找所有值班日志
	 * @param pageNo	页码
	 * @param pageSize	条数
	 * @param objs 条件数组
	 * @return  查询结果集合
	 */
	public PageBean<TRota> findRotaBySome(int pageNo,int pageSize,Object...objs);
}

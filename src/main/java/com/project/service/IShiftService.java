package com.project.service;

import com.project.pojo.TShift;
import com.project.util.PageBean;

/**
 * 交接班service层接口
 * @author Administrator
 *
 */
public interface IShiftService {
	
	/**
	 * 查询所有交接班记录并分页
	 * @param pageNo 页码数
	 * @param pageSize	展示条数
	 * @return
	 */
	public PageBean<TShift> findAllShift(int pageNo,int pageSize);
	
	/**
	 * 根据条件查询交接班记录
	 * @param pageNo 页码数
	 * @param pageSize	展示条数
	 * @param objs 查询条件数组
	 * @return
	 */
	public PageBean<TShift> findShiftBySome(int pageNo,int pageSize,Object...objs);
	
	/**
	 * 添加交接班日志
	 * @param shift 要添加的交接班日志
	 */
	public void addShift(TShift shift);
}

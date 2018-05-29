package com.project.service;

import com.project.pojo.TReport;
import com.project.util.PageBean;

public interface IReportService {
	/**
	 * 添加事件
	 * @param report
	 * @return 返回一个boolean
	 */
	public boolean addReport(TReport report);
	/**
	 * 查询所有并分页
	 * @param page 第几页
	 * @param size 每页显示的条数
	 * @return 事件pagebean
	 */
	public PageBean<TReport> findAllReport(int page,int size);
	
	
	/**
	 * 根据ID查询事件
	 * @param id 事件ID
	 * @return 返回一个事件实体
	 */
	public TReport findTReportById(String id);
	/**
	 * 修改事件
	 * @param report 事件实体
	 * @return 返回一个boolean
	 */
	public boolean updateTReport(TReport report);
	
	/**
	 * 删除事件
	 * @param report 事件实体
	 * @return 返回一个boolean
	 */
	public boolean delTReport(TReport report);
	
	/**
	 * 根据用户id查询事件分页
	 * @param userId 用户id
	 * @param page 第几页
	 * @param size 每页显示的条数
	 * @return 事件pagebean
	 */
	
	public PageBean<TReport> getAllReportByUserId(String userId,int page,int size);
	
	/**
	 * 
	 * @param page 第几页
	 * @param size 每页显示的条数
	 * @param objs 查询参数
	 * @return 事件的pagebean
	 */
	public PageBean<TReport> findReportBySome(int page,int size,Object...objs);
	
	/**
	 * 根据用户id和条件 查询 事件分页
	 * @param page 第几页
	 * @param size 每页显示的条数
	 * @param objs 查询参数
	 * @return 事件的pagebean
	 */
	
	public PageBean findMyReportBySome(int page,int size,String userId ,Object...objs);
	
}
package com.project.service;

import java.util.List;

import com.project.pojo.TResubmit;
import com.project.util.PageBean;

public interface IResubmitService {
	/**
	 * 添加续报
	 * @param resubmit 续报实体
	 */
	public boolean addResubmit(TResubmit resubmit);
	/**
	 * 根据事件id查询续报事件
	 * @param TReportId 事件id
	 * @return 续报集合
	 */
	public List<TResubmit> findAllResubmitByReportId(String TReportId);

	/**
	 * 根据用户id查询续报
	 * @param userId 用户id
	 * @return 续报pagebean
	 */
	public PageBean<TResubmit> getAllResubitByUserId(String userId,int page,int size);

}

package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dao.IResubmitDao;
import com.project.pojo.TResubmit;
import com.project.service.IResubmitService;
import com.project.util.MessageBean;
import com.project.util.PageBean;
import com.project.util.Producer;
import com.project.vo.ResubmitVO;
@Service("resubmitService")
public class ResubmitServiceImpl implements IResubmitService{
	 @Autowired
	private Producer producer;
	@Autowired
	private IResubmitDao resubmitDao;
	@Override
	public boolean addResubmit(TResubmit resubmit) {
		boolean boo = false;
		try {
			ResubmitVO  rsvo= new ResubmitVO();
			rsvo.setRCode(resubmit.getTReport().getRCode());
			rsvo.setRsArea(resubmit.getRsArea());
			rsvo.setRsDate(resubmit.getRsDate());
			rsvo.setRsDesc(resubmit.getRsDesc());
			rsvo.setRsNum(resubmit.getRsNum());
			rsvo.setUserName(resubmit.getTUser().getUserRname());
			rsvo.setUserTel(resubmit.getTUser().getUserTel());
			rsvo.setRsGrade(resubmit.getRsType());
			MessageBean mb = new MessageBean("2", rsvo);
			ObjectMapper obj = new ObjectMapper();
			
			String mapJakcson = obj.writeValueAsString(mb);
			producer.sendMsgQueue(mapJakcson);
			resubmitDao.add(resubmit);
			boo = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return boo;
	}

	@Override
	public List<TResubmit> findAllResubmitByReportId(String TReportId) {
		// TODO Auto-generated method stub
		String hql = "from TResubmit t where t.TReport.id =?";
		
		return resubmitDao.listByHQL(hql, TReportId);
	}

	@Override
	public PageBean<TResubmit> getAllResubitByUserId(String userId,int page,int size) {
		
		String hql = "from TResubmit t where t.TUser.id=? ";
		String countHql = "select count(*) from TResubmit t where t.TUser.id=?";
	return	resubmitDao.findEntityBySome(hql, countHql, page, size, userId);
		
	}

}

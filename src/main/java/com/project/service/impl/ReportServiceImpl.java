package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dao.IReportDao;
import com.project.pojo.TReport;
import com.project.service.IReportService;
import com.project.util.MessageBean;
import com.project.util.PageBean;
import com.project.util.Producer;
import com.project.vo.ReportVO;

@Service("reportService")
public class ReportServiceImpl implements IReportService {
	
  
	@Autowired
	private IReportDao reportDao;
	@Override
	public boolean addReport(TReport report) {
		
	
		
		return 	reportDao.add(report)==null?false:true;
	}

	@Override
	public PageBean<TReport> findAllReport(int page, int size) {
			String hql = "from TReport t order by t.RDate desc";
			String countHql = "select count(*) from TReport";
		return reportDao.findAllPage(hql, countHql, page, size);
	}

	@Override
	public TReport findTReportById(String id) {
		
		return reportDao.findById(id);
	}

	@Override
	public boolean updateTReport(TReport report)  {
		
	
		return reportDao.update(report);
	}

	@Override
	public boolean delTReport(TReport report) {
		
		return reportDao.delete(report);
	}

	@Override
	public PageBean<TReport> getAllReportByUserId(String userId, int page, int size) {
			
			String hql = " from TReport t where t.TUser.id=? order by t.RDate desc";
			String countHql = "select count(*) from TReport t where t.TUser.id=?";
			
			
		return reportDao.findEntityBySome(hql, countHql, page, size, userId);
	}

	@Override
	public PageBean<TReport> findReportBySome(int page,int size,Object...objs) {
			
		String hql = "from TReport t where 1=1";
		String countHql = "select count(*) from TReport t where 1=1";
		
		
		
		if(!"".equals(objs[0]) && null!=objs[0]) {
			hql+=" and t.RName like ?";
			countHql+=" and t.RName like ?";
		}
		if(!"".equals(objs[1]) && null!=objs[1]) {
			hql+=" and t.RType = ?";
			countHql+=" and t.RType = ?";
		}
		if(!"".equals(objs[2]) && null!=objs[2]) {
			hql+=" and t.RGrade = ?";
			countHql+=" and t.RGrade = ?";
		}
		if(!"".equals(objs[3]) && null!=objs[3]) {
			hql+=" and t.RStatus = ?";
			countHql+=" and t.RStatus = ?";
		}
		
		if(!"".equals(objs[4]) && null!=objs[4]) {
			hql+=" and t.RDate > ?";
			countHql+=" and t.RDate > ?";
		}
		if(!"".equals(objs[5]) && null!=objs[5]) {
			hql+=" and t.RDate < ?";
			countHql+=" and t.RDate < ?";
		}
		
		hql+= " order by t.RCode desc";
		
		List<String> list = new ArrayList<String>();
		for(int i=0;i<objs.length;i++) {
			if(!"".equals(objs[i]) && null!=objs[i]) {
				list.add(objs[i].toString());
			} 
		}
		System.out.println(hql);
		return reportDao.findEntityBySome(hql, countHql, page, size, list.toArray());
	}

	
	public PageBean<TReport> findMyReportBySome(int page,int size,String userId ,Object...objs) {
		
		
         if("".equals(userId) || null==userId) {
			return null;
		}
		String hql = "from TReport t where t.TUser.userId=?";
		
		String countHql = "select count(*) from TReport t where t.TUser.userId=?";
		
		if(!"".equals(objs[0]) && null!=objs[0]) {
			hql+=" and t.RName like ?";
			countHql+=" and t.RName like ?";
		}
		if(!"".equals(objs[1]) && null!=objs[1]) {
			hql+=" and t.RType = ?";
			countHql+=" and t.RType = ?";
		}
		if(!"".equals(objs[2]) && null!=objs[2]) {
			hql+=" and t.RGrade = ?";
			countHql+=" and t.RGrade = ?";
		}
		if(!"".equals(objs[3]) && null!=objs[3]) {
			hql+=" and t.RStatus = ?";
			countHql+=" and t.RStatus = ?";
		}
		
		if(!"".equals(objs[4]) && null!=objs[4]) {
			hql+=" and t.RDate < ?";
			countHql+=" and t.RDate < ?";
		}
		if(!"".equals(objs[5]) && null!=objs[5]) {
			hql+=" and t.RDate > ?";
			countHql+=" and t.RDate > ?";
		}
		
		List<String> list = new ArrayList<String>();
		list.add(userId);
		
		for(int i=0;i<objs.length;i++) {
			if(!"".equals(objs[i]) && null!=objs[i]) {
				list.add(objs[i].toString());
			} 
		}
		
		
		return reportDao.findEntityBySome(hql, countHql, page, size, list.toArray());
			
		
	}

	
	
	
	
	
	
	
	
}

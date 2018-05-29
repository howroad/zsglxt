package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IShiftDao;
import com.project.pojo.TShift;
import com.project.service.IShiftService;
import com.project.util.PageBean;

@Service("shiftService")
public class ShiftServiceImpl implements IShiftService{
	
	@Autowired
	private IShiftDao shiftDao;
	@Override
	public PageBean<TShift> findAllShift(int pageNo, int pageSize) {
		String hql = "select s from TShift s left join fetch s.TUser u order by s.SEndtime desc";
		String countHql = "select count(*) from TShift s left join s.TUser u ";
		return shiftDao.findAllPage(hql,countHql,pageNo, pageSize);
	}

	@Override
	public PageBean<TShift> findShiftBySome(int pageNo, int pageSize, Object...objs) {
		String hql = "select s from TShift s left join fetch s.TUser u where 1=1 ";
		if(!"".equals(objs[0])&&null!=(objs[0])) {
			hql += " and u.userRname like ? "; 
		}
		if(!"".equals(objs[1])&&null!=(objs[1])) {
			hql += " and s.SStarttime>?";
		}
		if(!"".equals(objs[2])&&null!=(objs[2])) {
			hql += " and s.SEndtime<?";
		}
		String countHql = "select count(*) from TShift s left join s.TUser u where 1=1 ";
		if(!"".equals(objs[0])&&null!=(objs[0])) {
			countHql += " and u.userRname like ? "; 
		}
		if(!"".equals(objs[1])&&null!=(objs[1])) {
			countHql += " and s.SStarttime>?";
		}
		if(!"".equals(objs[2])&&null!=(objs[2])) {
			countHql += " and s.SEndtime<?";
		}
		hql += " order by s.SEndtime desc";
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < objs.length; i++) {
			if(!"".equals(objs[i])&&null!=(objs[i])) {
				list.add(objs[i].toString());
			}
		}
		return shiftDao.findEntityBySome(hql,countHql, pageNo, pageSize, list.toArray());
	}

	@Override
	public void addShift(TShift shift) {
		shiftDao.add(shift);
	}

}

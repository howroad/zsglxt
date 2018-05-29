package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.IRotaDao;
import com.project.pojo.TRota;
import com.project.service.IRotaService;
import com.project.util.PageBean;

@Service("rotaService")
public class RotaServiceImpl implements IRotaService{
	
	@Autowired
	private IRotaDao rotaDao;
	@Override
	public boolean addRota(TRota rota) {
		boolean boo = false;
		try {
			rotaDao.add(rota);
			boo = true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return boo;
	}

	@Override
	public PageBean<TRota> findAllRota(int pageNo, int pageSize) {
		String hql = "select r from TRota r order by r.rotaDate desc";
		String countHql = "select count(*) from TRota";
		return rotaDao.findAllPage(hql,countHql,pageNo, pageSize);
	}

	@Override
	public PageBean<TRota> findRotaBySome(int pageNo, int pageSize, Object... objs) {
		String hql = "select r from TRota r left join r.TUser u where 1=1 ";
		if(!"".equals(objs[0])) {
			hql += " and u.userRname like ? "; 
		}
		if(!"".equals(objs[1])) {
			hql += " and r.rotaDate>?";
		}
		if(!"".equals(objs[2])) {
			hql += " and r.rotaDate<?";
		}
		
		String countHql = "select count(*) from TRota r left join r.TUser u where 1=1 ";
		if(!"".equals(objs[0])) {
			countHql += " and u.userRname like ? "; 
		}
		if(!"".equals(objs[1])) {
			countHql += " and r.rotaDate>?";
		}
		if(!"".equals(objs[2])) {
			countHql += " and r.rotaDate<?";
		}
		
		hql += " order by r.rotaDate desc";
		List<String> list = new ArrayList<String>();
		if(objs!=null) {
			for (int i = 0; i < objs.length; i++) {
				if(!"".equals(objs[i])) {
					list.add(objs[i].toString());
				}
			}
		}
		return rotaDao.findEntityBySome(hql,countHql, pageNo, pageSize, list.toArray());
	}

	

}

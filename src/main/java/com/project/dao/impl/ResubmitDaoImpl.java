package com.project.dao.impl;

import org.springframework.stereotype.Repository;

import com.project.dao.IResubmitDao;
import com.project.pojo.TResubmit;
@Repository("resubmitDao")
public class ResubmitDaoImpl extends BasicDaoAdapter<TResubmit, String> implements IResubmitDao{

}

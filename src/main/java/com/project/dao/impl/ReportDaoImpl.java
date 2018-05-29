package com.project.dao.impl;


import org.springframework.stereotype.Repository;

import com.project.dao.IReportDao;
import com.project.pojo.TReport;
@Repository("reportDao")
public class ReportDaoImpl extends BasicDaoAdapter<TReport, String> implements IReportDao{

}

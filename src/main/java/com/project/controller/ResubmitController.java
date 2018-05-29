package com.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.pojo.TReport;
import com.project.pojo.TResubmit;
import com.project.pojo.TUser;
import com.project.service.IReportService;
import com.project.service.IResubmitService;
import com.project.service.IUserService;

@Controller
@RequestMapping("resubmitController")
public class ResubmitController {

	@Autowired
	private IResubmitService resubmitService;
	@Autowired
	private IReportService reportService;

	
	@RequestMapping("addResubmit.do")
	@ResponseBody
	public boolean addResubmit(String rId,TResubmit resubmit,HttpServletRequest req) {
		TReport report = reportService.findTReportById(rId);
		resubmit.setTReport(report);
		String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		resubmit.setRsDate(date);
		TUser u = (TUser) req.getSession().getAttribute("session_user");
		resubmit.setTUser(u);
		return resubmitService.addResubmit(resubmit);
	}
	
	@RequestMapping("findResubmitByReportId/do")
	@ResponseBody
	public List<TResubmit> findResubmitByReportId(String rId){
		return resubmitService.findAllResubmitByReportId(rId);
	}
}

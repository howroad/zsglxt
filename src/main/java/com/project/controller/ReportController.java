package com.project.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.pojo.TReport;
import com.project.pojo.TResubmit;
import com.project.pojo.TUser;
import com.project.service.IReportService;
import com.project.service.IResubmitService;
import com.project.util.FileUploadUtil;
import com.project.util.MessageBean;
import com.project.util.PageBean;
import com.project.util.Producer;
import com.project.util.WordToPinYin;
import com.project.vo.ReportVO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

@Controller
@RequestMapping("reportController")
public class ReportController {

	@Autowired
	private IReportService reportService;
	@Autowired
	private IResubmitService resubmitService;
	@Autowired
	private Producer producer;

	@RequestMapping("addReport.do")
	@ResponseBody
	public boolean addReport(@RequestParam("img") MultipartFile file, TReport re, HttpServletRequest req) {
		String name = FileUploadUtil.getFileName(file);
		// 相对路径
		String path = "img/" + name;
		// 全路径
		String url = "http://192.168.1.67:8080/" + path;
		// jersey 发送另一台Tomcat(可读写的)
		// 创建jesy服务器 进行跨服务器上传
		Client client = Client.create();
		// 把文件关联到远程服务器
		WebResource resource = client.resource(url);
		// 上传
		try {
			resource.put(String.class, file.getBytes());
		} catch (UniformInterfaceException e) {
			e.printStackTrace();
		} catch (ClientHandlerException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		String rcode = WordToPinYin.dateToString() + WordToPinYin.toPinyin(re.getRName());
		TUser user = (TUser) req.getSession().getAttribute("session_user");
		re.setTUser(user);
		re.setRImage(name);
		re.setRCode(rcode);
		if (re.getRArea().equals("无")) {
			re.setRArea("");
		}
		return reportService.addReport(re);
	}

	@RequestMapping("fingAllMyReport.do")
	@ResponseBody
	public PageBean<?> fingAllMyReport(HttpServletRequest req, String RName, String SStarttime, String SEndtime,
			String pageNo, String RType, String RGrade, String RStatus) {
		TUser user = (TUser) req.getSession().getAttribute("session_user");
		String userId = user.getUserId();
		if (null != RName && !"".equals(RName)) {
			RName = "%" + RName + "%";
		}
		int num = Integer.parseInt((pageNo == null || pageNo.length() == 0) ? "1" : pageNo);
		return reportService.findMyReportBySome(num, 5, userId, RName, RType, RGrade, RStatus, SStarttime, SEndtime);
	}

	@RequestMapping("reportMain.do")
	@ResponseBody
	public PageBean<TReport> reportMain(Integer pageNo, String rName, String startTime, String endTime, String rType,
			String rGrade, String rStatus) {
		if (rName == null) {
			rName = "";
		}
		if (startTime == null) {
			startTime = "";
		}
		if (endTime == null) {
			endTime = "";
		}
		if (rType == null) {
			rType = "";
		}
		if (rGrade == null) {
			rGrade = "";
		}
		if (rStatus == null) {
			rStatus = "";
		}

		PageBean<TReport> pageBean = reportService.findReportBySome(pageNo, 5, "%" + rName + "%", rType, rGrade,
				rStatus, startTime, endTime);
		return pageBean;
	}

	@RequestMapping("findReportById.do")
	@ResponseBody
	public TReport findReportById(String rId) {

		List<TResubmit> list = resubmitService.findAllResubmitByReportId(rId);
		TReport report = reportService.findTReportById(rId);
		Set<TResubmit> set = new HashSet<TResubmit>();
		set.addAll(list);

		report.setTResubmits(set);

		return report;

	}

	@RequestMapping("updateReport.do")
	@ResponseBody
	public boolean updateReport(String rId, String region, String address, String grade, String num, String area,
			String desc) {

		TReport t = reportService.findTReportById(rId);
		t.setRRegion(region);
		t.setRAddress(address);
		t.setRArea(area);
		t.setRDesc(desc);
		t.setRNum(num);
		t.setRGrade(grade);

		return reportService.updateTReport(t);
	}

	@RequestMapping("deleteReport.do")
	@ResponseBody
	public boolean deleteReport(String rId) {

		TReport t = new TReport();
		t.setRId(rId);
		return reportService.delTReport(t);
	}

	// 上报
	@RequestMapping("updateReportStatus.do")
	@ResponseBody
	public boolean updateReportStatus(String rId, HttpServletRequest req) {

		TReport t = reportService.findTReportById(rId);
		t.setRStatus("已上报");
		TUser user = (TUser) req.getSession().getAttribute("session_user");
		t.setTUser(user);
		ReportVO revo = new ReportVO();

		revo.setRAddress(t.getRAddress());
		revo.setRArea(t.getRArea());
		revo.setRCode(t.getRCode());
		revo.setRDate(t.getRDate());
		revo.setRDesc(t.getRDesc());
		revo.setRGrade(t.getRGrade());
		revo.setRImage(t.getRImage());
		revo.setRName(t.getRName());
		revo.setRNum(t.getRNum());
		revo.setRRegion(t.getRRegion());
		revo.setRType(t.getRType());
		revo.setUserName(t.getTUser().getUserRname());
		revo.setUserTel(t.getTUser().getUserTel());

		MessageBean mb = new MessageBean("1", revo);
		ObjectMapper obj = new ObjectMapper();
		try {
			String mapJakcson = obj.writeValueAsString(mb);
			producer.sendMsgQueue(mapJakcson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reportService.updateTReport(t);
	}

}

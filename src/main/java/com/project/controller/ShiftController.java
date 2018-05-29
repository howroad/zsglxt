package com.project.controller;



import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.pojo.TRota;
import com.project.pojo.TShift;
import com.project.pojo.TUser;
import com.project.service.IShiftService;
import com.project.service.IUserService;
import com.project.util.PageBean;

@Controller
@RequestMapping("shiftController")
public class ShiftController {
	@Autowired
	private IShiftService shiftService;
	@Autowired
	private IUserService userService;
	
	@RequestMapping("findAllShift.do")
	@ResponseBody
	public PageBean<TShift> findAllShift(String userName,String SStarttime,String SEndtime,String pageNo) {
		if(null!=userName&&!"".equals(userName)) {
			userName = "%"+userName+"%";
		}
		int num =Integer.parseInt((pageNo==null||pageNo.length()==0)?"1":pageNo);
		PageBean<TShift> pb= shiftService.findShiftBySome(num, 5, userName,SStarttime,SEndtime);
		return pb;
		 
	}
	
	@RequestMapping("addShift.do")
	@ResponseBody
	public boolean addRota(String userName,String password,HttpServletRequest req) {
		
		
		 TUser user =  userService.login(userName, password);
		 if(user!=null) {
			 TUser user1 = (TUser) req.getSession().getAttribute("session_user");
			 TShift sf = new TShift();
			 sf.setTUser(user1);
			 sf.setSStarttime(req.getSession().getAttribute("startTime").toString());
			 String startTime=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
			 sf.setSEndtime(startTime);
			 shiftService.addShift(sf);
			 req.getSession().setAttribute("session_user", user);
			 req.getSession().setAttribute("startTime", startTime);
			 return true;
		 }
		 
		 return false;
	}
	
	
	
	
	
	
}

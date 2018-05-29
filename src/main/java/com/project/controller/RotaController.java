package com.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.pojo.TRota;
import com.project.pojo.TUser;
import com.project.service.IRotaService;
import com.project.service.IUserService;
import com.project.util.PageBean;

@Controller
@RequestMapping("rotaController")
public class RotaController {
	
	@Autowired
	private IRotaService rotaService;
	
	@RequestMapping("rotaMain.do")
	@ResponseBody
	public PageBean<TRota> rotaMain(Integer pageNo,String uName,String startTime,String endTime) {
		if(uName==null){
	    	uName="";
	    }else {
	    	uName = "%"+uName+"%";
	    }
	    if(startTime==null){
	    	startTime="";
	    }
	    if(endTime==null){
	    	endTime="";
	    }
		PageBean<TRota> pageBean = rotaService.findRotaBySome(pageNo, 5, uName,startTime,endTime);
		return pageBean;
	}
	@RequestMapping("addRota.do")
	@ResponseBody
	public boolean addRota(String userName,TRota rota,HttpServletRequest req) {
		TUser user = (TUser) req.getSession().getAttribute("session_user");
		String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		rota.setTUser(user);
		rota.setRotaDate(date);
		boolean boo = rotaService.addRota(rota);
		return boo;
	}
	
}

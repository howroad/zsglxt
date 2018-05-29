package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.pojo.TData;
import com.project.service.IDataService;

@Controller
@RequestMapping("dataController")
public class DataController {
	@Autowired
	private IDataService dataService;
	@RequestMapping("findData.do")
	public ModelAndView addReport() {
			
		List<TData> Llist = dataService.findAllData("RWLX");
		
		List<TData> Wlist = dataService.findAllData("QY");
		
		List<TData> Dlist = dataService.findAllData("RWDJ");
		
		ModelAndView mv = new ModelAndView("addReport.jsp");
		
		mv.addObject("Llist",Llist);
		mv.addObject("Wlist",Wlist);
		mv.addObject("Dlist",Dlist);
		
		
		return mv;
	}
	
	
	
	
	
}

package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("testController")
public class TestController {


	@RequestMapping("test1")
	@ResponseBody
	public String test() {
		return "success";
	}
}
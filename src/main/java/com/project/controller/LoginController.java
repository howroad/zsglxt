package com.project.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.pojo.TUser;
import com.project.service.IUserService;

@Controller("loginController")
public class LoginController {
	@Autowired
	private IUserService userService;

	@RequestMapping("login")
	public void login(String username, String password, String code, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		String codeSession = (String) session.getAttribute("code");

		if (codeSession.equalsIgnoreCase(code)) {
			// 验证码通过
			TUser user = userService.login(username, password);
			if (user != null) {
				session.setAttribute("session_user", user);
				String startTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
				session.setAttribute("startTime", startTime);
				
				response.sendRedirect(request.getContextPath() + "/index");
			} else {
				response.sendRedirect(request.getContextPath() + "/html/login.html");
			}
		}else {
			response.sendRedirect(request.getContextPath() + "/html/login.html");
		}

	}

	@RequestMapping("/index")
	public ModelAndView login() throws IOException {
		return new ModelAndView("index.jsp");
	}
}

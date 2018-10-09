package com.springboot.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.pojo.BaseView;
import com.springboot.pojo.User;
import com.springboot.service.UserService;
import com.springboot.utils.ValidateUtil;

/**
 *
 * @author  chengfan
 * @version 2018年9月17日
 */
@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("login.html")
	public String login() {
		return "login";
	}
	
	@RequestMapping("register.html")
	public String register() {
		return "register";
	}
	
	@RequestMapping("403.html")
	public String index() {
		return "403";
	}
	
	@PostMapping("toLogin.html")
	@ResponseBody
	public BaseView toLogin(Model model,@RequestParam("username")final String username,@RequestParam("password")final String password) {
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(username,password);
			try {
				currentUser.login(token);
			} catch (AuthenticationException e) {
				String message="用户名或密码不正确";
				model.addAttribute("message", message);
				return new BaseView("9999", "error");
			}
		}
		return new BaseView("0000", "success");
	}
	
	@RequestMapping("toRegister.html")
	@ResponseBody
	public BaseView toRegister(User user) {
		boolean flag = userService.addUser(user);
		if (flag) {
			return new BaseView("0000", "success");
		}else {  
			//注册失败
			return new BaseView("9999", "error");
		}
	}
	
	@RequestMapping("getValidateCode.html")
	public void getValidateCode(HttpServletRequest request, HttpServletResponse response) {
		ValidateUtil validateUtil = new ValidateUtil();
		//no-cache指示请求或响应消息不能缓存
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("image/png");
		OutputStream os;
		try {
			os = response.getOutputStream();
			String str = validateUtil.getCertPic(130, 40, os);
			System.out.println(str);
			System.out.println("to redis");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

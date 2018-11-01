package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.utils.EmailUtil;

/**
 *
 * @author  chengfan
 * @version 2018年11月1日
 */
@Controller
public class EmailController {
	
	@Autowired
	private EmailUtil emailUtils;

	@RequestMapping("send.html")
	public void sendEmail() {
		StringBuffer sb = new StringBuffer();
		sb.append("姓名：").append("某某某名字")
				.append("<br>")
				.append("手机号码：").append("131xxxxxxxx")
				.append("<br>")
				.append("QQ：").append("888888")
				.append("<br>")
				.append("联系地址：").append("某某某地址")
				.append("<br>")
				.append("单位名称：").append("某某某公司")
				.append("<br>")
				.append("信息来源：").append("某某某网站")
				.append("<br>")
				.append("方便联系时间：").append("某某某时间")
				.append("<br>")
				.append("来自界面：web推广界面");
		emailUtils.sendEmail("971072677@qq.com", "某某某主题", sb.toString());
	}
}

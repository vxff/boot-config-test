package com.springboot.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ObjectUtils;

/**
 *
 * @author chengfan
 * @version 2019年1月25日
 */
public class ExceptionMessage {

	public static final String USER_NOT_FOUND = "USER_NOT_FOUND";
	public static final String USER_STATUS_FAILD = "USER_STATUS_FAILD";
	
	public static final Map<String, String> messageMap = new HashMap<String, String>();

    static
	{
    	messageMap.put(ExceptionMessage.USER_NOT_FOUND, "用户：%s已被冻结，无法操作");
		messageMap.put(ExceptionMessage.USER_STATUS_FAILD, "用户状态异常");
	}
	
	public static String getMsg(String code,Object... params)
	{
		//格式化错误消息内容
        return ObjectUtils.isEmpty(params) ? messageMap.get(code) : String.format(messageMap.get(code), params);
	}
	
}

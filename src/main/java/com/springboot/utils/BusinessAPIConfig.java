package com.springboot.utils;

import java.io.Serializable;
import java.util.Properties;

/**
 *	获取properties配置文件的值
 * @author  chengfan
 * @version 2018年9月29日
 */
public class BusinessAPIConfig implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static Properties props = new Properties();

	public BusinessAPIConfig() {
	}

	static {
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("beetl.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getValue(String key) {
		return props.getProperty(key);
	}

	public static void updateProperties(String key, String value) {
		props.setProperty(key, value);
	}
	
	
}

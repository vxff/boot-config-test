package com.springboot.pojo;

import lombok.Data;

/**
 *
 * @author  chengfan
 * @version 2018年9月21日
 */
@Data
public class BaseView {

	private String code;
	
	private String message;
	
	public BaseView(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
}

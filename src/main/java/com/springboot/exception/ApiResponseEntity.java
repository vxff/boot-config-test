package com.springboot.exception;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author chengfan
 * @version 2019年1月25日
 */
@Data
@Builder
public class ApiResponseEntity<T extends Object> {

	/**
	  * 错误消息
	 */
	private String errorMsg;
	
	/**
	  * 数据内容
	 */
	private T data;
}

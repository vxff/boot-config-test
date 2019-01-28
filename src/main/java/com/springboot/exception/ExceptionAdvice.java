package com.springboot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chengfan
 * @version 2019年1月25日
 */
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class ExceptionAdvice {

	/**
	 * logback new instance
	 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 处理业务逻辑异常
	 *
	 * @param e 业务逻辑异常对象实例
	 * @return 逻辑异常消息内容
	 */
	@ExceptionHandler(BaseException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ApiResponseEntity<String> toBaseException(BaseException e) {
		logger.error("遇到业务逻辑异常：【{}】", e.getErrCode());
		// 返回响应实体内容
		return ApiResponseEntity.<String>builder().errorMsg(e.getErrMsg()).build();
	}
}

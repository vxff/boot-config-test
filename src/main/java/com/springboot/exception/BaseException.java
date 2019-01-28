package com.springboot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.springboot.utils.ExceptionMessage;

/**
 *
 * @author chengfan
 * @version 2019年1月25日
 */
public class BaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 日志对象
	 */
	private Logger logger = LoggerFactory.getLogger(BaseException.class);

	/**
	 * 错误消息内容
	 */
	protected String errMsg;
	
	/**
	 * 错误码
	 */
	protected String errCode;
	
	/**
	 * 格式化错误码时所需参数列表
	 */
	protected Object[] params;

	/**
	 * 获取错误消息内容 根据errCode从redis内获取未被格式化的错误消息内容 并通过String.format()方法格式化错误消息以及参数
	 *
	 * @return
	 */
	public String getErrMsg() {
		return errMsg;
	}

	/**
	 * 获取错误码
	 *
	 * @return
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * 获取异常参数列表
	 *
	 * @return
	 */
	public Object[] getParams() {
		return params;
	}

	/**
	 * 构造函数设置错误码以及错误参数列表
	 *
	 * @param errCode 错误码
	 * @param params  错误参数列表
	 */
	public BaseException(String errCode, Object... params) {
		this.errCode = errCode;
		this.params = params;
		// 获取格式化后的异常消息内容
		this.errMsg = ExceptionMessage.getMsg(errCode,params);
		// 错误信息
		logger.error("系统遇到如下异常，异常码：{}>>>异常信息：{}", errCode, errMsg);
	}

}

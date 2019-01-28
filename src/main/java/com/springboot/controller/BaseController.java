package com.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.PeopleDao;
import com.springboot.exception.ApiResponseEntity;
import com.springboot.exception.BaseException;
import com.springboot.exception.ErrorCodeEnum;
import com.springboot.pojo.People;

/**
 *
 * @author chengfan
 * @version 2019年1月25日
 */
@RestController
public class BaseController {

	@Autowired
	private PeopleDao peopleDao;

	@RequestMapping("test")
	public List<People> test() {
		return peopleDao.selectByAll();
	}
	
	@RequestMapping("test2")
	public List<People> test2() {
		PageQuery<People> query = new PageQuery<>(1, 1);
		
		 // 过滤条件
        Map<String,Object> paras = new HashMap<String,Object>(1);
        paras.put("name", "xff");
        query.setParas(paras);
        
        peopleDao.selectByPage(query);
        
		List<People> list = query.getList();
		return list;
	}

	@RequestMapping("testException")
	public ApiResponseEntity<String> index() throws BaseException {
		/**
		 * 模拟用户不存在 抛出业务逻辑异常
		 */
		if (true) {
			BaseException baseException = new BaseException(ErrorCodeEnum.USER_STATUS_FAILD.toString());
			throw baseException;
		}
		return ApiResponseEntity.<String>builder().data("this is index mapping").build();
	}

	@RequestMapping(value = "testException1", produces = "application/json; charset=utf-8")
	public ApiResponseEntity<String> testException1() throws BaseException {
		/**
		 * 模拟用户不存在 抛出业务逻辑异常
		 */
		if (true) {
			BaseException baseException = new BaseException(ErrorCodeEnum.USER_STATUS_FAILD.toString());
			throw baseException;
		}
		return ApiResponseEntity.<String>builder().data("this is index mapping").build();
	}

	@RequestMapping("testException2")
	public String testException2() throws BaseException {
		return "你好";
	}
}

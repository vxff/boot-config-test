package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.PeopleDao;
import com.springboot.pojo.People;

/**
 *
 * @author  chengfan
 * @version 2019年1月25日
 */
@RestController
public class BaseController {
	
	@Autowired
	private PeopleDao peopleDao;

	@RequestMapping("test")
	public List<People> test(){
		return peopleDao.selectByAll();
	}
}

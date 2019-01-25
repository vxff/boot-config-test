package com.springboot.dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import com.springboot.pojo.People;

/**
 *
 * @author  chengfan
 * @version 2019年1月25日
 */
@SqlResource(value="people")
public interface PeopleDao extends BaseMapper<People> {

	public List<People> selectByAll();
}

package com.springboot.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.pojo.User;

/**
 *
 * @author  chengfan
 * @version 2018年9月5日
 */
public interface UserRepository extends JpaRepository<User, Serializable>{

	public User findByUsername(String username);
}

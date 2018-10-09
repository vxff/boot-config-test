package com.springboot.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 *
 * @author  chengfan
 * @version 2018年9月5日
 */
@Data
@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String username;
	
	private String password;
	
	private String salt;
	
	/**
	 * credentialsSalt
	 * @return
	 */
	public String getCredentialsSalt() {
		return this.username + this.salt;
	}
}

package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.User;
import com.accp.domain.UserExample;
import com.accp.mapper.UserMapper;

@Service
@Transactional
public class userService {
	@Autowired
	UserMapper um;
	
	//添加了一行注释
	public User findUser(String username,String password) {
			UserExample ex=new UserExample();
			ex.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
			List<User> list=um.selectByExample(ex);
			if(list!=null&&list.size()>0) {
				return list.get(0);
			}
			return null;
	}
}

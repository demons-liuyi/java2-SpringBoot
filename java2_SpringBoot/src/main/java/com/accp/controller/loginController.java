package com.accp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.Student;
import com.accp.domain.User;
import com.accp.service.userService;

@RestController
@RequestMapping("/rest")
public class loginController {

	@Autowired
	userService us;
	@PostMapping("/loginIn")
	public Map<String, Object> loginIn(String username,String password,HttpSession session){	 
		User user=us.findUser(username, password);
		System.out.println(user.getId());
		session.setAttribute("user", user);
		System.out.println(session.getAttribute("user"));
		Map<String,Object> map = new HashMap<>();
		map.put("user", user);
		map.put("token",session.getId());
		return map;
	}
	
}

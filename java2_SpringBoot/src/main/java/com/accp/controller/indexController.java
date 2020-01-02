package com.accp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.Permission;
import com.accp.domain.User;
import com.accp.service.permissionService;

@RestController
@RequestMapping("/perms")
public class indexController {
	
	@Autowired
	permissionService ps;
	
	@GetMapping("/findTree")
	public List<Permission> findTree(HttpSession session){
		User user=(User) session.getAttribute("user");
		List<Permission> list=ps.findByUid(user.getId());
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("/qwe")
	public String qwe() {
		System.out.println("111");
		return "123";
	}
}

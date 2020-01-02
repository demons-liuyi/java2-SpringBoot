package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Student;
import com.accp.service.studentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/stu")
public class studentController {
	
	@Autowired
	studentService ss;
	
	@RequestMapping("/toQuery")
	public String toQuery() {
		return "query";
	}
	
	@RequestMapping("/pageInfo")
	@ResponseBody
	public PageInfo<Student> pageInfo(Integer pageSize,Integer pageNum){
		return ss.pageInfo(pageSize, pageNum);
	}
	
	@RequestMapping("/toAdd")	 
	public String toAdd() {	
		return "add";
	}	
	
	@RequestMapping("/addStudent")
	@ResponseBody
	public String addStudent(@RequestBody Student stu) {
		int i=ss.addStudent(stu);
		return "1";
	}
	
	@RequestMapping("/toUpdate")	 
	public String toUpdate(String sid,Model model) {
		System.out.println(sid);
		model.addAttribute("sid", sid);
		return "update";
	}
	
	@RequestMapping("/queryBySid")
	@ResponseBody
	public Student queryBySid(String sid) {
		Student stu=ss.queryBySid(sid);
		return stu;
	}
	
	@RequestMapping("/updateStudent")
	@ResponseBody
	public String updateStudent(@RequestBody Student stu) {
		int i=ss.updateStudent(stu);
		return "1";
	}
	
	@RequestMapping("/deleteStudent")
	@ResponseBody
	public String deleteStudent(String sid) {
		int i=ss.deleteStudent(sid);
		return "1";
	}
	
	 
	
	 
}

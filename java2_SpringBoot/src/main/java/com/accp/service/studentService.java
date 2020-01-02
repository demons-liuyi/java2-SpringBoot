package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Student;
import com.accp.domain.StudentExample;
import com.accp.mapper.StudentMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class studentService {

	@Autowired
	StudentMapper sm;
	
	public PageInfo<Student> pageInfo(Integer pageSize,Integer pageNum){
		Page<Student> page=PageHelper.startPage(pageNum, pageSize);
		List<Student> list=sm.selectByExample(null);
		return page.toPageInfo();
	}
	
	public int addStudent(Student stu) {
		int i=sm.insertSelective(stu);
		return i;
	}
	
	public int deleteStudent(String sid) {
		int i=sm.deleteByPrimaryKey(sid);
		return i;
	}
	
	public Student queryBySid(String sid) {
		 StudentExample example=new StudentExample();
		 example.createCriteria().andSidEqualTo(sid);
		 List<Student> stu=sm.selectByExample(example);
		 return stu.get(0);
	}
	
	 public int updateStudent(Student stu) {
		int i=sm.updateByPrimaryKeySelective(stu);
	  	 return i;   
	 }
	 
}

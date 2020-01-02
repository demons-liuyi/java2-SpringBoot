package com.accp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Permission;
import com.accp.mapper.PermissionMapper;

@Service
@Transactional
public class permissionService {

	@Autowired
	PermissionMapper pm;
	
	public List<Permission> findByUid(Integer uid){
		List<Permission> list=pm.findByUid(uid);
		Permission perm=new Permission();
		perm.setId(0);
		each(perm, list);
		return perm.getChildrens();
	}
	
	public void each(Permission perm,List<Permission> list) {
		for (Permission p : list) {
			if(perm.getId()==p.getParentid()) {			
				Permission newPerm=new Permission();
				newPerm.setId(p.getId());
				newPerm.setCatalog(p.getCatalog());
				newPerm.setChildrens(p.getChildrens());
				newPerm.setParentid(p.getParentid());
				newPerm.setPath(p.getPath());
				newPerm.setPermissionname(p.getPermissionname());
				perm.getChildrens().add(newPerm);
				each(newPerm,list);	 
			}
		}
	}
	
}

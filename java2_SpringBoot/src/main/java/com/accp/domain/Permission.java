package com.accp.domain;

import java.util.ArrayList;
import java.util.List;

public class Permission {
    private Integer id;

    private String permissionname;

    private Integer catalog;

    private Integer parentid;

    private String path;
    
    private List<Permission> childrens=new ArrayList<Permission>();

    public List<Permission> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<Permission> childrens) {
		this.childrens = childrens;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }

    public Integer getCatalog() {
        return catalog;
    }

    public void setCatalog(Integer catalog) {
        this.catalog = catalog;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
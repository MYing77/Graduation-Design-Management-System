package com.ysj.core.service;

import java.util.List;

import com.ysj.core.po.BaseDept;

public interface BaseDeptService {
	public List<BaseDept> deptlist();
	public BaseDept findDeptById(String deptId);
	public BaseDept findDeptByName(String deptName);
	public List<BaseDept> findDeptByName1(BaseDept baseDept);
	public int createDept(BaseDept baseDept);
	public int editInfo(String deptId,int s);
	public int editInfo1(BaseDept baseDept);
}

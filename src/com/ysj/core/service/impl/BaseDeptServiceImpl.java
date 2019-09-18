package com.ysj.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysj.core.dao.BaseDeptMapper;
import com.ysj.core.po.BaseDept;
import com.ysj.core.po.BaseDeptExample;
import com.ysj.core.service.BaseDeptService;
@Service
public class BaseDeptServiceImpl implements BaseDeptService {
	@Autowired
	private BaseDeptMapper baseDeptMapper;

	@Override
	public List<BaseDept> deptlist() {
		BaseDeptExample example = new BaseDeptExample();
		BaseDeptExample.Criteria criteria = example.createCriteria();
		criteria.andDeptStateEqualTo(1);
		return baseDeptMapper.selectByExample(example);
	}

	@Override
	public BaseDept findDeptById(String deptId) {
		BaseDeptExample example = new BaseDeptExample();
		BaseDeptExample.Criteria criteria = example.createCriteria();
		criteria.andDeptIdEqualTo(deptId);
		return baseDeptMapper.selectByExample(example).get(0);
	}

	@Override
	public BaseDept findDeptByName(String deptName) {
		BaseDeptExample example = new BaseDeptExample();
		BaseDeptExample.Criteria criteria = example.createCriteria();
		criteria.andDeptNameEqualTo(deptName);
		return baseDeptMapper.selectByExample(example).get(0);
	}

	@Override
	public List<BaseDept> findDeptByName1(BaseDept baseDept) {
		BaseDeptExample example = new BaseDeptExample();
		BaseDeptExample.Criteria criteria = example.createCriteria();
		if(baseDept!=null) {
			if(baseDept.getDeptName() !=null&&!"".equals(baseDept.getDeptName())) {
				criteria.andDeptNameLike("%" + baseDept.getDeptName() + "%");
			}
		}
		return baseDeptMapper.selectByExample(example);
	}

	@Override
	public int createDept(BaseDept baseDept) {
		return baseDeptMapper.insert(baseDept);
	}

	@Override
	public int editInfo(String deptId,int s) {
		return baseDeptMapper.editInfo(deptId,s);
	}

	@Override
	public int editInfo1(BaseDept baseDept) {
		return baseDeptMapper.editInfo1(baseDept.getDeptId(), baseDept.getDeptName());
	}
}

package com.ysj.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysj.core.dao.BaseMajorMapper;
import com.ysj.core.po.BaseMajor;
import com.ysj.core.po.BaseMajorExample;
import com.ysj.core.service.BaseMajorService;
@Service
public class BaseMajorServiceImpl implements BaseMajorService {
	@Autowired
	private BaseMajorMapper baseMajorMapper;

	@Override
	public List<BaseMajor> findMajorBydeptId(String deptId) {
		BaseMajorExample example = new BaseMajorExample();
		BaseMajorExample.Criteria criteria = example.createCriteria();
		criteria.andDeptIdEqualTo(deptId);
		criteria.andMajorStateEqualTo(1);
		List<BaseMajor> list = baseMajorMapper.selectByExample(example);
		return list;
	}
	
	@Override
	public List<BaseMajor> findMajorBydeptId1(String deptId) {
		BaseMajorExample example = new BaseMajorExample();
		BaseMajorExample.Criteria criteria = example.createCriteria();
		criteria.andDeptIdEqualTo(deptId);
		List<BaseMajor> list = baseMajorMapper.selectByExample(example);
		return list;
	}

	@Override
	public BaseMajor findMajorById(String majorId) {
		BaseMajorExample example = new BaseMajorExample();
		BaseMajorExample.Criteria criteria = example.createCriteria();
		criteria.andMajorIdEqualTo(majorId);
		List<BaseMajor> list = baseMajorMapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public int createMajor(BaseMajor baseMajor ) {
		return baseMajorMapper.insert(baseMajor);
	}

	@Override
	public int editMajor(BaseMajor baseMajor) {
		return baseMajorMapper.editMajor(baseMajor.getMajorName(),baseMajor.getMajorId());
	}

	@Override
	public int editMajor1(String majorId, int s) {
		return baseMajorMapper.editMajor1(majorId,s);
	}


}

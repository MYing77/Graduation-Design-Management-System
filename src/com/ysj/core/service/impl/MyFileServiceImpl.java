package com.ysj.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysj.core.dao.MyfileMapper;
import com.ysj.core.po.Myfile;
import com.ysj.core.po.MyfileExample;
import com.ysj.core.service.MyFileService;
@Service
public class MyFileServiceImpl implements MyFileService {

	@Autowired
	private MyfileMapper fileMapper;
	
	@Override
	public Myfile toPdfProjBook(Long fId) {
		return fileMapper.selectByPrimaryKey(fId);
	}

	@Override
	public Myfile selectById(Long fId) {
		return fileMapper.selectByPrimaryKey(fId);
	}

	@Override
	public int createMyfile(Myfile myfile) {
		return fileMapper.insert(myfile);
	}

	@Override
	public Myfile selectByfName(String fName) {
		MyfileExample example = new MyfileExample();
		//用来封装查询条件的
		MyfileExample.Criteria criteria=example.createCriteria();
		
		criteria.andFNameEqualTo(fName);
		
		List<Myfile> list= fileMapper.selectByExample(example);
		//select * from Myfile where fName = ?
		if (list!=null&& list.size()>0) {
			 return list.get(0);
		}
		return null;
	}

	@Override
	public int delete(Long fId) {
		return fileMapper.deleteByPrimaryKey(fId);
	}

	@Override
	public List<Myfile> filelist(Myfile myfile) {
		MyfileExample example = new MyfileExample();
		//用来封装查询条件的
		MyfileExample.Criteria criteria=example.createCriteria();
		List<Myfile> list = null;
		if(myfile!=null) {
			if(myfile.getfName()!=null&&!"".equals(myfile.getfName())) {
				criteria.andFNameLike("%" + myfile.getfName() + "%");
			}
		}
		example.setOrderByClause("f_type desc");
		list = fileMapper.selectByExample(example);
		return list;
	}

}

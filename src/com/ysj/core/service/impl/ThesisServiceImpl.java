package com.ysj.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysj.core.dao.ThesisMapper;
import com.ysj.core.po.Thesis;
import com.ysj.core.service.ThesisService;
@Service
public class ThesisServiceImpl implements ThesisService {
	
	@Autowired
	private ThesisMapper thesisMapper;
	
	@Override
	public List<Thesis> findThesisList(Thesis thesis, String sId) {
		List<Thesis> list = null;
		if(thesis!=null) {
			if(thesis.getfName() !=null&&!"".equals(thesis.getfName())) {
				list = thesisMapper.selectByExampleandSId(thesis.getfName(),sId);
				return list;
			}
		}
		return thesisMapper.selectBySId(sId);
	}

	@Override
	public Thesis findThesisByfId(Long fId) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int createThesis(Thesis thesis) {
		return thesisMapper.insert(thesis);
	}

	@Override
	public List<Thesis> findThesisBysId(String sId) {
		return thesisMapper.findThesisBysId(sId);
	}

	@Override
	public List<Thesis> findThesisBysIdAndAgree(String sId, String agree) {
		return thesisMapper.findThesisBysIdAndAgree(sId,agree);
	}

	@Override
	public List<Thesis> findThesisBytIdAndAgree(Thesis thesis, String tId, String agree) {
		List<Thesis> list = null;
		if(thesis!=null) {
			if(thesis.getfName() !=null&&!"".equals(thesis.getfName())) {
				list = thesisMapper.findThesisBytIdAndAgree(thesis.getfName(),tId, agree);
				return list;
			}
		}
		return thesisMapper.findThesisBytIdAndAgree1(tId, agree);
	}

	@Override
	public List<Thesis> findThesisBytIdAndAgree1(Thesis thesis, String tId, String agree) {
		List<Thesis> list = null;
		if(thesis!=null) {
			if(thesis.getfName() !=null&&!"".equals(thesis.getfName())) {
				list = thesisMapper.findThesisBytIdAndAgree2(thesis.getfName(),tId, agree);
				return list;
			}
		}
		return thesisMapper.findThesisBytIdAndAgree3(tId, agree);
	}

	@Override
	public int updateAgreeByfId(Long fId, String agree) {
		return thesisMapper.updateAgreeByfId(fId,agree);
	}

	@Override
	public List<Thesis> findThesisByMajorAndAgree(Thesis thesis, String major, String agree) {
		List<Thesis> list = null;
		if(thesis!=null) {
			if(thesis.getfName() !=null&&!"".equals(thesis.getfName())) {
				list = thesisMapper.findThesisByMajorAndAgree(thesis.getfName(),major,agree);
				return list;
			}
		}
		return thesisMapper.findThesisByMajorAndAgree1(major,agree);
	}

	@Override
	public List<Thesis> findThesisBytIdAndAgreeAndBatch(String tId, String agree, Short batch) {
		return thesisMapper.findThesisBytIdAndAgreeAndBatch(tId,agree,batch);
	}

}

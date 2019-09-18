package com.ysj.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysj.core.dao.MidCheckMapper;
import com.ysj.core.po.MidCheck;
import com.ysj.core.service.MidCheckService;
@Service
public class MidCheckServiceImpl implements MidCheckService {

	@Autowired
	private MidCheckMapper midCheckMapper;
	
	@Override
	public List<MidCheck> findMidCheckList(MidCheck midCheck, String sId) {
		List<MidCheck> list = null;
		if(midCheck!=null) {
			if(midCheck.getfName() !=null&&!"".equals(midCheck.getfName())) {
				list = midCheckMapper.selectByExampleandSId(midCheck.getfName(),sId);
				return list;
			}
		}
		return midCheckMapper.selectBySId(sId);
	}

	@Override
	public MidCheck findMidCheckByfId(Long fId) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int createMidCheck(MidCheck midCheck) {
		return midCheckMapper.insert(midCheck);
	}

	@Override
	public List<MidCheck> findMidCheckBysId(String sId) {
		return midCheckMapper.findMidCheckBysId(sId);
	}

	@Override
	public List<MidCheck> findMidCheckBysIdAndAgree(String sId, String agree) {
		return midCheckMapper.findMidCheckBysIdAndAgree(sId,agree);
	}

	@Override
	public List<MidCheck> findMidCheckBytIdAndAgree(MidCheck midCheck, String tId, String agree) {
		List<MidCheck> list = null;
		if(midCheck!=null) {
			if(midCheck.getfName() !=null&&!"".equals(midCheck.getfName())) {
				list = midCheckMapper.findMidCheckBytIdAndAgree(midCheck.getfName(),tId, agree);
				return list;
			}
		}
		return midCheckMapper.findMidCheckBytIdAndAgree1(tId, agree);
	}

	@Override
	public List<MidCheck> findMidCheckBytIdAndAgree1(MidCheck midCheck, String tId, String agree) {
		List<MidCheck> list = null;
		if(midCheck!=null) {
			if(midCheck.getfName() !=null&&!"".equals(midCheck.getfName())) {
				list = midCheckMapper.findMidCheckBytIdAndAgree2(midCheck.getfName(),tId, agree);
				return list;
			}
		}
		return midCheckMapper.findMidCheckBytIdAndAgree3(tId, agree);
	}

	@Override
	public int updateAgreeByfId(Long fId, String agree) {
		return midCheckMapper.updateAgreeByfId(fId,agree);
	}

	@Override
	public List<MidCheck> findMidCheckByMajorAndAgree(MidCheck midCheck, String major, String agree) {
		List<MidCheck> list = null;
		if(midCheck!=null) {
			if(midCheck.getfName() !=null&&!"".equals(midCheck.getfName())) {
				list = midCheckMapper.findMidCheckByMajorAndAgree(midCheck.getfName(),major, agree);
				return list;
			}
		}
		return midCheckMapper.findMidCheckByMajorAndAgree1(major, agree);
	}

}

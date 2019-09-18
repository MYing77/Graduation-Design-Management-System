package com.ysj.core.service;

import java.util.List;

import com.ysj.core.po.MidCheck;

public interface MidCheckService {
	public List<MidCheck>  findMidCheckList(MidCheck midCheck,String sId);
	public MidCheck findMidCheckByfId (Long fId);
	public int createMidCheck(MidCheck midCheck);
	public List<MidCheck> findMidCheckBysId (String sId);
	public List<MidCheck> findMidCheckBysIdAndAgree (String sId ,String agree);
	public List<MidCheck> findMidCheckBytIdAndAgree(MidCheck midCheck, String tId,String agree);
	public List<MidCheck> findMidCheckBytIdAndAgree1(MidCheck midCheck, String tId,String agree);
	public int updateAgreeByfId(Long fId,String agree);
	public List<MidCheck> findMidCheckByMajorAndAgree(MidCheck midCheck,String major,String agree);
}

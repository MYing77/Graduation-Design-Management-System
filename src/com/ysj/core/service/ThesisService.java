package com.ysj.core.service;

import java.util.List;
import com.ysj.core.po.Thesis;

public interface ThesisService {
	public List<Thesis>  findThesisList(Thesis thesis,String sId);
	public Thesis findThesisByfId (Long fId);
	public int createThesis(Thesis thesis);
	public List<Thesis> findThesisBysId (String sId);
	public List<Thesis> findThesisBysIdAndAgree (String sId ,String agree);
	public List<Thesis> findThesisBytIdAndAgree(Thesis thesis, String tId,String agree);
	public List<Thesis> findThesisBytIdAndAgree1(Thesis thesis, String tId,String agree);
	public int updateAgreeByfId(Long fId,String agree);
	public List<Thesis> findThesisByMajorAndAgree(Thesis thesis, String major,String agree);
	public List<Thesis> findThesisBytIdAndAgreeAndBatch(String tId,String agree,Short batch);
}

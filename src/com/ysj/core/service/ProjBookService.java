package com.ysj.core.service;

import java.util.List;

import com.ysj.core.po.ProjBook;

public interface ProjBookService {
	public List<ProjBook> findProjBookList (ProjBook projBook ,String sId);
	public ProjBook findProjBookByfId (Long fId);
	public int createProjBook(ProjBook projBook);
	public List<ProjBook> findProjBookBysId (String sId);
	public List<ProjBook> findProjBookBysIdAndAgree (String sId ,String agree);
	public List<ProjBook> findProjBookBytIdAndAgree(ProjBook projBook, String tId,String agree);
	public List<ProjBook> findProjBookBytIdAndAgree1(ProjBook projBook, String tId,String agree);
	public List<ProjBook> findProjBookByMajorAndAgree(ProjBook projBook, String major,String agree);
	public int updateAgreeByfId(Long fId,String agree);
}

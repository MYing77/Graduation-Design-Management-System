package com.ysj.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysj.core.dao.ProjBookMapper;
import com.ysj.core.po.ProjBook;
import com.ysj.core.service.ProjBookService;
@Service
public class ProjBookServiceImpl implements ProjBookService {
	
	@Autowired
	private ProjBookMapper projBookMapper;

	@Override
	public List<ProjBook> findProjBookList(ProjBook projBook, String sId) {
		List<ProjBook> list = null;
		if(projBook!=null) {
			if(projBook.getfName() !=null&&!"".equals(projBook.getfName())) {
				list = projBookMapper.selectByExampleandSId(projBook.getfName(),sId);
				return list;
			}
		}
		return projBookMapper.selectBySId(sId);
	}

	@Override
	public ProjBook findProjBookByfId(Long fId) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int createProjBook(ProjBook ProjBook) {
		return projBookMapper.insert(ProjBook);
	}

	@Override
	public List<ProjBook> findProjBookBysId(String sId) {
		return projBookMapper.findProjBookBysId(sId);
	}

	@Override
	public List<ProjBook> findProjBookBysIdAndAgree(String sId, String agree) {
		return projBookMapper.findProjBookBysIdAndAgree(sId,agree);
	}

	@Override
	public List<ProjBook> findProjBookBytIdAndAgree(ProjBook projBook, String tId, String agree) {
		List<ProjBook> list = null;
		if(projBook!=null) {
			if(projBook.getfName() !=null&&!"".equals(projBook.getfName())) {
				list = projBookMapper.findProjBookBytIdAndAgree(projBook.getfName(),tId, agree);
				return list;
			}
		}
		return projBookMapper.findProjBookBytIdAndAgree1(tId, agree);
	}

	@Override
	public List<ProjBook> findProjBookBytIdAndAgree1(ProjBook projBook, String tId, String agree) {
		List<ProjBook> list = null;
		if(projBook!=null) {
			if(projBook.getfName() !=null&&!"".equals(projBook.getfName())) {
				list = projBookMapper.findProjBookBytIdAndAgree2(projBook.getfName(),tId, agree);
				return list;
			}
		}
		return projBookMapper.findProjBookBytIdAndAgree3(tId, agree);
	}

	@Override
	public int updateAgreeByfId(Long fId,String agree) {
		return projBookMapper.updateAgreeByfId(fId,agree);
	}

	@Override
	public List<ProjBook> findProjBookByMajorAndAgree(ProjBook projBook, String major, String agree) {
		List<ProjBook> list = null;
		if(projBook!=null) {
			if(projBook.getfName() !=null&&!"".equals(projBook.getfName())) {
				list = projBookMapper.findProjBookByMajorAndAgree(projBook.getfName(),major, agree);
				return list;
			}
		}
		return projBookMapper.findProjBookByMajorAndAgree1(major, agree);
	}

}

package com.ysj.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysj.core.dao.ThesisAttachmentMapper;
import com.ysj.core.po.ThesisAttachment;
import com.ysj.core.service.ThesisAttachmentService;
@Service
public class ThesisAttachmentServiceImpl implements ThesisAttachmentService {
	
	@Autowired
	private ThesisAttachmentMapper thesisAttachmentMapper;

	@Override
	public List<ThesisAttachment> findThesisAttachmentList(ThesisAttachment thesisAttachment, String sId) {
		List<ThesisAttachment> list = null;
		if(thesisAttachment!=null) {
			if(thesisAttachment.getfName() !=null&&!"".equals(thesisAttachment.getfName())) {
				list = thesisAttachmentMapper.selectByExampleandSId(thesisAttachment.getfName(),sId);
				return list;
			}
		}
		return thesisAttachmentMapper.selectBySId(sId);
	}

	@Override
	public ThesisAttachment findThesisAttachmentByfId(Long fId) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int createThesisAttachment(ThesisAttachment thesisAttachment) {
		return thesisAttachmentMapper.insert(thesisAttachment);
	}

	@Override
	public List<ThesisAttachment> findThesisAttachmentBysId(String sId) {
		return thesisAttachmentMapper.selectBySId(sId);
	}

	@Override
	public List<ThesisAttachment> findThesisAttachmentBytId(String tId) {
		return thesisAttachmentMapper.findThesisAttachmentBytId(tId);
	}

	@Override
	public List<ThesisAttachment> findThesisAttachmentList1(ThesisAttachment thesisAttachment, String tId) {
		List<ThesisAttachment> list = null;
		if(thesisAttachment!=null) {
			if(thesisAttachment.getfName() !=null&&!"".equals(thesisAttachment.getfName())) {
				list = thesisAttachmentMapper.selectByExampleandTId(thesisAttachment.getfName(),tId);
				return list;
			}
		}
		return thesisAttachmentMapper.selectByTId(tId);
	}

	@Override
	public List<ThesisAttachment> findThesisAttachmentListByMajor(ThesisAttachment thesisAttachment, String major) {
		List<ThesisAttachment> list = null;
		if(thesisAttachment!=null) {
			if(thesisAttachment.getfName() !=null&&!"".equals(thesisAttachment.getfName())) {
				list = thesisAttachmentMapper.findThesisAttachmentListByMajor(thesisAttachment.getfName(),major);
				return list;
			}
		}
		return thesisAttachmentMapper.findThesisAttachmentListByMajor1(major);
	}

}

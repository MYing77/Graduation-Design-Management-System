package com.ysj.core.service;

import java.util.List;

import com.ysj.core.po.ThesisAttachment;

public interface ThesisAttachmentService {
	public List<ThesisAttachment>  findThesisAttachmentList(ThesisAttachment thesisAttachment,String sId);
	public List<ThesisAttachment>  findThesisAttachmentList1(ThesisAttachment thesisAttachment,String tId);
	public ThesisAttachment findThesisAttachmentByfId (Long fId);
	public int createThesisAttachment(ThesisAttachment thesisAttachment);
	public List<ThesisAttachment> findThesisAttachmentBysId (String sId);
	public List<ThesisAttachment> findThesisAttachmentBytId (String tId);
	public List<ThesisAttachment> findThesisAttachmentListByMajor (ThesisAttachment thesisAttachment,String major);
}

package com.ysj.core.service;

import java.util.List;

import com.ysj.core.po.OpenReport;


public interface OpenReportService {
	public List<OpenReport>  findOpenReportList(OpenReport openReport,String sId);
	public OpenReport findOpenReportByfId (Long fId);
	public int createOpenReport(OpenReport openReport);
	public List<OpenReport> findOpenReportBysId (String sId);
	public List<OpenReport> findOpenReportBysIdAndAgree (String sId ,String agree);
	public List<OpenReport> findOpenReportBytIdAndAgree(OpenReport openReport, String tId,String agree);
	public List<OpenReport> findOpenReportBytIdAndAgree1(OpenReport openReport, String tId,String agree);
	public int updateAgreeByfId(Long fId,String agree);
	public List<OpenReport> findOpenReportByMajorAndAgree(OpenReport openReport, String major,String agree);
	
}

package com.ysj.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysj.core.dao.OpenReportMapper;
import com.ysj.core.po.OpenReport;
@Service
public class OpenReportServiceImpl implements com.ysj.core.service.OpenReportService {

	@Autowired
	private OpenReportMapper openReportMapper;
	
	@Override
	public List<OpenReport> findOpenReportList(OpenReport openReport, String sId) {
		List<OpenReport> list = null;
		if(openReport!=null) {
			if(openReport.getfName() !=null&&!"".equals(openReport.getfName())) {
				list = openReportMapper.selectByExampleandSId(openReport.getfName(),sId);
				return list;
			}
		}
		return openReportMapper.selectBySId(sId);
	}

	@Override
	public OpenReport findOpenReportByfId(Long fId) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int createOpenReport(OpenReport openReport) {
		return openReportMapper.insert(openReport);
	}

	@Override
	public List<OpenReport> findOpenReportBysId(String sId) {
		return openReportMapper.findOpenReportBysId(sId);
	}

	@Override
	public List<OpenReport> findOpenReportBysIdAndAgree(String sId, String agree) {
		return openReportMapper.findOpenReportBysIdAndAgree(sId,agree);
	}

	@Override
	public List<OpenReport> findOpenReportBytIdAndAgree(OpenReport openReport, String tId, String agree) {
		List<OpenReport> list = null;
		if(openReport!=null) {
			if(openReport.getfName() !=null&&!"".equals(openReport.getfName())) {
				list = openReportMapper.findOpenReportBytIdAndAgree(openReport.getfName(),tId, agree);
				return list;
			}
		}
		return openReportMapper.findOpenReportBytIdAndAgree1(tId, agree);
	}

	@Override
	public List<OpenReport> findOpenReportBytIdAndAgree1(OpenReport openReport, String tId, String agree) {
		List<OpenReport> list = null;
		if(openReport!=null) {
			if(openReport.getfName() !=null&&!"".equals(openReport.getfName())) {
				list = openReportMapper.findOpenReportBytIdAndAgree2(openReport.getfName(),tId, agree);
				return list;
			}
		}
		return openReportMapper.findOpenReportBytIdAndAgree3(tId, agree);
	}

	@Override
	public int updateAgreeByfId(Long fId, String agree) {
		return openReportMapper.updateAgreeByfId(fId,agree);
	}

	@Override
	public List<OpenReport> findOpenReportByMajorAndAgree(OpenReport openReport, String major, String agree) {
		List<OpenReport> list = null;
		if(openReport!=null) {
			if(openReport.getfName() !=null&&!"".equals(openReport.getfName())) {
				list = openReportMapper.findOpenReportByMajorAndAgree(openReport.getfName(),major,agree);
				return list;
			}
		}
		return openReportMapper.findOpenReportByMajorAndAgree1(major,agree);
	}



}

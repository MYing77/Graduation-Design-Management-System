package com.ysj.core.dao;

import com.ysj.core.po.OpenReport;
import com.ysj.core.po.OpenReportExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpenReportMapper {
    int countByExample(OpenReportExample example);

    int deleteByExample(OpenReportExample example);

    int deleteByPrimaryKey(Long rId);

    int insert(OpenReport record);

    int insertSelective(OpenReport record);

    List<OpenReport> selectByExample(OpenReportExample example);
    
    List<OpenReport> selectByExampleandSId(@Param("fName")String fName ,
                                           @Param("sId")String sId);
    
    List<OpenReport> selectBySId(String sId);

    OpenReport selectByPrimaryKey(Long rId);

    int updateByExampleSelective(@Param("record") OpenReport record, @Param("example") OpenReportExample example);

    int updateByExample(@Param("record") OpenReport record, @Param("example") OpenReportExample example);

    int updateByPrimaryKeySelective(OpenReport record);

    int updateByPrimaryKey(OpenReport record);
    
    List<OpenReport> findOpenReportBysId(String sId);

	List<OpenReport> findOpenReportBysIdAndAgree(@Param("sId")String sId ,
                                                 @Param("agree")String agree);
	
	List<OpenReport> findOpenReportBytIdAndAgree(@Param("fName")String fName ,
                                               @Param("tId")String tId,
        	                                   @Param("agree")String agree);
	
	List<OpenReport> findOpenReportBytIdAndAgree1(@Param("tId")String tId,
                                               @Param("agree")String agree);
	
	List<OpenReport> findOpenReportBytIdAndAgree2(@Param("fName")String fName ,
                                                  @Param("tId")String tId,
                                                  @Param("agree")String agree);
	
	List<OpenReport> findOpenReportBytIdAndAgree3(@Param("tId")String tId,
                                                  @Param("agree")String agree);
	
	int updateAgreeByfId(@Param("fId")Long fId,
                         @Param("agree")String agree);
	
	List<OpenReport> findOpenReportByMajorAndAgree(@Param("fName")String fName ,
                                                   @Param("major")String major,
                                                   @Param("agree")String agree);
	
	List<OpenReport> findOpenReportByMajorAndAgree1(@Param("major")String major,
                                                    @Param("agree")String agree);

}
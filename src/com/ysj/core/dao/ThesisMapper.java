package com.ysj.core.dao;

import com.ysj.core.po.Thesis;
import com.ysj.core.po.ThesisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThesisMapper {
    int countByExample(ThesisExample example);

    int deleteByExample(ThesisExample example);

    int deleteByPrimaryKey(Long thesisId);

    int insert(Thesis record);

    int insertSelective(Thesis record);

    List<Thesis> selectByExample(ThesisExample example);
    
    List<Thesis> selectByExampleandSId(@Param("fName")String fName ,
                                       @Param("sId")String sId);

    List<Thesis> selectBySId(String sId);

    Thesis selectByPrimaryKey(Long thesisId);

    int updateByExampleSelective(@Param("record") Thesis record, @Param("example") ThesisExample example);

    int updateByExample(@Param("record") Thesis record, @Param("example") ThesisExample example);

    int updateByPrimaryKeySelective(Thesis record);

    int updateByPrimaryKey(Thesis record);
    
    List<Thesis> findThesisBysId(String sId);

	List<Thesis> findThesisBysIdAndAgree(@Param("sId")String sId ,
                                         @Param("agree")String agree);
	
	List<Thesis> findThesisBytIdAndAgree(@Param("fName")String fName ,
                                         @Param("tId")String tId,
                                         @Param("agree")String agree);

    List<Thesis> findThesisBytIdAndAgree1(@Param("tId")String tId,
                                          @Param("agree")String agree);

    List<Thesis> findThesisBytIdAndAgree2(@Param("fName")String fName ,
                                          @Param("tId")String tId,
                                          @Param("agree")String agree);

    List<Thesis> findThesisBytIdAndAgree3(@Param("tId")String tId,
                                          @Param("agree")String agree);

    int updateAgreeByfId(@Param("fId")Long fId,
                         @Param("agree")String agree);
    
    List<Thesis> findThesisByMajorAndAgree(@Param("fName")String fName ,
                                           @Param("major")String major,
                                           @Param("agree")String agree);

    List<Thesis> findThesisByMajorAndAgree1(@Param("major")String major,
                                           @Param("agree")String agree);

	List<Thesis> findThesisBytIdAndAgreeAndBatch(@Param("tId")String tId,
			                                     @Param("agree")String agree, 
			                                     @Param("batch")Short batch);
}
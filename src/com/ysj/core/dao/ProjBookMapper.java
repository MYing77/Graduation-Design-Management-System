package com.ysj.core.dao;

import com.ysj.core.po.ProjBook;
import com.ysj.core.po.ProjBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjBookMapper {
    int countByExample(ProjBookExample example);

    int deleteByExample(ProjBookExample example);

    int deleteByPrimaryKey(Long pId);

    int insert(ProjBook record);

    int insertSelective(ProjBook record);

    List<ProjBook> selectByExample(ProjBookExample example);
    
    List<ProjBook> selectByExampleandSId(@Param("fName")String fName ,
                                         @Param("sId")String sId);
    
    List<ProjBook> selectBySId(String sId);

    ProjBook selectByPrimaryKey(Long pId);

    int updateByExampleSelective(@Param("record") ProjBook record, @Param("example") ProjBookExample example);

    int updateByExample(@Param("record") ProjBook record, @Param("example") ProjBookExample example);

    int updateByPrimaryKeySelective(ProjBook record);

    int updateByPrimaryKey(ProjBook record);

	List<ProjBook> findProjBookBysId(String sId);

	List<ProjBook> findProjBookBysIdAndAgree(@Param("sId")String sId ,
                                             @Param("agree")String agree);
	
	List<ProjBook> findProjBookBytIdAndAgree(@Param("fName")String fName ,
			                                 @Param("tId")String tId,
		                                 	 @Param("agree")String agree);
	
	List<ProjBook> findProjBookBytIdAndAgree1(@Param("tId")String tId,
        	                                  @Param("agree")String agree);

	List<ProjBook> findProjBookBytIdAndAgree2(@Param("fName")String fName ,
                                              @Param("tId")String tId,
        	                                  @Param("agree")String agree);
	
	List<ProjBook> findProjBookBytIdAndAgree3(@Param("tId")String tId,
                                              @Param("agree")String agree);
	
	int updateAgreeByfId(@Param("fId")Long fId,
			             @Param("agree")String agree);
	
	List<ProjBook> findProjBookByMajorAndAgree(@Param("fName")String fName ,
                                               @Param("major")String tId,
        	                                   @Param("agree")String agree);

	List<ProjBook> findProjBookByMajorAndAgree1(@Param("major")String tId,
                                                @Param("agree")String agree);
}
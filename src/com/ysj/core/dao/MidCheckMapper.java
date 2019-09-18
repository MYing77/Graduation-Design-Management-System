package com.ysj.core.dao;

import com.ysj.core.po.MidCheck;
import com.ysj.core.po.MidCheckExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MidCheckMapper {
    int countByExample(MidCheckExample example);

    int deleteByExample(MidCheckExample example);

    int deleteByPrimaryKey(Long mId);

    int insert(MidCheck record);

    int insertSelective(MidCheck record);

    List<MidCheck> selectByExample(MidCheckExample example);
    
    List<MidCheck> selectByExampleandSId(@Param("fName")String fName ,
                                         @Param("sId")String sId);

    List<MidCheck> selectBySId(String sId);

    MidCheck selectByPrimaryKey(Long mId);

    int updateByExampleSelective(@Param("record") MidCheck record, @Param("example") MidCheckExample example);

    int updateByExample(@Param("record") MidCheck record, @Param("example") MidCheckExample example);

    int updateByPrimaryKeySelective(MidCheck record);

    int updateByPrimaryKey(MidCheck record);
    
    List<MidCheck> findMidCheckBysId(String sId);

	List<MidCheck> findMidCheckBysIdAndAgree(@Param("sId")String sId ,
                                             @Param("agree")String agree);
	
	List<MidCheck> findMidCheckBytIdAndAgree(@Param("fName")String fName ,
                                             @Param("tId")String tId,
                                             @Param("agree")String agree);

    List<MidCheck> findMidCheckBytIdAndAgree1(@Param("tId")String tId,
                                              @Param("agree")String agree);

    List<MidCheck> findMidCheckBytIdAndAgree2(@Param("fName")String fName ,
                                              @Param("tId")String tId,
                                              @Param("agree")String agree);

    List<MidCheck> findMidCheckBytIdAndAgree3(@Param("tId")String tId,
                                              @Param("agree")String agree);

    int updateAgreeByfId(@Param("fId")Long fId,
                         @Param("agree")String agree);
    
    List<MidCheck> findMidCheckByMajorAndAgree(@Param("fName")String fName ,
                                               @Param("major")String major,
                                               @Param("agree")String agree);
    
    List<MidCheck> findMidCheckByMajorAndAgree1(@Param("major")String major,
                                                @Param("agree")String agree);
}
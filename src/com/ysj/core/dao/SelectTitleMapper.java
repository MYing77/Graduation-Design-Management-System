package com.ysj.core.dao;

import com.ysj.core.po.SelectTitle;
import com.ysj.core.po.SelectTitleExample;
import com.ysj.core.po.SelectTitleKey;
import com.ysj.core.po.Title;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SelectTitleMapper {
    int countByExample(SelectTitleExample example);

    int deleteByExample(SelectTitleExample example);

    int deleteByPrimaryKey(SelectTitleKey key);

    int insert(SelectTitle record);

    int insertSelective(SelectTitle record);

    List<SelectTitle> selectByExample(SelectTitleExample example);
    
    List<SelectTitle> selectByExampleandSId(@Param("titlName")String titlName ,
                                            @Param("sId")String sId);
    
    List<SelectTitle> selectBySId(String sId);
    
    List<SelectTitle> findSelTitleListBysIdAndState(@Param("sId")String sId ,
                                                    @Param("seltitl_state")String seltitl_state);

    int findSelTitleListByState(@Param("major")String major ,
                                @Param("seltitlState")String seltitlState);
    
    int findSelTitleListByState1(String seltitlState);
    
    int findSelTitleListByState2(@Param("tId")String tId,
    		                     @Param("seltitlState")String seltitlState);
    
    List<Title> findSelTitleListByState3(@Param("titlName")String titlName,
    		                             @Param("tId")String tId,
                                         @Param("seltitlState")String seltitlState);
    
    List<Title> findSelTitleListByState4(@Param("tId")String tId,
                                         @Param("seltitlState")String seltitlState);
    
    int updateSelTitle1(@Param("titlId")Long titlId,
    		            @Param("seltitlState")String seltitlState);
    
    SelectTitle selectByPrimaryKey(SelectTitleKey key);

    int updateByExampleSelective(@Param("record") SelectTitle record, @Param("example") SelectTitleExample example);

    int updateByExample(@Param("record") SelectTitle record, @Param("example") SelectTitleExample example);

    int updateByPrimaryKeySelective(SelectTitle record);

    int updateByPrimaryKey(SelectTitle record);

	int findSelectTitle(String sId);
	
	SelectTitle findBytitlId(Long titlId);
	
	int findSelTitle(String sId);

	int updateReplyScore(@Param("sId")String sId,
			             @Param("titlId")Long titlId,
			             @Param("replyScore")double replyScore);
}
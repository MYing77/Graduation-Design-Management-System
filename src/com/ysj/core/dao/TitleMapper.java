package com.ysj.core.dao;

import com.ysj.core.po.Title;
import com.ysj.core.po.Title1;
import com.ysj.core.po.TitleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TitleMapper {
    int countByExample(TitleExample example);

    int deleteByExample(TitleExample example);

    int deleteByPrimaryKey(Long titlId);

    int insert(Title record);

    int insertSelective(Title record);

    List<Title> selectByExample(TitleExample example);
    
    List<Title> selectByExampleandMajor(@Param("titlName")String titlName ,
                                        @Param("major")String major);

    List<Title> selectByMajor(String major);

    Title selectByPrimaryKey(Long titlId);
    
    List<Title> selectByExampleandSId(@Param("titlName")String titlName ,
                                      @Param("sId")String sId);
    
    int findTitleSum(@Param("major")String major ,
    		         @Param("titlState")String titlState);
    
    int findTitleSum1(@Param("tId")String tId ,
    		          @Param("titlState")String titlState);
    
    int findTitleSum2(@Param("major")String major ,
	          @Param("selState")String selState);
    
    List<Title1> findTitleListBytId(@Param("titlName")String titlName,
    		                       @Param("tId")String tId);
    
    List<Title1> findTitleListBytId1(@Param("tId")String tId);
    
    List<Title1> findTitleListBytId11(@Param("tId")String tId);
    
    List<Title> findTitleListBytId2(@Param("titlName")String titlName,
            @Param("tId")String tId,
            @Param("titlState")String titlState);
    
    List<Title> findTitleListBytId3(@Param("tId")String tId,
                                    @Param("titlState")String titlState);
    
    List<Title> selectByExampleandSId2(String sId);
    
    Title selectByExampleandSId3(String sId);

    int updateByExampleSelective(@Param("record") Title record, @Param("example") TitleExample example);

    int updateByExample(@Param("record") Title record, @Param("example") TitleExample example);

    int updateByPrimaryKeySelective(Title record);

    int updateByPrimaryKey(Title record);
    
    List<Title1> findTitleListBytitlState(@Param("titlName")String titlName,
                                          @Param("major")String major,
                                          @Param("titlState")String titlState);
    
    List<Title1> findTitleListBytitlState1(@Param("major")String major,
                                           @Param("titlState")String titlState);
    
    List<Title1> findTitleListBytitlState2(@Param("titlName")String titlName,
                                           @Param("major")String major,
                                           @Param("titlState")String titlState);
    
    List<Title1> findTitleListBytitlState3(@Param("major")String major,
                                           @Param("titlState")String titlState);
    
    int updateTitlStateById(@Param("titlId")Long titlId,
    		                @Param("titlState")String titlState);
    
    List<Title1> findTitleListBymajor(@Param("titlName")String titlName,
                                      @Param("major")String major);

    List<Title1> findTitleListBymajor1(String major);

    List<Title1> findTitleListBymajor2(String major);
    
    int updateTitleMajor(@Param("major")String major,
    		             @Param("oldName")String oldName);
    
}
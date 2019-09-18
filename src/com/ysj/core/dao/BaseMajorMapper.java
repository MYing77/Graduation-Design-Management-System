package com.ysj.core.dao;

import com.ysj.core.po.BaseMajor;
import com.ysj.core.po.BaseMajorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseMajorMapper {
    int countByExample(BaseMajorExample example);

    int deleteByExample(BaseMajorExample example);

    int deleteByPrimaryKey(String majorId);

    int insert(BaseMajor record);

    int insertSelective(BaseMajor record);

    List<BaseMajor> selectByExample(BaseMajorExample example);

    BaseMajor selectByPrimaryKey(String majorId);

    int updateByExampleSelective(@Param("record") BaseMajor record, @Param("example") BaseMajorExample example);

    int updateByExample(@Param("record") BaseMajor record, @Param("example") BaseMajorExample example);

    int updateByPrimaryKeySelective(BaseMajor record);

    int updateByPrimaryKey(BaseMajor record);
    
    int editMajor(@Param("majorName")String majorName,
    		      @Param("majorId")String majorId );
    
    int editMajor1(@Param("majorId")String majorId,
		      @Param("s")int  s );
}
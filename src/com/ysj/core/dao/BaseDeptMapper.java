package com.ysj.core.dao;

import com.ysj.core.po.BaseDept;
import com.ysj.core.po.BaseDeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseDeptMapper {
    int countByExample(BaseDeptExample example);

    int deleteByExample(BaseDeptExample example);

    int deleteByPrimaryKey(String deptId);

    int insert(BaseDept record);

    int insertSelective(BaseDept record);

    List<BaseDept> selectByExample(BaseDeptExample example);

    BaseDept selectByPrimaryKey(String deptId);

    int updateByExampleSelective(@Param("record") BaseDept record, @Param("example") BaseDeptExample example);

    int updateByExample(@Param("record") BaseDept record, @Param("example") BaseDeptExample example);

    int updateByPrimaryKeySelective(BaseDept record);

    int updateByPrimaryKey(BaseDept record);
    
    int editInfo(@Param("deptId")String deptId,
    		     @Param("s")int s);
    
    int editInfo1(@Param("deptId")String deptId,
		          @Param("deptName")String deptName);

}
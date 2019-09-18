package com.ysj.core.dao;

import com.ysj.core.po.Student;
import com.ysj.core.po.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(String sId);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(String sId);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
    
    List<Student> findStudnetBySeltitlState(String major);
    
    int editInfo1(@Param("deptName")String deptName,
    		      @Param("oldName")String oldName);
    
    int editInfo2(@Param("majorName")String majorName,
		          @Param("majorId")String majorId);
}
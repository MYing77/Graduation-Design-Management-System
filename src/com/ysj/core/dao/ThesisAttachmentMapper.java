package com.ysj.core.dao;

import com.ysj.core.po.ThesisAttachment;
import com.ysj.core.po.ThesisAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThesisAttachmentMapper {
    int countByExample(ThesisAttachmentExample example);

    int deleteByExample(ThesisAttachmentExample example);

    int deleteByPrimaryKey(Long aId);

    int insert(ThesisAttachment record);

    int insertSelective(ThesisAttachment record);

    List<ThesisAttachment> selectByExample(ThesisAttachmentExample example);
    
    List<ThesisAttachment> selectByExampleandSId(@Param("fName")String fName ,
                                                 @Param("sId")String sId);

    List<ThesisAttachment> selectBySId(String sId);
    
    List<ThesisAttachment> selectByExampleandTId(@Param("fName")String fName ,
                                                 @Param("tId")String tId);
    
    List<ThesisAttachment> selectByTId(String tId);
    
    List<ThesisAttachment> findThesisAttachmentBysId(String sId);
    
    List<ThesisAttachment> findThesisAttachmentBytId(String tId);

    ThesisAttachment selectByPrimaryKey(Long aId);

    int updateByExampleSelective(@Param("record") ThesisAttachment record, @Param("example") ThesisAttachmentExample example);

    int updateByExample(@Param("record") ThesisAttachment record, @Param("example") ThesisAttachmentExample example);

    int updateByPrimaryKeySelective(ThesisAttachment record);

    int updateByPrimaryKey(ThesisAttachment record);
    
    List<ThesisAttachment> findThesisAttachmentListByMajor(@Param("fName")String fName ,
                                                           @Param("major")String major);

    List<ThesisAttachment> findThesisAttachmentListByMajor1(@Param("major")String major);
}
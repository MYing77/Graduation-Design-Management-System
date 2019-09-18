package com.ysj.core.dao;

import com.ysj.core.po.ReplyGroup;
import com.ysj.core.po.ReplyGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplyGroupMapper {
    int countByExample(ReplyGroupExample example);

    int deleteByExample(ReplyGroupExample example);

    int deleteByPrimaryKey(String replyId);

    int insert(ReplyGroup record);

    int insertSelective(ReplyGroup record);

    List<ReplyGroup> selectByExample(ReplyGroupExample example);

    ReplyGroup selectByPrimaryKey(String replyId);

    int updateByExampleSelective(@Param("record") ReplyGroup record, @Param("example") ReplyGroupExample example);

    int updateByExample(@Param("record") ReplyGroup record, @Param("example") ReplyGroupExample example);

    int updateByPrimaryKeySelective(ReplyGroup record);

    int updateByPrimaryKey(ReplyGroup record);
}
package com.ysj.core.dao;

import com.ysj.core.po.ScoreProportion;
import com.ysj.core.po.ScoreProportionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScoreProportionMapper {
    int countByExample(ScoreProportionExample example);

    int deleteByExample(ScoreProportionExample example);

    int deleteByPrimaryKey(String proportionId);

    int insert(ScoreProportion record);

    int insertSelective(ScoreProportion record);

    List<ScoreProportion> selectByExample(ScoreProportionExample example);

    ScoreProportion selectByPrimaryKey(String proportionId);

    int updateByExampleSelective(@Param("record") ScoreProportion record, @Param("example") ScoreProportionExample example);

    int updateByExample(@Param("record") ScoreProportion record, @Param("example") ScoreProportionExample example);

    int updateByPrimaryKeySelective(ScoreProportion record);

    int updateByPrimaryKey(ScoreProportion record);
}
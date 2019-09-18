package com.ysj.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysj.core.dao.ScoreProportionMapper;
import com.ysj.core.po.ScoreProportion;
import com.ysj.core.service.ScoreProportionService;
@Service
public class ScoreProportionServiceImpl implements ScoreProportionService {

	@Autowired
	private ScoreProportionMapper scoreProportionMapper;
	@Override
	public ScoreProportion getScoreProportion(String proportionId) {
		return scoreProportionMapper.selectByPrimaryKey(proportionId);
	}
	@Override
	public int update(ScoreProportion scoreProportion) {
		return scoreProportionMapper.updateByPrimaryKey(scoreProportion);
	}

}

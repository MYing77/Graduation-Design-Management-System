package com.ysj.core.service;

import com.ysj.core.po.ScoreProportion;

public interface ScoreProportionService {
	public ScoreProportion getScoreProportion(String proportionId);
	int update(ScoreProportion scoreProportion);
}

package com.ysj.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysj.core.dao.ReplyGroupMapper;
import com.ysj.core.po.ReplyGroup;
import com.ysj.core.po.ReplyGroupExample;
@Service
public class ReplyGroupServiceImpl implements com.ysj.core.service.ReplyGroupService {

	@Autowired
	private ReplyGroupMapper replyGroupMapper;
	
	@Override
	public int createReply(ReplyGroup replyGroup) {
		return replyGroupMapper.insert(replyGroup);
	}

	@Override
	public List<ReplyGroup> replyGrouplist(String creator) {
		ReplyGroupExample example = new ReplyGroupExample();
		ReplyGroupExample.Criteria criteria = example.createCriteria();
		criteria.andCreatorEqualTo(creator);
		return replyGroupMapper.selectByExample(example);
	}

	@Override
	public int deleteReply(String replyId) {
		return replyGroupMapper.deleteByPrimaryKey(replyId);
	}

}

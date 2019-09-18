package com.ysj.core.service;

import java.util.List;

import com.ysj.core.po.ReplyGroup;

public interface ReplyGroupService {
	int createReply(ReplyGroup replyGroup);
	List<ReplyGroup> replyGrouplist(String creator);
	int deleteReply(String replyId);
}

package com.ysj.core.service;

import com.ysj.core.po.Comments;

public interface CommentsServer {

	public Comments getcommentsById(Long cId);
	public Comments getcomments(Long fId);
	public int createComments(Comments comments);

}

package com.ysj.core.dao;

import com.ysj.core.po.Review;
import com.ysj.core.po.Review1;
import com.ysj.core.po.ReviewExample;
import com.ysj.core.po.ReviewKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReviewMapper {
    int countByExample(ReviewExample example);

    int deleteByExample(ReviewExample example);

    int deleteByPrimaryKey(ReviewKey key);

    int insert(Review record);

    int insertSelective(Review record);

    List<Review> selectByExample(ReviewExample example);

    Review selectByPrimaryKey(ReviewKey key);

    int updateByExampleSelective(@Param("record") Review record, @Param("example") ReviewExample example);

    int updateByExample(@Param("record") Review record, @Param("example") ReviewExample example);

    int updateByPrimaryKeySelective(Review record);

    int updateByPrimaryKey(Review record);

	List<Review1> findByMemberId(String memberTId);

	List<Review1> findBysNameAndMemberId(@Param("sName") String getsName,
			                             @Param("memberTId") String memberTId);

	int update(Review review);

	List<Review1> findByReplyLeader(String replyLeader);

	List<Review1> findReviewByRLer(String replyLeader);

	List<Review1> findReviewByRLer1(@Param("sName") String getsName, 
			                        @Param("replyLeader") String replyLeader);
	
	List<Review1> findBySId(String sId);
}
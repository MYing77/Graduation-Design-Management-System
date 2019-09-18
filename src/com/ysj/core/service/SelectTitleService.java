package com.ysj.core.service;

import java.util.List;

import com.ysj.core.po.SelectTitle;
import com.ysj.core.po.Title;

public interface SelectTitleService {
	public int createSelectTitle(SelectTitle selectTitle);
	public SelectTitle getSelectTitle(SelectTitle selectTitle);
	public List<SelectTitle> findSelTitleListById (Title title, String sId);
	public int deleteCustomer(Long titlId , String sId);
	public  int findSelectTitle(String sId);
	public List<SelectTitle> findSelTitleListBysIdAndState (String sId , String seltitl_state);
	public int findSelTitleListByState(String major,String seltitlState);
	public int findSelTitleListByState1(String seltitlState);
	public int findSelTitleListByState2(String tId,String seltitlState);
	public List<Title> findSelTitleListByState3(Title title ,String tId,String seltitlState);
	public int updateSelTitle(SelectTitle selectTitle);
	public int updateReplyScore(SelectTitle selectTitle);
	public int updateSelTitle1(SelectTitle selectTitle);
	public SelectTitle findBytitlId(Long titlId);
	public int findSelTitle(String sId);
}

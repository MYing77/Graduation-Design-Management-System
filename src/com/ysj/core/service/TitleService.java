package com.ysj.core.service;

import java.util.List;




import com.ysj.core.po.Title;
import com.ysj.core.po.Title1;

public interface TitleService {
	public List<Title> findTitleList(Title title , String sId);
	public List<Title> findTitleListByMajor(Title title ,String major);
	public Title findTitleById(Long titlId);
	public Title findTitleBysId(String sId);
	public int updateTitleById(Title title);
	public int updateTitleSelStateById(Title title);
	public int findTitleSum(String major,String titlState);
	public int findTitleSum1(String tId,String titlState);
	public int findTitleSum2(String major,String selState);
	public List<Title1> findTitleListBytId(Title title , String tId);
	public List<Title1> findTitleListBytitlState(Title title);
	public List<Title1> findTitleListBytitlState1(Title title);
	public List<Title1> findTitleListBytId11(String tId);
	public List<Title> findTitleListBytId1(Title title , String tId ,String titlState);
	public int createTitle(Title title);
	public int deleteTitle(Long titlId);
	public List<Title1> findTitleListBymajor(Title title,String major);
	public List<Title1> findTitleListBymajor2(String major);
	public int updateTitleMajor(String major,String oldName);
}

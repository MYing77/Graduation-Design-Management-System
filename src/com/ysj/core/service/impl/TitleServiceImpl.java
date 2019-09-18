package com.ysj.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysj.core.dao.TitleMapper;
import com.ysj.core.po.Title;
import com.ysj.core.po.Title1;
import com.ysj.core.service.TitleService;
@Service
public class TitleServiceImpl implements TitleService {
	
	@Autowired
	private TitleMapper titleMapper;

	@Override
	public List<Title> findTitleListByMajor(Title title ,String major) {
		List<Title> list = null;
		if(title!=null) {
			if(title.getTitlName() !=null&&!"".equals(title.getTitlName())) {
				list = titleMapper.selectByExampleandMajor((String)title.getTitlName(), major);
				return list;
			}
		}
		list = titleMapper.selectByMajor(major);
		return list;
	}

	@Override
	public Title findTitleById(Long titlId) {
		return titleMapper.selectByPrimaryKey(titlId);
	}

	@Override
	public List<Title> findTitleList(Title title , String sId) {
		List<Title> list = null;
		if(title!=null) {
			if(title.getTitlName() !=null&&!"".equals(title.getTitlName())) {
				list = titleMapper.selectByExampleandSId((String)title.getTitlName(), sId);
				return list;
			}
		}
		list = titleMapper.selectByExampleandSId2(sId);
		return list;
	}

	@Override
	public int updateTitleById(Title title) {
		return titleMapper.updateTitlStateById(title.getTitlId(),title.getTitlState());
	}

	@Override
	public int updateTitleSelStateById(Title title) {
		return titleMapper.updateByPrimaryKeySelective(title);
	}

	@Override
	public Title findTitleBysId(String sId) {
		return titleMapper.selectByExampleandSId3(sId);
	}

	@Override
	public int findTitleSum(String major ,String titlState) {
		return titleMapper.findTitleSum(major,titlState);
	}

	@Override
	public int findTitleSum1(String tId,String titlState) {
		return titleMapper.findTitleSum1(tId,titlState);
	}

	@Override
	public List<Title1> findTitleListBytId(Title title, String tId ) {
		List<Title1> list = null;
		if(title!=null) {
			if(title.getTitlName() !=null&&!"".equals(title.getTitlName())) {
				list = titleMapper.findTitleListBytId((String)title.getTitlName(), tId );
				return list;
			}
		}
		list = titleMapper.findTitleListBytId1(tId );
		return list;
	}

	@Override
	public int createTitle(Title title) {
		return titleMapper.insert(title);
	}

	@Override
	public List<Title> findTitleListBytId1(Title title, String tId, String titlState) {
		List<Title> list = null;
		if(title!=null) {
			if(title.getTitlName() !=null&&!"".equals(title.getTitlName())) {
				list = titleMapper.findTitleListBytId2((String)title.getTitlName(), tId ,titlState);
				return list;
			}
		}
		list = titleMapper.findTitleListBytId3(tId ,titlState);
		return list;
	}

	@Override
	public int deleteTitle(Long titlId) {
		return titleMapper.deleteByPrimaryKey(titlId);
	}

	@Override
	public List<Title1> findTitleListBytId11(String tId) {
		List<Title1> list = titleMapper.findTitleListBytId11(tId );
		return list;
	}

	@Override
	public int findTitleSum2(String major, String selState) {
		return titleMapper.findTitleSum2(major,selState);
	}

	@Override
	public List<Title1> findTitleListBytitlState(Title title) {
		List<Title1> list = null;
		if(title!=null) {
			if(title.getTitlName() !=null&&!"".equals(title.getTitlName())) {
				list = titleMapper.findTitleListBytitlState((String)title.getTitlName(), title.getMajor(),title.getTitlState() );
				return list;
			}
		}
		list = titleMapper.findTitleListBytitlState1(title.getMajor(),title.getTitlState() );
		return list;
	}

	@Override
	public List<Title1> findTitleListBytitlState1(Title title) {
		List<Title1> list = null;
		if(title!=null) {
			if(title.getTitlName() !=null&&!"".equals(title.getTitlName())) {
				list = titleMapper.findTitleListBytitlState2((String)title.getTitlName(), title.getMajor(),title.getTitlState() );
				return list;
			}
		}
		list = titleMapper.findTitleListBytitlState3(title.getMajor(),title.getTitlState() );
		return list;
	}

	@Override
	public List<Title1> findTitleListBymajor(Title title, String major) {
		List<Title1> list = null;
		if(title!=null) {
			if(title.getTitlName() !=null&&!"".equals(title.getTitlName())) {
				list = titleMapper.findTitleListBymajor((String)title.getTitlName(),major);
				return list;
			}
		}
		list = titleMapper.findTitleListBymajor1(major);
		return list;
	}

	@Override
	public List<Title1> findTitleListBymajor2(String major) {
		List<Title1> list = null;
		list = titleMapper.findTitleListBymajor2(major);
		return list;
	}

	@Override
	public int updateTitleMajor(String major, String oldName) {
		return titleMapper.updateTitleMajor(major,oldName);
	}




}

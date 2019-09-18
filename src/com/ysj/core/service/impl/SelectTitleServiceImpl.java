package com.ysj.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysj.core.dao.SelectTitleMapper;
import com.ysj.core.po.SelectTitle;
import com.ysj.core.po.SelectTitleExample;
import com.ysj.core.po.SelectTitleKey;
import com.ysj.core.po.Title;
import com.ysj.core.service.SelectTitleService;
@Service
public class SelectTitleServiceImpl implements SelectTitleService {

	@Autowired
	private SelectTitleMapper selectTitleMapper;
	
	@Override
	public int createSelectTitle(SelectTitle selectTitle) {
		return selectTitleMapper.insert(selectTitle);
	}

	@Override
	public SelectTitle getSelectTitle(SelectTitle selectTitle) {
		SelectTitleExample example = new SelectTitleExample();
		//用来封装查询条件的
		SelectTitleExample.Criteria criteria=example.createCriteria();
		criteria.andSIdEqualTo(selectTitle.getsId());
		criteria.andTitlIdEqualTo(selectTitle.getTitlId());
		List<SelectTitle> list= selectTitleMapper.selectByExample(example);
		if (list!=null&& list.size()>0) {
			 return list.get(0);
		}
		return null;
	}

	@Override
	public List<SelectTitle> findSelTitleListById(Title title, String sId) {
		List<SelectTitle> list = null;
		if(title!=null) {
			if(title.getTitlName() !=null&&!"".equals(title.getTitlName())) {
				list = selectTitleMapper.selectByExampleandSId(title.getTitlName(),sId);
				return list;
			}
		}
		return selectTitleMapper.selectBySId(sId);
		
	}

	@Override
	public int deleteCustomer(Long titlId, String sId) {
		SelectTitleKey key = new SelectTitleKey();
		key.setsId(sId);
		key.setTitlId(titlId);
		return selectTitleMapper.deleteByPrimaryKey(key);
	}

	@Override
	public int findSelectTitle(String sId) {
		return selectTitleMapper.findSelectTitle(sId);
	}

	@Override
	public List<SelectTitle> findSelTitleListBysIdAndState(String sId, String seltitl_state) {
		List<SelectTitle> list = selectTitleMapper.findSelTitleListBysIdAndState(sId,seltitl_state);
		return list;
	}

	@Override
	public int findSelTitleListByState(String major, String seltitlState) {
		return selectTitleMapper.findSelTitleListByState(major,seltitlState);
	}

	@Override
	public int findSelTitleListByState1(String seltitlState) {
		return selectTitleMapper.findSelTitleListByState1(seltitlState);
	}

	@Override
	public int findSelTitleListByState2(String tId, String seltitlState) {
		return selectTitleMapper.findSelTitleListByState2(tId,seltitlState);
	}

	@Override
	public List<Title> findSelTitleListByState3(Title title, String tId, String seltitlState ) {
		List<Title> list = null;
		if(title!=null) {
			if(title.getTitlName() !=null&&!"".equals(title.getTitlName())) {
				list = selectTitleMapper.findSelTitleListByState3((String)title.getTitlName(), tId, seltitlState);
				return list;
			}
		}
		list = selectTitleMapper.findSelTitleListByState4(tId, seltitlState);
		return list;
	}

	@Override
	public int updateSelTitle(SelectTitle selectTitle) {
		return selectTitleMapper.updateByPrimaryKeySelective(selectTitle);
	}

	@Override
	public int updateSelTitle1(SelectTitle selectTitle) {
		return selectTitleMapper.updateSelTitle1(selectTitle.getTitlId(),selectTitle.getSeltitlState());
	}

	@Override
	public SelectTitle findBytitlId(Long titlId) {
		return selectTitleMapper.findBytitlId(titlId);
	}

	@Override
	public int findSelTitle(String sId) {
		return selectTitleMapper.findSelTitle(sId);
	}

	@Override
	public int updateReplyScore(SelectTitle selectTitle) {
		return selectTitleMapper.updateReplyScore(selectTitle.getsId(),selectTitle.getTitlId(),selectTitle.getReplyScore());
	}


}

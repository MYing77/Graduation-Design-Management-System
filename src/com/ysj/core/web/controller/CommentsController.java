package com.ysj.core.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysj.core.po.Comments;
import com.ysj.core.po.Teacher;
import com.ysj.core.service.CommentsServer;
import com.ysj.core.service.MidCheckService;
import com.ysj.core.service.OpenReportService;
import com.ysj.core.service.ProjBookService;
import com.ysj.core.service.ThesisService;

@Controller
public class CommentsController {

	@Autowired
	private CommentsServer commentsServer;
	
	@Autowired
	private ProjBookService projBookService;
	
	@Autowired
	private OpenReportService openReportService;
	
	@Autowired
	private MidCheckService midCheckService;
	
	@Autowired
	private ThesisService thesisService;
	
	
	/**
	 * 查看建议详情ById
	 */
	@RequestMapping("/comments/getcommentsById.action")
	@ResponseBody
	public Comments getcommentsById(Long fId) {
		
		try {
			Comments comments =  commentsServer.getcomments(fId);
			return comments;
		}catch(Exception e) {
			return null;
		}

	}
	
	
	/**
	 * 生成建议(教师)
	 */
	@RequestMapping("/comments/createComments.action")
	@ResponseBody
	public String createComments(HttpSession session,HttpServletRequest request,Comments comments) {
		String agree = request.getParameter("agree");
		String role = request.getParameter("role");
		int rows = 0;
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String nowtime = df.format(new Date());
	        System.out.println(nowtime);// new Date()为获取当前系统时间
	        Date date = df.parse(nowtime);
	        comments.setDatetime(date);
	        comments.settId(teacher.gettId());
			rows = commentsServer.createComments(comments);
		} catch(Exception e) {
			
		}
		if(rows > 0){
			if(role.equals("任务书")) {
				projBookService.updateAgreeByfId(comments.getfId(), agree);
			}
			else if(role.equals("开题报告")) {
				openReportService.updateAgreeByfId(comments.getfId(), agree);
			}
			else if(role.equals("中期检查")) {
				midCheckService.updateAgreeByfId(comments.getfId(), agree);
			}
			else if(role.equals("论文")) {
				thesisService.updateAgreeByfId(comments.getfId(), agree);
			}
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	
}

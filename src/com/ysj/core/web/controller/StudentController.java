package com.ysj.core.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysj.core.po.MidCheck;
import com.ysj.core.po.OpenReport;
import com.ysj.core.po.ProjBook;
import com.ysj.core.po.ScoreProportion;
import com.ysj.core.po.SelectTitle;
import com.ysj.core.po.Student;
import com.ysj.core.po.Teacher;
import com.ysj.core.po.Thesis;
import com.ysj.core.po.ThesisAttachment;
import com.ysj.core.po.Title;
import com.ysj.core.service.MidCheckService;
import com.ysj.core.service.OpenReportService;
import com.ysj.core.service.ProjBookService;
import com.ysj.core.service.ScoreProportionService;
import com.ysj.core.service.SelectTitleService;
import com.ysj.core.service.StudentService;
import com.ysj.core.service.TeacherService;
import com.ysj.core.service.ThesisAttachmentService;
import com.ysj.core.service.ThesisService;
import com.ysj.core.service.TitleService;

@Controller
public class StudentController {
	
	private static final int PAGE_SIZE = 5;

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TitleService titleService;
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private SelectTitleService selectTitleService;
	
	@Autowired
	private ProjBookService projBookService;
	
	@Autowired
	private OpenReportService openReportService;
	
	@Autowired
	private MidCheckService midCheckService;
	
	@Autowired
	private ThesisService thesisService;
	
	@Autowired
	private ThesisAttachmentService thesisAttachmentService;
	
	@Autowired
	private ScoreProportionService scoreProportionService;
	
	/**
	 * 向学生主页面跳转
	 */
	@RequestMapping(value = "/student/toindex.action", method = RequestMethod.GET)
	public ModelAndView toIndex(HttpSession session) {
		Student student = (Student)session.getAttribute("USER_INFO");
		int sum = titleService.findTitleSum(student.getMajor(),"已审批");
		int s = selectTitleService.findSelTitleListByState(student.getMajor(),"同意");
		int s1 = selectTitleService.findSelTitleListByState(student.getMajor(),"待同意");
		ModelAndView mv = new ModelAndView();
		mv.addObject("sum", sum);
		mv.addObject("s", s);
		mv.addObject("s1", s1);
		mv.setViewName("views/user/student/index");
	    return mv;
	}
	
	/**
	 * 向个人信息修改页面跳转(学生)
	 */
	@RequestMapping(value = "/student/topersonInfo.action")
	public String topersonInfo(HttpSession session) {
		Student student = (Student)session.getAttribute("USER_INFO");
		student = studentService.findStudent(student.getsId(), student.getsPwd());
		session.setAttribute("USER_INFO", student);
		return "views/user/student/personInfo";
	}
	
	
	
	/**
	 * 学生信息修改
	 */
	@RequestMapping(value = "/student/editInfo.action")
	@ResponseBody
	public String editInfo(Student student) {
		int rows =0;
		try{
			rows = studentService.editInfo(student);
			}catch(Exception e){
				rows =0;
			}
		if(rows > 0){
	    	System.out.println("OK");
	        return "OK";
	    }else{
	    	System.out.println("FAIL");
	        return "FAIL";
	    }
	}
	
	/**
	 * 向密码修改页面跳转(学生)
	 */
	@RequestMapping(value = "/student/toeditPwd.action")
	public String toeditPwd(HttpSession session) {
		Student student = (Student)session.getAttribute("USER_INFO");
		student = studentService.findStudentById(student.getsId());
		session.setAttribute("USER_INFO", student);
		return "views/user/student/editPwd";
	}
	
	/**
	 * 学生密码修改
	 */
	@RequestMapping(value = "/student/editPwd.action")
	@ResponseBody
	public String editPwd(Student student) {
		int rows =0;
		try{
			rows = studentService.editInfo(student);
			}catch(Exception e){
				rows =0;
			}
		if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 向选题页面跳转(学生)
	 */
	@RequestMapping(value = "/student/totitlelist.action")
	public ModelAndView totitlelist(HttpSession session, @ModelAttribute("title") Title title,
			                                               @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		// pageNo 页码      pageSize 每页记录数
		PageHelper.startPage(pageNum, PAGE_SIZE);
		Student student = (Student)session.getAttribute("USER_INFO");
		List<Title>list = titleService.findTitleListByMajor(title ,(String)student.getMajor());
		PageInfo<Title> pageInfo = new PageInfo<>(list,5);
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", title);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("views/user/student/titlelist");
		return mv;
	}
	
	/**
	 * 查看课题详情ById(学生)
	 */
	@RequestMapping("/student/getTitleInfoById.action")
	@ResponseBody
	public Title getTitleInfoById(Long titlId) {
	    Title titleInfo = titleService.findTitleById(titlId);
	    System.out.println(titleInfo.getMajor());
	    return titleInfo;
	}

	/**
	 * 选择课题(学生)
	 */
	@RequestMapping("/student/selecttitle.action")
	@ResponseBody
	public String Selecttitle(HttpSession session, SelectTitle selectTitle) {
		Student student = (Student)session.getAttribute("USER_INFO");
		selectTitle.setsId(student.getsId());
		SelectTitle result = selectTitleService.getSelectTitle(selectTitle);
		if(result!=null) {
			return "FAIL1";
		}
		Title title = new Title();
		title.setTitlId(selectTitle.getTitlId());
		List<SelectTitle> list = selectTitleService.findSelTitleListBysIdAndState(student.getsId(), "待同意");
		if(list.size()!=0) {
			return "FAIL4" ;
		}
		list = selectTitleService.findSelTitleListBysIdAndState(student.getsId(), "同意");
		if(list.size()!=0) {
			return "FAIL2" ;
		}
		else {
			int rows = 0;
			try{
				selectTitle.setSeltitlState("待同意");
				rows = selectTitleService.createSelectTitle(selectTitle);
				}catch(Exception e){
					rows = 0;
				}
			if(rows > 0){
				System.out.println("选择课题成功！！！！");
		        return "OK";
		    }else{
		    	System.out.println("选择课题失败！！！！");
		    	return "FAIL3";
		    }
		}
	}
	
	/**
	 * 查看已选课题(学生)
	 */
	@RequestMapping("/student/selTitleById.action")
	@ResponseBody
	public ModelAndView selTitleById(HttpSession session, @ModelAttribute("title") Title title,
                                                          @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
        // pageNo 页码      pageSize 每页记录数
        PageHelper.startPage(pageNum, PAGE_SIZE);
        Student student = (Student)session.getAttribute("USER_INFO");
        List<Title>list = titleService.findTitleList(title, (String)student.getsId());
        PageInfo<Title> pageInfo = new PageInfo<>(list,5);
        ModelAndView mv = new ModelAndView();
        List<Teacher> list1 = teacherService.findTeacherBydept(student.getDept());
        int i = selectTitleService.findSelTitle(student.getsId());
        mv.addObject("title", title);
        mv.addObject("i", i);
        mv.addObject("Teacher", list1);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("views/user/student/selecttitlelist");
        return mv;
	}
	
	/**
	 * 删除已选课题(学生退选)
	 */
	@RequestMapping("/student/delTitleInfoById.action")
	@ResponseBody
	public String delTitleInfoById(HttpSession session ,Long id) {
		Student student = (Student)session.getAttribute("USER_INFO");
	    int rows = selectTitleService.deleteCustomer(id,(String)student.getsId());
	    if(rows > 0){	
	    	Title title = new Title();
			title.setTitlId(id);
			if(titleService.findTitleById(id).getTitlState().equals("待指导教师审批")) {
				titleService.deleteTitle(id);
			}
			else {
				title.setSelState("未被选择");
				titleService.updateTitleSelStateById(title);
			}
	        return "OK";
	    }else{
	        return "FAIL";			
	    }
	}
	
	/**
	 * 任务书文件列表(学生)
	 */
	@RequestMapping("/student/projBooklist.action")
	public ModelAndView projBooklist(HttpSession session ,@ModelAttribute("projBook") ProjBook projBook ,
			                                              @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, PAGE_SIZE);
		Student student = (Student)session.getAttribute("USER_INFO");
		List<ProjBook>list = projBookService.findProjBookList(projBook, (String)student.getsId());
		int i = selectTitleService.findSelectTitle(student.getsId());
		List<ProjBook> list2 = projBookService.findProjBookBysIdAndAgree(student.getsId(), "通过");
		int i2 = 0;
		if(list2.size()!=0) {
			i2 = 1;
		}
		PageInfo<ProjBook> pageInfo = new PageInfo<>(list,5);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("i", i);
        mv.addObject("i2", i2);
        mv.setViewName("views/user/student/projbooklist");
		return mv;
	}
	
	
	/**
	 * 开题报告文件列表(学生)
	 */
	@RequestMapping("/student/openReportlist.action")
	public ModelAndView openReportlist(HttpSession session ,@ModelAttribute("openReport") OpenReport openReport ,
			                                              @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, PAGE_SIZE);
		Student student = (Student)session.getAttribute("USER_INFO");
		List<OpenReport>list = openReportService.findOpenReportList(openReport, (String)student.getsId());
		List<ProjBook> list2 = projBookService.findProjBookBysIdAndAgree(student.getsId(), "通过");
		List<OpenReport> list3 = openReportService.findOpenReportBysIdAndAgree(student.getsId(), "通过");
		int i = 0;
		int i2 = 0;
		if(list2.size()!=0) {
			i = 1;
		}
		if(list3.size()!=0) {
			i2 = 1;
		}
		PageInfo<OpenReport> pageInfo = new PageInfo<>(list,5);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("i", i);
        mv.addObject("i2", i2);
        mv.setViewName("views/user/student/openReportlist");
		return mv;
	}
	
	/**
	 * 中期检查文件列表(学生)
	 */
	@RequestMapping("/student/midChecklist.action")
	public ModelAndView midChecklist(HttpSession session ,@ModelAttribute("midCheck") MidCheck midCheck ,
			                                              @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, PAGE_SIZE);
		Student student = (Student)session.getAttribute("USER_INFO");
		List<MidCheck>list = midCheckService.findMidCheckList(midCheck, (String)student.getsId());
		List<OpenReport> list2 = openReportService.findOpenReportBysIdAndAgree(student.getsId(), "通过");
		List<MidCheck> list3 = midCheckService.findMidCheckBysIdAndAgree(student.getsId(), "通过");
		int i = 0;
		int i2 = 0;
		if(list2.size()!=0) {
			i = 1;
		}
		if(list3.size()!=0) {
			i2 = 1;
		}
		PageInfo<MidCheck> pageInfo = new PageInfo<>(list,5);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("i", i);
        mv.addObject("i2", i2);
        mv.setViewName("views/user/student/midchecklist");
		return mv;
	}
	
	/**
	 * 论文文件列表(学生)
	 */
	@RequestMapping("/student/thesislist.action")
	public ModelAndView thesislist(HttpSession session ,@ModelAttribute("thesis") Thesis thesis ,
			                                              @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, PAGE_SIZE);
		Student student = (Student)session.getAttribute("USER_INFO");
		List<Thesis>list = thesisService.findThesisList(thesis, (String)student.getsId());
		List<MidCheck> list2 = midCheckService.findMidCheckBysIdAndAgree(student.getsId(), "通过");
		List<Thesis> list3 = thesisService.findThesisBysIdAndAgree(student.getsId(), "通过");
		int i = 0;
		int i2 = 0;
		if(list2.size()!=0) {
			i = 1;
		}
		if(list3.size()!=0) {
			i2 = 1;
		}
		PageInfo<Thesis> pageInfo = new PageInfo<>(list,5);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("i", i);
        mv.addObject("i2", i2);
        mv.setViewName("views/user/student/thesislist");
		return mv;
	}
	
	/**
	 * 附件列表(学生)
	 */
	@RequestMapping("/student/thesisAttachmentlist.action")
	public ModelAndView thesisAttachmentlist(HttpSession session ,@ModelAttribute("thesisAttachment") ThesisAttachment thesisAttachment ,
			                                              @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, PAGE_SIZE);
		Student student = (Student)session.getAttribute("USER_INFO");
		List<ThesisAttachment>list = thesisAttachmentService.findThesisAttachmentList(thesisAttachment, (String)student.getsId());
		List<Thesis> list3 = thesisService.findThesisBysIdAndAgree(student.getsId(), "通过");
		int i2 = 0;
		if(list3.size()!=0) {
			i2 = 1;
		}
		PageInfo<ThesisAttachment> pageInfo = new PageInfo<>(list,5);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.addObject("i2", i2);
        mv.setViewName("views/user/student/thesisAttachmentlist");
		return mv;
	}
	
	/**
	 * 成绩总评(学生)
	 */
	@RequestMapping("/student/studentScore.action")
	public ModelAndView studentScore (HttpSession session,@RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum){
		Student student = (Student)session.getAttribute("USER_INFO");
		List<SelectTitle> list = selectTitleService.findSelTitleListBysIdAndState(student.getsId(), "同意");
		ScoreProportion scoreProportion = scoreProportionService.getScoreProportion("1");
		ModelAndView mv = new ModelAndView();
		PageInfo<SelectTitle> pageInfo = new PageInfo<>(list,5);
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("scoreProportion", scoreProportion);
		mv.setViewName("views/user/student/studentscore");
		return mv;
	}
	
}

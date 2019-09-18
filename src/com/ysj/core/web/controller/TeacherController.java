package com.ysj.core.web.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ysj.core.po.BaseDept;
import com.ysj.core.po.BaseMajor;
import com.ysj.core.po.MidCheck;
import com.ysj.core.po.OpenReport;
import com.ysj.core.po.ProjBook;
import com.ysj.core.po.ReplyGroup;
import com.ysj.core.po.Review;
import com.ysj.core.po.Review1;
import com.ysj.core.po.ScoreProportion;
import com.ysj.core.po.SelectTitle;
import com.ysj.core.po.Student;
import com.ysj.core.po.Teacher;
import com.ysj.core.po.Thesis;
import com.ysj.core.po.ThesisAttachment;
import com.ysj.core.po.Title;
import com.ysj.core.po.Title1;
import com.ysj.core.service.BaseMajorService;
import com.ysj.core.service.MidCheckService;
import com.ysj.core.service.OpenReportService;
import com.ysj.core.service.ProjBookService;
import com.ysj.core.service.ReplyGroupService;
import com.ysj.core.service.ReviewService;
import com.ysj.core.service.ScoreProportionService;
import com.ysj.core.service.SelectTitleService;
import com.ysj.core.service.StudentService;
import com.ysj.core.service.TeacherService;
import com.ysj.core.service.ThesisAttachmentService;
import com.ysj.core.service.ThesisService;
import com.ysj.core.service.TitleService;

@Controller
public class TeacherController {
	
	private static final int PAGE_SIZE = 5;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private BaseMajorService baseMajorService;
	
	@Autowired
	private TitleService titleService;
	
	@Autowired
	private StudentService studentService;
	
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
	private ReplyGroupService replyGroupService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private ScoreProportionService scoreProportionService;
	
	@InitBinder
	 protected void initBinder(WebDataBinder binder) {
	     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	 }
	
	/**
	 * 向教师权限选择页面跳转
	 */
	@RequestMapping(value = "/teacher/roleset.action", method = RequestMethod.GET)
	public String roleset(HttpSession session) {
		return "views/user/teacher/roleset";
	}
	
	/**
	 * 向教师主页面跳转
	 */
	@RequestMapping(value = "/teacher/toindex.action", method = RequestMethod.GET)
	public ModelAndView toIndex(HttpSession session) {
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		int sum = titleService.findTitleSum1(teacher.gettId(),"已审批");
		int s = selectTitleService.findSelTitleListByState2(teacher.gettId(),"同意");
		int s1 = selectTitleService.findSelTitleListByState2(teacher.gettId(),"待同意");
		int sumProjBook = 0;
		int sumOpenReport = 0;
		int sumMidCheck = 0;
		int sumThesis = 0;
		List<ProjBook> list = projBookService.findProjBookBytIdAndAgree1(null, teacher.gettId(), "通过");
		if(list!=null) {
			sumProjBook = list.size();
		}
		List<OpenReport> list1 = openReportService.findOpenReportBytIdAndAgree1(null, teacher.gettId(), "通过");
		if(list1!=null) {
			sumOpenReport = list1.size();
		}
		List<MidCheck> list2 = midCheckService.findMidCheckBytIdAndAgree1(null, teacher.gettId(), "通过");
		if(list2!=null) {
			sumMidCheck = list2.size();
		}
		List<Thesis> list3 = thesisService.findThesisBytIdAndAgree1(null, teacher.gettId(), "通过");
		if(list3!=null) {
			sumThesis = list3.size();
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("sum", sum);
		mv.addObject("s", s);
		mv.addObject("s1", s1);
		mv.addObject("sumProjBook", sumProjBook);
		mv.addObject("sumOpenReport", sumOpenReport);
		mv.addObject("sumMidCheck", sumMidCheck);
		mv.addObject("sumThesis", sumThesis);
		mv.setViewName("views/user/teacher/index");
	    return mv;
	}
	
	/**
	 * 向教师课题页面跳转
	 */
	@RequestMapping(value = "/teacher/totitlelist.action")
	public ModelAndView totitlelist(HttpSession session, @ModelAttribute("title") Title title,
			                                               @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		// pageNo 页码      pageSize 每页记录数
		PageHelper.startPage(pageNum, PAGE_SIZE);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<Title1>list = titleService.findTitleListBytId(title ,(String)teacher.gettId());
		List <BaseMajor> list1 = baseMajorService.findMajorBydeptId(teacher.getDeptId());
		PageInfo<Title1> pageInfo = new PageInfo<>(list,5);
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", title);
		mv.addObject("BaseMajor", list1);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("views/user/teacher/titlelist");
		return mv;
	}
	
	/**
	 * 获取选题学生信息
	 */
	@RequestMapping(value = "/teacher/getStudentInfoById.action")
	@ResponseBody
	public Student getStudentInfoById(String sId) {
		Student student = studentService.findStudentById(sId);
		return student;
	}
	
	/**
	 * 删除课题(教师)
	 */
	@RequestMapping(value = "/teacher/titledelete.action")
	@ResponseBody
	public String titledelete(Long titlId) {
		int rows = titleService.deleteTitle(titlId);
	    if(rows > 0){			
	        return "OK";
	    }else{
	        return "FAIL";			
	    }
	}
	
	/**
	 * 教师申请新课题
	 */
	@RequestMapping("/teacher/createTitle.action")
	@ResponseBody
	public String createTitle(Title title,HttpSession session) {
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		title.settId(teacher.gettId());
		title.setTitlState("待审批");
		title.setSelState("未被选择");
	    int rows = titleService.createTitle(title);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 学生申请新课题
	 */
	@RequestMapping("/teacher/createTitle1.action")
	@ResponseBody
	public String createTitle1(Title title) {
		String sId = title.getsId();
		title.setTitlState("待指导教师审批");
		title.setSelState("已被选择");
		title.setsId(null);
	    int rows = titleService.createTitle(title);
	    System.out.println(title.getTitlId());
	    if(rows > 0){
	    	SelectTitle selectTitle = new SelectTitle();
	    	selectTitle.setsId(sId);
	    	selectTitle.setTitlId(title.getTitlId());
	    	selectTitle.setSeltitlState("待同意");
	    	selectTitleService.createSelectTitle(selectTitle);
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 向选题学生页面跳转
	 */
	@RequestMapping(value = "/teacher/toSelecttitlelist.action")
	public ModelAndView toSelecttitlelist(HttpSession session, @ModelAttribute("title") Title title,
			                                                   @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		// pageNo 页码      pageSize 每页记录数
		PageHelper.startPage(pageNum, PAGE_SIZE);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<Title> list = selectTitleService.findSelTitleListByState3(title, teacher.gettId(), "待同意");
		PageInfo<Title> pageInfo = new PageInfo<>(list,5);
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", title);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("views/user/teacher/selectTitlelist");
		return mv;
	}
	
	/**
	 * 对学生选题情况进行操作
	 */
	@RequestMapping(value = "/teacher/editSelTitle.action")
	@ResponseBody
	public String editSelTitle(SelectTitle selectTitle) {
		String titlState = titleService.findTitleById(selectTitle.getTitlId()).getTitlState();
		int rows = selectTitleService.updateSelTitle(selectTitle);
		if(rows > 0){
			Title title = new Title();
			title.setTitlId(selectTitle.getTitlId());
			if(selectTitle.getSeltitlState().equals("同意") && titlState.equals("待指导教师审批")) {
				title.setTitlState("待审批");
				titleService.updateTitleById(title);
				SelectTitle selectTitle2 = new SelectTitle();
				selectTitle2.setsId(selectTitle.getsId());
				selectTitle2.setTitlId(selectTitle.getTitlId());
				selectTitle2.setSeltitlState("待专业负责人审批");
				selectTitleService.updateSelTitle(selectTitle2);
			}
			if(selectTitle.getSeltitlState().equals("同意")) {
				title.setSelState("已被选择");
				titleService.updateTitleSelStateById(title);
				SelectTitle selectTitle1 = new SelectTitle();
				selectTitle1.setTitlId(selectTitle.getTitlId());
				selectTitle1.setSeltitlState("待同意");
				selectTitleService.updateSelTitle1(selectTitle1);
			}
			if(selectTitle.getSeltitlState().equals("拒绝") && titlState.equals("待指导教师审批")) {
				title.setTitlState("审批不通过");
				titleService.updateTitleById(title);
			}
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 学生任务书列表(已审核)
	 */
	@RequestMapping("/teacher/projBooklist.action")
	public ModelAndView projBooklist(HttpSession session ,@ModelAttribute("projBook") ProjBook projBook ,
			                                              @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, PAGE_SIZE);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<ProjBook>list = projBookService.findProjBookBytIdAndAgree(projBook, teacher.gettId(),"待通过");
		PageInfo<ProjBook> pageInfo = new PageInfo<>(list,5);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("views/user/teacher/projbooklist");
		return mv;
	}
	
	/**
	 * 学生任务书列表(待审核)
	 */
	@RequestMapping("/teacher/projBooklist1.action")
	public ModelAndView projBooklist1(HttpSession session ,@ModelAttribute("projBook") ProjBook projBook ,
			                                              @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, PAGE_SIZE);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<ProjBook>list = projBookService.findProjBookBytIdAndAgree1(projBook, teacher.gettId(),"待通过");
		PageInfo<ProjBook> pageInfo = new PageInfo<>(list,5);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("views/user/teacher/projbooklist1");
		return mv;
	}
	
	/**
	 * 学生开题报告列表(已审核)
	 */
	@RequestMapping("/teacher/openReportlist.action")
	public ModelAndView openReportlist(HttpSession session ,@ModelAttribute("openReport") OpenReport openReport ,
                                                            @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, PAGE_SIZE);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<OpenReport>list = openReportService.findOpenReportBytIdAndAgree(openReport, teacher.gettId(),"待通过");
		PageInfo<OpenReport> pageInfo = new PageInfo<>(list,5);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("views/user/teacher/openReportlist");
		return mv;
	}
	
	/**
	 * 学生开题报告列表(待审核)
	 */
	@RequestMapping("/teacher/openReportlist1.action")
	public ModelAndView openReportlist1(HttpSession session ,@ModelAttribute("openReport") OpenReport openReport ,
                                                            @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, PAGE_SIZE);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<OpenReport>list = openReportService.findOpenReportBytIdAndAgree1(openReport, teacher.gettId(),"待通过");
		PageInfo<OpenReport> pageInfo = new PageInfo<>(list,5);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("views/user/teacher/openReportlist1");
		return mv;
	}
	
	/**
	 * 学生中期检查列表(已审核)
	 */
	@RequestMapping("/teacher/midChecklist.action")
	public ModelAndView midChecklist(HttpSession session ,@ModelAttribute("midCheck") MidCheck midCheck ,
                                                            @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, PAGE_SIZE);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<MidCheck>list = midCheckService.findMidCheckBytIdAndAgree(midCheck, teacher.gettId(),"待通过");
		PageInfo<MidCheck> pageInfo = new PageInfo<>(list,5);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("views/user/teacher/midChecklist");
		return mv;
	}
	
	/**
	 * 学生中期检查列表(待审核)
	 */
	@RequestMapping("/teacher/midChecklist1.action")
	public ModelAndView midChecklist1(HttpSession session ,@ModelAttribute("midCheck") MidCheck midCheck ,
                                                            @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, PAGE_SIZE);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<MidCheck>list = midCheckService.findMidCheckBytIdAndAgree1(midCheck, teacher.gettId(),"待通过");
		PageInfo<MidCheck> pageInfo = new PageInfo<>(list,5);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("views/user/teacher/midChecklist1");
		return mv;
	}
	
	/**
	 * 学生论文列表(已审核)
	 */
	@RequestMapping("/teacher/thesislist.action")
	public ModelAndView thesislist(HttpSession session ,@ModelAttribute("thesis") Thesis thesis ,
                                                            @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, PAGE_SIZE);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<Thesis>list = thesisService.findThesisBytIdAndAgree(thesis, teacher.gettId(),"待通过");
		PageInfo<Thesis> pageInfo = new PageInfo<>(list,5);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("views/user/teacher/thesislist");
		return mv;
	}
	
	/**
	 * 学生论文列表(待审核)
	 */
	@RequestMapping("/teacher/thesislist1.action")
	public ModelAndView thesislist1(HttpSession session ,@ModelAttribute("thesis") Thesis thesis ,
                                                            @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, PAGE_SIZE);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<Thesis>list = thesisService.findThesisBytIdAndAgree1(thesis, teacher.gettId(),"待通过");
		PageInfo<Thesis> pageInfo = new PageInfo<>(list,5);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("views/user/teacher/thesislist1");
		return mv;
	}
	
	/**
	 * 学生附件列表
	 */
	@RequestMapping("/teacher/thesisAttachmentlist.action")
	public ModelAndView thesisAttachmentlist(HttpSession session ,@ModelAttribute("thesisAttachment") ThesisAttachment thesisAttachment ,
			                                              @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, PAGE_SIZE);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<ThesisAttachment>list = thesisAttachmentService.findThesisAttachmentList1(thesisAttachment, (String)teacher.gettId());
		PageInfo<ThesisAttachment> pageInfo = new PageInfo<>(list,5);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("views/user/teacher/thesisAttachmentlist");
		return mv;
	}
	
	/**
	 * 学生成绩总评(教师视图)
	 */
	@RequestMapping("/teacher/studentScore.action")
	public ModelAndView studentScore (HttpSession session,@RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum){
		PageHelper.startPage(pageNum, 10);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<Title1>list = titleService.findTitleListBytId11((String)teacher.gettId());
		ScoreProportion scoreProportion = scoreProportionService.getScoreProportion("1");
		PageInfo<Title1> pageInfo = new PageInfo<>(list,10);
		ModelAndView mv = new ModelAndView();
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("scoreProportion", scoreProportion);
		mv.setViewName("views/user/teacher/studentscore");
		return mv;
	}
	
	/**
	 * 修改评语和学生成绩(教师视图)
	 */
	@RequestMapping("/teacher/editStudentScore.action")
	@ResponseBody
	public String studentScore (SelectTitle selectTitle){
		System.out.println(selectTitle.getsId());
		System.out.println(selectTitle.getTitlId());
		System.out.println(selectTitle.gettScore());
		int rows = 0;
		try {
			rows = selectTitleService.updateSelTitle(selectTitle);
		} catch(Exception e) {
			
		}
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 向个人信息修改页面跳转(教师)
	 */
	@RequestMapping(value = "/teacher/topersonInfo.action")
	public String topersonInfo(HttpSession session) {
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		teacher = teacherService.findTeacher(teacher.gettId(), teacher.gettPwd());
		session.setAttribute("USER_INFO", teacher);
		return "views/user/teacher/personInfo";
	}
	
	/**
	 * 教师信息修改
	 */
	@RequestMapping(value = "/teacher/editInfo.action")
	@ResponseBody
	public String editInfo(Teacher teacher) {
		int rows =0;
		try{
			rows = teacherService.editInfo(teacher);
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
	 * 向密码修改页面跳转(教师)
	 */
	@RequestMapping(value = "/teacher/toeditPwd.action")
	public String toeditPwd(HttpSession session) {
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		teacher = teacherService.findTeacherById(teacher.gettId());
		session.setAttribute("USER_INFO", teacher);
		return "views/user/teacher/editPwd";
	}
	
	/**
	 * 教师密码修改
	 */
	@RequestMapping(value = "/teacher/editPwd.action")
	@ResponseBody
	public String editPwd(Teacher teacher) {
		int rows =0;
		try{
			rows = teacherService.editInfo(teacher);
			}catch(Exception e){
				
			}
		if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}

	/**
	 * 向专业负责人页面跳转
	 */
	@RequestMapping(value = "/teacher/leading/Index.action", method = RequestMethod.GET)
	public ModelAndView Index(HttpSession session) {
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		int sum = studentService.findStudentSum(teacher.getMajor());
		int s = titleService.findTitleSum2(teacher.getMajor(),"已被选择");
		int s1 = sum - s;
		int sumProjBook = 0;
		int sumOpenReport = 0;
		int sumMidCheck = 0;
		int sumThesis = 0;
		List<ProjBook> list = projBookService.findProjBookByMajorAndAgree(null, teacher.getMajor(), "通过");
		if(list!=null) {
			sumProjBook = list.size();
		}
		List<OpenReport> list1 = openReportService.findOpenReportByMajorAndAgree(null, teacher.getMajor(), "通过");
		if(list1!=null) {
			sumOpenReport = list1.size();
		}
		List<MidCheck> list2 = midCheckService.findMidCheckByMajorAndAgree(null, teacher.getMajor(), "通过");
		if(list2!=null) {
			sumMidCheck = list2.size();
		}
		List<Thesis> list3 = thesisService.findThesisByMajorAndAgree(null, teacher.getMajor(), "通过");
		if(list3!=null) {
			sumThesis = list3.size();
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("sum", sum);
		mv.addObject("s", s);
		mv.addObject("s1", s1);
		mv.addObject("sumProjBook",sumProjBook);
		mv.addObject("sumOpenReport",sumOpenReport);
		mv.addObject("sumMidCheck",sumMidCheck);
		mv.addObject("sumThesis",sumThesis);
		mv.setViewName("views/user/teacher/leading/Index");
	    return mv;
	}
	
	/**
	 * 向已审核课题页面跳转
	 */
	@RequestMapping(value = "/teacher/leading/totitlelist.action")
	public ModelAndView titlelist(HttpSession session, @ModelAttribute("title") Title title,
			                                               @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		// pageNo 页码      pageSize 每页记录数
		PageHelper.startPage(pageNum, 10);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		title.setMajor(teacher.getMajor());
		title.setTitlState("待审批");
		List<Title1>list = titleService.findTitleListBytitlState(title);
		List<Student> list1= studentService.findStudnetBySeltitlState(teacher.getMajor());
		PageInfo<Title1> pageInfo = new PageInfo<>(list,10);
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", title);
		mv.addObject("list1", list1);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("views/user/teacher/leading/titlelist");
		return mv;
	}
	
	/**
	 * 向待审核课题页面跳转
	 */
	@RequestMapping(value = "/teacher/leading/totitlelist1.action")
	public ModelAndView titlelist1(HttpSession session, @ModelAttribute("title") Title title,
			                                               @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		// pageNo 页码      pageSize 每页记录数
		PageHelper.startPage(pageNum, 10);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		title.setMajor(teacher.getMajor());
		title.setTitlState("待审批");
		List<Title1>list = titleService.findTitleListBytitlState1(title);
		PageInfo<Title1> pageInfo = new PageInfo<>(list,10);
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", title);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("views/user/teacher/leading/titlelist1");
		return mv;
	}
	
	/**
	 * 专业负责人审核课题
	 */
	@RequestMapping(value = "/teacher/leading/checkTitle.action")
	@ResponseBody
	public String checkTitle(Title title) {
		SelectTitle selectTitle = new SelectTitle();
		selectTitle = selectTitleService.findBytitlId(title.getTitlId());
		if(selectTitle!=null) {
			if(title.getTitlState().equals("审批不通过") && selectTitle.getSeltitlState().equals("待专业负责人审批")) {
				selectTitle.setSeltitlState("拒绝");
				selectTitleService.updateSelTitle(selectTitle);
			}
			if(title.getTitlState().equals("已审批") && selectTitle.getSeltitlState().equals("待专业负责人审批")) {
				selectTitle.setSeltitlState("同意");
				selectTitleService.updateSelTitle(selectTitle);
			}
		}
		int rows = titleService.updateTitleById(title);
		if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 给本专业未选择课题的学生手动分配课题
	 */
	@RequestMapping(value = "/teacher/leading/setStudent.action")
	@ResponseBody
	public String setStudent(HttpSession session,HttpServletRequest request,SelectTitle selectTitle) {
		selectTitle.setSeltitlState("同意");
		int rows =0;
		try{
			rows = selectTitleService.createSelectTitle(selectTitle);
			}catch(Exception e){
				
			}
		if(rows > 0){
			Title title = new Title();
			title.setTitlId(selectTitle.getTitlId());
			title.setSelState("已被选择");
			titleService.updateTitleSelStateById(title);
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 查询已被指导教师审核通过的任务书
	 */
	@RequestMapping("/teacher/leading/projBooklist.action")
	public ModelAndView ProjBooklist(HttpSession session ,@ModelAttribute("projBook") ProjBook projBook ,
			                                              @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, 10);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<ProjBook>list = projBookService.findProjBookByMajorAndAgree(projBook, teacher.getMajor(), "通过");
		PageInfo<ProjBook> pageInfo = new PageInfo<>(list,10);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("views/user/teacher/leading/projbooklist");
		return mv;
	}
	
	/**
	 * 查询已被指导教师审核通过的开题报告
	 */
	@RequestMapping("/teacher/leading/openReportlist.action")
	public ModelAndView OpenReportlist(HttpSession session ,@ModelAttribute("openReport") OpenReport openReport ,
                                                            @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, 10);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<OpenReport>list = openReportService.findOpenReportByMajorAndAgree(openReport, teacher.getMajor(),"通过");
		PageInfo<OpenReport> pageInfo = new PageInfo<>(list,10);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("views/user/teacher/leading/openReportlist");
		return mv;
	}

	/**
	 * 查询已被指导教师审核通过的中期检查
	 */
	@RequestMapping("/teacher/leading/midChecklist.action")
	public ModelAndView MidCheckList(HttpSession session ,@ModelAttribute("midCheck") MidCheck midCheck ,
                                                            @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, 10);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<MidCheck>list = midCheckService.findMidCheckByMajorAndAgree(midCheck, teacher.getMajor(),"通过");
		PageInfo<MidCheck> pageInfo = new PageInfo<>(list,10);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("views/user/teacher/leading/midChecklist");
		return mv;
	}
	
	/**
	 * 查询已被指导教师审核通过的论文
	 */
	@RequestMapping("/teacher/leading/thesislist.action")
	public ModelAndView Thesislist(HttpSession session ,@ModelAttribute("thesis") Thesis thesis ,
                                                            @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, 10);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<Thesis>list = thesisService.findThesisByMajorAndAgree(thesis, teacher.getMajor(),"通过");
		PageInfo<Thesis> pageInfo = new PageInfo<>(list,10);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("views/user/teacher/leading/thesislist");
		return mv;
	}
	
	/**
	 * 查询学生上传的论文附件
	 */
	@RequestMapping("/teacher/leading/thesisAttachmentlist.action")
	public ModelAndView ThesisAttachmentlist(HttpSession session ,@ModelAttribute("thesisAttachment") ThesisAttachment thesisAttachment ,
			                                              @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, 10);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<ThesisAttachment>list = thesisAttachmentService.findThesisAttachmentListByMajor(thesisAttachment, (String)teacher.getMajor());
		PageInfo<ThesisAttachment> pageInfo = new PageInfo<>(list,10);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("views/user/teacher/leading/thesisAttachmentlist");
		return mv;
	}
	
	/**
	 * 学生成绩总评(专业负责人视图)
	 */
	@RequestMapping("/teacher/leading/studentScore.action")
	public ModelAndView StudentScore (HttpSession session,@ModelAttribute("title") Title title,
			                                              @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum){
		PageHelper.startPage(pageNum, 10);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<Title1>list = titleService.findTitleListBymajor(title,teacher.getMajor());
		ScoreProportion scoreProportion = scoreProportionService.getScoreProportion("1");
		PageInfo<Title1> pageInfo = new PageInfo<>(list,10);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("scoreProportion", scoreProportion);
		mv.setViewName("views/user/teacher/leading/studentScore");
		return mv;
	}
	
	/**
	 * 修改答辩评语和学生成绩(专业负责人视图)
	 */
	@RequestMapping("/teacher/leading/editStudentScore.action")
	@ResponseBody
	public String editStudentScore (SelectTitle selectTitle){
		int rows = 0;
		try {
			rows = selectTitleService.updateSelTitle(selectTitle);
		} catch(Exception e) {
			
		}
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 向答辩安排页面跳转(专业负责人)
	 */
	@RequestMapping(value = "/teacher/leading/toreply.action")
	public ModelAndView reply(HttpSession session,@RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, 10);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List <ReplyGroup> list = replyGroupService.replyGrouplist(teacher.gettId());
		PageInfo<ReplyGroup> pageInfo = new PageInfo<>(list,10);
		ModelAndView mv = new ModelAndView();
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("views/user/teacher/leading/reply");
		return mv;
	}
	
	/**
	 * 向创建答辩组页面跳转(专业负责人)
	 */
	@RequestMapping(value = "/teacher/leading/tocreateReply.action")
	public ModelAndView tocreateReply(HttpSession session) {
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List<Teacher> list= teacherService.findTeacherBydept(teacher.getDept());
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("views/user/teacher/leading/newReply");
		return mv;
	}
	
	/**
	 * 创建答辩组(专业负责人)
	 */
	@RequestMapping(value = "/teacher/leading/createReply.action")
	@ResponseBody
	public String createReply(ReplyGroup replyGroup) {
		
		int rows = 0;
		try {
			rows = replyGroupService.createReply(replyGroup);
		}catch(Exception e) {
			rows = 0;
		}
	    if(rows > 0){
	    	String replyMember = replyGroup.getReplyMember();
			int l = replyMember.length();
			String s = replyMember.replaceAll(",","");
			int ll = s.length();
			int cc = l - ll + 1;
			String []member = new String[2];
			for(int i = 0;i < cc;i++) {
				member[i] = replyMember.substring(0, replyMember.indexOf(" "));
				System.out.println("评阅教师"+member[i]);
				replyMember = replyMember.substring(replyMember.indexOf(",") + 1,replyMember.length()-1);
			}
			String replyStudent = replyGroup.getReplyStudent();
			int l1 = replyStudent.length();
			String s1 = replyStudent.replaceAll(",","");
			int l2 = s1.length();
			int c = l1 - l2 + 1;
			String []student = new String[4];
			for(int i = 0;i < c;i++) {
				student[i] = replyStudent.substring(0, replyStudent.indexOf(" "));
				List<Thesis> list = thesisService.findThesisBytIdAndAgreeAndBatch(student[i], "通过",replyGroup.getBatch());
				for(int m = 0;m < list.size();m++) {
					Review review = new Review();
					review.setsId(list.get(m).getsId());
					review.setMemberTId(replyGroup.getReplyLeader().substring(0, replyGroup.getReplyLeader().indexOf(" ")));
					review.setReplyId(replyGroup.getReplyId());
					review.setReviewScore(0);
					review.setReviewType("答辩组长评分");
					reviewService.insertReview(review);
				}
				for(int j = 0;j < cc;j++) {
					for(int k = 0;k < list.size();k++) {
						Review review = new Review();
						review.setsId(list.get(k).getsId());
						review.setMemberTId(member[j]);
						review.setReplyId(replyGroup.getReplyId());
						review.setReviewScore(0);
						review.setReviewType("评阅教师评分");
						reviewService.insertReview(review);
					}
				}
				System.out.println("答辩学生"+student[i]+"所带学生");
				replyStudent = replyStudent.substring(replyStudent.indexOf(",") + 1,replyStudent.length()-1);
			}
	        return "OK";
	        
	    }else{
	        return "FAIL";
	    }
	}
	/**
	 * 删除答辩组(专业负责人)
	 */
	@RequestMapping(value = "/teacher/leading/replydelete.action")
	@ResponseBody
	public String replydelete(String replyId) {
		int rows = replyGroupService.deleteReply(replyId);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 向个人信息修改页面跳转(专业负责人)
	 */
	@RequestMapping(value = "/teacher/leading/topersonInfo.action")
	public String TopersonInfo(HttpSession session) {
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		teacher = teacherService.findTeacher(teacher.gettId(), teacher.gettPwd());
		session.setAttribute("USER_INFO", teacher);
		return "views/user/teacher/leading/personInfo";
	}	
	
	/**
	 * 向密码修改页面跳转(专业负责人)
	 */
	@RequestMapping(value = "/teacher/leading/toeditPwd.action")
	public String ToeditPwd(HttpSession session) {
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		teacher = teacherService.findTeacherById(teacher.gettId());
		session.setAttribute("USER_INFO", teacher);
		return "views/user/teacher/leading/editPwd";
	}
	
	// 导出学生成绩信息
	@RequestMapping("/teacher/leading/export.action")
	public void export(HttpSession session,HttpServletResponse response) {
		
	HSSFWorkbook book = new HSSFWorkbook();
	//创建sheet
	HSSFSheet sheet = book.createSheet("学生成绩表");
	sheet.setDefaultColumnWidth(15);
	sheet.setColumnWidth(3, 40*256);
	sheet.setColumnWidth(5, 40*256);
	sheet.setColumnWidth(8, 40*256);
	sheet.setColumnWidth(11, 40*256);
	sheet.setColumnWidth(14, 40*256);

	//创建标题列
	HSSFRow titleRow = sheet.createRow(0);
	//创建表单单元格并设置值
	titleRow.createCell(0).setCellValue("编号");
	titleRow.createCell(1).setCellValue("学号");
	titleRow.createCell(2).setCellValue("学生姓名");
	titleRow.createCell(3).setCellValue("题目");
	titleRow.createCell(4).setCellValue("指导教师");
	titleRow.createCell(5).setCellValue("指导教师评语");
	titleRow.createCell(6).setCellValue("指导教师评分");
	titleRow.createCell(7).setCellValue("答辩组组长");
	titleRow.createCell(8).setCellValue("答辩组组长评语");
	titleRow.createCell(9).setCellValue("答辩组组长评分");
	titleRow.createCell(10).setCellValue("评阅教师");
	titleRow.createCell(11).setCellValue("评阅教师评语");
	titleRow.createCell(12).setCellValue("评阅教师评分");
	titleRow.createCell(13).setCellValue("评阅教师");
	titleRow.createCell(14).setCellValue("评阅教师评语");
	titleRow.createCell(15).setCellValue("评阅教师评分");
	titleRow.createCell(16).setCellValue("总成绩");
	
	Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
	List<Title1>list = titleService.findTitleListBymajor2(teacher.getMajor());

	for (int i = 0; i < list.size(); i++) {

	Title1 title = list.get(i);

	HSSFRow row = sheet.createRow(i+1);
	
	row.createCell(0).setCellValue(i+1);
	row.createCell(1).setCellValue(title.getsId());
	row.createCell(2).setCellValue(title.getsName());
	row.createCell(3).setCellValue(title.getTitlName());
	row.createCell(4).setCellValue(title.gettName());
	if(title.gettComments()==null) {
		row.createCell(5).setCellValue("");
	}else {
		row.createCell(5).setCellValue(title.gettComments());
	}
	if(title.gettScore()==0) {
		row.createCell(6).setCellValue("");
	}else {
		row.createCell(6).setCellValue(title.gettScore());
	}
	
	if(title.getReplyScore()==null) {
		row.createCell(7).setCellValue("");
		row.createCell(8).setCellValue("");
		row.createCell(9).setCellValue("");
		row.createCell(10).setCellValue("");
		row.createCell(11).setCellValue("");
		row.createCell(12).setCellValue("");
		row.createCell(13).setCellValue("");
		row.createCell(14).setCellValue("");
		row.createCell(15).setCellValue("");
	}else {
		List<Review1> list1 = reviewService.findBySId(title.getsId());
		row.createCell(7).setCellValue(list1.get(0).getMemberTName());
		row.createCell(8).setCellValue(list1.get(0).getReviewComments());
		row.createCell(9).setCellValue(list1.get(0).getReviewScore());
		row.createCell(10).setCellValue(list1.get(1).getMemberTName());
		row.createCell(11).setCellValue(list1.get(1).getReviewComments());
		row.createCell(12).setCellValue(list1.get(1).getReviewScore());
		row.createCell(13).setCellValue(list1.get(2).getMemberTName());
		row.createCell(14).setCellValue(list1.get(2).getReviewComments());
		row.createCell(15).setCellValue(list1.get(2).getReviewScore());
	}
	
	if(title.gettScore()==0 ||title.getReplyScore()==null) {
		row.createCell(16).setCellValue("成绩未全");
	}
	else {
		row.createCell(16).setCellValue(title.gettScore()*0.5 + title.getReplyScore());
	}
	
	}

	try {
	//设置响应头,响应的内容是为附件形式
	response.addHeader("Content-Disposition",
	"attachment;filename=" + new String("学生成绩表.xls".getBytes(), "ISO-8859-1"));
	book.write(response.getOutputStream());
	} catch (Exception e) {
	e.printStackTrace();
	}
	}

	/**
	 * 向评阅教师页面跳转
	 */
	@RequestMapping(value = "/teacher/toreview.action")
	public ModelAndView review(HttpSession session,@ModelAttribute("review") Review1 review,
			                                       @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, 10);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		List <Review1> list = reviewService.findByMemberId(review,teacher.gettId());
		String replyLeader = teacher.gettId()+" "+teacher.gettName();
		List <Review1> list2 = reviewService.findByReplyLeader(replyLeader);
		int i = 0;
		PageInfo<Review1> pageInfo = new PageInfo<>(list,10);
		ModelAndView mv = new ModelAndView();
		if(list2.size()!=0) {
			i = 1;
		}
		mv.addObject("i", i);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("views/user/teacher/review");
		return mv;
	}
	
	/**
	 * 评阅教师获取学生评分详情
	 */
	@RequestMapping(value = "/teacher/editReviewScore.action")
	@ResponseBody
	public String editReviewScore (Review review){
		int rows = 0;
		try {
			rows = reviewService.updateReview(review);
		} catch(Exception e) {
			
		}
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 答辩组长获取答辩组学生评分列表
	 */
	@RequestMapping(value = "/teacher/toReplyleader.action")
	public ModelAndView toReplyleader(HttpSession session,@ModelAttribute("review") Review1 review,
                                                   @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, 10);
		Teacher teacher = (Teacher)session.getAttribute("USER_INFO");
		String replyLeader = teacher.gettId()+" "+teacher.gettName();
		List <Review1> list2 = reviewService.findReviewByRLer(review,replyLeader);
		int i = 0;
		PageInfo<Review1> pageInfo = new PageInfo<>(list2,10);
		ModelAndView mv = new ModelAndView();
		if(list2.size()!=0) {
			i = 1;
		}
		mv.addObject("i", i);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("views/user/teacher/replyLeader");
		return mv;
	}
	
	/**
	 * 获取答辩学生评语详情
	 */
	@RequestMapping(value = "/teacher/getReviewBySId.action")
	@ResponseBody
	public List<Review1> getReviewBySId(String sId){
		List<Review1> list = null;
	  try{
		  list = reviewService.findBySId(sId);
	  }catch(Exception e){
	     
	  }
	  return list;
	}
	
	/**
	 * 保存学生答辩成绩
	 */
	@RequestMapping(value = "/teacher/saveScore.action")
	@ResponseBody
	public String saveScore(String sId,Long titlId){
		int rows = 0;
		List<Review1> list = null;
		int flag = 0;
		try {
			list = reviewService.findBySId(sId);
		} catch(Exception e) {
			
		}
		for(int i = 0;i<list.size();i++) {
			if(list.get(i).getReviewScore()==0) {
				flag = 1;
			}
		}
		if(flag == 1) {
			return "FAIL1";
		}
		int score1 = 0;
		int score2 = 0;
		int count = 0;
		for(int i = 0;i<list.size();i++) {
			if(i == 0) {
				score1 = list.get(i).getReviewScore();
			}else {
				score2 += list.get(i).getReviewScore();
				count++;
			}
		}
		ScoreProportion scoreProportion = scoreProportionService.getScoreProportion("1");
		double replyScore = score1 * scoreProportion.getLeaderScoreProportion() + (score2/count)*(scoreProportion.getReviewScoreProportion());
		DecimalFormat df = new DecimalFormat("#.00");
		replyScore = Double.parseDouble(df.format(replyScore));
		try {
			SelectTitle selectTitle = new SelectTitle();
			selectTitle.setsId(sId);
			selectTitle.setTitlId(titlId);
			selectTitle.setReplyScore(replyScore);
			rows = selectTitleService.updateReplyScore(selectTitle);
		} catch(Exception e) {
			
		}
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
}

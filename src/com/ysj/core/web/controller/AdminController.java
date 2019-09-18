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
import com.ysj.core.po.Admin;
import com.ysj.core.po.BaseDept;
import com.ysj.core.po.BaseMajor;
import com.ysj.core.po.Myfile;
import com.ysj.core.po.ScoreProportion;
import com.ysj.core.po.Student;
import com.ysj.core.po.Teacher;
import com.ysj.core.service.AdminService;
import com.ysj.core.service.BaseDeptService;
import com.ysj.core.service.BaseMajorService;
import com.ysj.core.service.MyFileService;
import com.ysj.core.service.ScoreProportionService;
import com.ysj.core.service.StudentService;
import com.ysj.core.service.TeacherService;
import com.ysj.core.service.TitleService;

@Controller
public class AdminController {
	
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private BaseDeptService baseDeptService;
	@Autowired
	private BaseMajorService baseMajorService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private TitleService titleService;
	@Autowired
	private MyFileService myFileService;
	@Autowired
	private ScoreProportionService scoreProportionService;
	
	/**
	 * 向管理员主页面跳转
	 */
	@RequestMapping(value = "/admin/toindex.action", method = RequestMethod.GET)
	public String toIndex() {
	    return "views/user/admin/index";
	}
	
	/**
	 * 向教师列表跳转
	 */
	@RequestMapping(value = "/admin/toteacherlist.action")
	public ModelAndView teacherlist(@ModelAttribute("teacher") Teacher teacher,
                                    @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		List<Teacher> list = teacherService.Teacherlist(teacher);
		List<BaseDept> list1 = baseDeptService.deptlist();
		PageInfo<Teacher> pageInfo = new PageInfo<>(list,10);
		ModelAndView mv = new ModelAndView();
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("BaseDept", list1);
		mv.setViewName("views/user/admin/teacherlist");
		return mv;
	}
	
	/**
	 * 系部下拉框选中值改变时获取对应专业
	 */
	@RequestMapping(value="/admin/changeDept.action")
	@ResponseBody
	public List<BaseMajor> changeDept(String deptId){
		List<BaseMajor> list = null;
	  try{
		  list = baseMajorService.findMajorBydeptId(deptId);
	  }catch(Exception e){
	     
	  }
	  return list;
	}
	
	/**
	 * 系部下拉框选中值改变时获取对应专业
	 */
	@RequestMapping(value="/admin/changeDept1.action")
	@ResponseBody
	public List<BaseMajor> changeDept1(String dept){
		List<BaseMajor> list = null;
		BaseDept baseDept = baseDeptService.findDeptByName(dept);
	  try{
		  list = baseMajorService.findMajorBydeptId(baseDept.getDeptId());
	  }catch(Exception e){
	     
	  }
	  return list;
	}
	
	
	/**
	 * 通过tId获取教师信息详情
	 */
	@RequestMapping("/admin/getTeacherBytId.action")
	@ResponseBody
	public Teacher getTeacherBytId(String tId) {
		Teacher teacher = teacherService.findTeacherById(tId);
	    return teacher;
	}
	
	/**
	 * 添加教师
	 */
	@RequestMapping("/admin/createTeacher.action")
	@ResponseBody
	public String createTeacher(Teacher teacher) {
		teacher.settPwd("123");
		teacher.settState(1);
		BaseDept baseDept = baseDeptService.findDeptById(teacher.getDeptId());
		teacher.setDept(baseDept.getDeptName());
		if(teacher.getMajorId()!=null && !teacher.getMajorId().equals("")) {
			BaseMajor baseMajor = baseMajorService.findMajorById(teacher.getMajorId());
			teacher.setMajor(baseMajor.getMajorName());
		}else {
			teacher.setMajor("无");
		}
		if(teacher.getPower().equals("否")) {
			teacher.setMajorId(null);
		}
		int rows = 0;
		try {
			rows = teacherService.createTeacher(teacher);
		} catch(Exception e) {
			
		}
		
		if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 删除教师
	 */
	@RequestMapping("/admin/deleteTeacher.action")
	@ResponseBody
	public String deleteTeacher(String tId, int s) {
		int rows = 0;
		try {
			Teacher teacher = new Teacher();
			teacher.settId(tId);
			teacher.settState(s);
			rows = teacherService.editInfo(teacher);
		} catch(Exception e) {
			
		}
		if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	
	/**
	 * 修改教师信息
	 */
	@RequestMapping("/admin/updateTeacher.action")
	@ResponseBody
	public String updateTeacher(Teacher teacher) {
		if(teacher.getPower().equals("否")) {
			teacher.setMajorId(null);
			teacher.setMajor("无");
		}
		else {
			BaseMajor baseMajor = baseMajorService.findMajorById(teacher.getMajorId());
			teacher.setMajor(baseMajor.getMajorName());
		}
		int rows = 0;
		try {
			rows = teacherService.editInfo(teacher);
		} catch (Exception e){
			
		}
		if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	
	
	/**
	 * 向学生列表跳转
	 */
	@RequestMapping(value = "/admin/tostudentlist.action")
	public ModelAndView studentlist(@ModelAttribute("student") Student student,
                                    @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		List<Student> list = studentService.Studentlist(student);
		List<BaseDept> list1 = baseDeptService.deptlist();
		PageInfo<Student> pageInfo = new PageInfo<>(list,10);
	    ModelAndView mv = new ModelAndView();
	    mv.addObject("pageInfo", pageInfo);
	    mv.addObject("BaseDept", list1);
	    mv.setViewName("views/user/admin/studentlist");
	    return mv;
	}
	
	/**
	 * 通过sId获取学生信息
	 */
	@RequestMapping("/admin/getStudentBysId.action")
	@ResponseBody
	public Student getStudentBysId(String sId) {
		Student student = studentService.findStudentById(sId);
		   return student;
		}
	 
	/**
	* 修改学生信息
	*/
	@RequestMapping("/admin/updateStudent.action")
	@ResponseBody
	public String updateStudent(Student student) {
		BaseMajor baseMajor = baseMajorService.findMajorById(student.getMajorId());
		student.setMajor(baseMajor.getMajorName());
		int rows = studentService.editInfo(student);
		    if(rows > 0){
		        return "OK";
		    }else{
		        return "FAIL";
		    }
	}
	
	/**
	 * 删除学生
	 */
	@RequestMapping("/admin/deleteStudent.action")
	@ResponseBody
	public String deleteStudent(String sId, int s) {
		int rows = 0;
		try {
			Student student = new Student();
			student.setsId(sId);
			student.setsState(s);
			rows = studentService.editInfo(student);
		} catch(Exception e) {
			
		}
		
		if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 添加学生
	 */
	@RequestMapping("/admin/createStudent.action")
	@ResponseBody
	public String createStudent(Student student) {
		student.setsPwd("123");
		student.setsState(1);
		BaseMajor baseMajor = baseMajorService.findMajorById(student.getMajorId());
		BaseDept baseDept = baseDeptService.findDeptById(baseMajor.getDeptId());
		student.setMajor(baseMajor.getMajorName());
		student.setDept(baseDept.getDeptName());
		int rows = 0;
		try {
			rows = studentService.createStudent(student);
		} catch(Exception e) {
			
		}
		
		if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 向系部列表跳转
	 */
	@RequestMapping(value = "/admin/todeptlist.action")
	public ModelAndView deptlist(@ModelAttribute("baseDept") BaseDept baseDept,
                                 @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		List<BaseDept> list1 = baseDeptService.findDeptByName1(baseDept);
		PageInfo<BaseDept> pageInfo = new PageInfo<>(list1,10);
		ModelAndView mv = new ModelAndView();
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("views/user/admin/deptlist");
		return mv;
	}
	
	/**
	 * 新建系部
	 */
	@RequestMapping(value = "/admin/createDept.action")
	@ResponseBody
	public String createDept(BaseDept baseDept) {
		baseDept.setDeptState(1);
		int rows = 0;
		try {
			rows = baseDeptService.createDept(baseDept);
		} catch(Exception e) {
			
		}
		
		if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}

	/**
	 * 删除/恢复系部
	 */
	@RequestMapping("/admin/deleteDept.action")
	@ResponseBody
	public String deleteDept(String deptId,int s) {
		int rows = 0;
		try {
			rows = baseDeptService.editInfo(deptId,s);
		} catch(Exception e) {
			
		}
		
		if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 通过deptId获取系部详情
	 */
	@RequestMapping("/admin/getDeptById.action")
	@ResponseBody
	public BaseDept getDeptById(String deptId) {
		BaseDept baseDept = baseDeptService.findDeptById(deptId);
	    return baseDept;
	}
	
	/**
	* 修改系部信息
	*/
	@RequestMapping("/admin/updateDept.action")
	@ResponseBody
	public String updateDept(BaseDept baseDept) {
		String oldName = baseDeptService.findDeptById(baseDept.getDeptId()).getDeptName();
		int rows = 0;
		rows = baseDeptService.editInfo1(baseDept);
		    if(rows > 0){
		    	teacherService.editInfo1(baseDept);
		    	studentService.editInfo1(baseDept,oldName);
		        return "OK";
		    }else{
		        return "FAIL";
		    }
	}

	/**
	 * 向专业列表跳转
	 */
	@RequestMapping(value = "/admin/tomajorlist.action")
	public ModelAndView majorlist(String deptId,@RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		List<BaseMajor> list1 = baseMajorService.findMajorBydeptId1(deptId);
		PageInfo<BaseMajor> pageInfo = new PageInfo<>(list1,10);
		ModelAndView mv = new ModelAndView();
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("deptId", deptId);
		mv.setViewName("views/user/admin/majorlist");
		return mv;
	}
	
	/**
	 * 通过majorId获取专业详情
	 */
	@RequestMapping("/admin/getMajorById.action")
	@ResponseBody
	public BaseMajor getMajorById(String majorId) {
		BaseMajor baseMajor = baseMajorService.findMajorById(majorId);
	    return baseMajor;
	}

	/**
	 * 新建专业
	 */
	@RequestMapping(value = "/admin/createMajor.action")
	@ResponseBody
	public String createMajor(BaseMajor baseMajor) {
		baseMajor.setMajorState(1);
		int rows = 0;
		try {
			rows = baseMajorService.createMajor(baseMajor);
		} catch(Exception e) {
			
		}		
		if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}

	/**
	* 修改专业信息
	*/
	@RequestMapping("/admin/updateMajor.action")
	@ResponseBody
	public String updateMajor(BaseMajor baseMajor) {
		int rows = 0;
		String oldName = baseMajorService.findMajorById(baseMajor.getMajorId()).getMajorName();
		rows = baseMajorService.editMajor(baseMajor);
		    if(rows > 0){
		    	teacherService.editInfo2(baseMajor);
		    	studentService.editInfo2(baseMajor);
		    	titleService.updateTitleMajor(baseMajor.getMajorName(),oldName);
		        return "OK";
		    }else{
		        return "FAIL";
		    }
	}
	
	/**
	 * 删除/恢复专业
	 */
	@RequestMapping("/admin/deleteMajor.action")
	@ResponseBody
	public String deleteMajor(String majorId,int s) {
		int rows = 0;
		try {
			rows = baseMajorService.editMajor1(majorId,s);
		} catch(Exception e) {
			
		}
		
		if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 向管理员修改密码界面跳转
	 */
	@RequestMapping("/admin/toeditPwd.action")
	public String toeditPwd(HttpSession session) {
		Admin admin = (Admin)session.getAttribute("USER_INFO");
		admin = adminService.getAdmin(admin.getAdminId());
		session.setAttribute("USER_INFO", admin);
		return "views/user/admin/editPwd";
	}

	/**
	 * 管理员密码修改
	 */
	@RequestMapping(value = "/admin/editPwd.action")
	@ResponseBody
	public String editPwd(Admin admin) {
		int rows =0;
		try{
			rows = adminService.editInfo(admin);
			}catch(Exception e){
				
			}
		if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 向文件列表跳转
	 */
	@RequestMapping(value = "/admin/tofilelist.action")
	public ModelAndView filelist(@ModelAttribute("myfile") Myfile myfile,
                                 @RequestParam(value="pageNum",required=false,defaultValue="1") int pageNum) {
		PageHelper.startPage(pageNum, 10);
		List<Myfile> list = myFileService.filelist(myfile);
		PageInfo<Myfile> pageInfo = new PageInfo<>(list,10);
		ModelAndView mv = new ModelAndView();
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("views/user/admin/filelist");
		return mv;
	}
	
	/**
	 * 向成绩比重页面跳转
	 */
	@RequestMapping(value = "/admin/scoreproportion.action")
	public ModelAndView scoreproportion() {
		ScoreProportion scoreProportion = scoreProportionService.getScoreProportion("1");
		ModelAndView mv = new ModelAndView();
		int tScoreProportion = (int) Math.round(scoreProportion.gettScoreProportion() * 100);
		int leaderScoreProportion = (int) Math.round(scoreProportion.getLeaderScoreProportion() * 100);
		int reviewScoreProportion = (int) Math.round(scoreProportion.getReviewScoreProportion() * 100);
		mv.addObject("tScoreProportion", tScoreProportion);
		mv.addObject("leaderScoreProportion", leaderScoreProportion);
		mv.addObject("reviewScoreProportion", reviewScoreProportion);
		mv.setViewName("views/user/admin/scoreproportion");
		return mv;
	}
	
	/**
	 * 保存成绩比重
	 */
	@RequestMapping(value = "/admin/saveScoreProportion.action")
	@ResponseBody
	public String saveScoreProportion(String tScoreProportion,String leaderScoreProportion,String reviewScoreProportion) {
		ScoreProportion scoreProportion = new ScoreProportion();
		scoreProportion.setProportionId("1");
		scoreProportion.settScoreProportion(Integer.parseInt(tScoreProportion)*0.01);
		scoreProportion.setLeaderScoreProportion(Integer.parseInt(leaderScoreProportion)*0.01);
		scoreProportion.setReviewScoreProportion(Integer.parseInt(reviewScoreProportion)*0.01);
		int rows =0;
		try{
			rows = scoreProportionService.update(scoreProportion);
			}catch(Exception e){
				
			}
		if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
}

package com.ysj.core.web.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ysj.core.po.Admin;
import com.ysj.core.po.Student;
import com.ysj.core.po.Teacher;
import com.ysj.core.po.User;
import com.ysj.core.service.AdminService;
import com.ysj.core.service.StudentService;
import com.ysj.core.service.TeacherService;

@Controller
public class UserController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private AdminService adminService;
	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(String usercode, String password, String role, Model model, HttpSession session) {
		if(role.equals("学生")) {

			Student student = studentService.findStudent(usercode, password);
			if(student!=null) {
				User user = new User();
				user.setRole(role);
				session.setAttribute("USER", user);
				session.setAttribute("USER_INFO", student);
				return "redirect:student/toindex.action";
			}
		}
		else if(role.equals("教师")) {
			
			Teacher teacher = teacherService.findTeacher(usercode, password);
			if(teacher!=null) {
				User user = new User();
				user.setRole(role);
				session.setAttribute("USER", user);
				session.setAttribute("USER_INFO", teacher);
				return "redirect:teacher/roleset.action";
			}
		}
		else if(role.equals("管理员")) {
			Admin admin = adminService.findAdmin(usercode, password);
			if(admin!=null) {
				User user = new User();
				user.setRole(role);
				session.setAttribute("USER", user);
				session.setAttribute("USER_INFO", admin);
				return "redirect:admin/toindex.action";
			}
		}
		
		model.addAttribute("msg", "账号或密码错误，请重新输入！");
		return "login";
	}
	
	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/logout.action")
	public String logout(HttpSession session) {
	    // 清除Session
	    session.invalidate();
	    // 重定向到登录页面的跳转方法
	    return "redirect:tologin.action";
	}
	
	/**
	 * 向用户登陆页面跳转
	 */
	@RequestMapping(value = "/tologin.action", method = RequestMethod.GET)
	public String toLogin() {
	    return "login";
	}
	

}

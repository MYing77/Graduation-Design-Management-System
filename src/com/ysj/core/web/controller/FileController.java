package com.ysj.core.web.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ysj.common.utils.WordToPdf;
import com.ysj.core.po.MidCheck;
import com.ysj.core.po.Myfile;
import com.ysj.core.po.OpenReport;
import com.ysj.core.po.ProjBook;
import com.ysj.core.po.SelectTitle;
import com.ysj.core.po.Student;
import com.ysj.core.po.Teacher;
import com.ysj.core.po.Thesis;
import com.ysj.core.po.ThesisAttachment;
import com.ysj.core.po.Title;
import com.ysj.core.po.User;
import com.ysj.core.service.MidCheckService;
import com.ysj.core.service.MyFileService;
import com.ysj.core.service.OpenReportService;
import com.ysj.core.service.ProjBookService;
import com.ysj.core.service.SelectTitleService;
import com.ysj.core.service.StudentService;
import com.ysj.core.service.TeacherService;
import com.ysj.core.service.ThesisAttachmentService;
import com.ysj.core.service.ThesisService;
import com.ysj.core.service.TitleService;

@Controller
public class FileController {
	@Autowired
	private MyFileService fileService;
	
	@Autowired
	private SelectTitleService selectTitleService;

	@Autowired
	private TeacherService teacherService;

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
	private StudentService studentService;

	@Autowired
	private TitleService titleService;
	
	@Autowired
	private MyFileService myFileService;
	
	
	

	/**
	 * 根据浏览器的不同进行编码设置，返回编码后的文件名
	 */
	public String getFilename(HttpServletRequest request, String filename) throws Exception {
		// IE不同版本User-Agent中出现的关键词
		String[] IEBrowserKeyWords = { "MSIE", "Trident", "Edge" };
		// 获取请求头代理信息
		String userAgent = request.getHeader("User-Agent");
		for (String keyWord : IEBrowserKeyWords) {
			if (userAgent.contains(keyWord)) {
				// IE内核浏览器，统一为UTF-8编码显示
				return URLEncoder.encode(filename, "UTF-8");
			}
		}
		// 火狐等其它浏览器统一为ISO-8859-1编码显示
		return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
	}

	/**
	 * 预览文档(pdf)
	 */
	@RequestMapping("/file/toPdfProjBook.action")
	public ModelAndView toPdfProjBook(Long num1, String num2) {
		Myfile file = fileService.toPdfProjBook(num1);
		Teacher teacher = teacherService.findTeacherById(num2);
		String fPath = file.getfPath();
		String fPath2 = StringUtils.substringBeforeLast(fPath, ".");
		fPath2 = fPath2 + ".pdf";
		System.out.println("检查是否存在此pdf文件" + fPath2);
		File file2 = new File(fPath2);
		if(!file2.exists()) {
			WordToPdf w = new WordToPdf();
			w.wordToPDF(fPath, fPath2);
		}
		String f = file.getfName();
		f = f.substring(0, f.indexOf("."));
		f = f + ".pdf";
		String t = teacher.gettId();
		ModelAndView mv = new ModelAndView();
		mv.addObject("f", f);
		mv.addObject("t", t);
		System.out.println(f+t);
		mv.setViewName("views/pdf");
		return mv;
	}

	/**
	 * 文件下载
	 */
	@RequestMapping("/file/filedown.action")
	public ResponseEntity<byte[]> downfile(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String fId = request.getParameter("fId");
		ProjBook projBook = null;
		Myfile myfile = new Myfile();
		long l = Long.parseLong(fId);
		myfile = fileService.selectById(l);
		String filename = myfile.getfName();
		projBook = projBookService.findProjBookByfId(l);
		User user =(User) session.getAttribute("USER");
		String path = null;
		if(user.getRole().equals("学生")) {
			System.out.println("进来了");
			Student student = (Student) session.getAttribute("USER_INFO");
			List<ProjBook> list = projBookService.findProjBookList(projBook, (String) student.getsId());
			String tId = list.get(0).gettId();
			String tName = list.get(0).gettName();
			System.out.println(tId);
			System.out.println(tName);
			tName = tId;
			path = request.getServletContext().getRealPath("/upload/");
			path = path + tName + "\\";
		}
		else if(user.getRole().equals("教师")) {
			String tId = request.getParameter("tId");
			String tName = request.getParameter("tName");
			tName = tId;
			path = request.getServletContext().getRealPath("/upload/");
			path = path + tName + "\\";
		}
		System.out.println("地址是 " + path);
		// 指定要下载的文件所在路径
		ResponseEntity<byte[]> result = null;
		try {
			// 创建该文件对象
			File file = new File(path + File.separator + filename);
			// 对文件名编码，防止中文文件乱码
			filename = this.getFilename(request, filename);
			// 设置响应头
			HttpHeaders headers = new HttpHeaders();
			// 通知浏览器以下载的方式打开文件
			headers.setContentDispositionFormData("attachment", filename);
			// 定义以流的形式下载返回文件数据
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			// 使用Sring MVC框架的ResponseEntity对象封装返回下载数据
			result = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script language=\"javascript\">alert('下载失败！')</script>");
		} catch (IOException e) {
			e.printStackTrace();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script language=\"javascript\">alert('下载失败！')</script>");
		}
		return result;
	}

	/**
	 * 文件上传
	 * @throws IOException 
	 */
	@RequestMapping("/file/fileUpload.action")
	public ModelAndView fileUpload(HttpSession session,HttpServletResponse response,
			@RequestParam("fType") String fType,
			@RequestParam("uploadfile") List<MultipartFile> uploadfile, HttpServletRequest request) throws IOException {
		Student student = (Student)session.getAttribute("USER_INFO");
		ModelAndView mv = new ModelAndView();
		mv.addObject("fType", fType);
		if(fType.equals("任务书")) {
			List<ProjBook> list = projBookService.findProjBookBysIdAndAgree(student.getsId(), "待通过");
			if(list.size()!=0) {
				mv.addObject("FAIL", "FAIL1");
				mv.setViewName("views/error");
				return mv;
			}
		}else if(fType.equals("开题报告")) {
			List<OpenReport> list = openReportService.findOpenReportBysIdAndAgree(student.getsId(), "待通过");
			if(list.size()!=0) {
				mv.addObject("FAIL", "FAIL1");
				mv.setViewName("views/error");
				return mv;
			}
		}else if(fType.equals("中期检查")) {
			List<MidCheck> list = midCheckService.findMidCheckBysIdAndAgree(student.getsId(), "待通过");
			if(list.size()!=0) {
				mv.addObject("FAIL", "FAIL1");
				mv.setViewName("views/error");
				return mv;
			}
		}else if(fType.equals("论文")) {
			List<Thesis> list = thesisService.findThesisBysIdAndAgree(student.getsId(), "待通过");
			if(list.size()!=0) {
				mv.addObject("FAIL", "FAIL1");
				mv.setViewName("views/error");
				return mv;
			}
		}else if(fType.equals("附件")) {

			List<ThesisAttachment> list = thesisAttachmentService.findThesisAttachmentBysId(student.getsId());
			if(list.size()!=0) {
				mv.addObject("FAIL", "FAIL1");
				mv.setViewName("views/error");
				return mv;
			}
		}
		student = studentService.findStudent(student.getsId(), student.getsPwd());
		Title title = titleService.findTitleBysId(student.getsId());
		String tId = title.gettId();
	//	String tName = title.gettName();
		String t = tId;
		String s = student.getsId() + student.getsName();
		s = s + fType;

		// 判断所上传文件是否存在
				if (!uploadfile.isEmpty() && uploadfile.size() > 0) {
					//循环输出上传的文件
					for (MultipartFile file : uploadfile) {
						String name1 = t;
						// 获取上传文件的原始名称
						String originalFilename = file.getOriginalFilename();
						System.out.println("上传文件原始文件名是: "+ originalFilename);
						int c = originalFilename.indexOf(".");
						String s1 = originalFilename.substring(c);
						String s2 = originalFilename.substring(0, c);
						s2 = s;
						originalFilename = s2 + s1;
						//获取上传文件后缀名
						String dirPath = 
		                       request.getServletContext().getRealPath("/upload/"+name1);
						System.out.println(dirPath);
						File filePath = new File(dirPath);
						// 如果保存文件的地址不存在，就先创建目录
						if (!filePath.exists()) {
							filePath.mkdirs();
						}
						String newFilename = dirPath + "\\" + originalFilename;
						System.out.println("文件保存地址" + newFilename +"\n");
						File filePath2 = new File(newFilename);
						int i = 0;
						String s3 = null;
						while(filePath2.exists()) {
							i++;
							s3 = s2+ "(" + String.valueOf(i) +")";
							originalFilename = s3 + s1;
		     				System.out.println("文件已存在，重新命名为: "+originalFilename);  //文件名
							newFilename = dirPath + "\\" + originalFilename;
							System.out.println("新文件地址是: " +newFilename);
							filePath2 = new File(newFilename);
						}
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
						String nowtime = df.format(new Date());
				        System.out.println(nowtime);// new Date()为获取当前系统时间
						try {
							// 使用MultipartFile接口的方法完成文件上传到指定位置
							file.transferTo(new File(newFilename));
			//				String newFilenamePdf = s3 + ".pdf";
			//				System.out.println("生成的pdf文件名是: "+ newFilenamePdf);
			//				newFilenamePdf = dirPath + "\\" + newFilenamePdf;
			//				System.out.println("生成的pdf文件的保存地址是: "+newFilenamePdf);
			//				WordToPdf w = new WordToPdf();
			//				w.wordToPDF(newFilename, newFilenamePdf);
							Myfile myfile = new Myfile();
							myfile.setfName(originalFilename);                           
							myfile.setfPath(newFilename);
							Date date = df.parse(nowtime);
							myfile.setUploadDatetime(date);
							myfile.setfType(fType);
							myFileService.createMyfile(myfile);
							if(fType.equals("任务书")) {
								ProjBook projBook = new ProjBook();
								projBook.setfId(myFileService.selectByfName(originalFilename).getfId());
								projBook.setsId(student.getsId());
								projBook.setAgree("待通过");
								projBookService.createProjBook(projBook);
							}else if(fType.equals("开题报告")) {
								OpenReport openReport = new OpenReport();
								openReport.setfId(myFileService.selectByfName(originalFilename).getfId());
								openReport.setsId(student.getsId());
								openReport.setAgree("待通过");
								openReportService.createOpenReport(openReport);
							}else if(fType.equals("中期检查")) {
								MidCheck midCheck = new MidCheck();
								midCheck.setfId(myFileService.selectByfName(originalFilename).getfId());
								midCheck.setsId(student.getsId());
								midCheck.setAgree("待通过");
								midCheckService.createMidCheck(midCheck);
							}else if(fType.equals("论文")) {
								SelectTitle selectTitle = selectTitleService.findSelTitleListBysIdAndState(student.getsId(),"同意").get(0);
								Thesis thesis = new Thesis();
								thesis.setfId(myFileService.selectByfName(originalFilename).getfId());
								thesis.setsId(student.getsId());
								thesis.setAgree("待通过");
								thesis.setTitlId(selectTitle.getTitlId());
								thesisService.createThesis(thesis);
							}else if(fType.equals("附件")) {
								ThesisAttachment thesisAttachment = new ThesisAttachment();
								thesisAttachment.setfId(myFileService.selectByfName(originalFilename).getfId());
								thesisAttachment.setsId(student.getsId());
								thesisAttachmentService.createThesisAttachment(thesisAttachment);
							}
							
						} catch (Exception e) {
							e.printStackTrace();
							mv.setViewName("views/error");
		                    return mv;
						}
					}
					// 跳转到成功页面
					mv.setViewName("views/success");
					return mv;
				}else{
					mv.setViewName("views/error");
                    return mv;
				}

	}
	
	/**
	 * 删除文件
	 */
	@RequestMapping("/file/filedelete.action")
	@ResponseBody
	public String filedelete(HttpSession session,HttpServletRequest request ,Long fId) {
		Myfile myfile = fileService.selectById(fId);

		File file = new File(myfile.getfPath());
		if (file.isFile() && file.exists()) {
			file.delete();
		}
		int rows = fileService.delete(fId);
	    if(rows > 0){			
	        return "OK";
	    }else 
	    	return "FAIL";
	}

}

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() 
	                   + ":" + request.getServerPort() + path + "/";
%>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>高校毕业设计管理系统</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/materialdesignicons.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.min.css" rel="stylesheet">
</head>
<body>
<div class="lyear-layout-web">
  <div class="lyear-layout-container">
    <!--左侧导航-->
    <aside class="lyear-layout-sidebar">
      

      <div id="logo" style="height:55px">
      <p></p>
          <h3 align="center">毕业设计管理系统</h2>
      </div>
      <div class="lyear-layout-sidebar-scroll"> 
        
        <nav class="sidebar-main">
          <ul class="nav nav-drawer">
            <li class="nav-item active"> <a href="${pageContext.request.contextPath }/teacher/toindex.action"><i class="mdi mdi-home"></i> 首页</a> </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-bank"></i> 选题管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/teacher/totitlelist.action">我的课题</a> </li>
                <li> <a href="${pageContext.request.contextPath }/teacher/toSelecttitlelist.action">查看选题学生</a> </li>
                
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i> 任务书管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/teacher/projBooklist.action">已审核任务书</a> </li>
                <li> <a href="${pageContext.request.contextPath }/teacher/projBooklist1.action">待审核任务书</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i> 开题报告管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/teacher/openReportlist.action">已审核开题报告</a> </li>
                <li> <a href="${pageContext.request.contextPath }/teacher/openReportlist1.action">待审核开题报告</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-tab"></i> 中期检查</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/teacher/midChecklist.action">已审核中期检查</a> </li>
                <li> <a href="${pageContext.request.contextPath }/teacher/midChecklist1.action">待审核中期检查</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-file-document"></i> 论文管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/teacher/thesislist.action">已审核论文</a> </li>
                <li> <a href="${pageContext.request.contextPath }/teacher/thesislist1.action">待审核论文</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-attachment"></i> 附件</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/teacher/thesisAttachmentlist.action">下载学生附件</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-scale-balance"></i> 总评</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/teacher/studentScore.action">学生成绩总评</a> </li>
              </ul>
            </li>
          </ul>
        </nav>
        
        <div class="sidebar-footer">
          
        </div>
      </div>
      
    </aside>
    <!--End 左侧导航-->
    
    <!--头部信息-->
    <header class="lyear-layout-header">
      
      <nav class="navbar navbar-default">
        <div class="topbar">
          
          <div class="topbar-left">
            <div class="lyear-aside-toggler">
              <span class="lyear-toggler-bar"></span>
              <span class="lyear-toggler-bar"></span>
              <span class="lyear-toggler-bar"></span>
            </div>
            <span class="navbar-page-title"> 修改密码 </span>
          </div>
          
          <ul class="topbar-right">
            <li class="dropdown dropdown-profile">
              <a href="javascript:void(0)" data-toggle="dropdown">
                <span style="color:black">${USER_INFO.tName} <span class="caret"></span></span>
              </a>
              <ul class="dropdown-menu dropdown-menu-right">
                <li> <a href="${pageContext.request.contextPath }/teacher/topersonInfo.action"><i class="mdi mdi-account"></i> 个人信息</a> </li>
                <li> <a href="${pageContext.request.contextPath }/teacher/toeditPwd.action"><i class="mdi mdi-lock-outline"></i> 修改密码</a> </li>
                <li class="divider"></li>
                <li> <a href="${pageContext.request.contextPath }/logout.action"><i class="mdi mdi-logout-variant"></i> 退出登录</a> </li>
              </ul>
            </li>
            <a href="${pageContext.request.contextPath }/teacher/roleset.action">
            <span>切换角色权限</span>
            </a>
          </ul>
          
        </div>
      </nav>
      
    </header>
    <!--End 头部信息-->
    
    <!--页面主要内容-->
    <main class="lyear-layout-content">
      
      <div class="container-fluid">
        
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                
                <form id="edit_student_form" method="post" action="#" class="site-form">
                <input type="hidden" name="tId" id="tId" value="${USER_INFO.tId }" />
                <input type="hidden" name="opwd" id="opwd" value="${USER_INFO.tPwd }" />
                  <div class="form-group">
                    <label for="oldpwd">旧密码</label>
                    <input type="password" class="form-control" maxlength="25" name="oldpwd" id="oldpwd" placeholder="输入原登录密码">
                  </div>
                  <div class="form-group">
                    <label for="tPwd">新密码</label>
                    <input type="password" class="form-control" maxlength="25" name="tPwd" id="tPwd" placeholder="输入新的密码">
                  </div>
                  <div class="form-group">
                    <label for="confirmpwd">确认新密码</label>
                    <input type="password" class="form-control" maxlength="25" name="confirmpwd" id="confirmpwd" placeholder="再次输入新的密码">
                  </div>
                  <button type="button" class="btn btn-primary" onclick="editPwd()">修改密码</button>
                </form>
       
              </div>
            </div>
          </div>
          
        </div>
        
      </div>
      
    </main>
    <!--End 页面主要内容-->
  </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.min.js"></script>
<!--消息提示-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-notify.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lightyear.js"></script>
<!--图表插件-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Chart.js"></script>
<script type="text/javascript">
//执行修改密码操作(教师)
function editPwd() {
	var opwd = $("#opwd").val();
	var oldpwd = $("#oldpwd").val();
    var tPwd = $("#tPwd").val();
    var confirmpwd = $("#confirmpwd").val();
    if(oldpwd==''||tPwd==''||confirmpwd=='') {
    	lightyear.loading('show');
    	lightyear.loading('hide');
        lightyear.notify('新旧密码不能为空！', 'danger');
        return false;
    }else if(opwd != oldpwd) {
    	lightyear.loading('show');
    	lightyear.loading('hide');
        lightyear.notify('旧密码输入错误！', 'danger');
        return false;
    }else if(tPwd != confirmpwd) {
    	lightyear.loading('show');
    	lightyear.loading('hide');
        lightyear.notify('两次新密码输入不一致！', 'danger');
        return false;
    }else if(opwd == tPwd) {
    	lightyear.loading('show');
    	lightyear.loading('hide');
        lightyear.notify('新旧密码不能相同！', 'danger');
        return false;
    }
    
	$.post("<%=basePath%>teacher/editPwd.action",$("#edit_student_form").serialize(),function(data){
		if(data =="OK"){
			lightyear.loading('hide');
	        lightyear.notify('修改成功，页面即将自动刷新~', 'success');
	        setTimeout(function() {
	        	window.location.reload();
	        }, 2000)
		}else{
			lightyear.loading('hide');
	        lightyear.notify('修改失败，请重试~', 'danger');
	        setTimeout(function() {
	        	window.location.reload();
	        }, 2000)
		}
	});
}
</script>
</body>
</html>
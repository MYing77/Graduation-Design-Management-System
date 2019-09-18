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
            <li class="nav-item active"> <a href="${pageContext.request.contextPath }/student/toindex.action" onclick="location.reload()"><i class="mdi mdi-home"></i> 首页</a> </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-bank"></i> 选题管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/student/totitlelist.action">学生选题</a> </li>
                <li> <a href="${pageContext.request.contextPath }/student/selTitleById.action">我的选题</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i> 任务书管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/student/projBooklist.action">任务书</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i> 开题报告管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/student/openReportlist.action">开题报告 (学生)</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-tab"></i> 中期检查</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/student/midChecklist.action">中期检查</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-file-document"></i> 论文管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/student/thesislist.action">学生论文 (在线提交)</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-attachment"></i> 附件</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/student/thesisAttachmentlist.action">附件上传 (学生)</a> </li>
              </ul>
            </li>

            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-scale-balance"></i> 总评</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/student/studentScore.action">成绩总评 (学生)</a> </li>
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
            <span class="navbar-page-title"> 个人信息 </span>
          </div>
          
          <ul class="topbar-right">
            <li class="dropdown dropdown-profile">
              <a href="javascript:void(0)" data-toggle="dropdown">
                <span style="color:black">${USER_INFO.sName} <span class="caret"></span></span>
              </a>
              <ul class="dropdown-menu dropdown-menu-right">
                <li> <a href="${pageContext.request.contextPath }/student/topersonInfo.action"><i class="mdi mdi-account"></i> 个人信息</a> </li>
                <li> <a href="${pageContext.request.contextPath }/student/toeditPwd.action"><i class="mdi mdi-lock-outline"></i> 修改密码</a> </li>
                <li class="divider"></li>
                <li> <a href="${pageContext.request.contextPath }/logout.action"><i class="mdi mdi-logout-variant"></i> 退出登录</a> </li>
              </ul>
            </li>
           
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
                
                <div class="edit-avatar">

                  <div class="avatar-divider" style = "height:0px"></div>
                  <div class="edit-avatar-content">
                  </div>
                </div>
                <form id="edit_student_form" method="post" action="#" class="site-form">
                <input type="hidden" name="sId" id="sId" value="${USER_INFO.sId }" />
                  <div class="form-group">
                    <label for="sName">真实姓名</label>
                    <input type="text" readOnly class="form-control "  name="sName" id="sName" value="${USER_INFO.sName }" />
                  </div>
                  <div class="form-group">
                    <label for="dept">系部</label>
                    <input type="text" readOnly class="form-control "  name="dept" id="dept" value="${USER_INFO.dept }" />
                  </div>
                  <div class="form-group">
                    <label for="major">专业</label>
                    <input type="text" readOnly class="form-control "  name="major" id="major" value="${USER_INFO.major }" />
                  </div>
                  <div class="form-group">
                    <label for="sClass">班级</label>
                    <input type="text" readOnly class="form-control "  name="sClass" id="sClass" value="${USER_INFO.sClass }" />
                  </div>
                  <div class="form-group">
                    <label for="nickname">性别</label>
                    <select class="form-control " id="sex" name="sex" size="1">
                        <option value="男" ${USER_INFO.sex=="男"?'selected':''}>男</option>
                        <option value="女" ${USER_INFO.sex=="女"?'selected':''}>女</option>
                      </select>
                  </div>
                  <div class="form-group">
                    <label for="age">年龄</label>
                    <input type="number" maxlength="3" class="form-control "  name="age" id="age" value="${USER_INFO.age }"/>
                  </div>
                  <div class="form-group">
                    <label for="phone">手机</label>
                    <input oninput="value=value.replace(/[^\d]/g,'')" maxlength="11" type="text" class="form-control "  name="phone" id="phone" value="${USER_INFO.phone }"/>
                  </div>
                  <div class="form-group">
                    <label for="email">邮箱</label>
                    <input type="text" maxlength="32" class="form-control " name="email" id="email" value="${USER_INFO.email }" aria-describedby="emailHelp" placeholder="请输入正确的邮箱地址">
                  </div>
                  <div class="form-group">
                    <label for="batch">批次</label>
                    <input type="text" class="form-control " name="batch" id="batch" readonly  value="${USER_INFO.batch }"/>
                  </div>
                  <button type="button" class="btn btn-primary" onclick="editInfo()">保存</button>
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
<script type="text/javascript" src="js/Chart.js"></script>
<script type="text/javascript">
//执行修改个人信息操作(学生)
function editInfo() {
	var phone = document.getElementById('phone').value;
    if(!(/^1[34578]\d{9}$/.test(phone))){ 
        alert("手机号码有误，请重填");  
        return false; 
    } 
	$.post("<%=basePath%>student/editInfo.action",$("#edit_student_form").serialize(),function(data){
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
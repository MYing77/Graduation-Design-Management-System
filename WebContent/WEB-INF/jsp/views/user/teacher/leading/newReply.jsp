<!DOCTYPE html>
<html lang="zh">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>高校毕业设计管理系统</title>
<link rel="icon" href="favicon.ico" type="image/ico">
<meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
<meta name="description"
	content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
<meta name="author" content="yinqi">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/materialdesignicons.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-select.min.css" rel="stylesheet">
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
            <li class="nav-item"> <a href="${pageContext.request.contextPath }/teacher/leading/Index.action"><i class="mdi mdi-home"></i> 首页</a> </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-bank"></i> 课题管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/teacher/leading/totitlelist.action">已审核课题</a> </li>
                <li> <a href="${pageContext.request.contextPath }/teacher/leading/totitlelist1.action">待审核课题</a> </li>
              </ul>
            </li>
            
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-database"></i> 数据查询</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/teacher/leading/projBooklist.action">任务书</a> </li>
                <li> <a href="${pageContext.request.contextPath }/teacher/leading/openReportlist.action">开题报告</a> </li>
                <li> <a href="${pageContext.request.contextPath }/teacher/leading/midChecklist.action">中期检查</a> </li>
                <li> <a href="${pageContext.request.contextPath }/teacher/leading/thesislist.action">论文</a> </li>
                <li> <a href="${pageContext.request.contextPath }/teacher/leading/thesisAttachmentlist.action">附件</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav active open">
              <a href="javascript:void(0)"><i class="mdi mdi-cube"></i> 答辩管理</a>
              <ul class="nav nav-subnav">
                <li class="active"> <a href="${pageContext.request.contextPath }/teacher/leading/toreply.action">答辩安排</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-scale-balance"></i> 总评</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/teacher/leading/studentScore.action">学生成绩总评</a> </li>
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
								<span class="lyear-toggler-bar"></span> <span
									class="lyear-toggler-bar"></span> <span
									class="lyear-toggler-bar"></span>
							</div>
							<span class="navbar-page-title"> 创建答辩组</span>
						</div>
						<ul class="topbar-right">
          
            <li class="dropdown dropdown-profile">
              <a href="javascript:void(0)" data-toggle="dropdown">
                <span style="color:black">${USER_INFO.tName} <span class="caret"></span></span>
              </a>
              <ul class="dropdown-menu dropdown-menu-right">
                <li> <a href="${pageContext.request.contextPath }/teacher/leading/topersonInfo.action"><i class="mdi mdi-account"></i> 个人信息</a> </li>
                <li> <a href="${pageContext.request.contextPath }/teacher/leading/toeditPwd.action"><i class="mdi mdi-lock-outline"></i> 修改密码</a> </li>
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
                
                <form id="newReplyGroupInfo" class="row">
                <input hidden="hidden" id="creator" name="creator" value="${USER_INFO.tId}">
                  <div class="form-group col-md-12">
                    <label for="title">答辩组编号</label>
                    <input type="text" class="form-control" id="replyId" name="replyId" placeholder="请输入答辩组编号" />
                  </div>
                  <div class="form-group col-md-12">
                    <label for="replyLeader">答辩组组长</label>
                    <select id="replyLeader" name="replyLeader" class="form-control">
                    <option value="-1">--请选择--</option>
                          <c:forEach items="${list}" var="item">
								    <option value="${item.tId} ${item.tName }">
								    ${item.tId} ${item.tName }
								    </option>
							        </c:forEach>
                     </select>
                  </div>
                  <div class="form-group col-md-12">
                    <label for="replyMember">评阅教师</label>
                     <select data-max-options="2" id="replyMember" name="replyMember" class="selectpicker show-menu-arrow form-control" multiple >
                          <c:forEach items="${list}" var="item">
								    <option value="${item.tId} ${item.tName }">
								    ${item.tId} ${item.tName }
								    </option>
							        </c:forEach>
                     </select>
                  </div>
                  <div class="form-group col-md-12">
                    <label for="replyPlace">答辩地点</label>
                    <input type="text" class="form-control" id="replyPlace" name="replyPlace" value="" placeholder="请输入答辩地点，如：3B310" />
                  </div>
                  <div class="form-group col-md-12">
                    <label for="replyDatetime">答辩时间</label>
                    <input type="text" class="form-control" id="replyDatetime" name="replyDatetime" placeholder="请选择答辩开始时间" />
                  </div>
                  <div class="form-group col-md-12">
                    <label for="batch">批次</label>
                    <input type="number" class="form-control" id="batch" name="batch" placeholder="请选择批次" />
                  </div>
                  <div class="form-group col-md-12">
                    <label for="replyStudent">答辩学生</label>
                    <select data-max-options="4" id="replyStudent" name="replyStudent" class="selectpicker show-menu-arrow form-control" multiple >
                          <c:forEach items="${list}" var="item">
								    <option value="${item.tId} ${item.tName }">
								    ${item.tId}${item.tName }所带学生
								    </option>
							        </c:forEach>
                     </select>
                  </div>
                  <div class="form-group col-md-12">
                    <button type="button" class="btn btn-primary ajax-post" onclick="newReply()">创 建</button>
                    <button type="button" class="btn btn-default" onclick="javascript:history.back(-1);return false;">返 回</button>
                  </div>
                </form>
       
              </div>
            </div>
          </div>
          
        </div>
        
      </div>
			</main>
			<!--End 页面主要内容-->
			

	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/perfect-scrollbar.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/main.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/bootstrap-select.js"></script>
		<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/layDate-v5.0.9/laydate/laydate.js"></script>
	<script type="text/javascript">
	laydate.render({
		  elem: '#replyDatetime'
		 ,type: 'datetime'
		});
	
	function newReply() {
		if($("#replyId").val()=="") {
			alert("请输入答辩组编号！");
			return;
		}
		if($("#replyLeader").val()=="-1") {
			alert("请选择答辩组组长！");
			return;
		}
		if($("#replyMember").val()==null) {
			alert("请选择答辩组成员！");
			return;
		}
		if($("#replyPlace").val()=="") {
			alert("请选择答辩地点！");
			return;
		}
		if($("#replyDatetime").val()=="") {
			alert("请选择答辩开始时间！");
			return;
		}
		if($("#batch").val()=="") {
			alert("请选择批次！");
			return;
		}
		if($("#replyStudent").val()==null) {
			alert("请选择答辩学生！");
			return;
		}
		$.post("<%=basePath%>teacher/leading/createReply.action",
    			$("#newReplyGroupInfo").serialize(),function(data){
    			        if(data =="OK"){
    			            alert("创建答辩组成功！");
    			            window.location.href='<%=basePath%>teacher/leading/toreply.action';
    			        }else{
    			            alert("创建答辩组失败！");
    			            window.location.href='<%=basePath%>teacher/leading/toreply.action';
    			        }
    			    });
	}
	
	
	function jumpPage(pageNumber){
		  // 先修改访问的页码
		  document.getElementById("page").value = pageNumber;
		  // 手动提交表单
		  document.getElementById("form_query").submit();
	  };
	
	  function createReply() {
		  window.location.href='<%=basePath%>teacher/leading/createReply.action';
	  }
	  
	  function createMajor() {
		  if($("#new_majorId").val()=='') {
			  alert("请输入专业代码！");
			  return;
		  }
		  if($("#new_majorName").val()=='') {
			  alert("请输入专业名称！");
			  return;
		  }
		  $.post("<%=basePath%>admin/createMajor.action",
					$("#create_major_form").serialize(),function(data){
					        if(data =="OK"){
					            alert("添加专业成功！");
					            window.location.reload();
					        }else{
					            alert("添加专业失败！");
					            window.location.reload();
					        }
					    });
	  }
	  
	  
	  function editMajor(majorId) {
		    $.ajax({
		        type:"get",
		        url:"<%=basePath%>admin/getMajorById.action",
		        data:{"majorId":majorId},
		        success:function(data) {
		            $("#majorId").val(data.majorId);
		            $("#majorName").val(data.majorName);
		        }
		    });
		}
	  
	  function saveMajorinfo() {
		  if($("#majorId").val()=='') {
			  alert("请输入系部代码！");
			  return;
		  }
		  if($("#majorName").val()=='') {
			  alert("请输入系部名称！");
			  return;
		  }
		  $.post("<%=basePath%>admin/updateMajor.action",$("#edit_major_form").serialize(),function(data){
				if(data =="OK"){
					alert("专业信息更新成功！");
					window.location.reload();
				}else{
					alert("专业信息更新失败！");
					window.location.reload();
				}
			});
	  }
	  
	  
	  function deleteMajor(majorId,s) {
		  if(confirm('确实要删除/恢复该专业吗?')){
			  $.post("<%=basePath%>admin/deleteMajor.action",{"majorId":majorId,"s":s},function(data){
					if(data =="OK"){
						alert("操作成功！");
						window.location.reload();
					}else{
						alert("操作失败！");
						window.location.reload();
					}
				});
		  }
	  }	  
	  
	  function change() {
		  var dept = $("#new_dept").val();
		  if(dept=='-1') {
			  $("#new_major").html("");
			  return;
		  }
		  $.ajax({
			   type : "POST",
			   url : "<%=basePath%>admin/changeDept.action",
			   data : {"dept":dept},
			   dataType : "json",
			   success: function (date) {
                   var optionstring = "";
                   for (var j = 0; j < date.length;j++) {
                       optionstring += "<option value=\"" + date[j].majorName + "\" >" +date[j].majorName+" " + "</option>";
                       $("#new_major").html("<option value='0'>请选择...</option> "+optionstring);
                   }
               },

               error: function (msg) {
                   layer.msg('数据出错了!!');
               }
			  });
	  }
	  
	  function change2() {
		  var dept = $("#dept").val();
		  if(dept=='-1') {
			  $("#major").html("");
			  return;
		  }
		  $.ajax({
			   type : "POST",
			   url : "<%=basePath%>admin/changeDept.action",
			   data : {"dept":dept},
			   dataType : "json",
			   success: function (date) {
                   var optionstring = "";
                   for (var j = 0; j < date.length;j++) {
                       optionstring += "<option value=\"" + date[j].majorName + "\" >" +date[j].majorName+" " + "</option>";
                       $("#major").html("<option value='0'>请选择...</option> "+optionstring);
                   }
               },

               error: function (msg) {
                   layer.msg('数据出错了!!');
               }
			  });
	  }
	  
	  function change1(val) {
		  var dept = val;
		  if(dept=='-1') {
			  $("#major").html("");
			  return;
		  }
		  $.ajax({
			   type : "POST",
			   url : "<%=basePath%>admin/changeDept.action",
			   data : {"dept":dept},
			   dataType : "json",
			   success: function (date) {
                   var optionstring = "";
                   for (var j = 0; j < date.length;j++) {
                       optionstring += "<option value=\"" + date[j].majorName + "\" >" +date[j].majorName+" " + "</option>";
                       $("#major").html("<option value='无'>请选择...</option> "+optionstring);
                   }
               },

               error: function (msg) {
                   layer.msg('数据出错了!!');
               }
			  });
	  }
	</script>
</body>
</html>
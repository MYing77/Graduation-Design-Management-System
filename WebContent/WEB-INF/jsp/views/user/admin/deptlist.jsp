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
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/materialdesignicons.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.min.css"
	rel="stylesheet">
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
            <li class="nav-item"> <a href="${pageContext.request.contextPath }/admin/toindex.action" onclick="location.reload()"><i class="mdi mdi-home"></i> 首页</a> </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-human"></i> 用户管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/admin/toteacherlist.action">教师信息管理</a> </li>
                <li> <a href="${pageContext.request.contextPath }/admin/tostudentlist.action">学生信息管理</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav open active">
              <a href="javascript:void(0)"><i class="mdi mdi-application"></i> 系部/专业管理</a>
              <ul class="nav nav-subnav">
                <li class="active"> <a href="${pageContext.request.contextPath }/admin/todeptlist.action">系部/专业</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-file"></i> 文件管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/admin/tofilelist.action">学生上传文件管理</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-cube-unfolded"></i> 学生成绩比重设置</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/admin/scoreproportion.action">修改成绩比重</a> </li>
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
							<span class="navbar-page-title"> 系部/专业信息管理</span>
						</div>
						<ul class="topbar-right">
							<li class="dropdown dropdown-profile"><a
								href="javascript:void(0)" data-toggle="dropdown"> <span
									style="color: black">${USER_INFO.adminId} <span
										class="caret"></span></span>
							</a>
								<ul class="dropdown-menu dropdown-menu-right">
									
									<li><a
										href="${pageContext.request.contextPath }/admin/toeditPwd.action"><i
											class="mdi mdi-lock-outline"></i> 修改密码</a></li>
									<li class="divider"></li>
									<li><a
										href="${pageContext.request.contextPath }/logout.action"><i
											class="mdi mdi-logout-variant"></i> 退出登录</a></li>
								</ul></li>

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
							<div class="card-toolbar clearfix">
								<form id="form_query"
									action="${pageContext.request.contextPath }/admin/todeptlist.action"
									class="pull-right search-bar" method="post"">
									<input id="page" name="pageNum" type="hidden" value="1"/>
									<div class="input-group">
										<div class="input-group-btn">
											<input type="submit" class="btn btn-primary" id="search"
												name="search" value='搜索' >
										</div>
										<input type="text" class="form-control"
											value="${baseDept.deptName}" name="deptName"
											placeholder="请输入系名称">
									</div>
								</form>
							</div>
							<div class="card-body">
								<button type="button" class="btn btn-label btn-primary" data-toggle="modal" 
		           data-target="#newDeptDialog" onclick="clearDept()"><label><i class="mdi mdi-checkbox-marked-circle-outline"></i></label>添加</button>
								<p></p>
								<div class="table-responsive">
									<table class="table table-bordered" id="tbodyID">
										<thead>
											<tr>
												<th>系别代码</th>
												<th>系别名称</th>
												<th>状态</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="BaseDept" items="${pageInfo.list }"
												varStatus="state">
												<tr>
													<td>${BaseDept.deptId}</td>
													<td><button style="border:0;background: none;" type="button"><a href="${pageContext.request.contextPath }/admin/tomajorlist.action?deptId=${BaseDept.deptId }">${BaseDept.deptName }</a></button></td>
													<td>${BaseDept.deptState }</td>
													<td>
													<input type="button" class="btn btn-success btn-xs" id="edit"
																	name="edit" value='修改' data-toggle="modal" data-target="#deptInfoModal" onclick="editDept('${BaseDept.deptId}')">
																	<c:if test="${BaseDept.deptState==1 }">
																	<input type="button" class="btn btn-danger btn-xs" id="del"
																	name="del" value='删除' onclick="deleteDept('${BaseDept.deptId}',0)">
																	</c:if>
																	<c:if test="${BaseDept.deptState==0 }">
																	<input type="button" class="btn btn-danger btn-xs" id="del"
																	name="del" value='恢复' onclick="deleteDept('${BaseDept.deptId}',1)">
																	</c:if>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="row">
									<!--文字信息-->
									<div class="col-md-6">当前第 ${pageInfo.pageNum} 页.总共
										${pageInfo.pages} 页.一共 ${pageInfo.total} 条记录</div>
									<!--点击分页-->
									<div class="col-md-6">
										<nav aria-label="Page navigation">
											<div align="right">
												<ul class="pagination">

													<li><a
														href=""javascript:jumpPage(1)">首页</a></li>

													<!--上一页-->
													<li><c:if test="${pageInfo.hasPreviousPage}">
															<a
																href="javascript:jumpPage(${pageInfo.pageNum-1})"
																aria-label="Previous"> <span aria-hidden="true">«</span>
															</a>
														</c:if></li>

													<!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
													<c:forEach items="${pageInfo.navigatepageNums}"
														var="page_num">
														<c:if test="${page_num == pageInfo.pageNum}">
															<li class="active"><a href="#">${page_num}</a></li>
														</c:if>
														<c:if test="${page_num != pageInfo.pageNum}">
															<li><a
																href="javascript:jumpPage(${page_num})">${page_num}</a></li>
														</c:if>
													</c:forEach>

													<!--下一页-->
													<li><c:if test="${pageInfo.hasNextPage}">
															<a
																href="javascript:jumpPage(${pageInfo.pageNum+1})"
																aria-label="Next"> <span aria-hidden="true">»</span>
															</a>
														</c:if></li>

													<li><a
														href="javascript:jumpPage(${pageInfo.pages})">尾页</a></li>
												</ul>
											</div>
										</nav>
									</div>
								</div>

							</div>

						</div>
					</div>
				</div>

			</div>
			
			<div class="modal fade" id="deptInfoModal" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">系部详情</h4>
						</div>
						<div class="modal-body">
							<form id="edit_dept_form">
								<div class="form-group">
									<label for="eptId" class="control-label">系部代码：</label>
									<input  type="text" readOnly class="form-control" id="deptId" name="deptId" maxlength="4">
								</div>
								<div class="form-group">
									<label for="deptName" class="control-label">系部名称：</label>
									<input  type="text" maxlength="25" class="form-control" id="deptName" name="deptName">
								</div>

							</form>
						</div>
						<div class="modal-footer">
						    <button type="button" class="btn btn-primary" onclick="saveDeptinfo()">保存</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
						</div>
					</div>
				</div>
			</div>
			</main>
			<!--End 页面主要内容-->
			<div class="modal fade" id="newDeptDialog" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">系部详情</h4>
						</div>
						<div class="modal-body">
							<form id="create_dept_form">
								<div class="form-group">
									<label for="new_deptId" class="control-label">系部代码：</label>
									<input  type="text" class="form-control" id="new_deptId" name="deptId" maxlength="4">
								</div>
								<div class="form-group">
									<label for="new_deptName" class="control-label">系部名称：</label>
									<input  type="text" maxlength="25" class="form-control" id="new_deptName" name="deptName">
								</div>

							</form>
						</div>
						<div class="modal-footer">
						    <button type="button" class="btn btn-primary" onclick="createDept()">添加系部</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/perfect-scrollbar.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/main.min.js"></script>
	<script type="text/javascript">
	function jumpPage(pageNumber){
		  // 先修改访问的页码
		  document.getElementById("page").value = pageNumber;
		  // 手动提交表单
		  document.getElementById("form_query").submit();
	  };
	
	  function clearDept() {
		  $("#new_deptId").val("");
          $("#new_deptName").val("");
		  
	  }
	  
	  function createDept() {
		  if($("#new_deptId").val()=='') {
			  alert("请输入系部代码！");
			  return;
		  }
		  if($("#new_deptName").val()=='') {
			  alert("请输入系部名称！");
			  return;
		  }
		  $.post("<%=basePath%>admin/createDept.action",
					$("#create_dept_form").serialize(),function(data){
					        if(data =="OK"){
					            alert("添加系部成功！");
					            window.location.reload();
					        }else{
					            alert("添加系部失败！");
					            window.location.reload();
					        }
					    });
	  }
	  
	  
	  function editDept(deptId) {
		    $.ajax({
		        type:"get",
		        url:"<%=basePath%>admin/getDeptById.action",
		        data:{"deptId":deptId},
		        success:function(data) {
		            $("#deptId").val(data.deptId);
		            $("#deptName").val(data.deptName);
		        }
		    });
		}
	  
	  function saveDeptinfo() {
		  if($("#deptId").val()=='') {
			  alert("请输入系部代码！");
			  return;
		  }
		  if($("#deptName").val()=='') {
			  alert("请输入系部名称！");
			  return;
		  }
		  $.post("<%=basePath%>admin/updateDept.action",$("#edit_dept_form").serialize(),function(data){
				if(data =="OK"){
					alert("系部信息更新成功！");
					window.location.reload();
				}else{
					alert("系部信息更新失败！");
					window.location.reload();
				}
			});
	  }
	  
	  
	  function deleteDept(deptId,s) {
		  if(confirm('确实要删除/恢复该系吗?')){
			  $.post("<%=basePath%>admin/deleteDept.action",{"deptId":deptId,"s":s},function(data){
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
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
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-application"></i> 系部/专业管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/admin/todeptlist.action">系部/专业</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav open active">
              <a href="javascript:void(0)"><i class="mdi mdi-file"></i> 文件管理</a>
              <ul class="nav nav-subnav">
                <li class="active"> <a href="${pageContext.request.contextPath }/admin/tofilelist.action">学生上传文件管理</a> </li>
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
							<span class="navbar-page-title"> 学生文件管理</span>
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
									action="${pageContext.request.contextPath }/admin/tofilelist.action"
									class="pull-right search-bar" method="post">
									<input id="page" name="pageNum" type="hidden" value="1"/>
									<div class="input-group">
										<div class="input-group-btn">
											<input type="submit" class="btn btn-primary" id="search"
												name="search" value='搜索' >
										</div>
										<input type="text" class="form-control"
											value="${myfile.fName}" name="fName"
											placeholder="请输入文件名称">
									</div>
								</form>
							</div>
							<div class="card-body">
							
								<p></p>
								<div class="table-responsive">
									<table class="table table-bordered" id="tbodyID">
										<thead>
											<tr>
												<th>文件编号</th>
												<th>文件名称</th>
												<th>文件类型</th>
												<th>上传日期</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="myfile" items="${pageInfo.list }"
												varStatus="state">
												<tr>
													<td>${ state.index + 1}</td>
													<td>${myfile.fName }</td>
													<td>${myfile.fType }</td>
													<td><fmt:formatDate value="${myfile.uploadDatetime }" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate></td>
													<td><input type="button" class="btn btn-danger btn-xs" id="del"
																	name="del" value='删除' onclick="deleteFile(${myfile.fId})"></td>
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
	<script type="text/javascript">
	function jumpPage(pageNumber){
		  // 先修改访问的页码
		  document.getElementById("page").value = pageNumber;
		  // 手动提交表单
		  document.getElementById("form_query").submit();
	  };

	  function deleteFile(fId){
		  if(confirm('确实要删除该文件吗?')) {
				$.post("<%=basePath%>file/filedelete.action",{"fId":fId},
				function(data){
				            if(data =="OK"){
				                alert("附件删除成功！");
				                window.location.reload();
				            }else if(data =="FAIL"){
				                alert("删除附件失败！");
				                window.location.reload();
				            }
				        });
		  }
		  
		  
		  
	  }
	</script>
</body>
</html>
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


				<div id="logo" style="height: 55px">
					<p></p>
					<h3 align="center">
						毕业设计管理系统
						</h2>
				</div>
				<div class="lyear-layout-sidebar-scroll">

					<nav class="sidebar-main">
						<ul class="nav nav-drawer">
							<li class="nav-item"><a
								href="${pageContext.request.contextPath }/student/toindex.action"
								onclick="location.reload()"><i class="mdi mdi-home"></i> 首页</a>
							</li>
							<li class="nav-item nav-item-has-subnav active open"><a
								href="javascript:void(0)"><i class="mdi mdi-bank"></i> 选题管理</a>
								<ul class="nav nav-subnav">
									<li><a
										href="${pageContext.request.contextPath }/student/totitlelist.action">学生选题</a>
									</li>
									<li class="active"><a
										href="${pageContext.request.contextPath }/student/selTitleById.action">我的选题</a></li>
								</ul></li>
							<li class="nav-item nav-item-has-subnav"><a
								href="javascript:void(0)"><i class="mdi mdi-file-outline"></i>
									任务书管理</a>
								<ul class="nav nav-subnav">
									<li><a
										href="${pageContext.request.contextPath }/student/projBooklist.action">任务书</a></li>
								</ul></li>
							<li class="nav-item nav-item-has-subnav"><a
								href="javascript:void(0)"><i class="mdi mdi-file-outline"></i>
									开题报告管理</a>
								<ul class="nav nav-subnav">
									<li><a
										href="${pageContext.request.contextPath }/student/openReportlist.action">开题报告
											(学生)</a></li>
								</ul></li>
							<li class="nav-item nav-item-has-subnav"><a
								href="javascript:void(0)"><i class="mdi mdi-tab"></i> 中期检查</a>
								<ul class="nav nav-subnav">
									<li><a
										href="${pageContext.request.contextPath }/student/midChecklist.action">中期检查</a></li>
								</ul></li>
							<li class="nav-item nav-item-has-subnav"><a
								href="javascript:void(0)"><i class="mdi mdi-file-document"></i>
									论文管理</a>
								<ul class="nav nav-subnav">
									<li><a
										href="${pageContext.request.contextPath }/student/thesislist.action">学生论文
											(在线提交)</a></li>
								</ul></li>
							<li class="nav-item nav-item-has-subnav"><a
								href="javascript:void(0)"><i class="mdi mdi-attachment"></i>
									附件</a>
								<ul class="nav nav-subnav">
									<li><a
										href="${pageContext.request.contextPath }/student/thesisAttachmentlist.action">附件上传
											(学生)</a></li>
								</ul></li>

							<li class="nav-item nav-item-has-subnav"><a
								href="javascript:void(0)"><i class="mdi mdi-scale-balance"></i>
									总评</a>
								<ul class="nav nav-subnav">
									<li><a
										href="${pageContext.request.contextPath }/student/studentScore.action">成绩总评
											(学生)</a></li>
								</ul></li>
						</ul>
					</nav>

					<div class="sidebar-footer"></div>
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
							<span class="navbar-page-title"> 学生选题 </span>
						</div>

						<ul class="topbar-right">
							<li class="dropdown dropdown-profile"><a
								href="javascript:void(0)" data-toggle="dropdown"> <span
									style="color: black">${USER_INFO.sName} <span
										class="caret"></span></span>
							</a>
								<ul class="dropdown-menu dropdown-menu-right">
									<li><a
										href="${pageContext.request.contextPath }/student/topersonInfo.action"><i
											class="mdi mdi-account"></i> 个人信息</a></li>
									<li><a
										href="${pageContext.request.contextPath }/student/toeditPwd.action"><i
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
			<div class="modal fade" id="titleInfoModal" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">课题详情</h4>
						</div>
						<div class="modal-body">
							<form id="selectById_title_form">
								<div class="form-group">
									<label for="recipient-name" class="control-label">课题名称：</label>
									<input readonly type="text" class="form-control" id="titlName">
								</div>
								<div class="form-group">
									<label for="major" class="control-label">所属专业：</label> <input
										readonly type="text" class="form-control" id="major1">
								</div>
								<div class="form-group">
									<label for="message-text" class="control-label">课题来源：</label>
									<div class="example-box">
										<label class="lyear-radio radio-inline radio-primary">
											<input type="radio" disabled name="e" id="radio1"
											value="教师科研"><span>教师科研</span>
										</label> <label class="lyear-radio radio-inline radio-primary">
											<input type="radio" disabled name="e" id="radio2"
											value="社会生产实践"><span>社会生产实践</span>
										</label> <label class="lyear-radio radio-inline radio-primary">
											<input type="radio" disabled name="e" id="radio3" value="教学"><span>教学</span>
										</label> <label class="lyear-radio radio-inline radio-primary">
											<input type="radio" disabled name="e" id="radio4" value="其他"><span>其他</span>
										</label>
									</div>
								</div>
								<p></p>
								<div class="form-group">
									<label for="message-text" class="control-label">课题类型：</label>
									<div class="example-box">
										<label class="lyear-radio radio-inline radio-primary">
											<input type="radio" disabled name="ee" id="radio5"
											value="工程设计类"><span>工程设计类</span>
										</label> <label class="lyear-radio radio-inline radio-primary">
											<input type="radio" disabled name="ee" id="radio6"
											value="理论研究类"><span>理论研究类</span>
										</label> <label class="lyear-radio radio-inline radio-primary">
											<input type="radio" disabled name="ee" id="radio7"
											value="应用(试验)研究类"><span>应用(试验)研究类</span>
										</label> <label class="lyear-radio radio-inline radio-primary">
											<input type="radio" disabled name="ee" id="radio8"
											value="软件设计类"><span>软件设计类</span>
										</label><label class="lyear-radio radio-inline radio-primary">
											<input type="radio" disabled name="ee" id="radio9" value="其他"><span>其他</span>
										</label>
									</div>
								</div>
								<p></p>
								<div class="form-group">
									<label for="message-text" class="control-label">课题描述：</label>
									<div class="example-box">
										<textarea readonly style="height: 200px" class="form-control"
											id="titlDescribe"></textarea>
									</div>
									<p></p>
									<div class="form-group">
										<label for="message-text" class="control-label">指导教师：</label>
										<div class="example-box">
											<input readonly type="text" class="form-control" id="tName">
										</div>
									</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
						</div>
					</div>
				</div>
			</div>
			<!--页面主要内容-->
			<main class="lyear-layout-content">

			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-toolbar clearfix">
								<form id="form_query"
									action="${pageContext.request.contextPath }/student/selTitleById.action"
									class="pull-right search-bar" method="post"">
									<input id="page" name="pageNum" type="hidden" value="1" />
									<div class="input-group">
										<div class="input-group-btn">
											<input type="submit" class="btn btn-primary" id="search"
												name="search" value='搜索'>
										</div>
										<input type="text" class="form-control"
											value="${title.titlName}" name="titlName"
											placeholder="请输入课题名称">
									</div>
								</form>
							</div>
							<div class="card-body">
								<p></p>
								<c:if test="${i==0}">
								<input type="button" class="btn btn-primary" data-toggle="modal"
									data-target="#newtitleInfoModal" value='申请新课题' onclick="clearTitle()">
								</c:if>	
								<p></p>

								<div class="table-responsive">
									<table class="table table-bordered" id="tbodyID">
										<thead>
											<tr>
												<th>课题编号</th>
												<th>课题名称</th>
												<th>指导教师</th>
												<th>课题来源</th>
												<th>课题类型</th>
												<th>选题状态</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="selectTitle" items="${pageInfo.list }"
												varStatus="state">
												<tr>
													<td>${selectTitle.titlId}</td>
													<td><a data-toggle="modal"
														data-target="#titleInfoModal" href="javascript:void(0);"
														onclick="getTitle(${selectTitle.titlId})">${selectTitle.titlName }</a></td>
													<td>${selectTitle.tName }</td>
													<td>${selectTitle.titlSource }</td>
													<td>${selectTitle.titlType }</td>
													<td><span
														<c:if test="${selectTitle.seltitlState == '拒绝'}">class="label label-danger"</c:if>
														<c:if test="${selectTitle.seltitlState == '同意'}">class="label label-success"</c:if>
														<c:if test="${selectTitle.seltitlState == '待同意'}">class="label label-warning"</c:if>
														<c:if test="${selectTitle.seltitlState == '待专业负责人审批'}">class="label label-warning"</c:if>>${selectTitle.seltitlState }</span></td>
													<!-- <c:if test="${selectTitle.seltitlState == '拒绝'}">class="label label-danger"</c:if> <c:if test="${selectTitle.seltitlState == '同意'}">class="label label-success"</c:if> <c:if test="${selectTitle.seltitlState == '同意'}">class="label label-warning"</c:if>-->
													<td><c:choose>
															<c:when test="${selectTitle.seltitlState eq '待同意'}">
																<div class="input-group-btn">
																	<input type="button" class="btn btn-primary btn-xs"
																		id="del" name="search" value='退选'
																		onclick="delSelTitle(${selectTitle.titlId})">
																</div>
															</c:when>
															<c:otherwise>
													             &nbsp;&nbsp;&nbsp;无
													        </c:otherwise>
														</c:choose></td>
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

													<li><a href=""javascript:jumpPage(1)">首页</a></li>

													<!--上一页-->
													<li><c:if test="${pageInfo.hasPreviousPage}">
															<a href="javascript:jumpPage(${pageInfo.pageNum-1})"
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
															<li><a href="javascript:jumpPage(${page_num})">${page_num}</a></li>
														</c:if>
													</c:forEach>

													<!--下一页-->
													<li><c:if test="${pageInfo.hasNextPage}">
															<a href="javascript:jumpPage(${pageInfo.pageNum+1})"
																aria-label="Next"> <span aria-hidden="true">»</span>
															</a>
														</c:if></li>

													<li><a href="javascript:jumpPage(${pageInfo.pages})">尾页</a></li>
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

			<div class="modal fade" id="newtitleInfoModal" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">课题详情</h4>
						</div>
						<div class="modal-body">
							<form id="new_title_form">
								<div class="form-group">
									<label for="recipient-name" class="control-label">课题名称：</label>
									<input type="text" maxlength="32" class="form-control"
										id="new_titlName" name="titlName">
								</div>

								<input type="text" hidden="hidden" id="new_major" name="major" value="${USER_INFO.major }">
								<input type="text" hidden="hidden" id="sId" name="sId" value="${USER_INFO.sId }">
								<div class="form-group">
									<label for="message-text" class="control-label">课题来源：</label>
									<div class="example-box">
										<label class="lyear-radio radio-inline radio-primary">
											<input type="radio" name="titlSource" id="new_radio1"
											value="教师科研"><span>教师科研</span>
										</label> <label class="lyear-radio radio-inline radio-primary">
											<input type="radio" name="titlSource" id="new_radio2"
											value="社会生产实践"><span>社会生产实践</span>
										</label> <label class="lyear-radio radio-inline radio-primary">
											<input type="radio" name="titlSource" id="new_radio3" value="教学"><span>教学</span>
										</label> <label class="lyear-radio radio-inline radio-primary">
											<input type="radio" name="titlSource" id="new_radio4" value="其他"><span>其他</span>
										</label>
									</div>
								</div>
								<p></p>
								<div class="form-group">
									<label for="message-text" class="control-label">课题类型：</label>
									<div class="example-box">
										<label class="lyear-radio radio-inline radio-primary">
												<input type="radio" name="titlType" id="new_radio5"
												value="工程设计类"><span>工程设计类</span>
											</label> <label class="lyear-radio radio-inline radio-primary">
												<input type="radio" name="titlType" id="new_radio6"
												value="理论研究类"><span>理论研究类</span>
											</label> <label class="lyear-radio radio-inline radio-primary">
												<input type="radio" name="titlType" id="new_radio7"
												value="应用(试验)研究类"><span>应用(试验)研究类</span>
											</label> <label class="lyear-radio radio-inline radio-primary">
												<input type="radio" name="titlType" id="new_radio8"
												value="软件设计类"><span>软件设计类</span>
											</label><label class="lyear-radio radio-inline radio-primary">
												<input type="radio" name="titlType" id="new_radio9"
												value="其他"><span>其他</span>
											</label>
									</div>
								</div>
								<p></p>
								<div class="form-group">
									<label for="message-text" class="control-label">课题描述：</label>
									<div class="example-box">
										<textarea style="height: 200px" class="form-control"
											id="new_titlDescribe" name="titlDescribe"></textarea>
									</div>
									<p></p>
									<div class="form-group">
										<label for="major" class="control-label">指导教师：</label> <select
											class="form-control" id="new_tName" name="tId">
											<option value="-1">--请选择--</option>
											<c:forEach items="${Teacher}" var="item">
												<option value="${item.tId}">${item.tName }
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
						    <button type="button" class="btn btn-primary" onclick="newTitle()">提交申请</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
						</div>
					</div>
				</div>
			</div>
			</main>
			<!--End 页面主要内容-->

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
	    //根据课题Id查询课题详细信息
	    function getTitle(titlId) {
	    	$.ajax({
		        type:"get",
		        url:"<%=basePath%>student/getTitleInfoById.action",
				data : {
					"titlId" : titlId
				},
				success : function(titleInfo) {
					$("#titlName").val(titleInfo.titlName);
					$("#major1").val(titleInfo.major);
					if(titleInfo.titlSource=='教师科研'){
						$("#radio1").prop("checked",true);
					}else if(titleInfo.titlSource=='社会生产实践') {
						$("#radio2").prop("checked",true);
					}else if(titleInfo.titlSource=='教学') {
						$("#radio3").prop("checked",true);
					}else if(titleInfo.titlSource=='其他') {
						$("#radio4").prop("checked",true);
					}
					if(titleInfo.titlType=='工程设计类') {
						$("#radio5").prop("checked",true);
					}else if(titleInfo.titlType=='理论研究类') {
						$("#radio6").prop("checked",true);
					}else if(titleInfo.titlType=='应用(试验)研究类') {
						$("#radio7").prop("checked",true);
					}else if(titleInfo.titlType=='软件设计类') {
						$("#radio8").prop("checked",true);
					}else if(titleInfo.titlType=='其他') {
						$("#radio9").prop("checked",true);
					}
					$("#titlDescribe").val(titleInfo.titlDescribe);
					$("#tName").val(titleInfo.teacher.tName);
				}
			});
		}
	    
	    //删除选题信息(退选)
	    function delSelTitle(id) {
	    	if(confirm('确实要退选该课题吗?')) {
	    		$.post("<%=basePath%>student/delTitleInfoById.action",{"id":id},
	    		function(data){
	    		            if(data =="OK"){
	    		                alert("退选成功！");
	    		                window.location.reload();
	    		            }else{
	    		                alert("退选失败！");
	    		                window.location.reload();
	    		            }
	    		        });
	    		    }
	    }
	    
	    function clearTitle() {
			  $("#new_titlName").val("");
			  $("#new_radio1").removeAttr("checked");
			  $("#new_radio2").removeAttr("checked");
			  $("#new_radio3").removeAttr("checked");
			  $("#new_radio4").removeAttr("checked");
			  $("#new_radio5").removeAttr("checked");
			  $("#new_radio6").removeAttr("checked");
			  $("#new_radio7").removeAttr("checked");
			  $("#new_radio8").removeAttr("checked");
			  $("#new_titlDescribe").val(""); 
			  $("#new_tName").val("-1");
		  }
	    
	    //申请新课题
	    function newTitle() {
	    	var titlSource=$('input:radio[name="titlSource"]:checked').val();
	    	var titlType=$('input:radio[name="titlType"]:checked').val();
	    	var content = document.getElementById('new_titlDescribe').value;
	    	if($("#new_titlName").val()=="") {
	    		alert("请输入课题名称！");
	    		return;
	    	}
	    	if(titlSource==null){
	    		alert("请选择课题来源！");
	    		return;
	    	}
	    	if(titlType==null){
	    		alert("请选择课题类型");
	    		return;
	    	}
	    	if(content==''||content==null) {
	    		alert("请输入课题描述！");
	    		return;
	    	}
	    	if($("#new_tName").val()=="-1") {
	    		alert("请选择指导教师！");
	    		return;
	    	}
	    	$.post("<%=basePath%>teacher/createTitle1.action",
	    			$("#new_title_form").serialize(),function(data){
	    			        if(data =="OK"){
	    			            alert("申请课题成功！");
	    			            window.location.reload();
	    			        }else{
	    			            alert("申请课题失败！");
	    			            window.location.reload();
	    			        }
	    			    });
	    }
	</script>
</body>
</html>
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
            <li class="nav-item"> <a href="${pageContext.request.contextPath }/teacher/leading/Index.action"><i class="mdi mdi-home"></i> 首页</a> </li>
            <li class="nav-item nav-item-has-subnav open active">
              <a href="javascript:void(0)"><i class="mdi mdi-bank"></i> 课题管理</a>
              <ul class="nav nav-subnav">
                <li class="active"> <a href="${pageContext.request.contextPath }/teacher/leading/totitlelist.action">已审核课题</a> </li>
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
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-cube"></i> 答辩管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/teacher/leading/toreply.action">答辩安排</a> </li>
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
							<span class="navbar-page-title"> 教师课题 </span>
						</div>

						<ul class="topbar-right">
							<li class="dropdown dropdown-profile"><a
								href="javascript:void(0)" data-toggle="dropdown"> <span
									style="color: black">${USER_INFO.tName} <span
										class="caret"></span></span>
							</a>
								<ul class="dropdown-menu dropdown-menu-right">
									<li><a
										href="${pageContext.request.contextPath }/teacher/leading/topersonInfo.action"><i
											class="mdi mdi-account"></i> 个人信息</a></li>
									<li><a
										href="${pageContext.request.contextPath }/teacher/leading/toeditPwd.action"><i
											class="mdi mdi-lock-outline"></i> 修改密码</a></li>
									<li class="divider"></li>
									<li><a
										href="${pageContext.request.contextPath }/logout.action"><i
											class="mdi mdi-logout-variant"></i> 退出登录</a></li>
								</ul></li>
            <a href="${pageContext.request.contextPath }/teacher/roleset.action">
            <span>切换角色权限</span>
            </a>
						</ul>

					</div>
				</nav>
				

			</header>
			<div class="modal fade" id="studentInfoModal" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">学生详情</h4>
						</div>
						<div class="modal-body">
							<form id="student_form">
							<div class="form-group">
									<label for="recipient-name" class="control-label">学生学号：</label>
									<input type="text" readOnly class="form-control" name="sId" id="sId">
								</div>
								<div class="form-group">
									<label for="recipient-name" class="control-label">学生名字：</label>
									<input type="text" readOnly class="form-control" name="sName" id="sName">
								</div>
										
										<div class="form-group">
											<label for="message-text" class="control-label">系部：</label>
											<input type="text" readOnly class="form-control" name="dept" id="dept">
											</div>
										<div class="form-group">
											<label for="message-text" class="control-label">专业：</label>
											<input type="text" readOnly class="form-control" name="major" id="major">
											</div>
										<div class="form-group">
											<label for="message-text" class="control-label">班级：</label>
											<input type="text" readOnly class="form-control" name="sClass" id="sClass">
											</div>
										<div class="form-group">
											<label for="message-text" class="control-label">批次：</label>
											<input type="text" readOnly class="form-control" name="batch" id="batch">
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
			<!--End 头部信息-->
<div>
				<div class="modal fade" id="setStudentModal" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">指定学生</h4>
						</div>
						<div class="modal-body">
							<form id="student_form1">
							<input type="text" hidden="hidden" id="settitlId" name="titlId">
								<div class="form-group">
									<select class="form-control " id="setsId" name="sId">
									<option value="-1">--请选择--</option>
									<c:forEach var="type" items="${list1 }">
									<option value="${type.sId }">${type.sId } ${type.sName }</option>
									</c:forEach>       
                                    </select>
								</div>
										<div class="modal-footer">
						    <button type="button" class="btn btn-primary" onclick="setStudent()">保存</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
						</div>
										
							</form>
						</div>
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
									action="${pageContext.request.contextPath }/teacher/leading/totitlelist.action"
									class="pull-right search-bar" method="post"">
									<input id="page" name="pageNum" type="hidden" value="1"/>
									<div class="input-group">
										<div class="input-group-btn">
											<input type="submit" class="btn btn-primary" id="search"
												name="search" value='搜索' >
										</div>
										<input type="text" class="form-control"
											value="${title.titlName}" name="titlName"
											placeholder="请输入课题名称">
									</div>
								</form>
							</div>
							<div class="card-body">
									
								<p></p>
								<div class="table-responsive">
									<table class="table table-bordered" id="tbodyID">
										<thead>
											<tr>
												<th>课题编号</th>
												<th>课题名称</th>
												<th>学生</th>
												<th>指导教师</th>
												<th>课题来源</th>
												<th>课题类型</th>
												<th>课题状态</th>
												<th>选题状态</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="title" items="${pageInfo.list }"
												varStatus="state">
												<tr>	
													<td>${title.titlId }</td>
													<td><a data-toggle="modal"
														data-target="#titleInfoModal" href="javascript:void(0);"
														onclick="getTitle(${title.titlId})">${title.titlName }</a></td>
													<td>
													<c:if test="${title.sName !=null}"><a data-toggle="modal"
														data-target="#studentInfoModal" href="javascript:void(0);"
														onclick="getStudent(${title.sId})">${title.sName}</a></c:if>
													</td>
													<td>${title.tId}${title.tName}</td>
													<td>${title.titlSource }</td>
													<td>${title.titlType }</td>
													<td><span <c:if test="${title.titlState == '审批不通过'}">class="label label-danger"</c:if> <c:if test="${title.titlState == '已审批'}">class="label label-success"</c:if> <c:if test="${title.titlState == '待审批'}">class="label label-warning"</c:if>>${title.titlState }</span></td>
													<td>${title.selState }</td>
													<td><c:if test="${title.sName == null and title.titlState == '已审批'}"><a data-toggle="modal"
														data-target="#setStudentModal" href="javascript:void(0);"
														onclick="check(${title.titlId})">指定学生</a></c:if>
														<c:if test="${title.sName !=null or title.titlState == '审批不通过'}">无</c:if>
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
			<div>
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
									<label for="major" class="control-label">所属专业：</label>
									<input readonly type="text" class="form-control" id="major1">
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
												<input type="radio" disabled name="ee" id="radio9"
												value="其他"><span>其他</span>
											</label>
										</div>
										<p></p>
										<div class="form-group">
											<label for="message-text" class="control-label">课题描述：</label>
											<div class="example-box">
												<textarea readonly style="height: 200px"
													class="form-control" id="titlDescribe"></textarea>
											</div>
											<p></p>
											<div class="form-group">
												<label for="message-text" class="control-label">指导教师：</label>
												<div class="example-box">
													<input readonly type="text" class="form-control" id="tName">
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
			</div>
			
			</main>
			<!--End 页面主要内容-->
			<div>
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
									<input type="text" class="form-control" name="titlName" id="titlName">
								</div>
								<div class="form-group">
									<label for="message-text" class="control-label">课题来源：</label>
									<div class="example-box">
										<label class="lyear-radio radio-inline radio-primary">
											<input type="radio" name="titlSource" id="radio1"
											value="教师科研"><span>教师科研</span>
										</label> <label class="lyear-radio radio-inline radio-primary">
											<input type="radio" name="titlSource" id="radio2"
											value="社会生产实践"><span>社会生产实践</span>
										</label> <label class="lyear-radio radio-inline radio-primary">
											<input type="radio" name="titlSource" id="radio3" value="教学"><span>教学</span>
										</label> <label class="lyear-radio radio-inline radio-primary">
											<input type="radio" name="titlSource" id="radio4" value="其他"><span>其他</span>
										</label>
									</div>
									<p></p>
									<div class="form-group">
										<label for="message-text" class="control-label">课题类型：</label>
										<div class="example-box">
											<label class="lyear-radio radio-inline radio-primary">
												<input type="radio" name="titlType" id="radio5"
												value="工程设计类"><span>工程设计类</span>
											</label> <label class="lyear-radio radio-inline radio-primary">
												<input type="radio" name="titlType" id="radio6"
												value="理论研究类"><span>理论研究类</span>
											</label> <label class="lyear-radio radio-inline radio-primary">
												<input type="radio" name="titlType" id="radio7"
												value="应用(试验)研究类"><span>应用(试验)研究类</span>
											</label> <label class="lyear-radio radio-inline radio-primary">
												<input type="radio" name="titlType" id="radio8"
												value="软件设计类"><span>软件设计类</span>
											</label><label class="lyear-radio radio-inline radio-primary">
												<input type="radio" name="titlType" id="radio9"
												value="其他"><span>其他</span>
											</label>
										</div>
										<p></p>
										<div class="form-group">
											<label for="message-text" class="control-label">课题描述：</label>
											<div class="example-box">
												<textarea style="height: 200px"
													class="form-control" name="titlDescribe" id="titlDescribe"></textarea>
											</div>
											<p></p>
											<div class="form-group">
												<label for="message-text" class="control-label">指导教师：</label>
												<div class="example-box">
													<input readonly type="text" class="form-control" id="tName" value="${USER_INFO.tName }">
												</div>
											</div>
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
	  
	  //查看学生信息
	  function getStudent(sId) {
		  $.ajax({
		        type:"get",
		        url:"<%=basePath%>teacher/getStudentInfoById.action",
				data : {
					"sId" : sId
				},
				success : function(student) {
					$("#sId").val(student.sId);
					$("#sName").val(student.sName);
					$("#sClass").val(student.sClass);
					$("#dept").val(student.dept);
					$("#major").val(student.major);
					$("#batch").val(student.batch);
				}
			});
		  
	  }
	  
	  //筛选本专业未选课题的学生
	  function check(titlId) {
		  $("#settitlId").val(titlId);
		  $("#setsId").val(-1);
	  }
	  
	  //给未选课题指定学生
	  function setStudent() {
		  if($("#setsId").val()=='-1'){
			  alert("请选择学生！");
			  return;
		  }
		  $.post("<%=basePath%>teacher/leading/setStudent.action",
	    			$("#student_form1").serialize(),function(data){
	    			        if(data =="OK"){
	    			            alert("操作成功！");
	    			            window.location.reload();
	    			        }else{
	    			            alert("操作失败！");
	    			            window.location.reload();
	    			        }
	    			    });
		  
	  }
	  
	  //删除课题
	  function deleteTitle(titlId) {
		  if(confirm('确实要删除该课题吗? 该题的学生选题信息也会被删除')) {
				$.post("<%=basePath%>teacher/titledelete.action",{"titlId":titlId},
				function(data){
				            if(data =="OK"){
				                alert("课题删除成功！");
				                window.location.reload();
				            }else if(data =="FAIL"){
				                alert("删除课题失败！");
				                window.location.reload();
				            }
				        });
		  }
	  }
	  
	  
	  
	    //查看课题信息
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
	    
	    //申请新课题
	    function newTitle() {
	    	$.post("<%=basePath%>teacher/createTitle.action",
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
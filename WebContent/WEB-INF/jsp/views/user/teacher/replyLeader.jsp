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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <li class="nav-item nav-item-has-subnav active open">
              <a href="javascript:void(0)"><i class="mdi mdi-bank"></i> 审阅评分</a>
              <ul class="nav nav-subnav">
                <c:if test="${i!=0 }"><li class="active"><a href="${pageContext.request.contextPath }/teacher/toReplyleader.action">我的答辩组</a></li></c:if>
                <li> <a href="${pageContext.request.contextPath }/teacher/toreview.action">论文评分</a> </li>
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
							<span class="navbar-page-title"> 我的答辩组 </span>
						</div>

						<ul class="topbar-right">
							<li class="dropdown dropdown-profile"><a
								href="javascript:void(0)" data-toggle="dropdown"> <span
									style="color: black">${USER_INFO.tName} <span
										class="caret"></span></span>
							</a>
								<ul class="dropdown-menu dropdown-menu-right">
									<li><a
										href="${pageContext.request.contextPath }/teacher/topersonInfo.action"><i
											class="mdi mdi-account"></i> 个人信息</a></li>
									<li><a
										href="${pageContext.request.contextPath }/teacher/toeditPwd.action"><i
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
			<!--End 头部信息-->
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
			<!--页面主要内容-->
			<main class="lyear-layout-content">

			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-toolbar clearfix">
								<form id="form_query"
									action="${pageContext.request.contextPath }/teacher/toReplyleader.action"
									class="pull-right search-bar" method="post">
									<input id="page" name="pageNum" type="hidden" value="1" />
									<div class="input-group">
										<div class="input-group-btn">
										<input type="submit" class="btn btn-primary" id="search"
												name="search" value='搜索' >
										</div>
										<input type="text" class="form-control"
											value="${review.sName}" name="sName"
											placeholder="请输入学生名称">
									</div>
								</form>
							</div>
							<div class="card-body">	
								<p></p>
								<div class="table-responsive">
									<table class="table table-bordered" id="tbodyID">
										<thead>
											<tr>
												<th>序号</th>
												<th>答辩组编号</th>
												<th>选题名称</th>
												<th>论文</th>
												<th>学生</th>
												<th>批次</th>
												<th>指导教师</th>
												<th>评阅教师</th>
												<th>评阅得分</th>
												<th>评阅详情</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${pageInfo.list }"
												varStatus="state">
												<tr>
													<td>${ state.index + 1}</td>
													<td>${item.replyId }</td>
													<td><a data-toggle="modal"
														data-target="#titleInfoModal" href="javascript:void(0);"
														onclick="getTitle(${item.titlId})">${item.titlName }</a></td>
													<td><button style="border:0;background: none;" type="button" data-toggle="tooltip" data-placement="top" title="第一次预览可能需要等待较长时间"><a href="${pageContext.request.contextPath }/file/toPdfProjBook.action?num1=${item.fId }&num2=${item.tId }">${item.fName }</a></button></td>
													<td><a data-toggle="modal"
														data-target="#studentInfoModal" href="javascript:void(0);"
														onclick="getStudent(${item.sId})">${item.sName}</a></td>
													<td>${item.batch }</td>
													<td>${item.tName}</td>
													<td>${item.memberTName2 }</td>
													<td><button style="border:0;background: none;" type="button" data-toggle="tooltip" data-placement="top" title="成绩顺序对应左边评阅教师顺序">${item.reviewScore2 } <c:if test="${item.replyScore2!=null }"> (已录入)</c:if><c:if test="${item.replyScore2==null }"> (未录入)</c:if></button></td>
													<td><input type="button" class="btn btn-primary btn-xs" data-toggle="modal"
														data-target="#reviewInfoModal" href="javascript:void(0);" value="查看"
														onclick="getReviewBySId('${item.sId}')" />
													</td>
													<td>
													
													<input data-toggle="modal"
														data-target="#commentsInfoModal" type="button" class="btn btn-primary btn-xs" id="comment"
																	name="search2" value='录入成绩' onclick="saveScore ('${item.sId}',${item.titlId })">		
																	&nbsp;
																	<a href="${pageContext.request.contextPath }/file/filedown.action?fId=${item.fId}&tId=${item.tId}&tName=${item.tName}"><input type="button" class="btn btn-primary btn-xs" id="download"
																	name="search" value='下载文件'>	
																	</a>
												                   	
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
										</div>
										<p></p>
										<div class="form-group">
											<label for="message-text" class="control-label">课题描述：</label>
											<div class="example-box">
												<textarea readonly style="height: 200px"
													class="form-control" id="titlDescribe"></textarea>
											</div>
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
			</main>
			<!--End 页面主要内容-->
			<div class="modal fade" id="reviewInfoModal" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">评语详情</h4>
						</div>
						<div class="modal-body">
							<form id="studentScore_form">
							<input hidden="hidden" type="text" id="s_Id" name="sId">			
										<div class="form-group">
											<div class="form-group">
											<label for="replyLeader" class="control-label">答辩组组长：</label>
											<input readOnly type="text" class="form-control" name="replyLeader" id="replyLeader" />
											<label for="reviewScore" class="control-label">答辩组组长评分：</label>
											<input readOnly type="text" class="form-control" name="reviewScore" id="reviewScore" />
											<label for="review_Comments" class="control-label">答辩组长评语：</label>
												<textarea readOnly style="height: 100px"
													class="form-control" id="review_Comments" name="reviewComments"></textarea>
											</div>
											<p></p>
											
											<div class="form-group">
											<label for="replyLeader1" class="control-label">评阅教师：</label>
											<input readOnly type="text" class="form-control" name="memberTName1" id="memberTName1" />
											<label for="reviewScore1" class="control-label">评阅教师评分评分：</label>
											<input readOnly type="text" class="form-control" name="reviewScore1" id="reviewScore1" />
											<label for="review_Comments" class="control-label">评阅教师评语：</label>
												<textarea readOnly style="height: 100px"
													class="form-control" id="review_Comments1" name="reviewComments"></textarea>
											</div>
											<p></p>
											
											<div class="form-group">
											<label for="replyLeader2" class="control-label">评阅教师：</label>
											<input readOnly type="text" class="form-control" name="memberTName2" id="memberTName2" />
											<label for="reviewScore2" class="control-label">评阅教师评分评分：</label>
											<input readOnly type="text" class="form-control" name="reviewScore2" id="reviewScore2" />
											<label for="review_Comments" class="control-label">评阅教师评语：</label>
												<textarea readOnly style="height: 100px"
													class="form-control" id="review_Comments2" name="reviewComments"></textarea>
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
	
	  //下载文件
	  function getfId (fId) {
		  $.post("<%=basePath%>file/filedown.action",{"fId":fId}
					);
	  }
	  

	//评阅教师对论文编辑评语、评分
	    function getReviewBySId(sId) {
	    	$.ajax({
		        type:"get",
		        url:"<%=basePath%>teacher/getReviewBySId.action",
				data : {
					"sId" : sId
				},
				success : function(review) {
					$("#replyLeader").val(review[0].memberTName);
					$("#review_Comments").val(review[0].reviewComments);
					$("#reviewScore").val(review[0].reviewScore);
					$("#memberTName1").val(review[1].memberTName);
					$("#review_Comments1").val(review[1].reviewComments);
					$("#reviewScore1").val(review[1].reviewScore);
					$("#memberTName2").val(review[2].memberTName);
					$("#review_Comments2").val(review[2].reviewComments);
					$("#reviewScore2").val(review[2].reviewScore);
					
				}
			});
	    }
	    
	  //保存评阅教师建议和成绩
	    function saveScore(sId,titlId) {
	    	if(confirm('录入前请检查该学生所有评阅成绩是否齐全, 确定录入该学生的成绩吗?')) {
	    		$.post("<%=basePath%>teacher/saveScore.action",{"sId":sId,"titlId":titlId},
	    		    	function(data){
	    		    		if(data =="OK"){
	    			            alert("学生答辩成绩录入成功！");
	    			            window.location.reload();
	    			        }else if(data == "FAIL"){
	    			            alert("学生答辩成绩录入失败！");
	    			            window.location.reload();
	    			        }else if(data == "FAIL1"){
	    			            alert("录入失败！该学生存在成绩为0的评阅成绩");
	    			            window.location.reload();
	    			        }
	    			    });
	    		
	    	}

	    }
	    
	</script>
</body>
</html>
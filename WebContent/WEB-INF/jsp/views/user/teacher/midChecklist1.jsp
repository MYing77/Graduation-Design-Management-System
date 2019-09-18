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
            <li class="nav-item"> <a href="${pageContext.request.contextPath }/teacher/toindex.action"><i class="mdi mdi-home"></i> 首页</a> </li>
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
            <li class="nav-item nav-item-has-subnav ">
              <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i> 开题报告管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/teacher/openReportlist.action">已审核开题报告</a> </li>
                <li> <a href="${pageContext.request.contextPath }/teacher/openReportlist1.action">待审核开题报告</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav active open">
              <a href="javascript:void(0)"><i class="mdi mdi-tab"></i> 中期检查</a>
              <ul class="nav nav-subnav">
                <li> <a href="${pageContext.request.contextPath }/teacher/midChecklist.action">已审核中期检查</a> </li>
                <li class="active"> <a href="${pageContext.request.contextPath }/teacher/midChecklist1.action">待审核中期检查</a> </li>
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
								<span class="lyear-toggler-bar"></span> <span
									class="lyear-toggler-bar"></span> <span
									class="lyear-toggler-bar"></span>
							</div>
							<span class="navbar-page-title"> 待审核中期检查 </span>
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

			<!--页面主要内容-->
			<main class="lyear-layout-content">

			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-toolbar clearfix">
								<form id="form_query"
									action="${pageContext.request.contextPath }/teacher/midChecklist1.action"
									class="pull-right search-bar" method="post"">
									<input id="page" name="pageNum" type="hidden" value="1" />
									<div class="input-group">
										<div class="input-group-btn">
											<input type="submit" class="btn btn-primary" id="search"
												name="search" value='搜索'>
										</div>
										<input type="text" class="form-control"
											value="${midCheck.fName}" name="fName"
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
												<th>序号</th>
												<th>选题名称</th>
												<th>学生</th>
												<th>专业</th>
												<th>批次</th>
												<th>文件名称</th>
												<th>上传时间</th>
												<th>指导教师</th>
												<th>状态</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="midCheck" items="${pageInfo.list }"
												varStatus="state">
												<tr>
													<td>${ state.index + 1}</td>
													<td>${midCheck.titlName}</td>
													<td>${midCheck.sName}</td>
													<td>${midCheck.major}</td>
													<td>${midCheck.batch}</td>
													<td>
													<button style="border:0;background: none;" type="button" data-toggle="tooltip" data-placement="top" title="第一次预览可能需要等待较长时间"><a href="${pageContext.request.contextPath }/file/toPdfProjBook.action?num1=${midCheck.fId }&num2=${midCheck.tId }">${midCheck.fName }</a></button>
													</td>
													<td><fmt:formatDate value="${midCheck.uploadDatetime }" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate></td>
													<td>${midCheck.tName }</td>
													<td><span <c:if test="${midCheck.agree == '不通过'}">class="label label-danger"</c:if> <c:if test="${midCheck.agree == '通过'}">class="label label-success"</c:if> <c:if test="${midCheck.agree == '待通过'}">class="label label-warning"</c:if>>${midCheck.agree }</span></td>
													<td>
													<input data-toggle="modal"
														data-target="#commentsInfoModal" type="button" class="btn btn-primary btn-xs" id="comment"
																	name="search2" value='审核' onclick="Values('${midCheck.sId}',${midCheck.fId})">
													<a href="${pageContext.request.contextPath }/file/filedown.action?fId=${midCheck.fId}&tId=${midCheck.tId}&tName=${midCheck.tName}"><input type="button" class="btn btn-primary btn-xs" id="download"
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
			<div class="modal fade" id="commentsInfoModal" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="exampleModalLabel">建议详情</h4>
						</div>
						<div class="modal-body">
							<form id="comments_form">
							<input hidden="hidden" type="text" id="sId" name="sId">
							<input hidden="hidden" type="text" id="fId" name="fId">
							<input hidden="hidden" type="text" id="role" name="role" value="中期检查">
										<div class="form-group">
											<label for="message-text" class="control-label">任务书建议内容：</label>
											<div class="example-box">
												<textarea style="height: 200px"
													class="form-control" name="content" id="content"></textarea>
											</div>
											<p></p>
											<div class="form-group">
												<label for="message-text" class="control-label">时间：</label>
												<div class="example-box">
													<input id="datetime" readonly type="text" value="该项会自动生成" class="form-control" >
												</div>
											</div>
											<div class="form-group">
												<label for="message-text" class="control-label">状态：</label>
												<div class="example-box">
													<select class="form-control" id="agree" name="agree" size="1" >
													 <option value="1" style="color: #b6b6b6" disabled selected>待通过</option>
                                                     <option value="通过">通过</option>
                                                     <option value="不通过">不通过</option>
                                                    </select>
												</div>
											</div>
							
						</div>
						<div class="modal-footer">
						    <button type="button" class="btn btn-primary" onclick="getcomment()">保存</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
						</div>
						</form>
					</div>
				</div>
			</div>
			</div>
			</main>
			<!--End 页面主要内容-->
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
	  
	  //检验上传文件的类型
	  function fileChange(target,id) {   
          var fileSize = 0;   
          var filetypes =[".doc",".docx"];   
          var filepath = target.value;   
          if(filepath){  
        	  var isnext = false;   
              var fileend = filepath.substring(filepath.indexOf("."));   
              if(filetypes && filetypes.length>0){    
                  for(var i =0; i<filetypes.length;i++){  
                      if(filetypes[i]==fileend){   
                    	  isnext = true;   
                    	  break;   
                    	  }   
                      }   
                  }   
              if(!isnext){  
                  alert("只能上传 .doc .docx 格式的文件！");   
                  target.value ="";   
                  return false;   
                  }   
              }else{   
            	  return false;   
            	  }   
          if (isIE && !target.files) {   
        	  var filePath = target.value;   
        	  var fileSystem = new ActiveXObject("Scripting.FileSystemObject");   
        	  if(!fileSystem.FileExists(filePath)){   
        		  alert("附件不存在，请重新输入！");   
        		  return false;   
        		  }   
        	  var file = fileSystem.GetFile (filePath);   
        	  fileSize = file.Size;   
        	  } else {   
        		  fileSize = target.files[0].size;   
        		  }   
          
          if(size<=0){   
        	  alert("附件大小不能为0M！");   
        	  target.value ="";   
        	  return false;   
        	  }   
          lightyear.loading('show');
          }   
	  
	  
	  //检验是否已选择上传文件
	  function check() { 
		  if(f1.file.length==0||f1.file.value==""){
			  alert("请选择上传文件！");
			  return false;
		  }
	  }
	  
	  
	  //下载文件
	  function getfId (fId) {
		  $.post("<%=basePath%>file/filedown.action",{"fId":fId}
					);
	  }
	  
	 //清除建议模态框里的内容
	   // $("#comments_form").model("hide");
		function Values(sId,fId) {
			$("#content").val("");
			$("#agree").val("1");
			$("#sId").val(sId);
			$("#fId").val(fId);
			
		}  
	  
	  
	    //指导教师审核文件(任务书， 开题报告， 中期检查， 论文)
	    function getcomment() {
	    	var s=document.getElementById("agree").value;
	    	if(s=="1"){
	    		alert("请选择审核状态！");
	    		return ;
	    		
	    	}
	    	$.post("<%=basePath%>comments/createComments.action",
	    			$("#comments_form").serialize(),
	    			function(data){
	    			        if(data =="OK"){
	    			            alert("审核成功！");
	    			            window.location.reload();
	    			        }else{
	    			            alert("审核失败！");
	    			            window.location.reload();
	    			        }
	    			    });
	    	
	    }
	    
	    
	    //将日期转化为指定格式
	    Date.prototype.format = function(fmt) { 
	        var o = { 
	           "M+" : this.getMonth()+1,                 //月份 
	           "d+" : this.getDate(),                    //日 
	           "h+" : this.getHours(),                   //小时 
	           "m+" : this.getMinutes(),                 //分 
	           "s+" : this.getSeconds(),                 //秒 
	           "S"  : this.getMilliseconds()             //毫秒 
	       }; 
	       if(/(y+)/.test(fmt)) {
	               fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	       }
	        for(var k in o) {
	           if(new RegExp("("+ k +")").test(fmt)){
	                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
	            }
	        }
	       return fmt; 
	   }       
	    
	</script>
</body>
</html>
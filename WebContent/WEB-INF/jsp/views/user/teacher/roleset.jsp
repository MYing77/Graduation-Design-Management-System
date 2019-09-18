<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>高校毕业设计管理系统</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/materialdesignicons.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.min.css" rel="stylesheet">
</head>
<body>
<div style="height:100px">
</div>
<h1 align="center">请选择角色权限</h1>
<hr style="height:10px">
<c:if test="${USER_INFO.power=='是' }">
<div style="text-align:center ">
<a href="${pageContext.request.contextPath }/teacher/toindex.action"><button  class="btn  btn-primary btn-lg">指导教师 (${USER_INFO.dept })</button></a>
<p></p>
<a href="${pageContext.request.contextPath }/teacher/toreview.action"><button  class="btn  btn-primary btn-lg">评阅教师 (${USER_INFO.dept })</button></a>
<p></p>
<a href="${pageContext.request.contextPath }/teacher/leading/Index.action"><button class="btn  btn-primary btn-lg">专业负责人 (${USER_INFO.major })</button></a>
</div>
</c:if>
<c:if test="${USER_INFO.power=='否' }">
<div style="text-align:center ">
<a href="${pageContext.request.contextPath }/teacher/toindex.action"><button  class="btn  btn-primary btn-lg">指导教师 (${USER_INFO.dept })</button></a>
<p></p>
<a href="${pageContext.request.contextPath }/teacher/toreview.action"><button  class="btn  btn-primary btn-lg">评阅教师 (${USER_INFO.dept })</button></a>
<p></p>
</div>
</c:if>
</body>
</html>
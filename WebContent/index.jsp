<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 没有session对象，转发到登录页面 -->
<c:if test="${empty sessionScope.USER_INFO}">
<jsp:forward page="/WEB-INF/jsp/login.jsp"/>
</c:if>
<!-- 转发到学生主页 -->
<c:if test="${USER.role eq '学生'}">
<jsp:forward page="/WEB-INF/jsp/views/user/student/index.jsp"/>
</c:if>
<!-- 转发到教师主页 -->
<c:if test="${USER.role eq '教师'}">
<jsp:forward page="/WEB-INF/jsp/views/user/teacher/index.jsp"/>
</c:if>
<!-- 转发到管理员主页 -->
<c:if test="${USER.role eq '管理员'}">
<jsp:forward page="/WEB-INF/jsp/views/user/admin/index.jsp"/>
</c:if>

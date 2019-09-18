<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>毕业设计管理系统</title>
</head>
<body>
<script type="text/javascript">
window.onload =function() { 
	var fType="${fType}";
	var FAIL="${FAIL}"
	if(fType=='任务书' && FAIL=='FAIL1'){
		alert("上传失败！你的任务书列表有等待指导教师查看的任务书！");
		location.href = "${pageContext.request.contextPath }/student/projBooklist.action" ;
	}else if(fType=='开题报告'&& FAIL=='FAIL1'){
		alert("上传失败！你的开题报告列表有等待指导教师查看的开题报告！");
		location.href = "${pageContext.request.contextPath }/student/openReportlist.action" ;
	}else if(fType=='中期检查'&& FAIL=='FAIL1'){
		alert("上传失败！你的中期检查列表有等待指导教师查看的中期检查！");
		location.href = "${pageContext.request.contextPath }/student/midChecklist.action" ;
	}else if(fType=='论文'&& FAIL=='FAIL1'){
		alert("上传失败！你的论文列表有待指导教师查看的论文！");
		location.href = "${pageContext.request.contextPath }/student/thesislist.action" ;
	}else if(fType=='附件'&& FAIL=='FAIL1'){
		alert("上传失败！请先删除之前上传过的附件再重新上传！");
		location.href = "${pageContext.request.contextPath }/student/thesisAttachmentlist.action" ;
	}else {
		alert("上传失败！请稍后再试！");
		if(fType=='任务书'){
			location.href = "${pageContext.request.contextPath }/student/projBooklist.action" ;
		}
		else if(fType=='开题报告'){
			location.href = "${pageContext.request.contextPath }/student/openReportlist.action" ;
		}
		else if(fType=='中期检查'){
			location.href = "${pageContext.request.contextPath }/student/midChecklist.action" ;
		}
		else if(fType=='论文'){
			location.href = "${pageContext.request.contextPath }/student/thesislistlist.action" ;
		}
		else if(fType=='附件'){
			location.href = "${pageContext.request.contextPath }/student/thesisAttachmentlist.action" ;
		}
			
			
	}
	
	
};
</script>
</body>
</html>
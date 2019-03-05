<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ArchiveServlet?opType=update" method="post">
		<input type="hidden" name="id" value="${archive.id }">
		<input type="hidden" name="currentPage" value="${currentPage }">
		<input type="hidden" name="name" value="${name }">
		<input type="hidden" name="manager" value="${manager }">
		员工ID：<input type="text" name="empid" value="${archive.empid }"><br/>
		档案编号：<input type="text" name="code" value="${archive.code }"><br/>
		档案名称：<input type="text" name="name" value="${archive.name }"><br/>
		档案内容：<input type="text" name="content" value="${archive.content }"><br/>
		档案类型：<input type="text" name="type"  value="${archive.type }"><br/>
		备注说明：<input type="text" name="remark" value="${archive.remark }"><br/>
		创建时间：<input type="date" name="createTime" value="${archive.createTime}"><br/>
		
		
		
			<input type="submit" value="提交"><br/>
	</form>
	
	
</body>
</html>
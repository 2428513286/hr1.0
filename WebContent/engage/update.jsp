<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="EngageServlet?opType=update" method="post">
		<input type="hidden" name="id" value="${engage.id }">
		<input type="hidden" name="currentPage" value="${currentPage }">
		<input type="hidden" name="name" value="${name }">
		<input type="hidden" name="manager" value="${manager }">
		
		员工ID：<input type="text" name="empid" value="${engage.empid }"><br/>
		聘任职称：<input type="text" name="skillname" value="${engage.skillname }"><br/>
		创建时间：<input type="date" name="createDate" value="${engage.createDate }"><br/>
		
			<input type="submit" value="提交"><br/>
	</form>
	
	
</body>
</html>
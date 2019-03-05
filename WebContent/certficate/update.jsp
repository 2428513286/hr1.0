<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="CertficateServlet?opType=update" method="post">
		<input type="hidden" name="id" value="${certficate.id }">
		<input type="hidden" name="currentPage" value="${currentPage }">
		<input type="hidden" name="qname" value="${qname }">
		<input type="hidden" name="manager" value="${manager }">
		员工ID：<input type="text" name="empid" value="${certficate.empid }"><br/>
		培训ID：<input type="text" name="eduid" value="${certficate.eduid }"><br/>
		证书名称：<input type="text" name="name" value="${certficate.name }"><br/>
		证书编号：<input type="text" name="code" value="${certficate.code }"><br/>
		证书日期：<input type="date" name="getDate" value="${certficate.getDate }"><br/>
		
			<input type="submit" value="提交"><br/>
	</form>
	
	
</body>
</html>
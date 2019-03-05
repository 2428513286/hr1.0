<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="../CertficateServlet?opType=add" method="post">
		员工ID：<input type="text" name="empid"><br/>
		培训ID：<input type="text" name="eduid"><br/>
		证书名称：<input type="text" name="name" ><br/>
		证书编号：<input type="text" name="code"><br/>
		证书日期：<input type="date" name="getDate"><br/>
	
			<input type="submit" value="提交"><br/>
	</form>
	
</body>
</html>
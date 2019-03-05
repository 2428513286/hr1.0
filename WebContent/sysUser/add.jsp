<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="../SysUserServlet?opType=add" method="post">
		用户名：<input type="text" name="username"><br/>
		密码：<input type="text" name="password"><br/>
		员工ID：<input type="text" name="empid" ><br/>
		状态：<input type="text" name="state"><br/>
		
	
			<input type="submit" value="提交"><br/>
	</form>
	
</body>
</html>
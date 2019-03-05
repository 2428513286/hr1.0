<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="SysUserServlet?opType=update" method="post">
		<input type="hidden" name="id" value="${sysUser.id }">
		<input type="hidden" name="currentPage" value="${currentPage }">
		<input type="hidden" name="name" value="${name }">
		<input type="hidden" name="manager" value="${manager }">
		用户名：<input type="text" name="username" value="${sysUser.username }"><br/>
		密码：<input type="text" name="password" value="${sysUser.password }"><br/>
		员工ID：<input type="text" name="empid" value="${sysUser.empid }"><br/>
		状态：<input type="text" name="state" value="${sysUser.state }"><br/>
		
			<input type="submit" value="提交"><br/>
	</form>
	
	
</body>
</html>
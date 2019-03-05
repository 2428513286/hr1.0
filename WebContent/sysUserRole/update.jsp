<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="SysUserRoleServlet?opType=update" method="post">
		<input type="hidden" name="id" value="${sysUserRole.id }">
		<input type="hidden" name="currentPage" value="${currentPage }">
		<input type="hidden" name="name" value="${name }">
		<input type="hidden" name="manager" value="${manager }">
		
		用户编号：<input type="text" name="uid" value="${sysUserRole.uid }"><br/>
		角色编号：<input type="text" name="rid" value="${sysUserRole.rid }"><br/>
		
			<input type="submit" value="提交"><br/>
	</form>
	
	
</body>
</html>
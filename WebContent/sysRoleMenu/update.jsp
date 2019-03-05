<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="SysRoleMenuServlet?opType=update" method="post">
		<input type="hidden" name="id" value="${sysRoleMenu.id }">
		<input type="hidden" name="currentPage" value="${currentPage }">
		<input type="hidden" name="qname" value="${qname }">
		<input type="hidden" name="manager" value="${manager }">
		
		角色编号：<input type="text" name="rid" value="${sysRoleMenu.rid }"><br/>
		菜单编号：<input type="text" name="mid" value="${sysRoleMenu.mid }"><br/>
		
			<input type="submit" value="提交"><br/>
	</form>
	
	
</body>
</html>
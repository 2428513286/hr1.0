<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="SysMenuServlet?opType=update" method="post">
		<input type="hidden" name="id" value="${sysMenu.id }">
		<input type="hidden" name="currentPage" value="${currentPage }">
		<input type="hidden" name="qname" value="${qname }">
		<input type="hidden" name="manager" value="${manager }">
		菜单编号：<input type="text" name="code" value="${sysMenu.code }"><br/>
		pcode：<input type="text" name="pcode" value="${sysMenu.pcode }"><br/>
		菜单名称：<input type="text" name="name" value="${sysMenu.name }"><br/>
		url：<input type="text" name="url" value="${sysMenu.url }"><br/>
		菜单状态：<input type="text" name="state" value="${sysMenu.state }"><br/>
		菜单说明：<input type="text" name="remark" value="${sysMenu.remark }"><br/>
		
			<input type="submit" value="提交"><br/>
	</form>
	
	
</body>
</html>
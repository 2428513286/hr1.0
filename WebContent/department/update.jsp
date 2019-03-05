<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="DepartmentServlet?opType=update" method="post">
		<input type="hidden" name="id" value="${department.id }">
		<input type="hidden" name="currentPage" value="${currentPage }">
		<input type="hidden" name="name" value="${name }">
		<input type="hidden" name="manager" value="${manager }">
		
		部门名称：<input type="text" name="name" value="${department.name }"><br/>
		负责人名字：<input type="text" name="manager" value="${department.manager }"><br/>
		部门办公室编号：<input type="text" name="offceNo" value="${department.offceNo }"><br/>
		部门电话：<input type="text" name="phone" value="${department.phone}"><br/>
		部门说明：<input type="text" name="remark" value="${department.remark }"><br/>
		
			<input type="submit" value="提交"><br/>
	</form>
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../DepartmentServlet?opType=add" method="post">
		部门名称：<input type="text" name="name"><br/>
		部门负责人：<input type="text" name="manager"><br/>
		部门办公编号：<input type="text" name="offceNo"><br/>
		部门电话：<input type="text" name="phone" ><br/>
		部门说明：<input type="text" name="remark"><br/>
	
			<input type="submit" value="提交"><br/>
	</form>
	
</body>
</html>
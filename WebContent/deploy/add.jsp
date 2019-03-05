<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../DeployServlet?opType=add" method="post">
		员工ID：<input type="text" name="empid"><br/>
		旧部门：<input type="text" name="olddept"><br/>
		新部门：<input type="text" name="newdept"><br/>
		旧职位：<input type="text" name="oldjob"><br/>
		新职位：<input type="text" name="newjob" ><br/>
		离职时间：<input type="date" name="mixDate"><br/>
	
			<input type="submit" value="提交"><br/>
	</form>
	
</body>
</html>
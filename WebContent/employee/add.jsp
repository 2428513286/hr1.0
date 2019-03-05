<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../EmployeeServlet?opType=add" method="post">
		员工姓名：<input type="text" name="name"><br/>
		性别：<input type="text" name="sex"><br/>
		年龄：<input type="text" name="age"><br/>
		学历：<input type="text" name="edu" ><br/>
		学位：<input type="text" name="degree"><br/>
		职位：<input type="text" name="job"><br/>
		部门：<input type="text" name="deptid"><br/>
		状态：<input type="text" name="state"><br/>
		手机号：<input type="text" name="phone"><br/>
		地址：<input type="text" name="address"><br/>
		入职时间：<input type="date" name="createTime"><br/>
	
			<input type="submit" value="提交"><br/>
	</form>
	
</body>
</html>
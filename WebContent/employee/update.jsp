<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="EmployeeServlet?opType=update" method="post">
		<input type="hidden" name="id" value="${employee.id }">
		<input type="hidden" name="currentPage" value="${currentPage }">
		<input type="hidden" name="name" value="${name }">
		<input type="hidden" name="manager" value="${manager }">
		员工ID：<input type="text" name="id" value="${employee.id} "><br>
		员工姓名：<input type="text" name="name" value="${employee.name} "><br/>
		性别：<input type="text" name="sex" value="${employee.sex}"><br/>
		年龄：<input type="text" name="age" value="${employee.age}"><br/>
		学历：<input type="text" name="edu"  value="${employee.edu}"><br/>
		学位：<input type="text" name="degree" value="${employee.degree}"><br/>
		职位：<input type="text" name="job" value="${employee.job}"><br/>
		部门：<input type="text" name="deptid" value="${employee.deptid}"><br/>
		状态：<input type="text" name="state" value="${employee.state}"><br/>
		手机号：<input type="text" name="phone" value="${employee.phone}"><br/>
		地址：<input type="text" name="address" value="${employee.address}"><br/>
		入职时间：<input type="date" name="createTime" value="${employee.createTime}"><br/>
		
		
		
			<input type="submit" value="提交"><br/>
	</form>
	
	
</body>
</html>
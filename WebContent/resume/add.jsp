<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../ResumeServlet?opType=add" method="post">
		员工ID：<input type="text" name="empid"><br/>
		部门：<input type="text" name="orgname"><br/>
		员工职位：<input type="text" name="job"><br/>
		员工学历：<input type="text" name="edu"><br/>
		内容：<input type="text" name="content" ><br/>
		业绩：<input type="text" name="result"><br/>
		开始时间：<input type="date" name="beginDate"><br/>
		结束时间：<input type="date" name="endDate"><br/>
	
			<input type="submit" value="提交"><br/>
	</form>
	
</body>
</html>
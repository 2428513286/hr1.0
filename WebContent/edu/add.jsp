<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="../EduServlet?opType=add" method="post">
		培训名称：<input type="text" name="name"><br/>
		开始时间：<input type="date" name="biginDate"><br/>
		结束时间：<input type="date" name="endDate" ><br/>
		培训地点：<input type="text" name="adress"><br/>
		培训类别：<input type="text" name="type"><br/>
	
			<input type="submit" value="提交"><br/>
	</form>
	
</body>
</html>
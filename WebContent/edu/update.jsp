<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="EduServlet?opType=update" method="post">
		<input type="hidden" name="id" value="${edu.id }">
		<input type="hidden" name="currentPage" value="${currentPage }">
		<input type="hidden" name="qname" value="${qname }">
		<input type="hidden" name="manager" value="${manager }">
		培训名称：<input type="text" name="name" value="${edu.name }"><br/>
		开始时间：<input type="date" name="biginDate" value="${edu.biginDate }"><br/>
		结束时间：<input type="date" name="endDate" value="${edu.endDate }"><br/>
		培训地点：<input type="text" name="adress" value="${edu.adress }"><br/>
		培训类别：<input type="text" name="type" value="${edu.type }"><br/>
		
			<input type="submit" value="提交"><br/>
	</form>
	
	
</body>
</html>
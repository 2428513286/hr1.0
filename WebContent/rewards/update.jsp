<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="RewardsServlet?opType=update" method="post">
		<input type="hidden" name="id" value="${rewards.id }">
		<input type="hidden" name="currentPage" value="${currentPage }">
		<input type="hidden" name="name" value="${name }">
		<input type="hidden" name="manager" value="${manager }">
		员工ID：<input type="text" name="empid" value="${rewards.empid }"><br/>
		奖惩标题：<input type="text" name="title" value="${rewards.title }"><br/>
		奖惩内容：<input type="text" name="content" value="${rewards.content }"><br/>
		奖惩类别：<input type="text" name="type" value="${rewards.type }"><br/>
		奖惩时间：<input type="date" name="createDate" value="${rewards.createDate }"><br/>
		
			<input type="submit" value="提交"><br/>
	</form>
	
	
</body>
</html>
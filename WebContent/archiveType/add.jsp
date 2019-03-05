<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../ArchiveTypeServlet?opType=add" method="post">
		档案类型：<input type="text" name="name"><br/>
		备注：<input type="text" name="remark"><br/>
	
			<input type="submit" value="提交"><br/>
	</form>
	
</body>
</html>
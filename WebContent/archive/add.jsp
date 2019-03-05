<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../ArchiveServlet?opType=add" method="post">
		员工ID：<input type="text" name="empid"><br/>
		档案编号：<input type="text" name="code"><br/>
		档案名称：<input type="text" name="name"><br/>
		档案内容：<input type="text" name="content"><br/>
		档案类型：<input type="text" name="type" ><br/>
		备注说明：<input type="text" name="remark"><br/>
		创建时间：<input type="date" name="createTime"><br/>
	
			<input type="submit" value="提交"><br/>
	</form>
	
</body>
</html>
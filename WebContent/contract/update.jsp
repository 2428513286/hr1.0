<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ContractServlet?opType=update" method="post">
		<input type="hidden" name="id" value="${contract.id }">
		<input type="hidden" name="currentPage" value="${currentPage }">
		<input type="hidden" name="name" value="${name }">
		<input type="hidden" name="manager" value="${manager }">
		员工ID：<input type="text" name="empid" value="${contract.empid }"><br/>
		合同编号：<input type="text" name="code" value="${contract.code }"><br/>
		开始时间：<input type="date" name="beginDate" value="${contract.beginDate }"><br/>
		结束时间：<input type="date" name="endDate" value="${contract.endDate }"><br/>
		员工职位：<input type="text" name="job" value="${contract.job }"><br/>
		内容：<input type="text" name="content" value="${contract.content }"><br/>
		合同的电子文档：<input type="text" name="attachment" value="${contract.attachment }"><br/>
		
		
		
			<input type="submit" value="提交"><br/>
	</form>
	
	
</body>
</html>
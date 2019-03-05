<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门信息表</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/common4.js"></script>
<link type="text/css" href="css/style.css" rel="stylesheet">
</head>
<body>
	<div id="search">
		<form action="ArchiveServlet?opType=queryByPage" method="post">
			档案名称：<input type="text" name="qname" value="${qname }">&nbsp;&nbsp;
			档案编号：<input type="text" name="qmanager" value="${qmanager }">&nbsp;&nbsp;
			
				<input type="submit" value="搜索">
		</form>
	</div>
	
	<table border=1 id="myTable">
		<tr>
			<th><input type="checkbox"></th>
			<th>档案ID</th>
			<th>员工ID</th>
			<th>档案编号</th>
			<th>档案名称</th>
			<th>档案内容</th>
			<th>档案类型</th>
			<th>备注说明</th>
			<th>创建时间</th>
			<th>操作
				<a href="archive/add.jsp">新增</a>
				|
				<a href="#" onclick="deleteMore(${sp },'${qname }','${qmanager }');">批量删除</a>
			</th>
		</tr>
		<c:forEach var="archive" items="${list }">
			<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this);">
				<td><input type="checkbox" value="${archive.id }"></td>
				<td>${archive.id }</td>
				<td>${archive.empid }</td>
				<td>${archive.code }</td>
				<td>${archive.name }</td>
				<td>${archive.content }</td>
				<td>${archive.type }</td>
				<td>${archive.remark }</td>
				<td>${archive.createTime }</td>
				
				<td>
					<a href="ArchiveServlet?opType=queryById&id=${archive.id }&currentPage=${sp }&qname=${qname }&qmanager=${qmanager}">修改</a>
					|
					<a href="#" onclick="deleteById(${archive.id},${sp },'${qname }','${qmanager }');">删除</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	<div id="page">
		总记录数：${totals }&nbsp;&nbsp;总页数：${pageCounts }&nbsp;&nbsp;当前页：${sp }&nbsp;&nbsp;
		<a href="ArchiveServlet?opType=queryByPage&currentPage=1&qname=${qname }&qmanager=${qmanager}">首页</a>&nbsp;&nbsp;
		<a href="ArchiveServlet?opType=queryByPage&currentPage=${sp-1 }&qname=${qname }&qmanager=${qmanager}">上一页</a>&nbsp;&nbsp;
		<form action="ArchiveServlet?opType=queryByPage&qname=${qname }&qmanager=${qmanager}" method="post" style="display: inline;">
			<input type="text" name="currentPage" size="4" value="${sp }">
		</form>
		<a href="ArchiveServlet?opType=queryByPage&currentPage=${sp+1 }&qname=${qname }&qmanager=${qmanager}">下一页</a>&nbsp;&nbsp;
		<a href="ArchiveServlet?opType=queryByPage&currentPage=${pageCounts }&qname=${qname }&qmanager=${qmanager}">末页</a>&nbsp;&nbsp;
	</div>

</body>
</html>
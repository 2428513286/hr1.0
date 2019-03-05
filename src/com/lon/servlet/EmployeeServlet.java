package com.lon.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lon.dao.EmployeeDao;
import com.lon.dao.impl.EmployeeDaoImpl;
import com.lon.entity.Employee;


/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opType = request.getParameter("opType");
		if(opType==null) {
			queryByPage(request, response);
		}else if(opType.equals("add")) {
			add(request, response);
		}else if(opType.equals("update")) {
			update(request, response);
		}else if(opType.equals("deleteById")) {
			deleteById(request, response);
		}else if(opType.equals("deleteMore")) {
			deleteMore(request, response);
		}else if(opType.equals("queryById")) {
			queryById(request, response);
		}else if(opType.equals("queryAll")) {
			queryAll(request, response);
		}else if(opType.equals("queryByPage")) {
			queryByPage(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	public void add(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String age = request.getParameter("age");
			String edu = request.getParameter("edu");
			String degree = request.getParameter("degree");
			String job = request.getParameter("job");
			String deptid = request.getParameter("deptid");
			String state = request.getParameter("state");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			Employee e = new Employee();
			e.setName(name);
			e.setSex(Integer.parseInt(sex));
			e.setAge(Integer.parseInt(age));
			e.setEdu(Integer.parseInt(edu));
			e.setDegree(Integer.parseInt(degree));
			e.setJob(job);
			e.setDeptid(Integer.parseInt(deptid));
			e.setState(Integer.parseInt(state));
			e.setPhone(phone);
			e.setAddress(address);
			e.setCreateTime(new Timestamp(System.currentTimeMillis()));
			
			EmployeeDao dao = new EmployeeDaoImpl();
			dao.add(e);
			queryByPage(request, response);
		}
	
	public void deleteById(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			String id = request.getParameter("id");
			EmployeeDao dao = new EmployeeDaoImpl();
			dao.deleteById(Integer.parseInt(id));
			queryByPage(request, response);
		}
	
	public void deleteMore(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			String ids = request.getParameter("ids");
			EmployeeDao dao = new EmployeeDaoImpl();
			dao.deleteMore(ids);
			queryByPage(request, response);
		}
	
	
	public void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String age = request.getParameter("age");
			String edu = request.getParameter("edu");
			String degree = request.getParameter("degree");
			String job = request.getParameter("job");
			String deptid = request.getParameter("deptid");
			String state = request.getParameter("state");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			Employee e = new Employee();
			e.setName(name);
			e.setSex(Integer.parseInt(sex));
			e.setAge(Integer.parseInt(age));
			e.setEdu(Integer.parseInt(edu));
			e.setDegree(Integer.parseInt(degree));
			e.setJob(job);
			e.setDeptid(Integer.parseInt(deptid));
			e.setState(Integer.parseInt(state));
			e.setPhone(phone);
			e.setAddress(address);
			e.setCreateTime(new Timestamp(System.currentTimeMillis()));
			
			EmployeeDao dao = new EmployeeDaoImpl();
			dao.update(e);
			queryByPage(request, response);
		}
	
	
	public void queryById(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			String id = request.getParameter("id");
			String currentPage = request.getParameter("currentPage");
			String qname = request.getParameter("qname");
			String qmanager = request.getParameter("qmanager");
			
			EmployeeDao dao = new EmployeeDaoImpl();
			Employee e = dao.queryById(Integer.parseInt(id));
			request.setAttribute("employee", e);
			request.setAttribute("qname", qname);
			request.setAttribute("qmanager", qmanager);
			request.setAttribute("currentPage",currentPage);
			request.getRequestDispatcher("employee/update.jsp").forward(request, response);
		}
	
	public void queryAll(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
		}
	
	public void queryByPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
			String qname = request.getParameter("qname");
			String qmanager = request.getParameter("qmanager");
			String currentPage = request.getParameter("currentPage");
		
			String condition = " where 1=1 ";
			if(qname!=null&&!qname.equals("")&&!qname.equalsIgnoreCase("null")){
				condition += " and name like '%"+qname+"%'";
			}
			if(qmanager!=null&&!qmanager.equals("")&&!qname.equalsIgnoreCase("null")){
				condition += " and manager like '%"+qmanager+"%'";
			}
			
			EmployeeDao dao = new EmployeeDaoImpl();
			//当前页
			int sp = 1;
			//总记录数
			int totals = dao.getTotals(condition);
			//每页记录数
			int pageSize = 20;
			//总页数
			int pageCounts = totals/pageSize;
			if(totals%pageSize!=0){
				pageCounts++;
			}
			try{
				sp = Integer.parseInt(currentPage);
			}catch(Exception e){
				sp = 1;
			}
			if(sp>pageCounts){
				sp = pageCounts;
			}
			if(sp<1){
				sp = 1;
			}
			List<Employee> list = dao.queryByPage(sp, pageSize,condition);
			request.setAttribute("list", list);
			request.setAttribute("totals", totals);
			request.setAttribute("pageCounts", pageCounts);
			request.setAttribute("sp", sp);
			request.setAttribute("qname", qname);
			request.setAttribute("qmanager", qmanager);
			request.getRequestDispatcher("employee/list.jsp").forward(request, response);
		}

	
	
	
	
	
	
	
}

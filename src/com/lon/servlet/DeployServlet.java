package com.lon.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lon.dao.DeployDao;
import com.lon.dao.impl.DeployDaoImpl;
import com.lon.entity.Deploy;

/**
 * Servlet implementation class DeployServlet
 */
@WebServlet("/DeployServlet")
public class DeployServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opType = request.getParameter("opType");
		if (opType == null) {
			queryByPage(request, response);
		} else if (opType.equals("add")) {
			add(request, response);
		} else if (opType.equals("update")) {
			update(request, response);
		} else if (opType.equals("deleteById")) {
			deleteById(request, response);
		} else if (opType.equals("deleteMore")) {
			deleteMore(request, response);
		} else if (opType.equals("queryById")) {
			queryById(request, response);
		} else if (opType.equals("queryAll")) {
			queryAll(request, response);
		} else if (opType.equals("queryByPage")) {
			queryByPage(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empid = request.getParameter("empid");
		String olddept = request.getParameter("olddept");
		String newdept = request.getParameter("newdept");
		String oldjob = request.getParameter("oldjob");
		String newjob = request.getParameter("newjob");
		String mixDate = request.getParameter("mixDate");
		
		Deploy d = new Deploy();
		d.setEmpid(Integer.parseInt(empid));
		d.setOlddept(olddept);
		d.setNewdept(newdept);
		d.setOldjob(oldjob);
		d.setNewjob(newjob);
		try {
			d.setMixDate( new SimpleDateFormat("yyyy-MM-dd").parse(mixDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		DeployDao dao = new DeployDaoImpl();
		dao.add(d);
		queryByPage(request, response);
	}

	public void deleteById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		DeployDao dao = new DeployDaoImpl();
		dao.deleteById(Integer.parseInt(id));
		queryByPage(request, response);
	}

	public void deleteMore(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("ids");
		DeployDao dao = new DeployDaoImpl();
		dao.deleteMore(ids);
		queryByPage(request, response);
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		String empid = request.getParameter("empid");
		String olddept = request.getParameter("olddept");
		String newdept = request.getParameter("newdept");
		String oldjob = request.getParameter("oldjob");
		String newjob = request.getParameter("newjob");
		String mixDate = request.getParameter("mixDate");
		
		Deploy d = new Deploy();
		d.setId(Integer.parseInt(id));
		d.setEmpid(Integer.parseInt(empid));
		d.setOlddept(olddept);
		d.setNewdept(newdept);
		d.setOldjob(oldjob);
		d.setNewjob(newjob);
		try {
			d.setMixDate( new SimpleDateFormat("yyyy-MM-dd").parse(mixDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		DeployDao dao = new DeployDaoImpl();
		dao.update(d);
		queryByPage(request, response);
	}

	public void queryById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String currentPage = request.getParameter("currentPage");
		String qname = request.getParameter("qname");
		String qmanager = request.getParameter("qmanager");
		
		DeployDao dao = new DeployDaoImpl();
		Deploy d = dao.queryById(Integer.parseInt(id));
		request.setAttribute("deploy", d);
		request.setAttribute("qname", qname);
		request.setAttribute("qmanager", qmanager);
		request.setAttribute("currentPage",currentPage);
		request.getRequestDispatcher("deploy/update.jsp").forward(request, response);
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
		if (qname != null && !qname.equals("") && !qname.equalsIgnoreCase("null")) {
			condition += " and name like '%" + qname + "%'";
		}
		if (qmanager != null && !qmanager.equals("") && !qname.equalsIgnoreCase("null")) {
			condition += " and manager like '%" + qmanager + "%'";
		}

		DeployDao dao = new DeployDaoImpl();
		// 当前页
		int sp = 1;
		// 总记录数
		int totals = dao.getTotals(condition);
		// 每页记录数
		int pageSize = 20;
		// 总页数
		int pageCounts = totals / pageSize;
		if (totals % pageSize != 0) {
			pageCounts++;
		}
		try {
			sp = Integer.parseInt(currentPage);
		} catch (Exception e) {
			sp = 1;
		}
		if (sp > pageCounts) {
			sp = pageCounts;
		}
		if (sp < 1) {
			sp = 1;
		}
		List<Deploy> list = dao.queryByPage(sp, pageSize, condition);
		request.setAttribute("list", list);
		request.setAttribute("totals", totals);
		request.setAttribute("pageCounts", pageCounts);
		request.setAttribute("sp", sp);
		request.setAttribute("qname", qname);
		request.setAttribute("qmanager", qmanager);
		request.getRequestDispatcher("deploy/list.jsp").forward(request, response);
	}

}

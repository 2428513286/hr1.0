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

import com.lon.dao.EduDao;
import com.lon.dao.impl.EduDaoImpl;
import com.lon.entity.Edu;


/**
 * Servlet implementation class EduServlet
 */
@WebServlet("/EduServlet")
public class EduServlet extends HttpServlet {
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
		String name = request.getParameter("name");
		String biginDate = request.getParameter("biginDate");
		String endDate = request.getParameter("endDate");
		String adress = request.getParameter("adress");
		String type = request.getParameter("type");
		
		Edu edu = new Edu();
		edu.setName(name);
		try {
			edu.setBiginDate(new SimpleDateFormat("yyyy-MM-dd").parse(biginDate));
			edu.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(endDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		edu.setAdress(adress);
		edu.setType(Integer.parseInt(type));
		
		EduDao dao = new EduDaoImpl();
		dao.add(edu);
		queryByPage(request, response);
	}

	public void deleteById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		EduDao dao = new EduDaoImpl();
		dao.deleteById(Integer.parseInt(id));
		queryByPage(request, response);
	}

	public void deleteMore(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("ids");
		EduDao dao = new EduDaoImpl();
		dao.deleteMore(ids);
		queryByPage(request, response);
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String biginDate = request.getParameter("biginDate");
		String endDate = request.getParameter("endDate");
		String adress = request.getParameter("adress");
		String type = request.getParameter("type");
		
		Edu edu = new Edu();
		edu.setId(Integer.parseInt(id));
		edu.setName(name);
		try {
			edu.setBiginDate(new SimpleDateFormat("yyyy-MM-dd").parse(biginDate));
			edu.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(endDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		edu.setAdress(adress);
		edu.setType(Integer.parseInt(type));

		EduDao dao = new EduDaoImpl();
		dao.update(edu);
		queryByPage(request, response);
	}

	public void queryById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String currentPage = request.getParameter("currentPage");
		String qname = request.getParameter("qname");
		String qmanager = request.getParameter("qmanager");
		
		EduDao dao = new EduDaoImpl();
		Edu e = dao.queryById(Integer.parseInt(id));
		request.setAttribute("edu", e);
		request.setAttribute("qname", qname);
		request.setAttribute("qmanager", qmanager);
		request.setAttribute("currentPage",currentPage);
		request.getRequestDispatcher("edu/update.jsp").forward(request, response);
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

		EduDao dao = new EduDaoImpl();
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
		List<Edu> list = dao.queryByPage(sp, pageSize, condition);
		request.setAttribute("list", list);
		request.setAttribute("totals", totals);
		request.setAttribute("pageCounts", pageCounts);
		request.setAttribute("sp", sp);
		request.setAttribute("qname", qname);
		request.setAttribute("qmanager", qmanager);
		request.getRequestDispatcher("edu/list.jsp").forward(request, response);
	}

}

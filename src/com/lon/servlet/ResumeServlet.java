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

import com.lon.dao.ResumeDao;
import com.lon.dao.impl.ResumeDaoImpl;
import com.lon.entity.Resume;



/**
 * Servlet implementation class ResumeServlet
 */
@WebServlet("/ResumeServlet")
public class ResumeServlet extends HttpServlet {
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
		String orgname = request.getParameter("orgname");
		String job = request.getParameter("job");
		String edu = request.getParameter("edu");
		String content = request.getParameter("content");
		String result = request.getParameter("result");
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		
		Resume r = new Resume();
		r.setEmpid(Integer.parseInt(empid));
		r.setOrgname(orgname);
		r.setJob(job);
		r.setEdu(edu);
		r.setContent(content);
		r.setResult(result);
		try {
			r.setBeginDate( new SimpleDateFormat("yyyy-MM-dd").parse(beginDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			r.setEndDate( new SimpleDateFormat("yyyy-MM-dd").parse(endDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ResumeDao dao = new ResumeDaoImpl();
		dao.add(r);
		queryByPage(request, response);
	}

	public void deleteById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		ResumeDao dao = new ResumeDaoImpl();
		dao.deleteById(Integer.parseInt(id));
		queryByPage(request, response);
	}

	public void deleteMore(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("ids");
		ResumeDao dao = new ResumeDaoImpl();
		dao.deleteMore(ids);
		queryByPage(request, response);
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id");
		String empid = request.getParameter("empid");
		String orgname = request.getParameter("orgname");
		String job = request.getParameter("job");
		String edu = request.getParameter("edu");
		String content = request.getParameter("content");
		String result = request.getParameter("result");
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		
		Resume r = new Resume();
		r.setId(Integer.parseInt(id));
		r.setEmpid(Integer.parseInt(empid));
		r.setOrgname(orgname);
		r.setJob(job);
		r.setEdu(edu);
		r.setContent(content);
		r.setResult(result);
		try {
			r.setBeginDate( new SimpleDateFormat("yyyy-MM-dd").parse(beginDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			r.setEndDate( new SimpleDateFormat("yyyy-MM-dd").parse(endDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResumeDao dao = new ResumeDaoImpl();
		dao.update(r);
		queryByPage(request, response);
	}

	public void queryById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String currentPage = request.getParameter("currentPage");
		String qname = request.getParameter("qname");
		String qmanager = request.getParameter("qmanager");
		
		ResumeDao dao = new ResumeDaoImpl();
		Resume r = dao.queryById(Integer.parseInt(id));
		request.setAttribute("resume", r);
		request.setAttribute("qname", qname);
		request.setAttribute("qmanager", qmanager);
		request.setAttribute("currentPage",currentPage);
		request.getRequestDispatcher("resume/update.jsp").forward(request, response);
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

		ResumeDao dao = new ResumeDaoImpl();
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
		List<Resume> list = dao.queryByPage(sp, pageSize, condition);
		request.setAttribute("list", list);
		request.setAttribute("totals", totals);
		request.setAttribute("pageCounts", pageCounts);
		request.setAttribute("sp", sp);
		request.setAttribute("qname", qname);
		request.setAttribute("qmanager", qmanager);
		request.getRequestDispatcher("resume/list.jsp").forward(request, response);
	}

}

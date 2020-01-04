package com.deloitte.dept.appln;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.dept.dao.DeptDao;
import com.deloitte.dept.dao.impl.DeptDaoImpl;

@WebServlet("/DelDept")
public class DelDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	DeptDao dao = new DeptDaoImpl();
	int deptno = Integer.parseInt(request.getParameter("deptno"));
	int rows=dao.delDeptByCode(deptno);
	if(rows>0){
		out.println("deleted");
	}
	else{
		out.println("not deleted");
	}
	}

}

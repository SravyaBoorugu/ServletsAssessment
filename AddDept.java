package com.deloitte.dept.appln;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.dept.beans.Dept;
import com.deloitte.dept.dao.DeptDao;
import com.deloitte.dept.dao.impl.DeptDaoImpl;
import com.deloitte.empl.beans.Emp;
import com.deloitte.empl.dao.EmpDao;
import com.deloitte.empl.dao.impl.EmpDaoImpl;

@WebServlet("/AddDept")
public class AddDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
          int deptno = Integer.parseInt(request.getParameter("deptno"));
          String dname = request.getParameter("dname");
          String loc = request.getParameter("loc");
		   Dept dept = new Dept(deptno,dname,loc);
			DeptDao dao = new DeptDaoImpl();
			int rows = dao.addDept(dept);
			if(rows>0)
				out.println("inserted");
			else
				out.println("not inserted");
		
	}

}

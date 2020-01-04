package com.deloitte.dept.appln;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.dept.beans.Dept;
import com.deloitte.dept.dao.DeptDao;
import com.deloitte.dept.dao.impl.DeptDaoImpl;

@WebServlet("/GetDept")
public class GetDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     PrintWriter out = response.getWriter();
     DeptDao dao = new DeptDaoImpl();
     List<Dept> deptlist = dao.getdept();
     out.println("<table border=4>");
     out.println("<tr><th>DEPTNO<TH>DNAME<TH>LOC</TR>");
     for(Dept d : deptlist){
    	 out.println("<tr>");
    	 out.println("<td>"+d.getDeptno()+"</td>");
    	 out.println("<td>"+d.getDname()+"</td>");
    	 out.println("<td>"+d.getLoc()+"</td>");
    	 out.println("</tr>");}
     out.println("</table>");
     
	}

}

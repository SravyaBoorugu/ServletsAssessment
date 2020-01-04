package com.deloitte.dept.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.deloitte.dept.beans.Dept;
import com.deloitte.dept.dao.DeptDao;
import com.deloitte.dept.utils.DeptUtils;
import com.deloitte.empl.beans.Emp;

import oracle.jdbc.OracleDriver;

public class DeptDaoImpl implements DeptDao{
	private Connection conn=null;
	private PreparedStatement pst;
	private ResultSet rs;
	@Override
	public void openConnection() {
		try {
			DriverManager.registerDriver(new OracleDriver());
			String url ="jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pass = "tiger";
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	@Override
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addDept(Dept dept) {
		openConnection();
		int rows=0;
		try {
			pst = conn.prepareStatement(DeptUtils.insertdept);
			pst.setInt(1,dept.getDeptno());
			pst.setString(2, dept.getDname());
			pst.setString(3, dept.getLoc());
			rows= pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			close();
		}
		return rows;
	}
	@Override
	public List<Dept> getdept() {
		openConnection();
		List<Dept> deptlist = new ArrayList<Dept>();
		try {
			pst = conn.prepareStatement(DeptUtils.GETDEPT);
			rs = pst.executeQuery();
			while(rs.next()){
				Dept dept = new Dept(rs.getInt(1), rs.getString(2),rs.getString(3));
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return deptlist;
	}
	@Override
	public Dept getDeptByCode(int deptno) {
		openConnection();
		Dept dept = null;
		try {
			pst = conn.prepareStatement(DeptUtils.GETDEPTBYCODE);
			pst.setInt(1, deptno); 
			rs = pst.executeQuery();
			if(rs.next()){
				dept = new Dept(rs.getInt(1), rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return dept;
	}
	@Override
	public int updateDeptByCode(String dname,String loc,int deptno) {
		openConnection();
		int rows = 0;
		try {
			pst = conn.prepareStatement(DeptUtils.UPDATEDEPTBYCODE);
			pst.setString(1, dname);
			pst.setString(2,loc);
			pst.setInt(3,deptno);
		    rows = pst.executeUpdate();
		    
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return rows;
	}
	@Override
	public int delDeptByCode(int deptno) {
		openConnection();
		int rows = 0;
		try {
			pst = conn.prepareStatement(DeptUtils.DELDEPTBYCODE);
			pst.setInt(1, deptno);
		    rows = pst.executeUpdate();
		    
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return rows;
	}
	

}


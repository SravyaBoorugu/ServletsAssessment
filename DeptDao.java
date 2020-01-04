package com.deloitte.dept.dao;

import java.util.List;

import com.deloitte.dept.beans.Dept;
import com.deloitte.empl.beans.Emp;

public interface DeptDao {
	void openConnection();
	void close();
	int addDept(Dept dept); 
	List<Dept> getdept();
	Dept getDeptByCode(int deptno);
	int updateDeptByCode(String dname,String loc,int deptno);
	int delDeptByCode(int deptno);
}

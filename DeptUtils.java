package com.deloitte.dept.utils;

public class DeptUtils {
	public static String insertdept="insert into dept values(?,?,?)";
	public static final String GETDEPT = "select * from dept";
	public static final String GETDEPTBYCODE = "select * from dept where deptno=?";
    public static final String UPDATEDEPTBYCODE = "update dept set dname=?,loc=? where deptno =?";
    public static final String DELDEPTBYCODE = "delete from dept where deptno =?";
}

package com.practice.db.vo;

public class EmpVO {

    long empno;
    String ename;
    String job;
    long mgr;
    String hiredate;
    long sal;
    long comm;
    long deptno;

    public long getEmpno() {
        return empno;
    }

    public void setEmpno(long empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public long getMgr() {
        return mgr;
    }

    public void setMgr(long mgr) {
        this.mgr = mgr;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public long getSal() {
        return sal;
    }

    public void setSal(long sal) {
        this.sal = sal;
    }

    public long getComm() {
        return comm;
    }

    public void setComm(long comm) {
        this.comm = comm;
    }

    public long getDeptno() {
        return deptno;
    }

    public void setDeptno(long deptno) {
        this.deptno = deptno;
    }
}

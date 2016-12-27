package com.ssh.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/12/24.
 */
@Entity
@Table(name = "dept")
public class Dept {
    private int deptno;
    private String dname;
    private String loc;

    @Id
    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }
    
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

   
    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dept dept = (Dept) o;

        if (deptno != dept.deptno) return false;
        if (dname != null ? !dname.equals(dept.dname) : dept.dname != null) return false;
        if (loc != null ? !loc.equals(dept.loc) : dept.loc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deptno;
        result = 31 * result + (dname != null ? dname.hashCode() : 0);
        result = 31 * result + (loc != null ? loc.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", emps=" + emps +
                '}';
    }
    ///////////////////////////////////////////////////////////////////////////
    
//    @JoinColumn(name = "deptno")
    private Set<Emp> emps = new HashSet<Emp>();
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "dept")
    public Set<Emp> getEmps() {
        return emps;
    }

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }
}

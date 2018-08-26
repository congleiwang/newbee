package wang.conglei.mybatis.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: newbee
 * @description: 职员
 * @author: conglei.Wang
 * @create: 2018-08-18 14:39
 **/
public class Emp {
    private Integer id;
    private String empName;
    private Date hireDate;
    private Integer deptId;
    private int workAge;
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Emp() {
    }

    public Emp(Date hireDate) {
        this.hireDate = hireDate;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

        this.workAge = Integer.valueOf(sdf.format(new Date())) - Integer.valueOf(sdf.format(hireDate));
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }
}

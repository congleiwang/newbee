package wang.conglei.mybatis.entity;

/**
 * @program: mybatis
 * @description: 实体类，部门
 * @author: conglei.Wang
 * @create: 2018-07-16 22:57
 **/
public class Dept {
    private Integer id;
    private String deptName;
    private String loc;
    private Boolean enabled;

    public Dept() {
    }

    public Dept(String deptName, String loc) {
        this.deptName = deptName;
        this.loc = loc;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", loc='" + loc + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}

package wang.conglei.base.dao;

import org.junit.Test;
import wang.conglei.mybatis.dao.DeptDao;
import wang.conglei.mybatis.entity.Dept;

public class DeptDaoTest {

    @Test
    public void insert() throws Exception {
        Integer result = new DeptDao().insert();
        System.out.println(result);
    }

    @Test
    public void getById() {
        Dept dept = new DeptDao().getById(2);
        System.out.println(dept);
    }

    @Test
    public void page() {
    }
}
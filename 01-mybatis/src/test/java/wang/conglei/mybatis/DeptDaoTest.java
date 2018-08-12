package wang.conglei.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import wang.conglei.mybatis.dao.DeptDao;
import wang.conglei.mybatis.entity.Dept;

import java.io.InputStream;

public class DeptDaoTest {

    private SqlSession session;

    public static final String MYBATIS_CONFIG_XML = "mybatis-config.xml";

    @Before
    public void start() {
        try {
            InputStream inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG_XML);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            session = factory.openSession();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Test
    public void insert() throws Exception {
        Dept dept = new Dept("销售部", "深圳市南山区XXX二楼");
        DeptDao deptDao = session.getMapper(DeptDao.class);
        deptDao.insert(dept);
        session.commit();
        session.close();
        System.out.println(dept);

    }

    @Test
    public void getById() {
        DeptDao deptDao = session.getMapper(DeptDao.class);
        Dept dept = deptDao.getById(7);
        System.out.println(dept);
    }

    @Test
    public void page() {
    }
}
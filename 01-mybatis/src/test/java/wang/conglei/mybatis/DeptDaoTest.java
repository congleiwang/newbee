package wang.conglei.mybatis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import wang.conglei.mybatis.dao.DeptDao;
import wang.conglei.mybatis.entity.Dept;

import java.io.InputStream;
import java.util.List;

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

    @After
    public void end(){
        if(session !=null){
            session.close();
        }
    }

    @Test
    public void insert() throws Exception {
        Dept dept = new Dept("销售部1", "深圳市南山区XXX二楼");
        dept.setEnabled(false);
        DeptDao deptDao = session.getMapper(DeptDao.class);
        deptDao.insert(dept);
        System.out.println(JSON.toJSONString(dept));

    }

    @Test
    public void getById() {
        DeptDao deptDao = session.getMapper(DeptDao.class);
        Dept dept = deptDao.getById(9);
        System.out.println(dept);
    }

    @Test
    public void listAll() {
        DeptDao deptDao = session.getMapper(DeptDao.class);
        List<Dept> result = deptDao.listAll();
        System.out.println(JSON.toJSONString(result, SerializerFeature.PrettyFormat));
    }
}
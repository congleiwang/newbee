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
import wang.conglei.mybatis.dao.EmpDao;
import wang.conglei.mybatis.entity.Dept;
import wang.conglei.mybatis.entity.Emp;

import java.io.InputStream;
import java.util.List;

public class EmpDaoTest {

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
    public void list() {
        EmpDao empDao = session.getMapper(EmpDao.class);
        List<Emp> result = empDao.list();
        System.out.println(JSON.toJSONString(result, SerializerFeature.PrettyFormat));
    }
}
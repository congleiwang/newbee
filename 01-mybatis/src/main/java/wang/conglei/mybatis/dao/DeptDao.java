package wang.conglei.mybatis.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import wang.conglei.mybatis.entity.Dept;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: mybatis
 * @description: dept数据层操作
 * @author: conglei.Wang
 * @create: 2018-07-16 23:39
 **/
public class DeptDao {

    private SqlSession getSqlSession(){
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession();
    }

    public Integer insert() {
        SqlSession session = getSqlSession();

        Dept dept = new Dept("销售部", "深圳市南山区XXX二楼");
        session.insert("insert", dept);
        session.commit();
        session.close();

        return dept.getId();
    }

    public Dept getById(Integer id){
        SqlSession session = getSqlSession();
        return session.selectOne("getById",id);
    }

    public List<Dept> page(){
        SqlSession session = getSqlSession();
        // 从第二条开始查，查两条
        RowBounds rowBounds = new RowBounds(2,2);
        return  session.selectList("page",null,rowBounds);
    }

}

package wang.conglei.mybatis.dao;

import wang.conglei.mybatis.entity.Dept;

import java.util.List;

/**
 * @program: mybatis
 * @description: dept数据层操作
 * @author: conglei.Wang
 * @create: 2018-07-16 23:39
 **/
public interface DeptDao {


    Integer insert(Dept dept);

    Dept getById(Integer id);

    List<Dept> listAll();

}

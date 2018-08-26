package wang.conglei.mybatis.dao;

import wang.conglei.mybatis.entity.Emp;

import java.util.List;

/**
 * @program: newbee
 * @description: empdao
 * @author: conglei.Wang
 * @create: 2018-08-18 14:41
 **/
public interface EmpDao {
    List<Emp> list();
}

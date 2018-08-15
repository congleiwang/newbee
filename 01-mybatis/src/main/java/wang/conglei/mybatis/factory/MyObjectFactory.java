package wang.conglei.mybatis.factory;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.Enumeration;
import java.util.Properties;

/**
 * @program: newbee
 * @description: 对象处理工厂
 * @author: conglei.Wang
 * @create: 2018-08-16 07:12
 **/
public class MyObjectFactory extends DefaultObjectFactory {

    @Override
    public void setProperties(Properties properties) {
        // properties size在Object状态下始终为0，故无效
        if (properties != null) {
            Enumeration<Object> enu = properties.elements();
            while (enu.hasMoreElements()) {
                Object value = enu.nextElement();
                if (value != null && StringUtils.isBlank(value.toString())) {
                    value = null;
                }
            }
        }

    }
}

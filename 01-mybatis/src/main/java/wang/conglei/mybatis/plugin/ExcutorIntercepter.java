package wang.conglei.mybatis.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @program: newbee
 * @description: 执行SQL前对其做处理
 * @author: conglei.Wang
 * @create: 2018-08-16 07:38
 **/

@Intercepts({@Signature(
        method = "query", type = Executor.class,
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class
        })})
public class ExcutorIntercepter implements Interceptor {

    /**
     * @param invocation plugin方法生成的代理对象及其相关信息。
     * @return
     * @throws Throwable
     */
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("Executor.query（）执行之前");
        return invocation.proceed();
    }

    /**
     * 如果target所处理的类有实现接口，则为其生成一个代理对象，否则不做处理
     *
     * @param target 被拦截的Executor.class 实例对象。
     * @return
     */
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {

    }
}

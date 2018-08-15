package wang.conglei.mybatis.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: newbee
 * @description: 自定义的类型转换器
 * @author: conglei.Wang
 * @create: 2018-08-15 20:51
 **/
@MappedJdbcTypes(JdbcType.NUMERIC)
public class BooleanTypeHandler extends BaseTypeHandler<Boolean> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
        if (parameter == null || !parameter) {
            ps.setInt(i, 0);
        }
        ps.setInt(i, 1);

    }

    @Override
    public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
        if (rs.getInt(columnName) == 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        if (rs.getInt(columnIndex) == 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        if (cs.getInt(columnIndex) == 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}

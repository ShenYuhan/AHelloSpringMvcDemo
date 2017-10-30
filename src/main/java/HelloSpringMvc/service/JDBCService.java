package HelloSpringMvc.service;

import java.sql.ResultSet;

/**
 * Created by yuhan.shen on 2017/10/28.
 */
public interface JDBCService {

    public ResultSet executeQuery(String sql);

    public int executeUpdate(String sql);

}

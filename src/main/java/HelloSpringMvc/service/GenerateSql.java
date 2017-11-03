package HelloSpringMvc.service;

import java.util.Map;
import java.util.Set;

/**
 * Created by yuhan.shen on 2017/11/3.
 */
public interface GenerateSql {

    public String genInsertSql(String database, Map<String,String> maps);

    public String genSelectSql(String database,Set<String> colSets,Map<String,String> valueMaps);

}

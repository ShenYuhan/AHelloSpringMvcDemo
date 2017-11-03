package HelloSpringMvc.service.serviceImpl;

import HelloSpringMvc.service.GenerateSql;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Created by yuhan.shen on 2017/11/3.
 */
@Service
public class GenerateSqlImpl implements GenerateSql{

    public String genInsertSql(String table, Map<String,String> maps){
        StringBuilder keys = new StringBuilder();
        StringBuilder values = new StringBuilder();
        for (String key:maps.keySet()){
            keys.append(key+",");
            values.append("\'"+maps.get(key)+"\'"+",");
        }
        String keyStr = keys.substring(0,keys.length()-1);
        String valueStr = values.substring(0,values.length()-1);

        StringBuilder sql = new StringBuilder()
                .append("insert into ")
                .append(table)
                .append(" (")
                .append(keyStr)
                .append(") values (")
                .append(valueStr)
                .append(");");
        return sql.toString();
    }

//    public static void main(String[] args) {
//        GenerateSqlImpl generateSql = new GenerateSqlImpl();
//        Map<String,String> maps = new LinkedHashMap<String, String>();
//        maps.put("user_name","yuhan.shen");
//        maps.put("password","123");
//        maps.put("sex","mail");
//        System.out.println(generateSql.genInsertSql("tbl_user_info",maps));
//    }

    public String genSelectSql(String database, Set<String> colSets, Map<String,String> valueMaps){

        StringBuilder colSetsStrBuild = new StringBuilder();
        for (String str:colSets){
            System.out.println(str);
            colSetsStrBuild.append(str)
                    .append(",");
        }
        String colSetsStr = colSetsStrBuild.substring(0,colSetsStrBuild.length()-1);

        StringBuilder valueMapsStrBuild = new StringBuilder();
        for (String key:valueMaps.keySet()){
            System.out.println(key);
            valueMapsStrBuild.append(key+"=\'"+valueMaps.get(key)+"\' and ");
        }
        String valueMapsStr = valueMapsStrBuild.substring(0,valueMapsStrBuild.length()-5);

        StringBuilder sql = new StringBuilder()
                .append("select ")
                .append(colSetsStr)
                .append(" from ")
                .append(database)
                .append(" where ")
                .append(valueMapsStr)
                .append(";");
        return sql.toString();
    }
//
//    public static void main(String[] args) {
//        GenerateSql generateSql = new GenerateSqlImpl();
//        Set<String> sets = new LinkedHashSet<String>();
//        sets.add("id");
//        sets.add("user_name");
//        sets.add("password");
//        Map<String,String> maps = new HashMap<String, String>();
//        maps.put("user_name","yuhan.shen");
//        maps.put("password","123");
//        System.out.println(generateSql.genSelectSql("tbl_user_info",sets,maps));
//    }

}

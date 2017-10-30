package HelloSpringMvc.service.serviceImpl;

import HelloSpringMvc.service.JDBCService;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuhan.shen on 2017/10/28.
 */
public class JDBCServiceImpl implements JDBCService{

    //适用于select操作
    public ResultSet executeQuery(String sql){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahellospringmvcdemodb","root","123");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }

    //适用于insert、update、delete等操作
    public int executeUpdate(String sql){
        Connection connection = null;
        Statement statement = null;
        int result = -1;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahellospringmvcdemodb","root","123");
            statement = connection.createStatement();
            result = statement.executeUpdate(sql);
            return result;
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public Map<Integer, ArrayList<String>> resultSetToMap(ResultSet resultSet){
        Map<Integer, ArrayList<String>> maps = new HashMap<Integer, ArrayList<String>>();
        try {
            int index = 0;
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            ArrayList<String> arrayList =  new ArrayList<String>();
            while (resultSet.next()){
                for (int i=1; i<=columnCount; ++i){
                    arrayList.add(resultSet.getString(i));
                }
                arrayList.clear();
                maps.put(index++,arrayList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maps;
    }

}

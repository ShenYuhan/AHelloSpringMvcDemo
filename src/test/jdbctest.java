import java.sql.*;

/**
 * Created by yuhan.shen on 2017/10/28.
 */
public class jdbctest {

    public static void main(String[] args){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahellospringmvcdemodb","root","123");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        String sql = "select id,user_name,password from tbl_user_info";
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            //cursor
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String userName = resultSet.getString(2);
                String password = resultSet.getString(3);
                System.out.println(id+":"+userName+"-"+password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

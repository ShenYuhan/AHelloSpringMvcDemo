package HelloSpringMvc.service;


import HelloSpringMvc.bo.UserDetail;
import HelloSpringMvc.enums.CheckLoginEnum;
import HelloSpringMvc.enums.CheckRegisterEnum;
import HelloSpringMvc.service.serviceImpl.JDBCServiceImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuhan.shen on 2017/10/27.
 */
public class CheckParam {

    public CheckLoginEnum checkLoginParam(String userName, String password){
        StringBuilder sql = new StringBuilder("");
        sql.append("select * from tbl_user_info where user_name=\'")
                .append(userName)
                .append("\'");
        System.out.println(sql);
        JDBCServiceImpl jdbcService = new JDBCServiceImpl();
        ResultSet resultSet = jdbcService.executeQuery(sql.toString());
        try {
            if (resultSet.next()){
                if (resultSet.getString(3).equals(password)){
                    return CheckLoginEnum.SUCCESS;
                }
                else{
                    return CheckLoginEnum.FAIL_PASSWORD;
                }
            }
            else{
                return  CheckLoginEnum.FAIL_USER_NAME;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CheckLoginEnum.FAIL_SYS;
    }

    public CheckRegisterEnum checkRegisterParam(String userName,String password){
        StringBuilder sql = new StringBuilder("");
        sql.append("select * from tbl_user_info where user_name=\'")
                .append(userName)
                .append("\'");
        ResultSet resultSet = null;
        JDBCServiceImpl jdbcService = new JDBCServiceImpl();
        resultSet = jdbcService.executeQuery(sql.toString());
        try {
            if (resultSet.next()){
                return CheckRegisterEnum.DUPLICATE_USERNAME;
            }
            else{
                StringBuilder registerSql = new StringBuilder("");
                registerSql.append("insert into tbl_user_info (user_name,password) value (\'")
                        .append(userName)
                        .append("\',\'")
                        .append(password)
                        .append("\')");
                System.out.println(registerSql);
                if (jdbcService.executeUpdate(registerSql.toString())==1){
                    return CheckRegisterEnum.REGISTER_SUCCESS;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return CheckRegisterEnum.FAIL_SYS;
    }

    public CheckRegisterEnum checkRegisterDetailParam(UserDetail userDetail){
        StringBuilder sql = new StringBuilder()
                .append("select id from tbl_user_info where user_name=\'")
                .append(userDetail.getUserName())
                .append("\'");
        JDBCServiceImpl jdbcService = new JDBCServiceImpl();
        ResultSet resultSet = jdbcService.executeQuery(sql.toString());
        try{
            if (resultSet.next()){
                return CheckRegisterEnum.DUPLICATE_USERNAME;
            }
            else{
                StringBuilder registerSql = new StringBuilder()
                        .append("insert into tbl_user_info (user_name,password) value (\'")
                        .append(userDetail.getUserName())
                        .append("\',\'")
                        .append(userDetail.getPassword())
                        .append("\')");
                System.out.println(registerSql);
                Map<Integer,ArrayList<String>> maps = jdbcService.resultSetToMap(jdbcService.executeQuery(sql.toString()));
                if (jdbcService.executeUpdate(registerSql.toString())==1){
                    System.out.println("123");
                    StringBuilder registerDetailSql = new StringBuilder()
                            .append("insert into tbl_user_detail_info (id,user_name) value (\'")
//                            .append(maps.get(0).get(0))
                            .append("333")
                            .append("\',\'")
                            .append(userDetail.getUserName())
//                            .append("\',\'")
//                            .append(userDetail.getPassword())
                            .append("\')");
                    if (jdbcService.executeUpdate(registerDetailSql.toString())==1){
                        return CheckRegisterEnum.REGISTER_SUCCESS;
                    }
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return CheckRegisterEnum.FAIL_SYS;
    }

}

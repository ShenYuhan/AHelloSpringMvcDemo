package HelloSpringMvc.service;


import HelloSpringMvc.bo.UserDetail;
import HelloSpringMvc.enums.CheckLoginEnum;
import HelloSpringMvc.enums.CheckRegisterEnum;
import HelloSpringMvc.service.serviceImpl.GenerateSqlImpl;
import HelloSpringMvc.service.serviceImpl.JDBCServiceImpl;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by yuhan.shen on 2017/10/27.
 */
public class CheckParam {
    public CheckLoginEnum checkLoginParam(String userName, String password){
        GenerateSql generateSql = new GenerateSqlImpl();
        Set<String> sets = new LinkedHashSet<String>();
        sets.add("*");
        Map<String,String> userInfoMap = new HashMap<String, String>();
        userInfoMap.put("user_name",userName);
        String sqlSelect = generateSql.genSelectSql("tbl_user_info",sets,userInfoMap);

        JDBCServiceImpl jdbcService = new JDBCServiceImpl();
        ResultSet resultSet = jdbcService.executeQuery(sqlSelect);
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
        GenerateSql generateSql = new GenerateSqlImpl();
        Set<String> sets = new LinkedHashSet<String>();
        sets.add("*");
        Map<String,String> userInfoMap = new HashMap<String, String>();
        userInfoMap.put("user_name",userName);
        userInfoMap.put("password",password);
        String sqlSelect = generateSql.genSelectSql("tbl_user_info",sets,userInfoMap);

        ResultSet resultSet = null;
        JDBCServiceImpl jdbcService = new JDBCServiceImpl();
        resultSet = jdbcService.executeQuery(sqlSelect);
        try {
            if (resultSet.next()){
                return CheckRegisterEnum.DUPLICATE_USERNAME;
            }
            else{
                String sql2 = generateSql.genInsertSql("tbl_user_info",userInfoMap);
                if (jdbcService.executeUpdate(sql2)==1){
                    return CheckRegisterEnum.REGISTER_SUCCESS;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return CheckRegisterEnum.FAIL_SYS;
    }

    public CheckRegisterEnum checkRegisterDetailParam(UserDetail userDetail){
        GenerateSql generateSql = new GenerateSqlImpl();
        Set<String> sets = new LinkedHashSet<String>();
        sets.add("id");
        Map<String,String> userInfoMap = new HashMap<String, String>();
        userInfoMap.put("user_name",userDetail.getUserName());
        String sqlSelectUserId = generateSql.genSelectSql("tbl_user_info",sets,userInfoMap);

//
//        userInfoMap.put("user_name",userDetail.getPassword());
//        userInfoMap.put("user_name",userDetail.getSex());
//        userInfoMap.put("user_name",userDetail.getAge());
//        userInfoMap.put("user_name",userDetail.getTel());
//        userInfoMap.put("user_name",userDetail.getEmail());
//        userInfoMap.put("user_name",userDetail.getSpouse());
//        userInfoMap.put("user_name",userDetail.getUserName());
//        generateSql.genSelectSql("tbl_user_detail_info",);
//        String sqlSelectUserDetail = null;
//
//        StringBuilder sql = new StringBuilder()
//                .append("select id from tbl_user_info where user_name=\'")
//                .append(userDetail.getUserName())
//                .append("\'");
        JDBCServiceImpl jdbcService = new JDBCServiceImpl();
        ResultSet resultSet = jdbcService.executeQuery(sqlSelectUserId);
        try{
            Long id = resultSet.getLong(1);
            if (resultSet.next()){
                return CheckRegisterEnum.DUPLICATE_USERNAME;
            }
            else{
                Map<String,String> sqlInsertUserDetailMap = new HashMap<String, String>();
                sqlInsertUserDetailMap.put("id",id.toString());
                sqlInsertUserDetailMap.put("user_name",userDetail.getUserName());
                sqlInsertUserDetailMap.put("sex",userDetail.getSex().toString());
                sqlInsertUserDetailMap.put("age",userDetail.getAge().toString());
                sqlInsertUserDetailMap.put("tel",userDetail.getTel());
                sqlInsertUserDetailMap.put("email",userDetail.getEmail());
                sqlInsertUserDetailMap.put("spouse",userDetail.getSpouse());
                String sqlInsertDetailInfo = generateSql.genInsertSql("tbl_user_detail_info",sqlInsertUserDetailMap);
                Map<Integer,ArrayList<String>> maps = jdbcService.resultSetToMap(jdbcService.executeQuery(sqlInsertDetailInfo));
                return CheckRegisterEnum.REGISTER_SUCCESS;


//                if (jdbcService.executeUpdate(registerSql.toString())==1){
//                    System.out.println("123");
//                    StringBuilder registerDetailSql = new StringBuilder()
//                            .append("insert into tbl_user_detail_info (id,user_name) value (\'")
////                            .append(maps.get(0).get(0))
//                            .append("333")
//                            .append("\',\'")
//                            .append(userDetail.getUserName())
////                            .append("\',\'")
////                            .append(userDetail.getPassword())
//                            .append("\')");
//                    if (jdbcService.executeUpdate(registerDetailSql.toString())==1){
//                        return CheckRegisterEnum.REGISTER_SUCCESS;
//                    }
//                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return CheckRegisterEnum.FAIL_SYS;
    }

}

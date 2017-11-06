package HelloSpringMvc.dao;
import HelloSpringMvc.model.UserDetailInfoModel;
import HelloSpringMvc.model.UserInfo;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuhan.shen on 2017/11/6.
 */
public class UserAccountDao extends BaseDao{

    public UserInfo selectUserInfoById(Long id){
        return (UserInfo) selectOne("UserInfoMapper.selectUserInfoById",id);
    }

    public UserInfo selectUserInfoByUserName(String userName){
        return (UserInfo) selectOne("UserInfoMapper.selectUserInfoByUserName",userName);
    }

    public boolean isExistUserInfoByUserName(String userName){
        Integer result = selectCount("UserInfoMapper.selectUserInfoCountByUserName",userName);
        if (result.intValue()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isExistUserDetailInfoByUserName(String userName){
        Integer result = selectCount("UserDetailInfoMapper.selectUserDetailInfoCountByUserName",userName);
        if (result.intValue()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean insertUserInfo(String userName,String password){
        Map<String,String> map = new HashMap<String, String>();
        map.put("userName",userName);
        map.put("password",password);
        if (insert("UserInfoMapper.insertUserInfo",map)==1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean insertUserDetailInfo(UserDetailInfoModel userDetailInfo){
        if (insert("UserDetailInfoMapper.insertUserDetailInfo",userDetailInfo)==1){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        UserAccountDao userAccountDao = new UserAccountDao();
        UserDetailInfoModel userDetailInfo = new UserDetailInfoModel();
        userDetailInfo.setUserName("ganga");
        userDetailInfo.setId(Long.valueOf(33));
        userDetailInfo.setAge(33);
        userDetailInfo.setSex(Integer.valueOf(3));
        userDetailInfo.setEmail("@163");
        userDetailInfo.setSpouse("lqq");
        userDetailInfo.setTel("13366662222");
        userAccountDao.insertUserDetailInfo(userDetailInfo);
    }





}

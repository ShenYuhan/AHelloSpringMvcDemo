package HelloSpringMvc.bo;

/**
 * Created by yuhan.shen on 2017/11/11.
 */
public class UserInfoBo {

    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        System.out.println("userName: "+userName);
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("password: "+password);
        this.password = password;
    }
}

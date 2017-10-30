package HelloSpringMvc.enums;

/**
 * Created by yuhan.shen on 2017/10/27.
 */
public enum CheckLoginEnum {
    SUCCESS(0,"登录成功"),FAIL_PASSWORD(1,"密码错误"),FAIL_USER_NAME(2,"用户名不存在"),FAIL_SYS(3,"系统异常，请联系管理员");

    private int errorCode;
    private String errorMsg;

    CheckLoginEnum(int errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int erroorCode) {
        this.errorCode = erroorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

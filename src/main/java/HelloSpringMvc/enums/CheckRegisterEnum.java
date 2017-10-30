package HelloSpringMvc.enums;

/**
 * Created by yuhan.shen on 2017/10/28.
 */
public enum CheckRegisterEnum {

    REGISTER_SUCCESS(0,"注册成功，请牢记您的密码"),DUPLICATE_USERNAME(1,"用户名已存在"),FAIL_SYS(3,"系统异常，请联系管理员");

    private int errorCode;
    private String errorMsg;

    CheckRegisterEnum(int errorCode, String errorMsg){
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

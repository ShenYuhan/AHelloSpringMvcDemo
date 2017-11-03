package HelloSpringMvc.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuhan.shen on 2017/11/3.
 */
public class DatabaseLoginInfo {
    private String type;

    private String address;

    private String port;

    private String database;

    private String userName;

    private String password;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public DatabaseLoginInfo(String address, String port, String database, String userName, String password) {
//        this.address = address;
//        this.port = port;
//        this.database = database;
//        this.userName = userName;
//        this.password = password;
//    }

    public Map<String,String> databaseLoginInfoMap(){
        Map<String,String> maps = new HashMap<String,String>();
        maps.put("address",address);
        maps.put("port",port);
        maps.put("database",database);
        maps.put("userName",userName);
        maps.put("password",password);
        return maps;
    }

    public String getUrl(){
        return type+address+":"+port+"/"+database;
    }

}

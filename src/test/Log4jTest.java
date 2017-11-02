import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created by yuhan.shen on 2017/11/2.
 */
public class Log4jTest {

    private static Logger logger = Logger.getLogger(Log4jTest.class);

    public static void main(String[] args) {

//        一旦初始化一次就可以了？
//        PropertyConfigurator.configure("log4j.properties");
        System.out.println("321");
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
//         记录error级别的信息
        logger.error("This is error message.");
    }
}

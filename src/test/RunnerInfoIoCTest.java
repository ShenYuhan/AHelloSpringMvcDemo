import HelloSpringMvc.model.RunnerInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuhan.shen on 2017/11/7.
 */
public class RunnerInfoIoCTest {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RunnerInfo runnerInfo = (RunnerInfo) context.getBean("RunnerInfo");
        runnerInfo.sayHello();
    }
}

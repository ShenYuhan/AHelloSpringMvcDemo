import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import HelloSpringMvc.model.User;

/**
 * Created by yuhan.shen on 2017/10/24.
 */
public class UserTest {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloSpringMvc.model.User user = (HelloSpringMvc.model.User) context.getBean("user");
        HelloSpringMvc.model.User user2 = (HelloSpringMvc.model.User) context.getBean("user");
        System.out.println(user.getUserName());
        System.out.println(user.getUserId());
        System.out.println(user.getAge());


        System.out.println(user2.getUserName());
        System.out.println(user2.getUserId());
        System.out.println(user2.getAge());
    }
}

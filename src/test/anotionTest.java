import HelloSpringMvc.dao.UserAccountDao;
import org.junit.Test;

/**
 * Created by yuhan.shen on 2017/11/15.
 */
public class anotionTest {

    private UserAccountDao userAccountDao = new UserAccountDao();

    @Test
    public void testAnotation(){
        userAccountDao.printTest();
    }

}

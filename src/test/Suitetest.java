import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by yuhan.shen on 2017/10/30.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({})
public class Suitetest {

    public static void main(String[] args) {
        System.out.println("这个也运行了");
    }

    @Test
    public void ttt(){
        System.out.println("还有这");
    }

}

import HelloSpringMvc.model.classfile.CalculateToTest;
import org.junit.*;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

/**
 * Created by yuhan.shen on 2017/10/30.
 */
public class mockitotest {

    CalculateToTest calculateToTest = new CalculateToTest();
    int addResult = calculateToTest.add(1,2);
    int subResult = calculateToTest.sub(3,4);
    int divideResult = calculateToTest.divide(4,2);
    int assertAddResult = 3;
    int assertSubResult = -1;
    int assertDivideResult = 2;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass");
    }

    @Before
    public void before(){
        System.out.println("before");
    }

    @After
    public void after(){
        System.out.println("after");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass");
    }

    @Ignore("he")
    @Test
    public void test3(){
        System.out.println("对啊");
        assertEquals(3,3);
    }

    @Test
    public void test(){
        System.out.println("test");
        assertEquals("错误123",addResult,assertAddResult);
    }

    @Test
    public void test1(){

        assertTrue(1==1);
    }

    @Test
    public void differentAssertTest(){
        String obj1 = "junit";
        String obj2 = "junit";
        String obj3 = "unit";
        String obj4 = "unit";
        String obj5 = null;
        int var1 = 1;
        int var2 = 2;
        int[] arithmetic1 = {1,2,3};
        int[] arithmetic2 = {1,2,3};

        assertEquals(obj1,obj2);
        assertSame(obj3,obj4);
        assertNotSame(obj2,obj4);
        assertNotNull(obj1);
        assertNull(obj5);
        assertTrue((var1+1)==var2);
        assertArrayEquals(arithmetic1,arithmetic2);
    }

    @Ignore("ha")
    @Test
    public void test2(){
        System.out.println("对啊");
        assertEquals(3,3);
    }



}

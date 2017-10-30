import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by yuhan.shen on 2017/10/30.
 */
@RunWith(Parameterized.class)
public class paramTest{

    private String expectStr;
    private String str1;
    private String str2;
    private String str3;

    public paramTest(String expectStr,String str1,String str2,String str3){
        this.expectStr = expectStr;
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
    }

    @Parameterized.Parameters
    public static Collection asd(){
        return Arrays.asList(new String[][]{{"3s4","3","s","4"},{"2d7","2","d","6"}});
    }

    public String add(String str1,String str2,String str3){
        return str1+str2+str3;
    }

    @Ignore("Not Ready!")
    @Test
    public void adasd(){
        System.out.println(str1+"+"+str2+"+"+str3);
        assertEquals(expectStr,add(str1,str2,str3));
    }
}

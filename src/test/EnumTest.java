import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by yuhan.shen on 2017/11/17.
 */
public class EnumTest {

    public static void main(String[] args){
        Vector<String> vector = new Vector<String>();
        vector.add("Tom");
        vector.add("Jerry");
        vector.add("Zhangsan");
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
    }
}

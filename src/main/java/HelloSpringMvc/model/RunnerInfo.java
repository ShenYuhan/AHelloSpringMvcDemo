package HelloSpringMvc.model;

/**
 * Created by yuhan.shen on 2017/11/7.
 */
public class RunnerInfo {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayHello(){
        System.out.println("Hello,My name is "+this.name);
    }
}

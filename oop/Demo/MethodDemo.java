class Man{
    private  int age;
    private  String name;
    // 方法名与类名称相同，并且无放回值定义
    public Man(final String n, final int a) {// 定义有参构造
        name = n;
        age = a;
    }
    public void tell() {
        System.out.println("name:" + name + " age:" + age);
    }
    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
}
public class MethodDemo {
    public static void main(final String[] args) {
        Man per = new Man("张三", 18);
        per.setAge(20);
        per.tell();
    }    
}
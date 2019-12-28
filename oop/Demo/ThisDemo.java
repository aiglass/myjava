
/**
 * person
 */
class Human {
    private String name;
    private int age;
    public Human(String name,int age){
        this.name=name;
        this.age=age;
    }    
    public void tell(){
        System.out.println("姓名"+name+"年龄"+age);
    }
}
public class ThisDemo{
    public static void main(String[] args) {
        Human per=new Human("张三", 18);
        per.tell();
    }
}
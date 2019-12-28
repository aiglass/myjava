class Person{//定义一个Person类
       private String name;//属性name
       private int age;//属性age
       public void tell(){//定义一个行为
           System.out.println("姓名"+name+"年龄"+age);
       }
       /**
        * @param name the name to set
        */
       public void setName(String name) {
              this.name = name;
       }
       /**
        * @return the name
        */
       public String getName() {
              return name;
       }
       /**
        * @param age the age to set
        */
       public void setAge(int age) {
              this.age = age;
       }
       /**
        * @return the age
        */
       public int getAge() {
              return age;
       }
}
public class JavaDemo{
       //方法一
       public static void main(String args[]) {
              Person man=new Person();
              man.setAge(10);//在类外部对属性进行修改
              man.setName("张三");
              man.tell();
       }
}
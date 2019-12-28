/**
 * Channel
 */
class Channel {
    public void connect() {
        System.out.println("建立连接");
    }    
}
/**
 * DatabaseChannel 
 */
class DatabaseChannel extends Channel {
    @Deprecated
    public void connect() {
        System.out.println("数据库连接");
    }    
    @Deprecated
    public void con() {
        System.out.println("sdf");
    }
}

class A {    
    public void print(){System.out.println("a");}
}
class B extends A{
    public void print(){System.out.println("b");}
}
class C extends A{
    public void print(){System.out.println("c");}
}
public class OverrideDemo {
    public static void getClass(A a){a.print();}
    public static void main(String[] args) {
        getClass(new B());
        getClass(new C());
    }}
class Human {
    public void speak(){System.out.println("会说话！");}
}
class Supperman extends Human {
    public void fly(){System.out.println("我会飞");};
    public void fire(){System.out.println("我会喷火");};
}
public class DuotaiDemo {
    public static void main(String[] args) {
        Human man=new Supperman();//向上转型
        man.speak();
        Supperman man2=(Supperman) man;//向下转型
        man2.fly();
    }
}
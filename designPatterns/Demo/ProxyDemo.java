interface IEat {
    public abstract void Eat();
}

class Proxy implements IEat {
    private IEat eat;

    public Proxy(IEat eat) {
        this.eat = eat;
    }

    // 煮饭
    public void Eat() {
        this.Cook();
        this.eat.Eat();
        this.Clean();
    }

    public void Cook() {
        System.out.println("【1】煮饭");
    }

    public void Clean() {
        System.out.println("【2】洗碗");
    }
}

class Reat implements IEat {
    public void Eat() {
        System.out.println("顾客吃饭");
    }
}

/**
 * ProxyDemo
 */
public class ProxyDemo {
    public static void main(String[] args) {
        IEat eat=new Proxy(new Reat());
        eat.Eat(); 
    }
}
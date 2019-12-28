class Car {
    private String name;
    private Person person;

    public Car(final String name) {
        this.name = name;
    }

    public String getInfo() {
        return "品牌:" + this.name;
    }
}

/**
 * TestDemo1
 */
public class TestDemo1 {
    public static void main(String args[]) {
        Car car1 = new Car("宾利");
    }
}
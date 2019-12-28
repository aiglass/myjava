class Car{
    private static int ctr=0;
    private String cname;
    public Car(){
        Car.ctr++;
    }
    public Car(String cname){
        this();
        this.cname=cname;
    }
    /**
     * @return the ctr
     */
    public static int getCtr() {
        return ctr;
    }
    public String getInfo() {
        return "汽车名：" + this.cname;
    }
}

public class CountObj{//统计对象实例化的个数
    public static void main(String[] args) {
        Car car=new Car("摩托");
        Car car1=new Car("面包");
        Car car2=new Car("suv");
        Car car3=new Car("pmv");
        System.out.println(car.getInfo());
        System.out.println(Car.getCtr());
    }
}
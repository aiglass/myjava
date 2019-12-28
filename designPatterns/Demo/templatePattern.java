import java.util.ResourceBundle.Control;

/**
 * 模版设计模式
 * templatePattern
 */

/**
 * 定义模版
 * ActionModel
 * abstract
 */
abstract class ActionModel {
    //定义控制指令常量
    public static final int GAS=1;
    public static final int DRIVE=2;
    public static final int CARGO=3;
    //定义通用的行为方法 
    //加油
    public abstract void gasoline();
    //行驶
    public abstract void drive();
    //拉货
    public abstract void cargo();
    //写个遥控器 final跟上别小气
    public final void control(int cmd){
        switch (cmd) {
            case GAS:
                this.gasoline();
                break;
            case DRIVE:
                this.drive();
                break;
            case CARGO:
                this.cargo();
                break;
            case GAS+DRIVE+CARGO:
                this.gasoline();
                this.drive();
                this.cargo();
                break;
            default:
                break;
        }
    }
}
class Cars extends ActionModel{
     public void gasoline(){System.out.println("汽车要加油");};
     public void drive(){System.out.println("四个轮子路上开");};
     public void cargo(){System.out.println("尾箱装货，别放后排");};
}
//自行车
class Bicycle extends ActionModel{
    public void gasoline(){};
    public void drive(){System.out.println("两个轮子人踩走");};
    public void cargo(){};
}
//电动汽车
class ElectricCars extends ActionModel{
    public void gasoline(){};
    public void drive(){System.out.println("四个轮子路上开");};
    public void cargo(){System.out.println("电动后备箱，大货不能装");};
}
public class templatePattern {
    public static void main(String[] args) {
        ActionModel car=new Cars();
        ActionModel bike=new Bicycle();
        ActionModel tslar=new ElectricCars();
        System.out.println("汽车----------");
        car.control(ActionModel.GAS+ActionModel.DRIVE+ActionModel.CARGO);
        System.out.println("自行车---------");
        bike.control(ActionModel.GAS+ActionModel.DRIVE+ActionModel.CARGO);
        System.out.println("电动汽车---------");
        tslar.control(ActionModel.GAS+ActionModel.DRIVE+ActionModel.CARGO);

    }
}
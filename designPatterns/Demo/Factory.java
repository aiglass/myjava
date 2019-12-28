/**
 * 定义食物接口，eat(),isSafe()
 * 定义一种食物面包Bread
 * 定义一个工厂FoodFactory
 */
/**
 * IFood
 */
interface IFood {
    public abstract void eat();
}
class Bread implements IFood{
    public void eat(){
        System.out.println("吃面包");
    }
}
class Nofood implements IFood{
    public void eat(){
        System.out.println("没有这种食物");
    }
}
class FoodFactory{
    public static <T> T eatFood(String classname){
        System.out.println(classname);
        if("bread".equals(classname)){
            return (T) new Bread();
        }else{
            return (T) new Nofood();
        }
    }
}

public class Factory {
    public static void main(String[] args) {
        IFood food=FoodFactory.eatFood("bread");
        food.eat();
    }
}
### 购物车shopcart
使用面向对象的概念表输出下面的生活场景：    
小明去超市购物，所有买到的东西都放到了购物车，做好在收银台一起结账。
![屏幕快照 2019-12-10 下午7.40.41](http://mysource.moneygc.com/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-12-10%20%E4%B8%8B%E5%8D%887.40.41.png)

#### 实现步骤
前提：已经有了链表的接口和子类
1.  定义商品的标准：
    -   interface IGood
        -   属性：名字、价格
        -   方法：获取名字、获取价格
2.  定义购物车的标准：
    -   属性：
    -   方法：添加商品、删除商品
3.  实现购物车类
4.  定义收银台Cashier：省略收银台接口
    -   属性：购物车
    -   方法：allPrice、allcount
5.  book类按商品标准实现

```
//定义商品的标准
interface IGoods{
    public String getName();
    public double getPrice();
}
//定义购物车标准
interface ICart{
    public void add(IGoods goods);//添加商品信息
    public void del(IGoods goods);//删除商品信息
    public Object[] getAll();//获取购物车所有的商品
}
//购物车实现
class Cart implements ICart{
    //实例化链表对象存储商品
    private ILink<IGoods> allgoods=new LinkImpl<IGoods>();
    public void add(IGoods goods) {
        this.allgoods.add(goods);
    }
    public void del(IGoods goods) {
        this.allgoods.remove(goods);
    }
    public Object[] getAll() {
       return this.allgoods.toArray();
    }  
}
//收银台
class Cashier{
    private ICart icart;//用于传入购物车
    public Cashier(ICart icart){
        this.icart=icart;
    }
    public double allPrice(){
        double allprice=0.0;
        Object all[]=this.icart.getAll();
        for (Object obj : all) {
             IGoods a=(IGoods)obj;
             allprice+=a.getPrice();
        }
        return allprice;
    }
    public int allCount(){
        return this.icart.getAll().length;
    }
}
//商品类
class Book implements IGoods{
    private String name;
    private double price;
    public Book(String name,double price){
        this.name=name;
        this.price=price;
    }
    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }
    public boolean equals(Object obj){
        if(obj==null)return false;
        if(this==obj)return true;
        if(!(obj instanceof Book))return false;
        Book book=(Book)obj;
        return this.name.equals(book.name)&&this.price==book.price;
    }
    public String toString(){
        return "【图书】名称："+this.name+",价格"+this.price;
    }
}
public class ShopCart {
    public static void main(String[] args) {
        ICart cart=new Cart();
        cart.add(new Book("红楼",10.1));
        cart.add(new Book("字典",10.2));
        cart.add(new Book("贸易",10.3));
        Cashier cashier = new Cashier(cart);
        System.out.println(cashier.allCount());
        System.out.println(cashier.allPrice());
    }
}

```
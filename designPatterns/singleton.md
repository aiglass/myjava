### 单例设计模式 singleton
**特点：**构造方法私有化，类内部提供static方法获取实例化对象，不管外部如何调用，只实例化了一次

只允许一个类提供一个实例化对象，不能再进行实例化对象。通过构造方法控制，增加final Static 属性和Static方法。
```
class Message{
    private final static Message MESSAGE=new Message();
    private void Message(){};
    public static Message getInstance(){
        MESSAGE=new Message();
        return MESSAGE;
    }
    public vod print(){
        System.out.println("实例化了一次")
    }
}
```
实际开发中，很多情况下是不需要重复实例化类的。通过某一个类加载系统信息，方便程序的调用。
-   饿汉式：在系统加载类时就会对类进行实例化（上面的例子就是饿汉式）
-   懒汉式：在第一次使用时，再进行实例化对象

下面将Message修改为懒汉式.
```
class Message{
    private static Message message;
    private void Message(){};
    public static Message getInstance(){
        if(message==null){
            message=new Message();
        }
        return message;
    }
    public vod print(){
        System.out.println("实例化了一次")
    }
}
```

#### 多例设计
可以保留多个实例化对象
### 覆写
发现子类从父类继承的操作不符合场景，就需要对操作进行覆写
#### 方法的覆写
子类定义了与父类中方法数据类型和方法参数相同，就是对方法的覆写
-   由于实例化的是子类，先调用子类覆写的方法，如果没有覆写则调用父类的方法
-   使用super.方法()调用父类中的方法
-   被覆写的方法不能够使用比父类中方法更严格的访问控制权限public>default>private
-   private的方法不能被覆写
#### 属性的覆盖
-   当子类定义了与父类相同名称的属性时会进行覆盖，父类的属性一旦封装就不存在覆盖
-   this调用属性先找本类，若不存在再找父类

### final关键字
定义不能被继承的类、方法、常量
-   final class 不能被继承
-   final method不能被覆盖和重载
-   final 用于定义常量 不能被修改 
-   常常会使用 public static final 定义全局常量
-   常量建议使用大写，便于区分
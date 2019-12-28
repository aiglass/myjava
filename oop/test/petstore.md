### 宠物店 pet store
有一个宠物商店，里面可以出售各种宠物，要求可以实现宠物的上架处理、下架处理，也可以根据关键字查询处宠物的信息。

#### 相互关系
宠物商店、宠物接口、多种宠物类、链表接口、链表实现子类
![屏幕快照 2019-12-10 下午6.32.30](http://mysource.moneygc.com/%E5%B1%8F%E5%B9%95%E5%BF%AB%E7%85%A7%202019-12-10%20%E4%B8%8B%E5%8D%886.32.30.png)

#### 实现
定义宠物的标准
-   宠物名字、颜色

#### 总结
所有的程序开发都是以接口为标准进行的，在进行后期程序处理的时候就非常的灵活，只要复合标准的对象都可以进行存储。

#### 代码
其实整体结构还可以进行优化，加入抽象动物类和工厂类。
```
import com.moneygc.util.ILink;
interface Pet {// 定义宠物标准
    public String getName();
    public String getColor();
    public String getString();
}
class Petshop {// 宠物商店
    // 保存多个宠物
    private final ILink<Pet> allPets = new LinkImpl<Pet>();
    // 增加宠物,上架
    public void add(final Pet pet) {
        this.allPets.add(pet);
    }
    //宠物下架
    public void delet(final Pet pet) {
        this.allPets.remove(pet);
    }
    public ILink<Pet> search(final String keyword) {
        final LinkImpl<Pet> searchResult = new LinkImpl<Pet>();// 保存查询结果
        final Object result[] = this.allPets.toArray();// 获取全部数据
        if (result != null) {
            for (final Object object : result) {
                final Pet pet = (Pet) object;
                if (pet.getName().contains(keyword) || pet.getColor().contains(keyword)) {
                    searchResult.add(pet);// 保存查询结果
                }
            }
        }
        return searchResult;
    }
}
//宠物猫类实现Pet接口
class Cat implements Pet {
    private final String name;
    private final String color;
    public Cat(final String name, final String color) {
        this.name = name;
        this.color = color;
    }
    public String getName() {
        return this.name;
    }
    public String getColor() {
        return this.color;
    }
    public boolean equals(Object obj) {
        if (obj == null)return false;
        if (obj instanceof Cat)return true;
        if(this==obj)return true;
        Cat cat=(Cat) obj;
        return this.name.equals(cat.name)&&this.color.equals(cat.color);
    }
    public String toString() {
        return "【宠物猫】名字：" + this.name + "， 颜色:" + this.color;
    }
}

class Dog implements Pet {
   //和Cat类相同代码略
}
//测试代码
public class PetStoreDemo {
    public static void main(final String[] args) {
        final Petshop petshop = new Petshop();
        petshop.add(new Cat("草鱼", "白色"));
        petshop.add(new Cat("津巴", "红色"));
        petshop.add(new Dog("奥巴马", "红色"));
        petshop.add(new Dog("尼克斯", "红色"));
        final Object pet[] = petshop.search("奥巴马").toArray();
        for (final Object pet2 : pet) {
            System.out.println(pet2.toString());
        }
    }
}
```
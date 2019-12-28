interface ILink<E> {
    public Boolean add(E e);
    public int size();
    public Boolean isEmpty();
    public Object[] toArray();
    public  E get(int index);
    public Boolean set(int index,E data);
    public int contains(E data);
    public Boolean remove(E data);
    public Boolean clean();
}
class LinkImpl<E> implements ILink<E> {
    private class Node {
        private E data;
        private Node next;
        public Node(final E data) {
            this.data = data;
        }

        // 通过递归，保存新的node节点
        public void addNode(final Node newNode) {
            // 当前节点的下一个节点为空，意味着可以插入新节点
            if (this.next == null) {
                this.next = newNode;
            } else {
                this.next.addNode(newNode);
            }
        }

        // 第一次调用：this =
        // linkImpl.root第二次调用：this=linkImpl.root.next第三次调用：this=linkImpl.root.next.next。。。
        public void toArrayNode() {
            LinkImpl.this.returnData[LinkImpl.this.foot++] = this.data;
            if (this.next != null) {// 还有下一个数据
                this.next.toArrayNode();
            }
        }

        public E getNode(final int index) {
            if (LinkImpl.this.foot++ == index) {// 判断索引是否相同，并进行foot++
                return data;
            } else {
                return this.next.getNode(index);
            }
        }

        public Boolean setNode(final int index, final E data) {
            if (LinkImpl.this.foot++ == index) {// 判断索引是否相同，并进行foot++
                this.data = data;
                return true;
            } else {
                return this.next.setNode(index, data);
            }
        }

        public int containsNode(final E data) {
            LinkImpl.this.foot++;
            if (this.data.equals(data)) {
                return LinkImpl.this.foot - 1;
            } else {
                if (this.next == null) {
                    return -1;
                } else {
                    return this.next.containsNode(data);
                }
            }
        }

        public Boolean removeNode(final Node previous, final E data) {
            if (this.data.equals(data)) {
                previous.next = this.next;
                LinkImpl.this.count--;
                return true;
            } else {
                if (this.next != null) {
                    return this.next.removeNode(this, data);
                } else {
                    return false;
                }
            }
        }
    }

    // ------------------link类中定义的成员------------------
    // 添加数据、获取数据
    private int count = 0;// 保存数据个数
    private Node root;// 保存根元素
    private int foot = 0;// 追加脚标
    private Object[] returnData;// 返回数据的保存

    @Override
    public Boolean add(final E e) {
        if (e == null) {
            return false;
        }
        final Node newnode = new Node(e);
        if (this.root == null) {
            this.root = newnode;
        } else {
            root.addNode(newnode);
        }
        count++;
        return true;
    }

    public int size() {
        return this.count;
    }

    public Boolean isEmpty() {
        return this.count == 0;
    }

    public Object[] toArray() {
        // TODO Auto-generated method stub
        if (this.isEmpty()) {
            return null;
        }
        this.foot = 0;// 脚标清零
        this.returnData = new Object[this.count];// 根据已有的长度开辟一个数组
        this.root.toArrayNode();
        return this.returnData;
    }

    public E get(final int index) {
        if (index >= this.count) {// 索引范围
            return null;
        }
        this.foot = 0;// 重置索引下标从0开始递归查找
        return this.root.getNode(index);
    }

    public Boolean set(final int index, final E data) {
        if (index >= this.count) {// 索引范围
            return false;
        }
        this.foot = 0;
        return this.root.setNode(index, data);
    };

    public int contains(final E data) {
        this.foot = 0;
        return this.root.containsNode(data);
    }

    @Override
    public Boolean remove(final E data) {

        if (this.contains(data) >= 0) {
            if (this.root.data.equals(data)) {
                this.root = this.root.next;// 根节点的下一个节点
                this.count--;
                return true;
            } else {
                return this.root.next.removeNode(this.root, data);
            }
        } else {
            return false;
        }
    }

    public Boolean clean() {
        this.root = null;
        this.foot = 0;
        this.count = 0;
        return null;
    }
}

interface Pet {// 定义宠物标准
    public String getName();

    public String getColor();
}

class Petshop {// 宠物商店
    // 保存多个宠物
    private final ILink<Pet> allPets = new LinkImpl<Pet>();

    // 增加宠物,上架
    public void add(final Pet pet) {
        this.allPets.add(pet);
    }

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
    private final String name;
    private final String color;
    public Dog(final String name, final String color) {
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
        if (obj instanceof Dog)return true;
        if(this==obj)return true;
        Dog dog=(Dog) obj;
        return this.name.equals(dog.name)&&this.color.equals(cat.color);
    }
    public String toString() {
        return "【宠物狗】名字：" + this.name + "， 颜色:" + this.color;
    }
}
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
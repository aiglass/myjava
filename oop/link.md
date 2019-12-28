### 链表
**本质是一个动态的对象数组，可以实现若干个对象的存储**  
实际开发中，对象数组很常用，利用其可以描述出“多方”的概念。可以实现灵活的数据保存
>例如：一个人有多本书，传统数组长度是固定的。实际开发中，传统数组的应用范围是非常有限的。

#### 链表的实现
传统数组开发依赖脚标的控制，如果想要实现内容的动态维护，复杂度太高。
-   对于长度不变的数据可以使用传统数组
-   对于动态变化的数据需要使用动态的对象数组

**链表通过引用的逻辑关系来实现动态数组类似的功能**
1.  数据的添加add():   
link类只负责数据的操作和跟节点的处理，而所有的节点都是Node类处理的

2.  数据的长度size():   
在link类中增加计数器，覆写size()方法

3.  链表空集合判断isEmpty():    
在link接口中增加判断方法，link子类中覆写isEmpty方法

4.  数组集合的返回toArray():
在link接口中增加toArray方法。在接口子类Node中对数据进行递归查找

5.  获取索引指定数据get():  
利用递归的形式来完成，在接口子类Node中对数据进行递归查找

6.  修改指定索引的数据set(int index,E data)：     
在获取数据的方法上进行修改

7.  判断自定数据是否存在contains(E data):   
使用equals进行判断，在子类Node中依次判断,由于当前默认的链表没有空数据，实际开发中应该让被判断的数据在equals前面

8.  数据删除remove(E data):     
通过修改next实现的
    1.  要删除的是根节点数据，由LinkImpl负责
    2.  要删除的不是根节点数据，由Node负责

9.  清空处理clean():    
将root根节点清空，foot清零，个数也要清零

```
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
        public Node(E data) {
            this.data = data;
        }
        // 通过递归，保存新的node节点
        public void addNode(Node newNode) {
            // 当前节点的下一个节点为空，意味着可以插入新节点
            if (this.next == null) {
                this.next=newNode;
            } else {
                this.next.addNode(newNode);
            }
        }
        //第一次调用：this = linkImpl.root第二次调用：this=linkImpl.root.next第三次调用：this=linkImpl.root.next.next。。。
        public void toArrayNode(){
            LinkImpl.this.returnData[LinkImpl.this.foot++]=this.data;
            if(this.next!=null){//还有下一个数据
                this.next.toArrayNode();
            }
        }
        public E getNode(int index){
            if(LinkImpl.this.foot++ == index){//判断索引是否相同，并进行foot++
                return data;
            }else{
                return this.next.getNode(index);
            }
        }
        public Boolean setNode(int index,E data){
            if(LinkImpl.this.foot++ == index){//判断索引是否相同，并进行foot++
                this.data=data;
                return true;
            }else{
                return this.next.setNode(index,data);
            }
        }
        public int containsNode(E data){
            LinkImpl.this.foot++;
            if(this.data.equals(data)){
                return LinkImpl.this.foot-1;
            }else {
                if(this.next==null){
                    return -1;
                }else{
                    return this.next.containsNode(data);
                }
            }
        }

        public Boolean removeNode(Node previous,E data){
            if(this.data.equals(data)){
                previous.next=this.next;
                LinkImpl.this.count--;
                return true;
            }else{
                if(this.next!=null){
                    return this.next.removeNode(this, data);
                }else{
                    return false;
                }
            }
        }
    }
//------------------link类中定义的成员------------------
    //添加数据、获取数据
    private int count=0;//保存数据个数
    private Node root;//保存根元素
    private int foot=0;//追加脚标
    private Object[] returnData;//返回数据的保存
    @Override
    public Boolean add(E e) {
        if (e == null) {
            return false;
        }
        Node newnode = new Node(e);
        if (this.root == null) {
            this.root = newnode;
        } else {
            root.addNode(newnode);
        }
        count++;
        return true;
    }
    public int size(){
        return this.count;
    }
    public Boolean isEmpty(){
        return this.count==0;
    }
    public Object[] toArray() {
        // TODO Auto-generated method stub
        if(this.isEmpty()){
            return null;
        }
        this.foot=0;//脚标清零
        this.returnData=new Object[this.count];//根据已有的长度开辟一个数组
        this.root.toArrayNode();
        return this.returnData;
    }
    public E get(int index){
        if(index>=this.count){//索引范围
            return null;
        }
        this.foot=0;//重置索引下标从0开始递归查找
        return this.root.getNode(index);
    }

    public Boolean set(int index,E data){
        if(index>=this.count){//索引范围
            return false;
        }
        this.foot=0;
        return this.root.setNode(index,data);
    };

    public int contains(E data){
        this.foot=0;
        return this.root.containsNode(data);
    }

    @Override
    public Boolean remove(E data) {

        if(this.contains(data)>=0){
            if(this.root.data.equals(data)){
                this.root=this.root.next;//根节点的下一个节点
                this.count--;
                return true;
            }else{
               return this.root.next.removeNode(this.root,data);
            }   
        }else{
            return false;
        }
    }

    public Boolean clean() {
        this.root=null;
        this.foot= 0;
        this.count= 0;
        return null;
    }
}

public class LinkDemo {
    public static void main(String[] args) {
        ILink<String> all=new LinkImpl<String>();
        all.add("hello");
        all.add("world");
        all.add("moneygc");
        all.add("www");
        all.add("com");
        all.remove("com");
        all.clean();
        System.out.println(all.size());
    }
}
```
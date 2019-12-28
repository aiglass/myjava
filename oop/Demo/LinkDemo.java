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
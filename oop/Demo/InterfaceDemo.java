/**
 * InnerInterfaceDemo
 */
interface iMessage {
    public static final String Info="信息";
    public abstract String getInfo();
}
class Message implements iMessage{
    public String getInfo(){
        return "我是message";
    }
}
/**
 * Interface
 */
public class InterfaceDemo{
    public static void main(String[] args) {
        Message msg=new Message();
        System.out.println(msg.getInfo());
    }
}
import java.lang.Thread;

class MyThread extends Thread {// 线程的主体类
    private String title;

    public MyThread(String title) {
        this.title = title;
    }
    @Override
    public void run() {
            System.out.println(this.title+"----");
    }
}

class Runnab implements Runnable{
    private String title;
    public Runnab(String title){
        this.title=title;
    }
    @Override
    public void run() {
        System.out.println(this.title+"----");
    }

}

public class ThreadDemo {
    public static void main(String[] args) {
       MyThread a= new MyThread("线程d:");    
       Thread b=new Thread(new Runnab("title"));
       b.start();
       for (int i = 0; i < 10; i++) {
           String title="线程对象"+i;
           Runnable run=()->{
               for(int y=0;y<10;y++){
                   System.out.println(title+"运行，y="+y);
               }
           };
           new Thread(()->{
            for(int y=0;y<10;y++){
                System.out.println(title+"运行，y="+y);
            }
        }).start();
       }
    }
}
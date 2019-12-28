import java.text.BreakIterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class Ticket implements Callable {
    private String name;
    private int ticket = 10;

    public Ticket(String name) {
        this.name = name;
    }

    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 100; i++) {
            if (this.ticket == 0)
                break;
            System.out.println("*****线程执行、x=" + i);
            ticket--;
        }
        return "线程执行完毕";
    }
}

public class TicketsDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> ft=new FutureTask<String>(new Ticket("大麦网"));
        new Thread(ft).start();
        System.out.println(ft.get());
        new Thread(ft).start();
        System.out.println(ft.get());
        new Thread(ft).start();
        new Thread(ft).start();
    }
}
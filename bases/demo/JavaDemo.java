public class JavaDemo { 
    public int aMethod() {
            int i=0;
           i++;
           return i;
    }
    public static void main(String args[]) {
           Test test = new JavaDemo();
           test.aMethod();
           int j = test.aMethod();
           System.out.println(j);
    }
}
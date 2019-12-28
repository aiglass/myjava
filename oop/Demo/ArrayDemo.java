/**
 * ArrUtil
 *
 */
class ArrUtil{
    //普通排序
    public static int[] arrSort(int data[]) {
        int temp;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length-i-1; j++) {
                if(data[j]>data[j+1]){
                    temp=data[j];
                    data[j]=data[j+1];
                    data[j+1]=temp;
                }
            }
        }
        return data;
    }
    //快速排序
    public static int[] quickSort(int data[]) {
        return data;
    }
    //数组转置
    public static int[] reverse(int data[]) {
        //双指针法
        int temp=0;
        int center=data.length/2;
        int head=0;
        int tail=data.length-1;
        for (int i = 0; i <=center; i++) {
            temp=data[head];
            data[head]=data[tail];
            data[tail]=temp;
            head++;
            tail--;
        }
        return data;
    }

    public static void arrPrint(int data[]) {
        System.out.println("\n");
        for (int i : data) {
            System.out.print(i+",");
        }
        System.out.println("\n");
    }

}

/**
 * ArrayDemo
 */
public class ArrayDemo {
    public static void main(final String[] args) {
        int data[] = new int[] { 1, 4, 3, 6, 8, 9,11,23,2,32,4 };
        ArrUtil.arrSort(data);
        ArrUtil.arrPrint(data);
        ArrUtil.reverse(data);
        ArrUtil.arrPrint(data);
    }
    
}
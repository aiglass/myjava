class A <T>{
    private T letter;
    public A(T letter){this.letter=letter;}
    /**
     * @param letter the letter to set
     */
    public void setLetter(T letter) {this.letter = letter;}
    public T say(){return this.letter;}    
}
public class genericDemo {
    public static void main(String[] args) {
        A<Integer> a=new A<>(1);
        find(a);
    }
    public static void find(A<?> lettr){System.out.println(lettr.say());}}
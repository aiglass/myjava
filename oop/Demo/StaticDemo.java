class Chinese{
    private static String county="中华民国";
    private String name;
    public Chinese(){
    }
    public Chinese(String name){
        this.name=name;
    }
    public static void setCounty(String county) {
        Chinese.county = county;
    }
    public String getInfo() {
        return "国籍："+Chinese.county+"，姓名"+this.name;
    }
}
public class StaticDemo{
    public static void main(String[] args) {
        Chinese chi=new Chinese("李四");
        Chinese.setCounty("中华人民共和国");
        System.out.println(chi.getInfo());
    }
}
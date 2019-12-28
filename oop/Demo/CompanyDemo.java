interface IClassName {
    public abstract String getClassName();
}
class Company implements IClassName {
    public String getClassName(){
        return "Company";
    }
}
public class CompanyDemo {
    public static void main(String[] args) {
        IClassName ica=new Company();
        System.out.println(ica.getClassName());
    }
}
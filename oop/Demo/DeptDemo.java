class Dept{//类名称可以明确描述处某类事物
    private long deptno;
    private String dname;
    private String loc;
    public Dept(){//必须提供无参构造
    }
    public Dept(long deptno,String dname,String loc){
        this.deptno=deptno;
        this.dname=dname;
        this.loc=loc;
    }
    /**
     * @param deptno the deptno to set
     */
    public void setDeptno(long deptno) {
        this.deptno = deptno;
    }
    /**
     * @return the deptno
     */
    public long getDeptno() {
        return deptno;
    }
    /**
     * @param dname the dname to set
     */
    public void setDname(String dname) {
        this.dname = dname;
    }
    /**
     * @return the dname
     */
    public String getDname() {
        return dname;
    }
    /**
     * @param loc the loc to set
     */
    public void setLoc(String loc) {
        this.loc = loc;
    }
    /**
     * @return the loc
     */
    public String getLoc() {
        return loc;
    }
    public String getInfo() {
        return
        "【部门信息】\n部门编号："+this.deptno+
        "\n部门名称："+this.dname+
        "\n部门位置："+this.loc;
    }
}

public class DeptDemo{
    public static void main(String[] args) {
        Dept dept=new Dept();
        System.out.println(dept.getInfo());
    }
}
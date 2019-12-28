### 内建函数式接口
jdk1.8中提供有Lamda的表达式，也提供方法的引用。  
开发者自己开发函数式接口需要用@FunctionalInterface注释进行大量的注释。  
在一个java.util.function提供了大量的函数式接口供使用

**如果系统内置了可供我们使用的函数式接口，那么我们就没有必要自定义了。**

-   功能型函数式接口 Function
-   消费型函数式接口 Consumer
-   供给型函数式接口 Supplier
-   断言型函数式接口 Predicate
```
//功能型函数式接口
@FunctionalInterface
public interface Function<T,R>{
    R apply(T t);
}
//实际使用
import java.util.function.*;
public class LamdaDemo {
    public static void main(String[] args) {
        Function<String,Boolean> fun="**hello"::startsWith;
        System.out.println(fun.apply("**"));
    }
}
```

```
//消费型
@FunctionalInterface
public interface Consumer<T>{void accept(T t);}
import java.util.function.*;
public class LamdaDemo {
    public static void main(String[] args) {
        Consumer<String> con=System.out::println;
        con.accept("t");
    }
}
```
```
//供给型
@FunctionalInterface
public interface Supplier<T>{T get();}
//实际使用
import java.util.function.*;
public class LamdaDemo {
    public static void main(String[] args) {
        Supplier<char[]> sup="www.moneygc.com"::toCharArray;
        for (Character str : sup.get()) {
            System.out.println(str);
        }
    }
}
```

```
//断言型
@FunctionalInterface
public interface Predicate<T>{boolean test(T t);}
//实际使用
import java.util.function.*;
public class LamdaDemo {
    public static void main(String[] args) {
       Predicate<String> pre="moneygc"::equalsIgnoreCase;
       System.out.println(pre.test("MONEYGC"));
    }
}
```
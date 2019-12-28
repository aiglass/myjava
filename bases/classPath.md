### CLASSPATH
用以解决在不同文件目录下执行某个类文件

#### CLASSPATH配置
- 定义CLASSPATH环境属性
    - 配置以后，java程序解释时会自动通过CLASSPATH所设置的路径进行类的加载
    - JVM解释程序时需要CLASSPATH支持
    - 默认设置为当前所在目录的加载类文件CLASSPATH=.
    - 在一些时候安装java相关软件时CLASSPATH会被修改
    - 命令配置的CLASSPATH为临时变量。全局变量需要到操作系统中进行额外配置
    - PATH：操作系统提供的路径配置，定义所有可执行程序的路径
    - CLASSPATH：JRE提供的，用于定义java程序解释时类加载路径。
        - JVM->CLASSPATH->*.class字节码文件
    ```
    //修改路径
    SET CLASSPATH=d:\myjava\java
    //设置为当前路径
    SET CLASSPATH=.
    ```

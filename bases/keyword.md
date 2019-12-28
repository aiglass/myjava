### 标识符与关键字
程序实际上都是由一些结构的整合体。这些结构例如：类、方法、变量结构等。对于不同的结构一定要有不同的说明。
#### 标识符
标识符用于对结构进行命名，用来标识类名，变量名，方法名，数组名，变量常量，文件名的有效字符序列。
1.  标识符由字母、数字、 “_”、 “$”组成，且首字母不能是数字；
2.  不能把Java关键字作为标识符；
3.  标识符没有长度限制；
4.  标识符对大小写敏感。
#### 关键字/保留字
关键字是对系统的一些结构的描述处理，有着特殊含义。
+   jdk1.4出现的assert关键字用于异常处理
+   jdk1.5出现的enum关键字用于枚举
+   未使用到的关键字goto、const
+   严格来讲一些有意义的词不算关键字true、false、null
![关键字](https://i.loli.net/2019/05/25/5ce9436670e5920227.png)

abstract|assert|boolean|break|byte
--|:--:|:--:|:--:|--
case|catch|char|class|continue
default|do|double|else|enum
extends|final|finally|float|for
if|implements|import|instanceof|int
interface|long|native|new|package
private|protected|public|return|strictfp
short|static|super|switch|synchronized
this|throw|throws|transient|try
void|volatile|while|**goto**|**const**
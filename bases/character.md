### 字符型数据
字符型变量用单引号，引号中只能用1个字
>char a='B';

在常见编程语言中，字符都可以与int互相转换,字符中所描述的内容可以通过int获取系统中对应的系统编码。
```
char a='B';
print (int) a;//将输出66
```
常用系统编码
-   大写字母范围：A（65）～Z （90）
-   小写字母范围：a（97）～z (122)
-   数字字符范围：‘0’（48）～‘9’（57）
-   大小写字母转换：大写字符+32=小写字符
-   可以用char保存中文字符，是因为java使用的unicode字符编码
```
char a='中';
```
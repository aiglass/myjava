### String类的常用方法
项目开发中String类一定会经常用到，必须掌握了解系统提供的string类相关的方法
#### javaDoc简介
javaDoc是java的api文档。
-   [地址](https://docs.oracle.com/javase/9/docs/api/overview-summary.html)
-   jdk1.9之前，所有java中的常用类库都会在JVM启动的时候进行全部的加载，影响程序的性能
-   jdk1.9之后，开始提供模块的设计，将一些程序类放在了不同的模块中

文档组成
-   类的完整定义
-   类的相关说明
-   类的成员属性摘要
-   构造方法的摘要，看见deprecated就不要在用了
-   方法摘要：左边为返回值，右边为方法名称和说明
> 文档会存在一些“假”的中文翻译版，最好不要用，要学会看英文文档
#### 字符串与字符数组
-   charAt():获取数组中指定索引位置的字符，索引都是从0开始的
-   toCharArray():字符串变为字符数组
-   String​(char[] value)字符数组转字符串
-   String​(char[] value, int offset, int count)从字符数组指定位置开始转字符串

#### 字符串与字节数组
主要目的是为了数据传输
-   String​(byte[] bytes)字节数组变为字符串
-   String​(byte[] bytes，int offset,int count)字节数组的部分转换为字符串
-   getBytes​(String charsetName) 字符串转为字节数组
-   public byte[] getBytes​(String charsetName) throws UnsupportedEncodingException编码转换

#### 字符串比较
-   equals​(Object anObject)比较内容，大小写区分
-   equalsIgnoreCase​(String anotherString)忽略大小写的比较
-   int **compareTo**​(String anotherString)进行大小比较，返回差值
-   int compareTo​IgnoreCase(String anotherString)忽略大小写的比较，返回差值

#### 字符串查找
字符串中子字符串的查找
-   boolean	contains​(CharSequence s)判断子字符串是否包含jkk1.5开始支持
-   indexOf(String str)从头查找指定字符串的位置，jdk1.5之前使用该程序判断字符串是否存在
-   indexOf(String str,int fromIndex)从指定位置开始查找在字符串中的位置
-   lastIndexOf(String str)由后向前查找字符串所在的位置
-   lastIndexOf(String str，int fromIndex)从指定位置，由后向前查找字符串所在的位置
-   startsWith(String prefix)判断是否以指定的字符串开头
-   startsWith(String prefix,int toffset)从指定位置判断是否由指定的字符串开头
-   endsWith()是否由自定字符串结尾
#### 字符串替换
通过指定的内容对字符串进行替换
-   replaceAll​(String regex, String replacement)全部替换，涉及正则
-   replaceFirst​(String regex, String replacement)替换首个，涉及正则
#### 字符串拆分
对字符串进行拆分
-   split​(String regex)按照规则全部拆分
-   split​(String regex, int limit)按照指定的规则拆分为指定份数，后面的不拆了
-   拆不开先加\\进行转义处理
#### 字符串截取
从字符串中截取子字符串，实际开发中往往先通过indexof、lastIndexof获取位置后再使用截取
-   substring​(int beginIndex)从指定位置开始截取
-   substring​(int beginIndex, int endIndex)从指定区间截取
#### 字符串格式化
-   static format​(String format, Object... args)利用占位符(%s\%d\%c)按给定的格式对字符串进行输出。jdk1.5引入
```
  string.format("%s %s %s %s", "a", "b", "c", "d")
  //->" a b c d
```
#### 其他方法
-   concat(String str)对字符进行连接
-   intern()对字符串进行入池
-   isEmpty()判断字符串是否为空
-   length()长度获取
-   trim()去除左右的空格
-   toUpperCase()转大写，避免非字母的转换
-   toLowerCase()转小写，避免非字母的转换

思考？String类缺少首字母大写的方法，如何自己实现
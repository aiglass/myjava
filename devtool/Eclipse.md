### Eclipse 
[官网https://www.eclipse.org/](https://www.eclipse.org/)

翻译为中文“日蚀”（遮盖一切的光芒），这个是由IBM公司对Sun公司发起的挑战。在整个java领域上，真正使用java获利的只有IBM。Sun公司开发了java，但没有获得多大的收益。公元2000年世界开始了开源风，指的是技术开源，而不是项目开源。IBM将Eclipse转送给Eclipse的组织。

Eclipse的前身IBM推出的一个VisualAge开发工具，后来推出了Eclipse之后可以很好的进行java的开发。开源之前使用最广泛的java工具就是Borland JBuilder（极其难用）。Borland的2006年破产。sum公司在2003年推出自己的开发工具NetBeans。

2000年处的时候，企业开发主要是办公系统，开发过程中往往会使用两套技术组合：
-   解释过程：开发工具+操作系统+中间件+数据库；
-   皇家正规军（IBM）:WSAD+AIX+WAS+DB2,这套设计绝对稳定。
-   正规杂牌军（厂商合奏）:JBuilder+Linux+BEAWebLogic+Oracle;
-   开源风潮：Eclupse+Linux+Tomac+MySQL;

#### eclipse
本身支持：JDT、Junit、CVS客户端、插件开发等，Eclipse EE版本还支持各种javaee开发
#### JDT
在Eclipse之中提供呀JDT环境可以实现java程序的开发
1.  如果要进行项目的开发，首先创建一个新的项目

快捷键
-   CRTRL+1:进行代码纠错提示
-   ALT+/：进行代码提示
-   CTRL+SHIFT+下键：复制当前行
-   CTRL+/：单行注释
-   CTRL+SHIFT+/：多行注释
-   CTRL+SHIFT+F：格式化代码
-   CTRL+SHIFT+O：自动导入需要的包
#### 调试
-   F5单步跳入：进入到代码之中进行程序执行的观察
-   F6单步跳过：只关心最终的结果而并不关系里面到底执行了什么
-   F7单步返回：进入之后如果后续不再观察了，直接返回
-   F8恢复执行：取消断点影响继续执行
# ssh授权
## 添加ssh授权
 ssh-keygen 命令按几次回车生成公私钥，公私钥存放在主目录下的隐藏目录 .ssh 中的两个文件中：

使用 SSH 的好处主要有两点：
* 免密码推送，执行 git push 时不再需要输入用户名和密码了；
* 提高数据传输速度。
## git命令设置别名
>git config --global alias.[别名] [原命令]
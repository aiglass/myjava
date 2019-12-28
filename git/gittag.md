# git tag 标签
```
# 进入到gitproject目录
$ cd /home/shiyanlou/gitproject

# 查看git提交记录
$ git log

# 选择其中一个记录标志位stable-1的标签，注意需要将后面的8c315325替换成仓库下的真实提交内，commit的名称很长，通常我们只需要写前面8位即可
$ git tag stable-1 8c315325

# 查看当前所有tag
$ git tag
stable-1
```
标签对象
git tag 中使用-a ，-s ，-u 三个参数中任意一个，都会创建一个标签对象并且需要一个标签消息tag message来为tag添加注释。如果没有-m或是-F这些参数，命令执行时会启动一个编辑器来让用户输入标签消息。

当这样的一条命令执行后，一个新的对象被添加到 Git 对象库中，并且标签引用就指向了一个标签对象，而不是指向一个提交，这就是与轻量级标签的区别。
```
$ git tag -a stable-2 8c315325 -m "stable 2"
$ git tag
stable-1
stable-2
```
签名标签可以让提交和标签更加完整可信。如果你配有GPG key，那么你就很容易创建签名的标签。首先你要在你的 .git/config 或 ~/.gitconfig 里配好key。

```
//在配置文件中创建gpg key
git config （--global） user.signingkey <gpg-key-id>
//使用-s参数可创建“签名的标签”
git tag -s stable-1 commit的前八位
//如果没有在配置文件中配 GPG key，你可以用 -u 参数直接指定。
git tag -u <gpg-key-id> stable-1 1b2e1d63ff
```
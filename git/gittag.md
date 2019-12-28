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
## 签出版本
其实签出版本就是指定某个提交版本创建一个新的分支
```
//切换到之前的某个提交版本，
git checkout [标签名] 
//将此提交版本固定到一个新分支上并切换到此分支
git checkout -b [新的分支名] 
```
## releases
GitHub 的 releases 是 2013 年发布的新功能，旨在协助软件开发者分发新版本给用户
release 基于 tag，为 tag 添加更丰富的信息，一般是编译好的文件。
## 常用命令
```
git show [标签名] 
git push origin [标签名] 推送标签到远程仓库
git push origin :refs/tags/[标签名] 删除远程仓库的标签
```
当我们执行 git add [标签名] 创建本地标签后，在仓库主目录的 .git/refs/tags 目录下就会生成一个标签文件：
```
git tad -d V1.0
```
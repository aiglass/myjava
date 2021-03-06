# git修复操作
## 修复未提交文件中的错误（重复）
----------
### 让工作目录回到上一次提交时的状态（last committed state）：
```
git reset --hard HEAD^
//该命令会将目录中所有的未提交内容清空（不包括untracked files）,此时git diff 和git diff --cached命令将显示为空
```
只是要恢复一个文件，如heool.rb,使用git checkout:
```
git checkout --hello.rb
```
## 修复已提交文件中的错误
如果你已经做了一个 提交（commit），但是你马上后悔了，这里有两种截然不同的方法去处理这个问题。

创建一个 新的提交（commit），在新的提交里撤消老的提交所作的修改。这种作法在你已经把代码发布的情况下十分正确.

你也可以去修改你的 老提交（old commit）。但是如果你已经把代码发布了，那么千万别这么做，git 不会处理项目历史会改变的情况，如果一个分支的历史被改变了那以后就不能正常的合并。

## 创建新提交来修复错误
创建一个新的，撤销（revert）了前期修改的提交（commit）是很容易的。只要把出错的提交（commit）的名字（reference）做为参数传给命令git revert就可以了，下面这条命令就演示了如何撤销最近的一个提交：
```
git revert HEAD
```
下面这条命令就是撤销上上次（next-to-last）的提交
```
git revert HEAD^
```
在这种情况下，Git 尝试去撤销老的提交，然后留下完整的老提交前的版本.　如果你最近的修改和要撤销的修改有 重叠（overlap），那么就会被要求手工解决 冲突（conflicts），就像解决 合并（merge）时出现的冲突一样。

译者注：git revert 其实不会直接创建一个 提交（commit），只会把撤销后的文件内容放到 索引（index）里，你需要再执行 git commit 命令，它们才会成为真正的提交（commit）。
## 修改提交来修复错误
如果你刚刚做了某个提交（commit）， 但是你又想马上修改这个提交，git commit 现在支持一个叫--amend 的参数，它能让你修改刚才的这个提交（HEAD commit）。这项机制能让你在代码发布前，添加一些新的文件或是修改你的提交 注释（commit message）。

如果你在 老提交（older commit）里发现一个错误，但是现在还没有发布到代码服务器上，你可以使用 git rebase 命令的交互模式，git rebase -i 会提示你在编辑中做相关的修改。这样其实就是让你在 rebase 的过程来修改提交。
# 维护git
------
## 保证良好的性能
大的仓库中，git靠压缩历史信息来节约磁盘和内存空间,压缩不是自动进行的需要手动执行git gc
```
git gc
```
## 保持可靠性
git fsck 运行一些仓库的一致性检查，如果有任何问题就会报告。这项操作也有点耗时，通常报的警告就是  ``悬空对象（dangling objects）`` 
```
git fsck
```
悬空对象（dangling objects）并不是问题，最坏的情况它们只是多占了一些磁盘空间，但有时候它们是找回丢失的工作的最后一丝希望.

## 常用命令

```
//--soft 表示软退回，--hard 硬退回
 git reset --soft HEAD^ 
 git reset --hard [版本号] 
 git reset --hard{2}
```
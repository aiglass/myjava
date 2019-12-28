# git高级应用
项目中会存在不需要git进行追踪（track）的文件。如临时文件、备份文件、拓展文件等等。

在项目顶级目录中创建.gitignore文件,下列是常见的一下语法，实际是正则。注释使用的是#号
```
//忽略指定文件如foo.txt
foo.txt
//忽略掉所有的html
*.html
//不能忽略,用！号
！foo.html
//忽略所有的.o和.a文件
*.[oa]
```
### rebase变基
如果远端origin分支上做了一些修改并且做了提交，而你又修改了本地分支，意味着origin和mywork分支各自进行前进了，形成了分叉。

此时你可以使用pull命令拉取origin与mywork进行合并，但这样会出现一个 ___合并提交(merge commit)___

实际开发中想要本地的mywork分支历史看起来未经过合并，就需要用到rebase。
## git rebase 变基 
git rebase命令会把mywork分支中的所以commit取消掉，并临时保存未补丁patch（补丁放在.git/rebase目录中）,然后把mywork分支更新到最新的origin分支，最后把保存的这些补丁应用到mywork分支上。

当mywork分支更新后，会再指向新创建的commit，而老的commit将会被丢弃。如果运行垃圾收集命令（pruning garbage collection），这些被丢弃的提交就会删除
## rebase 冲突解决
在rebase过程中，也许会出现冲突（conflict）。此时git会停止rebase并会让你解决冲突；在解决冲突后，用git-add命令去更新这些内容的索引（index），然后，你无需执行git-commit，只要执行：git rebase --continue。git会继续应用（apply）余下的补丁。
## rebase 操作的回滚
在任何时候，你可以用--abort参数来终止rebase的行动，并且mywork分支会回到rebase开始前的状态
## 交互式rebase
提交到远端之前。交互式rebase在和别人分享提交之前对你的提交进行分割线、合并或者重新排序。也可以在拉取代码到本地时，用交互式rebase进行清理。

在rebase过程中对一部分提交进行修改，用git rebase 命令中加入-i 或 --interactive参数进行调用交互模式
```
//执行交互式rebase，操作对象是最后一次从origin仓库拉取或者向origin推送之后的所以提交
git rebase -i origin/master

```


```
//创建一个基于origin的mywork分支，并切换到mywork分支
git checkout -b mywork origin
```
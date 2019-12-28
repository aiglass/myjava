# git日志log
### gitlog 常用命令
```
//查看日志
git log
//查看某目录下的某个文件从某版本之后的修改日志
git log v2.5.。 makefile fs/
```
### 日志统计
```
//显示被修改的文件添加或删除了多少行内容
git log --stat 
//在一行中显示日志
git log --pretty=oneline
//short格式显示
git log --pretty=short// 还有medium，full,fuller,email,raw，format等参数
//显示提交图
git log --graph
//format 格式化输出，--topo-order拓扑顺序（子提交在父提交前展示）
git log --pretty=format:'%h : %s' --topo-order --graph
//--reverse 逆序展示提交日志
git log --reverse

```

## 常用命令
* git log [分支名] 查看某分支的提交历史，不写分支名查看当前所在分支
* git log --oneline 一行显示提交历史
* git log -n 其中 n 是数字，查看最近 n 个提交
* git log --author [贡献者名字] 查看指定贡献者的提交记录
* git log --graph 图示法显示提交历史
* git reflog 命令，它会记录本地仓库所有分支的每一次版本变化

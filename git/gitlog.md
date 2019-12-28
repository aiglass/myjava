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
# 编辑器定制
```
$git config --global core.editor emacs
```
## 添加别名
```
$ git config --global alias.last 'cat-file commit HEAD'

$ git last
tree c85fbd1996b8e7e5eda1288b56042c0cdb91836b
parent cdc9a0a28173b6ba4aca00eb34f5aabb39980735
author Scott Chacon <schacon@gmail.com> 1220473867 -0700
committer Scott Chacon <schacon@gmail.com> 1220473867 -0700

fixed a weird formatting problem

$ git cat-file commit HEAD
tree c85fbd1996b8e7e5eda1288b56042c0cdb91836b
parent cdc9a0a28173b6ba4aca00eb34f5aabb39980735
author Scott Chacon <schacon@gmail.com> 1220473867 -0700
committer Scott Chacon <schacon@gmail.com> 1220473867 -0700

fixed a weird formatting problem
```
## 添加颜色
```
$ git config color.branch auto
$ git config color.diff auto
$ git config color.interactive auto
$ git config color.status auto
```
可以通过color.ui选项把颜色全部打开
```
$ git config color.ui true
```
## 提交模版
```
git config commit.template '/etc/git-commit-template'
```
## 日志格式
```
$ git config format.pretty oneline
```
## 其他配置选项
参考[git config](https://mirrors.edge.kernel.org/pub/software/scm/git/docs/git-config.html)
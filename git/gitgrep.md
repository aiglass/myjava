# git grep
```
//查看仓库里每个使用xmmap函数的地方
git grep xmmap
//-n显示行号
git grep -n xmmap
//只显示文件名--name-only
git grep --name-only xmmap
//-c查看每个文件中有多少行 匹配内容 （line matches）:
git grep -c xmmap
//从某个特定版本里查找内容，可以在命令行末尾加上标签名
git grep xmmap v1.5.0
// 组合搜索条件，例如查找仓库中定义SORT_DIRENT的地方
git grep -e '#define' --and -e SORT_DIRENT 
// 可以进行both条件搜素操作，也可以进行或either条件搜索操作：
git grep --all-match -e '#define' -e SORT_DIRENT
//也可以查找处复合一个条件（term）且复合两个条件*（terms）之一的文件行，例如我们可以找出名字中含义PATH或是MAX的常量定义：
git grep -e '#define' --and \(-e PATH -e MAX)
```
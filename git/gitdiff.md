# git diff
比较文件修改
```
//查看缓存区中的修改
git diff --cached

```
比较分支差异
```
//比较两个分支
git diff master test
//比较当前分支与另一个分支的差别（例如：当前为master）
git diff test
//比较指定文件或者目录
git diff test file1
//用stat参数统计文件改动
git diff test --stat
```
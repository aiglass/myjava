# 追踪分支
追踪分支是用于联系本地分支和远程分支的。

在追踪分支（Tracking Branches）上执行 __推送（push）__ 或 __拉取（pull）__ ，都会自动的推送或拉取到关联的远程分支上。

如果需要**经常从远程仓库拉取分支到本地**，并且不想很麻烦的使用git pull这种格式，那么就应该使用 ___追踪分支（Tracking Branches）___

git clone命令会自动在本地建立一个master分支，他是origin/master的追踪分支。而origin/master就是被克隆仓库的master分支。

使用git branch命令加上--track参数，将手动创建追踪分支
```
git branch --track experimental origin/experimental
```
>前提是远端仓库也有一个experimental分支

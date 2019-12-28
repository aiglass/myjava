# gitflow 工作流
```
//克隆本地仓库
git clone /本地仓库地址 myrepo新目录名
//想将myrepo的修改合并到源本地仓库
cd /本地仓库
git pull /目录/myrepo master

//定义远程分支缩写
git remote add myrepo /目录/myrepo
```
pull命令等同于执行了两个操作：先git fetch从远端分支抓取最新的分支修改信息，再用git merge把修改合并进当前的分支。

remote远端仓库的相关命令
```
//获取远端仓库地址
git config --get remote.origin.url
//通过ssh协议从指定主机clone
git clone host:/仓库地址    新目录名
git clone ssh://服务器/账号/仓库名称
```
推送
```
git push ssh://服务器仓库地址 master:master
$ git push ssh://服务器仓库地址 master
```
如果push结果不是fast forward快速向前，可能会报错.这种情况通常是因为没有使用 git pull 获取远端仓库的最新更新，在本地修改的同时，远端仓库已经变化了（其他协作者提交了代码），此时应该先使用 git pull 合并最新的修改后再执行 git push：
```
//报错示例
error: remote 'refs/heads/master' is not an ancestor of
local  'refs/heads/master'.
Maybe you are not up-to-date and need to pull first?
error: failed to push to 'ssh://yourserver.com/~you/proj.git'
```

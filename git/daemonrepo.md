# 建立一个公共仓库
## 1.建立一个公共仓库
假设你个人的仓库在目录 ~/proj，我们先克隆一个新的“裸仓库“，并且创建一个标志文件告诉 git-daemon 这是个公共仓库：
```
git clone --bare ~/proj proj.git
touch proj.git/git-daemon-export-ok
```
上面的命令创建了一个 proj.git 目录， 这个目录里有一个 裸 git 仓库 —— 即只有 .git 目录里的内容，没有任何签出（checkout）的文件。

下一步就是你把这个 proj.git 目录拷到你打算用来托管公共仓库的主机上，你可以用 scp， rsync 或其它任何方式。
## 2.通过git协议导出git仓库
上面的命令创建了一个 proj.git 目录， 这个目录里有一个 裸 git 仓库 —— 即只有 .git 目录里的内容，没有任何签出（checkout）的文件。

下一步就是你把这个 proj.git 目录拷到你打算用来托管公共仓库的主机上，你可以用 scp， rsync 或其它任何方式。
## 3.通过 http 协议导出 git 仓库
Git 协议有不错的性能和可靠性，但是如果主机上已经配好了一台 web 服务器，使用 http 协议（git over http）可能会更容易配置一些。

你需要把新建的 裸仓库 放到 Web 服务器 的 可访问目录 里， 同时做一些调整，以便让 web 客户端获得它们所需的额外信息：
```
$ mv proj.git /var/www/html/proj.git
$ cd proj.git
$ git --bare update-server-info
$ chmod a+x hooks/post-update
```
克隆的时候可以使用下面的命令进行克隆：
```
$ git clone http://服务器地址/proj.git
```
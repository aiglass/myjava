# 建立私有仓库
## 通过ssh协议来访问仓库
ssh协议访问git通常是最简单的办法。

如果你在一台机器上有了一个 ssh 帐号， 你只要把 git 祼仓库 放到任何一个可以通过 ssh 访问的目录，然后可以像 ssh 登录一样简单的使用它。假设你现在有一个仓库，并且你要把它建成可以在网上可访问的私有仓库，你可以用下面的命令，导出一个 祼仓库，然后用 scp 命令把它们拷到你的服务器上：
```
$ git clone --bare /home/user/myrepo/.git /tmp/myrepo.git
$ scp -r /tmp/myrepo.git myserver.com:/opt/git/myrepo.git
```
如果其它人也在 myserver.com 这台服务器上有 ssh 帐号，那么他也可以从这台服务器上克隆（clone）代码：
```
$ git clone myserver.com:/opt/git/myrepo.git
```
上面的命令会提示你输入ssh密码或是使用公钥（public key）
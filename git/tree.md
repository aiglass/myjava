# git树名
## git树名
treeish树名，表示git对象的名称的方式的名称，为了简化40位长度SHA串。
## Sha短名
如果你的一个提交（commit）的 sha 名字是 980e3ccdaac54a0d4de358f3fe5d718027d96aae， git会把下面的串视为等价的:
```
980e3ccdaac54a0d4de358f3fe5d718027d96aae
980e3ccdaac54a0d4
980e3cc
```
理论上5个字节以上就很难重复，git会把sha短名（partial sha）自动补全
## 分支，remote或标签
可以使用分支，remote 或标签名来代替 SHA 串名，他们都是指向某个对象的指针。
## 日期标识符
git的引用日志（RefLog）可以做一些相对的查询操作.
```
master@{yesterday}
master@{1 month ago}:
```
## 顺序标识符
这种格式用来表达某点前面的第N个提交(ref)
```
master@{5}//master 前面的第5个提交（ref）
```
## 多个父对象
这能告诉你某个提交的第 N 个直接父提交（parent）。这种格式在合并提交（merge commits）时特别有用，这样就可以使提交对象（commit object）有多于一个直接父对象（direct parent）:
```
master^2
```
## 波浪号
波浪号用来标识一个提交对象（commit object）的第N级嫡（祖）父对象（Nthgrandparent），例如：
```
master~2和master^^等价
```
标识符是可以叠加的，一下3个表达式都是指向同一个提交commit
```
master^^^^^^
master~3^~2
master~6
```
## 树对象指针
提交对象commit object是指向一个树对象。你要得到一个提交对象commit object指向的树对象tree object 的sha串名，在‘树‘名的后面加上{tree}来得到：
```
master^{tree}
```
## 二进制标识符
如果你要某个二进制对象（blob）的sha串名，你可以在树名treeish后添加二进制对象blob对应的文件路径来得到它
```
master:/path/to/file
```
## 区间
这能告诉你某个提交的第 N 个直接父提交（parent）。这种格式在合并提交（merge commits）时特别有用，这样就可以使提交对象（commit object）有多于一个直接父对象（direct parent）:
```
7b593b5..51bea1
```
这会包括所有从 7b593b 开始的提交（commit）。译者注：相当于 7b593b..HEAD：
```
7b593b5..
```
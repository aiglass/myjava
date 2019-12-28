# stash储藏
遇到bug时，可以使用git stash储藏当前的工作状态，修复完bug后，执行unstash(反储藏)操作回到之前的状态

## 储藏队列
执行git stash命令，就会将当前修改的储藏（stash）添加到储藏队列(stashes)中.
>查看储藏队列：git stash list

>从队列中调用储藏：git stash apply stash@{1}

>清空stashes：git stash clear
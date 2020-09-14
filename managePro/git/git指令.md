**记录一些git的常用指令**
===
git官方有一本推荐的书 [Pro Git](https://git-scm.com/book/zh/v2)
## 常用的一些指令
|指令名称|指令作用 |
|----|----|
| git init | 以当前的文件夹创建仓库 |
| git add 文件名 | 追踪或者暂存文件 |
| git status | 查看文件状态 |
| git commit -m 信息| 提交更新 |
| git remote -v | 查看远程仓库 |
| git remote add remote_name url_ | 添加远程仓库,并设置别名remote_name,url_远程仓库的url |
| git fetch remote_name | 从远程仓库remote_name拉取更新 |
| git push remote_name branch_name | 推送更新到远程仓库remote_name的branch_name分支 |
| git remote rename old_name new_name | 将远程仓库old_name更新为new_name |
| git remote rm remote_name | 将远程仓库remote_name删除
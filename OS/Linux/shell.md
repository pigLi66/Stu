

通配符：

*0到无穷个任意字符

？单个任意字符

[] 单个括号内的字符，可以通过 - 表示一个闭区间的字符匹配

[^] 取反，在[]不匹配的情况



使用test指令可以测试文件属性，是否存在等，也可以进行数值的判断

所用的终端就是shell



测试shell脚本是否有语法错误， sh [-nvx]

-n  ：不要执行script，仅查询语法的问题；

-v  ：再执行sccript 前，先将scripts 的内容输出到屏幕上；

-x  ：将使用到的script 内容显示到屏幕上，这是很有用的参数！



## 运行shell脚本的方式

### 1、fork一个新进程进行运行

- sh fileName
- bash fileName
- ./fileName     （文件必须具有执行权限，chmod u+x fileName）

### 2、 直接运行，同一个进程下

- source fileName
- . fileName （. 和 fileName 之间具有空格，等同于 source fileName）

##  变量

### 1、变量的定义

`var='value'` 变量直接定义使用即可，注意等号=左右两边不能有空格

`  readonly var` 可以将一个变量定义为一个只读变量

`  unset`

可以declare定义变量，declare -i  定义整型

使用local 可以定义局部变量

### 2、变量的使用

`$var` $加变量名既可以使用变量，再双引号""里面也可以通过这种方式

``  var=`command` `` 使用命令替换的内容，可以将命令的输出赋给一个变量，

`  var=$(command)` 也可以通过$()的方式将一个命令的输出赋给一个变量，支持嵌套的命令

### 登录shell

登录shell时，会从5个不同的启动文件中读取命令

/etc/profile

$HOME/.bash_profile

$HOME/.bashrc

$HOME/.bash_login

$HOME/.profile

### 文件描述符

Linux最多有9个文件描述符，可以通过lsof 查看已有的文件描述符，-p 标识进程，-n标识文件描述符

0标准输入

1标准输出

2错误输出

可以使用exec 创建，修改，关闭文件描述符，

exec 3>&- 关闭文件描述符3

exec 3>file 创建输出到文件file的文件描述符，两个>（>>）表示追加到文件尾

exec 3>&1 重定向文件描述符


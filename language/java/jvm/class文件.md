
# 好玩的
javap 工具可以用来分析class文件的字节码 <br>
Java中的字面量（变量名，方法名，类名等一系列的）使用两个字节存储长度，超过了不行<br>
属性感觉像是一个key value 的键值对，key 是一个指向常量池的索引，还有一个，value的长度，(key length value)<br>
方法长度不能超过65535<br>

# 名词解释
全限定名：  例子：java.lang.Object 这是Object 的全限定名<br>
简单名称：没有类型和参数修饰的方法或者字段名称 例子：方法  toString<br>
描述符： 描述字段的数据类型、方法参数（包括数量、类型、以及顺序）和返回值<br>

# 一些名词
| 英文 | 中文 | 10进制值 |
| -- | -- | -- |
| constant_pool_count | 常量池容量计数值 |
| CONSTANT_Utf8_info | utf8的字符串 | 1
| CONSTANT_Intger_info | int整型字面量 | 3
| CONSTANT_Float |  | 4
| CONSTANT_Long |  | 5
| CONSTANT_Double |  | 6
| CONSTANT_Class | 类或者接口的符号引用 | 7
| CONSTANT_String | 字符串类型字面量 | 8
| CONSTANT_Fieldref | 字段的符号引用 | 9
| CONSTANT_Methodref | 类中方法的引用 | 10
| CONSTANT_InterfaceMethodref | 接口中方法的符号引用 | 11
| CONSTANT_NameAndType | 字段或方法的部分符号引用 | 12
| CONSTANT_MethodHandle | 方法句柄 | 15
| CONSTANT_MethodType | 标识方法的类型 | 16
| CONSTANT_InvokeDynamic | 动态方法调用点 | 18
| 常 | 量 | 池在上
| access_flags | 访问标志 |
|  |  |
|  |  |
# 文件格式

0XCOFEBABE 魔数  
_ _ 次版本  _ _ 主版本<br>
常量池入口， 是一个集合<br>
访问标志 _ _ 类相关的<br>
类索引 _ _ ， 父类索引 _ _ 接口索引集合（多个类）<br>
字段表集合 (修饰符，名称索引，描述符索引，字段属性集合)<br>
方法表集合（同上）<br>
<br>
属性表集合：code：<br>
类型| 名称 | 解释
--| -- | --
u2 | attribute_name_index | 属性名的索引
u4 | attribute_length | 属性值的长度
u2 | max_stack | 操作数栈深度的最大值（分配栈帧时使用）
u2 | max_locals | 局部变量表需要的空间（单位：Slot）
u4 | code_length | 字节码指令长度
u1 | code | 字节码指令
u2 | exception_table_length |
exception_info | exception_table | tryCatch中的异常表(当在start_pc 到end_pc 之间出现catch_type 的异常（包括子类）时，跳转到handler_pc 执行)
u2 | attribute_count |
attributo_info | attrivutes |
 |  | Exceptions thorws 中的异常表(省略常用两项)
u2 | number_of_exceptions | 几个异常索引
u2 | exception_index_table | 异常索引（指向常量池）
 |  | LineNumberTable 非必须，可以设置不生成，这样无法设置断点（省略常用两项）
u2 | line_number_table_length | 一下两项组成line_number_table
u2 | start_pc | 指令第几行
u2 | line_number | java文件中的第几行
 |  | sourceFile属性（省略两个常用属性）,帮助堆栈定位错误文件
u2 | sourcefile_indx | 常量池文件名的索引
 java的非类方法中总会带有this ，所以locals和args不为零， 有一个this
<br>
<br>
<br>

# 不会看的
Java中非static 属性，使用init 方法进行初始化<br>
sun 的javac中，final static 修饰的基础数据类型和String 使用ConstantValue 属性进行初始化，其他的使用clinit <br>
innerClasses属性（省略常用的两个）
类型| 名称 | 解释
--| -- | --
u2 | number_of_classes | 下面4个属性组成一个 inner_classes_info
u2 | inner_class_info_index | 内部类的一个索引(Constant_Utf8_info)
u2 | outer_class_info_index | 宿主类的一个索引(Constant_Utf8_info)
u2 | inner_name_index | 内部类的名称索引
u2 | inner_class_access_flags | 内部类的访问标识
 |  |
 |  |
 |  |
 |  |
 |  |

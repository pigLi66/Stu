## redis-cli 命令

>  **SET** key value  [NX|XX]   

​		设置一个key，value键值对

​		NX表示如果不存在则设置，返回ok，若存在，则返回nil（空），表示设置失败

​		XX 表示如果存在则设置，返回ok，如不存在，则返回nil（空），表示操作失败

​		时间复杂度：O(1)

> **GET	** key 

​		返回键对应的值，不存在则为nil

​		时间复杂度：O(1)

> **GETSET** key new_value

​		获取键对应值的同时，设置键对应的值，若不存在，返回nill（一样会设置成功）

> **MSET** key value [key value ...]

​		设置同时设置多个key value

​		时间复杂度：O(N)

> **MGET** key [key...]

​		同时获取多个key对应的值

​		时间复杂度：O(N)

> **MSETNX**  key value [key vallue ...]

​		给定的所有键都不存在的情况下，将键值对放入redis中

​		时间复杂度：O(N)

> **STRLEN** key

​		获取key对应值的字节长度 

​		时间复杂度：O(N)

> **GETRANGE** key startIndex endIndex

​		获取key对应值的字符串中从startIndex到endIndex范围的值

​		index与python中的数组下标类似

> **SETRANGE** key index string

​		设置key对应的值，从index开始，替换为string

​		如果key对应的value长度小于index+string.length，将会自动扩展value。

​		如果index > value.length，那么，index-1到value.length将会填充为二进制位的0。

​		key不存在也可以设置

​		返回value执行替换后的字节长度

​		时间复杂度O(N)

> **APPEND** key string

​		将string追加到value的末尾

​		若value不存在，则创建一个空的value，然后追加。效果类似set

​		返回追加字符串后value的字节长度

​		时间复杂度O(N)

> **INCRBY** key increment

​		将value增加increment，value必须是整数数值（可以是负数）

​		若value不存在，则先初始化value=0，再执行操作

​		时间复杂度O(1)

> **DECRBY** key decrement

​		将value减少decrement，value必须是整数数值（可以是负数）

​		若value不存在，则先初始化value=0，再执行操作

​		时间复杂度O(1)

> **INCR** key
>
> **DECR** key

​		将value +（-） 1，value必须是整数

​		若value不存在，则先初始化value=0，再执行操作

​		返回value操作后的数值

​		时间复杂度O(1)

> **INCRBYFLOAT** key increment

​		将value（整数或浮点数）+ increment(可以是负数)

​		执行操作后的浮点数最多保留17位

​		若计算结果为整数，自动转换为整数

​		返回value操作后的数值

​		时间复杂度O(1)



### 散列 操作与前面类似，指令前加H，例如HSET

| 命令                      | 描述                     | 返回值        |
| ------------------------- | ------------------------ | ------------- |
| **HSET** hash field value | 为散列中的指定字段设置值 | 若filed不存在 |
| **HLEN** hash             | 获取散列包含的字段数量   | 散列字段数    |
|                           |                          |               |


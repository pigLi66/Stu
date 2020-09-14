[美团技术博客的hashmap记录](https://www.zhihu.com/search?type=content&q=hashmap)
# HashMap 源码记录

### 安全的map
Collections.synchronizedMap包装一个map，返回一个封装了的map，他是Collections的一个内部类，里面通过锁将所有的map操作封装了
>        public V put(K var1, V var2) {
            synchronized(this.mutex) {
                return this.m.put(var1, var2);
            }
        }


### 有意思的设计
prev和next记录了一个双向链表，当为红黑树时，是一个双向链表
当出现hash冲突时，会使用key的comparable接口方法，没有就不调用
一个元素的hash值，是在刚刚插入的时候确定的，不会重新计算
在判断key值相等之前，会先比较hash，map中元素的hash是刚插入时的值，所以如果将一个key修改后，重新插入（hash值要产生了该表），是不会相等的。

先记录map中元素内部类的构成

HashMap.TreeNode -> LinkedHashMap.Entry -> HashMap.Node -> map.Entry

### put(key, value)
put(key k, value v) 调用 putVal(k.hashCode(), k, v, false, true)

### putVal(key, value, onlyIfAbsent, evict)

onlyIfAbsent 当已经存在key时，是否进行替换，false表示替换

1. 如果没有发生hash冲突，则直接插入
2. 如果新插入的结点的key等于发生冲突的key，直接进行替换
3. 如果hash冲突的结点是treeNode，则执行var7.putTreeVal(this, var6, var1, var2, var3);
4. 遍历链表，如果找到了key值相等的结点，则执行替换。否则新建一个结点包含key，value 插入链表尾
5. 如果插入节点后链表的长度大于等于8，执行treeifyBin(var6, var1);

var10 代表了进行替换的结点，没有进行替换则为null


### treeifyBin(elem, hashCode)
1. elem小于64时直接进行resize 而非重建为红黑树
2. elem[hashcode]不为空，进行重构为树，root = var6
3. 不为空调用var6.treeif，调用树根节点的方法

### treeif(elem)
将链表转换为树

### resize()  扩容方法
新建一个数组newTab， 将oldTab 转移到 newTab上，不重新计算hash。
原先一个结点上的值只会扩散到另一个结点，满足oldCap + oldIndex，原理和hashmap使用2的倍数长度数组，并且采用与运算有关。
如果一个结点上是树，会根据扩容后的结点长度，决定是否重构为链表。
方法的实践复杂度很高，一定要设置好初始长度，O(n)，系数是2


### putTreeVal 当插入的结点在一棵树中的时候

### root balanceInsertion(root, balanceNode)
> 维护红叉树的规则，balanceNode，插入的结点

1. 普通红黑树的构建过程

Java的类加载功能是通过Java代码实现的，所以可以通过Java定制自己的类加载器<br>
#### ClassLoader的一些特点
每个ClassLoad都有一个父节点，ClassLoad的数据结构类似于一个链表    
如果一个CLassLoad没有被显示指定父节点，则默认指定为SystemClassLoader，也就是Launcher里面单例的ClassLoad（private只能通过getter方法获取，没有setter方法），是Launcher.AppClassLoader的实例<br>
如果一个ClassLoader没有父节点为null，则默认为BootstrapClassCloader  
BootstrapClassCloader是由jvm实现的，实际上也只是在loadClass中做了一个判断，如果parent为null，调用private native Class<?> findBootstrapClass(String var1);<br>
设置线程上下文ClassLoader，并不会影响当前线程的类的加载，如果需要修改，可以通过虚拟机参数，ContectClassLoader等以后再发掘

## ClassLoader可以查看sun.misc.Launcher
#### ClassLoader.loadClass() 的运行过程
1. 先调用findLoadedClass检测自己是否已经加载了对应的类，如果已经加载，直接返回
2. 调用父节点（不是父类）的loadClass()进行加载，如果父类loadClass() 的结果返回了class，直接返回
3. 调用findClass()方法去查找class文件，如果没有找到，则抛出ClassNotFoundException
4. 将class文件加载进一个byte数组，调用defineClass()方法，将文件的byte数组形式转化为一个class对象。  
#### 定制ClassLoader的作用
定制class文件。可以在保存编译后的class文件时，进行加密操作，然后自己定义一个CLassLoader，并重写findClass()方法，在读取class文件时进行解密，就可以定制属于自己的class文件格式<Br>
可以从internet或者是其它任意的地方读取加载class。通过重写findCLass()方法，可以选择任意位置的class文件，例如可以通过URLConnection 从internet上读取class；<Br>
如果对字节码足够了解，可以在加载class的过程中修改class文件，完成自己的需求，比如aop<br>

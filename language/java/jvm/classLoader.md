## 类加载器

- 功能： 通过一个类的全限定名获取描述该类的二进制字节流

对于任意的一个类，都必须由它的类加载器和这个类本身一起确定其在java虚拟机中的唯一性，每一个类加载器，都拥有一个独立的类名称空间。简而言之：类加载器.类全限定名 唯一确定一个类
同一个类文件，可以通过这种方式，在虚拟机中创建两个不相同的类

### 类加载器
1. 启动类加载器(Bootstrap Class Loader)（使用c++编写）java 中用null 表示
负责加载 java_home\lib目录下的类 或者被Xbootclasspath 指定路径中存放的能够被jvm识别的类

2. 扩展类加载器(Extension Class Loader) 在sun.misc.Launcher$ExtClassLoader中用java实现
负责加载java_home\lib\ext 目录或者是java.ext.dirs 系统变量所指定的路径中所有的类库。

3. 应用程序类加载器(Application Class Loader) sun.misc.Launcher$AppClassLoader
因为也是ClassLoader.getSystemClassLoader()的返回值，所以在某些场合下也叫做系统类加载器。
负责加载classpath上的所有类库

### 双亲委派模型
一个类加载器加载类时，会先委托给父加载类（非继承关系，而是通过组合的方式实现，结构类似于链表），如果夫类加载器无法加载，才会自己进行加载。
jdk的类加载器采用双亲委派模式，

``` mermaid
graph LR
A(Application Class Loader) -->B(Extension Class Loader) 
	B--> C(Bootstrap Class Loader)
```

通过双亲委派模型，可以方便的构建java类优先级关系，结局各个类加载器协作时基础类型的一致性问题。

通过线程上下文的类加载器，可以违背双亲委派模型。


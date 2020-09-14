# 一些常用的注解

`@SpringBootApplication` <br>
`@Value`可以用来注入application中的值，也可以注入启动参数的值<br>
`@Conditional*` 之类的注解用于条件化生成bean，和`@Bean`、`@Componet`等一起使用。
**note：当@Conditional和@Bean一起使用时，默认使用返回值的类型作为value，所以当@ConditionalOnClass和Bean一起使用没有意义，因为在加载类时，虚拟机会把返回值的Class加载，所以@ConditionalOnClass必定为true，同理@ConditionalOnMissClass一直为false** <br>

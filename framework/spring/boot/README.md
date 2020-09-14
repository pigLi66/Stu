## 主要目标
> 为所有的spring开发提供一个快速并且健壮的使用体验  
> 当需求与默认的配置相冲突时，能够快速更改  
> 不需要代码和xml的配置    

## 约定
 spring-boot-starter-* 是一些官方的spring boot 启动器  
 如果需要自定义spring-boot-start， 推荐使用 \*-spring-boot-starter的形式  
 SpringBootApplication 会自动扫描加了该注解的类所在的目录及以下的bean， 其他的可以使用include 属性添加<br>
 构造器注入，可以在构造器上面添加@Autowired，如果只有一个构造器，可以省略<br>

### spring事件
> 在springboot启动时，控制台会打印一系列的事件，也是spring启动的过程<br>
1. ApplicationStartingEvent
2. ApplicationEnvironmentPreparedEvent
3. ApplicationContextInitializedEvent
4. ApplicationPreparedEvent
5. ApplicationStartedEvent
6. ApplicationReadyEvent
7. ApplicationFailedEvent


CommandLineRunner 在SpringApplication has started和SpringApplication.run(…​) completes之间

### 构建自己的spring-boot-starter
一般使用 \*-spring-boot-starter命名，用于引入其它依赖，而使用\*-spring-boot-autoconfigure 创建自动配置的模块。
使用Condition等注解条件化bean，可以引入spring-boot-autoconfigure-processor创建spring-autoconfigure-metadata.properties文件帮助spring的类加载器加快应用的启动。

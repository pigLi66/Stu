### spring属性相关，包括文件
> propert 的来源可以是 application文件，系统属性，参数等等，可以查看启动属性列表
### 启动属性 排在前面的会覆盖后面的
1. Devtools global settings properties in the $HOME/.config/spring-boot folder when devtools is active.

2. @TestPropertySource annotations on your tests.

3. properties attribute on your tests. Available on @SpringBootTest and the test annotations for testing a particular slice of your application.

4. Command line arguments.

5. Properties from SPRING_APPLICATION_JSON (inline JSON embedded in an environment variable or system property).

6. ServletConfig init parameters.

7. ServletContext init parameters.

8. JNDI attributes from java:comp/env.

9. Java System properties (System.getProperties()).

10. OS environment variables.

11. A RandomValuePropertySource that has properties only in random.*.

12. Profile-specific application properties outside of your packaged jar (application-{profile}.properties and YAML variants).

13. Profile-specific application properties packaged inside your jar (application-{profile}.properties and YAML variants).

14. Application properties outside of your packaged jar (application.properties and YAML variants).

15. Application properties packaged inside your jar (application.properties and YAML variants).

16. @PropertySource annotations on your @Configuration classes. Please note that such property sources are not added to the Environment until the application context is being refreshed. This is too late to configure certain properties such as logging.* and spring.main.* which are read before refresh begins.

17. Default properties (specified by setting SpringApplication.setDefaultProperties).

### 一些好的设计方法
> spring 建议将属性文件中的值映射成properties的bean，而不是使用繁重的`@Value`

### @Annotations
- `@ConfigurationProperties` 可以将属性映射成一个简单的Bean，但需要确保该类能够被spring扫描，配合`@EnableConfiguartionProperties`和`ConfigurationPropertiesScan`使用 <br>
- `@ConfigurationPropertiesScan`一般放于启动类上，指定ConfiguartionProperties的扫描路径，默认会包含当前路径 <br>
- `@EnableConfiguartionProperties` 指定扫描的ConfigurationProperties类 <br>
- `@Value` 注入指定的属性值 <br>
- `@Validated` 当在创建properties时，进行校验，使用JSR-303中的注解，注释属性
- `@Valid` 当存在嵌套属性是，在嵌套属性上添加该注解，可以校验嵌套的属性。

### spring的高度定制化
> 可以通过创建名为 **configurationPropertiesValidator** 的bean去定制自己的校验器。但需要将创建该bean的方法声明为static，确保能够在较早的时机进行加载。

# ***springMVC***
### 构建模块
spring-boot-starter-webflux 模块可以构建reactive web applications(机翻，响应式web应用) <br>
spring-boot-starter-web

### 自动配置包含的特性
Inclusion of ContentNegotiatingViewResolver and BeanNameViewResolver beans.

Support for serving static resources, including support for WebJars.

Automatic registration of Converter, GenericConverter, and Formatter beans.

Support for HttpMessageConverters .

Automatic registration of MessageCodesResolver .

Static index.html support.

Custom Favicon support .

Automatic use of a ConfigurableWebBindingInitializer bean .

### 在保持自动配置的同时定制自己的配置
1. 自定义interceptors, formatters, view controllers, and other features的同时
> 实现WebMvcConfigurer，并使用Configuration注解，注意不要使用@EnableWebMvc <br>
2. 自定义 RequestMappingHandlerMapping, RequestMappingHandlerAdapter, 或者 ExceptionHandlerExceptionResolver
> 实现WebMvcRegistrations


### Annotation
`@EnableWebMvc` 在学好spring之前不推荐使用，当需要完全定制自己的springMVC时可以使用


### property
spring.mvc.static-path-pattern= 设置静态资源映射的URL

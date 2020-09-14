# 谈谈对于[Restful](https://www.ics.uci.edu/~fielding/pubs/dissertation/top.htm) 的理解  

Restful 在我的理解中是一个软件开发的规范，按照该规范开发的应用，能够很好的向前端或者其他应用展现该应用所具有的资源，并且操作资源，并且，其他使用该资源的应用，只要了解该规范，就能够在不需要文档的情况下进行访问和操作  
  
在开发中，将资源通过uri 暴露给使用方，其他应用，可以通过特定的http 动作（http的方法）进行访问，并进行操作 
uri全部由名词构成，不包括动词，单单只是标识一个资源，而http 方法，标识对资源的操作，GET 表示获取资源，POST 表示将资源对应的资源上传，PUT 表示进行更新操作，DELETE 表示删除对应资源。  
应用只需要告诉调用者， 资源的URI即可  
  
符合restful的应用（简称server)， 和使用server的应用（简称client），之间通过http 进行通信，client 通过uri，定位操作的资源，使用http方法告诉server怎么操作资源。server 通过状态码和原因短语告诉client 一次操作的结果，1XX标识信息回应，2XX标识操作成功，3XX标识资源已经移动，4XX标识client操作错误，5XX标识服务器错误，具体的状态码可以查看[腾讯云的开发手册](https://cloud.tencent.com/developer/section/1189846)。响应报文的content主体，用于传送资源，而报文的头部用于传送一个信息，列如：token，资源的位置location等等。  
  
Java 开发中，spring对restful提供了很好的支持，包括[RestController](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html)注解、[ResponseEntity](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html)等等。 在开发中，尽量做到一个controller 类只标识一个资源。对于一些用户认证的通用操作，可以使用拦截器进行配置。
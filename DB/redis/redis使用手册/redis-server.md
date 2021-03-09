##  redis-server的一些配置

redis默认端口6379

redis-server 使用一下的方式可以关闭和重启

```shell
/etc/init.d/redis-server stop
/etc/init.d/redis-server start
/etc/init.d/redis-server restart
```

### redis-server的启动参数

--port 指定启动的端口

可以在启动命令的后面直接追加文件名，来指定redis的配置文件
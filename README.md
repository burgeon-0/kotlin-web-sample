# kotlin-web-sample

Kotlin Web Sample

## Zookeeper

- 启动 Zookeeper

```shell
sudo zkServer.sh start
```

- 停止 Zookeeper

```shell
sudo zkServer.sh stop
```

- 使用 zkClient 连接 Zookeeper

```shell
zkCli.sh -server 127.0.0.1:2181

# 连接后，可使用以下命令进行测试
ls /
create /zk_test my_data
get /zk_test
set /zk_test joke
delete /zk_test
```

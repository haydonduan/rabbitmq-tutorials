### docker安装rabbitmq
#### pull带有管理端的rabbitmq
> docker pull rabbitmq:management

#### 创建容器
> docker run --name owl-rabbitmq -p 15672:15672 -p 5672:5672 rabbitmq:management

#### 启动容器
> docker run owl-rabbitmq

#### 查看log
> docker logs -f owl-rabbitmq

### 运行程序
#### compile
> javac -cp ../lib/amqp-client-5.7.1.jar NewTask.java Worker.java

#### publish message
> java -cp .:../lib/amqp-client-5.7.1.jar:../lib/slf4j-api-1.7.26.jar:../lib/slf4j-simple-1.7.26.jar NewTask First message....

#### consume message
>  java -cp .:../lib/amqp-client-5.7.1.jar:../lib/slf4j-api-1.7.26.jar:../lib/slf4j-simple-1.7.26.jar Worker

#### 笔记
    - work-queues
        -  启动多个worker，那么rabbitmq会去给每个worker，按照顺序发消息
        -  channel.setQoS(1) 目前感觉用处不大？？
        
    - channel.basicPublish("", "hello", null, message.getBytes());
        -之前这个方法的第一个参数时exchange，但是这里是空的，那就是必须制定queue的名字才能使用该exchange进行转发
        

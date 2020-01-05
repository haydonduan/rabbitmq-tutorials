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
        
        
    - exchange type 为fanout
        - 需要执行exchange name，但是不用执行queue名字，因为是广播机制，所以会看到没有指定queue,就算填上也没啥用
        - 如果指定的queue就成了传统的队列，exchange 就会轮流给不同的queue发送消息了，如上章一样

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

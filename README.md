# 
kafka linux 下载地址：
http://kafka.apache.org/downloads

启动zookeeper
cd进入kafka解压目录，输入
bin/zookeeper-server-start.sh config/zookeeper.properties

启动kafka
cd进入kafka解压目录，输入
bin/kafka-server-start.sh config/server.properties

创建一个topic 
Kafka通过topic对同一类的数据进行管理，同一类的数据使用同一个topic可以在处理数据时更加的便捷
在kafka解压目录打开终端,输入
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
创建一个名为test的topic

在创建topic后可以通过输入
bin/kafka-topics.sh --list --zookeeper localhost:2181
来查看已经创建的topic

创建一个消息消费者
在kafka解压目录打开终端，输入
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
可以创建一个用于消费topic为test的消费者


创建一个消息生产者
在kafka解压目录打开一个新的终端，输入
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test

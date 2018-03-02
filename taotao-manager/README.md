

一、后台管理系统+商品服务
taotao-parent
taotao-common
taotao-manager(taotao-manager-dao+
			   taotao-manager-pojo+
			   taotao-manager-interface+
			   taotao-manager-service)  taotao-manager-web

虚拟机：centos JDK7  zookeeper redis集群



FastDFS是用c语言编写的一款开源的轻量级分布式文件系统。它对文件进行管理，功能包括：
文件存储、文件同步、文件访问（文件上传、文件下载）等，解决了大容量存储和负载均衡的问题。
特别适合以文件为载体的在线服务，如相册网站、视频网站等等。 
FastDFS为互联网量身定制，充分考虑了冗余备份、负载均衡、线性扩容等机制，并注重高可用、
高性能等指标，使用FastDFS很容易搭建一套高性能的文件服务器集群提供文件上传、下载等服务。
/home/fastdfs/store_path0/data/00/00
zookeeper服务器IP地址：192.168.202.99 网关：192.168.202.2  子网掩码：255.255.255.0  端口2181 root密码：123
taotao-image-server虚拟机 IP地址：192.168.202.167 网关：192.168.202.2  子网掩码：255.255.255.0 root密码：itcast

KindEditor 富文本编辑器

二、商城门户和内容服务
taotao-content(taotao-content-interface+
				taotao-content-service)
taotao-portal-web


三、搜索服务工程

solr Solr是一个独立的企业级搜索应用服务器，它对外提供类似于Web-service的API接口。用户可以通过http请求，向搜索引擎服务器提交一定格式的XML文件，生成索引；
也可以通过Http Get操作提出查找请求，并得到XML格式的返回结果。
中文分析器IK-Analyzer

SolrCloud(Solr云)是Solr提供的分布式搜索方案，当你需要大规模，容错，分布式索引和检索能力时可使用SolrCloud。当一个系统的索引数据量少的时候是不需要使用SolrCloud的，当索引量很大，搜索请求并发很高的时候，这时就需要使用SolrCloud来满足这些需求。
SolrCloud是基于Solr和Zookeeper(来管理Solr集群的)的分布式搜索方案，它的主要思想是使用Zookeeper作为集群的配置信息中心

消息中间件MQ。常见的作为MQ的中间件有：ActiveMQ  RabbitMQ  Kafka
为了实现系统之间通信，把系统之间调用的耦合度降低的情况下都可以使用MQ。 端口 8161

freemarker 网页静态化


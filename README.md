##顺序练习springboot2的guides 

###地址：https://spring.io/guides


###登录用户名密码：
####ben
####benspassword

私有云服务器地址：106.12.95.66
密码：p....!  （字母、数字、特殊符号。）

cmd  :   ssh root@ip


docker run -d --name myactivemq -p 61616:61616 -p 8161:8161 webcenter/activemq

docker run -itd --name my-redis -p 6379:6379 redis

docker run -itd --name mysql01 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=p...b(全字母) mysql

docker run -itd --name mysqlslave02 -p 3307:3306 -e MYSQL_ROOT_PASSWORD=slave mysql

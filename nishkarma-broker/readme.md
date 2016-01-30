#Nishkarma EAI Framework
This sample program intends to demonstrate EAI pattern with ApacheMQ, Spring Batch.

##Environments
* Spring Framework (https://projects.spring.io/spring-framework/)
* ActiveMQ (http://activemq.apache.org/)
* Spring Batch (http://projects.spring.io/spring-batch/)
* Spring Batch Admin (http://docs.spring.io/spring-batch-admin/)
* Jetty (http://www.eclipse.org/jetty/)
* MyBatis (http://blog.mybatis.org/p/products.html)
* PostgreSQL (http://www.postgresql.org/)

###Steps:

1) In the command line
```
git clone https://github.com/nishkarma/broker.git
```
2) Inside Eclipse
```
File -> Import -> Maven -> Existing Maven projects
```

3) Initialize DB
```
In PostgreSQL Admin Tool, run
db-script/sample data/
	erp
		/TB_TMP_ERP_ORDERS_insert.sql
	mall
		/CUSTOMER_insert.sql
		/TB_TMP_ORDER_insert.sql
```		
		
###Program Run

mvn package

* BatchServer

    run in eclipse
		org.nishkarma.batch.application.BatchServer
		with VM arguments
			-DENVIRONMENT=postgresql -Dspring.profiles.active="batch"
	run in command shell
		java -DENVIRONMENT=postgresql -Dspring.profiles.active="batch" -cp "./target/dependency-jars/*:./target/classes" org.nishkarma.batch.application.BatchServer


* BrokerServer

	run in eclipse
		org.nishkarma.broker.application.BrokerServer
		with VM arguments
			-DENVIRONMENT=postgresql -Dspring.profiles.active="activemq, jetty"
	run in command shell
		java -DENVIRONMENT=postgresql -Dspring.profiles.active="activemq, jetty" -cp "./target/dependency-jars/*:./target/classes" org.nishkarma.broker.application.BrokerServer activemq-server1.properties
		
	when you need HA, run once more with parameter activemq-server2.properties like
		java -DENVIRONMENT=postgresql -Dspring.profiles.active="activemq, jetty" -cp "./target/dependency-jars/*:./target/classes" org.nishkarma.broker.application.BrokerServer activemq-server2.properties
		
	
###how to monitor
1. webconsole
	http://localhost:8161/
   
	When you connect to http://localhost:8161/, jetty will ask you realm. insert admin / admin2 that is configured in /nishkarma-broker/webapps/WEB-INF/jetty-realm.properties.
	If you login, you can see ApacheMQ webconsole link and Spring Batch Admin link.

2. jconsole
	remote
	service:jmx:rmi:///jndi/rmi://127.0.0.1:1100/jmxrmi
	
###how to customize
	

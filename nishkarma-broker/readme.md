#Nishkarma EAI Framework
This sample program intends to demonstrate EAI pattern with ApacheMQ, Spring Batch.

You can see the overview this project in https://github.com/nishkarma/broker/blob/master/nishkarma-broker/docs/Nishkarma-EAI-Diagram.pdf

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
1. In PostgreSQL Admin Tool, run
db-script/sample data/
	erp
		/TB_TMP_ERP_ORDERS_insert.sql
	mall
		/CUSTOMER_insert.sql
		/TB_TMP_ORDER_insert.sql
2. ActiveMQ Schemas
It's defined as createTablesOnStartup="tre" in /src/main/resources/activemq/activemq-nishkarma.xml.
<persistenceAdapter>
	<jdbcPersistenceAdapter dataSource="#dataSource-eai"
		createTablesOnStartup="false" />
</persistenceAdapter>

When you run BrokerServer first time, set the createTablesOnStartup="true".
It will create ActiveMQ schemas.
After schema is created, set the createTablesOnStartup="false".

3. Spring Batch Schemas
It's defined as batch.data.source.init=false in /webapps/batch/WEB-INF/classes/batch-postgresql.properties.

When you run BatchServer first time, set the batch.data.source.init=true.
It will create ActiveMQ schemas.
After schema is created, set the batch.data.source.init=false.
```		
		
###Program Run

mvn package

* BatchServer
```
    run in eclipse
		org.nishkarma.batch.application.BatchServer
		with VM arguments
			-DENVIRONMENT=postgresql -Dspring.profiles.active="batch"
	run in command shell
		java -DENVIRONMENT=postgresql -Dspring.profiles.active="batch" -cp "./target/dependency-jars/*:./target/classes" org.nishkarma.batch.application.BatchServer
```

* BrokerServer
```
	run in eclipse
		org.nishkarma.broker.application.BrokerServer
		with VM arguments
			-DENVIRONMENT=postgresql -Dspring.profiles.active="activemq, jetty"
	run in command shell
		java -DENVIRONMENT=postgresql -Dspring.profiles.active="activemq, jetty" -cp "./target/dependency-jars/*:./target/classes" org.nishkarma.broker.application.BrokerServer activemq-server1.properties
		
	when you need HA, run once more with parameter activemq-server2.properties like
		java -DENVIRONMENT=postgresql -Dspring.profiles.active="activemq, jetty" -cp "./target/dependency-jars/*:./target/classes" org.nishkarma.broker.application.BrokerServer activemq-server2.properties
```		
	
###How to monitor
```
1. webconsole
	http://localhost:8161/
   
	When you connect to http://localhost:8161/, jetty will ask you realms. 
	Insert admin / admin2 that is configured in /nishkarma-broker/webapps/WEB-INF/jetty-realm.properties.
	If you login, you can see ApacheMQ webconsole link and Spring Batch Admin link.

2. jconsole
	remote
	service:jmx:rmi:///jndi/rmi://127.0.0.1:1100/jmxrmi
```
	

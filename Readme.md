Welcome to AniSat Food Delivery Micro Service.

This project comprise 3 parts

1. Orcheatraotor Micro Service act as GateWay API as well as UI(browser) for all other services.
2. Kafka Message broker will be used to communicated between micro service.
3. Actual Micro Services. (foodService, UserService, Order Service)

Notes : 
1. Implemented all the service as Docker. So that we can directly deploy to AWS/Google Cloud.
2. Need to implement other Corss Cutting conserns like 
    a : Security, 
    b : Sluth/Zipkin for Cloud Tracing, 
    c : ELK(Elastic Search, Logtesh, Kibana Stack), 
    d : RestTemplate Pool, 
    e : Chacing between mmicro service. 
    f : NoSql data persistance for audit
    h : NewRelic for metric analysis and many more.

Steps to run the entire food application.

#Step 1 : Install Kafka as Docker:

    git clone https://github.com/wurstmeister/kafka-docker
    DOCKERHOST=$(ifconfig | grep -E "([0-9]{1,3}\.){3}[0-9]{1,3}" | grep -v 127.0.0.1 | awk '{ print $2 }' | cut -f2 -d: | head -n1)
    echo $DOCKERHOST

    cd kafka-docker
    vi docker-compose-single-broker.yml

--replace the new ip against below property.
    KAFKA_ADVERTISED_HOST_NAME: <new IP>

    docker-compose -f ./docker-compose-single-broker.yml up -d
    docker exec -t kafka-docker_kafka_1 kafka-topics.sh  --bootstrap-server :9092  --create  --topic ORDERSTATUSUPDATES --partitions 1  --replication-factor 1

The above steps will start and run kafka server in port 9092 port with the topci name ORDERSTATUSUPDATES.

#Step 2 : build the project:

    cd project_directory 
    mvn clean install -DskipTests

#Step 3 : Start Micro Service one by one as below.
mvn clean install -DskipTests create new folder called finalJar and copy all the required jars into it.

    cd <project_baseDirectory>/finaljar
    java -jar orchestrator.jar
        //orchestrator start in Port 8080
        
    java -jar foodmgmt.jar
        //orchestrator start in Port 8082
         
    java -jar ordermgnt.jar
        //orchestrator start in Port 8083
        
    java -jar usermgnt.jar
        //orchestrator start in Port 8081

#Setp 4 : Download postmand collection and load. All the required data will be prepopulated already.
    Execute Get/GetAll operation in Postman to check all the api's working as expected.

#Step 5 : The actual flow is this.

    User : Can Be 3 type : Customer, Hotel, Delivery Person 
    Orchestrator is a single app will serve UI for all the above users(Customer, Hotel, Delivery Person) based on the login.
    
    As of Now only API has implemented due to time contraint. UI if I get more time I can implement in Spring ThymeLeve.
    
    Flow 1 : 
        Step 1 : User Create order using API to Order Management.
        Step 2 : ORder will be saved in to local database and order event published in Kafka.
        Step 3 : Orchestrator of the listener(Many Listerner) will listen for Order Event and create notification in the UI for User Or Hotel Or Delivery Person for next task.
        
    Excution :
        Step 1 : Execute GetAllOrders PostMan request in Orchestrator --> Get All Orders. The result will be empty.  
        Step 2 : Execute Post New Order in Order Service --> Post New Order.
            {
            	"orderId":4,
            	"userId":1,
            	"restaruntId":1,
            	"cost":200.0,
            	"overAllStatus":"CREATED",
            	"address":"delivery address",
            	"foodId":1,
            	"qty":2
            }
            Response : You will get response as 200 OK.
        Step 3 : Aagain Execute Step 1.
        Step 4 : You can find new order created in Orchestrator local db for notification to particular Hotel.
            
         






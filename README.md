# bills-display
This project is supposed to create a simple UI interface that would read bills from elastic and display them. 

Iteration #1 - Just read the bills and display them.
Iteration #2 - Search and filtering functionality.
Iteration #3 - Show all or show only bills corresponding to a certain user.


How to start the entire application

Projects involved:
1. bills-generator (aka producer)
2. bills-processer (aka consumer)
3. bills-display (aka kind of interface)


The folder under the bills-display contains the docker scripts.

docker/bills/bills-display 
   - contains the scripts to generate a docker image from the bills-display application; the application will be started on port 8080
   - docker build -t billdisplay .

docker/bills/bills-processer 
   - contains the scripts to generate the docker image for the consumer, from the bills-processer application
   - first we generate locally a .jar file
   - we override into the container the application.yml with some other settings (eventuallly)
   - the processer will be started and will listen till there is something into the queue
   - the processer will read from the queue and will save it into elasticsearch
   - we have to have saved into the application the hostname for the elasticsearch: right now (06.10.2017) it is still hardcoded, but  should 
   be eventually configured into application.yml und read inside the application
   - hostname: elastic, user:elastic, password: changeme
   - docker build -t processer .
   
docker/bills/elasticsearch
   - contains already the docker-compose yml to start the elasticsearch (not used here, moved into processer-display/docker-compose.yml))
   
docker/bills/kafka
   - contains already the docker-compose.yml to start the zookeeper + kafka  (not used here, moved into processer-display/docker-compose.yml)
   
docker/bills/processer-display
   - contains the docker-compose.yml file to start all the services: kafka, zookeeper, elastic, processer, display
   - the services got a hostname so we can use this property when we want to specify that a service has to connect to another one (eg. processer connects to elastic)
   - KAFKA_ADVERTISED_HOST_NAME: 172.17.0.1 - this is very important!!!! the IP represents the docker network IP
            - more info here: https://github.com/wurstmeister/kafka-docker/issues/17
            


So the setup till now is more or less flexible. Still have to work on it, but for the first try at least it works: starts the services, reads the things from 
kafka and saves them in elasticsearch.

To start everything just have to run:
/docker/bills/processer-display/docker-compose up    

Then in order to write into kafka, run separately the bills-generator project

Then access everything at: http://localhost:8080/index/bills
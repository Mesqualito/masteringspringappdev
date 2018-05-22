
## MongoDB:
- docker-compose -f docker-compose.yml up
- docker exec -it masteringspringappdev_mongodb_1 /bin/bash
- [id]:/# mongo --username eshopdb eshopdb
- \> db.eshopdb.insert({cust_id:1,name:"Testcustomer1",address:"Germany"}) ...

## Apache Active MQ:
- docker pull rmohr/activemq (22.05.2018: Apache Active MQ 5.15.3)
- docker run -p 61616:61616 -p 8161:8161 -name activemq rmohr/activemq (The JMX broker listens on port 61616
and the Web Console on port 8161)
- alternative: docker run -p 61616:61616 -p 8161:8161 -v /opt/activemq/conf:/opt/activemq/con
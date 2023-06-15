#!/bin/bash
docker run -d --name amq \
        -p 61616:61616 \
        -p 8161:8161 \
         rmohr/activemq

docker run -d --name hsqldb \
	  -e "HSQLDB_USER=sa" \
  	-e "HSQLDB_PASSWORD=password" \
  	-e "HSQLDB_DATABASE_ALIAS=db" \
	  -p 9001:9001 \
	mitchtalmadge/hsqldb
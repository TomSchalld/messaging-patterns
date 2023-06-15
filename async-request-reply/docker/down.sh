#!/bin/bash

docker stop hsqldb
docker stop amq
docker rm hsqldb
docker rm amq
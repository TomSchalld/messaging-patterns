#!/bin/bash

curl --request POST -sLvvv \
     --url 'http://localhost:8080/input'\
     --header 'Content-Type: application/json' \
     -d '{"action": "ADD", "left": 30, "right":12}'
#!/bin/sh
mvn clean package && docker build -t at.faun.pos.dobl/AmdahlsLaw .
docker rm -f AmdahlsLaw || true && docker run -d -p 8080:8080 -p 4848:4848 --name AmdahlsLaw at.faun.pos.dobl/AmdahlsLaw 

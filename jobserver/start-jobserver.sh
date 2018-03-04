#!/bin/bash

mkdir -p logs
JOBSERVER_PORT=8090
JMXREMOTE_PORT=3600

#Show process  using JOBSERVER_PORT
fuser -v -n tcp $JOBSERVER_PORT

#kill process using  JOBSERVER_Port
fuser -k $JOBSERVER_PORT/tcp



#fuser -v -n tcp $JMXREMOTE_PORT

#fuser -k $JMXREMOTE_PORT/tcp



/usr/bin/java  -XX:+AggressiveOpts -XX:TargetSurvivorRatio=90 -XX:SurvivorRatio=64 -XX:MaxTenuringThreshold=8 \
 -XX:NewRatio=1 -Dserver.port=${JOBSERVER_PORT}   -Dcom.sun.management.jmxremote=true \
  -Dcom.sun.management.jmxremote.port=$JMXREMOTE_PORT -Dcom.sun.management.jmxremote.ssl=false \
  -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.local.only=false \
   -XX:+UnlockCommercialFeatures -XX:+FlightRecorder  -Dasync=true -Dlogging.path=./logs/ -jar jobserver-1.0-SNAPSHOT-jar-with-dependencies.jar

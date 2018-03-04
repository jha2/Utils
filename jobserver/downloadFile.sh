#!/bin/bash

JOB_SERVER=http://172.21.149.203:8090/jobserver

#create destination folder:  set from application.properties
destination_folder="resources"
rm -f $destination_folder
mkdir -p $destination_folder

filename="NASA_access_log_Jul95.gz"

#get jobs

get_file () {
        echo ""
        curl  -s -H "traceID:${id}" -X GET  ${JOB_SERVER}/download/$filename
        if [ $? -eq 0 ]
        then
            echo "file: $filename downloaded to $destination_folder"
        fi
}

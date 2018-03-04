### Introduction

This is a spring boot application for downloading file from a given FTP server.  It download the file using [FTPClient]() and stores them in local file system.  The present (or another) service can be modified (written) to store downloaded file in Hadoop Distributed File System (HDFS). 

####Build the package

```cd src```

```mvn clean install```

Application jar file can be found in the folder ```target/jobserver-1.0-SNAPSHOT-jar-with-dependencies.jar```.

#### Staring the jobserver
Create a folder `jobserver` on the node where you want to run the application. Copy the   following files into the folder ```jobserver```

* ```target/jobserver-1.0-SNAPSHOT-jar-with-dependencies.jar```     
*  ```src/main/resources/application.properties```  
*  run.sh
* downloadFile.sh

For starting the jobserver:
```./run.sh```

Above command will start jobserver running on the port 8090.

###Initiate file transfer from FTP server
./downloadFile.sh

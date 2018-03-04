### Instructions:



The class "MainExample.scala" does the spark code analysis for  determine the top-n most frequent visitors and urls for each day of the trace. 

In order to build the jar:

``cd src``

``mvn clean install``


Inside the ```/target``` folder you will find the result fat jar called ```spark-scala-maven-project-0.0.1-SNAPSHOT-jar-with-depencencies.jar```. In order to launch the Spark job use this command in a shell with a configured Spark environment:

    spark-submit --class com.examples.MainExample \
      --master yarn-cluster \
      spark-scala-maven-project-0.0.1-SNAPSHOT-jar-with-depencencies.jar \
      inputhdfspath \
      outputpath

The format for file path: 

File residing in local file system: ```file:///input.txt ```

File residing in local file system: ```hdfs:///input.txt ```

To run on the spark job on local node (spark binaries should be installed or [one can used pre-compiled VM](https://github.com/martinprobson/vagrant-hadoop-hive-spark)):

```./run.sh```


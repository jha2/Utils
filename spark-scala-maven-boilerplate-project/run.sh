#!/bin/bash

#Protocol file is used for local file system
#Protocol hdfs can be used for file residing in HDFS.

export VAGRANT_AREA="file:///vagrant/Courses"
export PACKAGE_DIR="spark-scala-maven-boilerplate-project"
export LOCAL_PATH="/vagrant/Courses"

rm -f ${VAGRANT_AREA}/NASA/jobout.txt

#Run the job locally on the node using spark-submit
/usr/local/spark/bin/spark-submit --class com.examples.MainExample \
  --master local ${VAGRANT_AREA}/${PACKAGE_DIR}/target/spark-scala-maven-project-0.0.1-SNAPSHOT-jar-with-dependencies.jar \
  ${VAGRANT_AREA}/NASA/text ${VAGRANT_AREA}/NASA/jobout.txt


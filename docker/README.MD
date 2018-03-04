###Introduction
 Focus on how to dockerize a Spring Boot Application to run it in an isolated environment. Creats a Java-enabled, lightweight base image, running [Alpine Linux](https://hub.docker.com/_/alpine/).
 
#### Common Base Image

Uses Docker’s own build-file format: a Dockerfile. For building the image and store it in the local library, we have to run

```docker build --tag=alpine-java:base --rm=true .```

#### Dockerize the jobserver and spark application
mkdir -p files

cd ../jobserver
mvn clean install 
cp target/jobserver-1.0-SNAPSHOT-jar-with-dependencies.jar ../docker/files
cd ../docker


#### Image creation
For creating image:

```docker build --file=Dockerfile.server --tag=job-server:latest --rm=true . ```

#### Create volume for mounting
docker volume create --name=spring-boot-jobserver

### Run the image 
 docker run --name=spring-boot-jobserver --publish=8888:8888 \
     --volume=spring-boot-jobserver:/var/lib/jobserver \
     job-server:latest
     
### Foe inspecting the jobserver
docker inspect job-server

docker stop job-server

docker rm job-server
     
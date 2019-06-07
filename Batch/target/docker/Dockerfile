FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD /mail-batch-0.0.1-SNAPSHOT.jar mail-batch.jar
EXPOSE 8084
ENV JAVA_OPTS=""
#RUN bash -c 'touch /mail-batch.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /mail-batch.jar" ]
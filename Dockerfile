FROM openjdk:11
VOLUME /tmp
EXPOSE 8102
ADD ./target/ws-client-business-0.0.1-SNAPSHOT.jar ws-client-business.jar
ENTRYPOINT ["java","-jar","ws-client-business.jar"]
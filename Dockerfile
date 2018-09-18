FROM openjdk:8
ADD target/myapp.jar myapp.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", myapp.jar]
FROM eclipse-temurin:17
WORKDIR /opt/maps/
RUN mkdir api
COPY ./api ./api
CMD ["java", "-jar", "./api/target/maps-1.0-SNAPSHOT.jar"]
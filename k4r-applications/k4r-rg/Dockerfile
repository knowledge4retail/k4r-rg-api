FROM maven:3.6.3-jdk-11 as MAVEN_TOOL_CHAIN

WORKDIR /build
#COPY ./ /build
COPY ./k4r-rg/src/ /build/k4r-rg/src/
COPY ./k4r-rg/pom.xml /build/k4r-rg/
COPY ./pom.xml /build

RUN mvn --batch-mode --update-snapshots \
      -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=WARN \
      -Dorg.slf4j.simpleLogger.showDateTime=true -Dorg.slf4j.simpleLogger.dateTimeFormat=HH:mm:ss,SSS \
      clean install -P docker -pl k4r-rg

FROM openjdk:11.0.6-jre
COPY --from=MAVEN_TOOL_CHAIN /build/k4r-rg/target/rg.jar /usr/app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/app/app.jar"]

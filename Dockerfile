FROM openjdk:11
WORKDIR /tmp
ADD target/zzd.jar /tmp/app.jar
CMD java -jar app.jar
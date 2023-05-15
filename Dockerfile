FROM openjdk:19
ADD out/artifacts/paracasa_jar/paracasa.jar paracasa.jar
ENTRYPOINT ["java", "-jar", "paracasa.jar"]
# Usar una imagen base con Maven y JDK 8
FROM maven:3.8.4-openjdk-8 AS build

# Establecer un directorio de trabajo
WORKDIR /app

# Copiar archivos de tu proyecto al directorio de trabajo
COPY . /app

# Ejecutar Maven para construir el proyecto
RUN mvn clean package

# Crear una nueva imagen basada en OpenJDK 8
FROM openjdk:8-jre-slim-buster

# Exponer el puerto que utilizará la aplicación
EXPOSE 8080

# Copiar el archivo JAR construido desde la etapa anterior
COPY --from=build /app/target/conexa-0.0.1-SNAPSHOT.war /app/conexa-0.0.1-SNAPSHOT.jar

# Establecer el punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/conexa-0.0.1-SNAPSHOT.jar"]
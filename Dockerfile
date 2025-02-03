# Etapa 1: Construcción de la aplicación
FROM maven:3.9.1-eclipse-temurin-17 AS build
WORKDIR /app
# Copia el archivo pom.xml y descarga las dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B
# Copia el código fuente
COPY src ./src
# Compila la aplicación y crea el jar (se omiten los tests)
RUN mvn clean package -DskipTests

# Etapa 2: Imagen de ejecución
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copia el jar generado en la etapa anterior
COPY --from=build /app/target/gft-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

# GFT - API de Precios

Esta aplicación es un microservicio desarrollado en Spring Boot 3 que expone un endpoint REST para consultar el precio final y la tarifa aplicable de un producto en función de la fecha de aplicación. Utiliza una arquitectura hexagonal, una base de datos en memoria H2 y proporciona documentación interactiva a través de Swagger UI. Además, incluye configuración para despliegue con Docker.

---

## Tabla de Contenidos
- [Requisitos](#requisitos)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Ejecutar la Aplicación](#ejecutar-la-aplicación)
    - [Desde la Línea de Comandos (Maven)](#desde-la-línea-de-comandos-maven)
    - [Usando Docker](#usando-docker)
- [Documentación de la API (Swagger UI)](#documentación-de-la-api-swagger-ui)
- [Acceso a la Consola H2](#acceso-a-la-consola-h2)
- [Especificaciones del Código y Arquitectura](#especificaciones-del-código-y-arquitectura)
- [Docker](#docker)
- [Test y pruebas de integracion](#test-y-pruebas-de-integración)

---

## Requisitos
- Java 17 o superior.
- Maven 3.8 o superior.
- Docker (opcional, para despliegue en contenedor).

---

## Estructura del Proyecto
El proyecto sigue una arquitectura hexagonal, separando la lógica de dominio y casos de uso de los adaptadores de entrada (REST) y salida (persistencia). La estructura principal es la siguiente:

```plaintext
com.inditex.gft
├── application
│   ├── port.in                // Interfaces de casos de uso
│   └── service                // Implementaciones de casos de uso
├── domain
│   ├── model                  // Entidades y objetos de valor del dominio
│   ├── repository             // Interfaces de repositorios (puertos de salida)
│   └── exception              // Excepciones del dominio
├── infrastructure
│   ├── adapter.in             // Adaptadores de entrada (REST, controladores, mappers, etc.)
│   └── adapter.out            // Adaptadores de salida (persistencia, entidades JPA, repositorios, etc.)
├── configuration              // Configuraciones generales (beans, Swagger, etc.)
└── generated                  // Código generado a partir del archivo OpenAPI (por el plugin)
```

# Ejecutar la Aplicación

## Desde la Línea de Comandos (Maven)

1. **Compilar y empaquetar la aplicación**:
   mvn clean install

2. **Ejecutar el JAR generado:
    java -jar target/gft-0.0.1-SNAPSHOT.jar

La aplicación estará disponible en el puerto 8080.

# Usando Docker

1. **Construir la imagen Docker:
    Para construir la imagen usa el comando `docker build -t gft .`

2. ** Ejecutar el contenedor:
    `docker run -p 8080:8080 gft`
    
La aplicación estará disponible en http://localhost:8080.

# Documentación de la API (Swagger UI)
La documentación interactiva de la API está disponible a través de Swagger UI. Una vez iniciada la aplicación, accede a:

http://localhost:8080/swagger-ui/index.html

Allí podrás probar los endpoints y consultar los esquemas de datos (incluyendo el modelo de errores).

# Acceso a la Consola H2
La base de datos H2 está configurada para ser accesible. Para acceder, abre en tu navegador:

http://localhost:8080/h2-console

Utiliza los siguientes datos de conexión:

JDBC URL: jdbc:h2:mem:pricesdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
Username: sa
Password: (vacío)


# Especificaciones del Código y Arquitectura

Arquitectura Hexagonal
La aplicación está estructurada en capas para separar la lógica de negocio de la infraestructura. Los adaptadores de entrada (controladores REST y mappers) y de salida (persistencia con JPA) están claramente definidos.

Gestión de Excepciones
Se implementa un controlador global de excepciones (@ControllerAdvice) para capturar y retornar respuestas de error según el modelo definido en OpenAPI.

Generación de Código
Se utiliza el plugin openapi-generator-maven-plugin para generar interfaces y modelos a partir del archivo OpenAPI (prices.yaml), promoviendo el enfoque API First.

# Docker
El Dockerfile utiliza un enfoque multi-stage para construir y empaquetar la aplicación, facilitando un despliegue sencillo y reproducible.


#  Test y pruebas de integración
Este proyecto incluye pruebas de integración para validar el correcto funcionamiento de la API REST y su interacción con la base de datos. Se han implementado utilizando JUnit 5, RestAssured y una base de datos en memoria H2 para pruebas.

Para ejecutar todos los test unitario ejecutar desde la consola: `mvn test -DexcludedGroups=integracion`

✅ Tipos de pruebas implementadas
Pruebas de integración de API (Service Tests)

Validan que los endpoints REST devuelvan respuestas correctas.
Se realizan con RestAssured.
Se verifican códigos de estado HTTP, estructura de respuesta y valores esperados.
Pruebas de integración con base de datos (Database Integration Tests)

Si tu api no esta en ejecucion desde una consola del sistema ejecutar: `mvn spring-boot:run`
Para ejecutarlas se debe tener una instancia de la aplicacion corriendo en localhost:8080 y desde la consola de comandos ejecutar: `mvn test -Dtest=PriceApiTest`


Validan que la API interactúa correctamente con la BD H2.
Se prueba la persistencia y recuperación de datos.
Se aseguran de que las consultas SQL devuelvan los datos correctos.

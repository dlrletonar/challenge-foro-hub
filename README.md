# Foro Hub API REST Challenge Alura

Este repositorio contiene el código fuente de una API REST desarrollada con Spring Boot para gestionar un foro de discusión. La API permite la autenticación de usuarios, registro de nuevos usuarios y gestión de temas de discusión.

## Funcionalidades Principales

- **Autenticación Segura**: Utiliza Spring Security y JSON Web Tokens (JWT) para asegurar las operaciones de autenticación y autorización de usuarios.
- **Persistencia de Datos**: Integra con MySQL a través de Spring Data JPA para almacenar y consultar información de usuarios y temas de discusión.
- **Documentación de API**: Genera automáticamente documentación de API con Swagger/OpenAPI, accesible a través de [Swagger UI](http://localhost:8080/swagger-ui/index.html#/).
- **Validación de Datos**: Implementa validaciones para garantizar la integridad de las peticiones entrantes.
- **Migración de Base de Datos**: Utiliza Flyway para gestionar las migraciones de base de datos y mantener la consistencia de la estructura.

### Ejemplos de Peticiones

A continuación, se muestran ejemplos de cómo realizar peticiones a los endpoints más relevantes de la API utilizando Insomnia.

#### Autenticación

##### Registrar Usuario

Para registrar un nuevo usuario en la aplicación:

- **Método**: POST
- **URL**: `http://localhost:8080/auth/register`
- **Cuerpo**:
  ```json
  {
    "login": "nombre_usuario",
    "password": "contraseña_secreta"
  }
  ```
- **Resultado Esperado**: Usuario registrado exitosamente.

#### Gestión de Temas

##### Crear Nuevo Tema

Para crear un nuevo tema de discusión:

- **Método**: POST
- **URL**: `http://localhost:8080/topics`
- **Cuerpo**:
  ```json
  {
    "titulo": "Título del Tema",
    "mensaje": "Contenido del mensaje",
    "curso": "JAVA"
  }
  ```
- **Resultado Esperado**: Tema creado correctamente.

### Pruebas Adicionales con swagge

- Puedes explorar todos los endpoints disponibles y sus descripciones en [Swagger UI](http://localhost:8080/swagger-ui/index.html).
![image](https://github.com/user-attachments/assets/6601ea81-4ce8-442f-bdc1-e166db4a43b0)
![image](https://github.com/user-attachments/assets/7a6f238d-d999-49c4-909e-147a49da5992)
![image](https://github.com/user-attachments/assets/68814bdf-f4fe-47b1-9816-916fb1a7e434)
![image](https://github.com/user-attachments/assets/de2bc061-a78a-4042-bfd3-6daae6dd5ab7)
### Dependencias

- Java 17
- Spring Boot 3.3.1
- MySQL Connector/J
- Spring Boot Starter Data JPA
- Spring Boot Starter Security
- Spring Boot Starter Validation
- Spring Boot Starter Web
- Spring Boot DevTools
- Lombok
- Spring Boot Starter Test
- Flyway Core
- Flyway MySQL
- Springdoc OpenAPI Starter Webmvc UI

## Clases Principales

### Curso

La clase `Curso` es un enum que define los cursos disponibles en el sistema, como Java, Python, JavaScript, HTML y PHP. Estos cursos categorizan los temas de discusión dentro del foro.

### Topico

La clase `Topico` representa un tema de discusión en el foro. Contiene atributos como título, mensaje, fecha de creación y curso asociado. Implementa la persistencia con JPA y utiliza anotaciones como `@Entity` y `@CreationTimestamp` para facilitar el almacenamiento y gestión de temas.

### Usuario

La clase `Usuario` modela a los usuarios del sistema. Implementa la interfaz `UserDetails` de Spring Security para la gestión de la autenticación y autorización. Contiene atributos como login y password, y utiliza el algoritmo BCrypt para el almacenamiento seguro de contraseñas.

## Configuración y Uso

Para ejecutar la aplicación localmente:

1. Clona este repositorio: `git clone https://github.com/tu-usuario/challenge-foro-hub.git`
2. Configura tu base de datos MySQL en el archivo `application.properties`, las base de datos, clave, usuario
3. Ejecuta la aplicación utilizando tu IDE preferido o ejecutando `mvn spring-boot:run` en la línea de comandos.


finalmente concluido el challenge
![Badge-Spring](https://github.com/user-attachments/assets/cb61cea2-ae08-48fd-82d3-a1acfeee5da8)


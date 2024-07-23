# Conexa Challenge

## Descripción del Proyecto

Aplicación Spring Boot para challenge de Conexa desplegada en Fly.io que utiliza Keycloak para la autenticación. La aplicación está diseñada para integrar con una API de Star Wars y proporciona una interfaz de usuario para interactuar con los datos de la API a través de Swagger.

### Tecnologías y Librerías Utilizadas

- **Spring Boot**: Framework principal para el desarrollo de aplicaciones Java.
- **Keycloak**: Solución de gestión de identidades y accesos para la autenticación y autorización.
- **Fly.io**: Plataforma para el despliegue y la gestión de la aplicación.
- **Feign**: Librería para realizar llamadas a APIs externas de manera declarativa.
- **JUnit**: Framework para la creación de pruebas unitarias.
- **Mockito**: Librería para la creación de mocks en pruebas unitarias.

### Pruebas

#### Pruebas de Integración

- **StarWarsVehicleControllerIntegrationTest**: Pruebas de integración para el controlador de vehículos de Star Wars, verificando la funcionalidad de los endpoints.
  - `testGetAllVehicles`: Verifica la obtención de todos los recursos de vehículos.
  - `testGetVehicleById`: Verifica la obtención de un recurso específico de vehículos por ID.
  - `testSearchVehicles`: Verifica la búsqueda de vehículos por nombre.

#### Pruebas Unitarias

- **StarWarsStarshipServiceImplTest**: Pruebas unitarias para el servicio de naves estelares de Star Wars.
  - `testGetStarshipById`: Verifica la obtención de una nave estelar específica por ID utilizando un mock de Feign client.

### Uso de la Colección de Postman

Para facilitar la interacción con la API de Star Wars, he creado una colección de Postman que incluye todas las solicitudes necesarias. Sigue los pasos a continuación para utilizar la colección:

1. **Descarga la colección de Postman**:
  - La colección se encuentra en el repositorio.

2. **Importa la colección en Postman**:
  - Abre Postman.
  - Haz clic en "Import" en la esquina superior izquierda.
  - Selecciona el archivo descargado de la colección.

3. **Configura el entorno**:
  - Al ejecutar cualquiera de los dos llamados a Keycloak, se guardará una variable global con el token de acceso.

4. **Ejecuta las solicitudes**:
  - La colección incluye varios endpoints agrupados por recursos (films, starships, people, vehicles).
  - Selecciona una solicitud y haz clic en "Send" para ejecutarla.

#### Capturas de pantalla de la colección de Postman:

- **Tutorial Postman**:
  ![Films](https://i.imgur.com/Aq8MRJN.jpeg)


### Enlaces

- **Swagger de la app**: [Swagger UI](https://azamma-conexa-challenge.fly.dev/swagger-ui/index.html?configUrl=/api-docs/swagger-config#/)
- **Keycloak propio en Fly.io**: [Keycloak](https://keycloak-conexa.fly.dev/admin/master/console/)

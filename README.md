# GestorEventos
Proyecto para gestionar eventos concretos , usuarios y envio de emails a estos.

## Partes principales del proyecto

![guf](https://github.com/user-attachments/assets/58beb225-8888-45be-91e7-b17d510ceff3)
![eventos](https://github.com/user-attachments/assets/e2a96d6e-2858-4f9c-bb45-00859797bc83)

## Descripción

El propósito de este proyecto es poder gestionar usuarios y eventos particulares para cada usuario además de proporcionar email a la hora de crear un evento y recordatorios una hora antes del evento.

## Funcionalidades

- **Autenticación de usuarios**: Registro, inicio de sesión y gestión de sesiones.
- **Área de eventos**: Gestión de eventos , creación y eliminación.
- **Sistema de en evio de emails**: Creación de emails en función de la creación de eventos por parte del usuario.

## Tecnologías Utilizadas

- **Backend**: Spring Boot
- **Base de Datos**: MySQL
- **Frontend**: Thymeleaf
- **Gestión de dependencias**: Maven
- **Estilos**: Bootstrap

## Versiones Utilizadas

- **Java**: 17
- **Maven**: 3.9.7
- **Spring Boot**: 3.3.2
- **Bootstrap**: 4.5.2

## Instalación

1. Clonar el repositorio:

    ```bash
    git clone https://github.com/pbl99/GestorEventos.git
    cd GestorEventos
    ```

2. Compilar el proyecto:

    ```bash
    mvn clean install
    ```

3. Ejecutar la aplicación:

    ```bash
    mvn spring-boot:run
    ```

4. Acceder a la aplicación:

    Abre tu navegador web y navega a [http://localhost:8080](http://localhost:8080).

## Configuración

### Email config
Según esta hecho el proyecto se necesita crear un archivo email.properties en resources con : 
```
mail.username= tu email de google
mail.password= contraseña de la aplicación
```
!Importante este proyecto esta configurado para ser usado con google se necesita una cuenta de google y la creación de contraseñas de aplicación 

### Base de Datos

Por defecto, la aplicación usa una base de datos MySQL. Puedes cambiar la configuración de la base de datos en el archivo `application.properties` ubicado en `src/main/resources/`.

Ejemplo de configuración para MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nombre_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```
## Modelo Relacional

A continuación se muestra el modelo relacional de la base de datos utilizada en este proyecto:

![modelorelacional](https://github.com/user-attachments/assets/d7bc7deb-1306-444b-9505-7fecf8ecdc28)

## Contribuir
Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1. Fork el repositorio
2. Crea una nueva rama (git checkout -b feature/nueva-funcionalidad)
3. Realiza tus cambios y haz commit (git commit -am 'Añadir nueva funcionalidad')
4. Push a la rama (git push origin feature/nueva-funcionalidad)
5. Crea un Pull Request 

## Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

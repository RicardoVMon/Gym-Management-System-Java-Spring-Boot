# Aplicación Web de Gestión de Gimnasio

Esta aplicación web, construida utilizando Java Spring Boot, está diseñada para facilitar la gestión de la relación entre entrenador y usuario dentro de un entorno de gimnasio. Proporciona funciones para que los administradores asignen rutinas predefinidas a los usuarios, gestionen ejercicios dentro de estas rutinas y mantengan una lista de ejercicios que pueden agregarse a las rutinas mediante operaciones CRUD. Además, los administradores tienen la capacidad de eliminar usuarios de la base de datos.

## Características

- **Autenticación de Usuario**: La aplicación incluye un sólido sistema de inicio de sesión y registro para nuevos usuarios.
- **Gestión de Rutinas**: Los administradores pueden asignar rutinas predefinidas a los usuarios.
- **Gestión de Ejercicios**: Los administradores pueden asignar ejercicios a rutinas y gestionar la lista de ejercicios disponibles.
- **Funciones de Usuario**: Los usuarios normales pueden ver sus rutinas asignadas, ejercicios dentro de ellas y acceder a una sección para estiramientos antes o después del entrenamiento.
- **Seguimiento de Medidas**: Los usuarios pueden realizar un seguimiento de las medidas de su cuerpo a lo largo del tiempo.

## Tecnologías Utilizadas

- **Java Spring Boot**: Proporciona el marco para construir aplicaciones web robustas y escalables.
- **Spring Security**: Gestiona la autenticación y autorización.
- **Spring Data JPA**: Simplifica el acceso a datos proporcionando una implementación de repositorio para trabajar con datos.
- **Thymeleaf**: Utilizado para la representación de plantillas Java en el lado del servidor.
- **MySQL**: Sistema de gestión de bases de datos para almacenar datos de la aplicación.
- **Bootstrap**: Librería de diseño UI/UX.

## Instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/RicardoVMon/Workout-Tracker-PrograWeb
   ```

2. Navega hasta el directorio del proyecto:

   ```bash
   cd directorio\Workout-Tracker-PrograWeb
   ```

3. Configura las propiedades de la aplicación:

   Actualiza el archivo `application.properties` con los detalles de configuración de tu base de datos.

4. Construye la aplicación:

   ```bash
   mvn clean install
   ```

5. Ejecuta la aplicación:

   ```bash
   java -jar target/aplicacion.jar
   ```

6. Accede a la aplicación en tu navegador web en `http://localhost:80`.

## Uso

1. **Inicio de Sesión o Registro**: Los nuevos usuarios deben registrarse, mientras que los usuarios existentes pueden iniciar sesión utilizando sus credenciales.

2. **Acciones del Administrador**:
   - Asignar rutinas a usuarios.
   - Gestionar ejercicios dentro de rutinas (agregar, eliminar, actualizar).
   - Operaciones CRUD en la lista de ejercicios disponibles.
   - Eliminar usuarios de la base de datos.

3. **Acciones de Usuario**:
   - Ver rutinas y ejercicios asignados.
   - Acceder a estiramientos antes o después del entrenamiento.
   - Realizar un seguimiento de las medidas corporales a lo largo del tiempo.

## Soporte

Para cualquier problema o consulta, por favor generar un issue en el repositorio.

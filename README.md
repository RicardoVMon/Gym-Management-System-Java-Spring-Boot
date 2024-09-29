---

# Gym Management Web Application

This web application, built using Java Spring Boot, is designed to facilitate the management of trainer-user relationships in a gym environment. It provides features for administrators to assign predefined routines to users, manage exercises within those routines, and maintain a list of exercises that can be added to the routines through CRUD operations. Additionally, administrators have the ability to remove users from the database.

## Features

- **User Authentication**: The app includes a robust login and registration system for new users.
- **Routine Management**: Administrators can assign predefined routines to users.
- **Exercise Management**: Administrators can assign exercises to routines and manage the list of available exercises.
- **User Functions**: Regular users can view their assigned routines, exercises within them, and access a section for warm-up or cool-down stretches.
- **Measurement Tracking**: Users can track their body measurements over time.

## Technologies Used

- **Java Spring Boot**: Provides the framework for building robust and scalable web applications.
- **Spring Security**: Manages authentication and authorization.
- **Spring Data JPA**: Simplifies data access by providing a repository implementation for working with data.
- **Thymeleaf**: Used for server-side Java template rendering.
- **MySQL**: Database management system for storing application data.
- **Bootstrap**: UI/UX design library.

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/RicardoVMon/Workout-Tracker-PrograWeb
   ```

2. Navigate to the project directory:

   ```bash
   cd directory\Workout-Tracker-PrograWeb
   ```

3. Import the database dump:

   You need to import the `Database Script.sql` file into MySQL. First, ensure MySQL is running, then execute the following commands in the MySQL console:

   ```bash
   mysql -u root -p
   ```

   After logging in, run:

   ```bash
   source /path/to/Database Script.sql;
   ```

   This will import the dump and create the necessary tables for the application.

4. Configure database permissions:

   After importing the database, create a user and grant them the necessary permissions by running the following commands in the MySQL console:

   ```sql
   CREATE USER 'admin_proyecto'@'localhost' IDENTIFIED BY 'admin_clave';

   GRANT ALL PRIVILEGES ON gymapp.* TO 'admin_proyecto'@'localhost';

   FLUSH PRIVILEGES;
   ```

   Replace `'admin_clave'` with a more secure password if desired.

5. Update `application.properties`:

   Update the `src/main/resources/application.properties` file with your database configuration details:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/gymapp
   spring.datasource.username=admin_proyecto
   spring.datasource.password=admin_clave
   ```

6. Build the application:

   ```bash
   mvn clean install
   ```

7. Run the application:

   ```bash
   java -jar target/application.jar
   ```

8. Access the application in your web browser at `http://localhost:80`.

## Usage

1. **Login or Register**: New users need to register, while existing users can log in with their credentials.

2. **Administrator Actions**:
   - Assign routines to users.
   - Manage exercises within routines (add, delete, update).
   - CRUD operations on the available exercises list.
   - Remove users from the database.

3. **User Actions**:
   - View assigned routines and exercises.
   - Access warm-up or cool-down stretches.
   - Track body measurements over time.

## Support

For any issues or questions, please create an issue in the repository.

---

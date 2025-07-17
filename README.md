# HibernateProject

This project demonstrates the use of Hibernate ORM in Java for basic CRUD operations and HQL queries. It includes entity classes, configuration files, and example usage of Hibernate features.

## Project Structure

```
pom.xml                  # Maven build configuration
src/
  main/
    java/
      com/sahin/
        Alien.java        # Entity class
        Laptop.java       # Entity class
        Student.java      # Entity class
        Main.java         # Main application entry point
        HQL/
          Demo.java       # HQL query examples
          Laptop_From_HQL.java # HQL query for Laptop entity
    resources/
      hibernate.cfg.xml   # Hibernate configuration file
  test/
    java/                # (Optional) Test classes
```

## Technologies Used
- Java
- Hibernate ORM
- Maven

## Setup Instructions
1. **Clone the repository**
2. **Configure Database**: Update `hibernate.cfg.xml` with your database connection details.
3. **Build the project**:
   ```bash
   mvn clean install
   ```
4. **Run the application**:
   - Execute `Main.java` or HQL demo classes from your IDE or using Maven exec plugin.

## Features
- Entity mapping for `Alien`, `Laptop`, and `Student`
- Hibernate configuration via XML
- HQL query examples
- Basic CRUD operations

## Notes
- Ensure your database is running and accessible as per the configuration.
- You may need to adjust the JDBC driver dependency in `pom.xml` for your database.

## License
This project is for educational purposes.


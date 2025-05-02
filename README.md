# Student Management API

RESTful API built with Java Spring Boot, JPA, and PostgreSQL to manage student information. Implements operations to create, list, retrieve, update, and delete student records, with exception handling and data validation, following REST standards and best practices in Spring development.

## Features

- Create, list, retrieve, update, and delete student records (CRUD)
- Exception handling with custom error responses
- Data validation for all input fields
- Follows RESTful principles and best practices
- Built with Java Spring Boot, JPA, and PostgreSQL

## Technologies

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Bean Validation (Jakarta Validation)
- Lombok (optional)

## Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/Student-s-Management-API.git
   cd Student-s-Management-API


   Configure the database:
Create a PostgreSQL database (e.g., escola_db)
Update the src/main/resources/application.properties file with your database credentials:
spring.datasource.url=jdbc:postgresql://localhost:5432/escola_db
spring.datasource.username=your_username
spring.datasource.password=your_password

Build and run the application:

./mvnw spring-boot:run

mvn spring-boot:run

API Endpoints

GET	/api/alunos :	List all students
GET	/api/alunos/{id} :	Get student by ID
POST	/api/alunos	: Create a new student
PUT	/api/alunos/{id}:	Update student by ID
DELETE	/api/alunos/{id}:	Delete student by ID

Example JSON

{
  "nome": "Maria Oliveira",
  "email": "maria@email.com",
  "matricula": "2024002",
  "telefone": "(11) 98888-7777",
  "curso": "Computer Science"
}

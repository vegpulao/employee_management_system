# Employee Management System API

## Project Overview

The Employee Management System API is a RESTful backend application developed using Spring Boot. It provides secure management of employees, tasks, and leave requests through JWT-based authentication and role-based authorization. The application follows a layered architecture using Controllers, Services, Repositories, DTOs, and Mappers to ensure maintainability and scalability.

---

## Features

- JWT-based user authentication and authorization.
- Secure password encryption using BCrypt.
- Employee management with complete CRUD operations.
- Task management with complete CRUD operations.
- Leave request management with complete CRUD operations.
- Search employees by name, department, and designation.
- Search tasks by title, priority, and status.
- Search leave requests by status.
- Pagination support for employee and task records.
- Bean validation for request validation.
- Global exception handling.
- Swagger UI for API documentation.
- DTO architecture for secure request and response handling.

---

## Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- JWT (JJWT)
- MySQL
- Maven
- Swagger (Springdoc OpenAPI)

---

## Project Structure

```
src
├── config
├── controller
├── dto
├── entity
├── exception
├── mapper
├── repository
├── security
├── service
└── EmployeeManagementApplication
```

---

# Setup Instructions

## 1. Clone the Repository

```bash
git clone https://github.com/<your-username>/<repository-name>.git
```

## 2. Open the Project

Open the project using IntelliJ IDEA or any Java IDE.

## 3. Configure Database

Update the MySQL configuration inside:

```
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```

## 4. Create Database

Create a MySQL database named:

```
employee_management
```

Alternatively, execute the provided **schema.sql** script.

## 5. Run the Application

```bash
mvn spring-boot:run
```

The application starts at:

```
http://localhost:8080
```

---

# Database Configuration

Database: MySQL

Hibernate:

```
spring.jpa.hibernate.ddl-auto=update
```

Database Script:

```
schema.sql
```

---

# API Documentation

Swagger UI

```
http://localhost:8080/swagger-ui/index.html
```

---

# API List

## Authentication

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /auth/register | Register a new user |
| POST | /auth/login | Login and receive JWT |

---

## Employee

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /employees | Create employee |
| GET | /employees | View all employees |
| GET | /employees/{id} | View employee by ID |
| PUT | /employees/{id} | Update employee |
| DELETE | /employees/{id} | Delete employee |
| GET | /employees/search/name/{name} | Search by name |
| GET | /employees/search/department/{department} | Search by department |
| GET | /employees/search/designation/{designation} | Search by designation |
| GET | /employees/page | Paginated employees |

---

## Tasks

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /tasks | Create task |
| GET | /tasks | View all tasks |
| GET | /tasks/{id} | View task by ID |
| PUT | /tasks/{id} | Update task |
| DELETE | /tasks/{id} | Delete task |
| GET | /tasks/search/title/{title} | Search by title |
| GET | /tasks/search/priority/{priority} | Search by priority |
| GET | /tasks/search/status/{status} | Search by status |
| GET | /tasks/page | Paginated tasks |
| GET | /tasks/employee/{employeeId} | Tasks by employee |

---

## Leave Requests

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /leaves | Apply leave |
| GET | /leaves | View all leave requests |
| GET | /leaves/{id} | View leave request |
| PUT | /leaves/{id} | Update leave request |
| DELETE | /leaves/{id} | Delete leave request |
| GET | /leaves/search/status/{status} | Search leave by status |

---

# Future Enhancements

- Refresh Token authentication.
- File upload support for employee profile pictures and documents.
- Advanced filtering and sorting for all modules.
- Docker containerization for simplified deployment.
- Role-specific dashboards and permissions.
- Stricter role-specific authorities

---

# Author

**Darius**

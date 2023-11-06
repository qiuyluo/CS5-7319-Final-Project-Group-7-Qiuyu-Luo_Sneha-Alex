# CS5-7319-Final-Project-Group-7-Qiuyu-Luo_Sneha-Alex

LibraryTech is a library website that offers personalized book recommendations based on hold history, provides basic functions such as login, book search and homepage browsing.

## Prerequisites

- Java JDK (version 19.0.2)
- Maven (version 3.9.0)
- Spring Boot (version 3.1.5)
- Node.js (version 18.16.0)
- PostgreSQL (version 14)

## Installation

Instructions for setting up the development environment.

### Backend (Spring Boot)

1. Download and install Java JDK from [Download link](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. Install Maven from [Maven download page](https://maven.apache.org/download.cgi) and configure environment variables.
3. Clone the repository to your local machine:
   ```
   git clone [repository url]
   ```

### Frontend (React)

1. Download and install Node.js from [Node.js download page](https://nodejs.org/).
2. Navigate to the frontend directory:
   ```
   cd frontend
   ```
3. Install dependencies:
   ```
   npm install
   ```

### Database (PostgreSQL)

Download and install PostgreSQL from [PostgreSQL download page](https://www.postgresql.org/download/).

## Configuration

### application.properties setup

Before running the application locally, you need to configure your database settings in the `application.properties` file located in the `src/main/resources` directory. The default configuration is set up for PostgreSQL with the following properties:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/LibraryTech
spring.datasource.username=postgres
spring.datasource.password=qiuyluo
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
```

Please update these properties to match your local PostgreSQL setup:

```properties
spring.datasource.url: This property defines the URL for your database. Replace 5433 with the port number where your PostgreSQL server is running.
spring.datasource.username: Change postgres to the username that you use for your PostgreSQL database.
spring.datasource.password: Replace qiuyluo with the password corresponding to your PostgreSQL database user.
```

### PostgreSQL database setup

1. The file `src/main/resources/sql/data.sql` is a comprehensive script for initializing the database schema and populating it with sample data. It includes SQL statements for creating tables, inserting initial records, and setting up any necessary database relationships.
2. Use query tool in pgAdmin to run `data.sql`. This will create three tables: books, holds, users and initialize the dataset to support the book recommendation algorithm.

## Running the Application

### Compiling the Code

Instructions for compiling the project with Maven:

```shell
mvn clean install
```

### Access the application

1. base URL: `http://localhost:8080`
2. Upon the initial launch, a default username `user` is created, and a security password is generated and logged in the console output. Please search the console logs for `Using generated security password:` to find the temporary password.

![67ac0232d3cbd9f7d1ab5475a01e18c](https://github.com/qiuyluo/CS5-7319-Final-Project-Group-7-Qiuyu-Luo_Sneha-Alex/assets/113461826/0f566204-4d5f-43aa-9422-0266512429c1)

The generated password is unique to each run.

# Difference between two selected styles

The two architecture designs we chose to implement are a two tier client-server design and a three-tier model. While both designs are similar in that they both have a set frontend and a set backend, they are significantly different in their functionality.
The client-server design consists of a frontend and a backend. This design is simple to implement and to maintain. However, its simplicity comes with limited functionality, such as a lack of user authentication.
In contrast, the three-tier structure has a more complex design to implement and maintain. But with this complexity comes additional functionality. The added business layer between the frontend and backend layers gives the program a faster execution time as well as the capability to handle more complex logic and fucntions.

# final selection rationale

In the end, we determined that the three-tier architecture was better suited to our program's needs. Despite its complexity, the three-tier architecture has added functionality that suits the requirements of our program idea. We need to be able to handle personalized user functions, which means we need to to be able t handle user authentication. This is possible with the three-tier architecture, but not with the two-tiered client-server architecture. Therefore we decided that the three-tier architecture better suits our needs.

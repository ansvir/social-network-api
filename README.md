## Social Network Post API project
### Version: 0.0.1-SNAPSHOT

### Description
Project developed in illustration purposes. CRUD application with ability
to request top X social posts ordered descending by amount of views

Use Swagger to investigate API : http://localhost:8080/api/v2/api-docs.

### How to launch
1. Using command line:
   2. You need preinstalled JRE on your machine and cloned project
   3. Navigate to project root folder and run: `mvn clean install` -> `mvn spring-boot:run`
2. Launch JAR:
   3. Follow steps from first instruction, but instead of two
### Brief project architecture
```mermaid
+-----------------------+
|        Server         |
|                       |   
|   +---------------+   |    Response       +---------------+       
|   |     SNP API   | --|---------------->> |               |
|   |               | <<|------------------ |     Client    |
|   +---------------+   |    Request        |               |
|   |     Tomcat    |   |                   |               |
|   +---------------+   |                   +---------------+
|           |           |
|           |           |
|           |           |
|           |           |
|           |           |
|      /---------\      |
|     /    H2     \     |
|    |_____________|    |
|    |_____________|    |
|    |_____________|    |
|                       |
+-----------------------+
```
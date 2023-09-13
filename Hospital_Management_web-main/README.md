# Hospital_Management_web

#Technology
.Springboot
.hibernate
.mysql

#Dependency
For-Mysql
-------------
<dependency>
  <groupId>com.mysql</groupId>
  <artifactId>mysql-connector-j</artifactId>
  <scope>runtime</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
    <version>3.1.2</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.modelmapper/modelmapper -->
<dependency>
    <groupId>org.modelmapper</groupId>
    <artifactId>modelmapper</artifactId>
    <version>3.1.1</version>
</dependency>


#Configure Spring Datasource, JPA, App properties

spring.datasource.url=jdbc:mysql://localhost:3306/SVS
spring.datasource.username=root
spring.datasource.password=1234
spring.jpa.database-platform=org.hibernate.dialect.MySQL57Dialect
spring.jpa.generate-ddl=true
spring.jpa.show-sql=true
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
server.port=8086


#Run Spring Boot application

mvn spring-boot:run


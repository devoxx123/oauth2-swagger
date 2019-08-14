# Spring-oauth2-jpa-example
A simple and basic example  to secure REST APsI with authentication using Spring Boot , Security , OAuth2 and JPA.
You can find more about this topic on official spring documentation:

# Techonology Stack
----------------
1.Java 1.8
2.JPA 2.0
3.SpringBoot 2.0
4.Spring Data JPA,
5.RESTful,
6.Spring Security,
7.OAuth 2.0
8.MYSQL 5.7
9.RestTemplate(Client or Consumer)
10.Swagger UI,
11.Postman Rest Client 6.0
12.Newman (Running collection.json)


# RESTful EndPoints
------------------
POST---http://localhost:8080/user/adduser

POST---http://localhost:8080/user/login

POST---http://localhost:8080/user/updatepwd

POST---http://localhost:8080/user/fileupload

GET----http://localhost:8080/user/listofaccounts

GET----http://localhost:8080/user/getaccbyid/{{ID}}

GET----http://localhost:8080/user/getbyname/{{name}}

PUT----http://localhost:8080/user/update/{{ID}}

DELETE-http://localhost:8080/user/delete/{{ID}}


Swagger URLs
-------------
http://localhost:8080/v2/api-docs
http://localhost:8080/swagger-ui.html



five core concepts in Spring Security
--------------------------------------
1. Authentication
2. Authorization
3. Principal
4. Granted Authority
5. Roles

Client id: defines the id of the client application that is authorized to authenticate, the client application provides this in order to be allowed to send a request to the server.

Client secret: is the client application’s password. In a non-trivial implementation client ids and passwords will be securely stored in a database and retrievable through a separate API that clients applications access during deployment.

Grant type: we define the grant type password here because it’s not enabled by default.

The scope: read/write defines the level of access we are allowing to resources.

Resource Id: The resource id specified here must be specified on the resource server as well.

AuthenticationManager: Spring’s authentication manager takes care of checking user credential validity.


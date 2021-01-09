# About this repository

This is an API made using the following techs:

- Java
- Spring Boot
- Spring Web
- Spring JPA/Hibernate
- Database H2

## What you’ll need
To use it, you just need to clone this repository and have the Java Development Kit (JDK) 8 +

##After all, what is it?

This application will listen to your host constantly. If you use the HTTP POST method considering the endpoint **/clients**, you will see the response for that call.

example of call: localhost:8080/clients

**A valid call needs an object with the following properties:**
- name;
- email;
- cpf;
- dateOfbirth;

**There is little data validation in this call. I will list two of them:**

- They cannot all be blank and the email and cpf must be valid based on Hibernate validation.

- This application does not accept duplicate cpfs and emails.

That's it. Any questions, please, let me know.

Emerson Vitorio
## Purplist

Purplist is an application designed to share multipurpose lists between users.

Users can add new items to their lists, which can later be checked/unchecked.

To share a list with friends, all you need to do is send an invitation knowing your friend's nickname.

----------------------------
Currently, mainly the backend of the application has been created. It is a hobby project under development.

To create the database needed to run the project, run the ```create_database_for_purplist.sql``` script in your MySql database and fill all the ```spring.datasource``` in the data in the ```application.properties``` file accordingly.

----------------------------
### From the developer's side
#### Technologies Used

- **Java 17**: Primary programming language.
- **Spring Boot 3.1.2**:
  - Web framework for building the application.
  - Modules used:
    - Web
    - Data JPA
    - Thymeleaf
    - Security
    - DevTools
- **Form-Based authentication**: simple authentication to store data in sql
- **MySQL**: Relational database for data storage.
- **Hibernate**: ORM tool used via Spring Data JPA.
- **Thymeleaf**: Template engine for server-side rendering of HTML.
- **Lombok**: Reduces boilerplate Java code.
- **Maven**: Dependency and build management tool.
- **Jackson**: JSON serialization and deserialization.
- **Jakarta Persistence API (JPA)**: For mapping Java objects to relational database tables.

#### Functionalities
- [x] Login to your own account
- [x] Viewing the data of a logged-in user
- [x] Ability to add, edit and delete Purplists
- [x] Mechanism for inviting friends to the list
    - sending invitations
    - acceptance/refusal
    - preview of invitation status
- [x] User roles giving different rights after signing up to the application
- [x] Possibility to moderate all the data using api for admin user


#### Potential future work
- [ ] Registration with password validation
- [ ] Assigning roles to individual list members (admin/viewer/editor)




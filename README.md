For the front end, visit https://github.com/MochiCircle/social-media-app-frontend.

# Revature Social Network

In Revature's Social Network everyone is friends with everyone else. Users can register, login to the application, and start sharing multimedia with everyone. Registered users are allowed to modify their personal information and upload their profile pictures. The application provides a search feature that allows users to search out friends and look at their profiles. Users are provided with a "feed", in which they can see what everyone is posting and like posts. Users can access and use the application via an interactive client-side single paged application that stores and retrieves multimedia using AWS S3 and consumes a RESTful web service that provides business logic and access to a database.

## Technologies Used
- Java
- Hibernate
- Spring
- SQL
- JUnit
- Log4J
- AWS SDK
- JavaMail
- Mockito
- Agile-Scrum

To-do list:
- Improve security
- Extensive documentation
- Further test coverage
- Set up SonarCloud

## Getting Started
1. Open up your terminal and navigate to desired folder to copy the project using `cd /(location)`.
2. run `git clone https://github.com/MochiCircle/social-media-app-backend.git`.
3. Open up project in your desired Java IDE.
4. Navigate to .\social-media-app-backend\src\main\webapp\WEB-INF\applicationContext.xml and edit lines 38-41 to match the credentials of your own database:
```xml
<property name="url" value="jdbc:postgresql://myEndpoint:5432/myDatabase" />
<property name="username" value="myUsername" />
<property name="password" value="myPassword" />
```
5. In the same file, edit line 54 in the .xml file to `<prop key="hibernate.hbm2ddl.auto">create</prop>`. Once the tables are created, change it back to `none`.
6. Set up IAM credentials to access your own s3 bucket. (https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-files.html)
7. Install Apache Tomcat (or equivalent) and run the project through localhost. See Apache documentation for more info.

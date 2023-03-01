## This app was built as a code challenge for ConnectBase Java position.

# Java 17
# MySQL
# IntelliJ IDE
# Git
# Postman
- GET: http://localhost:8080/user/{loginId}
- POST: http://localhost:8080/user
- PUT: http://localhost:8080/user
- body of the requests:
  {
  "loginId": "string",
  "fullName": "string",
  "dob": "2023-03-01T00:57:31Z",
  "gender": "F"
  }

1. Clone the repository to you local machine.
2. Set up your MySql and update application.properties file with your database and credentials.
3. Run mvn clean install on you IntelliJ IDE terminal.
4. Run the app and make requests through postman.
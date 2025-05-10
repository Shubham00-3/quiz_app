

## **Quiz App**

### **Introduction**
The Quiz App is a Spring Boot-based backend API that allows users to start a quiz, retrieve random multiple-choice questions, submit answers, and track their performance. It is designed as a lightweight application with in-memory H2 database integration.

---

### **Features**
- Start a new quiz session.
- Retrieve random quiz questions from a predefined set.
- Submit answers and get immediate feedback.
- View quiz stats: number of correct and incorrect answers.

---

### **Technologies Used**
- **Spring Boot**: Backend framework for creating RESTful APIs.
- **H2 Database**: In-memory database for storing questions and session data.
- **Java**: Core programming language.
- **Maven**: Dependency and project management tool.
- **JUnit**: Testing framework for unit tests.

---

### **Project Structure**
- **Controller Layer**: Handles incoming API requests.
- **Service Layer**: Implements business logic for quiz management.
- **Repository Layer**: Manages data access and persistence using Spring Data JPA.
- **Model Layer**: Defines the structure of questions and quiz sessions.

---

### **Setup Instructions**
1. **Clone the Repository**:
    ```bash
    git clone https://github.com/Shubham00-3/quiz_app.git
    ```
2. **Navigate to the Project Directory**:
    ```bash
    cd quiz_app
    ```
3. **Build the Project**:
    ```bash
    mvn clean install
    ```
4. **Run the Application**:
    ```bash
    mvn spring-boot:run
    ```

5. Access the API at `http://localhost:8080`.

---

### **API Endpoints**
1. **Start a Quiz Session**  
   **POST** `/api/quiz/start?userId=<user_id>`  
   Start a new quiz session for the specified user.

2. **Get a Random Question**  
   **GET** `/api/quiz/question`  
   Retrieve a random multiple-choice question.

3. **Submit an Answer**  
   **POST** `/api/quiz/submit?sessionId=<session_id>&questionId=<question_id>&selectedOption=<option_number>`  
   Submit the user's answer for evaluation.

4. **Get Quiz Stats**  
   **GET** `/api/quiz/stats?sessionId=<session_id>`  
   View the number of correct and incorrect answers for the session.

---

### **Testing**
Run the included JUnit tests to verify functionality:
```bash
mvn test


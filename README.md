
# 🗳️ VoteGo – Online Voting System (Spring Boot Backend)

**VoteGo** is a Spring Boot–based RESTful backend application that allows citizens to vote securely, view candidates, and see real-time election results. Designed using layered architecture and JPA entity relationships, it ensures maintainability, scalability, and robustness.

---

## 📌 Features

- ✅ Voter registration & management
- ✅ Candidate registration & management
- ✅ Vote casting with validations
- ✅ Real-time election result declaration
- ✅ DTO-based clean data flow
- ✅ Centralized exception handling
- ✅ Validation with meaningful error messages

---

## ⚙️ Tech Stack

| Technology          | Version     |
|---------------------|-------------|
| Java                | 17          |
| Spring Boot         | 3.5.0       |
| Spring Data JPA     | ✅          |
| Hibernate Validator | ✅          |
| MySQL               | 8+          |
| Maven               | Build Tool  |
| Lombok              | ✅          |

---

## 🗂️ Project Structure

```
com.ahmad.projects.votego
├── controller            # REST endpoints
├── service               # Business logic
├── dto                   # Request/Response objects
├── exception             # Custom exception handling
├── entities              # JPA entity classes
├── repository            # Spring Data JPA Repositories
└── VotingApplication.java  # Main class
```

---

## 🧩 Entity Relationships

| Entity          | Relationship                           |
|-----------------|----------------------------------------|
| `Voter`         | `@OneToOne` → Vote                     |
| `Vote`          | `@ManyToOne` → Candidate<br>`@OneToOne` → Voter |
| `Candidate`     | `@OneToMany` → Vote<br>`@OneToOne` → ElectionResult |
| `ElectionResult`| `@OneToOne` → Candidate (Winner)       |

---

## 🌐 REST API Endpoints

### 🧑‍💼 Voter APIs

| Method | Endpoint              | Description            |
|--------|------------------------|------------------------|
| POST   | `/api/v1/voter/add`    | Register a new voter   |
| GET    | `/api/v1/voter/get`    | Get all voters         |
| GET    | `/api/v1/voter/get/{id}` | Get voter by ID        |
| PUT    | `/api/v1/voter/update/{id}` | Update voter       |
| DELETE | `/api/v1/voter/delete/{id}` | Delete voter       |

### 🧾 Vote APIs

| Method | Endpoint              | Description            |
|--------|------------------------|------------------------|
| POST   | `/api/v1/vote/cast`    | Cast a vote            |
| GET    | `/api/v1/vote/get`     | Get all votes          |

### 🧑‍💼 Candidate APIs

| Method | Endpoint                | Description              |
|--------|--------------------------|--------------------------|
| POST   | `/api/v1/candidate/add`  | Add a new candidate      |
| GET    | `/api/v1/candidate/get`  | Get all candidates       |
| GET    | `/api/v1/candidate/get/{id}` | Get candidate by ID |
| PUT    | `/api/v1/candidate/update/{id}` | Update candidate |
| DELETE | `/api/v1/candidate/delete/{id}` | Delete candidate |

### 🗳️ Election Result APIs

| Method | Endpoint                | Description                  |
|--------|--------------------------|------------------------------|
| POST   | `/api/v1/er/dr`          | Declare election result      |
| GET    | `/api/v1/er/get`         | Get all election results     |

---

## 🔒 Validation & Exception Handling

- Uses `@Valid`, `@NotBlank`, `@Email` for request validation
- Centralized exception handling using `@ControllerAdvice`
- Custom exceptions:
  - `ResourceNotFoundException`
  - `VoteNotAllowedException`
  - `DuplicateResourceException`
- Proper HTTP status codes and messages

---

## 🛠️ How to Run the Project Locally

1. **Clone the Repo**
   ```bash
   git clone https://github.com/Ahmad-Raza810/VoteGo-Backend.git
   cd VoteGo-Backend
   ```

2. **Configure MySQL**
   Create a database named `votego`.

3. **Edit `application.properties`**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/votego
   spring.datasource.username=root
   spring.datasource.password=ahmad1234
   spring.jpa.hibernate.ddl-auto=update
   ```

4. **Build & Run**
   ```bash
   mvn spring-boot:run
   ```

5. **Test APIs**
   Use Postman or Swagger (you can add Swagger config later).

---

## 🧪 Testing

- Manual testing via Postman
- Validation and exception paths covered
- You can extend with:
  - `JUnit 5` for unit testing
  - `Mockito` for service layer testing

---

## 💡 Future Enhancements

- 🔐 JWT-based authentication for admin/voters
- 📊 Admin dashboard
- 📧 Email verification
- 📈 Pagination and search filters
- 📄 Export results as PDF

---

## 👨‍💻 Author

**Ahmad Raza**  
📍 India  
💻 [GitHub Profile](https://github.com/Ahmad-Raza810)

---

> 🚀 VoteGo empowers a secure, flexible digital voting experience and serves as a full-stack backend demo for real-world elections or polls.

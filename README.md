# 🚀 Resume Analyzer – AI-Powered Career Growth Assistant

An AI-powered web application that helps users analyze resumes, identify skill gaps, explore career opportunities, and organize their professional learning journey.

Built using **Java, Spring Boot, MySQL, Thymeleaf, and Groq AI**.

## 📌 Project Overview

Resume Analyzer is a career assistance platform designed to help students and job seekers understand how their resumes align with target job descriptions.

The application provides AI-assisted resume analysis, estimated job matching, skill improvement suggestions, job-role guidance, and personal career organization tools.

## ✨ Key Features

### 1. AI Resume Analysis
- Upload PDF and DOCX resumes.
- Extract text from uploaded documents.
- Analyze resumes using Groq AI when configured.
- Compare resume content against a target job description.
- Display an estimated resume match percentage.
- Identify matching and missing skills.
- Provide suggestions for improvement.

### 2. Career and Job Research
- Explore suitable job roles based on skills.
- Get career guidance and role suggestions.
- Access external job-search platforms.

### 3. Learning Diary
- Record daily learning activities.
- Save topics and hours spent learning.
- Maintain a personal learning history.

### 4. Calendar Highlights
- Save interviews, examinations, deadlines, and important events.
- Store event dates and descriptions.
- Save reminder preferences.

### 5. Personal Notes
- Create and save notes.
- View previously saved notes.
- Delete notes when no longer needed.

### 6. User Authentication
- User registration and login.
- Secure password hashing.
- Logout functionality.
- User-specific data management.

## 🛠️ Technologies Used

| Category | Technology |
|---|---|
| Backend | Java, Spring Boot |
| Frontend | HTML, CSS, Thymeleaf |
| Database | MySQL 8 |
| AI Integration | Groq API |
| Security | Spring Security |
| ORM | Spring Data JPA, Hibernate |
| Build Tool | Maven |
| Document Processing | Apache PDFBox, Apache POI |
| Development Environment | Visual Studio Code |

## 📂 Project Structure

```text
ResumeAnalyzer/
│
├── src/
│   └── main/
│       ├── java/com/resumeanalyzer/
│       │   ├── config/
│       │   ├── controller/
│       │   ├── model/
│       │   ├── repository/
│       │   ├── service/
│       │   └── ResumeAnalyzerApplication.java
│       │
│       └── resources/
│           ├── static/css/
│           ├── templates/
│           └── application.properties
│
├── .gitignore
├── pom.xml
└── README.md
```

## ⚙️ Requirements

Install the following before running the application:

- JDK 17 or later
- Apache Maven 3.9+
- MySQL Server 8.x
- Visual Studio Code
- Java and Spring Boot extensions for VS Code

JDK 27 is also suitable for this project.

## 🗄️ Database Configuration

1. Start your MySQL Server.
2. Open MySQL Workbench.
3. Execute:

```sql
CREATE DATABASE resume_analyzer;
```

Configure your database environment variables in PowerShell:

```powershell
$env:DB_URL="jdbc:mysql://localhost:3306/resume_analyzer?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"
$env:DB_USERNAME="root"
$env:DB_PASSWORD="YOUR_MYSQL_PASSWORD"
```

Replace the password placeholder with your actual MySQL password.

## 🤖 Groq AI Configuration

To enable AI-powered resume analysis, configure your private Groq API key:

```powershell
$env:GROQ_API_KEY="YOUR_GROQ_API_KEY"
$env:GROQ_MODEL="openai/gpt-oss-120b"
```

Without a Groq API key, the application can use its basic keyword-analysis fallback.

**Security:** Never commit API keys, database passwords, or other secrets to GitHub.

## ▶️ How to Run the Project

### Step 1: Clone the repository

```bash
git clone https://github.com/kaveri-bh/Resume-Analyzer.git
```

### Step 2: Open the project folder

```bash
cd Resume-Analyzer
```

### Step 3: Verify Maven

```bash
mvn -version
```

### Step 4: Run the application

```bash
mvn clean spring-boot:run
```

### Step 5: Open the application

Visit:

http://localhost:8080

Register a new account and start using Resume Analyzer.

## 🔒 Security and Privacy

- Passwords are stored using BCrypt hashing.
- Application secrets should be provided through environment variables.
- User records are associated with the authenticated account.
- Do not upload confidential resumes to an untrusted deployment.

## ⚠️ Current Limitations

- Resume match percentage is an estimate, not an official employer ATS score.
- Job Research provides role guidance and external job-board links, not live vacancy data.
- Calendar reminder preferences are stored, but automatic browser and email notifications are not implemented.
- Notes currently support creating and deleting entries.

## 🚀 Future Enhancements

- Real-time job vacancy integration.
- Automated calendar and email notifications.
- Advanced resume scoring and skill recommendations.
- Resume download and report generation.
- Enhanced analytics dashboard.
- Cloud deployment.

## 👩‍💻 Developer

**Kaveri Parisapogu**

GitHub: https://github.com/kaveri-bh

Project Repository: https://github.com/kaveri-bh/Resume-Analyzer

---

⭐ If you find this project useful, consider giving the repository a star!

*Built with Java, Spring Boot, MySQL, and Groq AI.*

# Resume Analyzer – Career Growth Assistant
Spring Boot + MySQL project for resume analysis and career organization.

## Requirements
JDK 17+ (JDK 27 is suitable), Maven 3.9+, MySQL Server 8.x, VS Code Java and Spring extensions.
MySQL Workbench is only a client; make sure MySQL Server is installed and running.

## Database
In MySQL Workbench run:
```sql
CREATE DATABASE resume_analyzer;
```
Default username is `root` and password is blank. Update `src/main/resources/application.properties` if your MySQL credentials differ.

## Groq AI
Set your private API key in the VS Code PowerShell terminal:
```powershell
$env:GROQ_API_KEY="YOUR_GROQ_API_KEY"
$env:GROQ_MODEL="llama-3.3-70b-versatile"
```
Without the key, the app runs with a basic keyword analysis. Never publish your API key.

## Run
Open the extracted ResumeAnalyzer folder in VS Code and run:
```powershell
mvn -version
mvn clean spring-boot:run
```
Then open http://localhost:8080 and register.

## Included
Login/registration/logout, PDF/DOCX resume upload, text extraction, Groq-powered resume comparison when configured, skill suggestions, job-role guidance and job-board links, learning diary, saved calendar events and notes. User data is scoped by login email.

## Starter release limitations
The match is an estimate, not an employer ATS score. Job Research provides role guidance and job board links, not live vacancies. Calendar saves reminder preference but does not yet send browser/email notifications. Notes support create/delete. Resume text is stored in MySQL; avoid uploading sensitive documents to a public deployment.

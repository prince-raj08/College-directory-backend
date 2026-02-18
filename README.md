🎓 College Directory Application
📌 Project Overview

The College Directory Application is a full-stack web application designed to streamline interaction between Students, Faculty Members, and Administrators within a single college.
It enables users to manage, view, and update academic and personal information efficiently through role-based dashboards.

🚀 Features
🔐 Authentication & Authorization

Secure Login System

Role-Based Access Control (Student / Faculty / Admin)

JWT / Session Based Authentication

Protected API Endpoints

Error Handling for Invalid Credentials

👥 User Roles & Functionalities
1. Student

Capabilities:

View Personal Profile (Name, Photo, Contact Info)

View Academic Details (Courses, Grades, Attendance)

Search Other Students (Name / Department / Year)

Contact Faculty Advisors (Email / Phone)

2. Faculty Member

Capabilities:

Manage Class List

View Student Contact Information

Update Profile (Office Hours, Email, Phone)

3. Administrator

Capabilities:

Add / Update / Delete Student Records

Add / Update / Delete Faculty Records

Dashboard with Analytics & Graphs

Monitor Enrollment & Faculty Load

🛠️ Tech Stack
Frontend

React.js

Tailwind CSS / CSS

JavaScript

Responsive UI Design

State Management (React Hooks)

Backend

Java

Spring Boot

REST APIs

JWT Authentication

Role-Based Authorization

Data Validation & Error Handling

Database

PostgreSQL

🗄️ Database Design
Entities

User – Stores login credentials and role.

StudentProfile – Extends User with academic details.

FacultyProfile – Extends User with office information.

AdministratorProfile – Extends User with department info.

Department – Stores department details.

Course – Course information and assigned faculty.

Enrollment – Many-to-Many relationship between Students & Courses.

Relationships

One-to-One → User ↔ Profile

One-to-Many → Faculty ↔ Courses

Many-to-Many → Students ↔ Courses (Enrollment Table)

One-to-Many → Department ↔ Users/Courses

📊 Dashboard Analytics

Student Enrollment Trends

Faculty Course Load

Interactive Charts & Graphs

Real-Time Data Aggregation

🔧 API Modules

Authentication APIs

Student Management APIs

Faculty Management APIs

Course & Enrollment APIs

Dashboard Analytics APIs

📁 Project Structure (Suggested)
college-directory/
│
├── frontend/
│   ├── components/
│   ├── pages/
│   ├── services/
│   └── App.js
│
├── backend/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── model/
│   └── config/
│
└── database/
    └── schema.sql

⚙️ Installation & Setup
Frontend
cd frontend
npm install
npm start

Backend
cd backend
mvn spring-boot:run

Database

Install PostgreSQL

Create Database college_directory

Run SQL Schema

🔒 Security

Encrypted Password Storage

JWT Tokens

Role-Based Endpoint Protection

Input Validation

🎯 Future Enhancements

Notifications System

File Upload Improvements

Advanced Search Filters

Mobile App Version

Email Integration

🤝 Contribution

Pull requests are welcome. For major changes, please open an issue first to discuss improvements.

📄 License

This project is for educational purposes.

👨‍💻 Author

Prince Raj

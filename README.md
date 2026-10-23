# Crime Record Management System 🚔

A Java-based desktop application designed to digitize and manage crime records efficiently. The system helps police stations maintain crime details, assign officers to cases, and manage evidence using a user-friendly graphical interface and a MySQL database.

## 📌 Project Overview

The Crime Record Management System was developed as an academic project for Shirpur Police Station, Shirpur. It aims to replace manual record-keeping with a computerized system that improves data organization, accuracy, security, and information retrieval.

The application provides a centralized platform for managing crime records, tracking assigned officers, and maintaining evidence details associated with criminal cases.

## ✨ Features

- **Admin Login:** Secure access to the system through authentication.
- **Crime Management:** Add, view, edit, delete, and search crime records.
- **Evidence Management:** Record and retrieve evidence details associated with specific crimes.
- **Officer Management:** Maintain police officer information.
- **Case-Officer Mapping:** Assign officers to specific criminal cases.
- **Record Retrieval:** Quickly search and access stored crime and evidence records.
- **Database Integration:** Store and manage information using MySQL.
- **User-Friendly Interface:** Simple graphical user interface developed using Java Swing.

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java 8 | Application development |
| Java Swing | Graphical User Interface (GUI) |
| MySQL | Database management |
| JDBC | Database connectivity |
| NetBeans IDE 8.0.2 | Development environment |
| Windows 10/11 | Operating system |

## ⚙️ System Requirements

- **Operating System:** Windows 10 or Windows 11
- **Programming Language:** Java 8 (JDK 1.8)
- **IDE:** NetBeans IDE 8.0.2 or a compatible Java IDE
- **Database:** MySQL Server
- **Database Driver:** MySQL JDBC Driver
- **RAM:** Minimum 4 GB recommended

## 🚀 Installation and Setup

Follow these steps to set up and run the project on your local machine.

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY.git
```

Replace `YOUR-USERNAME` and `YOUR-REPOSITORY` with your GitHub username and repository name.

### 2. Open the Project

- Open NetBeans IDE.
- Select **File → Open Project**.
- Navigate to the cloned project folder.
- Open the project in NetBeans.

### 3. Configure the MySQL Database

- Start your MySQL server.
- Create the database required by the application.
- Import or execute the SQL database script if one is included in the repository.
- Configure the database connection details in the project.

Ensure that the database contains the required tables for administrators, crimes, evidence, officers, and case-officer mappings.

### 4. Configure JDBC Connectivity

Make sure the MySQL JDBC driver is available in the project libraries. Update the database connection URL, username, and password according to your local MySQL configuration.

### 5. Run the Application

- Build the project in NetBeans.
- Resolve any missing library or database configuration issues.
- Run the main application class.
- Log in using the configured administrator credentials.

**Note:** Database names, connection settings, and login credentials depend on the actual project configuration.

## 🗄️ Database Structure

The project uses MySQL to organize crime-related information into structured tables:

- **Admins:** Stores administrator login details.
- **Crimes:** Stores crime information, including case number, crime type, description, date, location, and status.
- **Evidence:** Stores evidence descriptions, types, submission details, and associated crime IDs.
- **Officers:** Stores officer information, including name, rank, and department.
- **Case Officers:** Maintains mappings between crime cases and assigned officers.

Relationships between tables help maintain consistency and associate evidence and officers with their respective cases.

## 📂 Main Modules

1. **Login Module** – Authenticates users before system access.
2. **Crime Record Module** – Manages crime details and case status.
3. **Evidence Module** – Adds and displays evidence records.
4. **Officer Management Module** – Maintains officer information.
5. **Case-Officer Mapping Module** – Assigns officers to criminal cases.

## 🎯 Project Objectives

- Digitize traditional paper-based crime record management.
- Reduce manual effort and data-entry errors.
- Improve the speed of searching and retrieving records.
- Maintain organized evidence records.
- Track officer assignments for criminal cases.
- Provide controlled access to sensitive information.

## 🧪 Testing

The project report covers the following testing approaches:

- **White Box Testing:** Checks internal logic, control flow, database queries, and error handling.
- **Black Box Testing:** Verifies application functionality using valid and invalid inputs.
- **Performance Testing:** Evaluates record retrieval, database handling, and system responsiveness.

## 🔮 Future Enhancements

Potential improvements include:

- Graphical crime statistics and analytical reports.
- Advanced search and filtering options.
- Automated database backup and recovery.
- Improved role-based access control.
- Enhanced reporting and report export functionality.
- Network-based access for multiple authorized users.

## ⚠️ Limitations

- The accuracy of records depends on the information entered by users.
- Graphical crime statistics and advanced analytics are not included in the documented version.
- The application requires appropriate Java, MySQL, and JDBC configuration.

## 🎓 Academic Project

**Project Title:** Crime Record Management System  
**Organization:** Shirpur Police Station, Shirpur  
**Course:** Integrated Master of Computer Applications (IMCA)  
**Institution:** R. C. Patel Institute of Management Research and Development, Shirpur  
**Academic Year:** 2024–2025

## 👨‍💻 Author

**Vaibhav Jaywantrao Patil**

## 📄 License

No license has been specified for this project yet. If you intend to make the source code available for reuse, consider adding an appropriate open-source license.

---

⭐ If you find this project useful for learning Java Swing, JDBC, and MySQL database integration, feel free to explore the repository.

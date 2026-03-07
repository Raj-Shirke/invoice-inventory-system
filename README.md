# Automated Invoice & Inventory System 🚀

A full-stack Spring Boot application for managing product inventory and generating real-time sales invoices.

## ✨ Features

- **Inventory Management**: Add, update, and view products in real-time.
- **Automated Invoicing**: Process sales and calculate total prices automatically.
- **Database Sync**: Uses Hibernate to automatically sync Java models with MySQL tables.
- **Responsive Dashboard**: Clean HTML/JS interface for easy management.

## 🛠️ Tech Stack

- **Backend**: Java 25, Spring Boot 4.0.3, Spring Data JPA
- **Database**: MySQL 8.0
- **Frontend**: HTML5, Vanilla JavaScript, CSS3
- **Tools**: VS Code, Maven, MySQL Workbench

## ⚙️ Setup Instructions

1. Create a database named `invoice_inventory_db` in MySQL.
2. Update `src/main/resources/application.properties` with your MySQL credentials.
3. Run the application using `mvn spring-boot:run` or **F5** in VS Code.
4. Open `http://localhost:8081` in your browser.

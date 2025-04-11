# Dynamic MySQL Operator using JDBC

This Java project demonstrates how to dynamically interact with a MySQL database using JDBC. The project provides a menu-driven interface that allows users to:

- ✅ Create a new database
- ✅ Create tables within a database
- ✅ Insert values into the tables
- ✅ Display table contents

## 📂 Project Structure

The project contains the following key Java files:

- `DBCreation.java` - Handles the creation of a new MySQL database.
- `TableCreate.java` - Allows you to create tables dynamically inside a selected database.
- `InsertValues.java` - Facilitates inserting values into existing tables.
- `DisplayTable.java` - Displays the content of tables.
- `Main.java` - Acts as the entry point and provides a menu-driven interface.

## 🚀 Getting Started

### Prerequisites

- Java JDK 8 or higher
- MySQL Server running locally
- MySQL JDBC Driver (add it to your classpath)

### Database Connection

Make sure to update the database connection string in `Main.java`:

```java
String url = "jdbc:mysql://localhost:3306/";

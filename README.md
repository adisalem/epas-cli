# Employee Pension Administration System (EPAS) CLI

A Java-based Command-Line Interface (CLI) application for managing employee pension plans and generating quarterly enrollment reports.

## Project Overview

This application helps HR managers manage employee pension plan enrollment by:
- Viewing all employees with their pension plan details
- Generating reports for current quarter eligible enrollees
- Generating reports for next quarter upcoming eligible enrollees

## Features

### Feature 1: All Employees Report
Displays all employees in JSON format, sorted by:
- Yearly Salary (descending)
- Last Name (ascending)

Includes pension plan information if the employee is enrolled.

### Feature 2: Current Quarterly Enrollees Report
Displays employees eligible for enrollment in Q2 2026 (April - June), sorted by employment date (descending).

**Eligibility Criteria:**
- Employed for at least 1 year by quarter end
- Yearly salary >= $100,000
- Not already enrolled in a pension plan

### Feature 3: Next Quarterly Upcoming Enrollees Report
Displays employees eligible for enrollment in Q3 2026 (July - September), sorted by:
- Employment Date (descending)
- Yearly Salary (ascending)

**Eligibility Criteria:**
- Same as Feature 2

## Project Structure

```
epas-cli/
├── src/
│   ├── main/
│   │   ├── java/com/epas/
│   │   │   ├── app/EPASApp.java          # Main application class
│   │   │   └── model/
│   │   │       ├── Employee.java         # Employee entity
│   │   │       └── PensionPlan.java      # PensionPlan entity
│   │   └── resources/
│   └── test/java/
├── .github/workflows/
│   └── maven.yml                         # GitHub Actions CI/CD pipeline
├── pom.xml                               # Maven build configuration
├── README.md                             # This file
└── screenshots/                          # Evidence screenshots
```

## Technology Stack

- **Language:** Java 17
- **Build Tool:** Apache Maven 3.x
- **JSON Processing:** Jackson 2.15.2
- **CI/CD:** GitHub Actions
- **Version Control:** Git & GitHub

## Building the Project

### Prerequisites
- Java 17 or higher
- Maven 3.6.0 or higher

### Build Steps

```bash
# Navigate to project directory
cd epas-cli

# Clean and compile the project
mvn clean compile

# Build the executable JAR
mvn package

# Run the application
java -jar target/epas-cli-1.0-SNAPSHOT.jar
```

## Running the Application

```bash
# Using Maven
mvn exec:java -Dexec.mainClass="com.epas.app.EPASApp"

# Using the compiled JAR
java -jar target/epas-cli-1.0-SNAPSHOT.jar
```

## Sample Output

When executed, the application produces three JSON reports to standard output:

1. **All Employees Report** - Complete employee list with pension details
2. **Current Quarter Report** - Q2 2026 eligible enrollees
3. **Next Quarter Report** - Q3 2026 eligible enrollees

## Employee Test Data

The application includes 7 sample employees:

| ID | Name | Salary | Employment Date | Pension Plan |
|----|------|--------|-----------------|--------------|
| 1 | Daniel Agar | $105,945.50 | 2025-08-17 | - |
| 2 | Bernard Shaw | $197,750.00 | 2025-02-03 | EX0089 |
| 3 | Carly Jones | $842,000.75 | 2024-05-16 | SM2307 |
| 4 | Wesley Schneider | $174,500.00 | 2025-04-30 | - |
| 5 | Anna Wiltord | $185,750.00 | 2025-09-15 | - |
| 6 | Yosef Tesfalem | $100,000.00 | 2025-07-31 | - |
| 7 | Johnny Edwards | $95,500.00 | 2025-07-09 | - |

## CI/CD Pipeline

GitHub Actions automatically builds and tests the application on:
- Every push to `master`, `main`, or `develop` branches
- Every pull request to these branches

The workflow:
1. Checks out the code
2. Sets up Java 17 runtime
3. Builds the project with Maven
4. Runs the application
5. Archives build artifacts

## Author

Created for CS489 - Applied Software Development Lab2a
MIU - Department of Computer Science

## License

This is a student project for educational purposes.

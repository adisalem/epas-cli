# EPAS - Employee Pension Administration System

A simple Java CLI tool to manage employee pension enrollments and generate quarterly reports.

## What it does

- **List all employees** - sorted by salary (high to low) and name
- **Current quarter enrollees** - who's eligible for Q2 2026
- **Next quarter candidates** - who's eligible for Q3 2026

Eligible means: employed 1+ year, salary ≥ $100k, not already enrolled.

## Quick start

```bash
# Build
mvn clean package

# Run
java -jar target/epas-cli-1.0-SNAPSHOT.jar
```

## Tech

- Java 17
- Maven
- Jackson (JSON)
- GitHub Actions (CI/CD)

1. **All Employees Report** - Complete employee list with pension details
2. **Current Quarter Report** - Q2 2026 eligible enrollees
3. **Next Quarter Report** - Q3 2026 eligible enrollees

## Employee Test Data

The application includes 7 sample employees:

| # | Plan Ref | First Name | Last Name | Salary | Employment Date | Enrollment Date | Monthly Contribution |
|---|----------|------------|-----------|--------|-----------------|-----------------|----------------------|
| 1 | - | Daniel | Agar | $105,945.50 | 2025-08-17 | - | - |
| 2 | EX0089 | Benard | Shaw | $197,750.00 | 2025-02-03 | 2026-02-03 | $450.00 |
| 3 | SM2307 | Carly | Jones | $842,000.75 | 2024-05-16 | 2025-05-17 | $1,555.50 |
| 4 | - | Wesley | Schneider | $174,500.00 | 2025-04-30 | - | - |
| 5 | - | Anna | Wiltord | $185,750.00 | 2025-09-15 | - | - |
| 6 | - | Yosef | Tesfalem | $100,000.00 | 2025-07-31 | - | - |
| 7 | - | Johnny | Edwards | $95,500.00 | 2025-07-09 | - | - |

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


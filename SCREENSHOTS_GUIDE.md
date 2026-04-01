# Lab2a: EPAS CLI Application - Screenshots & Submission Guide

## ✅ Project Completion Checklist

This document guides you through taking the required screenshots for Lab2a submission.

## Project Location
```
d:\pStuff\MIU\adv sw\assignments\lab2\epas-cli\
```

## Git Repository Information
- **Branch:** master
- **Initial Commit:** Initialized with all project files
- **Commit Hash:** Latest (run `git log --oneline` to verify)

---

## 📸 Required Screenshots

### Screenshot 1: Project Structure in IDE
**File:** `01-project-structure.png`

Open the project in VS Code or your IDE and take a screenshot showing:
- Folder tree expanded showing:
  - `src/main/java/com/epas/app/EPASApp.java`
  - `src/main/java/com/epas/model/Employee.java`
  - `src/main/java/com/epas/model/PensionPlan.java`
  - `pom.xml`
  - `.github/workflows/maven.yml` (GitHub Actions workflow)
  - `README.md`

---

### Screenshot 2: Maven Build Success
**File:** `02-maven-build.png`

Run this command in terminal:
```bash
cd "d:\pStuff\MIU\adv sw\assignments\lab2\epas-cli"
mvn clean package
```

Take a screenshot showing the terminal output displaying:
```
[INFO] BUILD SUCCESS
[INFO] Total time: X.XXX s
```

---

### Screenshot 3: Feature 1 - All Employees Report
**File:** `03-feature1-all-employees.png`

Run this command in terminal:
```bash
cd "d:\pStuff\MIU\adv sw\assignments\lab2\epas-cli"
java -jar target/epas-cli-1.0-SNAPSHOT.jar
```

Take a screenshot of the output showing:
- Header: "========== FEATURE 1: All Employees (JSON) =========="
- All 7 employees sorted by Salary DESC, LastName ASC
- Employees with Pension Plans (Bernard Shaw, Carly Jones) show plan details
- Employees without plans show null for pensionPlan field

---

### Screenshot 4: Feature 2 - Current Quarterly Enrollees
**File:** `04-feature2-current-quarter.png`

Show the same terminal output but capture the section:
- Header: "========== FEATURE 2: Current Quarterly Enrollees Report =========="
- Quarter: Q2 2026 (April - June)
- Shows Wesley Schneider as qualified (employed >= 1 year, salary >= $100,000, not enrolled)
- Sorted by Employment Date DESC
- Total Qualified Enrollees: 1

---

### Screenshot 5: Feature 3 - Next Quarterly Enrollees
**File:** `05-feature3-next-quarter.png`

Show the same terminal output but capture the section:
- Header: "========== FEATURE 3: Next Quarterly Upcoming Enrollees Report =========="
- Quarter: Q3 2026 (July - September)
- Shows 4 qualified employees:
  - Anna Wiltord (2025-09-15, $185,750)
  - Daniel Agar (2025-08-17, $105,945.50)
  - Yosef Tesfalem (2025-07-31, $100,000)
  - Wesley Schneider (2025-04-30, $174,500)
- Sorted by Employment Date DESC, then Salary ASC
- Total Qualified Upcoming Enrollees: 4

---

### Screenshot 6: GitHub Actions Workflow Configuration
**File:** `06-github-actions-workflow.png`

Open file `.github/workflows/maven.yml` in your IDE and take a screenshot showing:
- Workflow triggers on push and pull_request
- Build job with Maven build steps
- Java 17 setup
- Package and run application steps

---

### Screenshot 7: README.md Documentation
**File:** `07-readme-documentation.png`

Open `README.md` in your IDE and take a screenshot showing:
- Project title and description
- Features overview
- Technology stack
- Build and run instructions

---

### Screenshot 8: Git Log - Commit History
**File:** `08-git-log.png`

Run this command in terminal:
```bash
cd "d:\pStuff\MIU\adv sw\assignments\lab2\epas-cli"
git log --oneline
```

Take a screenshot showing the initial commit.

---

## 🚀 Pushing to GitHub

### Step 1: Create a new repository on GitHub.com
1. Go to https://github.com/new
2. Name it: `epas-cli` (or similar)
3. Do NOT initialize with README (we have one already)
4. Click "Create repository"

### Step 2: Add remote and push
```bash
cd "d:\pStuff\MIU\adv sw\assignments\lab2\epas-cli"
git remote add origin https://github.com/YOUR_USERNAME/epas-cli.git
git branch -M master
git push -u origin master
```

### Step 3: GitHub Repository Screenshot
**File:** `09-github-repository.png`

After pushing, take a screenshot of your GitHub repository showing:
- Repository name: epas-cli
- Files listed: pom.xml, README.md, src/, .github/workflows/
- GitHub Actions showing build status

---

## 📋 Submission Checklist

Before submitting to Sakai:

- ✅ Project compiles successfully with Maven
- ✅ All three features produce correct JSON output
- ✅ All 8-9 screenshots saved in `screenshots/` folder as PNG or JPG files
- ✅ Git repository initialized locally with initial commit
- ✅ Project pushed to GitHub repository
- ✅ GitHub Actions workflow is active and building on push
- ✅ README.md documents the project
- ✅ pom.xml configured correctly with Maven plugins

---

## 📝 Final Words

### Features Implemented (Lab2a):
1. ✅ Maven build automation with JAR packaging
2. ✅ Three reporting features (all employees, current quarter, next quarter)
3. ✅ Employee and PensionPlan model classes
4. ✅ JSON output formatting
5. ✅ GitHub Actions CI/CD pipeline
6. ✅ Git & GitHub version control
7. ✅ Proper project documentation

### Data Loaded:
- 7 employees with employment dates from 2024-2025
- 2 employees already enrolled in pension plans
- Correct filtering based on qualification criteria

### Ready for Submission! 🎓

---

**For questions or issues:**
- Check README.md in project root
- Review code comments in EPASApp.java
- Verify Maven installation: `mvn --version`
- Verify Java installation: `java --version` (should be 17+)


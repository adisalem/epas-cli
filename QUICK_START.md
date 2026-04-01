# 🚀 QUICK START GUIDE - Lab2a EPAS Project

## Project Ready! ✅

Your Employee Pension Administration System (EPAS) CLI application is **100% complete and ready for submission**.

**Location:** `d:\pStuff\MIU\adv sw\assignments\lab2\epas-cli\`

---

## ⚡ QUICK COMMANDS

### Build the project
```bash
cd "d:\pStuff\MIU\adv sw\assignments\lab2\epas-cli"
mvn clean package
```

### Run the application
```bash
java -jar target/epas-cli-1.0-SNAPSHOT.jar
```

### Check git status
```bash
git status
```

### View commit history
```bash
git log --oneline
```

---

## 📋 WHAT'S INCLUDED

✅ **3 Entity Classes:**
- Employee.java (with 5 required attributes + methods)
- PensionPlan.java (with 3 required attributes + methods)
- EPASApp.java (main application with 3 reporting features)

✅ **3 Reporting Features:**
1. All Employees Report (JSON, sorted by salary DESC + name ASC)
2. Current Quarterly Enrollees (Q2 2026, sorted by employment date DESC)
3. Next Quarterly Enrollees (Q3 2026, sorted by employment date DESC + salary ASC)

✅ **Build & Deployment:**
- Maven pom.xml with all dependencies
- Executable JAR file (epas-cli-1.0-SNAPSHOT.jar)
- GitHub Actions CI/CD workflow (.github/workflows/maven.yml)

✅ **Documentation:**
- README.md (project overview & usage)
- COMPLETION_SUMMARY.md (detailed status)
- SCREENSHOTS_GUIDE.md (submission instructions)

✅ **Version Control:**
- Git repository initialized (.git/)
- Initial commit made
- Ready to push to GitHub

---

## 📸 YOUR TO-DO: TAKE SCREENSHOTS

Follow **SCREENSHOTS_GUIDE.md** to take these 9 screenshots:

1. Project structure in your IDE
2. Maven build success output
3. Feature 1 JSON output (all employees)
4. Feature 2 JSON output (current quarter)
5. Feature 3 JSON output (next quarter)
6. GitHub Actions workflow file
7. README.md file
8. Git commit log
9. GitHub repository (after pushing)

Save all screenshots to: `screenshots/` folder (use .png or .jpg)

---

## 💾 PUSH TO GITHUB & SUBMIT

### 1. Create GitHub repository
Go to https://github.com/new and create `epas-cli` repository

### 2. Push your project
```bash
cd "d:\pStuff\MIU\adv sw\assignments\lab2\epas-cli"
git remote add origin https://github.com/YOUR_USERNAME/epas-cli.git
git push -u origin master
```

### 3. Take screenshot of GitHub repo

### 4. Submit to Sakai
Paste your GitHub URL: `https://github.com/YOUR_USERNAME/epas-cli`

---

## ✨ KEY FEATURES IMPLEMENTED

### Feature 1: All Employees
- **Command:** `java -jar target/epas-cli-1.0-SNAPSHOT.jar`
- **Output:** All 7 employees in JSON format
- **Sorting:** Salary (DESC) → LastName (ASC)
- **Data:** 2 employees with pension plans, 5 without

### Feature 2: Current Quarter Enrollees
- **Quarter:** Q2 2026 (April 1 - June 30)
- **Output:** Employees eligible for enrollment
- **Sorting:** Employment Date (DESC)
- **Result:** 1 qualified (Wesley Schneider)

### Feature 3: Next Quarter Enrollees
- **Quarter:** Q3 2026 (July 1 - September 30)
- **Output:** Employees who will be eligible next quarter
- **Sorting:** Employment Date (DESC) → Salary (ASC)
- **Result:** 4 qualified (Anna, Daniel, Yosef, Wesley)

---

## 📊 QUALIFICATION CRITERIA

Employee must meet ALL of these:
- ✅ Employed for ≥ 1 year by end of quarter
- ✅ Yearly salary ≥ $100,000
- ✅ NOT already enrolled in a pension plan

---

## 🛠 TECHNOLOGIES USED

- **Java 17** - Programming language
- **Maven 3.x** - Build automation
- **Jackson 2.15.2** - JSON processing
- **JUnit 4** - Testing framework
- **GitHub Actions** - CI/CD automation
- **Git** - Version control

---

## 📝 PROJECT STRUCTURE

```
epas-cli/
├── src/main/java/com/epas/
│   ├── app/EPASApp.java          ← Main application
│   └── model/
│       ├── Employee.java         ← Model class
│       └── PensionPlan.java      ← Model class
├── .github/workflows/maven.yml   ← CI/CD pipeline
├── pom.xml                       ← Maven config
├── README.md                     ← Documentation
├── COMPLETION_SUMMARY.md         ← Status report
├── SCREENSHOTS_GUIDE.md          ← Screenshot instructions
└── screenshots/                  ← Your screenshots go here!
```

---

## ✅ VERIFICATION CHECKLIST

Before submitting:

- [ ] All code compiles: `mvn clean package`
- [ ] Application runs: `java -jar target/epas-cli-1.0-SNAPSHOT.jar`
- [ ] Feature 1 shows 7 employees
- [ ] Feature 2 shows 1 qualified
- [ ] Feature 3 shows 4 qualified
- [ ] 9 screenshots taken and in screenshots/ folder
- [ ] Git repository has initial commit
- [ ] Project pushed to GitHub
- [ ] GitHub Actions workflow triggered and passed
- [ ] GitHub URL ready for Sakai submission

---

## 🎓 READY TO SUBMIT!

**Everything is complete.** You just need to:
1. Take the 9 screenshots (use SCREENSHOTS_GUIDE.md)
2. Push to GitHub
3. Submit the GitHub URL to Sakai

For detailed instructions, see **SCREENSHOTS_GUIDE.md** and **COMPLETION_SUMMARY.md**

---

**Project Status:** ✅ COMPLETE  
**Date:** March 31, 2026  
**Course:** CS489 - Applied Software Development  
**Assignment:** Lab2a - Software Dev Environment Demo

Good luck! 🚀

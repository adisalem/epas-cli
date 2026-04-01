package com.epas.app;

import com.epas.model.Employee;
import com.epas.model.PensionPlan;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Employee Pension Administration System CLI Application (EPAS)
 * Main application class for managing employee pension plans and generating reports
 */
public class EPASApp {

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public static void main(String[] args) throws Exception {
        List<Employee> employees = loadEmployeeData();

        System.out.println("\n========== FEATURE 1: All Employees (JSON) ==========");
        System.out.println("Sorted by: Yearly Salary (DESC), Last Name (ASC)\n");
        printAllEmployees(employees);

        System.out.println("\n\n========== FEATURE 2: Current Quarterly Enrollees Report ==========");
        System.out.println("Quarter: Q2 2026 (April 1 - June 30)");
        System.out.println("Sorted by: Employment Date (DESC)\n");
        printCurrentQuarterlyEnrollees(employees);

        System.out.println("\n\n========== FEATURE 3: Next Quarterly Upcoming Enrollees Report ==========");
        System.out.println("Quarter: Q3 2026 (July 1 - September 30)");
        System.out.println("Sorted by: Employment Date (DESC), Yearly Salary (ASC)\n");
        printNextQuarterlyEnrollees(employees);
    }

    /**
     * Load employee and pension plan data into memory
     */
    private static List<Employee> loadEmployeeData() {
        List<Employee> employees = new ArrayList<>();

        // Employee 1: Daniel Agar - no pension plan (employed less than 1 year)
        Employee emp1 = new Employee(1, "Daniel", "Agar", LocalDate.of(2025, 8, 17), 105945.50);
        employees.add(emp1);

        // Employee 2: Bernard Shaw - with pension plan EX0089
        Employee emp2 = new Employee(2, "Bernard", "Shaw", LocalDate.of(2025, 2, 3), 197750.00);
        emp2.setPensionPlan(new PensionPlan("EX0089", LocalDate.of(2026, 2, 3), 450.00));
        employees.add(emp2);

        // Employee 3: Carly Jones - with pension plan SM2307
        Employee emp3 = new Employee(3, "Carly", "Jones", LocalDate.of(2024, 5, 16), 842000.75);
        emp3.setPensionPlan(new PensionPlan("SM2307", LocalDate.of(2025, 5, 17), 1555.50));
        employees.add(emp3);

        // Employee 4: Wesley Schneider - no pension plan (employed less than 1 year)
        Employee emp4 = new Employee(4, "Wesley", "Schneider", LocalDate.of(2025, 4, 30), 174500.00);
        employees.add(emp4);

        // Employee 5: Anna Wiltord - no pension plan (employed less than 1 year)
        Employee emp5 = new Employee(5, "Anna", "Wiltord", LocalDate.of(2025, 9, 15), 185750.00);
        employees.add(emp5);

        // Employee 6: Yosef Tesfalem - no pension plan (employed less than 1 year)
        Employee emp6 = new Employee(6, "Yosef", "Tesfalem", LocalDate.of(2025, 7, 31), 100000.00);
        employees.add(emp6);

        // Employee 7: Johnny Edwards - no pension plan (salary < $100,000)
        Employee emp7 = new Employee(7, "Johnny", "Edwards", LocalDate.of(2025, 7, 9), 95500.00);
        employees.add(emp7);

        return employees;
    }

    /**
     * Feature 1: Print all employees in JSON format
     * Sorted by: Yearly Salary (DESC), then Last Name (ASC)
     */
    private static void printAllEmployees(List<Employee> employees) throws Exception {
        List<Employee> sorted = employees.stream()
                .sorted(Comparator
                        .comparingDouble(Employee::getYearlySalary).reversed()
                        .thenComparing(Employee::getLastName))
                .collect(Collectors.toList());

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sorted);
        System.out.println(json);
    }

    /**
     * Feature 2: Current Quarterly Enrollees Report
     * Current Quarter: Q2 2026 (April 1 - June 30)
     * Criteria: Employed >= 1 year by quarter end, salary >= $100,000, NOT enrolled
     * Sorted by: Employment Date (DESC)
     */
    private static void printCurrentQuarterlyEnrollees(List<Employee> employees) throws Exception {
        LocalDate quarterStart = LocalDate.of(2026, 4, 1);
        LocalDate quarterEnd = LocalDate.of(2026, 6, 30);

        List<Employee> qualifiedEnrollees = employees.stream()
                .filter(emp -> isQualifiedForQuarter(emp, quarterStart, quarterEnd))
                .sorted(Comparator.comparing(Employee::getEmploymentDate).reversed())
                .collect(Collectors.toList());

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(qualifiedEnrollees);
        System.out.println(json);
        System.out.println("\nTotal Qualified Enrollees: " + qualifiedEnrollees.size());
    }

    /**
     * Feature 3: Next Quarterly Upcoming Enrollees Report
     * Next Quarter: Q3 2026 (July 1 - September 30)
     * Criteria: Employed >= 1 year by quarter end, salary >= $100,000, NOT enrolled
     * Sorted by: Employment Date (DESC), then Yearly Salary (ASC)
     */
    private static void printNextQuarterlyEnrollees(List<Employee> employees) throws Exception {
        LocalDate quarterStart = LocalDate.of(2026, 7, 1);
        LocalDate quarterEnd = LocalDate.of(2026, 9, 30);

        List<Employee> upcomingEnrollees = employees.stream()
                .filter(emp -> isQualifiedForQuarter(emp, quarterStart, quarterEnd))
                .sorted(Comparator
                        .comparing(Employee::getEmploymentDate).reversed()
                        .thenComparingDouble(Employee::getYearlySalary))
                .collect(Collectors.toList());

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(upcomingEnrollees);
        System.out.println(json);
        System.out.println("\nTotal Qualified Upcoming Enrollees: " + upcomingEnrollees.size());
    }

    /**
     * Check if employee is qualified for enrollment in a specific quarter
     * Criteria:
     * 1. Must have been employed for at least 1 year on or before the last day of the quarter
     * 2. Yearly salary must be >= $100,000
     * 3. Must NOT already be enrolled to a pension plan
     */
    private static boolean isQualifiedForQuarter(Employee emp, LocalDate quarterStart, LocalDate quarterEnd) {
        // Employee must not be enrolled already
        if (emp.getPensionPlan() != null) {
            return false;
        }

        // Yearly salary must be >= $100,000
        if (emp.getYearlySalary() < 100000) {
            return false;
        }

        // Employment must be at least 1 year before the end of the quarter
        LocalDate oneYearBeforeQuarterEnd = quarterEnd.minusYears(1);
        return emp.getEmploymentDate().isBefore(oneYearBeforeQuarterEnd) ||
                emp.getEmploymentDate().equals(oneYearBeforeQuarterEnd);
    }
}

package com.epas.service;

import com.epas.config.ReportConfig;
import com.epas.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReportService {
    private final ObjectMapper mapper;
    private final EmployeeService employeeService;

    public ReportService(EmployeeService employeeService) {
        this.employeeService = employeeService;
        this.mapper = createMapper();
    }

    private ObjectMapper createMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper;
    }

    public void printAllEmployees(List<Employee> employees) throws Exception {
        System.out.println("\n-- ALL EMPLOYEES --");
        System.out.println("Sorted by: Salary (high to low), Name (A-Z)\n");

        List<Employee> sorted = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getYearlySalary).reversed()
                        .thenComparing(Employee::getLastName))
                .collect(Collectors.toList());

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sorted);
        System.out.println(json);
    }

    public void printCurrentQuarterEnrollees(List<Employee> employees) throws Exception {
        System.out.println("\n\n-- CURRENT QUARTER: Q2 2026 (April-June) --");
        System.out.println("Eligible for Enrollment\n");

        List<Employee> qualified = employeeService.getQualifiedEmployees(employees, ReportConfig.Q2_END);
        List<Employee> sorted = qualified.stream()
                .sorted(Comparator.comparing(Employee::getEmploymentDate).reversed())
                .collect(Collectors.toList());

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sorted);
        System.out.println(json);
        System.out.println("\nTotal Qualified Enrollees: " + sorted.size());
    }

    public void printNextQuarterEnrollees(List<Employee> employees) throws Exception {
        System.out.println("\n\n-- NEXT QUARTER: Q3 2026 (July-September) --");
        System.out.println("Upcoming Candidates\n");

        List<Employee> qualified = employeeService.getQualifiedEmployees(employees, ReportConfig.Q3_END);
        List<Employee> sorted = qualified.stream()
                .sorted(Comparator.comparing(Employee::getEmploymentDate).reversed()
                        .thenComparingDouble(Employee::getYearlySalary))
                .collect(Collectors.toList());

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sorted);
        System.out.println(json);
        System.out.println("\nTotal Qualified Upcoming Enrollees: " + sorted.size());
    }
}

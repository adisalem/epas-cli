package com.epas.service;

import com.epas.config.ReportConfig;
import com.epas.model.Employee;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    public boolean isQualifiedForQuarter(Employee emp, LocalDate quarterEnd) {
        if (emp.getPensionPlan() != null) {
            return false;
        }

        if (emp.getYearlySalary() < ReportConfig.MIN_SALARY) {
            return false;
        }

        LocalDate oneYearBeforeQuarterEnd = quarterEnd.minusYears(ReportConfig.MIN_EMPLOYMENT_YEARS);
        return emp.getEmploymentDate().isBefore(oneYearBeforeQuarterEnd) ||
                emp.getEmploymentDate().equals(oneYearBeforeQuarterEnd);
    }

    public List<Employee> getQualifiedEmployees(List<Employee> employees, LocalDate quarterEnd) {
        return employees.stream()
                .filter(emp -> isQualifiedForQuarter(emp, quarterEnd))
                .collect(Collectors.toList());
    }
}

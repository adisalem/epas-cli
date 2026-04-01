package com.epas.repository;

import com.epas.model.Employee;
import com.epas.model.PensionPlan;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    public List<Employee> loadAll() {
        List<Employee> employees = new ArrayList<>();

        Employee emp1 = new Employee(1, "Daniel", "Agar", LocalDate.of(2025, 8, 17), 105945.50);
        employees.add(emp1);

        Employee emp2 = new Employee(2, "Benard", "Shaw", LocalDate.of(2025, 2, 3), 197750.00);
        emp2.setPensionPlan(new PensionPlan("EX0089", LocalDate.of(2026, 2, 3), 450.00));
        employees.add(emp2);

        Employee emp3 = new Employee(3, "Carly", "Jones", LocalDate.of(2024, 5, 16), 842000.75);
        emp3.setPensionPlan(new PensionPlan("SM2307", LocalDate.of(2025, 5, 17), 1555.50));
        employees.add(emp3);

        Employee emp4 = new Employee(4, "Wesley", "Schneider", LocalDate.of(2025, 4, 30), 174500.00);
        employees.add(emp4);

        Employee emp5 = new Employee(5, "Anna", "Wiltord", LocalDate.of(2025, 9, 15), 185750.00);
        employees.add(emp5);

        Employee emp6 = new Employee(6, "Yosef", "Tesfalem", LocalDate.of(2025, 7, 31), 100000.00);
        employees.add(emp6);

        Employee emp7 = new Employee(7, "Johnny", "Edwards", LocalDate.of(2025, 7, 9), 95500.00);
        employees.add(emp7);

        return employees;
    }
}

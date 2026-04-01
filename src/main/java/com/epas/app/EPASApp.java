package com.epas.app;

import com.epas.repository.EmployeeRepository;
import com.epas.service.EmployeeService;
import com.epas.service.ReportService;
import com.epas.model.Employee;
import java.util.List;
import java.util.Scanner;

public class EPASApp {
    public static void main(String[] args) throws Exception {
        EmployeeRepository repository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService();
        ReportService reportService = new ReportService(employeeService);

        List<Employee> employees = repository.loadAll();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    reportService.printAllEmployees(employees);
                    break;
                case "2":
                    reportService.printCurrentQuarterEnrollees(employees);
                    break;
                case "3":
                    reportService.printNextQuarterEnrollees(employees);
                    break;
                case "4":
                    reportService.printAllEmployees(employees);
                    reportService.printCurrentQuarterEnrollees(employees);
                    reportService.printNextQuarterEnrollees(employees);
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Enter 0, 1, 2, 3, or 4.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n==== EPAS MENU ====");
        System.out.println("1. Show all employees");
        System.out.println("2. Show current quarter enrollees");
        System.out.println("3. Show next quarter upcoming enrollees");
        System.out.println("4. Show all reports");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }
}

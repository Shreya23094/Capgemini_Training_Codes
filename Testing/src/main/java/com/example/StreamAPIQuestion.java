package com.example;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamAPIQuestion {
    public static void main(String[] args) {

        List<Department> departments = EmployeeRepository.getDepartments();
        List<Employee> employees = EmployeeRepository.getEmployees();

        // 1. Find out the sum of salary of all employees.
        double sum = employees.stream()
                .mapToDouble(emp -> emp.getSalary())
                .sum();
        System.out.println("Total Salary: " + sum);

        // 2. List out department names and count of employees in each department.
        Map<String, Long> deptCount = employees.stream()
                .filter(emp -> emp.getDepartment() != null)
                .collect(Collectors.groupingBy(
                        emp -> emp.getDepartment().getDepartmentName(),
                        Collectors.counting()
                ));
        deptCount.forEach((dept, count) ->
                System.out.println(dept + " -> " + count));

        // 3. Find out the senior most employee of an organization.
        Optional<Employee> optMin = employees.stream()
                .min((e1, e2) -> e1.getHireDate().compareTo(e2.getHireDate()));
        System.out.println("Senior Most: " +
                optMin.get().getFirstName() + " " + optMin.get().getLastName());

        // 4. List employee name and duration of their service in months and days.
        employees.stream().forEach(emp -> {
            Period period = Period.between(emp.getHireDate(), LocalDate.now());
            System.out.println(emp.getFirstName() + " " + emp.getLastName()
                    + " -> " + period.getYears() * 12 + period.getMonths()
                    + " months and " + period.getDays() + " days");
        });

        // 5. Find out employees without department.
        employees.stream()
                .filter(emp -> emp.getDepartment() == null)
                .forEach(emp ->
                        System.out.println(emp.getFirstName() + " " + emp.getLastName()));

        // 6. Find out department without employees.
        departments.stream()
                .filter(dept ->
                        employees.stream()
                                .noneMatch(emp -> emp.getDepartment() != null &&
                                        emp.getDepartment().getDepartmentId()
                                                == dept.getDepartmentId()))
                .forEach(dept ->
                        System.out.println(dept.getDepartmentName()));

        // 7. Find departments with highest count of employees.
        Optional<Map.Entry<String, Long>> maxDept =
                deptCount.entrySet().stream()
                        .max(Map.Entry.comparingByValue());

        maxDept.ifPresent(entry ->
                System.out.println("Highest Employees Dept: "
                        + entry.getKey() + " -> " + entry.getValue()));

        // 8. List employee name, hire date and day of week.
        employees.stream()
                .forEach(emp ->
                        System.out.println(emp.getFirstName() + " "
                                + emp.getLastName() + " | "
                                + emp.getHireDate() + " | "
                                + emp.getHireDate().getDayOfWeek()));

        // 9. List employees joined on FRIDAY.
        employees.stream()
                .filter(emp ->
                        emp.getHireDate().getDayOfWeek().toString()
                                .equals("FRIDAY"))
                .forEach(emp ->
                        System.out.println(emp.getFirstName() + " "
                                + emp.getLastName()));

        // 10. employee name reports to manager name
        employees.stream()
                .filter(emp -> emp.getManagerId() != null)
                .forEach(emp -> {
                    employees.stream()
                            .filter(mgr ->
                                    mgr.getEmployeeId()
                                            .equals(emp.getManagerId()))
                            .findFirst()
                            .ifPresent(mgr ->
                                    System.out.println(emp.getFirstName()
                                            + " reports to "
                                            + mgr.getFirstName()));
                });

        // 11. employee name, salary and salary increased by 15%
        employees.stream()
                .forEach(emp ->
                        System.out.println(emp.getFirstName()
                                + " | Salary: " + emp.getSalary()
                                + " | Increased: "
                                + (emp.getSalary() * 1.15)));

        // 12. Employees without manager
        employees.stream()
                .filter(emp -> emp.getManagerId() == null)
                .forEach(emp ->
                        System.out.println(emp.getFirstName() + " "
                                + emp.getLastName()));

        // 13. Method to print subordinates of manager
        printSubordinates(employees, "John", "Doe");

        // 14. Sort employees

        // by Employee id
        employees.stream()
                .sorted(Comparator.comparing(Employee::getEmployeeId))
                .forEach(emp ->
                        System.out.println(emp.getEmployeeId()));

        // by Department id
        employees.stream()
                .filter(emp -> emp.getDepartment() != null)
                .sorted(Comparator.comparing(
                        emp -> emp.getDepartment().getDepartmentId()))
                .forEach(emp ->
                        System.out.println(emp.getDepartment()
                                .getDepartmentId()));

        // by First name
        employees.stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .forEach(emp ->
                        System.out.println(emp.getFirstName()));
    }

    // 13. Method
    public static void printSubordinates(List<Employee> employees,
                                         String firstName,
                                         String lastName) {

        Optional<Employee> manager = employees.stream()
                .filter(emp ->
                        emp.getFirstName().equals(firstName)
                                && emp.getLastName().equals(lastName))
                .findFirst();

        if (manager.isPresent()) {
            employees.stream()
                    .filter(emp ->
                            emp.getManagerId() != null &&
                                    emp.getManagerId()
                                            .equals(manager.get()
                                                    .getEmployeeId()))
                    .forEach(emp ->
                            System.out.println(emp.getFirstName()
                                    + " " + emp.getLastName()));
        }
    }
}
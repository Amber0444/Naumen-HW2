package org.example.Task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    // 4 вариант
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Иванов Иван", 25, "IT", 80000.0),
                new Employee("Петрова Мария", 32, "HR", 65000.0),
                new Employee("Смирнов Алексей", 45, "Finance", 120000.0),
                new Employee("Кузнецова Ольга", 28, "IT", 90000.0),
                new Employee("Попов Дмитрий", 38, "Sales", 75000.0),
                new Employee("Соколова Анна", 22, "Marketing", 50000.0)
        ));

        System.out.println("Исходный список сотрудников:");
        employees.forEach(System.out::println);

        List<String> formattedEmployees = formatEmployees(employees);

        System.out.println("\nСписок строк вида 'Имя - Отдел':");
        formattedEmployees.forEach(System.out::println);
    }

    public static List<String> formatEmployees(List<Employee> employees) {
        if (employees == null) {
            return new ArrayList<>();
        }

        return employees.stream()
                .map(emp -> emp.getFullName() + " - " + emp.getDepartment())
                .collect(Collectors.toList());
    }
}

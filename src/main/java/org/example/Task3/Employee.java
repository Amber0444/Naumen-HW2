package org.example.Task3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private String fullName;
    private Integer age;
    private String department;
    private Double salary;

    public Employee(String fullName, Integer age, String department, Double salary) {
        this.fullName = fullName;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("ФИО='%s', Возраст=%d, Отдел='%s', ЗП=%.2f",
                fullName, age, department, salary);
    }
}

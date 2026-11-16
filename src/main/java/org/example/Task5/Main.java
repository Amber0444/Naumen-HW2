package org.example.Task5;

public class Main {
    public static void main(String[] args) {
        Task5 task = new Task5();

        task.addData("Файл_1.txt");
        task.addData("Файл_2.txt");
        task.addData("STOP");
        task.addData("Файл_3.txt");

        task.start();

        System.out.println("Программа завершила работу.");
    }
}

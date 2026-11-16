package org.example;

import java.util.Random;
import java.util.Scanner;

public class Task1 {
    // 4 вариант
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов массива (n >= 0): ");
        int n = scanner.nextInt();

        int[] array = generateRandomArray(n);

        System.out.print("Сгенерированный массив: ");
        printArray(array);

        Integer lastPositive = findLastPositive(array);

        if (lastPositive != null) {
            System.out.println("Последний положительный элемент: " + lastPositive);
        } else {
            System.out.println("В массиве нет положительных элементов.");
        }

        scanner.close();
    }

    public static int[] generateRandomArray(int n) {
        if (n == 0) return new int[0];

        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(1000) - 500;
        }
        return array;
    }

    public static Integer findLastPositive(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > 0) {
                return array[i];
            }
        }
        return null;
    }

    public static void printArray(int[] array) {
        if (array.length == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

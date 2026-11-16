package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    // 4 вариант
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов списка (n >= 0): ");
        int n = scanner.nextInt();

        ArrayList<Double> list = generateRandomList(n);

        System.out.println("Исходный список:");
        printList(list);

        selectionSort(list);

        System.out.println("\nОтсортированный список (Сортировка выбором):");
        printList(list);

        scanner.close();
    }

    public static ArrayList<Double> generateRandomList(int n) {
        ArrayList<Double> list = new ArrayList<>();
        if (n == 0) return list;

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            double value = -100.0 + (200.0 * random.nextDouble());
            value = Math.round(value * 100.0) / 100.0;
            list.add(value);
        }
        return list;
    }

    public static void selectionSort(ArrayList<Double> list) {
        if (list == null || list.size() <= 1) {
            return;
        }

        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                Double temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }

    public static void printList(ArrayList<Double> list) {
        System.out.println(list);
    }
}

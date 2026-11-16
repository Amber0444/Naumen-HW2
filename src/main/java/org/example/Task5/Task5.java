package org.example.Task5;

import java.util.LinkedList;
import java.util.Queue;

public class Task5 implements Task {
    private final Queue<String> queue;
    private boolean isRunning;

    public Task5() {
        this.queue = new LinkedList<>();
        this.isRunning = false;
    }

    public void addData(String data) {
        queue.offer(data);
    }

    @Override
    public void start() {
        if (isRunning) {
            System.out.println("Задача уже выполняется.");
            return;
        }

        isRunning = true;
        System.out.println("Запуск обработки очереди");

        while (isRunning && !queue.isEmpty()) {
            String data = queue.poll();

            System.out.println("Обработка данных: " + data);

            if ("STOP".equalsIgnoreCase(data)) {
                System.out.println("Получен сигнал остановки!");
                stop();
            }
        }

        if (isRunning && queue.isEmpty()) {
            System.out.println("Очередь пуста, обработка завершена");
            isRunning = false;
        }
    }

    @Override
    public void stop() {
        isRunning = false;
        System.out.println("Обработка очереди остановлена");

        if (!queue.isEmpty()) {
            System.out.println("Очистка оставшихся элементов в очереди (" + queue.size() + " шт.)");
            queue.clear();
        }
    }
}

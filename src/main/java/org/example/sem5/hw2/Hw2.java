package org.example.sem5.hw2;
// Написать программу, которая найдёт и выведет повторяющиеся имена
// с количеством повторений. Отсортировать по убыванию популярности.

import java.util.*;

public class Hw2 {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList(
                "иван иванов",
                "светлана петрова",
                "кристина белова",
                "анна мусина",
                "анна крутова",
                "иван юрин",
                "петр лыков",
                "павел чернов",
                "петр чернышов",
                "мария федорова",
                "марина светлова",
                "мария савина",
                "мария рыкова",
                "марина лугова",
                "анна владимирова",
                "иван мечников",
                "петр петин",
                "иван ежов"
        );
        Map<String, Integer> namesCount = new HashMap<>();
        for (String employee : employees) {
            String[] parts = employee.split("\\s+");
            String name = parts[0];
            if (namesCount.containsKey(name)) {
                namesCount.put(name, namesCount.get(name) + 1);
            } else {
                namesCount.put(name, 1);
            }
        }
        List<Map.Entry<String, Integer>> sortedNames =
                new ArrayList<>(namesCount.entrySet());
        sortedNames.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        for (Map.Entry<String, Integer> name : sortedNames) {
            if (name.getValue() > 1) {
                System.out.println(name);
            }
        }
    }
}
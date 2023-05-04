package org.example.sem5.hw1;
// Подсчитать количество искомого слова, через map (наполнением значение,
// где искомое слово будет являться ключом), вносить все слова не нужно.
// Пример:
// Россия идет вперед всей планеты. Планета — это не Россия.
// Запрос: Россия
// Ответ: Россия - 2
// toLoverCase().

import java.util.HashMap;
import java.util.Map;

public class Hw1 {
    public static void main(String[] args) {

        String text = "Уверенность в себе воина и самоуверенность обычного человека – " +
                "это разные вещи. Обычный человек ищет признания в глазах окружающих, " +
                "называя это уверенностью в себе. Воин ищет безупречности в собственных " +
                "глазах и называет это смирением. Обычный человек цепляется за окружающих, " +
                "а воин рассчитывает только на себя.";

        text = text.replaceAll("[-|—]|\\p{Punct}", " ");
        while (text.contains("  ")) {
            text = text.replace("  ", " ");
        }
        String findWord = "Воин";
        String[] arrayText = text.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String currentWord : arrayText) {
            if (!findWord.equalsIgnoreCase(currentWord)) {
                continue;
            }
            int count = map.getOrDefault(findWord.toLowerCase(), 0);
            map.put(currentWord.toLowerCase(), ++count);
        }
        System.out.println(findWord + " - " + map.getOrDefault(findWord.toLowerCase(), 0));
    }
}
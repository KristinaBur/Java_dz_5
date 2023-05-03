import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task_2 {
    public static void main(String[] args) {
        String str = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";

        System.out.println(getSortNames(str));
    }

    public static Map getSortNames(String str) {
        String strmas[] = str.split(", ");
        HashMap<String, Integer> names = new HashMap<>();
        for (String it : strmas) {
            String name = it.split(" ")[0];
            if (names.containsKey(name)) {
                names.replace(name, names.get(name) + 1);
            } else {
                names.put(name, 1);
            }
        }

        TreeMap<Integer, List<String>> names2 = new TreeMap<>();
        for (String it : names.keySet()) {
            if (names2.containsKey(names.get(it))) {
                names2.get(names.get(it)).add(it);
            } else {
                List<String> list = new ArrayList<>();
                list.add(it);
                names2.put(names.get(it), list);
            }

        }
        return names2.descendingMap();
    }
}



// import java.util.ArrayList;
// import java.util.LinkedHashMap;
// import java.util.List;
// import java.util.Map;

// public class Task_2 {
//     public static void main(String[] args) {
//         List<String> workers = List.of("Иван Иванов", "Светлана Петрова", "Кристина Белова",
//                 "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова",
//                 "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов");

//         String[] array;
//         List<String> workers_name = new ArrayList<>();

//         for (int i = 0; i < workers.size(); i++) {
//             array = workers.get(i).split(" ", 2);
//             workers_name.add(array[0]);
//         }
//         System.out.println(calcAndSort(workers_name));
//     }

//     static Map<String, Integer> calcAndSort(List<String> workers_name) {
//         Map<String, Integer> nameCount = new LinkedHashMap<>();
//         for (int i = 0; i < workers_name.size(); i++) {
//             if (nameCount.containsKey(workers_name.get(i))) {
//                 nameCount.put(workers_name.get(i), nameCount.get(workers_name.get(i)) + 1);
//             } else {
//                 nameCount.put(workers_name.get(i), 1);
//             }
//         }

//         Map<String, Integer> sorted = new LinkedHashMap<>();
//         int max_value = 0;
//         for (int value : nameCount.values()) {
//             if (value > max_value) {
//                 max_value = value;
//             }
//         }
//         for (int i = max_value; i > 0; i--) {
//             for (Map.Entry<String, Integer> count : nameCount.entrySet()) {
//                 String key = count.getKey();
//                 if (nameCount.get(key) == i) {
//                     sorted.put(key, nameCount.get(key));
//                 }
//             }
//         }
//         return sorted;
//     }
// }

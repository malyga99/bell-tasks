package firstTask;

import java.util.List;
import java.util.Map;

public class FirstTask {

    private List<Map<String, String>> table;

    {
        initTable();
    }

    private void initTable() {
        table = List.of(
                Map.of(
                        "Имя", "Максим",
                        "Возраст", "32",
                        "Должность", "Middle java dev",
                        "Зарплата", "$ 1200"
                ),
                Map.of(
                        "Имя", "Иван",
                        "Возраст", "25",
                        "Должность", "Junior java dev",
                        "Зарплата", "50000 ₽"
                ),
                Map.of(
                        "Имя", "Мария",
                        "Возраст", "35",
                        "Должность", "Senior java automation QA",
                        "Зарплата", "160000 ₽"
                ),
                Map.of(
                        "Имя", "Петр",
                        "Возраст", "28",
                        "Должность", "Dev-ops",
                        "Зарплата", "$ 1700"
                ),
                Map.of(
                        "Имя", "Анна",
                        "Возраст", "31",
                        "Должность", "Middle functional test",
                        "Зарплата", "€ 1100"
                ),
                Map.of(
                        "Имя", "Кирилл",
                        "Возраст", "36",
                        "Должность", "Senior java dev",
                        "Зарплата", "€ 2500"
                ),
                Map.of(
                        "Имя", "Дмитрий",
                        "Возраст", "22",
                        "Должность", "Junior java automation QA",
                        "Зарплата", "45000 ₽"
                )
        );
    }

    public List<Map<String, String>> getTable() {
        return table;
    }

    public static void main(String[] args) {
        FirstTask firstTask = new FirstTask();
        List<Map<String, String>> table = firstTask.getTable();

        double avgAge = findAvgAge(table);
        System.out.println("Средний возраст: " + avgAge);

        List<String> names = findNames(table);
        System.out.println("Имена сотрудников, младше 30: " + names);

        List<String> namesWithRublesSalary = findNamesWithRublesSalary(table);
        System.out.println("Имена сотрудников, получающих ЗП в рублях: " + namesWithRublesSalary);
    }

    private static double findAvgAge(List<Map<String, String>> table) {
        return table.stream()
                .mapToInt(el -> Integer.parseInt(el.get("Возраст")))
                .average()
                .orElseThrow(() -> new RuntimeException("Таблица пустая"));
    }

    private static List<String> findNames(List<Map<String, String>> table) {
        return table.stream()
                .filter(el -> Integer.parseInt(el.get("Возраст")) < 30)
                .map(el -> el.get("Имя"))
                .toList();
    }

    private static List<String> findNamesWithRublesSalary(List<Map<String, String>> table) {
        return table.stream()
                .filter(el -> el.get("Зарплата").contains("₽"))
                .map(el -> el.get("Имя"))
                .toList();
    }
}

import java.util.*;

public class Task_1 {
    public static void main(String[] args) {
        Map<String, StringBuilder> phoneBook = new HashMap<String, StringBuilder>();
        Scanner input = new Scanner(System.in, "cp866");
        while (true) {
            System.out.println("Введите команду:\n" +
            "add - Добавить контакт\n" +
            "find - Найти контакт\n" +
            "all - Вывести телефонную книгу");
            String comand = new String();
            comand = input.next();
            switch (comand) {

                case "add":
                    input.nextLine();
                    System.out.println("Введите имя: ");
                    String manName = input.nextLine();
                    System.out.println("Введите номер телефона: ");
                    String tempPhNum = input.next();
                    StringBuilder phoneNumber = new StringBuilder();
                    phoneNumber.append(tempPhNum);

                    if (phoneBook.containsKey(manName)) {
                        StringBuilder temp = new StringBuilder();                
                        temp = phoneBook.get(manName);
                        temp.append(" " + phoneNumber);
                        phoneBook.put(manName, temp);
                    } else phoneBook.put(manName, phoneNumber);

                    break;

                case "find":
                    input.nextLine();
                    System.out.println("Введите имя: ");
                    String findCon = input.nextLine();

                    if (phoneBook.containsKey(findCon)) {
                        System.out.println(phoneBook.get(findCon));
                    } else System.out.println("Такого контакта нет");

                    break;

                default:
                    System.out.println("Некорректная команда!");
                    break;

                case "all":
                System.out.println(phoneBook);
                break;
            }
            //System.out.println(phoneBook);
        }
    }
}
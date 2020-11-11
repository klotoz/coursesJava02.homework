package homework3;


import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
        String[] fruit = {"яблоко", "банан", "яблоко", "ежевика", "малина", "арбуз", "клубника", "малина", "дыня", "арбуз", "клубника", "малина"};
        HashMap<String, Integer> map = new HashMap<>();
        for(String x : fruit) {
            map.put(x, map.getOrDefault(x, 0) +1); //не уверена, что так можно, но мне так больше нравится.
        /*    Integer value = map.getOrDefault(x, 0);
            map.put(x, value+1); */
        }
        System.out.println(map);


        PhoneBook book = new PhoneBook();
        book.addContact("Ivanov", "89990001515");
        book.addContact("Petrov", "89997097777");
        book.addContact("Sidorov", "89995444456");
        book.addContact("Bugaev", "89997776565");
        book.addContact("Romancev", "89997773737");
        book.addContact("Romancev", "89997773737");
        book.addContact("Ivanov", "89990001514");
        book.addContact("Ivanov", "89990001510");

        book.findContact("Popov");
        book.findContact("Ivanov");
        book.findContact("Petrov");
        book.findContact("Romancev");
    }




}

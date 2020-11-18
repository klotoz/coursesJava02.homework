package homework3;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    HashMap<String, HashSet<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void addContact(String surname, String phone){
        HashSet<String> book = phoneBook.getOrDefault(surname, new HashSet<>());
        book.add(phone);
        phoneBook.put(surname, book);

    }
    public void findContact(String surname){
        System.out.println("Контакт: " + surname + " , номер телефона: " + phoneBook.getOrDefault(surname, new HashSet<>()));
    }
}

package ru.gb.jtwo.clesson.myhome;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    HashMap<String, ArrayList<String>> phonebook;

        public Phonebook() {
            this.phonebook = new HashMap<>();
        }

        public void addContact(String name, String phone) {
            ArrayList<String> book = phonebook.getOrDefault(name, new ArrayList<>());
            book.add(phone);
            phonebook.put(name, book);
        }

        public void getPhone(String name) {
            System.out.println("Фамилия: " + name + " / Телефон " + phonebook.getOrDefault(name, new ArrayList<>()));
        }
}

package ru.gb.jtwo.clesson.myhome;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        arrayListSample();

        Phonebook phonebook = new Phonebook();
        phonebook.addContact("Ivanov","123456");
        phonebook.addContact("Ivanov","234567");
        phonebook.addContact("petrov","345678");
        phonebook.addContact("sidorov","385678");
        phonebook.addContact("dorov","885678");

        phonebook.getPhone("sidorov");
        phonebook.getPhone("Ivanov");
    }

    private static void arrayListSample() {
        String[] str = {"one", "two", "free", "four", "five","six","seven","eigth","ten","one","one","two","five","ten"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(str));
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        System.out.println("количество вхождений элемента 'ten': " + getNumber(list,"ten"));
        System.out.println("количество вхождений элемента 'one': " + getNumber(list,"one"));
        System.out.println("количество вхождений элемента 'six': " + getNumber(list,"six"));
    }
    private static int getNumber(ArrayList<String> list, String str) {
        return list.lastIndexOf(str) - list.indexOf(str) + 1;
    }
}

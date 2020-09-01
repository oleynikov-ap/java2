package ru.gb.jtwo.blesson.myhome;

import java.io.IOException;

public class MyException extends IOException{
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }
}

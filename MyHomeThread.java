package ru.gb.jtwo.elesson.myhome;

public class MyHomeThread extends Thread{
    public float[] arr;
    public int pos;
    public MyHomeThread(String name, float[] arr, int pos) {
        super(name);
        this.arr = arr;
        this.pos = pos;
    }

    public MyHomeThread(String name, float v, int pos) {
    }

    @Override
    public void run() {
        Main.changeArray(this.arr,pos);
    }
}

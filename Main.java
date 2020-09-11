package ru.gb.jtwo.elesson.myhome;

import com.sun.istack.internal.XMLStreamReaderToContentHandler;
import ru.gb.jtwo.elesson.online.MyThread;

import java.util.Arrays;

public class Main {
    private static final int size = 10000000;
    private static final int countThread = 2;
    private static final int h = size / countThread;
    private static float[] arr1 = new float[size];
    private static float[] arr2 = new float[size];
    private static float[][] arr = new float[countThread][];
    private static MyHomeThread[] mTH = new MyHomeThread[countThread];

    public static void changeArray(float[] arr, int pos){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + pos / 5) * Math.cos(0.2f + pos / 5) * Math.cos(0.4f + pos++ / 2));
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < arr1.length; i++) arr1[i] = 1;
        long a = System.currentTimeMillis();
        MyHomeThread m0 = new MyHomeThread("thread #0", arr1, 0);
        m0.start();
        try {
            m0.join(); // while (m.isAlive());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Cоздание массива одним потоком: " + (System.currentTimeMillis() - a));

        for (int i = 0; i < arr2.length; i++) arr2[i] = 1;

        a = System.currentTimeMillis();
        for (int i = 0; i < mTH.length; i++) {
            arr[i] = new float[h];
            System.arraycopy(arr2, i * h, arr[i], 0, h);
            mTH[i] = new MyHomeThread("thread #" + i, arr[i], i * h);
            mTH[i].start();
        }
        for (int i = 0; i < mTH.length; i++) {
            try {
                mTH[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < mTH.length; i++) {
            System.arraycopy(arr[i], 0, arr2, i * h, h);
            }
        System.out.println("Cоздание массива с " + countThread + " потоками: " + (System.currentTimeMillis() - a));

        System.out.println("Проверка на равенство: " + Arrays.equals(arr1, arr2));
    }
}

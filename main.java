package ru.gb.jtwo.blesson.myhome;

import java.io.IOException;

public class main {
    private static final int LEN_MATRIX = 4;
    private static String str;
    private static String[][] matrix = new String[LEN_MATRIX][LEN_MATRIX];
    private static int[] summArray = new int[LEN_MATRIX];

    public static void main(String[] args) {
    str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
//    str = "10 3 1 2\n2 3 2 2\n5 6 4 7 1\n300 3 1 0";
//    str = "10 3 1 2\n2 3 2 2\n5 6 4 f\n300 3 1 0";
        try
        {
            toMatrix(matrix, str);
            summMatrix(summArray);
            printMatrix(matrix);
            for (int i = 0; i < matrix.length; i++) {
                System.out.println("Сумма " + (i + 1) + "-ой строк равна: " + summArray[i]);
            }
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("IntFormat: " + nfe.getMessage());
        }
        catch (MyException myexc)
        {
            System.out.println(myexc.getMessage());
        }
    }

    public static void toMatrix (String[][] matrix, String str) throws MyException {
        String[] tempStr = str.split("\n");
        String[] tempStrMatrix;
        if (tempStr.length != LEN_MATRIX) throw new MyException("Ошибка: Неверно указан размер матрицы: " + tempStr.length);
        for (int i = 0; i < tempStr.length ; i++) {
            tempStrMatrix = tempStr[i].split(" ");
            if (tempStrMatrix.length != LEN_MATRIX) throw new MyException("Ошибка: длина " + (i + 1) + "-ой строки: " + tempStrMatrix.length);
            matrix[i] = tempStrMatrix;
        }
    }

    public static int summArray(String[] strArray){
        int summ = 0;
        for (int i = 0; i < strArray.length; i++) {
            summ += Integer.parseInt(strArray[i]);
        }
        return summ / 2;
    }

    public static void summMatrix( int[] summArray){
        for (int i = 0; i < matrix.length; i++) {
            summArray[i] = summArray(matrix[i]);
        }
    }

    public static void printMatrix (String[][] matrix){
        for (int i = 0; i < LEN_MATRIX; i++) {
            for (int j = 0; j < LEN_MATRIX; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}

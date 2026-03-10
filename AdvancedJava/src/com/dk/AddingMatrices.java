package com.dk;

import java.util.*;

class AdditionRow extends Thread {
    int[] row1;
    int[] row2;
    int[] rowFinal;
    int j;

    AdditionRow(int[] row1, int[] row2, int[] rowFinal, int j) {
        this.row1 = row1;
        this.row2 = row2;
        this.rowFinal = rowFinal;
        this.j = j;
    }

    @Override
    public void run() {
        for (int i = 0; i < row1.length; i++) {
            rowFinal[i] = row1[i] + row2[i];
        }
        System.out.println("Completed for index "+j+" : " + Arrays.toString(rowFinal));
    }
}

public class AddingMatrices {
    public static void main(String[] args) throws InterruptedException {

        List<Thread> list = new ArrayList<>();

        int[][] matrix1 = {
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1}
        };

        int[][] matrix2 = {
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1}
        };

        int[][] result = new int[5][5];

        for (int j = 0; j < result.length; j++) {
            Thread t = new AdditionRow(matrix1[j], matrix2[j], result[j], j);
            list.add(t);
            t.start();
        }

        for (Thread t : list) {
            t.join();
        }

    }
}
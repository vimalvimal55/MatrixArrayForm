package com.aimia.aip.reporting.service.export;

import org.junit.jupiter.api.Test;

class TestClass1 {


    @Test
    public void getMethod() {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int executionDiagnol = 0;
        int[] newArray = new int[40];
        int newArrayPosition = 0;
        for (int i = 0; i < 1; i++) {
            System.out.println("i is " + i);
            for (int j = 0; j < i + matrix[0].length; j++) {
                System.out.println("j is " + j);

                if (executionDiagnol % 2 != 0) {
                    for (int row = i, col = j; col >= 0 && row < matrix[0].length && col < matrix[0].length; row++, col--) {
                        System.out.println("(" + row + "," + col + ")");
                        System.out.println("matrix[row][col] is" + matrix[row][col]);
                        newArray[newArrayPosition++] = matrix[row][col];
                    }
                } else {
                    for (int row = i, col = j; col >= 0 && row < matrix[0].length && col < matrix[0].length; row++, col--) {
                        System.out.println("(" + col + "," + row + ")");
                        System.out.println("matrix[row][col] is" + matrix[col][row]);
                        newArray[newArrayPosition++] = matrix[col][row];
                    }
                }
                executionDiagnol++;
            }
            System.out.print("======================");


            for (i = matrix[0].length - 1; i < matrix[0].length; i++) {
                System.out.println("i is " + i);
                for (int j = 1; j < matrix[0].length; j++) {
                    System.out.println("j is " + j);

                    if (executionDiagnol % 2 != 0) {
                        for (int row = i, col = j; row >= 0 && row < matrix[0].length && col < matrix[0].length; row--, col++) {
                            System.out.println("(" + col + "," + row + ")");
                            System.out.println("matrix[row][col] is" + matrix[col][row]);
                            newArray[newArrayPosition++] = matrix[col][row];
                        }
                    } else {
                        for (int row = i, col = j; col >= 0 && row < matrix[0].length && col < matrix[0].length; row++, col--) {
                            System.out.println("(" + col + "," + row + ")");
                            System.out.println("matrix[row][col] is" + matrix[col][row]);
                            newArray[newArrayPosition++] = matrix[col][row];
                        }
                    }
                    executionDiagnol++;
                }
            }

        }

        System.out.println(newArray.toString());
        for (int i = 0; i < matrix[0].length * matrix[0].length; i++) {
            System.out.print(newArray[i]);
            System.out.print(",");
        }

    }
}


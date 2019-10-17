package com.aimia.aip.reporting.service.export;

import org.junit.jupiter.api.Test;

class TestClass2 {


    @Test
    public void getMethod() {
        int[][] matrix = {{1, 2, 3, 4},
                {4, 3, 2, 1},
                {7, 8, 9, 6},
                {6, 5, 4, 3},
        };


        int principleSum = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.println("matrix[row][col] is" + matrix[i][i]);
            principleSum = principleSum + matrix[i][i];
        }

        int secondorySum = 0;
        for (int i = 0, j = matrix[0].length - 1; i < matrix[0].length; i++, j--) {
            System.out.println("matrix[row][col] is" + matrix[i][j]);
            secondorySum = secondorySum + matrix[i][j];
        }


        System.out.println("principleSum is " + principleSum);
        System.out.println("secondorySum is " + secondorySum);

    }
}


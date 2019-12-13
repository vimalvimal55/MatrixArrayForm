import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class solution {
    public static final String SPACE = " ";

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        int numberOfTestCases = Integer.parseInt(s1.nextLine());

        for (int i = 0; i < numberOfTestCases; i++) {

            String[] matrixMeta = s1.nextLine().split(SPACE);
            Integer rowCount = Integer.valueOf(matrixMeta[0]);
            Integer columnCount = Integer.valueOf(matrixMeta[1]);
            int[][] matrix = new int[rowCount][columnCount];

            for (int row = 0; row < rowCount; row++) {
                String[] rowInputData = s1.nextLine().split(SPACE);
                for (int column = 0; column < columnCount; column++) {
                    matrix[row][column] = Integer.parseInt(rowInputData[column]);
                }
            }

            ArrayParent p = new ArrayParent(rowCount, columnCount, matrix);
            p.setCentres();
            p.generateMaxValues();
            System.out.println(p.findDifference());

        }
    }

    static class ArrayParent {
        int row;
        int column;
        int[][] matrix;
        List<Array> centres;
        List<Array> maxValues = new ArrayList<>();

        public ArrayParent(int row, int column, int[][] matrix) {
            this.row = row;
            this.column = column;
            this.matrix = matrix;
        }

        private static int getCentreRow1(int row) {
            int centreRow1 = 0;
            if (row % 2 != 0 && row >= 2) {
                centreRow1 = (row - 1) / 2;
            } else {
                if (row >= 2) {
                    centreRow1 = (row / 2) - 1;
                }

            }

            return centreRow1;
        }

        private static int getCentreRow(int row) {
            int centreRow = 0;
            if (row % 2 != 0 && row >= 2) {
                centreRow = (row - 1) / 2;
            } else {
                if (row >= 2) {
                    centreRow = (row / 2);
                }

            }
            return centreRow;
        }

        public Integer findDifference() {
            List<Integer> listOfInts = new ArrayList<>();

            maxValues.forEach(s -> centres.forEach(c -> {
                listOfInts.add(findDifferenceBetweenSteps(s, c));
            }));
            return Collections.min(listOfInts);
        }

        public int findDifferenceBetweenSteps(Array a, Array b) {
            int rowDiff = a.left - b.left;
            if (rowDiff < 0) {
                rowDiff = rowDiff * -1;
            }
            int columnDiff = a.right - b.right;
            if (columnDiff < 0) {
                columnDiff = columnDiff * -1;
            }
            return rowDiff + columnDiff;
        }

        public void generateMaxValues() {
            int max = this.matrix[0][0];
            for (int r = 0; r < this.row; r++) {
                for (int c = 0; c < this.column; c++) {
                    if (this.matrix[r][c] > max) {
                        max = this.matrix[r][c];
                    }
                }
            }
            this.maxValues = new ArrayList<>();
            for (int r = 0; r < this.row; r++) {
                for (int c = 0; c < this.column; c++) {
                    if (this.matrix[r][c] == max) {
                        this.maxValues.add(new Array(r, c));
                    }
                }
            }

        }

        public void setCentres() {
            List<Array> list = new ArrayList<>();
            list.add(new Array(getCentreRow(row), getCentreRow(column)));
            list.add(new Array(getCentreRow1(row), getCentreRow1(column)));
            if (row % 2 == 0 && column % 2 == 0) {
                list.add(new Array(getCentreRow(row), getCentreRow1(column)));
                list.add(new Array(getCentreRow1(row), getCentreRow(column)));
            }

            setCentres(list);
        }

        public void setCentres(List<Array> centres) {
            this.centres = centres;
        }

    }

    static class Array {
        int left;
        int right;

        public Array(int left, int right) {
            this.left = left;
            this.right = right;
        }

    }

}



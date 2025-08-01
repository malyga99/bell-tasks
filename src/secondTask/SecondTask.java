package secondTask;

public class SecondTask {

    private int[][] matrix;

    {
        initMatrix();
    }

    private void initMatrix() {
        matrix = new int[][] {
                {1, 8, 2, 2, 13},
                {6, 7, 33, 1, 12},
                {3, 2, 24, 5, -2},
                {75, 68, 9, 5, 0},
                {2, 88, 55, -5, 56}
        };
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public static void main(String[] args) {
        SecondTask secondTask = new SecondTask();
        int[][] matrix = secondTask.getMatrix();

        int minElement = findMinElement(matrix);
        System.out.println("Минимальный элемент диагонали: " + minElement);
    }

    private static int findMinElement(int[][] matrix) {
        int len = matrix.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            if (i != len - 1 - i) {
                int firstDiagonal = matrix[i][i];
                int secondDiagonal = matrix[i][len - 1 - i];
                min = Math.min(min, Math.min(firstDiagonal, secondDiagonal));
            }
        }

        return min;
    }
}

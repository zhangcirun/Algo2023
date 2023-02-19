package Go2023;

public class SearchA2DMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length * matrix[0].length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int i = mid / matrix[0].length;
            int j = mid % matrix[0].length;

            if (matrix[i][j] == target) {
                return true;
            }

            if (matrix[i][j] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        int i1 = start / matrix[0].length;
        int j1 = start % matrix[0].length;
        int i2 = end / matrix[0].length;
        int j2 = end % matrix[0].length;


        return matrix[i1][j1] == target ||matrix[i2][j2] == target;
    }
}

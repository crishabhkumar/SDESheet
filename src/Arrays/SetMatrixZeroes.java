package Arrays;
import java.util.*;
/**
 * SetMatrixZeroes
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

        setZeroes(matrix);
        for(int[] arr : matrix){
            System.out.println(Arrays.toString(arr));
        }
    }

    //Brute Force Approach
    // public static void setZeroes(int[][] matrix) {
    //     for(int i = 0;i < matrix.length;i++){
    //         for(int j = 0;j < matrix[i].length;j++){
    //             if(matrix[i][j] == 0){
    //                 for(int k = 0;k<matrix[i].length;k++){
    //                     matrix[i][k] = -1;
    //                 }
    //                 for(int k = 0; k < matrix.length;k++){
    //                     matrix[k][j] = -1;
    //                 }
    //             }
    //         }
    //     }
    //     for(int i = 0;i<matrix.length;i++){
    //         for(int j = 0;j<matrix[i].length;j++){
    //             if(matrix[i][j] == -1){
    //                 matrix[i][j] = 0;
    //             }
    //         }
    //     }
    // }

    //Optimal Solution
    //T.C. = O((N * M) * (N+M) + (N*M))
    //S.C. = O(N) + O(M)
    // public static void setZeroes(int[][] matrix) {
    //     int[] rows = new int[matrix.length];
    //     int[] cols = new int[matrix[0].length];

    //     Arrays.fill(rows, 0);
    //     Arrays.fill(cols, 0);

    //     for(int i = 0;i < matrix.length;i++){
    //         for(int j = 0;j < matrix[i].length;j++){
    //             if(matrix[i][j] == 0){
    //                     rows[i] = 1;
    //                     cols[j] = 1;

    //             }
    //         }
    //     }
    //     for(int i = 0;i<matrix.length;i++){
    //         for(int j = 0;j<matrix[i].length;j++){
    //             if(rows[i] == 1 || cols[j] == 1){
    //                 matrix[i][j] = 0;
    //             }
    //         }
    //     }
    // }

    //Best
    //T.C. = O(2 * N * M)
    //S.C. = O(1)
    public static void setZeroes(int[][] matrix) {
        //int[] rows = new int[matrix.length];    //matrix[0][...]
        //int[] cols = new int[matrix[0].length]; //matrix[...][0]
        int temp = 1;

        // Arrays.fill(rows, 0);
        // Arrays.fill(cols, 0);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;

                    if(j == 0){
                        temp = 0;
                    }else{
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int i = 0;i<matrix[0].length;i++){
                matrix[0][i] = 0;
            }
        }
        if(temp == 0){
            for(int i = 0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
    }

}


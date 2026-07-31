class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int low = 0, high = m * n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int i = mid / n;
            int j = mid % n;

            if(matrix[i][j] < target){
                low = mid + 1;
            }
            else if(matrix[i][j] > target){
                high = mid - 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}

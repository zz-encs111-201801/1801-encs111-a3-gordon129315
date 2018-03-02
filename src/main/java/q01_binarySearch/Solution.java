package q01_binarySearch;

public class Solution {
    public boolean contains(int[] arr, int value){
        return  binarySearchRecurse(arr, 0 , arr.length, value);
    }

    public boolean binarySearchRecurse(int[] arr, int i, int j, int q) {
        if (i >= j) {
            return false;
        }

        int mid = i + (j - i) / 2;
        if (arr[mid] > q) {
            return binarySearchRecurse(arr, i, mid, q);
        }
        else if (arr[mid] < q) {
            return binarySearchRecurse(arr, mid + 1, j, q);
        }
        else if (arr[mid] == q) {
            return true;
        }
        return false;
    }
}

package q02_quickSelect;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int getAtRank(int[] arr, int rank) {
        int pivot = arr[0];
        List<Integer> leftList = new LinkedList<>();
        List<Integer> rightList = new LinkedList<>();

        for (int j = 1; j < arr.length; j++) {
            if (arr[j] < pivot) {
                leftList.add(arr[j]);
            }
            else if (arr[j] >= pivot) {
                rightList.add(arr[j]);
            }
        }

        if (leftList.size() == rank) {
            return pivot;
        }
        else if (leftList.size() > rank) {
            int[] newArr = ListToArray(leftList);
            return getAtRank(newArr, rank);
        }
        else if (leftList.size() < rank) {
            int[] newArr = ListToArray(rightList);
            return getAtRank(newArr, rank - leftList.size() - 1);
        }

        return 0;
    }

    private int[] ListToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}

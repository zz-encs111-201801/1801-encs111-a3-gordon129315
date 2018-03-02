package q03_quickSort;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public void quickSort(int[] arr) {
        List<Integer> list = quickSortRecurse(ArrayToList(arr));
//        System.out.println(list);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }

    private List<Integer> quickSortRecurse(List<Integer> list) {
        if (list.size() == 0 || list.size() == 1) {
            return list;
        }

        int pivot = list.get(0);
        List<Integer> leftList = new LinkedList<>();
        List<Integer> rightList = new LinkedList<>();

        for (int j = 1; j < list.size(); j++) {
            if (list.get(j) < pivot) {
                leftList.add(list.get(j));
            }
            else if (list.get(j) > pivot) {
                rightList.add(list.get(j));
            }
        }

        List<Integer> newList = quickSortRecurse(leftList);
        newList.add(pivot);
        newList.addAll(quickSortRecurse(rightList));

        return newList;
    }

    private List<Integer> ArrayToList(int[] arr) {
        List<Integer> list = new LinkedList<>();
        for (int v : arr) {
            list.add(v);
        }
        return list;
    }
}

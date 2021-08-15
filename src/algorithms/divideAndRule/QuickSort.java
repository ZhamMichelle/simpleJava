package algorithms.divideAndRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(48, 5, 2, 3, 14, 1));
        System.out.println(quickSort(arr));
    }

    public static List<Integer> quickSort(List<Integer> arr) {
        List<Integer> lessArr = new ArrayList<>();
        List<Integer> highArr = new ArrayList<>();
        List<Integer> mainArr = new ArrayList<>();
        if (arr.size() <= 2)
            return arr;
        else {
            int pivot = arr.get(0);
            mainArr.add(pivot);
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) < pivot)
                    lessArr.add(arr.get(i));
                else if (arr.get(i) > pivot)
                    highArr.add(arr.get(i));
            }
            System.out.println("less: " + lessArr);
            System.out.println("high: " + highArr);
            System.out.println("main: " + mainArr);
            mainArr.addAll(mainArr.size(), quickSort(highArr));
            mainArr.addAll(0, quickSort(lessArr));

            return mainArr;
        }
    }
}

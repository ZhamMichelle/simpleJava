package algorithms.divideAndRule;

import java.util.Arrays;

public class ArraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{105, 2, 440, 6, 2, 220};
        int[] arr2 = new int[]{2, 8, 9, 35, 75,105};
//        System.out.println(recursion(arr, arr.length-1));
//        System.out.println(recursion1(arr));
//        System.out.println(recursion2(arr));
//
//        System.out.println(fact(4));

//        System.out.println(recursion3(arr));
//        System.out.println("max: " + max(arr));

        System.out.println(binarySearch(arr2, 105, 0, arr2.length));
    }

    public static int binarySearch(int[] arr, int n, int bottom, int top) {
        int middle = (top + bottom) / 2;
        if (arr[middle] == n)
            return middle;
        else if (arr[middle] < n){
            System.out.println("top1: "+top);
            System.out.println("bottom1: "+bottom);
            return binarySearch(arr, n, middle, top);}
        else{
            System.out.println("top: "+top);
            System.out.println("bottom: "+bottom);
            return binarySearch(arr, n, bottom, middle);}
    }

    public static int recursion(int[] arr, int size) {
        if (size == 0)
            return arr[0];
        else
            return arr[size] + recursion(arr, size - 1);
    }

    public static int recursion1(int[] arr) {
        if (arr.length == 1)
            return arr[0];
        else
            return arr[0] + recursion1(Arrays.copyOfRange(arr, 1, arr.length));
    }

    public static int recursion2(int[] arr) {
        if (arr.length == 1)
            return arr[0];
        else
            return arr[arr.length - 1] + recursion2(Arrays.copyOf(arr, arr.length - 1));
    }

    public static int fact(int n) {
        if (n == 1)
            return n;
        else
            return n * fact(n - 1);
    }

    public static int recursion3(int[] arr) {
        if (arr.length == 1)
            return 1;
        else
            return 1 + recursion3(Arrays.copyOf(arr, arr.length - 1));
    }

    public static int max(int[] arr) {
        int x = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > x) {
                x = arr[i];
            }
        }
        return x;
    }


}

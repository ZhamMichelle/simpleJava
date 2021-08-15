package algorithms.binarySearch;

import java.time.Duration;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;

public class TheMain {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2, 4, 5, 9, 10, 15, 18, 21,25));
        int place = binary_search(arr, 21, 0, arr.size() - 1);
        //System.out.println(place);

        int place2=binary_search2(arr,25);
        System.out.println(place2);

        Period fromCharUnits = Period.parse("P2Y3M5D");
        System.out.println(fromCharUnits.getDays());

        Duration fromChar2 = Duration.parse("PT10M");
        System.out.println(fromChar2.getSeconds());
    }

    public static Integer binary_search(ArrayList<Integer> arr, int x, int low, int high) {

        int lowPlace = low;
        int highPlace = high;
        int mid = (lowPlace + highPlace) / 2;
        if (arr.get(mid).intValue() == x) {
            return mid;
        } else if (x > arr.get(mid)) {
            return binary_search(arr, x, mid + 1, highPlace);
        } else {
            return binary_search(arr, x, lowPlace, mid);
        }
    }

    public static Integer binary_search2(ArrayList<Integer> arr, int x) {
        int low = 0;
        int high = arr.size()-1;

        while (low <= high) {
            int mid=(high+low)/2;
            if(x== arr.get(mid)){
                return mid;
            }else if(x> arr.get(mid)){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return null;
    }
}



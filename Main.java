package sophiecui;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
//        System.out.print("\nResult is : " + sol.nextClosestTime("23:59"));
        int[] array = {3,1,4,8,2,10,2};
//        int[] array = {5,1,6,3};
        System.out.print("\nResult is : " + printArray(sol.quickSort(array)));
//        System.out.print("\nResult is : " + sol.partition(array, 0, array.length -1, 3));
    }

    public static String printArray(int[] array) {
        String str = "";
        for (int i : array){
            System.out.print(i);
            str = str + i + " ";
        }
        return str;
    }
}

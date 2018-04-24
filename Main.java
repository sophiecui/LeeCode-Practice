package sophiecui;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.print("\nResult is : " + sol.nextClosestTime("23:59"));
//        int[] array = {3,1,4,8,2,10, 2};
        int[] array = {5,1};
        System.out.print("\nResult is : " + printArray(sol.mergeSort(array)));
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

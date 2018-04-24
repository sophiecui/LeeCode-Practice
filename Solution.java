package sophiecui;

import java.util.*;

public class Solution {
    public int max = 1440;

    public String nextClosestTime(String time) {
        Set<Character> items = new HashSet<>();
        char[] array = time.toCharArray();
        for (char c : array) {
            if (c != ':' && !items.contains(c)) {
                items.add(c);
            }
        }
        List<Character> result = new ArrayList<>();
        for (Character c : array) {
            result.add(c);
        }
        List<Character> cur = new ArrayList<>();
        int target = changeTimeToInt(time);
        dfs(items, cur, target, result);
        String str = "";
        for (Character c : result) {
            str += c;
        }
        return str;
    }

    private int changeTimeToInt(String time) {
        char[] array = time.toCharArray();
        int hours = (array[0] - '0') * 10 + array[1] - '0';
        int min = (array[3] - '0') * 10 + array[4] - '0';
        return hours * 60 + min;
    }

    private void dfs(Set<Character> items, List<Character> cur, int target, List<Character> result) {

        if (cur.size() == 4) {

            int temp = changeStringToInt(cur);
            if (temp < 1) return;
            int diff = 0;
            if (temp <= target) {
                diff = 1440 - (target - temp);
            } else {
                diff = temp - target;
            }
            if (diff < max) {
                //update result
                updateResult(cur, result);
                max = diff;
            }
            return;
        }
        for (Character c : items) {
            cur.add(c);
            dfs(items, cur, target, result);
            cur.remove(cur.size() - 1);
        }

    }

    private void updateResult(List<Character> cur, List<Character> result) {
        result.set(0, cur.get(0));
        result.set(1, cur.get(1));
        result.set(2, ':');
        result.set(3, cur.get(2));
        result.set(4, cur.get(3));
    }

    private int changeStringToInt(List<Character> cur) {

        int hour = (cur.get(0) - '0') * 10 + cur.get(1) - '0';
        int min = (cur.get(2) - '0') * 10 + cur.get(3) - '0';
        if (hour < 0 || hour > 24 || min < 0 || min > 59) {
            return -1;
        }
        return hour * 60 + min;
    }

    public int[] mergeSort(int[] array) {

        if (array == null || array.length <= 1) {
            return array;
        }
        split(array, 0, array.length - 1);
        return array;
    }

    private void split(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        split(array, left, mid);
        split(array, mid + 1, right);
        merge(array, left, mid, mid + 1, right);
    }

    private void merge(int[] array, int start1, int end1, int start2, int end2) {
        int[] help = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            help[i] = array[i];
        }
        int i = start1;
        int j = start2;
        int k = start1;
        while (i <= end1 && j <= end2) {
            array[k++] = help[i] < help[j] ? help[i++] : help[j++];
        }
        while (i <= end1) {
            array[k++] = help[i++];
        }
        while (j <= end2) {
            array[k++] = help[j++];
        }
        return;
    }

    public int[] quickSort(int[] array) {

        if (array == null || array.length <= 1) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int start, int end){
        if (start >= end){
            return;
        }
        Random seed = new Random();
        int pivot = start + seed.nextInt (end - start);
        int index = partition(array, start, end, pivot);
        quickSort(array, start, index - 1);
        quickSort(array, index + 1, end);
    }

    public int partition(int[] array, int start, int end, int pivot){
        int i = start;
        int j = end - 1;
        swap(array, end, pivot);
        while (i <= j) {
            if (array[i] >= array[end]){
                swap(array, i, j--);
                continue;
            } else if (array[j] < array[end]){
                swap(array, i++, j);
                continue;
            } else {
                i++;
            }
        }
        swap(array, i, end);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}

package searching;

import java.util.Scanner;

public class LinearSearchWithFlag {
    static int linearSearch(int[] arr, int target) {
        boolean flag = false;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                flag = true;
                index = i;
                break;
            }
        }
        if (flag) {
            return index;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 8, 12, 4, 18};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to search: ");
        int target = sc.nextInt();

        int index = linearSearch(arr, target);
        if (index == -1) {
            System.out.println("Target element was not found!!!!!");
        } else {
            System.out.println("Target element was found at index " + index);
        }
    }
}

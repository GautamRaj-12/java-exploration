package searching;

import java.util.Scanner;

public class LinearSearchSimple {
    static void linearSearch(int[] arr, int target) {
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Element is found at index " + i);
                break;
            }
        }
        if (i == arr.length) {
            System.out.println("Element is not found!!!!");
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 8, 12, 4, 18};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to search: ");
        int target = sc.nextInt();

        linearSearch(arr,target);
    }
}

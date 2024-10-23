package arrays;

public class ArrayOperations {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    static int[] insertAtBegin(int[] arr, int target) {
        // Create a new array with size +1 of original
        int[] arrNew = new int[arr.length + 1];

        // Copy elements from old array to new array
        for (int i = 0; i < arr.length; i++) {
            arrNew[i + 1] = arr[i];
        }

        arrNew[0] = target;

        return arrNew;
    }

    static int[] insertAtEnd(int[] arr, int target) {
        // Create a new array with size +1 of original
        int[] arrNew = new int[arr.length + 1];

        // Copy elements from old array to new array
        for (int i = 0; i < arr.length; i++) {
            arrNew[i] = arr[i];
        }

        // Add the new element at the end
        arrNew[arrNew.length - 1] = target;

        // return the new array
        return arrNew;
    }

    static int[] insertAtIndex(int[] arr, int target, int index) {
        // Create a new array with size +1 of original
        int[] arrNew = new int[arr.length + 1];

        // Copy elements from old array to new array till less than index
        for (int i = 0; i < index; i++) {
            arrNew[i] = arr[i];
        }

        // Insert the target at the specified index
        arrNew[index] = target;

        // Copy the remaining elements
        for (int i = index + 1; i < arrNew.length; i++) {
            arrNew[i] = arr[i - 1];
        }
        return arrNew;
    }

    static int[] deleteAtBegin(int[] arr) {
        // Create a new array with size -1 of original
        int[] arrNew = new int[arr.length - 1];

        // Copy elements from old array to new array
        for (int i = 0; i < arr.length - 1; i++) {
            arrNew[i] = arr[i + 1];
        }

        return arrNew;
    }

    static int[] deleteAtEnd(int[] arr) {
        // Create a new array with size -1 of original
        int[] arrNew = new int[arr.length - 1];

        // Copy elements from old array to new array
        for (int i = 0; i < arr.length - 1; i++) {
            arrNew[i] = arr[i];
        }

        return arrNew;
    }

    static int[] deleteAtIndex(int[] arr, int index) {
        // Create a new array with size -1 of original
        int[] arrNew = new int[arr.length - 1];

        // Copy elements before index
        for (int i = 0; i < index; i++) {
            arrNew[i] = arr[i];
        }

        // Copy elements after index
        for (int i = index; i < arrNew.length; i++) {
            arrNew[i] = arr[i + 1];
        }
        return arrNew;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 8, 12};

        System.out.print("Default Array: ");
        printArray(arr);

        System.out.print("Inserting at end:");
        printArray(insertAtEnd(arr, 6));

        System.out.print("Inserting at beginning:");
        printArray(insertAtBegin(arr, 9));

        System.out.print("Inserting at index 2: ");
        printArray(insertAtIndex(arr, 21, 2));

        System.out.print("Deleting from end:");
        printArray(deleteAtEnd(arr));

        System.out.print("Deleting from beginning:");
        printArray(deleteAtBegin(arr));

        System.out.print("Deleting from index 2: ");
        printArray(deleteAtIndex(arr, 2));
    }
}

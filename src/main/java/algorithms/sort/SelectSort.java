package algorithms.sort;

public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5, 4, 6, 8, 7, 9};
        selectSort(arr);
    }

    private static void selectSort(int[] arr) {
        for (int j = 0; j < arr.length - 1; j++) {
            int minPos = j;
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i] < arr[minPos]) {
                    minPos = i;
                }
            }
            swap(arr[j], arr[minPos]);
        }
        print(arr);
    }

    private static void print(int[] arr) {
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
    }

    private static void swap(int num1, int num2) {
        int temp = num1;
        num1 = num2;
        num2 = temp;
    }
}

import java.util.*;

public class Main {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Random rd = new Random();
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(1000);
        }
        //insertionSort(arr);
        bubbleSort(arr);
        //selectionSort(arr);
        //heapSort(arr);
        //mergeSort(arr, 0, arr.length - 1);
        //quickSort(arr , 0 , arr.length-1);
        printArr(arr);
        double endtime = (System.nanoTime() - startTime) * Math.pow(10 , -9);
        String s = String.format("%.4f", endtime);
        System.out.println("running time in seconds = " + s + "s");
    }


    private static void quickSort(int arr[] , int first , int last){
        int index;
        if(first < last)
        {
            index = divide(arr, first, last);
            quickSort(arr, first, index - 1);
            quickSort(arr, index+1, last);
        }
    }

    private static int divide(int[] arr , int first , int last){
        int pivot = arr[last] , i = first-1 , j = first;
        while (j < last){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] =temp;
            }
            j++;
        }

        i++;
        while (i < last){
            if(pivot < arr[i]){
                int temp = arr[i];
                arr[i] = arr[last];
                arr[last] =temp;
                break;
            }
            i++;
        }

        return i;
    }

    private static void heapSort(int[] arr){
        int size = arr.length;
        for (int root = size / 2 - 1; root >= 0; root--)
            maxHeapify(arr, size , root );

        for(int i = size-1; i > 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeapify(arr , i , 0);
        }

        printArr(arr);
    }

    private static void maxHeapify(int[] arr  , int size , int root){
        int temp = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < size && arr[left] > arr[temp]) {
            temp = left;
        }

        if (right < size && arr[right] > arr[temp]) {
            temp = right;
        }

        if(temp != root){
            int swap = arr[root];
            arr[root] = arr[temp];
            arr[temp] = swap;

            // Recursively heapify the affected sub-tree
            maxHeapify(arr, size, temp);
        }
    }

    private static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){

            int min_index = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
        printArr(arr);
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        printArr(arr);
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int x = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    break;
                } else {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i--;
                }
            }
            i = x;
        }

        printArr(arr);
    }

    private static void merge(int[] arr, int first, int mid, int last) {
        int leftSize = mid - first + 1;
        int rightSize = last - mid;
        int leftArr[] = new int[leftSize];
        int rightArr[] = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArr[i] = arr[first + i];
        }

        for (int j = 0; j < rightSize; j++) {
            rightArr[j] = arr[mid + j + 1];
        }

        int leftPointer = 0, rightPointer = 0, index = first;

        while (leftPointer < leftSize && rightPointer < rightSize) {
            if (leftArr[leftPointer] <= rightArr[rightPointer]) {
                arr[index] = leftArr[leftPointer];
                leftPointer++;
            } else {
                arr[index] = rightArr[rightPointer];
                rightPointer++;
            }
            index++;
        }

        while (rightPointer < rightSize && index < arr.length) {
            arr[index] = rightArr[rightPointer];
            rightPointer++;
            index++;
        }

        while (leftPointer < leftSize && index < arr.length) {
            arr[index] = leftArr[leftPointer];
            leftPointer++;
            index++;
        }

    }

    private static void mergeSort(int[] arr, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(arr, first, mid);
            mergeSort(arr, mid + 1, last);
            merge(arr, first, mid, last);
        }
    }

    private static void printArr(int[] arr) {
        for (int element : arr) {
            System.out.println(element);
        }
    }
}
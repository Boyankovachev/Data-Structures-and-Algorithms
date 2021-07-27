import java.util.List;

public class Sort {

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            int minIndex = i;
            for (int j = i+1; j < n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

        }
    }

    public static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = key;
        }
    }

    public static void mergeSort(int[] arr){
        int arrLength = arr.length;
        if(arrLength < 2){
            return;
        }
        int midPoint = arrLength / 2;
        int[] leftArray = new int[midPoint];
        int[] rightArray = new int[arrLength - midPoint];
        for(int i=0; i<midPoint; i++){
            leftArray[i] = arr[i];
        }
        for(int i=midPoint; i<arrLength; i++){
            rightArray[i-midPoint] = arr[i];
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(arr, leftArray, rightArray, midPoint, arrLength - midPoint);
    }

    private static void merge(
            int[] arr, int[] leftArray, int[] rightArray,
            int leftArraySize, int rightArraySize){

        int i=0,j=0,k=0;
        while (i<leftArraySize && j<rightArraySize){
            if(leftArray[i] <= rightArray[j]){
                arr[k++] = leftArray[i++];
            }
            else {
                arr[k++] = rightArray[j++];
            }
        }
        while (i<leftArraySize){
            arr[k++] = leftArray[i++];
        }
        while (j<rightArraySize){
            arr[k++] = rightArray[j++];
        }
    }

}

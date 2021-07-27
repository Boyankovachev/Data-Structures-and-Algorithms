import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class TestSort {

    private static final int ARRAY_LENGTH = 1000;

    private int[] arrUnsorted = new int[ARRAY_LENGTH];
    public int[] arrSorted = new int[ARRAY_LENGTH];

    public TestSort(){
        //setup arrays
        Random random = new Random();
        for(int i = 0; i<ARRAY_LENGTH; i++){
            arrUnsorted[i] = random.nextInt();
        }
        arrSorted = Arrays.stream(arrUnsorted).sorted().toArray();
    }

    private static boolean compareArrays(int[] arr1, int[] arr2){
        /*
        arrays are equal if they have equal length and all
        integers are the same in the same order
         */
        int arrLength = arr1.length;
        if(arrLength != arr2.length){
            return false;
        }
        else {
            int i;
            for(i=0; i<arrLength; i++){
                if(arr1[i] != arr2[i]){
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void testBubbleSort(){
        int[] arrTest = arrUnsorted.clone();
        Sort.bubbleSort(arrTest);
        assert compareArrays(arrTest, arrSorted);
        assert !compareArrays(arrTest, arrUnsorted);
    }

    @Test
    public void testSelectionSort(){
        int[] arrTest = arrUnsorted.clone();
        Sort.selectionSort(arrTest);
        assert compareArrays(arrTest, arrSorted);
        assert !compareArrays(arrTest, arrUnsorted);
    }

    @Test
    public void testInsertionSort(){
        int[] arrTest = arrUnsorted.clone();
        Sort.insertionSort(arrTest);
        assert compareArrays(arrTest, arrSorted);
        assert !compareArrays(arrTest, arrUnsorted);
    }

    @Test
    public void testMergeSort(){
        int[] arrTest = arrUnsorted.clone();
        Sort.mergeSort(arrTest);
        assert compareArrays(arrTest, arrSorted);
        assert !compareArrays(arrTest, arrUnsorted);
    }

}

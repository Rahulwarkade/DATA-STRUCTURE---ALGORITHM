// import java.util.Collections;
// import java.util.Arrays;
public class Sorting
{
    static void printArr(int arr[])
    {
        for(int i=0; i<arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    static void bubbleSort(int arr[])
    {
        for(int i=0; i<arr.length-1; i++)
        {
            int swaps = 0;
            for(int j=0; j<arr.length-1-i; j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps++;
                }
            }
            if(swaps==0) break;
        }
    }
    static void selectionSort(int arr[])
    {
        for(int i=0; i<arr.length-1; i++)
        {   int minElement = i;
            int swaps = 0;
            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[minElement]>arr[j])
                {
                    minElement = j;
                    swaps++;
                }
            }
            if(swaps==0) break;
            int temp = arr[i];
            arr[i] = arr[minElement];
            arr[minElement] = temp;
        }
    }
    static void insertionSort(int arr[])
    {
        for(int i=1; i<arr.length-1; i++)
        {
            int curr = arr[i];
            int prev = i-1;
            while(prev>=0 && arr[prev]>curr)
            {
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }
    static void countSort(int arr[])
    {
        int maxEl = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++)
        {
            if(maxEl<arr[i])
            {
                maxEl = arr[i];
            }
        }
        int countArr[] = new int[maxEl+1];

        for(int i=0; i<arr.length; i++)
        {
            countArr[arr[i]]++;
        }

        int j=0;
        for(int i=0; i<countArr.length; i++)
        {
            if(countArr[i]>0)
            {
                arr[j] = i;
                countArr[i]--;
                j++;
            }
        }
    }
    public static void main(String args[])
    {
        int arr[] = {5,2,8,9,3,7};
        printArr(arr);
    }
}
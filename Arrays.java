import java.util.*;
public class Arrays
{
    public static void fun(int marks[])
    {
        marks[0] = marks[2] =0;
    }
    public static int linearSearch(int numbers[],int key)
    {
        for(int i=0; i<numbers.length; i++)
        {
            if(numbers[i]==key)
            return i;
        }
        return -1;
    }

    public static int binarySearch(int numbers[],int key)
    {
        int start =0;
        int end = numbers.length-1;
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(numbers[mid]==key)
            {
                return mid;
            }
            else if(numbers[mid]<key)
            {
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        return -1;
    }
   public static int smallest = Integer.MAX_VALUE;
    public static int getLargest(int arr[])
    {
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]>largest)
            {
                largest = arr[i];
            }
            if(arr[i]<smallest)
                smallest = arr[i];
        }
        return largest;
    }
    public static void reverseArr(int numbers[])
    {
        int start = 0;
        int end = numbers.length-1;
        while(start<end)
        {
            int temp;
            temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
        return;
    }
    public static void printArr(int numbers[])
    {
        for(int i=0; i<numbers.length; i++)
            System.out.print(numbers[i]+ " ");
        System.out.println();
    }
    public static void pairs(int numbers[])
    {
        int totalPair = 0;
        for(int i=0; i<numbers.length; i++)
        {
            for(int j=i+1; j<numbers.length; j++)
            {
                System.out.print("("+numbers[i]+","+numbers[j]+")  ");
                totalPair++;
            }
            System.out.println();
        }
        System.out.println("Total pairs = "+totalPair);
    }
    static void subArrays(int arr[])
    {
        int totalSubarr =0;
        int maxSubarrSum = Integer.MIN_VALUE;
        int minSubarrsum = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++)
        {
            for(int j=i; j<arr.length; j++)
            {
                int subarrsum = 0;
                System.out.print("[");
                for(int k=i; k<=j; k++)
                {
                    System.out.print(arr[k]);
                    if(k!=j)
                    System.out.print(",");
                    subarrsum+=arr[k];
                }
                totalSubarr++;
                System.out.print("]");
                if(subarrsum>maxSubarrSum)
                    maxSubarrSum = subarrsum;
                if(subarrsum<minSubarrsum)
                    minSubarrsum = subarrsum;
                System.out.print("="+subarrsum+" ");
            }
            System.out.println();
        }
        System.out.println("total subArray = "+totalSubarr);
        System.out.println("Maximum subArray sum = "+maxSubarrSum);
        System.out.println("Minimum subArray sum = "+minSubarrsum);
    }
    static void maxSubarrSum(int arr[])
    {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++)
        {
            for(int j=i; j<arr.length; j++)
            {
                int sum = 0; 
                for(int k=i; k<=j; k++)
                {
                    sum+=arr[k];
                }
                if(sum>max)
                    max = sum;
            }
        }
        System.out.println("Maximum sum is = "+max);
    }
    static void prefixSum(int arr[])
    {
        int max = arr[0];
        int prefixarr[] = new int[arr.length];
        prefixarr[0] = arr[0];
        for(int i = 1; i<prefixarr.length; i++)
        {
            prefixarr[i]=prefixarr[i-1]+arr[i]  ;
        }
        
        for(int i=1; i<arr.length; i++)
        {
            for(int j=i; j<arr.length; j++)
            {
                int maxSum = prefixarr[j]-prefixarr[i-1];
                if(maxSum>max)
                {
                    max = maxSum;
                }
            }
        }
        System.out.println(max);
    }
    static void kadanesAlgo(int arr[])
    {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        int count = 0;
        for(int i=0; i<arr.length; i++)
        {
            curSum += arr[i];
            if(curSum<0)
            {
                curSum = 0;
                count++;
            }
            if(maxSum<curSum)
            {
                maxSum = curSum;
            }
        }
        System.out.println(count);
        if(count==arr.length)
        {
            maxSum = Integer.MIN_VALUE;
            for(int i=0; i<arr.length; i++)
            {
                if(maxSum<arr[i])
                {
                    maxSum = arr[i];
                }
            }
        }
        System.out.println(maxSum);
    }
    public static void trappingRainwater(int arr[])
    {
        int leftMax[] = new int[arr.length];
        int rightMax[] = new int[arr.length];
        int maxValue = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++)
        {
            if(maxValue<arr[i])
            {
                maxValue = arr[i];
            }
            leftMax[i] = maxValue;
        }
        maxValue = Integer.MIN_VALUE;
        for(int i=arr.length-1; i>=0; i--)
        {
            if(maxValue<arr[i])
            {
                maxValue = arr[i];
            }
            rightMax[i] = maxValue;
        }

        int waterLevel[] = new int[arr.length];
        int width = 1;
        int trappedWater[] = new int[arr.length];
        int totaltrappedWater = 0;
        for(int i=0; i<arr.length; i++)
        {
            waterLevel[i] = Math.min(leftMax[i], rightMax[i]);
            trappedWater[i] = (waterLevel[i] - arr[i])*width;
            totaltrappedWater+=trappedWater[i];
        }

        System.out.println(totaltrappedWater);
    }
    static void buyNSellstocks(int stocks[])
    {
        int buyingPrice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i=1; i<stocks.length; i++)
        {
         if(buyingPrice<stocks[i])
         {
            int profit = stocks[i]-buyingPrice;
            maxprofit = Math.max(profit,maxprofit);
         }
         else{
            buyingPrice = stocks[i];
         }
        }
        System.out.println(maxprofit);
    }
    public static void main(String args[])
    {
        int numbers[] = {7,1,5,3,6,4};
    }
}

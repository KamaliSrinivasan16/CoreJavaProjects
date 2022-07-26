package program;

public class  longestIncreasingSubsequence
{
	static int lis(int arr[], int n)
    {
        int lis[] = new int[n];
        int i, j, max = 0;
 
        //to initialize LIS values for all indexes 
        for (i = 0; i < n; i++)
        {
        	lis[i] = 1;
        }
            
        for (i = 1; i < n; i++)
        {
        	 for (j = 0; j < i; j++)
        	 {
        		 if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                     lis[i] = lis[j] + 1;
        	 }
        }  
 
       //to find the length of largest increasing subsequence
        for (i = 0; i < n; i++)
        {
        	 if (max < lis[i])
        	 {
        		 max = lis[i];
        	 }          
        }
        return max;
    }
	
	//main function
	public static void main(String args[])
    {
        int arr[] = { 9,3,12,20,17,26,49,38,56 };
        int n = arr.length;
        System.out.println("Length of the longest Increasing Subsequence is "+ lis(arr, n) + "\n");
    }
}
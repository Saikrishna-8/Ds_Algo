/*
 * Problem Description link is here 
 * 
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * 
 * 
 */


package arrays;

import java.util.Arrays;

public class SubarrayWithSumK1 {

	public static int prefixSum=0;
	public static int[] hash1=new int[10000000];
	public static int[] hash2=new int[10000000];
	
	public static void main(String[] args) {
		int a[]=new int[] {1,-1,0,0};
	
		System.out.println("Ans "+findSubarrysCount(a,0));
	}
	public static int findSubarrysCount(int []a,int K)
	{
		int count =0;
		for(int i=0;i<a.length;i++)
		{
			prefixSum+=a[i];
			
			if(prefixSum==K)
				count++;
			
			count+=findinHash(prefixSum-K);
			
			if(prefixSum<0)
				hash2[Math.abs(prefixSum)]++;
			
			else if(prefixSum>=0)
				hash1[prefixSum]++;
			
		}
		return count;
	}
	public static int findinHash(int val)
	{
		if(val<0 && hash2[-1*val]>0 )
			return hash2[-1*val];
		
		else if(val>=0 && hash1[val]>0) 
			return  hash1[val];
		
		return 0;
	}
}
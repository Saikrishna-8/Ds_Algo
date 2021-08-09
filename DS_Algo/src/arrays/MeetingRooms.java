package arrays;

import java.util.*;

public class MeetingRooms {

	public MeetingRooms() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[])
	{
		
	}
	

}



// https://leetcode.com/problems/meeting-rooms-ii/
// problem description Source

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals,new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}
		}
				
		);
 	     return MinimumRooms(intervals);	
        
    }
   public static int MinimumRooms(int[][] intervals)
	{
		Queue<Integer> pq=new PriorityQueue<Integer>(intervals.length,new Comparator<Integer>(){
			
			 public int compare(Integer a, Integer b) {
	                return a - b;
	              }
		});
		pq.add(intervals[0][1]);
		
		for(int i=1;i<intervals.length;i++)
		{
			if(intervals[i][0]>=pq.peek())
			{
				pq.poll();
				pq.add(intervals[i][1]);
			}
			else
			{
				pq.add(intervals[i][1]);
			}
		}
		return pq.size();
	}
}

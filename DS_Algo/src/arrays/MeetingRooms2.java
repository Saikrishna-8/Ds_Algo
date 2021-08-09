package arrays;
import java.util.*;

public class MeetingRooms2 {

	public MeetingRooms2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[])
	{
		
	}
}



/*https://leetcode.com/problems/meeting-rooms-ii/
 * 
 * problem description Source       
 * 
 * Approach 2
 */


 
class Solution1 {
    public int minMeetingRooms(int[][] intervals) {
        int[] start=new int[intervals.length];
		int[] end=new int[intervals.length];
		
		for(int i=0;i<intervals.length;i++)
		{
			start[i]=intervals[i][0];
		}
		for(int i=0;i<intervals.length;i++)
		{
			end[i]=intervals[i][1];
		}
		return MinimumRooms(start,end);
        
    }
    public int MinimumRooms(int[] start,int[] end)
	{
		Arrays.sort(start);
		Arrays.sort(end);
		
		int count=1;
		int i=1,j=0;
		while(i<start.length)
		{
			if(start[i]>=end[j])
			{
				i++;
				j++;
			}
			else {
				i++;
				count++;
			}
		}
		return count;
	}
}
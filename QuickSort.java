package sorting;
/* ***************************************************************
* Quick Sort with a Middle Pivot
* 
* 1.  Set the pivot to the middle of the array.
* 2.  Set a left-side location and set a right-side location.
* 3.  Check that the left-side location value is less than the pivot value.
* 4.  If it is less, move the left-side location right one position. If not, keep the value.
* 5.  Check that the right-side location value is greater than the pivot value.
* 6.  If it is greater, move the right-side location left one position. If not, keep the value.
* 7.  Once you have a right-side value less than the pivot and a left-side value greater than the pivot, swap the left-side and right-side values.
* 8.  Then, move the left-side location right one position and move the right-side location left one position.
* 9.  Stop it when the left-side value becomes greater than the right-side value.
* 10. Split the array into a left-side until the element before the pivot and the right-side from the pivot to the end.
* 11. Repeat steps 1-10 until split arrays reach one element where you then break out.
* 		
******************************************************************/
/* ***************************************************************
* Quick Sort with a Left Pivot
* 
* 1.  Set the pivot to the left most element of the array.
* 2.  Set a left-side location and set a right-side location.
* 3.  Check that the left-side location value is less than the pivot value.
* 4.  If it is less, move the left-side location right one position. If not, keep the value.
* 5.  Check that the right-side location value is greater than the pivot value.
* 6.  If it is greater, move the right-side location left one position. If not, keep the value.
* 7.  Once you have a right-side value less than the pivot and a left-side value greater than the pivot, swap the left-side and right-side values.
* 8.  Then, move the left-side location right one position and move the right-side location left one position.
* 9.  Stop it when the left-side value becomes greater than the right-side value.
* 10. Split the array into a left-side until the element before the pivot and the right-side from the pivot to the end.
* 11. Repeat steps 1-10 until split arrays reach one element where you then break out.
* 		
******************************************************************/
/* ***************************************************************
* Quick Sort with a Right Pivot
* 
* 1.  Set the pivot to the right most element of the array.
* 2.  Set a left-side location and set a right-side location.
* 3.  Check that the left-side location value is less than the pivot value.
* 4.  If it is less, move the left-side location right one position. If not, keep the value.
* 5.  Check that the right-side location value is greater than the pivot value.
* 6.  If it is greater, move the right-side location left one position. If not, keep the value.
* 7.  Once you have a right-side value less than the pivot and a left-side value greater than the pivot, swap the left-side and right-side values.
* 8.  Then, move the left-side location right one position and move the right-side location left one position.
* 9.  Stop it when the left-side value becomes greater than the right-side value.
* 10. Split the array into a left-side until the element before the pivot and the right-side from the pivot to the end.
* 11. Repeat steps 1-10 until split arrays reach one element where you then break out.
* 
******************************************************************/

public class QuickSort extends ArrayStringSorting{
	public QuickSort(String UnsortedString[], int leftBound, int rightBound,int pivotVal) {
		 Compared = 0; 
		 Swaps = 0;
		 QuickSorts(UnsortedString,leftBound,rightBound,pivotVal);
	}
	public void QuickSorts(String UnsortedString[], int leftBound, int rightBound,int pivotVal) {
		  int pivot = 0;
		  if (pivotVal == 0) {
			  pivot = leftBound;
		  }
		  if (pivotVal == 1) {
			  pivot = (leftBound+rightBound)/2;
		  }
		  if (pivotVal == 2) {
			  pivot = rightBound;
		  }
		  
		  int index = partition(UnsortedString, leftBound, rightBound,pivot);
	      
	      if (index-1 >= rightBound) {
	    	  index = index-1;
	      }
	      if (leftBound < index - 1)
	    	  QuickSorts(UnsortedString, leftBound, index - 1,pivotVal);
	      if (index < rightBound)
	    	  QuickSorts(UnsortedString, index, rightBound,pivotVal);
	}

}

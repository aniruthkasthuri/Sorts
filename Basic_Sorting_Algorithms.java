package sorting;

public class Basic_Sorting_Algorithms {
    
    public static int compared = 0;
    public static int swaps = 0;
	public static void swap(String[] UnsortedString, int SwapLoc1,int SwapLoc2){
			System.out.println("I am swapping "+UnsortedString[SwapLoc1]+ " and "+UnsortedString[SwapLoc2]+".");
			String temstr = UnsortedString[SwapLoc1];		
			UnsortedString[SwapLoc1] = UnsortedString[SwapLoc2];
            UnsortedString[SwapLoc2] = temstr;
            swaps+=1;
    }
	
	public static boolean CompareLess(String[] UnsortedString, int Loc1,int Loc2) {
		System.out.println("I am comparing "+UnsortedString[Loc1]+ " and "+UnsortedString[Loc2] + ".");
		compared+=1;
		if (UnsortedString[Loc1].compareTo(UnsortedString[Loc2]) < 0){
			return true;
		}
		return false;
	}
	
	public static boolean CompareGreater(String[] UnsortedString, int Loc1,int Loc2) {
		System.out.println("I am comparing "+UnsortedString[Loc1]+ " and "+UnsortedString[Loc2] + ".");
		compared+=1;
		if (UnsortedString[Loc1].compareTo(UnsortedString[Loc2]) > 0){
			return true;
		}
		return false;
	}
	public static void bubblesort(String[] UnsortedString){
	    boolean isSwapped = true;
	    int LengthOfString = UnsortedString.length;
	    while(isSwapped != false){
	    	isSwapped = false;
	        for (int loc = 0; loc<LengthOfString-1;loc++){
	        	compared+=1;
	            if (CompareGreater(UnsortedString,loc,loc+1)){
	            	swap(UnsortedString,loc,loc+1);
	            	isSwapped = true;
	            }
	            }
	        LengthOfString--;
	        }
	
	}
	
	public static void selectionsort(String[] UnsortedString, int LengthOfString,int NumberOfSortedElements,int NumberOfCompares){
	         int MaxValue = MaxValueOfStringArr(UnsortedString,0,1,NumberOfSortedElements,NumberOfCompares);
	         if ((LengthOfString-1) != MaxValue) {
	        	 swap(UnsortedString,LengthOfString-1,MaxValue);
	         }
	         NumberOfSortedElements++;
	         if (LengthOfString != 1){
	             selectionsort(UnsortedString,LengthOfString-1,NumberOfSortedElements,NumberOfCompares);
	         }
	}
	
	public static int MaxValueOfStringArr(String[] UnsortedString, int CurrentMax, int loc,int NumberOfSortedElements,int NumberOfCompares){
	     if (UnsortedString.length-NumberOfSortedElements == loc){
	    	 compared+=NumberOfCompares;
	         return CurrentMax;
	     }
	     if (CompareGreater(UnsortedString,CurrentMax,loc) == false){
	         return MaxValueOfStringArr(UnsortedString,loc,loc+1,NumberOfSortedElements,NumberOfCompares+1);
	     }
	     return MaxValueOfStringArr(UnsortedString,CurrentMax,loc+1,NumberOfSortedElements,NumberOfCompares+1);
	}
	
	public static void printarr(String[] SortedString,String sorttype,long startTime, long endTime) {
		for (int loc = 0; loc<SortedString.length; loc++){
            System.out.print(SortedString[loc]+ " ");
        }
		System.out.println();
		System.out.println("The number of comparisons are "+compared+ " and the number of swaps are "+swaps+" in the "+sorttype+".");
		System.out.println("The "+sorttype+" took "+(endTime - startTime) + " ns."); 
		System.out.println();
		compared = 0;
		swaps = 0;
	}
	public static int partition(String UnsortedString[], int leftBound, int rightBound,int PivotLoc)
	{
	      int leftLoc = leftBound, rightLoc = rightBound;
	      
	      while (leftLoc <= rightLoc) {
	           while (CompareLess(UnsortedString,leftLoc,PivotLoc)) {	  
	        	   leftLoc++;
	            }
	            while (CompareGreater(UnsortedString,rightLoc,PivotLoc)) {
	            	rightLoc--;
	            }
	            if (leftLoc <= rightLoc) {
	                  swap(UnsortedString,leftLoc,rightLoc);
	                  leftLoc++;
	                  rightLoc--;  
	            } 
	      }
	      return leftLoc;
	}

	public static void quickSortRight(String UnsortedString[], int leftBound, int rightBound) {
	      
		  int index = partition(UnsortedString, leftBound, rightBound,rightBound);
	      
	      if (index-1 >= rightBound) {
	    	  index = index-1;
	      }
	      if (leftBound < index - 1)
	    	  quickSortRight(UnsortedString, leftBound, index - 1);
	      if (index < rightBound)
	    	  quickSortRight(UnsortedString, index, leftBound);
	}
	
	public static void quickSortLeft(String UnsortedString[], int leftBound, int rightBound) {
	      
		  int index = partition(UnsortedString, leftBound, rightBound,leftBound);
	      
	      if (index-1 >= rightBound) {
	    	  index = index-1;
	      }
	      if (leftBound < index - 1)
	    	  quickSortLeft(UnsortedString, leftBound, index - 1);
	      if (index < rightBound)
	    	  quickSortLeft(UnsortedString, index, rightBound);
	}
	
	public static void quickSortMiddle(String arr[], int leftBound, int rightBound) {
	     
		  int index = partition(arr, leftBound, rightBound,(leftBound+rightBound)/2);
	      
	      if (index-1 >= rightBound) {
	    	  index = index-1;
	      }
	      if (leftBound < index - 1)
	    	  quickSortMiddle(arr, leftBound, index - 1);
	      if (index < rightBound)
	    	  quickSortMiddle(arr, index, rightBound);
	}
	
	public static void main(String[] Words){
		System.out.println("We are now running the array with a bubblesort.");
		String[] SortedWords = Words.clone();
		long startTime = System.nanoTime();
/* ***************************************************************
 * Bubble Sort
 * 
 * 1.  Start with 0th Element.
 * 2.  Compare the element with the adjacent element.
 * 3.  If it is greater, swap the two elements. If not, do NOT swap.
 * 4.  Move to the next element and repeat steps 2 and 3. Continue until you go through the entire array.
 * 5.  Repeat steps 1-4 until there are no more swaps.
 * 		
 ******************************************************************/
		
		bubblesort(SortedWords);
		long endTime = System.nanoTime();
		printarr(SortedWords,"bubblesort",startTime,endTime);
		
		System.out.println("We are now running the same array with a selection sort.");
		SortedWords = Words.clone();
		startTime = System.nanoTime();
/* ***************************************************************
* Selection Sort
* 
* 1.  Start with left most element of the array.
* 2.  Check for the maximum value of the array through one round.
* 3.  Then, swap the maximum value and the right-most element's value.
* 4.  Repeat steps 1-3 but decrease the right-most element's index by one every time until there is only one element left.
* 		
******************************************************************/
		
		selectionsort(SortedWords,SortedWords.length,0,0);	
		endTime = System.nanoTime();
		printarr(SortedWords,"selectionsort",startTime,endTime);
		
		System.out.println("We are now running the same array with a quicksort middle pivot.");
		SortedWords = Words.clone();
		startTime = System.nanoTime();
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
		quickSortMiddle(SortedWords,0,SortedWords.length-1);
		endTime = System.nanoTime();
		printarr(SortedWords,"quicksort with a middle pivot",startTime,endTime);

		
		System.out.println("We are now running the same array with a quicksort left pivot.");
		SortedWords = Words.clone();
		startTime = System.nanoTime();
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
	    quickSortLeft(SortedWords,0,SortedWords.length-1);
		endTime = System.nanoTime();
		printarr(SortedWords,"quicksort with a Left pivot",startTime,endTime);

		System.out.println("We are now running the same array with a quicksort right pivot.");
		SortedWords = Words.clone();
		startTime = System.nanoTime();
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
	    quickSortRight(SortedWords,0,SortedWords.length-1);
		endTime = System.nanoTime();
		printarr(SortedWords,"quicksort with a Right pivot",startTime,endTime);
	}
}

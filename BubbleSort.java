package sorting;

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

public class BubbleSort extends ArrayStringSorting{
    public BubbleSort(String[] UnsortedString){
    	Compared = 0; 
		Swaps = 0;
	    boolean isSwapped = true;
	    int LengthOfString = UnsortedString.length;
	    while(isSwapped != false){
	    	isSwapped = false;
	        for (int loc = 0; loc<LengthOfString-1;loc++){
	            if (CompareGreater(UnsortedString,loc,loc+1)){
	            	swap(UnsortedString,loc,loc+1);
	            	isSwapped = true;
	            }
	            }
	        LengthOfString--;
	        }
	
	}
}

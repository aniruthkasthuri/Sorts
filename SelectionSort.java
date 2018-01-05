package sorting;

/* ***************************************************************
* Selection Sort
* 
* 1.  Start with left most element of the array.
* 2.  Check for the maximum value of the array through one round.
* 3.  Then, swap the maximum value and the right-most element's value.
* 4.  Repeat steps 1-3 but decrease the right-most element's index by one every time until there is only one element left.
* 		
******************************************************************/

public class SelectionSort extends ArrayStringSorting{
	public SelectionSort(String[] UnsortedString, int LengthOfString,int NumberOfSortedElements,int NumberOfCompares) {
		Compared = 0; 
		Swaps = 0;
		SelectionSorts(UnsortedString,LengthOfString,NumberOfSortedElements,NumberOfCompares);
	}
	public void SelectionSorts(String[] UnsortedString, int LengthOfString,int NumberOfSortedElements,int NumberOfCompares){
        int MaxValue = MaxValueOfStringArr(UnsortedString,0,1,NumberOfSortedElements,NumberOfCompares);
        if ((LengthOfString-1) != MaxValue) {
       	  swap(UnsortedString,LengthOfString-1,MaxValue);
        }
        NumberOfSortedElements++;
        if (LengthOfString != 1){
            SelectionSorts(UnsortedString,LengthOfString-1,NumberOfSortedElements,NumberOfCompares);
        }
}

}

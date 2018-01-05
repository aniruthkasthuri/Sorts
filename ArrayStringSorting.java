package sorting;

public class ArrayStringSorting {
	protected int Compared = 0;
    protected int Swaps = 0;
    
    public void setCompared(int changeBy) {
    	 Compared+=changeBy;
    }
    public int readCompared() {
    	 return Compared;
    }
    public void setSwaps(int changeBy) {
   	 Swaps+=changeBy;
   }
   public int readSwaps() {
   	 return Swaps;
   }
    
	public void swap(String[] UnsortedString, int SwapLoc1,int SwapLoc2){
		System.out.println("I am swapping "+UnsortedString[SwapLoc1]+ " and "+UnsortedString[SwapLoc2]+".");
		String temstr = UnsortedString[SwapLoc1];		
		UnsortedString[SwapLoc1] = UnsortedString[SwapLoc2];
        UnsortedString[SwapLoc2] = temstr;
        setSwaps(1);
}

	public boolean CompareLess(String[] UnsortedString, int Loc1,int Loc2) {
		System.out.println("I am comparing "+UnsortedString[Loc1]+ " and "+UnsortedString[Loc2] + ".");
		setCompared(1);
		if (UnsortedString[Loc1].compareTo(UnsortedString[Loc2]) < 0){
			return true;
		}
		return false;
	}
	
	public boolean CompareGreater(String[] UnsortedString, int Loc1,int Loc2) {
		//System.out.println("I am comparing "+UnsortedString[Loc1]+ " and "+UnsortedString[Loc2] + ".");
		setCompared(1);
		if (UnsortedString[Loc1].compareTo(UnsortedString[Loc2]) > 0){
			return true;
		}
		return false;
	}
	public int MaxValueOfStringArr(String[] UnsortedString, int CurrentMax, int loc,int NumberOfSortedElements,int NumberOfCompares){
	     if (UnsortedString.length-NumberOfSortedElements == loc){
	    	 setCompared(NumberOfCompares);
	         return CurrentMax;
	     }
	     if (CompareGreater(UnsortedString,CurrentMax,loc) == false){
	         return MaxValueOfStringArr(UnsortedString,loc,loc+1,NumberOfSortedElements,NumberOfCompares+1);
	     }
	     return MaxValueOfStringArr(UnsortedString,CurrentMax,loc+1,NumberOfSortedElements,NumberOfCompares+1);
	}
	
	public void printarr(String[] SortedString,String sorttype,long startTime, long endTime) {
		for (int loc = 0; loc<SortedString.length; loc++){
           System.out.print(SortedString[loc]+ " ");
       }
		System.out.println();
		System.out.println("The number of comparisons are "+this.readCompared()+ " and the number of swaps are "+this.readSwaps()+" in the "+sorttype+".");
		System.out.println("The "+sorttype+" took "+(endTime - startTime) + " ns."); 
		System.out.println();

	}
	public int partition(String UnsortedString[], int leftBound, int rightBound,int PivotLoc)
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
	
}

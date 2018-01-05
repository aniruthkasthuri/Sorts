package sorting;
import java.util.Scanner;  

public class RunSorts{
	public static void main(String[] Words){
		Scanner sc=new Scanner(System.in); 
		
    	String[] SortedWords = Words.clone();
    	long startTime = System.nanoTime();
    	BubbleSort bubbles = new BubbleSort(SortedWords);
        long endTime = System.nanoTime();
        bubbles.printarr(SortedWords,"bubblesort",startTime,endTime);  
        
        
        SortedWords = Words.clone();
        startTime = System.nanoTime();
        System.out.println("Enter 0 for Left Pivot, Enter 1 for Middle Pivot, Enter 2 for Right Pivot: ");  
        int pivot = sc.nextInt();
        QuickSort sorting = new QuickSort(SortedWords,0,SortedWords.length-1,pivot);
        //sorting.quickSorts(SortedWords,0,SortedWords.length-1,pivot);
        endTime = System.nanoTime();
        sorting.printarr(SortedWords,"quicksort",startTime,endTime); 
        
        SortedWords = Words.clone();
        startTime = System.nanoTime();
        SelectionSort SelectionArray = new SelectionSort(SortedWords,SortedWords.length,0,0);
        //SelectionArray.SelectionSort(SortedWords,0,SortedWords.length-1,pivot);
        endTime = System.nanoTime();
        sorting.printarr(SortedWords,"Selection Sort",startTime,endTime); 
    }

}

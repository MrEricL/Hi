/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): Quicksort first chooses a pivot. It can either be random or always the same position in the subarray. It then puts every element in the array that is smaller than the pivot to the left of the pivot, and every element that is larger to the right of it, although they arent necessarily in order. The pivot is sorted, so we focus on the elements to the left and to the right, so we recursively call quicksort on the elements to the left and right. THis keeps going until the array being sorted is only size 1, which means it must be sorted, and we can go back up the recursive "chain".
 *
 * 2a. Worst pivot choice / array state and associated runtime: 
First element in a reverse order array or vie versa
 *
 * 2b. Best pivot choice / array state and associated runtime:
the pivot that splits the array in half?
 *
 * 3. Approach to handling duplicate values in array:
 * If there are duplicates, while the area before the pivot is being sorted, since two equal values can be placed in any order when being sorted, since they are the same, the counter for moving left is increased in order to make sure that the while loop terminates. 
 *****************************************************/



public class QuickSortTester 
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] arr, int left, int right){
	int pivot = partition(arr,left,right);
	if (left < pivot - 1)
	    qsort(arr,left,pivot - 1);
	if (pivot + 1 < right)
	    qsort(arr,pivot + 1 , right);
	return;
    }

    public static int partition( int[] arr, int left , int right){
	int pivot = arr[(left+right) / 2];
	//int pivot = arr[left + ((int) ((right - left) * Math.random()))];
	//int pivot = arr[left];
	while (left<right){
	    while (arr[left] < pivot)
		left++;
	    while (arr[right] > pivot)
		right--;
	    if (left<right){
		swap(left , right  , arr);
		//for duplicates 
		if (arr[left] == arr[right])
		    left++;
	    }
	}
	return left;
    }
    
    public static int[] generate(){
	int[] ret = new int[1000];
	
	for (int i = 0; i < ret.length; i++){
	    //ret[i] = (int)(Math.random()*100);
	    ret[i] = i;
	}
	return ret;
    }    

    //main method for testing
    public static void main( String[] args )
	
    {
	int [] test = generate();
	
	double totaltime=0;
	double tries=100;
	double avg=0;


        long time;

	for (int i = 0; i < tries; i++){
	    
	    time = (System.nanoTime());	    
	    qsort (test, 0 , test.length-1);
	    time=(System.nanoTime()-time);
	    totaltime+=(double)(time);
	}

	avg = totaltime/ tries;
	avg = avg / 1000000;

	System.out.println("\nAverage Time: "+ avg + " milliseconds for "+(int) tries +" tests\n");

       	
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,1,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	
	qsort( arr1 , 0 , arr1.length-1);	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN , 0 , arrN.length-1);
	System.out.println("arrN after sort: " );
	printArr(arrN);

	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort

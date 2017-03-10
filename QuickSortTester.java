
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
	//int pivot = arr[(left+right) / 2];
	int pivot = arr[left + ((int) ((right - left) * Math.random()))];
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



    //PIVOT IN THE MIDDLE
    public static void qsortmid( int[] arr, int left, int right){
	int pivot = partitionmid(arr,left,right);
	if (left < pivot - 1)
	    qsortmid(arr,left,pivot - 1);
	if (pivot + 1 < right)
	    qsortmid(arr,pivot + 1 , right);
	return;
    }

    public static int partitionmid( int[] arr, int left , int right){
	int pivot = arr[(left+right) / 2];
	//	int pivot = arr[left + ((int) ((right - left) * Math.random()))];
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

    //PIVOT IN THE FIRST ONE
    public static void qsortf( int[] arr, int left, int right){
	int pivot = partitionf(arr,left,right);
	if (left < pivot - 1)
	    qsortf(arr,left,pivot - 1);
	if (pivot + 1 < right)
	    qsortf(arr,pivot + 1 , right);
	return;
    }

    public static int partitionf( int[] arr, int left , int right){
	int pivot = arr[0];
	//	int pivot = arr[left + ((int) ((right - left) * Math.random()))];
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

    
    
    //RANDOM ARRAY
    public static int[] generate(int h){
	int[] ret = new int[h];
	
	for (int i = 0; i < ret.length; i++){
	    ret[i] = (int)(Math.random()*100);
	    //ret[i] = i;
	}
	return ret;
    }

    // REVERSE ORDERED ARRAY
    public static int[] generateR(int h){
	int[] ret = new int[h];
	
	for (int i = h-1; i > 0 ; i--){
	    ret[i] = i;
	}
	return ret;

    }

    
    // ORDERED ARRAY
    public static int[] generateB(int h){
	int[] ret = new int[h];
	
	for (int i = 0; i < ret.length; i++){
	    ret[i] = i;
	}
	return ret;

    }

    //main method for testing
    public static void main( String[] args )
	
    {
	int h = 10000; //LENGTH OF ARRAY
	int [] test = generateR(h);

	
	double tries = 100;
	double totaltime=0;
	double avg=0;


        long time;



	


	//Worst Case: Array in reverse order and first element picked as pivot
	System.out.println("\n\nWorst Case _______________________________________________");
	
	for (int i = 0; i < tries; i++){
	    
	    time = (System.nanoTime());	    
	    qsortf (test, 0 , test.length-1);
	    time=(System.nanoTime()-time);
	    totaltime+=(double)(time);
	    shuffle(test);
	}

	avg = totaltime/ tries;
	avg = avg / h;

	System.out.println("\nWorst Time: "+ avg + " milliseconds for random pivot \n");
	
	/*
	//AVERAGE CASES
	System.out.println("\n\nAverage Cases _______________________________________________");
	
	for (int i = 0; i < tries; i++){
	    
	    time = (System.nanoTime());	    
	    qsort (test, 0 , test.length-1);
	    time=(System.nanoTime()-time);
	    totaltime+=(double)(time);
	    shuffle(test);
	}

	avg = totaltime/ tries;
	avg = avg / h;

	System.out.println("\nAverage Time: "+ avg + " milliseconds for random pivot \n");/*
	/*
	test = generate(h);
	
	for (int i = 0; i < tries; i++){
	    
	    time = (System.nanoTime());	    
	    qsortmid (test, 0 , test.length-1);
	    time=(System.nanoTime()-time);
	    totaltime+=(double)(time);
	    shuffle(test);
	}

	avg = totaltime/ tries;
	avg = avg / h;

	System.out.println("\nAverage Time: "+ avg + " milliseconds for middle \n");

	test = generate(h);
	
	for (int i = 0; i < tries; i++){
	    
	    time = (System.nanoTime());	    
	    qsortf(test, 0 , test.length-1);
	    time=(System.nanoTime()-time);
	    totaltime+=(double)(time);
	    shuffle(test);
	}

	avg = totaltime/ tries;
	avg = avg / h;

	System.out.println("\nAverage Time: "+ avg + " milliseconds for first \n");

	*/
	System.out.println("__________________________________________________________\n\n\n");


    }//end main

}//end class QuickSort

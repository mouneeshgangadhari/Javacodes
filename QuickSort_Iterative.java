import java.util.*; 
   
class Quicksort_iterative
{ 
    /* This function takes last element as pivot, places the pivot element at its correct
    position in sorted array, and places all smaller (smaller than pivot) to left of
    pivot and all greater elements to right of pivot */
	static int partition(int arr[], int low, int high)   
	{ 
        int pivot = arr[high]; 

		System.out.println("low " + low + " high " + high + " pivot " + pivot);

        // smaller element index 
        int i = (low - 1); 
        for (int j = low; j <= high - 1; j++) 
		{ 
			//System.out.println("i " + i + " j " + j + " " + arr[j] + " " + pivot);
            // check if current element is less than or equal to pivot
            if (arr[j] <= pivot) {
                i++; 
				System.out.println("i " + i + " j " + j +" arr[i] " + arr[i] + " arr[j] " + arr[j]);
                // swap arr[i] and arr[j]
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
				System.out.println("in Sorting Array:" + Arrays.toString(arr)); 

            } 
        } 
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i + 1]; 
        arr[i + 1] = arr[high]; 
        arr[high] = temp; 

		System.out.println("Sorting Array:" + Arrays.toString(arr)); 
        return i + 1; 
    }    
     
	// sort the array using quickSort
    static void quickSort(int arr[], int low, int high) 
    { 
        //auxillary stack
        int[] stack = new int[high - low + 1]; 
   
        // top of stack initialized to -1
        int top = -1; 
   
        // push initial values of low and high to stack 
        stack[++top] = low; 
        stack[++top] = high; 
   
        // Keep popping from stack while is not empty 
        while (top >= 0) 
		{ 
            // Pop h and l 
            high = stack[top--]; 
            low = stack[top--]; 

			System.out.println("low " + low + " high " + high);
   
            // Set pivot element at its correct position in sorted array 
            int pivot = partition(arr, low, high); 
			System.out.println("new pivot " + pivot);

   
            // If there are elements on left side of pivot, then push left side to stack 
            if (pivot - 1 > low) 
			{ 
                stack[++top] = low; 
                stack[++top] = pivot - 1; 
            } 
   
            // If there are elements on right side of pivot, then push right side to stack 
            if (pivot + 1 < high) 
			{ 
                stack[++top] = pivot + 1; 
                stack[++top] = high; 
            } 
			System.out.println("top " + top + " stack:" + Arrays.toString(stack));
        } 
    }
 
	public static void main(String args[]) 
    { 
		// 8
		// 91 22 3 1 66 7 9 2
		Scanner sc=new Scanner(System.in);
		System.out.println("enter array size");

		int n = sc.nextInt(); 
		int a[]=new int[n];

		System.out.println("enter the elements of array ");

        for(int i=0;i<n;i++)
		{
			a[i] =sc.nextInt();
		}        

		System.out.println("Original Array:" + Arrays.toString(a)); 
		// call quickSort routine to sort the array 
		quickSort(a, 0, n - 1); 
		//print the sorted array
		System.out.println("\nSorted Array:" + Arrays.toString(a)); 
    } 
}

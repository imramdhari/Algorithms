import java.util.*; 
import java.lang.Math; 
  
class Main 
{
   //Get random number between 1 and number given as input  
    static int getNum(ArrayList<Integer> v)  
    {  
        
        int n = v.size();  
      
        int index = (int)(Math.random() * n);  
       
        int num = v.get(index);  
        
        v.set(index, v.get(n - 1)); 
        v.remove(n - 1);  
        return num;  
    } 
    // this method will generate the random permutation of integer
    static int[] generateRandom(int n)  
    {  
        ArrayList<Integer> v = new ArrayList<>(n);    
        for (int i = 0; i < n; i++)  
            v.add(i + 1);
        ArrayList<Integer> newAL = new ArrayList<>(n); 
        while (v.size() > 0)  
        { 
          newAL.add(getNum(v));
        } 
        return convertIntegers(newAL);

    }
// this methods will convert Integer
    public static int[] convertIntegers(ArrayList<Integer> integers)
    {
      int[] ret = new int[integers.size()];
      for (int i=0; i < ret.length; i++)
      {
        ret[i] = integers.get(i).intValue();
      }
      return ret;
    }

    
    static int qs_count = 0;// intially count will be 0
    
    static int partition(int arr[], int low, int high)
    {
        
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
          
            // If current element is smaller than the pivot
            //when pivot 
            qs_count ++;
           System.out.println("QMatrix:"+Arrays.toString(arr));
            if (arr[j] < pivot) 
            { 
                i++; 
                
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            }
            
            
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
       
        return i+1; 
        
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    static int[] quicksort(int arr[], int low, int high) 
    { 
        int[] copy = arr;
        if (low < high) 
        {
           
            /* pi is partitioning index, arr[pi] is  
              now at right place */

            int pi = partition(copy, low, high); 
            
  
            // Recursively sort elements before 
            // partition and after partition 
            quicksort(copy, low, pi-1); 
            quicksort(copy, pi+1, high); 
        }
        
        return copy;

        
        
        
    }
    static int ms_count = 0;
    static void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[m + 1 + j]; 
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0;   
  
        // Initial index of merged subarry array 
        int k = l; 
     
        while (i < n1 && j < n2) { 
            ms_count++;
        
            if (L[i] <= R[j]) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 

           
          
        } 

  
        /* Copy remaining elements of L[] if any */
        while (i < n1) { 
          
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) { 
          
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
      
            
        
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    static int[] mergesort(int arr[], int l, int r) 
    { 
    	int[] copy = arr;
        if (l < r) { 
            // Find the middle point 
            int m = (l + r) / 2; 
  
            // Sort first and second halves 
            mergesort(copy, l, m); 
            mergesort(copy, m + 1, r); 

            
            // Merge the sorted halves 
            merge(copy, l, m, r); 
        
         
         
            
        }
        System.out.println("Matrix:"+Arrays.toString(copy));
        return copy;

       
        
            

    
    }
    
  

    //Driver class to execute the program
    /**
     * @param args
     */
    public static void main(String []args) 
    { 
     Scanner input=new Scanner(System.in);
     System.out.println("Enter a random number"); 
       int n=input.nextInt();  // storing user output in n
       int[] randomArr = generateRandom(n);  // calling function to generate random permutation
       int newLength = randomArr.length;
       int[] copiedArray = Arrays.copyOf(randomArr, newLength);
   
    System.out.println("Random Permutation:"+Arrays.toString(randomArr));
    System.out.println("Mergesort array:" + Arrays.toString(mergesort(randomArr,0,n-1)));
    System.out.println("Quicksort array:" +Arrays.toString(quicksort(copiedArray,0,n-1)));
     
    System.out.println("Quicksort Counter: " + qs_count);
    System.out.println("Mergesort Counter: " + ms_count);
// part 4 of question 1
    System.out.println("Enter positive integer, trials:");
        int m=input.nextInt();  
        int total_tr= m*m*m;
        int[] randomArr2 = generateRandom(m);
        int newLength1 = randomArr2.length;
        int[] copiedArray2 = Arrays.copyOf(randomArr2, newLength1);
     System.out.println("Random Permutation after trails:"    +Arrays.toString(randomArr2));
     System.out.println("Mergesort array:" + Arrays.toString(mergesort(randomArr2,0,n-1)));
     System.out.println("Quicksort array:" +Arrays.toString(quicksort(copiedArray2,0,n-1)));
     int countersum= (qs_count+ ms_count);
     int quick_avg= (qs_count/countersum);
     int merge_avg= (ms_count/countersum);
    

     System.out.println("Quicksort Counter: " + qs_count);
     System.out.println("Mergesort Counter: " + ms_count);
     System.out.println("Number of Trails " + total_tr);
     System.out.println("Average Quick Sorts  " + quick_avg);
     System.out.println("Average Merge Sorts  " + merge_avg);
    
    


    } 
}

import java.util.Random; 
import java.util.Arrays; 
public class RandomPermutation
{ 

    static void randomize( int arr[]) 
    { 
        
        int r = (int) Math.random(); 

        int n = arr.length;
          
       
        for (int j = n-1; j > 1; j--) { 
              
            
            int k = (int) Math.floor((j+1)*r); 
           
            int temp = arr[j]; 
            arr[j] = arr[k]; 
            arr[k] = temp; 
        } 
        
        System.out.println("Generated Permutation:"+ Arrays.toString(arr)); 
    } 


      
   
    public static void main(String[] args)  
    { 
          
         int[] arr = {1, 2, 3, 4, 5, 6, 7, 8}; 
         System.out.println("This is input :"+ Arrays.toString(arr));
         
         randomize (arr); 
    } 
}
package bst;

import java.util.Scanner;

public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	Scanner scan= new Scanner(System.in);
    	System.out.println("Enter the root number because node is null at this time");
    	int a=scan.nextInt();
    	RandomisedBSTNode n = new RandomisedBSTNode(a);
    	RandomisedBSTTree tree = new RandomisedBSTTree(n);
    	
    	// inserting numbers 
    	
    	
    	 System.out.println("Inserting these keys (5,15,2,6,14,20,21,19,17,18)");
           tree.nodeInsert(5);
            tree.nodeInsert(15);
            tree.nodeInsert(2);
            tree.nodeInsert(6);
            tree.nodeInsert(14);
           tree.nodeInsert(20);
           tree.nodeInsert(21);
          tree.nodeInsert(19);
          tree.nodeInsert(17);
          tree.nodeInsert(18);
          
      	// printing pre order
          
          System.out.println("Pre-Order");
          System.out.println();
           tree.printPreorder();
           System.out.println();
           
       	// printing in order
           
           System.out.println("In-Order");
           System.out.println();
           tree.printInorder();
         System.out.println();
         
      // printing post order
         System.out.println("Post-Order");
         System.out.println();
         tree.printPostorder();
         System.out.println();
         
         // Deleting 15 from randomised BST Tree and printing pre, in and post order below:
         
         System.out.println("Now Deleting 15 ");
         
        tree.nodeDelete(15);
        System.out.println();
        System.out.println("Pre-Order");
        System.out.println();
        tree.printPreorder();
        System.out.println();
        System.out.println("In-Order");
        System.out.println();
        tree.printInorder();
      System.out.println();
      System.out.println("Post-Order");
      System.out.println();
      tree.printPostorder();
      System.out.println();
      
      
      // Inserting 11 into randomised BST Tree and printing pre, in and post order below:
      
         System.out.println("Now Inserting 11 ");
         System.out.println();
         System.out.println("In-Order");
         tree.nodeInsert(11);
         tree.printInorder();
         System.out.println();
         System.out.println("Pre-Order");
         System.out.println();
         tree.printPreorder();
         System.out.println();
      
          System.out.println();
        System.out.println("Post-Order");
        System.out.println();
   
        tree.printPostorder();
        System.out.println();
        
        // Using scanner to get input from user .
        System.out.println("Enter a key to check insertion otherwise enter 0");
        System.out.println();
    	int b=scan.nextInt();
    	if(b==0) {
    		 
            System.out.println("Pre-Order");
            System.out.println();
             tree.printPreorder();
             System.out.println();
             System.out.println("In-Order");
             System.out.println();
             tree.printInorder();
              System.out.println();
               System.out.println("Post-Order");
               System.out.println();
              tree.printPostorder();
             System.out.println();
    		
    	}
    	else {
    		 System.out.println("Now Inserting: "+ b);
    		 tree.nodeInsert(b);
             System.out.println("In-Order");
             System.out.println();
            
             tree.printInorder();
             System.out.println();
             System.out.println("Pre-Order");
             System.out.println();
             tree.printPreorder();
             System.out.println();
          
              System.out.println();
            System.out.println("Post-Order");
            System.out.println();
      
            tree.printPostorder();
            System.out.println();
    		
    	}
    	
    	
    	
    }
}

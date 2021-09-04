package bst;

import java.util.Random;


////////////////////////////Randomised BST ///////////////////////////////////////

//Implementation of Randomised BST search at a node 
//returns node that contains the key

public class RandomisedBSTNode {
	
	int key;       //data at the node
	RandomisedBSTNode left;   //left child
	RandomisedBSTNode right;  //right child
    int size;  // size of node
    Random rand = new Random();
    RandomisedBSTNode node;
   int prior;
    
    public RandomisedBSTNode(int key) {
        this.key = key;                    // making constructor 
        left = null;
        right = null;
        this.size = 1;
        this.prior = new Random().nextInt(100);
    }
  

    
     RandomisedBSTNode rotationLeft(RandomisedBSTNode h) {       // updation in Left rotation
    	RandomisedBSTNode x=h.right;
    	//rotation 
    	h.right = x.left;
    	x.left = h;
    	x.size = h.size;
    	fixSize(x);
    	// setting new root
    	return x;
    	
    }
    
     RandomisedBSTNode rotationRight(RandomisedBSTNode h) {
    	RandomisedBSTNode x=h.left;
    	h.left = x.right;
    	x.right = h;                                                        // updation in Right rotation
    	x.size = h.size;
    	fixSize(x);
    	return x;
    	
    }
     // Randomised Root Insert method passing two parameters node and key.
     RandomisedBSTNode insertRoot(RandomisedBSTNode h,int key) {
    	 
    	 // checking node h is null , if yes then it will create new node with key  and below it is checking all the condition 
    	 if(h==null) {
    		 return new RandomisedBSTNode(key);
    	 }
    	 if(key<h.key) {
    		 h.left = insertRoot(h.left,key);                                    
    		 h =rotationRight(h);
    	 }else {
    		 h.right = insertRoot(h.right,key);
    		 h=rotationLeft(h);
    	 }
    	 return h;
    	 
     }
     
     //fixing size after after updating the tree
     void fixSize(RandomisedBSTNode x) {
    	 x.size = getSize(x.left)+getSize(x.right)+1;
     }
     
     //recursively inserting node after comparison
     
     RandomisedBSTNode insert(RandomisedBSTNode h,int key) {
    	 if(h==null) {
    		 return new RandomisedBSTNode(key);
    	 }
    	 if(rand.nextInt(1000)==h.size) {
    		 return insertRoot(h,key);
    	 }
    	 if (h.key>key){
    		 h.left =insert(h.left,key);
    	 }else {
    		 h.right = insert(h.right,key);
    	 }
    	 fixSize(h);
    	 return h;
     }
    
// preorder method 
  void printPreorderNode() {
      System.out.print(key + " ");
      if (left != null) {
          left.printPreorderNode();
      }
      if (right != null) {
          right.printPreorderNode();
      }
  }
// in-order method
  void printInorderNode() {
      if (left != null) {
          left.printInorderNode();
      }
      System.out.print(key + " ");
      if (right != null) {
          right.printInorderNode();
      }
  }
//  post order method
  void printPostorderNode() {
      if (left != null) {
          left.printPostorderNode();
      }
      if (right != null) {
          right.printPostorderNode();
      }
      System.out.print(key + " ");
  }
    
   
    // getting size or height of node
   int getSize(RandomisedBSTNode j){
	  if(j==null) {
		  return 0;
	  }
	  return j.size;
   }
   
   // joining two nodes 
   RandomisedBSTNode join(RandomisedBSTNode h,RandomisedBSTNode j) {
	   if(rand.nextInt(1000)<h.size) {
		  h.right = join(h.right,j);
		  fixSize(h);
		  return h;
	   }else {
		   j.left=join(h,j.left);
		   fixSize(j);
		   return j;
	   }
	   
   }
   
   // randomised deletion implementation where p is node and k is key which needs to be deleted
   RandomisedBSTNode delete(RandomisedBSTNode p, int k)           // deleting from p tree the first found node with k key 
   {
	   // checking node is empty or not  if yes then it will return null.
      if(p==null)
        {
    	  return null;
    	  }
      // if not, then it will check given key is less than node key.It not going to  delete.
     if(k < p.key) {
    	 
    	 p.left=delete(p.left,k);
     }
     else if( k > p.key ) 
         p.right = delete(p.right,k); 
      
 
     else {
         // ...........................................................................
    	 //if node p has no child 
        if( p.left==null  && p.right== null) 
       {
    	
         p=null; 
            
       }
        // ...........................................................................
		 //if node has two child 
    	 else if(p.right !=null && p.left != null) {
    	    
    	      if (p.right.prior > p.left.prior) {                //if  left child has less priority than right child
        	        p=rotationLeft(p);                             // calling left rotation
        	        p.left=delete(p.left,k);  // delete left child
           
               }
                 else 
                   {     // delete right child               
                	 p=rotationRight(p);                              // calling right rotation
                	 p.right=delete(p.right,k);
        	   
                   }
              	}
    	 
    	   // if node has only one child
    	 else
         {
    	 		RandomisedBSTNode child=(p.left !=null)? p.left: p.right ;  // finding child node 
    	 		p=child;
         }
     }
     
    		return p; 
   }
     

	
    
    

}

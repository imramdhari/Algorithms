package bst;


public class RandomisedBSTTree {

	RandomisedBSTNode root;

    public RandomisedBSTTree() {
        root = null;
    }

    public RandomisedBSTTree(RandomisedBSTNode node) {
        root = node;
    }

   
    
    public void printPreorder() {
        root.printPreorderNode();
    }

    public void printInorder() {
        root.printInorderNode();
    }

    public void printPostorder() {
        root.printPostorderNode();
    }
   // RandomisedBSTNode bj = null;
    public void nodeInsert(int key){
    	 
         root.insert(root,key);
    }
    public void nodeDelete(int key){
       root.delete(root,key);
    }
   
    
    
}

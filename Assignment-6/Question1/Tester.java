package assignment6;

public class Tester {

	 public static void main(String[] args) {
	    	BSTRecursiveFunc bst = new BSTRecursiveFunc();

	        bst.insert(50);
	        bst.insert(30);
	        bst.insert(20);
	        bst.insert(40);
	        bst.insert(70);
	        bst.insert(60);
	        bst.insert(80);

	        System.out.println("Search 40: " + bst.search(40));
	        System.out.println("Search 90: " + bst.search(90));
	        
	        System.out.println("Level of 30: " + bst.getLevel(30)); 
	        System.out.println("Level of 20: " + bst.getLevel(20));

	        bst.delete(20);
	        bst.delete(30);
	        bst.delete(50);
	        
	    }

}

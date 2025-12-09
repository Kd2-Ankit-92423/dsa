package BST;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BST bst = new BST();
		
		bst.add(50);
		bst.add(25);
		bst.add(70);
		bst.add(10);
		bst.add(40);
		bst.add(100);
		bst.add(69);
		
		bst.printSuccessor(700);
		
		bst.InOrder();
		bst.dfs();
		System.out.println();
		
		bst.BFS();
		
		bst.print();
		

	}

}

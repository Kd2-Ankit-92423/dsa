package question2;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter vertex count : ");
		int vCount = sc.nextInt();
		
		Graph g = new Graph(vCount);
		
		g.accept(sc);
		//g.print();
		
		g.dfs(4);
		System.out.println();
		g.bfs(4);

		sc.close();
	}

}














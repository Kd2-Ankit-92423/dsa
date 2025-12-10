package question2;
import java.util.*;

public class Graph 
{
   int vertexCount;
   int edgeCount;
   List<Integer> adjList[];
   
   public Graph(int vCount)
   {
	   this.vertexCount=vCount;
	   adjList= new List[vertexCount];
	   
	   for(int i=0;i<vertexCount;i++)
	   {
		   adjList[i]=new LinkedList<Integer>();
	   }
   }
   
   
   public void accept(Scanner sc)
   {
	   System.out.println("Enter Edge Count");
	   this.edgeCount = sc.nextInt();
	   
	   System.out.println("Enter Edge (src, dest) ");
	   for(int i=0;i<edgeCount;i++)
	   {
		   int src = sc.nextInt();
		   int dest = sc.nextInt();
		   
		   adjList[src].add(dest);
		   adjList[dest].add(src);
   
	   }
   }
   
   public void print()
   {
	   for(int u=0;u<vertexCount;u++)
	   {
		   System.out.print(u +": ");
		   for(int v : adjList[u])
		   {
			   System.out.print(" "+ v);
		   }
		   System.out.println();
	   }
   }
   
   public void dfs(int start)
   {
	   Stack<Integer> stack = new Stack<>();
	   boolean visited[] = new boolean[vertexCount];
	   
	   
	   stack.push(start);
	   visited[start]=true;
	   
	   while(!stack.isEmpty())
	   {
		   int curr = stack.pop();
		   System.out.print(curr+" ");
		   
		   for(int neighbour : adjList[curr])
		   {
			   if(!visited[neighbour])
			   {
				   stack.push(neighbour);
				   visited[neighbour]=true;
			   }
		   }
	   }
   }
   
   public void bfs(int start)
   {
	   Queue<Integer> stack = new LinkedList<>();
	   boolean visited[] = new boolean[vertexCount];
	   
	   
	   stack.offer(start);
	   visited[start]=true;
	   
	   while(!stack.isEmpty())
	   {
		   int curr = stack.poll();
		   System.out.print(curr+" ");
		   
		   for(int neighbour : adjList[curr])
		   {
			   if(!visited[neighbour])
			   {
				   stack.offer(neighbour);
				   visited[neighbour]=true;
			   }
		   }
	   }
   }
   
   
}

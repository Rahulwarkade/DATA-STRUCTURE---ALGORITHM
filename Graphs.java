import java.util.*;

public class Graphs 
{
	public static class Edge
	{
		int src,dest,weight;
		Edge(int src,int dest,int weight)
		{
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}

	public static void BFS(ArrayList<Edge>[] graph)
	{
		int n = graph.length;
		Queue<Integer> q = new LinkedList<>();
		boolean visited[]  = new boolean[n];

		q.add(graph[0].get(0).src);

		while(!q.isEmpty())
		{
			int curr = q.remove();

			if(!visited[curr])
			{
				visited[curr] = true;
				System.out.print(curr+" ");

				for(int i=0; i<graph[curr].size(); i++)
				{
					int child = graph[curr].get(i).dest;
					if(!visited[child])
					{
						q.add(child);
					}
				}
			} 
		}
	}
	public static void DFS(ArrayList<Edge>[] graph,int curr,boolean visited[])
	{
		int n = graph.length;
		System.out.print(curr+" ");
		visited[curr] = true;

		for(int i=0; i<graph[curr].size(); i++)
		{
			int child = graph[curr].get(i).dest;
			if(!visited[child])
				DFS(graph,child,visited);
		}
	}
	public static void main(String args[])
	{
		Scanner jin = new Scanner(System.in);
		int V = jin.nextInt();
		int E = jin.nextInt();

		ArrayList<Edge>[] graph = new ArrayList[V];

		for(int i=0; i<V; i++)
		{
			graph[i] = new ArrayList<>();
		}

		// graph[0].add(new Edge(0,1,5));
		// graph[1].add(new Edge(1,2,1));
		// graph[1].add(new Edge(1,3,3));
		// graph[2].add(new Edge(2,1,1));
		// graph[2].add(new Edge(2,3,1));
		// graph[2].add(new Edge(2,4,2));
		// graph[3].add(new Edge(3,1,1));
		// graph[3].add(new Edge(3,2,1));
		// graph[4].add(new Edge(4,2,2));

		for(int i=0; i<E; i++)
		{
			int src,dest,wt;
			src = jin.nextInt();
			dest = jin.nextInt();
			// wt = jin.nextInt();
			graph[src].add(new Edge(src,dest,1));
			graph[dest].add(new Edge(dest,src,1));
		}
		// for(int i=0; i<V; i++)
		// {
		// 	for(int j=0; j<graph[i].size(); j++)
		// 	{
		// 		Edge node = graph[i].get(j);
		// 		System.out.println("source = "+node.src+", destination = "+node.dest+" weight = "+node.weight);
		// 	}
		// }

		BFS(graph);
		System.out.println();
		DFS(graph,graph[0].get(0).src,new boolean[V]);
	}
}
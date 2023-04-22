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
		boolean visited[]  = new boolean[n];

		int cc = 0;
		for(int i=0; i<n; i++)
		{
			if(!visited[i])
			{
				BFSutil(graph,visited);
				cc++;
			}
		}

		System.out.println("\nnumber of components = "+cc);

	}
	public static void BFSutil(ArrayList<Edge>[] graph,boolean visited[])
	{
		Queue<Integer> q = new LinkedList<>();

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

	public static void DFS(ArrayList<Edge>[] graph)
	{
		boolean visited[] = new boolean[graph.length];
		int components = 0;
		for(int i=0; i<graph.length; i++)
		{
			if(!visited[i])
			{
				DFSutil(graph,i,visited);
				components++;
			}
		}
		System.out.println("\nnumber of components = "+components);
	}
	public static void DFSutil(ArrayList<Edge>[] graph,int curr,boolean visited[])
	{
		int n = graph.length;
		System.out.print(curr+" ");
		visited[curr] = true;

		for(int i=0; i<graph[curr].size(); i++)
		{
			int child = graph[curr].get(i).dest;
			if(!visited[child])
				DFSutil(graph,child,visited);
		}
	}

	public static boolean hasPath(ArrayList<Edge>[] graph,int src,int dest,boolean visited[])
	{
		if(src== dest){
			return true;
		}
		visited[src] = true;

		for(int i=0; i<graph[src].size(); i++)
		{
			int child = graph[src].get(i).dest;
			if(!visited[child]&&hasPath(graph,child,dest,visited))
			{
				return true;
			}
		}
		return false;
	}

	public static boolean detectCycle(ArrayList<Edge>[] graph)
	{
		boolean visited[] = new boolean[graph.length];

		for(int i=0; i<graph.length; i++)
		{
			if(!visited[i])
			{
				if(detectCycleUtil(graph,i,-1,visited))
				{
					return true;
				}
			}
		}
		return false;
	}

	public static boolean detectCycleUtil(ArrayList<Edge>[] graph,int curr,int par,boolean visited[])
	{
		visited[curr] = true;

		for(int i=0; i<graph[curr].size(); i++)
		{
			int child = graph[curr].get(i).dest;
			if(visited[child] && child!=par)
			{
				return true;
			}
			else if(!visited[child])
			{
				if(detectCycleUtil(graph,child,curr,visited))
				{
					return true;
				}
			}
		}
		return false;
	}

	public static boolean bipartite(ArrayList<Edge>[] graph)
	{
		int color[] = new int[graph.length];
		for(int i=0; i<graph.length; i++)
		{
			color[i] = -1;
		}

		Queue<Integer> q = new LinkedList<>();

		for(int i=0; i<graph.length; i++)
		{
			if(color[i]==-1)
			{
				q.add(i);
				color[i] = 0;
				while(!q.isEmpty())
				{
					int curr = q.remove();

					for(int j=0; j<graph[curr].size(); j++)
					{
						int child = graph[curr].get(j).dest;
						if(color[child]==-1)
						{
							int nextColor = color[curr]==0 ? 1 : 0;
							color[child] = nextColor;
							q.add(child);
						}
						else if(color[child]==color[curr])
						{
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	public static boolean isCycleUtil(ArrayList<Edge>[] graph,int curr,boolean[] vis,boolean[] stack)
	{
		vis[curr] = true;
		stack[curr] = true;

		for(int i=0; i<graph[curr].size(); i++)
		{
			int child = graph[curr].get(i).dest;

			if(stack[child])
			{
				return true;
			}
			if(!vis[child] && isCycleUtil(graph,child,vis,stack))
			{
				return true;
			}
		}
		stack[curr] = false;
		return false;
	}

	public static void topologicalSortUtil(ArrayList<Edge>[] graph,int curr,boolean[] vis,Stack<Integer> stack)
	{
		vis[curr] = true;

		for(int i=0; i<graph[curr].size(); i++)
		{
			int child = graph[curr].get(i).dest;
			if(!vis[child])
			{
				topologicalSortUtil(graph,child,vis,stack);
			}
		}
		stack.push(curr);
	}
	public static void topologicalSort(ArrayList<Edge>[] graph)
	{
		boolean[] vis = new boolean[graph.length];
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<graph.length; i++)
		{
			if(!vis[i])
			{
				topologicalSortUtil(graph,i,vis,stack);
			}
		}

		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
	}
	public static boolean isCycle(ArrayList<Edge>[] graph)
	{
		boolean vis[] = new boolean[graph.length];
		boolean stack[]  = new boolean[graph.length];
		for(int i=0; i<graph.length; i++)
		{
			if(!vis[i])
			{
				if(isCycleUtil(graph,i,vis,stack))
				{
					return true;
				}
			}
		}
		return false;
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
			// graph[dest].add(new Edge(dest,src,1));
		}
		// for(int i=0; i<V; i++)
		// {
		// 	for(int j=0; j<graph[i].size(); j++)
		// 	{
		// 		Edge node = graph[i].get(j);
		// 		System.out.println("source = "+node.src+", destination = "+node.dest+" weight = "+node.weight);
		// 	}
		// }

		// BFS(graph);
		// System.out.println();
		// DFS(graph,graph[0].get(0).src,new boolean[V]);

		//Components of graph
		// DFS(graph);
		// System.out.println();
		// System.out.println(hasPath(graph,0,5,new boolean[V]));

		// System.out.println(detectCycle(graph));
		// System.out.println(bipartite(graph));
		System.out.println(isCycle(graph));
		// topologicalSort(graph);
	}
}
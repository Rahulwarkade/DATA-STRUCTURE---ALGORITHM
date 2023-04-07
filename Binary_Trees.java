import java.util.*;

public class Binary_Trees
{
	public static class Node
	{
		int data;
		Node left;
		Node right;

		Node(int val)
		{
			data = val;
			left = null;
			right = null;
		}
	}
	public static class BTree
	{
		int idx = -1;
		Node buildTree(int node[])
		{
			idx++;
			if(node[idx]==-1)
				return null;	

			Node newNode = new Node(node[idx]);
			newNode.left = buildTree(node);
			newNode.right = buildTree(node);

			return newNode;
		}
	}

	public static void preOrder(Node root)
	{
		if(root == null){
			System.out.print("-1 ");
			return;
		}

		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void inOrder(Node root)
	{
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}

	public static void postOrder(Node root)
	{
		if(root ==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}

	public static void levelOrder(Node root)
	{
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while(!q.isEmpty())
		{
			Node curr = q.remove();
			if(curr==null)
			{
				if(q.isEmpty())
					break;
				System.out.println();
				q.add(null);
			}
			else
			{
				System.out.print(curr.data+" ");
				if(curr.left!=null)
					q.add(curr.left);
				if(curr.right!=null)
					q.add(curr.right);
			}
		}
	}
	public static int height(Node root)
	{
		if(root == null)
			return 0;
		return Math.max(height(root.left), height(root.right))+1;
	}

	public static int countNodes(Node root)
	{
		if(root ==null)
			return 0;
		return countNodes(root.left)+countNodes(root.right) + 1;
	}	
	public static int sumNodes(Node root)
	{
		if(root ==null)
			return 0;
		return sumNodes(root.left)+sumNodes(root.right) + root.data;
	}

	public static int diameter(Node root)
	{
		if(root == null)
			return 0;
		int leftdimeter = diameter(root.left);
		int rightdimeter = diameter(root.right);
		int selfdimeter = height(root.left) + height(root.right) + 1;

		return Math.max(selfdimeter,Math.max(leftdimeter,rightdimeter));
	}
	public static class Info
	{
		int diam;
		int ht;
		Info(int diam,int ht)
		{
			this.diam = diam;
			this.ht = ht;
		}
	}

	public static Info optDiameter(Node root)
	{
		if(root == null)
			return new Info(0,0);

		Info leftdiam = optDiameter(root.left);
		Info rightdiam = optDiameter(root.right);
		
		int diam = Math.max(leftdiam.ht+rightdiam.ht+1,Math.max(leftdiam.diam,rightdiam.diam));
		int height = Math.max(leftdiam.ht,rightdiam.ht)+1;

		return new Info(diam,height);
	}

	public static boolean isIdentical(Node root,Node subroot)
	{
		if(root==null && subroot == null)
			return true;
		if(root==null || subroot ==null || root.data!=subroot.data)
			return false;

		if(!isIdentical(root.left,subroot.left))
		{
			return false;
		}
		if(!isIdentical(root.right,subroot.right))
			return false;
		return true;
	}
	public static boolean subTree(Node root,Node subroot)
	{
		if(root==null || subroot==null)
			return false;

		if(root.data==subroot.data)
		{
			if(isIdentical(root,subroot))
				return true;
			else  
				return false;
		}

		return subTree(root.left,subroot) || subTree(root.right,subroot);
	}

	public static class Info2
	{
		Node node;
		int hd;
		Info2(int hd,Node node)
		{
			this.hd = hd;
			this.node = node;
		}

	}
	public static void topView(Node root)
	{
		Queue<Info2> q = new LinkedList<>();
		HashMap<Integer,Node> mp = new HashMap<>();

		int min=0,max = 0;
		q.add(new Info2(0,root));
		q.add(null);

		while(!q.isEmpty())
		{
			Info2 curr = q.remove();
			if(curr ==null)
			{
				if(q.isEmpty())
					break;
				else  
					q.add(null);
			}
			else  
			{

				if(curr.node.left!=null){
					q.add(new Info2(curr.hd-1,curr.node.left));
					min = Math.min(curr.hd-1,min);
				}
				if(curr.node.right !=null)
				{
					q.add(new Info2(curr.hd+1,curr.node.right));
					max = Math.max(curr.hd+1,max);
				}
								if(!mp.containsKey(curr.hd))
				{
					mp.put(curr.hd,curr.node);
				}
			}

		}

		for (int i=min; i<=max; i++) {
			System.out.println(mp.get(i).data+" ");
		}
	}

	public static void kthLevel(Node root, int level,int k)
	{
		if(root==null)
			return;
		if(level==k)
		{
			System.out.print(root.data+" ");
			return;
		}

		kthLevel(root.left,level+1,k);
		kthLevel(root.right,level+1,k);
	}

	public static boolean getPath(Node root,ArrayList<Integer> path,int n)
	{
		if(root==null)
			return false;

		path.add(root.data);
		if(root.data == n)
		{
			return true;
		}

		boolean left = getPath(root.left,path,n);
		boolean right = getPath(root.right,path,n);
		// if(!left)
		// {
		// 	path.remove(path.size()-1);
		// }
		// if(!right)
		// {
		// 	path.remove(path.size()-1);
		// }
		if(left || right)
			return true;

		path.remove(path.size()-1);
		return false;

		// return left || right;
	}

	public static int lca(Node root,int n1,int n2)
	{
		ArrayList<Integer> path1 = new ArrayList<>();
		ArrayList<Integer> path2 = new ArrayList<>();

		getPath(root,path1,n1);
		getPath(root,path2,n2);

		int i= 0;
		while(i<path1.size() && i<path2.size())
		{
			if(path1.get(i)!=path2.get(i))
				break;
			i++;
		}

		return path1.get(i-1);
	}
	public static void main(String args[])
	{
		// int node[] = {1,2,4,-1,-1,5,-1,6,-1,7,-1,-1,3,-1,-1};

		int node[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		int node2[] = {2,4,2,-1,-1,-1,5,-1,-1};
		int node3[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};

		BTree tree = new BTree();
		BTree tree2 = new BTree();
		Node root = tree2.buildTree(node);
		Node subroot = tree.buildTree(node3);
		// System.out.println(root.data);
		// System.out.println(root.left.data);
		// System.out.println(root.left.left.data);
		// System.out.println(root.left.right.data);
		// System.out.println(root.right.data);
		// System.out.println(root.right.right.data);

		// System.out.println(optDiameter(root).diam);
		// if(subTree(root,subroot))
		// {
		// 	System.out.println("Subtree of another tree");
		// }
		// else  
		// {
		// 	System.out.println("Not a subtree of another tree");
		// }

		// topView(subroot);
		// kthLevel(subroot,0,2);

		System.out.println(lca(subroot,4,5));
	}
}
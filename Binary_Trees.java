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
	public static void main(String args[])
	{
		// int node[] = {1,2,4,-1,-1,5,-1,6,-1,7,-1,-1,3,-1,-1};

		int node[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		int node2[] = {2,4,2,-1,-1,-1,5,-1,-1};

		BTree tree = new BTree();
		BTree tree2 = new BTree();
		Node root = tree2.buildTree(node);
		Node subroot = tree.buildTree(node2);
		// System.out.println(root.data);
		// System.out.println(root.left.data);
		// System.out.println(root.left.left.data);
		// System.out.println(root.left.right.data);
		// System.out.println(root.right.data);
		// System.out.println(root.right.right.data);

		// System.out.println(optDiameter(root).diam);
		if(subTree(root,subroot))
		{
			System.out.println("Subtree of another tree");
		}
		else  
		{
			System.out.println("Not a subtree of another tree");
		}
	}
}
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
	public static void main(String args[])
	{
		int node[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

		BTree tree = new BTree();
		Node root = tree.buildTree(node);
		// System.out.println(root.data);
		// System.out.println(root.left.data);
		// System.out.println(root.left.left.data);
		// System.out.println(root.left.right.data);
		// System.out.println(root.right.data);
		// System.out.println(root.right.right.data);

		postOrder(root);
	}
}
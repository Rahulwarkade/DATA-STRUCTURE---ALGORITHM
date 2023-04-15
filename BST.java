import java.util.*;

public class BST 
{
	public static class Node 
	{
		int data;
		Node left;
		Node right;

		Node(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static Node root = null;
	public static Node buildBST(Node root,int data)
	{
		if(root == null)
		{
			Node newNode = new Node(data);
			root = newNode;
			return root;
		}

		if(root.data>data)
		{
			root.left = buildBST(root.left,data);
		}
		else  
		{
			root.right = buildBST(root.right,data);
		}

		return root;

	}

	public static void inOrder(Node root)
	{
		if(root == null)
			return;

		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	public static void main(String args[])
	{

		int[]  arr = new int[8];
		Scanner jin = new Scanner(System.in);

		for(int i=0; i<8; i++)
		{
			arr[i] = jin.nextInt();
		    root = buildBST(root,arr[i]);
		}

		inOrder(root);

	}
}
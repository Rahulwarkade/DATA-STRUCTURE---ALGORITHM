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

	public static boolean search(Node root,int key)
	{
		if(root == null )
			return false;

		if(root.data == key){
			return true;
		}
		else if(root.data>key)
		{
			 return search(root.left,key);
		}
		else  
		{
			return search(root.right,key);
		}
	}

	public static Node inOrderSuccessor(Node root)
	{
		if(root.left==null && root.right==null)
			return root;
		if(root.left == null) return root;
		else  
			return inOrderSuccessor(root.left);
	}
	public static Node delete(Node root,int key)
	{
		if(root == null)
			return null;
		if(root.data == key)
		{
			if(root.left==null && root.right==null)
				return null;
			else if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			else{
				Node temp = inOrderSuccessor(root.right);
				root.data = temp.data;
				root.right = delete(root.right,temp.data);
			}
		}
		else
		{
			if(root.data>key)
			{
				root.left = delete(root.left,key);
			}
			else 
			{
				root.right = delete(root.right,key);
			}
		}

		return root;
	}

	public static void preOrder(Node root)
	{
		if(root == null)
			return;

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void main(String args[])
	{

		int[]  arr = new int[10];
		Scanner jin = new Scanner(System.in);

		for(int i=0; i<10; i++)
		{
			arr[i] = jin.nextInt();
		    root = buildBST(root,arr[i]);
		}

		inOrder(root);
		// System.out.println(search(root,4));
		System.out.println();
		root = delete(root,5);
		inOrder(root);
		System.out.println();
		preOrder(root);

	}
}
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

	public static void printInRange(Node root, int k1,int k2)
	{
		if(root == null ) return;

		if(root.data>=k1 && root.data<=k2)
		{
			printInRange(root.left,k1,k2);
			System.out.print(root.data+" ");
			printInRange(root.right,k1,k2);
		}

		if(root.data<k1)
		{
			printInRange(root.right,k1,k2);
		}
		if(root.data>k2)
		{
			printInRange(root.right,k1,k2);
		}
	}

	public static void rootToLeaf(Node root,ArrayList<Integer> path)
	{
		if(root.left== null && root.right== null)
		{
			path.add(root.data);
			System.out.println(path);
			return;
		}
		path.add(root.data);

		if(root.left!=null)	
			rootToLeaf(root.left,path);
		path.remove(path.size()-1);
		if(root.right!=null)
			rootToLeaf(root.right,path);
	}

	public static boolean validateBST(Node root)
	{
		if(root == null) return true;
		if(root.left == null && root.right==null)
			return true;
		if(root.left!=null && root.data<=root.left.data)
			return false;
		if( root.right!=null && root.data>=root.right.data)
			return false;

		return validateBST(root.left) && validateBST(root.right);
	}

	public static Node mirrorBST(Node root)
	{
		if(root == null)
			return null;
		Node left = mirrorBST(root.right);
		Node right = mirrorBST(root.left);

		root.left = left;
		root.right = right;
		return root;
	}

	public static Node balancedBST(int arr[],int st,int en)
	{
		if(st>en) return null;

		int mid = ((en-st)>>1)+st;
		Node root = new Node(arr[mid]);
		root.left = balancedBST(arr,st,mid-1);
		root.right = balancedBST(arr,mid+1,en);

		return root;
	}
	public static Node balanced(ArrayList<Integer> arr,int st,int en)
	{
		if(st>en) return null;

		int mid = ((en-st)>>1)+st;
		Node root = new Node(arr.get(mid));
		root.left = balanced(arr,st,mid-1);
		root.right = balanced(arr,mid+1,en);

		return root;
	}
	public static void sortedList(Node root,ArrayList<Integer> list)
	{
		if(root==null)
			return;

		sortedList(root.left,list);
		list.add(root.data);
		sortedList(root.right,list);
	}

	public static Node bstTobalancedBST(Node root)
	{

		ArrayList<Integer> list = new ArrayList<>();

		sortedList(root,list);

		return balanced(list,0,list.size()-1);
	}
	public static void main(String args[])
	{

		int[]  arr = new int[7];
		Scanner jin = new Scanner(System.in);

		for(int i=0; i<7; i++)
		{
			arr[i] = jin.nextInt();
		    root = buildBST(root,arr[i]);
		}

		// inOrder(root);
		// System.out.println(search(root,4));
		// System.out.println();
		// root = delete(root,5);
		// inOrder(root);
		// System.out.println();

		// root = balancedBST(arr,0,6);
		// inOrder(root);
		// System.out.println();
		// root = mirrorBST(root);
		// System.out.println("\nMirror BST =");
		// preOrder(root);

		// printInRange(root,5,12);
		// rootToLeaf(root,new ArrayList<>());
		// System.out.println(validateBST(root));

		root = bstTobalancedBST(root);
		preOrder(root);
	}
}
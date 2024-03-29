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

	public static class Infoclass 
	{
		boolean isBST; 
		int size,min,max,data,maxSize;

		Infoclass(int data)
		{
			this.data = data;
			this.isBST = true;
			this.size = 0;
			this.min = Integer.MAX_VALUE;
			this.max = Integer.MIN_VALUE;
			this.maxSize = Integer.MIN_VALUE;
		}
	}

	public static Infoclass largestBST(Node root)
	{
		if(root == null)
			return new Infoclass(0);
		Infoclass leftInfo = largestBST(root.left);
		Infoclass rightInfo = largestBST(root.right);
		Infoclass selfInfo = new Infoclass(root.data);
		if(leftInfo.isBST==false || rightInfo.isBST == false)
		{
			selfInfo.isBST = false;
		}

		if(selfInfo.data<leftInfo.min || selfInfo.data>rightInfo.max){
			selfInfo.isBST = false;
		}
		selfInfo.min = Math.min(selfInfo.data,Math.min(leftInfo.min,rightInfo.min));
		selfInfo.max = Math.max(selfInfo.data,Math.max(leftInfo.max,rightInfo.max));
		selfInfo.size = leftInfo.size + rightInfo.size+1;
		if(selfInfo.isBST) selfInfo.maxSize = selfInfo.size;
		else {
			if(leftInfo.isBST) selfInfo.maxSize = leftInfo.size;
			else selfInfo.maxSize = rightInfo.size;
		}
		return selfInfo;
	}

	public static void inOrderSeq(Node root,ArrayList<Integer> path)
	{
		if(root == null) return;

		inOrderSeq(root.left,path);
		path.add(root.data);
		inOrderSeq(root.right,path);
	}

	public static void margePaths(ArrayList<Integer> path,ArrayList<Integer> path1,ArrayList<Integer> path2)
	{
		int i = 0; 
		int j = 0;
		while(i<path1.size() && j<path2.size())
		{
			if(path1.get(i)<path2.get(j))
			{
				path.add(path1.get(i));
				i++;
			}
			else 
			{
				path.add(path2.get(j));
				j++;
			}
		}

		while(i<path1.size())
		{
			path.add(path1.get(i));
			i++;
		}
		while(j<path2.size())
		{
			path.add(path2.get(j));
			j++;
		}
	}
	public static Node margeTooBST(Node root1,Node root2)
	{
		ArrayList<Integer> path1 = new ArrayList<>();
		ArrayList<Integer> path2 = new ArrayList<>();
		ArrayList<Integer> path = new ArrayList<>();
		inOrderSeq(root1,path1);
		inOrderSeq(root2,path2);

		margePaths(path,path1,path2);

		return balanced(path,0,path.size()-1);
	}

	public static class AvlNode 
	{
		int data,height;
		AvlNode left,right;

		AvlNode(int data)
		{
			this.data = data;
			this.height = 1;
		}
	}
	public static class AVLTree
	{
		public static int height(AvlNode root)
		{
			if(root == null)
				return 0;
			return root.height;
		}

		public static int balancedFactor(AvlNode root)
		{
			if(root == null)
				return 0;
			return height(root.left) - height(root.right);
		}
		public static  AvlNode leftRotation(AvlNode Y)
		{
			AvlNode X = Y.right;
			AvlNode T2 = X.left;

			X.left = Y;
			Y.right = T2;

			X.height = Math.max(height(X.left),height(X.right)) + 1;
			Y.height = Math.max(height(Y.left),height(Y.right)) + 1;

			return X;
		}
		public static AvlNode rightRotation(AvlNode Y)
		{
			AvlNode X = Y.left;
			AvlNode T2 = X.right;

			X.right = Y;
			Y.left = T2;

			X.height = Math.max(height(X.left),height(X.right)) + 1;
			Y.height = Math.max(height(Y.left),height(Y.right)) + 1;

			return X;
		}
		public static AvlNode insert(AvlNode root,int key)
		{
			if(root == null)
			{
				return new AvlNode(key);
			}

			if(root.data>key)
			{
				root.left = insert(root.left,key);
			}
			else if(root.data<key)
			{
				root.right = insert(root.right,key);

			}
			else 
			{
				return root;
			}

			root.height = Math.max(height(root.left),height(root.right)) + 1;

			int bf = balancedFactor(root);

			//left left unbalanced
			if(bf>1 && key<root.left.data)
			{
				return rightRotation(root);
			}
			//right right unbalanced
			if(bf< -1 && key>root.right.data)
			{
				root = leftRotation(root);
				return root;
			}
			//left right unbalanced
			if (bf>1 && key>root.left.data)
			{
				root.left = rightRotation(root.left);
				return leftRotation(root);
			}
			//right left unbalaced
			if(bf< -1 && key<root.right.data)
			{
				root.right = leftRotation(root.right);
				return rightRotation(root);
			}

			return root;
		}
	}

	public static void preOrderAvl(AvlNode root)
	{
		if(root == null)
			{return;}
		System.out.print(root.data+" ");
		preOrderAvl(root.left);
		preOrderAvl(root.right);
	}
	public static void main(String args[])
	{

		// int[]  arr = new int[7];
		// Scanner jin = new Scanner(System.in);

		// for(int i=0; i<7; i++)
		// {
		// 	arr[i] = jin.nextInt();
		//     root = buildBST(root,arr[i]);
		// }

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

		// root = bstTobalancedBST(root);
		// preOrder(root);

		// Node rootBT = null;
		// int arye[] = {50,30,5,-1,-1,20,-1,-1,60,45,-1,-1,70,65,-1,-1,80,-1,-1};

		// BTree tr = new BTree();
		// rootBT = tr.buildTree(arye);
		// preOrder(rootBT);
		// Infoclass nod = largestBST(rootBT);
		// System.out.println("largest BST = "+nod.maxSize);

		// Node root1 = null;
		// Node root2 = null;
		// int[] bst1 = {2,1,-1,-1,4,-1,-1};
		// int[] bst2 = {9,3,-1,-1,12,-1,-1};
		// BTree tr = new BTree();
		// BTree tr1 = new BTree();
		// root1 = tr.buildTree(bst1);
		// root2 = tr1.buildTree(bst2);

		// Node margedRoot = margeTooBST(root1,root2);

		// preOrder(margedRoot);

		AVLTree obj = new AVLTree();
		AvlNode avlRoot = null;
		avlRoot = AVLTree.insert(avlRoot,10);
		avlRoot = AVLTree.insert(avlRoot,20);
		avlRoot = AVLTree.insert(avlRoot,30);
		avlRoot = AVLTree.insert(avlRoot,40);
		avlRoot = AVLTree.insert(avlRoot,50);
		// avlRoot = AVLTree.insert(avlRoot,25);

		preOrderAvl(avlRoot);
	}
}
import java.util.LinkedList;
public class LinkedLists
{
	static class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	static class dllNode
	{
		int dlldata;
		dllNode dllnext;
		dllNode dllprev;

		dllNode(int data)
		{
			this.dlldata = data;
			this.dllnext = null;
			this.dllprev = null;
		}
	}
	Node head;
	Node tail;
	static int size;

	static dllNode dllhead;
	static dllNode dlltail;
	static int dllsize;
	void addFirst(int data)
	{
		Node newNode = new Node(data);

		if(head==null)
		{
			head = tail = newNode;
			size++;
			return;
		}

		newNode.next = head;
		head = newNode;
		size++;
	}

	void addLast(int data)
	{
		Node newNode = new Node(data);
		if(head==null)
		{
			head = tail = newNode;
			size++;
			return;
		}

		tail.next = newNode;
		tail = newNode;
		size++;
	}
	void printLL(Node head)
	{
		if(head==null)
		{
			System.out.println("LinkedLists is empty");
			return ;
		}
		Node temp = head;
		while(temp!=null)
		{
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.println("Null");
	}

	void addAtIdx(int data, int idx)
	{
		Node newNode = new Node(data);
		if(idx==0)
		{
			head = tail = newNode;
			size++;
			return;
		}
		Node temp = head; 
		int i= 0;
		while(i<idx-1)
		{
			temp = temp.next;
			i++;
		}
		Node prev = temp.next;
		temp.next = newNode;
		newNode.next = prev;
		size++;
	}

	int removeFirst()
	{
		if(head==null)
		{
			System.out.println("LinkedLists is empty");
			return Integer.MAX_VALUE;
		}
		else if(head.next ==null)
		{
			int data = head.data;
			head = tail = null;
			size--;
			return data;
		}
		int data = head.data;
		head = head.next;
		size--;
		return data;
	}

	int removeLast()
	{
		if(size==0)
		{
			System.out.println("LinkedLists is empty");
			return Integer.MAX_VALUE;
		}
		else if(size==1)
		{
			int val = head.data;
			head = tail = null;
			size--;
			return val;
		}

		Node temp = head;

		while(temp.next!=tail)
		{
			temp = temp.next;
		}
		int val = temp.next.data;//tail.data
		temp.next = null;
		tail = temp;
		size--;
		return val;
	}

	int iterativeSearch(int val)
	{
		Node temp = head;
		int i=0;
		while(temp!=null)
		{
			if(temp.data == val)
			{
				return i;
			}
			temp = temp.next;
			i++;
		}
		return -1;
	}	
	int recursiveSearch(Node head,int val)
	{
		if(head==null)
			return -1;
		if(head.data == val)
			return 0;
		int idx = recursiveSearch(head.next,val);
		if(idx == -1)
			return -1;
		return idx+1;
	}

	void reverseLL()
	{
		Node prev = null;
		Node curr = tail = head;
		Node next;
		while(curr!=null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}

	void removeNthNodeFromEnd(int n)
	{
		if(size==n)
		{
			head = tail = null;
		}
		else if(size<n)
		{
			System.out.println("LinkedLists is empty");
			return;
		}
		int nthNode = size - n;
		int idx = 1;
		Node prev = head;
		while(idx<nthNode)
		{
			prev = prev.next;
			idx++;
		}
		prev.next = prev.next.next;
		size--;
	}

	Node findMid()
	{
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	boolean checkPalindrome()
	{
		if(head==null || head.next==null)
		{
			return true;
		}
		Node midNode = findMid();

		Node prev = null;
		Node curr = midNode;
		Node next;

		while(curr!=null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		Node right = prev;
		Node left = head;

		while(right!=null)
		{
			if(left.data!=right.data)
			{
				return false;
			}
			left = left.next;
			right = right.next;
		}
		return true;
	}

	boolean isCycle()
	{
		Node fast = head;
		Node slow = head;

		while(fast!=null && fast.next !=null)
		{
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow)
				return true;
		}
		return false;
	}

	void removeCycle()
	{
		Node slow = head;
		Node fast = head;
		boolean cycle = false;
		while(fast!=null && fast.next !=null)
		{
			slow = slow.next;
			fast = fast.next.next;

			if(slow==fast)
			{
				cycle = true;
				break;
			}
		}

		if(cycle)
		{
			slow = head;
			Node prev = null;
			while(slow!=fast)
			{
				slow = slow.next;
				prev = fast;
				fast = fast.next;
			}

			prev.next = null;
		}
	}

	Node getMid(Node mhead)
	{
		Node slow = mhead;
		Node fast = mhead.next;

		while(fast!=null && fast.next!=null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	Node merge(Node left,Node right)
	{
		LinkedLists ll = new LinkedLists();
		ll.head = new Node(-1);
		Node temp = ll.head;

		while(left!=null && right != null)
		{
			if(left.data<=right.data)
			{
				temp.next = left;
				left = left.next;
				temp = temp.next;
			}
			else
			{
				temp.next = right;
				right = right.next;
				temp = temp.next;
			}
		}

		while(left!=null)
		{
			temp.next = left;
			left = left.next;
			temp = temp.next;
		}
		while(right!=null)
		{
			temp.next = right;
			right = right.next;
			temp = temp.next;
		}

		return ll.head.next;
	}
	Node mergeSort(Node mainHead)
	{
		if(mainHead==null || mainHead.next == null)
			return mainHead;
		Node mid = getMid(mainHead);
		Node right = mid.next;
		mid.next = null;
		Node left = mainHead;

		Node rightHead = mergeSort(right);
		Node leftHead = mergeSort(left);

		Node list = merge(rightHead,leftHead);

		return list;
	}

	void zigZagLinkedList()
	{
		Node mid = getMid(head);

		Node prev = null;
		Node curr = mid.next;
		mid.next = null;
		Node next;

		while(curr!=null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		Node lhead = head;
		Node rhead = prev;
		Node lnext;
		Node rnext;

		while(rhead!=null && lhead!=null)
		{
			lnext = lhead.next;
			lhead.next = rhead;
			rnext = rhead.next;
			rhead.next =lnext;

			lhead = lnext;
			rhead = rnext;
		}
	}
	void dllAddFirst(int data)
	{
		dllNode newNode = new dllNode(data);
		if(dllsize == 0)
		{
			dllhead = dlltail = newNode;
			dllsize++;
			return;
		}
		newNode.dllnext = dllhead;
		dllhead.dllprev = newNode;
		dllhead = newNode;
		dllsize++;
	}

	void printdll()
	{
		if(dllsize==0){
			System.out.println("Doubly linkedList is empty");
			return;
		}
		dllNode temp = dllhead;
		while(temp!=null)
		{
			System.out.print(temp.dlldata+"<->");
			temp = temp.dllnext;
		}
		System.out.println("null");
		return;
	}
	void dllAddLast(int data)
	{
		dllNode newNode = new dllNode(data);
		if(dllsize == 0)
		{
			dllhead = dlltail = newNode;
			dllsize++;
			return ;
		}
		dlltail.dllnext = newNode;
		newNode.dllprev = dlltail;
		dlltail = newNode;
		dllsize++;
		return;
	}

	int dllremoveFirst()
	{
		int key = -1;
		if(dllsize==0)
		{
			return key;
		}
		else if(dllsize==1)
		{
			key = dllhead.dlldata;
			dllhead = dlltail = null;
			dllsize--;
			return key;
		}
		key = dllhead.dlldata;
		dllhead = dllhead.dllnext;
		dllhead.dllprev = null;
		dllsize--;
		return key;
	}
	int dllremoveLast()
	{
		int key = -1;
		if(dllsize==0)
		{
			return key;
		}
		else if(dllsize==1)
		{
			key = dllhead.dlldata;
			dllhead = dlltail = null;
			dllsize--;
			return key;
		}
		key = dlltail.dlldata;
		dlltail = dlltail.dllprev;
		dlltail.dllnext = null;
		dllsize--;
		return key;
	}
	void reverseDll()
	{
		dllNode curr = dllhead;
		dllNode prev = null;
		dllNode next;

		while(curr!=null)
		{
			next = curr.dllnext;
			curr.dllnext = prev;
			curr.dllprev = next;

			prev = curr;
			curr = next;
		}

		dllhead = prev;
	}
	public static void main(String args[])
	{
		LinkedLists ll = new LinkedLists();

		//Doubly Linked List

		ll.dllAddFirst(24);
		ll.dllAddFirst(23);
		ll.dllAddFirst(22);
		ll.dllAddLast(21);
		ll.dllAddLast(1);
		ll.printdll();
		System.out.println(LinkedLists.dllsize);
		System.out.println(ll.dllremoveLast());
		System.out.println(ll.dllremoveFirst	());
		ll.printdll();
		System.out.println(LinkedLists.dllsize);
		ll.reverseDll();
		ll.printdll();
		ll.addFirst(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addLast(4);
		ll.addLast(5);
		ll.addAtIdx(2,3);
		ll.removeFirst();
		ll.removeLast();
		ll.printLL(ll.head);
		Node temp = ll.mergeSort(ll.head);

		ll.printLL(temp);
		ll.zigZagLinkedList();
		ll.printLL(ll.head);
		ll.removeNthNodeFromEnd(3);
		ll.printLL(ll.head);
		ll.reverseLL();
		ll.printLL(ll.head);
		ll.removeNthNodeFromEnd(2);
		ll.printLL(ll.head);
		System.out.println(ll.checkPalindrome());
		ll.tail.next = ll.head.next;
		System.out.println(ll.isCycle());
		ll.removeCycle();
		System.out.println(ll.isCycle());
		System.out.println(ll.recursiveSearch(ll.head,5));
		System.out.println(ll.recursiveSearch(ll.head,3));

		// LinkedList<Integer> list = new LinkedList<>();

		// list.addFirst(1);
		// list.addLast(2);
		// list.addLast(3);
		// list.addLast(4);
		// System.out.println(list);
		// list.removeFirst();
		// list.removeLast();
		// System.out.println(list);
		// System.out.println(list.size());

	}
}
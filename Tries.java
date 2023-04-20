import java.util.*;

public class Tries 
{
	public static class Node 
	{
		Node children[] = new Node[26];
		boolean eow = false;

		Node()
		{
			for(int i=0; i<26; i++)
				children[i] = null;
		}
	}

	public static Node root = new Node();

	public static void insert(String word)
	{
		Node curr = root;
		for(int i=0; i<word.length(); i++)
		{
			int idx = word.charAt(i) - 'a';

			if(curr.children[idx]==null)
			{
				curr.children[idx] = new Node();
			}
			curr = curr.children[idx];
		}
		curr.eow = true;
	}

	public static boolean search(String word)
	{
		Node curr = root;

		for(int i=0; i<word.length(); i++)
		{
			int idx = word.charAt(i) - 'a';

			if(curr.children[idx]==null)
				return false;
			curr = curr.children[idx];
		}

		return curr.eow;
	}

	public static boolean wordBreak(String key)
	{
		if(key.length() == 0)
			return true;
		for(int i=1; i<=key.length(); i++)
		{
			if(search(key.substring(0,i))&&wordBreak(key.substring(i))){
				return true;
			}
		}
		return false;
	}

	public static class Node1
	{
		Node1 children[] = new Node1[26];
		boolean eow = false;
		int freq;
		Node1(){
			for(int i=0; i<26; i++)
			{
				children[i] = null;
			}
			freq = 1;
		}
	}

	public static Node1 root1 = new Node1();
	public static void insertfp(String key)
	{
		Node1 curr = root1;
		for(int i=0; i<key.length(); i++)
		{
			int idx = key.charAt(i) - 'a';
			if(curr.children[idx]==null)
			{
				curr.children[idx] = new Node1();
			}
			else
			{
				curr.children[idx].freq++;
			}
			curr = curr.children[idx];
		}

		curr.eow = true;
	}

	public static void findPrefix(Node1 root1, String ans)
	{
		if(root1==null)
			return;
		if(root1.freq==1){
			System.out.println(ans);
			return;
		}

		for(int i=0; i<26; i++)
		{
			if(root1.children[i]!=null)
			{
				findPrefix(root1.children[i],ans+(char)(i+'a'));
			}
		}
	}

	public static boolean startsWith(String prefix)
	{
		Node curr = root;

		for(int i=0; i<prefix.length(); i++)
		{
			int idx = prefix.charAt(i)-'a';

			if(curr.children[idx]==null)
				return false;
			curr = curr.children[idx];
		}

		return true;
	}
	public static void main(String args[])
	{
		// String words[] = {"the","a","there","their","any","thee"};
		// String words[] = {"i","like","sam","samsung","mobile","ice"};
		// String words[] = {"zebra","dog","duck","dove"};
		String words[] = {"apple","app","mango","man","woman"};

		for (int i=0; i<words.length; i++) {
			insert(words[i]);
		}

		// System.out.println(search("an"));

		// System.out.println(wordBreak("ilikesam"));
		// root1.freq = -1;
		// findPrefix(root1,"");

		System.out.println(startsWith("man"));
	}
}
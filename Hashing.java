import java.util.*;

public class Hashing
{

	public static class HashMap<K,V>
	{
		class Node 
		{
			K key;
			V value;

			Node(K key, V value)
			{
				this.key = key;
				this.value = value;
			}
		}

		private  int n;
		private  int N;
		private LinkedList<Node> buckets[];

		@SuppressWarnings("unchecked")
		HashMap()
		{
			this.N = 4;
			this.n = 0;
			this.buckets = new LinkedList[4];
			for(int i=0; i<N; i++)
				buckets[i] = new LinkedList<Node>();
		}

		private int hashFun(K key)
		{
			int idx = key.hashCode();
			return Math.abs(idx)%N;
		}
		private int searchInLL(int dIdx,K key)
		{
			LinkedList<Node> ll = buckets[dIdx];
			int d = 0;
			for(int i=0; i<ll.size(); i++)
			{
				if(ll.get(i)==key) return d;
				else d++;
			}
			return -1;
		}
		public void put(K key,V value)
		{
			int bIdx = hashFun(key);
			int dIdx = searchInLL(bIdx,key);

			if(dIdx!=-1)
			{
				Node node = buckets[bIdx].get(dIdx);
				node.value = value;
			}
			else 
			{
				Node newNode = new Node(key,value);
				buckets[bIdx].add(newNode);
				n++;
			}
		}
	}
	public static void main(String args[])
	{
		// HashMap<String,Integer> hm = new HashMap<>();

// .put(key,value) -> O(1)
		// hm.put("India",130);
		// hm.put("China",120);
		// hm.put("US",30);
		// hm.put("Russia",100);

		// System.out.println(hm);
// .get(key) -> O(1)
		// int population = hm.get("India");
		// System.out.println("India population = "+population);
		// System.out.println("Indonesia popultaion = "+hm.get("Indonesia"));

// .contiansKey(key) -> O(1)

		// System.out.println(hm.containsKey("US"));
		// System.out.println(hm.containsKey("UK"));
// .remove(key) -> O(1)

		// System.out.println(hm.remove("China"));
		// System.out.println(hm);

		// System.out.println(hm.size());
		// System.out.println(hm.isEmpty());
		// hm.clear();
		// System.out.println(hm.isEmpty());

		// Set<String> keys = hm.keySet();

		// System.out.println(hm.entrySet());
		// for(String key : keys)
		// {
		// 	System.out.println("key="+key+", value="+hm.get(key));
		// }

		HashMap<String,Integer> hm = new HashMap<>();

		hm.put("India",24);

	}
}
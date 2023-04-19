import java.util.*;

public class Hashing
{

	// public static class HashMap<K,V>
	// {
	// 	class Node 
	// 	{
	// 		K key;
	// 		V value;

	// 		Node(K key, V value)
	// 		{
	// 			this.key = key;
	// 			this.value = value;
	// 		}
	// 	}

	// 	private int n;
	// 	private int N;
	// 	private LinkedList<Node> buckets[];

	// 	@SuppressWarnings("unchecked")
	// 	HashMap()
	// 	{
	// 		this.N = 4;
	// 		this.n = 0;
	// 		this.buckets = new LinkedList[4];
	// 		for(int i=0; i<N; i++)
	// 			buckets[i] = new LinkedList<Node>();
	// 	}

	// 	private int hashFun(K key)
	// 	{
	// 		int idx = key.hashCode();
	// 		return Math.abs(idx)%N;
	// 	}
	// 	private int searchInLL(int dIdx,K key)
	// 	{
	// 		LinkedList<Node> ll = buckets[dIdx];
	// 		int d = 0;
	// 		for(int i=0; i<ll.size(); i++)
	// 		{
	// 			if(ll.get(i).key==key) return d;
	// 			else d++;
	// 		}
	// 		return -1;
	// 	}

    //     @SuppressWarnings("unchecked")
    //     private void rehash()
    //     {
    //         LinkedList<Node> oldBuckets[] = buckets;
    //         buckets = new LinkedList[2*N];
    //         N = 2*N;
    //         n = 0;
    //         for(int i=0; i<N; i++)
    //         {
    //             buckets[i] = new LinkedList<>();
    //         }

    //         for(int i=0; i<oldBuckets.length; i++)
    //         {
    //             LinkedList<Node> ll = oldBuckets[i];
    //             for(int j=0; j<ll.size(); j++)
    //             {
    //                 Node node = ll.get(j);
    //                 put(node.key,node.value);
    //             }
    //         }
    //     }

    //     public boolean isEmpty()
    //     {
    //         return n==0;
    //     }
	// 	public void put(K key,V value)
	// 	{
	// 		int bIdx = hashFun(key);
	// 		int dIdx = searchInLL(bIdx,key);


	// 		if(dIdx!=-1)
	// 		{
	// 			Node node = buckets[bIdx].get(dIdx);
	// 			node.value = value;
	// 		}
	// 		else 
	// 		{
	// 			Node newNode = new Node(key,value);
	// 			buckets[bIdx].add(newNode);
	// 			n++;
	// 		}
    //         double lambda = (double)n/N;
    //         if(lambda>=1.0)
    //         {
    //             rehash();
    //         }

	// 	}

    //     public boolean containsKey(K key)
    //     {
    //         int bIdx = hashFun(key);
	// 		int dIdx = searchInLL(bIdx,key);
	// 		if(dIdx!=-1)
	// 		{
    //             return true;
	// 		}
    //         return false;
    //     }

    //     public V get(K key)
    //     {
    //         int bIdx = hashFun(key);
    //         int dIdx = searchInLL(bIdx, key);

    //         if(dIdx!=-1)
    //         {
    //             Node node = buckets[bIdx].get(dIdx);
    //             return node.value;
    //         }
    //             return null;
    //     }

    //     public V remove(K key)
    //     {
    //         int bIdx = hashFun(key);
    //         int dIdx = searchInLL(bIdx, key);

    //         if(dIdx!=-1)
    //         {
    //             Node node = buckets[bIdx].remove(dIdx);
    //             n--;
    //             return node.value;
    //         }
    //         return null;            
    //     }

    //     public ArrayList<K> keySet()
    //     {
    //         ArrayList<K> list = new ArrayList<>();
    //         for(int i=0; i<N; i++)
    //         {
    //             LinkedList<Node> ll = buckets[i];
    //             for(int j=0; j<ll.size(); j++)
    //             {
    //                 list.add(ll.get(j).key);
    //             }
    //         }
    //         return list;
    //     }
    //     public int size()
    //     {
    //         return n;
    //     }
    //     public int length()
    //     {
    //         return N;
    //     }
	// }
	
	public static void majorityElm(int[] arr)
	{
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int i=0; i<arr.length; i++)
		{
			if(hm.containsKey(arr[i]))
			{
				hm.put(arr[i],hm.get(arr[i])+1);
			}
			else  
			{
				hm.put(arr[i],1);
			}
		}
		int n = arr.length/3;
		for(Integer key : hm.keySet())
		{
			if(hm.get(key)>n)
				System.out.print(key);
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

// Implementation of HashMap

		// HashMap<String,Integer> hm = new HashMap<>();

		// hm.put("India",24);
		// hm.put("China",20);
		// hm.put("US",10);
		// hm.put("UK",5);
		// hm.put("France",50);
		// hm.put("Russia",99);
		// hm.put("Japan",88);
		// hm.put("Ukrain",88);
		// hm.put("Argentina",88);
		// hm.put("Pakistan",88);
		// hm.put("Koria",88);
		// hm.put("Astrilia",88);
        
        // ArrayList<String> keys = hm.keySet();
        
        // for (String key : keys) {
        //     System.out.println("key = "+key+", value = "+hm.get(key));
        // }

        // System.out.println(hm.get("China"));
        // System.out.println(hm.remove("China"));
        // System.out.println(hm.get("China"));
        // System.out.println(hm.isEmpty());
        // System.out.println(hm.containsKey("India"));
        // System.out.println(hm.size());
        // System.out.println(hm.length());

// LinkedHashMap
		// HashMap<String,Integer> hm = new HashMap<>();
		// LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
		// hm.put("Ukrain",88);
		// hm.put("Argentina",88);
		// hm.put("Pakistan",88);

		// lhm.put("Ukrain",88);
		// lhm.put("Argentina",88);
		// lhm.put("Pakistan",88);

		// System.out.println(hm);
		// System.out.println(lhm);
// TreeMap
		// TreeMap<String,Integer> tm = new TreeMap<>();
		// tm.put("Ukrain",88);
		// tm.put("Argentina",88);
		// tm.put("Pakistan",88);
		// System.out.println(tm);

		int[] nums = {1,3,2,5,1,3,1,5,1};
		majorityElm(nums);
	}
}
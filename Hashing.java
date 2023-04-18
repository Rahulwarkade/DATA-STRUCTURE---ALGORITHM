import java.util.*;

public class Hashing
{
	public static void main(String args[])
	{
		HashMap<String,Integer> hm = new HashMap<>();

// .put(key,value) -> O(1)
		hm.put("India",130);
		hm.put("China",120);
		hm.put("US",30);
		hm.put("Russia",100);

		System.out.println(hm);
// .get(key) -> O(1)
		int population = hm.get("India");
		System.out.println("India population = "+population);
		System.out.println("Indonesia popultaion = "+hm.get("Indonesia"));

// .contiansKey(key) -> O(1)

		System.out.println(hm.containsKey("US"));
		System.out.println(hm.containsKey("UK"));
// .remove(key) -> O(1)

		System.out.println(hm.remove("China"));
		System.out.println(hm);

		System.out.println(hm.size());
		System.out.println(hm.isEmpty());
		hm.clear();
		System.out.println(hm.isEmpty());
	}
}
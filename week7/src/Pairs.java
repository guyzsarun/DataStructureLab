import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import org.junit.internal.ExactComparisonCriteria;

public class Pairs {

	public static ArrayList<Pair> allPairs(int[] a) {
		ArrayList<Pair> result = new ArrayList<Pair>();
		for (int i=0;i<a.length-1;i++) {
			Pair x = new Pair();
			x.first=a[i];
			x.second=a[i+1];
			result.add(x);
		}
		Pair x = new Pair();
		x.first=a[a.length-1];
		x.second=a[0];
		result.add(x);
		return result;
	}

	public static Hashtable<Integer, Integer> allPairs02(int[] a) {
		Hashtable<Integer, Integer> h = new Hashtable<Integer, Integer>();
		for (int i=0;i<a.length-1;i++) {
			h.put(a[i],a[i+1]);
		}
		h.put(a[a.length-1],a[0]);
		return h;
	}

	public static int find(ArrayList<Pair> a, int key) throws Exception {
		for (int i=0;i<a.size();i++) {
			if (a.get(i).first==key){
				return a.get(i).second;
			}
		}
		throw new Exception();
	}
	

	public static int find02(Hashtable<Integer, Integer> h, int key) {
		return h.get(key);
	}

	public static void printArrayListPairs(ArrayList<Pair> r) {
		for (Pair pair : r) {
			System.out.print("(" + pair.first + ", " + pair.second + "), ");
		}
		System.out.println("");
		System.out.println("");
	}

}

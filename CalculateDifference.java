import java.util.HashMap;
import java.util.Map;

public class CalculateDifference {

	public static void main(String[] args) {
		char[] arr1 = { 'A', 'B', 'C', 'D' };
		char[] arr2 = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'A' };
		Map<Character, Integer> mp = new HashMap<Character, Integer>();
		for (char c : arr1) {
			if (mp.containsKey(c)) {
				mp.put(c, mp.get(c) + 1);
			} else
				mp.put(c, 1);
		}
		for (char c : arr2) {
			if (!mp.containsKey(c)) {
				System.out.print(c);
			}
		}
	}

}
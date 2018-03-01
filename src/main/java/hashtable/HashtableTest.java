package hashtable;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author elon
 *
 */
public class HashtableTest {

	public static void main1(String[] args) {
		//引用类型
		Map map = new Hashtable<String, Integer>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		Map map1 = map;
		Map map2 = map;
		map1.put("four", 4);
		map2.put("five", 5);
		System.out.println("=============");
		List list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		List list1 = list;
		list1.add("4");
		List list2 = list;
		list2.add("3");
		System.out.println("=============");
	}

	public static void main(String[] args) {
		ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap();
		String curr = concurrentHashMap.putIfAbsent("1","1");
		System.out.println(curr);
		curr = concurrentHashMap.putIfAbsent("1","2");
		System.out.println(curr);
		curr = concurrentHashMap.putIfAbsent("1","3");
		System.out.println(curr);
	}

}

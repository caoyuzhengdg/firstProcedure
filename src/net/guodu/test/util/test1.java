package net.guodu.test.util;

import java.util.HashMap;
import java.util.Map;

public class test1 {

	public static void main(String[] args) {
		
		Map<String, String> map1 = new HashMap<String, String>();
		
		map1.put("北京", "beijing");
		String aa = map1.get("北京");
		System.out.println(aa);
		
		String listname = "list:sms:abc:mt:95599:cmpp:1";
		
		int i = listname.lastIndexOf(":");
		
		String listname_new = listname.substring(0,i);
		System.out.println(listname_new);

		String listname_new1 = listname.substring(i);
		
		System.out.println(listname_new1);
		
//		map1.put("北京", "beijing1");
//		String aa1 = map1.get("北京");
//		System.out.println(aa1);
		
	}

}

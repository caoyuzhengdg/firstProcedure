/**
 * 
 */
package net.guodu.test.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author wangyajing
 *
 */
public class b {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("101", "赌博");
//		map.put("103", "456");
//		map.put("104", "123");
//		map.put("102", "买卖");
//		
//		 Set<Integer> tenSetInteger = new HashSet<Integer>();
//		 tenSetInteger.add(1);
//		 tenSetInteger.add(2);
//		 
//		String str = "456赌博123";
//		Set<String> setStr = getkeywordid(map,str);
//		
//		Iterator it1 = setStr.iterator();
//        while(it1.hasNext()){
//            System.out.println("包含违禁词ID："+it1.next());
//        }
//		
//        String idstr = "101|102|103|104";
//        String []  idstrarr= idstr.split("\\|");
//        Set<String> setStr1 = new HashSet<String>();
//        for(int i = 0;i<idstrarr.length;i++){
//        	setStr1.add(idstrarr[i]);
//        }
//        
//		Boolean b  = getValue(setStr,setStr1);
//        System.out.println("是否拦截："+b);
		
		
		String m = "18910319243".substring(11-4, 11);
		System.out.println("是否拦截："+m);
	}
	
	 //获取
	 public static Boolean getValue(Set<String> set1,Set<String> set2){
		 Boolean flag = false;
		 int count = 0;
		 Iterator it1 = set1.iterator();
	        while(it1.hasNext()){
	        	String aa = (String) it1.next();
	        	if(set2.contains(aa)){
	        		System.out.println("符合包含违禁词ID："+aa);
		            count ++;
	        	}
	        }
	      if (set1.size()==count){
	    	  flag = true;
	      }
		 return flag;
	 }
	 
	 //获取短信内容包含违禁词的ID
	 public static Set<String> getkeywordid(Map<String, String> map,String str){
		 Set<String> setStr = new HashSet<String>();
		 Set<Entry<String, String>> entrys = map.entrySet();
		 for (Map.Entry<String, String> entry :entrys ) {  
			    if (str.contains(entry.getValue())){
				    setStr.add(entry.getKey());
			    }
			}  
		 return setStr;
	 }

}

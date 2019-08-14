package net.guodu.test.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 获取长短信头，针对同一手机号降低短信头重复率
 * 
 * @author zxj
 * 
 */
public class test {
	public static void main(String args []){

		System.out.println("1111【中国农业银行】222【中国农业银行】333".replace("【中国农业银行】", ""));
		System.out.println("1111【中国农业银行】222【中国农业银行】333".replaceFirst("【中国农业银行】", ""));
		System.out.println("1111【中国农业银行】222【中国农业银行】333【中国农业银行】".replaceAll("【中国农业银行】", ""));
	}
    
    
 // 用于生成长短信头的数组
    private static Integer[] flag;

    public test(int n) {
 //在此处为数组赋值，输入参数n代表以手机号后n位来互斥，目前n取值为4，即手机号后四位
    	int size = (int) Math.pow(10,n);
		System.out.println("长短信头的数组长度：" + size);
    	flag = new Integer[size];
		for (int i = 0; i < flag.length; i++) {
			
			flag[i] = i % 256;
//			System.out.println("数组元素："+ flag[i]);	
		}
    }

//	将数组中的int值转换为长短信头00~ff 
	public synchronized static String toLetterInt(int x) {
		
		if (x < 0 && x > -16) {
			return '0' + Integer.toHexString(-x);
		} else if (x >= 0 && x < 16) {
			return '0' + Integer.toHexString(x);

		} else if (x < 256 && x >= 16) {
			return Integer.toHexString(x);
		} else if (x <= -16 && x > -256){
			return Integer.toHexString(-x);
		}else {
			x = 0;
			return '0' + Integer.toHexString(x);
		}
	}

//	该方法即为获取长短信头的方法，输入参数：手机号、代表手机号后A位的整数a，目前A取值为4
    public static String GetLongSmsFlag(String mobile,int a) {
        String c = null;
        
				try {
//			 		得到手机号的后a位，转换为整数
			        if (mobile == null || mobile.length() < 11) {
			        	c = "00";
			        }else{
						int key = Integer.valueOf(mobile.substring(11-a, 11));
						if (key < 0) {
							key = 0 - key;
							if (key >= flag.length){
								key = key % flag.length;	
							}
						}else if (key >= flag.length){
							key = key % flag.length;
						}
//	    		将手机号后A位得到的值，作为数组下标，得到该元素+1后的值
						if (flag[key] >= 0&& flag[key] < 255) {
							System.out.println(flag[key]);
							flag[key]++;
							System.out.println(flag[key]);

						}else if (flag[key] >= 255){
							flag[key] = 0;
						}
//			    		将数组中的值转换为短信头00~ff			
						System.out.println(flag[key]);

						c = new String(toLetterInt(flag[key]));
			        }

					Pattern p = Pattern.compile("[0-9a-fA-F][0-9a-fA-F]", Pattern.DOTALL);
//		    		将转换后的值做一下模型匹配，保证短信头格式规范								
					Matcher matcher = p.matcher(c);
					boolean f = matcher.matches();
					if (!f) {
						c = "ff";
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "ff";
//		    		如果出现异常，则抛出异常，同时返回值							
				}catch (Exception e){
					System.err.println("Exception caught:" + e.getMessage());
					return "ff";
				}
//	    返回值c即为短信头								    
        return c;
    }

//    public static void main(String[] args) {
//		String[] head;
//		head=new String[256];
//    	new LongSmsFlag(4);
//    	String mobile="undefined";
//		for (int i = 0; i < 256; i++) {
//			head[i]=LongSmsFlag.GetLongSmsFlag(mobile,4);
//			System.out.println("短信头："+ head[i]);	
//		}
//		int[] b = new int[head.length]; 
//
//		int j=0;
//		float f=1.00f;
//
//		for(int i=0; i<head.length; i++)
//		{
//			int d=Integer.valueOf(head[i],16);
//		    b[d]++;
//
//		}
//		
//		for (int i =0;i <b.length;i++){
//		if (b[i]> 1) {
//
//			j=j+(b[i]-1);
//
//			System.out.println("出现相同头："+Integer.toHexString(i) +"重复次数："+b[i]);	
//
//		}
//	}
//		f=(j*100)/head.length;
//		System.out.println("重复个数："+j+"重复率："+f);	
//
//		
//	}
       
    
}
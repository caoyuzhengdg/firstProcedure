package net.guodu.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Tools {


	public static String trancMobile(String mobile) {
		if (mobile == null || mobile.length() <= 2) {
			return null;
		}
		if (mobile.substring(0, 1).equals("+")) {
			mobile = mobile.substring(1, mobile.length());
		}
		if (mobile.substring(0, 2).equals("86")) {
			mobile = mobile.substring(2, mobile.length());
		}
		return mobile.trim();// 20130128 pq add
	}

	public static String gettime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return sdf.format(date) ;
	}

	public static String delayByHour(int delay, String timeFmt) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, delay);
		SimpleDateFormat formatter = new SimpleDateFormat(timeFmt);
		return formatter.format(calendar.getTime());
	}

	public static String millisToDateStr(long millis) {
		return DateToString(new Date(millis),"yyyy-MM-dd HH:mm:ss");
	}

	public static Date StringToDate(String DT) {
		return StringToDate(DT, "yyyyMMddHHmmss");
	}

	public static Date StringToDate(String DT, String fmt) {
		return StringToDate(DT, fmt, new Date());
	}

	public static Date StringToDate(String DT, String fmt, Date DefaultDT) {
		Date dt;
		try {
			dt = new SimpleDateFormat(fmt).parse(DT);
		} catch (Exception E) {
			dt = DefaultDT;
		}
		return dt;
	}

	public static String DateToString(Date dd) {
		return DateToString(dd, "yyyyMMddHHmmss");
	}

	public static String DateToString(Date dd, String fmt) {
		String time = "";
		SimpleDateFormat tmp = new SimpleDateFormat(fmt);
		try {
			time = tmp.format(dd);
		} catch (Exception E) {
			time = "";
		}
		return time;
	}

	public static String getParameter(String paraName) {
		ResourceBundle bundle = getBundle("ApplicationResource.properties");
		String value = bundle.getString(paraName);
		return value;
	}

	public static String getParameterC3P0(String paraName) {
		ResourceBundle bundle = getBundle("c3p0.properties");
		String value = bundle.getString(paraName);
		return value;
	}

	public static ResourceBundle getBundle(String fileName) {
		if (fileName == null) {
			throw new NullPointerException();
		}
		InputStream is = null;
		PropertyResourceBundle bundle = null;
		try {
			is = new FileInputStream(new File(fileName));
			bundle = new PropertyResourceBundle(is);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (is != null) {
				try {
					is.close();
				} catch (IOException ioex) {
					ioex.printStackTrace();
				}
			}
		}
		return bundle;
	}

	/**
	 *  ��Ŀû�е��ô˷��� ũ������֧��UTF��8 ��ע��
	 * @return
	 */
//	public static String getMD5Result(String username, String password,
//			String checkcode) {
//		String calresult = "";
//		try {
//			String s = username + "000000000" + password + checkcode;
//			MessageDigest md = MessageDigest.getInstance("MD5");
//			md.reset();
//			md.update(s.getBytes("UTF-8"));
//			byte[] byteArray = md.digest();
//			// calresult=new String(byteArray,"UTF-8");
//			StringBuffer md5StrBuff = new StringBuffer();
//			for (int i = 0; i < byteArray.length; i++) {
//				if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
//					md5StrBuff.append("0").append(
//							Integer.toHexString(0xFF & byteArray[i]));
//				else
//					md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
//			}
//			calresult = md5StrBuff.toString();
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return calresult;
//	}

	public static String getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
		if (month.length() < 2) {
			month = "0" + month;
		}
		String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		if (day.length() < 2) {
			day = "0" + day;
		}
		String hour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
		if (hour.length() < 2) {
			hour = "0" + hour;
		}
		String minute = String.valueOf(calendar.get(Calendar.MINUTE));
		if (minute.length() < 2) {
			minute = "0" + minute;
		}
		String second = String.valueOf(calendar.get(Calendar.SECOND));
		if (second.length() < 2) {
			second = "0" + second;
		}
		return month + day + hour + minute + second;
	}

	public static String getCurrentTime(String timeFmt) {
		SimpleDateFormat formatter = new SimpleDateFormat(timeFmt);
		return formatter.format(new java.util.Date());
	}

	// public static void main(String args[]) {
	// System.out.println(gettime());
	// }
}

package net.guodu.test.util;

public class SeqUtil {

	private static int seq = 100;

	public static synchronized int getSeq() {
		if (seq > 99999) {
			seq = 10000;
		}
		return seq++;
	}

	private static long phone = 13000000000l;

	public static synchronized long getPhone() {
		if (phone > Integer.MAX_VALUE) {
			phone = 13000000000l;
		}
		return phone++;
	}
	
	private static int clientCount = 1;
	
	public static synchronized long getClientCount(){
		return clientCount++;
	}
}

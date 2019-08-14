package net.guodu.test.util;

import java.io.IOException;

public class Config {

	public static String ip;
	public static int port;
	public static int right;
	public static int wrong;
	public static int client_2;
	public static int sleepTime;
	public static int sleepTime2;
	public static int office;
	public static int inner;
	
	public static String desmobile;
	public static String content;
	public static String product_code;
	public static String longid;

	
	public static void load() {
		Args arg = null;
		try {
			Cfg cfg = new Cfg("config.xml");
			arg = cfg.getArgs("common");
			ip = arg.get("ip", "127.0.0.1");
			port = arg.get("port", 60000);
			right = arg.get("right", 0);
			wrong = arg.get("wrong", 0);
			client_2 = arg.get("client_2", 0);
			sleepTime = arg.get("sleep_time", 200);
			sleepTime = arg.get("sleep_time2", 200);
			office = arg.get("Office", 0);
			content = arg.get("content", "");
			inner = arg.get("inner", 0);
			
			desmobile = arg.desmobile("desmobile", "0" ) ;
			content = arg.content("content", "0" ) ;
			product_code = arg.product_code("product_code", "0" ) ;
			longid = arg.longid("longid", "0" ) ;
			
			System.out.println("### IP=" + ip + ",Port=" + port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static String getIp() {
		return ip;
	}


	public static void setIp(String ip) {
		Config.ip = ip;
	}


	public static int getPort() {
		return port;
	}


	public static void setPort(int port) {
		Config.port = port;
	}


	public static int getRight() {
		return right;
	}


	public static void setRight(int right) {
		Config.right = right;
	}


	public static int getWrong() {
		return wrong;
	}


	public static void setWrong(int wrong) {
		Config.wrong = wrong;
	}


	public static int getClient_2() {
		return client_2;
	}


	public static void setClient_2(int client_2) {
		Config.client_2 = client_2;
	}


	public static int getSleepTime() {
		return sleepTime;
	}


	public static void setSleepTime(int sleepTime) {
		Config.sleepTime = sleepTime;
	}


	public static int getSleepTime2() {
		return sleepTime2;
	}


	public static void setSleepTime2(int sleepTime2) {
		Config.sleepTime2 = sleepTime2;
	}


	public static int getOffice() {
		return office;
	}


	public static void setOffice(int office) {
		Config.office = office;
	}


	public static int getInner() {
		return inner;
	}


	public static void setInner(int inner) {
		Config.inner = inner;
	}


	public static String getDesmobile() {
		return desmobile;
	}


	public static void setDesmobile(String desmobile) {
		Config.desmobile = desmobile;
	}


	public static String getContent() {
		return content;
	}


	public static void setContent(String content) {
		Config.content = content;
	}


	public static String getProduct_code() {
		return product_code;
	}


	public static void setProduct_code(String product_code) {
		Config.product_code = product_code;
	}


	public static String getLongid() {
		return longid;
	}


	public static void setLongid(String longid) {
		Config.longid = longid;
	}

}

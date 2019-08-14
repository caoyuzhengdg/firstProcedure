package net.guodu.test.thread;

import net.guodu.test.util.Config;

public class Start { 

	public static void main(String args[]) {
		Config.load();
		org.apache.log4j.PropertyConfigurator.configure("Log4j.properties");
		
		
//		Loger.mtlog.info("农行客户端启动 用法：java -jar AbcClient.jar");
//		Loger.mtlog.info("客户端启动,当恰时间："+Tools.gettime());
//
//		TimerTask task = new TimerTask() {
//			@Override   
//			public void run() {
				new ThreadPool().start();
//			}
//		};	
//		Timer timer = new Timer();
//		long delay = 0;
////		休眠时间，43200000 * 1000 12个小时 
//		long intevalPeriod = 43200000 * 1000;
//		timer.scheduleAtFixedRate(task, delay, intevalPeriod);
	}

}

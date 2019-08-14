package net.guodu.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.guodu.test.socket.ClientSocket4;
import net.guodu.test.util.Config;
import net.guodu.test.util.Loger;

public class ThreadPool {

	private static ExecutorService instance = ThreadPool.getInstance();

	public static synchronized ExecutorService getInstance() {
		if (instance == null) {
			instance = Executors.newFixedThreadPool(10);
		}
		return instance;
	}
	private void initThread() {
		if (Config.right == 1) {
			//客户端测试
			for (int i = 0; i < 1; i++) {
				Loger.log.info("第 "+i +" 个连接！！！！");
				instance.execute(new ClientSocket4());
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void start() {
		initThread();
	}

	public static void stopThreadPool(ExecutorService pool) {
		pool.shutdown();
	}

}

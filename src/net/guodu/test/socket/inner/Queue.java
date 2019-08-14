package net.guodu.test.socket.inner;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Queue {

	public static ConcurrentLinkedQueue<Object> submitQueue = new ConcurrentLinkedQueue<Object>();

	public static void add(Object submitRecord) {
		submitQueue.add(submitRecord);
	}

	public static Object poll() {

		return submitQueue.poll();

	}

	public synchronized static int size() {
		return submitQueue.size();
	}

	public static Object[] getMessages(int count) {
		int batchNum = 0;
		int size = size();

		if (count > size)
			batchNum = size;
		else
			batchNum = count;

		Object[] result = new Object[batchNum];
		for (int i = 0; i < batchNum; i++) {
			Object sr = submitQueue.poll();
			if (null != sr)
				result[i] = sr;
		}
		return result;
	}

}

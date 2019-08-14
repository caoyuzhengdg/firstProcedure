package net.guodu.test.socket.inner;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import net.guodu.test.socket.RecvThread;
import net.guodu.test.util.Config;

public class ClientSocketInnerTest extends Thread {
	Socket clientSocket;
	byte[] packet = new byte[300];
	RecvThread recvThread;

	public ClientSocketInnerTest() {
		try {
			clientSocket = new Socket(Config.ip, Config.port);
			clientSocket.setSoTimeout(5000); // 设置时延时间，单位毫秒
			System.out.println(clientSocket);

			recvThread = new RecvThread(clientSocket);
			recvThread.start();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {

		GenerateTestDataThread t = new GenerateTestDataThread();
		t.start();

		DataOutputStream oos = null;
		try {
			oos = new DataOutputStream(clientSocket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			while (true) {

				if (clientSocket == null || clientSocket.isClosed()) {
					return;
				}

				int size = Queue.size();
				for (int i = 0; i < size; i++) {
					byte[] bytes = (byte[]) Queue.poll();
					oos.write(bytes);
					oos.flush();
				}

				Thread.sleep(Config.sleepTime);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (clientSocket != null && !clientSocket.isClosed()) {
				try {
					clientSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// /// end 发送下行
	}
}

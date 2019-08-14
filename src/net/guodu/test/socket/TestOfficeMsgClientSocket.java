package net.guodu.test.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import net.guodu.test.msg.ABCUnifiedOfficeMsg;
import net.guodu.test.util.Config;
import net.guodu.test.util.SeqUtil;

public class TestOfficeMsgClientSocket implements Runnable {

	Socket clientSocket;
	byte[] packet = new byte[300];
	RecvThread recvThread;

	public void run() {

		int count = 1;
		try {
			// clientSocket = new Socket("192.168.1.121", 60000);
			clientSocket = new Socket(Config.ip, Config.port);
			// clientSocket = new Socket("218.241.67.231", 60000);
			clientSocket.setSoTimeout(5000); // 设置时延时间，单位毫秒
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		recvThread = new RecvThread(clientSocket);
		recvThread.start();

		int total = 0;
		// ///// 发送下行
//		while (true) {

			try {

//				if (count > 50) {
//					clientSocket.close();
//					clientSocket = new Socket(Config.ip, Config.port);
//					recvThread.setSocket(clientSocket);
//					count = 0;
//				}
				DataOutputStream oos = new DataOutputStream(clientSocket
						.getOutputStream());

				// 发送下行消息
				packet = ABCUnifiedOfficeMsg.getSubmitPacket(String
						.valueOf(SeqUtil.getSeq()));
				oos.write(packet);
				oos.flush();

				// // 发送下行消息
//				packet = ABCUnifiedOfficeMsg.getSGIPSubmitPacket(String
//						.valueOf(SeqUtil.getSeq()));
//				oos.write(packet);
//				oos.flush();
				
//				packet = ABCUnifiedOfficeMsg.getTelcomSubmitPacket(String
//						.valueOf(SeqUtil.getSeq()));
//				oos.write(packet);
//				oos.flush();
				
				// System.out.println("=====>"
				// + TypeConvert.byteArrayToHexString(packet));

				total = count;
				System.out.println("ABC Client --"
						+ Thread.currentThread().getId() + "--: 已发送" + total
						* 2);
				count++;
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
				try {
					clientSocket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

//		}
		// /// end 发送下行
	}
}

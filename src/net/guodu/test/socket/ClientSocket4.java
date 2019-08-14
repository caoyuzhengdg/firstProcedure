package net.guodu.test.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import net.guodu.test.msg.ABCSubmitMsg;
import net.guodu.test.msg.LongMsg;
import net.guodu.test.util.Config;
import net.guodu.test.util.Loger;
import net.guodu.test.util.SeqUtil;
import net.guodu.test.util.Tools;

public class ClientSocket4 implements Runnable {

	Socket clientSocket;
	byte[] packet = new byte[300];
	RecvThread recvThread;

	public ClientSocket4() {
		try {
			clientSocket = new Socket(Config.ip, Config.port);
			clientSocket.setSoTimeout(5000); //  
			System.out.println(clientSocket);


		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {

		DataOutputStream oos = null;
		try {
			oos = new DataOutputStream(clientSocket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		try {

			int count = 0;
			while (true) {

				if (clientSocket == null || clientSocket.isClosed()) {
					return;
				}

		
					Date d = new Date();
//					System.out.println(Tools.DateToString(d));
					
//					packet = ABCSubmitMsg.getCMPP_product_code(Config.product_code,Config.desmobile,""+Tools.DateToString(d)+Config.content,Config.longid);
//					oos.write(packet);
//					oos.flush();
					int m = 0;
//					String abc[] = Config.getDesmobile().split(",");
					int num=10000;
					for(int j = 0 ; j < 50000 ; j++){
						num++;
						for ( int i = 0 ; i < 5 ; i++ ) {//135034河南     135077广西		135010北京	135003重庆		183487河北																																
//							packet = ABCSubmitMsg.getCMPP_product_code_batch("9901DZ001","13401000123","尊敬银行账户，请进行确认，如果有错误信息，或影响到业务，取消请发送TD。","1069095599");
							packet = ABCSubmitMsg.getCMPP_product_code_batch("9901DZ301","183487"+num,"尊敬银行账户，请进行确认，如尊123错误信息拦截测试，或影响到业务，尊敬银行账户，请进行确认，如果有错误信息，或影响到业务,尊敬银行账户，请进行确认，如果有错误信息，或影1","1069095599");
							oos.write(packet);
							oos.flush();
//							
//							packet = ABCSubmitMsg.getCMPP_product_code_STK("8801AZ001","18510184331","WExKQQEBddHeQcNEJVpZP4WWAGBDfuBh+/8jVP9wzpqPn+J1ia+axUrs33RYKkWTDcCj5jrh4uWGZg8I6nVHEUe5E0QZf9P4EGdZtSG5awSadRUDVmoH+IzNVt+T0r/MOwIVgFpf7DuTzjhnFvvRJPYaFcQ=","1069095599");
//							oos.write(packet);
//							oos.flush();
//							
//							packet = ABCSubmitMsg.getCMPP_product_code_batch("9901DZ001","18910319243","尊敬的客户，您在我行开立多个银行账户，请进行确认，如果有错误信息，或影响到了您的使用，请于最近几日取消业务，取消请发送TD。","95599");
//							oos.write(packet);
//							oos.flush();
//							
//							packet = ABCSubmitMsg.getCMPP_product_code_batch("9901DZ001","18910319243","尊敬的客户，您在我行开立多个银行账户，请进行确认，如果有错误信息，或影响到了您的使用，请于最近几日取消业务，取消请发送TD。","95599");
//							oos.write(packet);
//							oos.flush();
							m = m+4;
							System.out.println("共发了 ： "+m+" ，条");;
						}
					}
					
					
					
					
//					Thread.sleep(200000);
//					packet = ABCSubmitMsg.getCMPP_product_code_batch("9901DZ001","15811514879","测试你好1测试你好2测试你好3测试你好4测试你好5测试你好6测试你好7测试你好8测试你好9测试你好0测试你好1测试你好－62","1069095599");
//					oos.write(packet);
//					oos.flush();
					
					Loger.mtlog.info("发送条数：" + SeqUtil.getClientCount());
				
				
				Thread.sleep(20000000);
//				System.exit(0);
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
	}
}

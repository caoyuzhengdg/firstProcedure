package net.guodu.test.thread;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ReadThreadHelper extends Thread {

	private Socket clientSocket;
	byte[] bytes = new byte[80];

	public ReadThreadHelper(Socket argsocket) {

		clientSocket = argsocket;
	}

	public void run() {
		try {
			InputStream in = clientSocket.getInputStream();

			while (in.read() != -1) {
				in.read(bytes);
				System.out.println(new String(bytes).toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

package net.guodu.test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class RecvThread extends Thread {
	private Socket socket;

	public RecvThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		int count = 0;

		while (true) {

			if (count >= 100) {
				try {
					sleep(3);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				count = 0;
			}
			count++;
			try {

				if (!socket.isClosed()) {
					InputStream is = socket.getInputStream();
					is.read();
				}

			} catch (IOException e) {
				// e.printStackTrace();
			}
		}
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
}

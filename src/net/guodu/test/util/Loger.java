package net.guodu.test.util;

import org.apache.log4j.Logger;

public class Loger {

	// �������Ļ
	public static final Logger console = Logger.getLogger(Loger.class);

	// ���������־
	public static final Logger mtlog = Logger.getLogger("mtlog");

	// ������л�����־
	public static final Logger log = Logger.getLogger("log");

	// ���������־
	public static final Logger deliverAll = Logger.getLogger("DeliverAllToABC");
	
	public static final Logger exception = Logger.getLogger("exception");

}

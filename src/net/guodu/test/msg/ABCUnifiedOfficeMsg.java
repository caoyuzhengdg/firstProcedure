package net.guodu.test.msg;

import java.nio.ByteBuffer;

import net.guodu.test.util.ProtocolUtil;

public class ABCUnifiedOfficeMsg {

	public static byte[] getSubmitPacket(String seq) {
		String content = seq + ":农行统一办公门户通道测试短信test123#$%^&^@!";
		// String content = "在人大附中实验楼， 设计技术教室里，学生们在老师指导下设计的科"
		// + "学小装置吸引了总书记的目光，他走上前去仔细察看。设计直升机降落高"
		// + "度差补偿装置的学生告诉总书记，自己的设计灵感是从看到抗震救灾时"
		// + "直升机在山区着陆困难后萌发的，使用这套装置可以解决直升机在斜坡上"
		// + "起降问题。设计波浪能发电装置的学生给总书记演示了装置的发电效果，"
		// + "介绍了自己的设计思路和技术原理。胡锦涛高兴地对在场的学生们说，"
		// + "通过这样的设计技术课，可以增强大家的创新意识和实践能力。";
		// String content = "农行95599联通通道测试!#@E#@ABC,收到请回复上行";

		int totalLen = 191 + content.getBytes().length;

		byte[] hands = makeHeader(totalLen, (short) 12);

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 60);
		String seqNum = "99M" + ProtocolUtil.getStringDate() + seq;

		System.out.println(seqNum);
		buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
		buf.put((byte) 0);
		buf.put(ProtocolUtil.stringToByteBuf("test67890", 20), 0, 20);
		buf.put((byte) 0);
		buf.put(ProtocolUtil.stringToByteBuf("test67890", 21), 0, 21);
		buf.put(ProtocolUtil.stringToByteBuf(" ", 17), 0, 17);
		buf.put(ProtocolUtil.stringToByteBuf(" ", 17), 0, 17);
		buf.put((byte) 1);
		buf.put(ProtocolUtil.stringToByteBuf("13699289946", 21), 0, 21);
		buf.putInt(content.getBytes().length);
		buf.put(ProtocolUtil
				.stringToByteBuf(content, content.getBytes().length), 0,
				content.getBytes().length);
		buf.put(ProtocolUtil.stringToByteBuf("baoliu", 8), 0, 8);
		return buf.array();

	}

	public static byte[] getSGIPSubmitPacket(String seq) {
		String content = "农行统一办公门户通道测试短信test123#$%^&^@![ABC]";
		// String content = "在人大附中实验楼， 设计技术教室里，学生们在老师指导下设计的科"
		// + "学小装置吸引了总书记的目光，他走上前去仔细察看。设计直升机降落高"
		// + "度差补偿装置的学生告诉总书记，自己的设计灵感是从看到抗震救灾时"
		// + "直升机在山区着陆困难后萌发的，使用这套装置可以解决直升机在斜坡上"
		// + "起降问题。设计波浪能发电装置的学生给总书记演示了装置的发电效果，"
		// + "介绍了自己的设计思路和技术原理。胡锦涛高兴地对在场的学生们说，"
		// + "通过这样的设计技术课，可以增强大家的创新意识和实践能力。";
		// String content = "";
		// String content = "农行95599联通通道测试!#@E#@ABC,收到请回复上行";
		int totalLen = 191 + content.getBytes().length;

		byte[] hands = makeHeader(totalLen, (short) 12);

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 60);
		String seqNum = "99M" + ProtocolUtil.getStringDate() + seq;

		System.out.println(seqNum);
		buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
		buf.put((byte) 0);
		buf.put(ProtocolUtil.stringToByteBuf("test67890", 20), 0, 20);
		buf.put((byte) 0);
		buf.put(ProtocolUtil.stringToByteBuf("test67890", 21), 0, 21);
		buf.put(ProtocolUtil.stringToByteBuf(" ", 17), 0, 17);
		buf.put(ProtocolUtil.stringToByteBuf(" ", 17), 0, 17);
		buf.put((byte) 1);
		buf.put(ProtocolUtil.stringToByteBuf("13126672489", 21), 0, 21);
		buf.putInt(content.getBytes().length);
		buf.put(ProtocolUtil
				.stringToByteBuf(content, content.getBytes().length), 0,
				content.getBytes().length);
		buf.put(ProtocolUtil.stringToByteBuf("baoliu", 8), 0, 8);
		return buf.array();

	}

	public static byte[] getTelcomSubmitPacket(String seq) {
		// String content = "农行统一办公门户通道测试短信test123#$%^&^@!";
		// String content = "在人大附中实验楼， 设计技术教室里，学生们在老师指导下设计的科"
		// + "学小装置吸引了总书记的目光，他走上前去仔细察看。设计直升机降落高"
		// + "度差补偿装置的学生告诉总书记，自己的设计灵感是从看到抗震救灾时"
		// + "直升机在山区着陆困难后萌发的，使用这套装置可以解决直升机在斜坡上"
		// + "起降问题。设计波浪能发电装置的学生给总书记演示了装置的发电效果，"
		// + "介绍了自己的设计思路和技术原理。胡锦涛高兴地对在场的学生们说，"
		// + "通过这样的设计技术课，可以增强大家的创新意识和实践能力。";
		// String content = "";
		String content = "农行95599联通通道测试!#@E#@ABC,收到请回复上行";
		int totalLen = 191 + content.getBytes().length;

		byte[] hands = makeHeader(totalLen, (short) 12);

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 60);
		String seqNum = "99M" + ProtocolUtil.getStringDate() + seq;

		System.out.println(seqNum);
		buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
		buf.put((byte) 0);
		buf.put(ProtocolUtil.stringToByteBuf("test67890", 20), 0, 20);
		buf.put((byte) 0);
		buf.put(ProtocolUtil.stringToByteBuf("test67890", 21), 0, 21);
		buf.put(ProtocolUtil.stringToByteBuf(" ", 17), 0, 17);
		buf.put(ProtocolUtil.stringToByteBuf(" ", 17), 0, 17);
		buf.put((byte) 1);
		buf.put(ProtocolUtil.stringToByteBuf("18941265931", 21), 0, 21);
		buf.putInt(content.getBytes().length);
		buf.put(ProtocolUtil
				.stringToByteBuf(content, content.getBytes().length), 0,
				content.getBytes().length);
		buf.put(ProtocolUtil.stringToByteBuf("baoliu", 8), 0, 8);
		return buf.array();

	}

	/**
	 * 将包头各字段数据打包
	 * 
	 * @param totalLength
	 *            包头与数据包的总长度
	 * @param commandId
	 *            命令字
	 * @return byte[] 返回数据包（包头）
	 */
	private static byte[] makeHeader(int totalLength, short commandId) {
		ByteBuffer buf = ByteBuffer.allocate(60);
		buf.put(ProtocolUtil.stringToByteBuf("39", 2));
		buf.put(ProtocolUtil.stringToByteBuf("11", 2));
		buf.put(ProtocolUtil.stringToByteBuf("1", 1));
		buf.put((byte) 0);

		buf.put(ProtocolUtil.stringToByteBuf("aa", 2));
		buf.putShort((short) totalLength);
		buf.put(ProtocolUtil.stringToByteBuf("cc", 2));
		buf.put(ProtocolUtil.stringToByteBuf("dd", 2));
		buf.put(ProtocolUtil.stringToByteBuf("2222", 4));
		buf.put(ProtocolUtil.stringToByteBuf("3333", 4));
		buf.put(ProtocolUtil.stringToByteBuf("4444", 4));
		buf.put(ProtocolUtil.stringToByteBuf("5555", 4));
		buf.put(ProtocolUtil.stringToByteBuf("ee", 2));
		buf.putShort(commandId);
		buf.put(ProtocolUtil.stringToByteBuf("ff", 2));
		buf.put(ProtocolUtil.stringToByteBuf("gg", 2));
		buf.put(ProtocolUtil.stringToByteBuf("h", 1));
		buf.put(ProtocolUtil.stringToByteBuf("i", 1));
		buf.put(ProtocolUtil.stringToByteBuf("jjjj", 4));
		buf.put(ProtocolUtil.stringToByteBuf("kk", 2));
		buf.put(ProtocolUtil.stringToByteBuf("llll", 14));

		return buf.array();
	}

}

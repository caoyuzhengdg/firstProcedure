package net.guodu.test.msg;

import java.nio.ByteBuffer;

import net.guodu.test.util.ProtocolUtil;

public class LongMsg {

	public static byte[] getSubmitLongPacket(String seq) {
		String content = "在人大附中实验楼， 设计技术教室里，学生们在老师指导下设计的科"
				+ "学小装置吸引了总书记的目光，他走上前去仔细察看。设计直升机降落高"
				+ "度差补偿装置的学生告诉总书记，自己的设计灵感是从看到抗震救灾时"
				+ "直升机在山区着陆困难后萌发的，使用这套装置可以解决直升机在斜坡上起降问题。";

		int totalLen = 191 + content.getBytes().length;

		byte[] hands = makeHeader(totalLen, (char) 0x0002);

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 60);
		String seqNum = "99M" + ProtocolUtil.getStringDate() + seq;

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
		
		System.out.println("long--" + seqNum + ", 13699289946 , " + content);
		return buf.array();

	}

	private static byte[] makeHeader(int totalLength, char commandId) {
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
		buf.putChar(commandId);
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

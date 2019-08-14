package net.guodu.test.socket.inner;

import java.nio.ByteBuffer;

import net.guodu.test.util.ProtocolUtil;
import net.guodu.test.util.SeqUtil;

/**
 * 批量文件请求消息包
 * 
 */
public class ABCInnerMsg {

	public static byte[] getMsgs(String phone, String content) {
		String seqNum = "99M" + ProtocolUtil.getStringDate()
				+ String.valueOf(SeqUtil.getSeq());

		int totalLen = 191 + content.getBytes().length;

		byte[] hands = makeHeader(totalLen, (char) 0x0002);

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 60);

		buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
		buf.put((byte) 0);
		buf.put(ProtocolUtil.stringToByteBuf("test67890", 20), 0, 20);
		buf.put((byte) 0);
		buf.put(ProtocolUtil.stringToByteBuf("test67890", 21), 0, 21);
		buf.put(ProtocolUtil.stringToByteBuf(" ", 17), 0, 17);
		buf.put(ProtocolUtil.stringToByteBuf(" ", 17), 0, 17);
		buf.put((byte) 1);
		buf.put(ProtocolUtil.stringToByteBuf(phone, 21), 0, 21);
		buf.putInt(content.getBytes().length);
		buf.put(ProtocolUtil
				.stringToByteBuf(content, content.getBytes().length), 0,
				content.getBytes().length);
		buf.put(ProtocolUtil.stringToByteBuf("baoliu", 8), 0, 8);
		System.out.println("seq=" + seqNum + "phone=" + phone + ",content="
				+ content);

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
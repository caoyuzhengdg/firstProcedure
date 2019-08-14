package net.guodu.test.msg;

import java.nio.ByteBuffer;

import net.guodu.test.util.ProtocolUtil;
import net.guodu.test.util.TypeConvert;

/**
 * 批量文件请求消息包
 * 
 */
public class ABCBatchMsg {
	private String spMsgID;
	private String fileName;
	private int msgNumber;
	private String msgType;

	
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
		buf.putChar( commandId);
		buf.put(ProtocolUtil.stringToByteBuf("ff", 2));
		buf.put(ProtocolUtil.stringToByteBuf("gg", 2));
		buf.put(ProtocolUtil.stringToByteBuf("h", 1));
		buf.put(ProtocolUtil.stringToByteBuf("i", 1));
		buf.put(ProtocolUtil.stringToByteBuf("jjjj", 4));
		buf.put(ProtocolUtil.stringToByteBuf("kk", 2));
		buf.put(ProtocolUtil.stringToByteBuf("llll", 14));

		return buf.array();
	}
	
	public static byte[] getBatchPacket() {

		byte[] hands = makeHeader(337, (char)0x0003);

//		SpMsgId	20	Octet String	消息ID
//		FileName	255	Octet String	要批处理的文件名
//		MsgNumber	4	Integer	文件包含的消息长度
//		MsgType	2（1）	Integer	0 表示每条信息不相同，1 表示每条信息相同（广告信息）
		
		ByteBuffer buf = ByteBuffer.allocate(337);
		
		buf.put(hands,0, 60);
		buf.put(ProtocolUtil.stringToByteBuf("99M20802100000307892", 20),0, 20);
		buf.put(ProtocolUtil.stringToByteBuf("BATCH_MT_100803121212.dat", 255), 0, 255);
		buf.put((byte)15); 
		buf.put((byte)1);
		return buf.array();

	}
	
	public static void main(String argsp[]){
		System.out.println(TypeConvert.byteArrayToHexString(getBatchPacket()));
	}
}
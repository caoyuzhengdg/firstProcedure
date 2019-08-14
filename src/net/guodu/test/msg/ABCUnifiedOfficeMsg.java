package net.guodu.test.msg;

import java.nio.ByteBuffer;

import net.guodu.test.util.ProtocolUtil;

public class ABCUnifiedOfficeMsg {

	public static byte[] getSubmitPacket(String seq) {
		String content = seq + ":ũ��ͳһ�칫�Ż�ͨ�����Զ���test123#$%^&^@!";
		// String content = "���˴���ʵ��¥�� ��Ƽ��������ѧ��������ʦָ������ƵĿ�"
		// + "ѧСװ������������ǵ�Ŀ�⣬������ǰȥ��ϸ�쿴�����ֱ���������"
		// + "�Ȳ��װ�õ�ѧ����������ǣ��Լ����������Ǵӿ����������ʱ"
		// + "ֱ������ɽ����½���Ѻ��ȷ��ģ�ʹ������װ�ÿ��Խ��ֱ������б����"
		// + "�����⡣��Ʋ����ܷ���װ�õ�ѧ�����������ʾ��װ�õķ���Ч����"
		// + "�������Լ������˼·�ͼ���ԭ�������θ��˵ض��ڳ���ѧ����˵��"
		// + "ͨ����������Ƽ����Σ�������ǿ��ҵĴ�����ʶ��ʵ��������";
		// String content = "ũ��95599��ͨͨ������!#@E#@ABC,�յ���ظ�����";

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
		String content = "ũ��ͳһ�칫�Ż�ͨ�����Զ���test123#$%^&^@![ABC]";
		// String content = "���˴���ʵ��¥�� ��Ƽ��������ѧ��������ʦָ������ƵĿ�"
		// + "ѧСװ������������ǵ�Ŀ�⣬������ǰȥ��ϸ�쿴�����ֱ���������"
		// + "�Ȳ��װ�õ�ѧ����������ǣ��Լ����������Ǵӿ����������ʱ"
		// + "ֱ������ɽ����½���Ѻ��ȷ��ģ�ʹ������װ�ÿ��Խ��ֱ������б����"
		// + "�����⡣��Ʋ����ܷ���װ�õ�ѧ�����������ʾ��װ�õķ���Ч����"
		// + "�������Լ������˼·�ͼ���ԭ�������θ��˵ض��ڳ���ѧ����˵��"
		// + "ͨ����������Ƽ����Σ�������ǿ��ҵĴ�����ʶ��ʵ��������";
		// String content = "";
		// String content = "ũ��95599��ͨͨ������!#@E#@ABC,�յ���ظ�����";
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
		// String content = "ũ��ͳһ�칫�Ż�ͨ�����Զ���test123#$%^&^@!";
		// String content = "���˴���ʵ��¥�� ��Ƽ��������ѧ��������ʦָ������ƵĿ�"
		// + "ѧСװ������������ǵ�Ŀ�⣬������ǰȥ��ϸ�쿴�����ֱ���������"
		// + "�Ȳ��װ�õ�ѧ����������ǣ��Լ����������Ǵӿ����������ʱ"
		// + "ֱ������ɽ����½���Ѻ��ȷ��ģ�ʹ������װ�ÿ��Խ��ֱ������б����"
		// + "�����⡣��Ʋ����ܷ���װ�õ�ѧ�����������ʾ��װ�õķ���Ч����"
		// + "�������Լ������˼·�ͼ���ԭ�������θ��˵ض��ڳ���ѧ����˵��"
		// + "ͨ����������Ƽ����Σ�������ǿ��ҵĴ�����ʶ��ʵ��������";
		// String content = "";
		String content = "ũ��95599��ͨͨ������!#@E#@ABC,�յ���ظ�����";
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
	 * ����ͷ���ֶ����ݴ��
	 * 
	 * @param totalLength
	 *            ��ͷ�����ݰ����ܳ���
	 * @param commandId
	 *            ������
	 * @return byte[] �������ݰ�����ͷ��
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

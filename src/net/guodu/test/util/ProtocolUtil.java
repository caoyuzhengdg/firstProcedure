package net.guodu.test.util;

import java.io.DataOutput;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ProtocolUtil {
	public static final char SUBMIT = 0x0002;
	public static final char SUBMIT_RESP = 0x8002;
	public static final char DELIVER = 0x0001;
	public static final char DELIVER_RESP = 0x8001;
	public static final char BATCH = 0x0003;
	public static final char BATCH_RESP = 0x8003;
	public static final char ACTIVE_TEST = 0x0004;
	public static final char ACTIVE_TEST_RESP = 0x8004;
	public static final char ACCOUNT_CHECK = 0x0005;
	public static final char ACCOUNT_CHECK_RESP = 0x8005;
	public static final char MSG_DETAIL_CHECK = 0x0006;
	public static final char MSG_DETAIL_CHECK_RESP = 0x8006;
	public static final char AFFIRM = 0x0007;
	public static final char AFFIRM_RESP = 0x8007;
	// ����ΪSTK��������
	public static final char STK_SUBMIT = 0x0008;
	public static final char STK_SUBMIT_RESP = 0x8008;
	public static final char STK_DELIVER = 0x0009;
	public static final char STK_DELIVER_RESP = 0x8009;

	/**
	 * Edit By Baoshuang 2008-07-09
	 */

	public static final char NYHL_SUBMIT = 0x000A;
	public static final char NYHL_SUBMIT_RESP = 0x800A;
	/** **************Edit End********************** */

	public static final int PROCESS_MODE_ACCOUNT = 1;
	public static final int PROCESS_MODE_MSG_DETAIL = 2;
	public static final int PROCESS_AFFIRM = 3;

	public static byte[] stringToByteBuf(String str, int maxLen) {
		byte[] bTemp = new byte[maxLen];
		byte[] bytes = null;
		try {
			bytes = str.getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int len = bytes.length;

		if (len > maxLen) {
			//BytesCopy(bytes, bTemp, 0, maxLen - 1, 0);
			BytesCopy_20(bytes, bTemp, 0, maxLen - 1, 0);
		} else {
			//BytesCopy(bytes, bTemp, 0, len - 1, 0);
			BytesCopy_20(bytes, bTemp, 0, len - 1, 0);
		}
		return bTemp;
	}
	//20130129 pq add ��λ�����ܴ������ո�(�ո��ASCII��Ϊ0x20)
	public static void BytesCopy_20(byte source[], byte dest[], int sourcebegin,
			int sourceend, int destbegin) {
		int maxLen = dest.length;
		int j = 0;
		for (int i = sourcebegin; i < maxLen; i++) {
			if (i <= sourceend){
				dest[destbegin + j] = source[i];
			}else{
				dest[destbegin + j] = 0x20;
			}
			j++;
		}
	}
	public static void main(String[] args) {
		ByteBuffer buf = ByteBuffer.allocate(20);
		//buf.put(Common.stringToByteBuf("186102620661234567890", 20));
		buf.put(ProtocolUtil.stringToByteBuf("1860000000", 20));
		//buf.put(Common.stringToByteBuf("���Ų���test", 20));
		System.out.println(TypeConvert.byteArrayToHexString(buf.array()));
//		byte b = (byte)0;
//		System.out.println(TypeConvert.byteToHexString(b));
//		System.out.println(TypeConvert.byteArrayToHexString("0".getBytes()));
	}


	public static synchronized String getStringDate() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());

	}

	public static void BytesCopy(byte source[], byte dest[], int sourcebegin,
			int sourceend, int destbegin) {
		int j = 0;
		for (int i = sourcebegin; i <= sourceend; i++) {
			dest[destbegin + j] = source[i];
			j++;
		}
	}

	public static String getStrFromByteBuf(ByteBuffer buf, int maxLen) {
		byte[] bTemp = new byte[maxLen];
		buf.get(bTemp, 0, maxLen);

		int len = 0;
		for (int i = 0; i < maxLen; i++) {
			if (bTemp[i] == 0x00) {
				break;
			}
			len++;
		}
		return new String(bTemp, 0, len);
	}

	public static byte[] getByteFromByteBuf(ByteBuffer buf, int maxLen) {
		byte[] bTemp = new byte[maxLen];
		buf.get(bTemp, 0, maxLen);
		return bTemp;
	}

	public static int byteToInt(byte b) {
		return b;
	}

	public static byte intToByte(int i) {
		return (byte) i;
	}

	public static int bytesToInt(byte bytes[]) {
		return (0xff & bytes[0]) << 24 | (0xff & bytes[1]) << 16
				| (0xff & bytes[2]) << 8 | bytes[3];
	}

	public static byte[] intToBytes(int i) {
		byte bytes[] = new byte[2];
		bytes[1] = (byte) (0xff & i);
		bytes[0] = (byte) ((0xff00 & i) >> 8);
		return bytes;
	}

	public static byte[] intToBytes4(int i) {
		byte bytes[] = new byte[4];
		bytes[3] = (byte) (0xff & i);
		bytes[2] = (byte) ((0xff00 & i) >> 8);
		bytes[1] = (byte) ((0xff0000 & i) >> 16);
		bytes[0] = (byte) ((0xff000000 & i) >> 24);
		return bytes;
	}

	public static byte[] longToBytes8(long l) {
		byte bytes[] = new byte[8];
		bytes[7] = (byte) (int) ((long) 255 & l);
		bytes[6] = (byte) (int) (((long) 65280 & l) >> 8);
		bytes[5] = (byte) (int) (((long) 0xff0000 & l) >> 16);
		bytes[4] = (byte) (int) (((long) 0xff000000 & l) >> 24);
		int high = (int) (l >> 32);
		bytes[3] = (byte) (0xff & high);
		bytes[2] = (byte) ((0xff00 & high) >> 8);
		bytes[1] = (byte) ((0xff0000 & high) >> 16);
		bytes[0] = (byte) ((0xff000000 & high) >> 24);
		return bytes;
	}

	public static void intToBytes(int i, byte bytes[]) {
		bytes[1] = (byte) (0xff & i);
		bytes[0] = (byte) ((0xff00 & i) >> 8);
	}

	public static void IntToBytes4(int i, byte bytes[]) {
		bytes[3] = (byte) (0xff & i);
		bytes[2] = (byte) ((0xff00 & i) >> 8);
		bytes[1] = (byte) ((0xff0000 & i) >> 16);
		bytes[0] = (byte) ((0xff000000 & i) >> 24);
	}

	public static int Bytes4ToInt(byte bytes[]) {
		return (0xff & bytes[0]) << 24 | (0xff & bytes[1]) << 16
				| (0xff & bytes[2]) << 8 | 0xff & bytes[3];

	}

	public static long Bytes8ToLong(byte bytes[]) {
		return (0xff & bytes[0]) << 56 | (0xff & bytes[1]) << 48
				| (0xff & bytes[2]) << 40 | (0xff & bytes[3]) << 32
				| (0xff & bytes[4]) << 24 | (0xff & bytes[5]) << 16
				| (0xff & bytes[6]) << 8 | 0xff & bytes[7];
	}

	public static void setFieldData(DataOutput dos, String value, int len) {
		value = leftFillSpace(value, len);
		byte[] bytes = stringToByteBuf(value, len);
		try {
			dos.write(bytes);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	/**
	 * �����Ȳ�������ݽ����󲹿ո�
	 * 
	 * @param len
	 *            ������󳤶�
	 * @param value
	 *            �账�������
	 * @return ���
	 */
	public static String leftFillSpace(long value, int len) {
		String result = String.valueOf(value);
		while (result.length() < len) {
			result = " " + result;
		}
		return result;
	}

	public static String leftFillSpace(String value, int len) {
		String result = value;

		while (result.length() < len) {
			result = " " + result;
		}

		return result;
	}

	/**
	 * ��16���Ƶ��ִ�ת���ɶ�Ӧ�Ķ�����������
	 * 
	 * @param vStr
	 *            String ԭʼ�ַ���
	 * @param MaxLen
	 *            int ת�����ֽ���������󳤶�
	 * @return byte[] ת���Ժ�Ķ�����������
	 */
	public static byte[] hexStrToBytesBuf(String vStr, int MaxLen) {
		byte[] btemp = new byte[MaxLen];
		vStr = vStr.trim();
		int strlen = vStr.length();
		int j = strlen / 2;
		if (j >= MaxLen) {
			strlen = MaxLen * 2;
		} else {
			strlen = j * 2;
		}
		ByteBuffer buf = ByteBuffer.allocate(MaxLen);
		char[] c = vStr.toCharArray();
		byte bb;
		String s = null;
		for (int i = 0; i < strlen; i += 2) {
			s = new String(c, i, 2);
			try {
				bb = (byte) (Integer.parseInt(s, 16) & 0xFFFFFFFF);
				buf.put(bb);
			} catch (NumberFormatException ex) {
				throw new NumberFormatException(ex.toString());
			}

		}
		btemp = buf.array();
		return btemp;
	}

}

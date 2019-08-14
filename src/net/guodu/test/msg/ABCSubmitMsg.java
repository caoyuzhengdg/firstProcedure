package net.guodu.test.msg;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import net.guodu.test.util.Loger;
import net.guodu.test.util.ProtocolUtil;
import net.guodu.test.util.SeqUtil;

public class ABCSubmitMsg {

	public static byte[] makeHeader(int totalLength, char commandId) {
		ByteBuffer buf = ByteBuffer.allocate(32);
        
        //buf.putInt(totalLength);
		buf.put(ProtocolUtil.stringToByteBuf(String.valueOf(totalLength), 6));
        buf.put(ProtocolUtil.stringToByteBuf("01", 2));
        buf.put(ProtocolUtil.stringToByteBuf("00", 2));
        buf.put(ProtocolUtil.stringToByteBuf("11", 2));
        buf.put(ProtocolUtil.stringToByteBuf("aaaa", 4));
        buf.put(ProtocolUtil.stringToByteBuf("bbbb", 4));
        buf.put(ProtocolUtil.stringToByteBuf("llll", 12));

		return buf.array();
	}
	
	public static byte[] makeHeader_batch(int totalLength, char commandId) {
		ByteBuffer buf = ByteBuffer.allocate(32);
        
        //buf.putInt(totalLength);
		buf.put(ProtocolUtil.stringToByteBuf(String.valueOf(totalLength), 6));
        buf.put(ProtocolUtil.stringToByteBuf("01", 2));
        buf.put(ProtocolUtil.stringToByteBuf("00", 2));
        buf.put(ProtocolUtil.stringToByteBuf("12", 2));
        buf.put(ProtocolUtil.stringToByteBuf("aaaa", 4));
        buf.put(ProtocolUtil.stringToByteBuf("bbbb", 4));
        buf.put(ProtocolUtil.stringToByteBuf("llll", 12));

		return buf.array();
	}
	/**
	 * wangyajing add STK������
	 * @param totalLength
	 * @param commandId
	 * @return
	 */
	public static byte[] makeHeaderSTK(int totalLength, char commandId) {
		ByteBuffer buf = ByteBuffer.allocate(32);
        
        //buf.putInt(totalLength);
		buf.put(ProtocolUtil.stringToByteBuf(String.valueOf(totalLength), 6));
        buf.put(ProtocolUtil.stringToByteBuf("01", 2));
        buf.put(ProtocolUtil.stringToByteBuf("00", 2));
        buf.put(ProtocolUtil.stringToByteBuf("30", 2));
        buf.put(ProtocolUtil.stringToByteBuf("aaaa", 4));
        buf.put(ProtocolUtil.stringToByteBuf("bbbb", 4));
        buf.put(ProtocolUtil.stringToByteBuf("llll", 12));

		return buf.array();
	}
	//����
	public static byte[] makeHeader2(int totalLength, char commandId) {
		ByteBuffer buf = ByteBuffer.allocate(32);
        
        //buf.putInt(totalLength);
		buf.put(ProtocolUtil.stringToByteBuf(String.valueOf(totalLength), 6));
        buf.put(ProtocolUtil.stringToByteBuf("10", 2));
        buf.put(ProtocolUtil.stringToByteBuf("00", 2));
        buf.put(ProtocolUtil.stringToByteBuf("12", 2));
        buf.put(ProtocolUtil.stringToByteBuf("aaaa", 4));
        buf.put(ProtocolUtil.stringToByteBuf("bbbb", 4));
        buf.put(ProtocolUtil.stringToByteBuf("llll", 12));

		return buf.array();
	}
	public static byte[] makeHeader3(int totalLength, char commandId) {
		ByteBuffer buf = ByteBuffer.allocate(32);
        
        //buf.putInt(totalLength);
		buf.put(ProtocolUtil.stringToByteBuf(String.valueOf(totalLength), 6));
        buf.put(ProtocolUtil.stringToByteBuf("01", 2));
        buf.put(ProtocolUtil.stringToByteBuf("00", 2));
        buf.put(ProtocolUtil.stringToByteBuf("99", 2));
        buf.put(ProtocolUtil.stringToByteBuf("aaaa", 4));
        buf.put(ProtocolUtil.stringToByteBuf("bbbb", 4));
        buf.put(ProtocolUtil.stringToByteBuf("llll", 12));

		return buf.array();
	}
	
	public static byte[] makeHeader4(int totalLength,String type) {
		ByteBuffer buf = ByteBuffer.allocate(32);
        
        //buf.putInt(totalLength);
		buf.put(ProtocolUtil.stringToByteBuf(String.valueOf(totalLength), 6));
        buf.put(ProtocolUtil.stringToByteBuf("01", 2));
        buf.put(ProtocolUtil.stringToByteBuf("00", 2));
        buf.put(ProtocolUtil.stringToByteBuf(type, 2));//21����ͨ��23��ģ�����
        buf.put(ProtocolUtil.stringToByteBuf("aaaa", 4));
        buf.put(ProtocolUtil.stringToByteBuf("bbbb", 4));
        buf.put(ProtocolUtil.stringToByteBuf("llll", 12));

		return buf.array();
	}
	public static byte[] makeHeader5(int totalLength,String type) {
		ByteBuffer buf = ByteBuffer.allocate(32);
        
        //buf.putInt(totalLength);
		buf.put(ProtocolUtil.stringToByteBuf(String.valueOf(totalLength), 6));
        buf.put(ProtocolUtil.stringToByteBuf("01", 2));
        buf.put(ProtocolUtil.stringToByteBuf("00", 2));
        buf.put(ProtocolUtil.stringToByteBuf(type, 2));
        buf.put(ProtocolUtil.stringToByteBuf("aaaa", 4));
        buf.put(ProtocolUtil.stringToByteBuf("bbbb", 4));
        buf.put(ProtocolUtil.stringToByteBuf("llll", 12));

		return buf.array();
	}
	public static byte[] makeHeader6(int totalLength) {
		ByteBuffer buf = ByteBuffer.allocate(34);
        
        //buf.putInt(totalLength);
		buf.put(ProtocolUtil.stringToByteBuf(String.valueOf(totalLength), 6));
        buf.put(ProtocolUtil.stringToByteBuf("01", 2));
        buf.put(ProtocolUtil.stringToByteBuf("00", 2));
        buf.put(ProtocolUtil.stringToByteBuf("23", 2));
        buf.put(ProtocolUtil.stringToByteBuf("aaaa", 4));
        buf.put(ProtocolUtil.stringToByteBuf("bbbb", 4));
        buf.put(ProtocolUtil.stringToByteBuf("llll", 14));

		return buf.array();
	}

	public static byte[] getBatchPacket(String seq) {

		int totalLen = 340;
		byte[] hands = makeHeader(totalLen, (char) 0x0003);
		ByteBuffer buf = ByteBuffer.allocate(totalLen);
		buf.put(hands, 0, 60);

		String seqNum = "M" + ProtocolUtil.getStringDate() + seq;
		buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
		buf.put(ProtocolUtil.stringToByteBuf("DZTZ_KFSB_201007_31430", 255), 0,
				255);
		buf.putInt(100);
		buf.put(ProtocolUtil.stringToByteBuf("0", 1), 0, 1);

		return buf.array();
	}
	public static byte[] getLongTest() {
		int totalLen = 32 ;
		System.out.println(totalLen);
		byte[] hands = makeHeader3(totalLen-6, (char)0);

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 32);

		System.out.println(buf.array());
		return buf.array();

	}
	
	public static byte[] getMMS(String phone,String ID,String content ,String type) {
		//String content = "����";
		int totalLen = 147 + content.getBytes().length;

		byte[] hands = makeHeader4(totalLen-6,type);
		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 32);
		buf.put(ProtocolUtil.stringToByteBuf(ID, 20), 0, 20);//����ID
		buf.put(ProtocolUtil.stringToByteBuf("201211160958", 14), 0, 14);//���Ž���ʱ�䣨��ʽ��yyyymmddhhmms������20010301200000��
		buf.put(ProtocolUtil.stringToByteBuf("1069095599", 21), 0, 21);//���ŷ����û�����
		buf.put(ProtocolUtil.stringToByteBuf("11111", 9), 0, 9);//��Ʒ����

		buf.put(ProtocolUtil.stringToByteBuf("1", 4), 0, 4);
		//buf.putInt(1);//��ͬ�����ֻ��Ÿ���
		String seqNum = "M" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
			buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);//����Ϣ��ˮ����ũ������Ψһ��־��
			buf.put(ProtocolUtil.stringToByteBuf(phone, 21), 0, 21);//���Ž����û�����
		
		buf.put(ProtocolUtil.stringToByteBuf(content.getBytes().length+"", 6), 0, 6);//�����ı����ݳ���
		//buf.putInt(content.getBytes().length);//�����ı����ݳ���
		buf.put(ProtocolUtil.stringToByteBuf(content, content.getBytes().length), 0,
		content.getBytes().length);//�����ı�����
		
		System.out.println("�������Ų���--" + seqNum + ", "+phone+" , " + content);
		return buf.array();
	}
	
	public static byte[] getMMSBatch(String ID,String content,String type) {
		//String content = "";
		int totalLen = 229 + content.getBytes().length;

		byte[] hands = makeHeader5(totalLen-6,type);
		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 32);

		buf.put(ProtocolUtil.stringToByteBuf(ID, 20), 0, 20);//����ID
		buf.put(ProtocolUtil.stringToByteBuf("201211160958", 14), 0, 14);//���Ž���ʱ�䣨��ʽ��yyyymmddhhmms������20010301200000��
		buf.put(ProtocolUtil.stringToByteBuf("1069095599", 21), 0, 21);//���ŷ����û�����
		buf.put(ProtocolUtil.stringToByteBuf("11111", 9), 0, 9);//��Ʒ����

		buf.put(ProtocolUtil.stringToByteBuf("3", 4), 0, 4);//��Ʒ����
		//buf.putInt(10);//��ͬ�����ֻ��Ÿ���
		String seqNum = "";
		for(int i=0;i<3;i++){
			seqNum = "m" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
			//15811514879 18910229623
			buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
			if(i%3 == 1){
				buf.put(ProtocolUtil.stringToByteBuf("18910319243", 21), 0, 21);
			}else if(i%3 == 2){
				buf.put(ProtocolUtil.stringToByteBuf("18610262066", 21), 0, 21);
			}else{
				buf.put(ProtocolUtil.stringToByteBuf("13716491460", 21), 0, 21);
			}
			System.out.println("�������ŵ�������--" + seqNum + " , " + content);
		}
		buf.put(ProtocolUtil.stringToByteBuf(content.getBytes().length+"", 6), 0, 6);//�����ı����ݳ���
		buf.put(ProtocolUtil.stringToByteBuf(content, content.getBytes().length), 0,
		content.getBytes().length);//�����ı�����
		
		
		return buf.array();
	}
	public static byte[] getMMSD() {
		String content = "����|����|����";
		int totalLen = 145 + content.getBytes().length;

		byte[] hands = makeHeader6(totalLen);
		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 32);

		buf.put(ProtocolUtil.stringToByteBuf("T2012092120424625670", 20), 0, 20);//����ID
		buf.put(ProtocolUtil.stringToByteBuf("201211160958", 14), 0, 14);//���Ž���ʱ�䣨��ʽ��yyyymmddhhmms������20010301200000��
		buf.put(ProtocolUtil.stringToByteBuf("1069095599", 21), 0, 21);//���ŷ����û�����
		buf.put(ProtocolUtil.stringToByteBuf("11111", 9), 0, 9);//��Ʒ����

		buf.putInt(1);//��ͬ�����ֻ��Ÿ���
		String seqNum = "D" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
			buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);//����Ϣ��ˮ����ũ������Ψһ��־��
			buf.put(ProtocolUtil.stringToByteBuf("18900000000", 21), 0, 21);//���Ž����û�����
		
		buf.putInt(content.getBytes().length);//�����ı����ݳ���
		buf.put(ProtocolUtil.stringToByteBuf(content, content.getBytes().length), 0,
		content.getBytes().length);//�����ı�����
		
		System.out.println("MMSD--" + seqNum + ", 18900000000 , " + content);
		return buf.array();
	}
	public static byte[] getCMPP_w() {
		String content = "CMPPũ�з���˲���" ;
		//String seqNum = "M" + ProtocolUtil.getStringDate();

		int totalLen = 128 -3 -10 + content.getBytes().length;//��Ʒ������12λ��Ϊ9λ ���ʼ�3
		//System.out.println(content);

		System.out.println(totalLen);
		byte[] hands = makeHeader(totalLen, (char)0);

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 32);

		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 14), 0, 14);
		buf.put(ProtocolUtil.stringToByteBuf("544332", 21), 0, 21);
		//buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 12), 0, 12);
		//buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 12), 0, 12);
		//buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 12), 0, 12);
		buf.put(ProtocolUtil.stringToByteBuf("201205081", 9), 0, 9);
		buf.putInt(1);
		//buf.put(ProtocolUtil.stringToByteBuf("2", 4), 0, 4);
		String seqNum = "A" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
			buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
			buf.put(ProtocolUtil.stringToByteBuf("1861026", 11), 0, 11);
		
		buf.putInt(content.getBytes().length);
		buf.put(ProtocolUtil.stringToByteBuf(content, content.getBytes().length), 0,
		content.getBytes().length);
		
		System.out.println("CMPP--" + seqNum + ", 1861026 , " + content);
		return buf.array();

	}
	public static byte[] getCMPP_product_code(String product_code,String phone,String c,String longid) {
		String seqNum = "A" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
		String content_old = c;//+seqNum ;
		String content = null;
		try {
			byte[] temp=content_old.getBytes("utf-8");//这里写原编码方式
            byte[] newtemp=new String(temp,"utf-8").getBytes("gbk");//这里写转换后的编码方式
            content=new String(newtemp,"gbk");//这里写转换后的编码方式
            
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int totalLen = 0;
		try {
			totalLen = 127  + content.getBytes("gbk").length;
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 

		System.out.println(totalLen);
		byte[] hands = makeHeader(totalLen - 6, (char)0); 

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 32);

		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 14), 0, 14);
		buf.put(ProtocolUtil.stringToByteBuf(longid, 21), 0, 21);
//		2013.4.28 pangqian add  9901DZ301�������� 9901DZ006�����۷�
		buf.put(ProtocolUtil.stringToByteBuf(product_code, 9), 0, 9);
		buf.put(ProtocolUtil.stringToByteBuf("1", 4), 0, 4);
		buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
		buf.put(ProtocolUtil.stringToByteBuf(phone, 21), 0, 21);//15383348665
		
		//buf.putInt(content.getBytes().length);
		try {
			buf.put(ProtocolUtil.stringToByteBuf(String.valueOf(content.getBytes("gbk").length), 6));
			buf.put(ProtocolUtil.stringToByteBuf(content, content.getBytes("gbk").length), 0,
			content.getBytes("gbk").length);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			byte[] temp=content.getBytes("gbk");//这里写原编码方式
            byte[] newtemp=new String(temp,"gbk").getBytes("utf-8");//这里写转换后的编码方式
            content=new String(newtemp,"utf-8");//这里写转换后的编码方式
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println("发送短信：--" + seqNum + ", "+phone+" , " + content + ", "+longid);
		Loger.mtlog.info("发送短信：--" + seqNum + ", "+phone+" , " + content + ", "+longid);
		return buf.array();

	}
	
	public static byte[] getCMPP_product_code_batch(String product_code,String phone,String c,String longid) {
		String seqNum = "A" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
		String content_old = c;//+seqNum ;
		String content = null;
		try {
			byte[] temp=content_old.getBytes("utf-8");//这里写原编码方式
            byte[] newtemp=new String(temp,"utf-8").getBytes("gbk");//这里写转换后的编码方式
            content=new String(newtemp,"gbk");//这里写转换后的编码方式
            
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int totalLen = 0;
		try {
			totalLen = 127  + content.getBytes("gbk").length;
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 

		System.out.println(totalLen);
		byte[] hands = makeHeader_batch(totalLen - 6, (char)0); 

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 32);

		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 14), 0, 14);
		buf.put(ProtocolUtil.stringToByteBuf(longid, 21), 0, 21);
		buf.put(ProtocolUtil.stringToByteBuf(product_code, 9), 0, 9);
		buf.put(ProtocolUtil.stringToByteBuf("1", 4), 0, 4);
		buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
		buf.put(ProtocolUtil.stringToByteBuf(phone, 21), 0, 21);//15383348665
		
		//buf.putInt(content.getBytes().length);
		try {
			buf.put(ProtocolUtil.stringToByteBuf(String.valueOf(content.getBytes("gbk").length), 6));
			buf.put(ProtocolUtil.stringToByteBuf(content, content.getBytes("gbk").length), 0,
			content.getBytes("gbk").length);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			byte[] temp=content.getBytes("gbk");//这里写原编码方式
            byte[] newtemp=new String(temp,"gbk").getBytes("utf-8");//这里写转换后的编码方式
            content=new String(newtemp,"utf-8");//这里写转换后的编码方式
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println("发送短信：--" + seqNum + ", "+phone+" , " + content + ", "+longid);
		Loger.mtlog.info("发送短信：--" + seqNum + ", "+phone+" , " + content + ", "+longid);
		Loger.mtlog.info("发送短信二进制：--" + TypeConvert.byteArrayToHexString(buf.array()));
		
		TypeConvert.byteArrayToHexString(buf.array());
		return buf.array();

	}
	
	public static byte[] getCMPP_product_code_STK(String product_code,String phone,String c,String longid) {
		String seqNum = "A" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
		String content = c;//+seqNum ;

		int totalLen = 127  + content.getBytes().length;//��Ʒ������12λ��Ϊ9λ ���ʼ�3,���ĳ�����4��Ϊ6���ʼ�2��

		System.out.println(totalLen);
		
//		STK������
		byte[] hands = makeHeaderSTK(totalLen - 6, (char)0);//���ĳ��ȣ�����ͷ+������-6 �ʼ�6

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 32);

		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 14), 0, 14);
		buf.put(ProtocolUtil.stringToByteBuf(longid, 21), 0, 21);
//		2013.4.28 pangqian add  9901DZ301�������� 9901DZ006�����۷�
		buf.put(ProtocolUtil.stringToByteBuf(product_code, 9), 0, 9);
		buf.put(ProtocolUtil.stringToByteBuf("1", 4), 0, 4);
		buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
		buf.put(ProtocolUtil.stringToByteBuf(phone, 21), 0, 21);//15383348665
		
		//buf.putInt(content.getBytes().length);
		buf.put(ProtocolUtil.stringToByteBuf(String.valueOf(content.getBytes().length), 6));
		buf.put(ProtocolUtil.stringToByteBuf(content, content.getBytes().length), 0,
		content.getBytes().length);
		
		System.out.println("�������Ų���--" + seqNum + ", "+phone+" , " + content);
		return buf.array();

	}
	public static byte[] getCMPP_product_code_batch(String product_code,String phone,String phone1,String phone2,String c,String longid) {
		String seqNum = "A" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
		String content = c;//+seqNum ;

		int totalLen = 127  + 82 + content.getBytes().length;//��Ʒ������12λ��Ϊ9λ ���ʼ�3,���ĳ�����4��Ϊ6���ʼ�2��

		System.out.println(totalLen);
		byte[] hands = makeHeader2(totalLen - 6, (char)0);//���ĳ��ȣ�����ͷ+������-6 �ʼ�6

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 32);

		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 14), 0, 14);
		buf.put(ProtocolUtil.stringToByteBuf(longid, 21), 0, 21);
//		2013.4.28 pangqian add  9901DZ301�������� 9901DZ006�����۷�
		buf.put(ProtocolUtil.stringToByteBuf(product_code, 9), 0, 9);
		buf.put(ProtocolUtil.stringToByteBuf("3", 4), 0, 4);
//		buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
//		buf.put(ProtocolUtil.stringToByteBuf(phone, 21), 0, 21);//15383348665
		
		for(int i=0;i<3;i++){
			//15811439243,13699289946,13716491460,13241265931,18610262066,15383348665
			seqNum = "B" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
			buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
			if(i%3 == 1){
				buf.put(ProtocolUtil.stringToByteBuf(phone, 21), 0, 21);
			}else if(i%3 == 2){
				buf.put(ProtocolUtil.stringToByteBuf(phone1, 21), 0, 21);
			}else{
				buf.put(ProtocolUtil.stringToByteBuf(phone2, 21), 0, 21);
			}
			System.out.println("������������--" + seqNum + ", " + content);
		}
		
		//buf.putInt(content.getBytes().length);
		buf.put(ProtocolUtil.stringToByteBuf(String.valueOf(content.getBytes().length), 6));
		buf.put(ProtocolUtil.stringToByteBuf(content, content.getBytes().length), 0,
		content.getBytes().length);
		
		System.out.println("�������Ų���--" + seqNum + ", "+phone+" , " + content);
		return buf.array();

	}
	
	public static byte[] getCMPP(String phone,String c,String longid) {
		String seqNum = "A" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
		String content = c;//+seqNum ;

		int totalLen = 127  + content.getBytes().length;//��Ʒ������12λ��Ϊ9λ ���ʼ�3,���ĳ�����4��Ϊ6���ʼ�2��

		System.out.println(totalLen);
		byte[] hands = makeHeader(totalLen - 6, (char)0);//���ĳ��ȣ�����ͷ+������-6 �ʼ�6

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 32);

		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 14), 0, 14);
		buf.put(ProtocolUtil.stringToByteBuf(longid, 21), 0, 21);
//		2013.4.28 pangqian add  9901DZ301�������� 9901DZ006�����۷�
		buf.put(ProtocolUtil.stringToByteBuf("201205081", 9), 0, 9);
		buf.put(ProtocolUtil.stringToByteBuf("1", 4), 0, 4);
			buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
			buf.put(ProtocolUtil.stringToByteBuf(phone, 21), 0, 21);//15383348665
		
		//buf.putInt(content.getBytes().length);
		buf.put(ProtocolUtil.stringToByteBuf(String.valueOf(content.getBytes().length), 6));
		buf.put(ProtocolUtil.stringToByteBuf(content, content.getBytes().length), 0,
		content.getBytes().length);
		
		System.out.println("�������Ų���--" + seqNum + ", "+phone+" , " + content);
		return buf.array();

	}
	
	public static byte[] getCMPP_2(String content) {
		String seq= "A" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
//		int totalLen = 32+54+123 + content.getBytes().length;//��Ʒ������12λ��Ϊ9λ ���ʼ�3
		int totalLen = 127  + content.getBytes().length;//��Ʒ������12λ��Ϊ9λ ���ʼ�3,���ĳ�����4��Ϊ6���ʼ�2��
		System.out.println(content);
		
		System.out.println(totalLen);
		byte[] hands = makeHeader2(totalLen -6, (char)0);

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 32);

		buf.put(ProtocolUtil.stringToByteBuf("aaa21207", 14), 0, 14);
		buf.put(ProtocolUtil.stringToByteBuf("95599", 21), 0, 21);
		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 9), 0, 9);
		buf.put(ProtocolUtil.stringToByteBuf("3", 4), 0, 4);
		String seqNum = "";
		for(int i=0;i<3;i++){
			//15811439243,13699289946,13716491460,13241265931,18610262066,15383348665
			seqNum = "B" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
			buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
			if(i%3 == 1){
				buf.put(ProtocolUtil.stringToByteBuf("18910319243", 21), 0, 21);
			}else if(i%3 == 2){
				buf.put(ProtocolUtil.stringToByteBuf("13716491460", 21), 0, 21);
			}else{
				buf.put(ProtocolUtil.stringToByteBuf("18910319243", 21), 0, 21);
			}
			System.out.println("������������--" + seqNum + ", " + content);
		}
		//buf.putInt(content.getBytes().length);
		buf.put(ProtocolUtil.stringToByteBuf(String.valueOf(content.getBytes().length), 6));
		buf.put(ProtocolUtil.stringToByteBuf(content, content.getBytes().length), 0,
		content.getBytes().length);
		

		return buf.array();

	}
	public static byte[] getCMPP_3(String content) {
		String seq= "A" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
//		int totalLen = 32+54+123 + content.getBytes().length;//��Ʒ������12λ��Ϊ9λ ���ʼ�3
		int totalLen = 127  + content.getBytes().length;//��Ʒ������12λ��Ϊ9λ ���ʼ�3,���ĳ�����4��Ϊ6���ʼ�2��
		System.out.println(content);
		
		System.out.println(totalLen);
		byte[] hands = makeHeader2(totalLen -6, (char)0);

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 32);

		buf.put(ProtocolUtil.stringToByteBuf("aaa21207", 14), 0, 14);
		buf.put(ProtocolUtil.stringToByteBuf("1069095599", 21), 0, 21);
		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 9), 0, 9);
		buf.put(ProtocolUtil.stringToByteBuf("3", 4), 0, 4);
		String seqNum = "";
		for(int i=0;i<3;i++){
			//15811439243,13699289946,13716491460,13241265931,18610262066,15383348665
			seqNum = "B" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
			buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
			if(i%3 == 1){
//				buf.put(ProtocolUtil.stringToByteBuf("18610262066", 21), 0, 21);
			}else if(i%3 == 2){
				buf.put(ProtocolUtil.stringToByteBuf("13716491460", 21), 0, 21);
			}else{
				buf.put(ProtocolUtil.stringToByteBuf("18910319243", 21), 0, 21);
			}
			System.out.println("������������--" + seqNum + ", " + content);
		}
		//buf.putInt(content.getBytes().length);
		buf.put(ProtocolUtil.stringToByteBuf(String.valueOf(content.getBytes().length), 6));
		buf.put(ProtocolUtil.stringToByteBuf(content, content.getBytes().length), 0,
		content.getBytes().length);
		

		return buf.array();

	}
	public static byte[] getCMPP_4(String content) {
		String seq= "A" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
		int totalLen = 168 + content.getBytes().length;//��Ʒ������12λ��Ϊ9λ ���ʼ�3
		System.out.println(content);
		
		System.out.println(totalLen);
		byte[] hands = makeHeader2(totalLen -6, (char)0);

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 32);

		buf.put(ProtocolUtil.stringToByteBuf("aaa21207", 14), 0, 14);
		buf.put(ProtocolUtil.stringToByteBuf("95599", 21), 0, 21);
		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 9), 0, 9);
		buf.put(ProtocolUtil.stringToByteBuf("2", 4), 0, 4);
		String seqNum = "";
		for(int i=0;i<2;i++){
			//15811439243,13699289946,13716491460,13241265931,18610262066,15383348665
			seqNum = "B" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
			buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
			if(i%2 == 1){
				buf.put(ProtocolUtil.stringToByteBuf("13716491460", 21), 0, 21);
				System.out.println("CMPP--" + seqNum + ", 13716491460 , " + content);
			}else{
				buf.put(ProtocolUtil.stringToByteBuf("15811439243", 21), 0, 21);
				System.out.println("CMPP--" + seqNum + ", 15811439243 , " + content);
			}
			System.out.println("������������--" + seqNum + ", " + content);
		}
		//buf.putInt(content.getBytes().length);
		buf.put(ProtocolUtil.stringToByteBuf(String.valueOf(content.getBytes().length), 6));
		buf.put(ProtocolUtil.stringToByteBuf(content, content.getBytes().length), 0,
		content.getBytes().length);
		

		return buf.array();

	}
	

	/*public static byte[] getSGIP() {
		String content = "SGIPũ�з������������" ;
		//String seqNum = "M" + ProtocolUtil.getStringDate() + seq;
		//content = content + "," + seqNum;

		int totalLen = 497 + content.getBytes().length;
		System.out.println(content);

		System.out.println(totalLen);
		byte[] hands = makeHeader2(totalLen, (char)0);

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 32);

		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 14), 0, 14);
		buf.put(ProtocolUtil.stringToByteBuf("544332", 21), 0, 21);
		//buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 12), 0, 12);
		//buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 12), 0, 12);
		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 12), 0, 12);
		buf.putInt(10);
		//buf.put(ProtocolUtil.stringToByteBuf("2", 4), 0, 4);
		String seqNum = "";
		for(int i=0;i<10;i++){
			seqNum = "C" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
			buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
			buf.put(ProtocolUtil.stringToByteBuf("18610262066", 21), 0, 21);
		}
			
		
		buf.putInt(content.getBytes().length);
		buf.put(ProtocolUtil.stringToByteBuf(content, content.getBytes().length), 0,
		content.getBytes().length);
		System.out.println("SGIP--" + seqNum + ", 18610262066 , " + content);

		return buf.array();

	}
	public static byte[] getSGIP_2() {
		String content = "SGIPũ�з���˲���";
		//String seqNum = "M" + ProtocolUtil.getStringDate() + seq;
		//content = content + "," + seqNum;

		int totalLen = 128 + content.getBytes().length;
		System.out.println(content);

		System.out.println(totalLen);
		byte[] hands = makeHeader(totalLen, (char)0);

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 32);

		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 14), 0, 14);
		buf.put(ProtocolUtil.stringToByteBuf("544332", 21), 0, 21);
		//buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 12), 0, 12);
		//buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 12), 0, 12);
		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 12), 0, 12);
		buf.putInt(1);
		String seqNum = "D" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
			buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
			buf.put(ProtocolUtil.stringToByteBuf("13241265931", 21), 0, 21);
		buf.putInt(content.getBytes().length);
		buf.put(ProtocolUtil.stringToByteBuf(content, content.getBytes().length), 0,
		content.getBytes().length);
		System.out.println("SGIP--" + seqNum + ", 13241265931 , " + content);

		return buf.array();

	}

	public static byte[] getSMGP() {
		String content = "SMGPũ�з���˲���";
		//String seqNum = "M" + ProtocolUtil.getStringDate() + seq;
		//content = content + "," + seqNum;

		int totalLen = 128 + content.getBytes().length;
		System.out.println(content);

		System.out.println(totalLen);
		byte[] hands = makeHeader(totalLen, (char)0);

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 32);

		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 14), 0, 14);
		buf.put(ProtocolUtil.stringToByteBuf("544332", 21), 0, 21);
		//buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 12), 0, 12);
		//buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 12), 0, 12);
		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 12), 0, 12);
		buf.putInt(1);
		//buf.put(ProtocolUtil.stringToByteBuf("2", 4), 0, 4);
		String seqNum = "E" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
			buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
			buf.put(ProtocolUtil.stringToByteBuf("18910229623", 21), 0, 21);
		
		buf.putInt(content.getBytes().length);
		buf.put(ProtocolUtil.stringToByteBuf(content, content.getBytes().length), 0,
		content.getBytes().length);
		System.out.println("SMGP--" + seqNum + ", 18910229623 , " + content);
		return buf.array();

	}
	
	public static byte[] getSMGP_2() {
		String content = "SMGPũ�з������������" ;
		//String seqNum = "M" + ProtocolUtil.getStringDate() + seq;
		//content = content + "," + seqNum;

		int totalLen = 497 + content.getBytes().length;
		System.out.println(content);

		System.out.println(totalLen);
		byte[] hands = makeHeader2(totalLen, (char)0);

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 32);

		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 14), 0, 14);
		buf.put(ProtocolUtil.stringToByteBuf("544332", 21), 0, 21);
		//buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 12), 0, 12);
		//buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 12), 0, 12);
		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 12), 0, 12);
		buf.putInt(10);
		//buf.put(ProtocolUtil.stringToByteBuf("2", 4), 0, 4);
		String seqNum = "";
		for(int i=0;i<10;i++){
			seqNum = "F" + ProtocolUtil.getStringDate() + String.valueOf(SeqUtil.getSeq());
			buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
			buf.put(ProtocolUtil.stringToByteBuf("18910229623", 21), 0, 21);
		}
			
		
		buf.putInt(content.getBytes().length);
		buf.put(ProtocolUtil.stringToByteBuf(content, content.getBytes().length), 0,
		content.getBytes().length);
		System.out.println("SMGP--" + seqNum + ", 18910229623 , " + content);

		return buf.array();

	}

	public static byte[] getMT(String seq, String phone) {
		String content = "ABCService �����������ݣ�@#��#" + phone;
		String seqNum = "M" + ProtocolUtil.getStringDate() + seq;
		content = content + "," + seqNum;

		int totalLen = 128 + 41 + content.getBytes().length;
		System.out.println(content);

		System.out.println(totalLen);
		byte[] hands = makeHeader2(totalLen, (char)0);

		ByteBuffer buf = ByteBuffer.allocate(totalLen);

		buf.put(hands, 0, 32);

		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 14), 0, 14);
		buf.put(ProtocolUtil.stringToByteBuf("1122", 21), 0, 21);
		//buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 12), 0, 12);
		//buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 12), 0, 12);
		buf.put(ProtocolUtil.stringToByteBuf("20120508150600", 12), 0, 12);
		buf.putInt(2);
		//buf.put(ProtocolUtil.stringToByteBuf("2", 4), 0, 4);
		for(int i=0;i<2;i++){
			seqNum = "M" + ProtocolUtil.getStringDate() + seq;
			buf.put(ProtocolUtil.stringToByteBuf(seqNum, 20), 0, 20);
			buf.put(ProtocolUtil.stringToByteBuf(phone, 21), 0, 21);

			System.out.println("MT--" + seqNum + "," + "phone" + "," + content);
		}
		
		buf.putInt(content.getBytes().length);
		buf.put(ProtocolUtil.stringToByteBuf(content, content.getBytes().length), 0,
		content.getBytes().length);
		

		return buf.array();

	}*/

}
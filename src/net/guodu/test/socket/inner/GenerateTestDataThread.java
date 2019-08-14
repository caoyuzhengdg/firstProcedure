package net.guodu.test.socket.inner;

import java.util.ArrayList;

public class GenerateTestDataThread extends Thread {

	public void run() {
		ArrayList<TestBean> list = generate();
		Object[] beans = list.toArray();

		System.out.println("List.size = " + list.size());

		for (int i = 0; i < beans.length; i++) {
			TestBean bean = (TestBean) beans[i];
			for (int j = 1; j < 6; j++) {

				byte[] sms = ABCInnerMsg.getMsgs(bean.phone, bean.content + j);
				Queue.add(sms);

				byte[] longsms = ABCInnerMsg.getMsgs(bean.phone,
						bean.longcontent + j);
				Queue.add(longsms);
			}
		}

	}

	public ArrayList<TestBean> generate() {
		ArrayList<TestBean> list = new ArrayList<TestBean>();
		TestBean b1 = new TestBean("ÍõÎ¢Î¢", "13699289946");
		list.add(b1);

		TestBean b2 = new TestBean("°×ÏşÈã", "13241265931");
		list.add(b2);

//		TestBean b3 = new TestBean("ËïÓñ³É", "13426124269");
//		list.add(b3);

//		TestBean b4 = new TestBean("³Â½®ÆÂ", "13501127479");
//		list.add(b4);

		TestBean b5 = new TestBean("ÍôÔÃ", "13126672489");
		list.add(b5);

//		TestBean b6 = new TestBean("ÁõÓ°Ó¢", "13811774250");
//		list.add(b6);
		
//		TestBean b7 = new TestBean("³ÂÜø", "18701634012");
//		list.add(b7);
		
		TestBean b7 = new TestBean("µçĞÅÊÖ»ú", "18910229623");
		list.add(b7);
		
		TestBean b8 = new TestBean("³ÂÅô", "13439440588");
		list.add(b8);

		return list;
	}
}

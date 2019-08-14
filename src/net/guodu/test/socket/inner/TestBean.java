package net.guodu.test.socket.inner;

public class TestBean {

	public String name;
	public String phone;
	public String content = "农行短信测试,测试次数：";
	public String longcontent = "农行长短信测试A长短信测试B长短信测试C长短信测试D长短信测试E长短信测试F长短信测试G长短信测试H长短信测试I长短信测试J长短信测试K长短信测试L测试次数：";

	public TestBean(String name, String phone) {
		this.name = name;
		this.phone = phone;
		this.content = name + content;
		this.longcontent = name + longcontent;
	}
}

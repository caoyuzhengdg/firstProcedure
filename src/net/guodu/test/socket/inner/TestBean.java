package net.guodu.test.socket.inner;

public class TestBean {

	public String name;
	public String phone;
	public String content = "ũ�ж��Ų���,���Դ�����";
	public String longcontent = "ũ�г����Ų���A�����Ų���B�����Ų���C�����Ų���D�����Ų���E�����Ų���F�����Ų���G�����Ų���H�����Ų���I�����Ų���J�����Ų���K�����Ų���L���Դ�����";

	public TestBean(String name, String phone) {
		this.name = name;
		this.phone = phone;
		this.content = name + content;
		this.longcontent = name + longcontent;
	}
}

package idv.chou.chou_springboot.bean;

public class Field {
	private String 正面;
	private String 背面;
	
	public Field() {
		super();
	}
	
	public Field(String 正面, String 背面) {
		this.正面 = 正面;
		this.背面 = 背面;
	}
	public String get正面() {
		return 正面;
	}
	public void set正面(String 正面) {
		this.正面 = 正面;
	}
	public String get背面() {
		return 背面;
	}
	public void set背面(String 背面) {
		this.背面 = 背面;
	}
}

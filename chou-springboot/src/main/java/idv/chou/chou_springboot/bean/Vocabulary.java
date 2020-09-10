package idv.chou.chou_springboot.bean;

import java.util.Arrays;

public class Vocabulary {
	private String name;
	private Info infos[];
	
	public Vocabulary() {
		super();
	}
	
	public Vocabulary(String name, Info[] infos) {
		this.name = name;
		this.infos = infos;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Info[] getInfos() {
		return infos;
	}
	public void setInfo(Info[] infos) {
		this.infos = infos;
	}
	@Override
	public String toString() {
		return "Vocabulary [name=" + name + ", infos=" + Arrays.toString(infos) + "]";
	}
	
}

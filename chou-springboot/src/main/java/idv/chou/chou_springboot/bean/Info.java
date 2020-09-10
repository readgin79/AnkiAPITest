package idv.chou.chou_springboot.bean;

import java.util.Arrays;

public class Info {
	private String pos;
	private String kk;
	private Explanation[] explanation;
	
	public Info() {
		super();
	}

	public Info(String pos, String kk, Explanation[] explanation) {
		this.pos = pos;
		this.kk = kk;
		this.explanation = explanation;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getKk() {
		return kk;
	}

	public void setKk(String kk) {
		this.kk = kk;
	}

	public Explanation[] getExplanation() {
		return explanation;
	}

	public void setExplanation(Explanation[] explanation) {
		this.explanation = explanation;
	}

	@Override
	public String toString() {
		return "Info [pos=" + pos + ", kk=" + kk + ", explanation=" + Arrays.toString(explanation) + "]";
	}
	
	
}

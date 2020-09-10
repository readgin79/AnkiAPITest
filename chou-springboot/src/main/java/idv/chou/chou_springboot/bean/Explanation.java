package idv.chou.chou_springboot.bean;

import java.util.Arrays;

public class Explanation {
	private String explanation;
	private String chinese;
	private String[] example;
	
	public Explanation() {
		super();
	}
	public Explanation(String explanation, String chinese, String[] example) {
		this.explanation = explanation;
		this.chinese = chinese;
		this.example = example;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
	public String[] getExample() {
		return example;
	}
	public void setExample(String[] example) {
		this.example = example;
	}
	@Override
	public String toString() {
		return "Explanation [explanation=" + explanation + ", chinese=" + chinese + ", example="
				+ Arrays.toString(example) + "]";
	}
	
	
	
}

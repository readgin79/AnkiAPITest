package idv.chou.chou_springboot.bean;

import java.util.Arrays;

public class AnkiResponse_get {
	private String[] result;
	private String error;
	
	public String[] getResult() {
		return result;
	}
	public void setResult(String[] result) {
		this.result = result;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return "AnkiResponse [result=" + Arrays.toString(result) + ", error=" + error + "]";
	}
}

package idv.chou.chou_springboot.bean;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;


public class ResponseBean {

	private Object data;
	private String result = "success";
	private HashMap <String, String>res = new HashMap();
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		Gson gson = new Gson();
		res.put("data", gson.toJson(this.getData()));
		res.put("result", this.getResult().toString());
		return gson.toJson(res);
	}
}

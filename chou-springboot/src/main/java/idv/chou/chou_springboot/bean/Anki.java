package idv.chou.chou_springboot.bean;

public class Anki {
	private String action;
	private Integer version;
	private Param params;
	
	public Anki() {
		super();
	}
	
	public Anki(String action, Integer version, Param params) {
		this.action = action;
		this.version = version;
		this.params = params;
	}
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Param getParams() {
		return params;
	}
	public void setParams(Param params) {
		this.params = params;
	}
	
	
}

package idv.chou.chou_springboot.bean;

public class Note {
	private String deckName;
	private String modelName = "基本型(含反向的卡片)";
	private Field fields;
	
	public Note() {
		super();
	}
	
	public Note(String deckName, String modelName, Field fields) {
		this.deckName = deckName;
		this.modelName = modelName;
		this.fields = fields;
	}
	public String getDeckName() {
		return deckName;
	}
	public void setDeckName(String deckName) {
		this.deckName = deckName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public Field getFields() {
		return fields;
	}
	public void setFields(Field fields) {
		this.fields = fields;
	}
}

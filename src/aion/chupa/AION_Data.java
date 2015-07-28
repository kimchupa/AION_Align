package aion.chupa;

public class AION_Data {

	
	private String Filename;
	private String IdData;
	private String TextData;
	
	
	AION_Data(String file, String id, String text) {
		
		this.Filename = file;
		this.IdData = id;
		this.TextData = text;
	}


	public String getFilename() {
		return Filename;
	}


	public void setFilename(String filename) {
		Filename = filename;
	}


	public String getIdData() {
		return IdData;
	}


	public void setIdData(String idData) {
		IdData = idData;
	}


	public String getTextData() {
		return TextData;
	}


	public void setTextData(String textData) {
		TextData = textData;
	}
}

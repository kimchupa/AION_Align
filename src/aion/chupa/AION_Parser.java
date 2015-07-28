package aion.chupa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;

public class AION_Parser {


	private ArrayList<String> fileList = new ArrayList<String>();
	private ArrayList<String> fileName = new ArrayList<String>();
	private Map<Integer, AION_Data> aionData = new HashMap<Integer, AION_Data>();


	public AION_Parser(ArrayList<String> list, ArrayList<String> name) {

		this.fileList = list;
		this.fileName = name;

	}

	public void parse(){

		try{

			System.out.println("Parsing Started...");
			Map<Integer, AION_Data> textData = new HashMap<Integer, AION_Data>();

			UserAgent userAgent = new UserAgent();
			userAgent.settings.charset = "UTF-16";
			int key = 0;
			int filelistSize = fileList.size();
			System.out.println("Number of Files: " + filelistSize);
			for(int i = 0; i < fileList.size(); i++) {

				if(filelistSize%1000 == 0){
					System.out.println(filelistSize);
				}
				
				filelistSize--;
				
				userAgent.open(new File(fileList.get(i)));  //open the HTML (or XML) from a file
				String fileNames = fileName.get(i);


				Elements HtmlPage = userAgent.doc.findEach("<HtmlPage>");
				int htmlc = 0;
								
				for(Element HtmlPages : HtmlPage) {
					
					int pc = 0;
					int actc = 0;
					htmlc++;

					UserAgent inneruAgent = new UserAgent();
					inneruAgent.openContent(HtmlPages.innerHTML());

					Elements p_act = inneruAgent.doc.findEach("<p|act>");

					for(Element p_acts : p_act) {
						if((p_acts.outerHTML().contains("<p"))&&(!p_acts.innerHTML().matches("\\s+|^$"))){
							pc++;
							key++;
							//System.out.println(fileNames+"\t"+"["+htmlc+"h"+pc+"p]" + p_acts.innerHTML());
							textData.put(key, new AION_Data(fileNames, fileNames + htmlc +"h"+pc+"p", p_acts.innerHTML()));
							//System.out.print(textData.get(key).getFilename());
							//System.out.print(textData.get(key).getIdData());
							//System.out.println(textData.get(key).getTextData());

						}
						else if((p_acts.outerHTML().contains("<Act"))&&(!p_acts.innerHTML().matches("\\s+|^$"))){
							actc++;
							key++;
							//System.out.println(fileNames+"\t"+"["+htmlc+"h"+actc+"a]" + p_acts.innerHTML());
							textData.put(key, new AION_Data(fileNames, fileNames + htmlc +"h"+actc+"a", p_acts.innerHTML()));
							//System.out.print(textData.get(key).getFilename());
							//System.out.print(textData.get(key).getIdData());
							//System.out.println(textData.get(key).getTextData());

						}
					}
				}
			}
			
			System.out.println("Number of p and act: " + key);
			this.aionData = textData;

		}
		catch(JauntException | IOException e){
			System.err.println(e);
		}
	}

	public ArrayList<String> getFileList() {
		return fileList;
	}
	public void setFileList(ArrayList<String> fileList) {
		this.fileList = fileList;
	}

	public Map<Integer, AION_Data> getAIONData() {
		return aionData;
	}

	public void setAionData(Map<Integer, AION_Data> aionData) {
		this.aionData = aionData;
	}

	public ArrayList<String> getFileName() {
		return fileName;
	}

	public void setFileName(ArrayList<String> fileName) {
		this.fileName = fileName;
	}

}


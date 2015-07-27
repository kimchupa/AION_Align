package aion.chupa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;

public class AION_Parser {


	private ArrayList<String> fileList = new ArrayList<String>();
	private JSONObject aionTextData;


	public AION_Parser(ArrayList<String> fileList) {

		this.fileList = fileList;

	}

	public void parse(){

		try{

			//Map<Integer, Object[]> textData = new HashMap<Integer, Object[]>();
			JSONObject jsonData = new JSONObject();

			UserAgent userAgent = new UserAgent();
			userAgent.settings.charset = "UTF-16";
			int key = 0;
			for(int i = 0; i < fileList.size(); i++) {

				userAgent.open(new File(fileList.get(i)));  //open the HTML (or XML) from a file
				String fileName = fileList.get(i);
				//System.out.println("\n" + fileList.get(i));


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
							//System.out.println(fileName+"\t"+"["+htmlc+"h"+pc+"p]" + p_acts.innerHTML());
							jsonData.put("filename", fileName);
							jsonData.put("id", htmlc +"h"+pc+"p");
							jsonData.put("textdata", p_acts.innerHTML());
							System.out.print(jsonData);

						}
						else if((p_acts.outerHTML().contains("<Act"))&&(!p_acts.innerHTML().matches("\\s+|^$"))){
							actc++;
							key++;
							//System.out.println(fileName+"\t"+"["+htmlc+"h"+actc+"a]" + p_acts.innerHTML());
							jsonData.put("filename", fileName);
							jsonData.put("id", htmlc +"h"+pc+"a");
							jsonData.put("textdata", p_acts.innerHTML());
							System.out.print(jsonData);
						}
					}
				}
			}
			
			this.aionTextData = jsonData;

		}
		catch(JauntException | IOException e){
			System.err.println(e);
		}
	}

	public JSONObject getaionTextData() {
		return aionTextData;
	}
	public ArrayList<String> getFileList() {
		return fileList;
	}
	public void setFileList(ArrayList<String> fileList) {
		this.fileList = fileList;
	}

}


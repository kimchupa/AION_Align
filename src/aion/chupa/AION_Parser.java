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


	private ArrayList<String> sourceFileList = new ArrayList<String>();
	private ArrayList<String> targetFileList = new ArrayList<String>();
	private Map aionData;

	AION_Parser(ArrayList<String> sourceList, ArrayList<String> targetList) {

		sourceFileList = sourceList;
		targetFileList = targetList;
		Parse(sourceFileList);

	}

	private void Parse(ArrayList<String> fileList){

		try{

			Map<Integer, Object[]> aionSTdata = new HashMap<Integer, Object[]>();

			UserAgent userAgent = new UserAgent();
			userAgent.settings.charset = "UTF-16";

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
							//System.out.println("["+htmlc+"h;"+pc+"p]" + p_acts.innerHTML());
							aionSTdata.put(p_acts.hashCode(), new Object[] {
								fileName,
								htmlc +"h;"+pc+"p",
								p_acts.innerHTML()
							});

						}
						else if((p_acts.outerHTML().contains("<Act"))&&(!p_acts.innerHTML().matches("\\s+|^$"))){
							actc++;
							aionSTdata.put(p_acts.hashCode(), new Object[] {
								fileName,
								htmlc +"h;"+actc+"p",
								p_acts.innerHTML()
							});
							//System.out.println("["+htmlc+"h;"+actc+"a]" + p_acts.innerHTML());
						}
					}
					System.out.println(pc+actc);
				}
			}
			
			aionData = aionSTdata;

		}
		catch(JauntException | IOException e){
			System.err.println(e);
		}
	}

	public ArrayList<String> getsourceFileList() {
		return sourceFileList;
	}

	public ArrayList<String> gettargetFileList() {
		return targetFileList;
	}

	public Map getAionData() {
		return aionData;
	}

	public void setAionData(Map aionData) {
		this.aionData = aionData;
	}
}


package aion.chupa;

import java.io.File;

public class AION_Align {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File sourceF = new File("test");
		AION_FileList AIONFR = new AION_FileList(sourceF);

		AIONFR.fileList(sourceF);
		System.out.println(AIONFR.getSourcePath());


//		try{
//			UserAgent userAgent = new UserAgent();
//			userAgent.open(new File("test/macro.html"));  //open the HTML (or XML) from a file
//
//			Elements HtmlPage = userAgent.doc.findEach("<HtmlPage>");
//			int htmlc = 0;
//			for(Element HtmlPages : HtmlPage) {
//
//
//				int pc = 0;
//				int actc = 0;
//				htmlc++;
//
//				UserAgent inneruA = new UserAgent();
//				inneruA.openContent(HtmlPages.innerHTML());
//
//				Elements p_act = inneruA.doc.findEach("<p|act>");
//
//				for(Element p_acts : p_act) {
//					if((p_acts.outerHTML().contains("<p"))&&(!p_acts.innerHTML().matches("\\s+|^$"))){
//						pc++;
//						System.out.println("["+htmlc+"h;"+pc+"p]" + p_acts.innerHTML());
//
//					}
//					else if((p_acts.outerHTML().contains("<Act"))&&(!p_acts.innerHTML().matches("\\s+|^$"))){
//						actc++;
//						System.out.println("["+htmlc+"h;"+actc+"a]" + p_acts.innerHTML());
//					}
//				}
//			}
//
//
//		}
//		catch(JauntException | IOException e){
//			System.err.println(e);
//		}
	}

}

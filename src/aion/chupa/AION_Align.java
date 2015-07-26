package aion.chupa;

import java.io.File;
import java.io.IOException;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;

public class AION_Align {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			UserAgent userAgent = new UserAgent();
			userAgent.open(new File("test/macro.html"));  //open the HTML (or XML) from a file

			//Element htmlpage = userAgent.doc.findFirst("<HtmlPage>");  //find first div who's class matches 'images' 
			
			//Elements elements = userAgent.doc.findEvery("<HtmlPage>");              //find all divs in the document
			//System.out.println("Every div: " + elements.size() + " results");
			
//			Elements HtmlPage = userAgent.doc.findEach("<HtmlPage>");
//			System.out.println("Found " + HtmlPage.size() + " HtmlPage");
//			
//			for(Element HtmlPages : HtmlPage) {
//			
//				System.out.println(HtmlPages.outerHTML() + "\n---\n");
//				
//			}
			
			Elements HtmlPage = userAgent.doc.findEach("<HtmlPage>");
			int htmlc = 0;
			for(Element HtmlPages : HtmlPage) {
				
				
				int pc = 0;
				int actc = 0;
				htmlc++;
								
				UserAgent inneruA = new UserAgent();
				inneruA.openContent(HtmlPages.innerHTML());
				
				Elements p_act = inneruA.doc.findEach("<p|act>");
				
				for(Element p_acts : p_act) {
					if((p_acts.outerHTML().contains("<p"))&&(!p_acts.innerHTML().matches("\\s+|^$"))){
						pc++;
						System.out.println("["+htmlc+"h;"+pc+"p]" + p_acts.innerHTML());
						
					}
					else if((p_acts.outerHTML().contains("<Act"))&&(!p_acts.innerHTML().matches("\\s+|^$"))){
						actc++;
						System.out.println("["+htmlc+"h;"+actc+"a]" + p_acts.innerHTML());
					}
					
//					if(!p_acts.innerHTML().equals(" ")){
//						System.out.println("["+htmlc+";"+pc+";"+actc+"]" + p_acts.innerHTML());
//					}
				}
				
				//System.out.println(HtmlPages.innerHTML());
			}
			//System.out.println(htmlc + "--" + pc + "--" + actc);

						
			
			
			//System.out.println("div as HTML:\n" + elements.outerHTML() + "\n");      
			//System.out.println("div's content as HTML:\n" + htmlpage.innerHTML());
			//System.out.println("div as XML:\n" + htmlpage.outerXML(2));             //2 chars of indent added at each node level
			//System.out.println("div's content as XML:\n" + htmlpage.innerXML(2));   //2 chars of indent added at each node level

			//make some changes
			//htmlpage.innerHTML("<img src='presto.gif'><br>Presto!");          //replace div's content with different elements.
			//System.out.println("Altered document as HTML:\n" + userAgent.doc.innerHTML());  //print the altered document.
		}
		catch(JauntException | IOException e){
			System.err.println(e);
		}
	}

}

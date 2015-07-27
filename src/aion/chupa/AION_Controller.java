package aion.chupa;

import java.io.File;

public class AION_Controller extends Thread{

	private File filePath;
	
	
	public AION_Controller(File sourceFilePath){
		this.filePath = sourceFilePath;
	}
	
	
	public void run(){
		AION_FileIO aionFileList = new AION_FileIO(filePath);
		aionFileList.fileList();
		//AION_Parser aionParser = new AION_Parser();
		//aionParser.parse(aionFileList.getFileList());
		
	}
}

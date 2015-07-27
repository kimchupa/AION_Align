package aion.chupa;

import java.io.File;

public class AION_Align {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File sourceFilePath = new File("feo");
		File targetFilePath = new File("test");
		
		AION_FileList aionFileList = new AION_FileList(sourceFilePath, targetFilePath);
		AION_Parser aionParse = new AION_Parser(aionFileList.getsourceFileList(), aionFileList.gettargetFileList());
		AION_FileOut aionFileOut = new AION_FileOut(aionParse.getAionData());
	}

}

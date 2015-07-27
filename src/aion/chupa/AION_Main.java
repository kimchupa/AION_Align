package aion.chupa;

import java.io.File;

public class AION_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File sourceFilePath = new File("feo1");
		File targetFilePath = new File("feo2");
		
		
		AION_FileIO source = new AION_FileIO(sourceFilePath);
		source.fileList();
		AION_FileIO target = new AION_FileIO(targetFilePath);
		target.fileList();
		
		
		AION_Parser sourceParser = new AION_Parser(source.getFileList());
		sourceParser.parse();
		
		AION_Parser targetParser = new AION_Parser(target.getFileList());
		targetParser.parse();
		
		AION_Align align = new AION_Align(sourceParser.getaionTextData(), targetParser.getaionTextData());
		align.Align();
		
//		AION_FileOut sourceOut = new AION_FileOut(sourcePaser.getaionTextData());
//		sourceOut.XlsxOut();
		
//		AION_FileOut targetOut = new AION_FileOut(targetPaser.getaionTextData());
//		targetOut.XlsxOut();
		
		
//		AION_Controller source = new AION_Controller(sourceFilePath);
//		AION_Controller target = new AION_Controller(targetFilePath);
//		source.start();
//		target.start();
		
	}

}

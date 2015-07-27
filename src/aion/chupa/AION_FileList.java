package aion.chupa;

import java.io.File;
import java.util.ArrayList;



public class AION_FileList {

	private ArrayList<String> sourceFileList = new ArrayList<String>();
	private ArrayList<String> targetFileList = new ArrayList<String>();


	
	AION_FileList(File sourceFilePath, File targetFilePath) {
		
		sourceFileList(sourceFilePath);
		
	}

	public void sourceFileList(File FilePath){

		File[] sourcefList = FilePath.listFiles();
		System.out.println(FilePath);
		for (File sourcefile : sourcefList){
			
			if (sourcefile.isFile()){			
				System.out.println(sourcefile.getPath() + "\r\n");
				sourceFileList.add(sourcefile.getPath());
				
			}

			else if (sourcefile.isDirectory()){
				sourceFileList(sourcefile);
			}
		}
	}
	
	public void targetFileList(File target){

		File[] targetfList = target.listFiles();

		for (File targetfile : targetfList){

			if (targetfile.isFile()){			
				//System.out.println(sourcefile.getPath() + "\r\n");
				targetFileList.add(targetfile.getPath());
				
			}

			else if (targetfile.isDirectory()){
				targetFileList(targetfile);
			}
		}
	}

	public ArrayList<String> getsourceFileList() {
		// TODO Auto-generated method stub
		return sourceFileList;
	}
	
	public ArrayList<String> gettargetFileList() {
		// TODO Auto-generated method stub
		return targetFileList;
	}
	
}
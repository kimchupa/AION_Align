package aion.chupa;

import java.io.File;
import java.util.ArrayList;



public class AION_FileIO extends Thread{

	private ArrayList<String> fileList = new ArrayList<String>();
	private File filePath;
	
	public AION_FileIO(File sourceFilePath) {
		
		this.filePath = sourceFilePath;
		
	}
	
	public void fileList(){
		System.out.println(filePath + " > start sourceFileList");

		File[] sourcefList = filePath.listFiles();
		for (File sfile : sourcefList){
			
			if (sfile.isFile()){			
				System.out.println(sfile.getPath());
				fileList.add(sfile.getPath());
			}
			else if (sfile.isDirectory()){
				filePath = sfile;
				fileList();
			}
		}
		System.out.println(filePath + " > end sourceFileList");
	}
	
	
	public ArrayList<String> getFileList(){
		return fileList;
	}
	
	public void run(){
		
		synchronized (this) {
			fileList();
		}
		notify();
		
	}
}
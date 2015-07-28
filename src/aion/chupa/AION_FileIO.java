package aion.chupa;

import java.io.File;
import java.util.ArrayList;



public class AION_FileIO extends Thread{

	private ArrayList<String> fileList = new ArrayList<String>();
	private ArrayList<String> fileName = new ArrayList<String>();
	private File filePath;
	
	public AION_FileIO(File sourceFilePath) {
		
		this.filePath = sourceFilePath;
		
		
	}
	
	public void fileList(){
		File[] sourcefList = filePath.listFiles();
		for (File sfile : sourcefList){
			
			if (sfile.isFile()){			
				//System.out.println(sfile.getName());
				fileList.add(sfile.getPath());
				fileName.add(sfile.getName());
			}
			else if (sfile.isDirectory()){
				filePath = sfile;
				fileList();
			}
		}
		//System.out.println(filePath + " > end sourceFileList");
	}
	
	
	public ArrayList<String> getfileList(){
		return fileList;
	}
	
	public ArrayList<String> getfileName(){
		return fileName;
	}
	
	public void run(){
		
		synchronized (this) {
			fileList();
		}
		notify();
		
	}
}
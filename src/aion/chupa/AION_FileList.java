package aion.chupa;

import java.io.File;



public class AION_FileList {

	private File sourcePath;
	private String currentFile;
	private int fileNum = 0;



	AION_FileList(File sourceDir) {

		sourcePath = sourceDir;
	}

	public void fileList(File source){

		File[] sourcefList = source.listFiles();

		for (File sourcefile : sourcefList){

			if (sourcefile.isFile()){			
				System.out.println(sourcefile.getPath() + "\r\n");
			}

			else if (sourcefile.isDirectory()){
				fileList(sourcefile);
			}
		}
	}






	public File getSourcePath() {
		return sourcePath;
	}




	public void setSourcePath(File sourcePath) {
		this.sourcePath = sourcePath;
	}




	public String getCurrentFile() {
		return currentFile;
	}




	public void setCurrentFile(String currentFile) {
		this.currentFile = currentFile;
	}




	public int getFileNum() {
		return fileNum;
	}




	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}

}

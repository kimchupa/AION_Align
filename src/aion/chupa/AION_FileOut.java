package aion.chupa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AION_FileOut {

	
	private Map aionDataout;
	
	
	AION_FileOut(Map aionData) {
		
		aionDataout = aionData;
		XlsxOut();
	}

	public void XlsxOut(){
		
		
		XSSFWorkbook workbook = new XSSFWorkbook();		

		XSSFSheet sheet = workbook.createSheet("AION");

		XSSFFont font = workbook.createFont();
		font.setBold(true);

		XSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);

		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("FileName");
		header.createCell(1).setCellValue("ID");
		header.createCell(2).setCellValue("Text");

		Set<Integer> keyset = aionDataout.keySet();
		
		int rownum = 1;
		
		for(int key : keyset){
			
			Row row = sheet.createRow(rownum++);
			Object[] abjArr = (Object[]) aionDataout.get(key);
			
			int cellnum = 0;
			
			for(Object obj : abjArr) {
				
				Cell cell = row.createCell(cellnum++);
				if(obj instanceof String) {
					cell.setCellValue((String)obj);
				}
			}
		}
		
		try{
			
			File fileOut = new File("test/out.xlsx");
			if(!fileOut.exists()) {
				fileOut.getParentFile().mkdirs();
			}
			
			FileOutputStream fos = new FileOutputStream(fileOut);
			workbook.write(fos);
			fos.flush();
			fos.close();
			
		}catch (IOException  e) {
			e.printStackTrace();
		}
	}
}

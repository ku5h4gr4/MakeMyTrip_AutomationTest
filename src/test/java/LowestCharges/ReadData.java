package LowestCharges;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
	
	public ArrayList<String> Data() throws IOException
	{
		DataFormatter formatter = new DataFormatter();
		ArrayList<String> dataList = new ArrayList<>();
		String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\Data.xlsx";
		FileInputStream file= new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int totalRow = sheet.getLastRowNum();
		int totalCell = sheet.getRow(0).getLastCellNum();
		for(int i=1;i<=totalRow;i++)
		{
			XSSFRow currentRow = sheet.getRow(i);
			for(int j=0;j<totalCell;j++)
			{
				XSSFCell currentCell = currentRow.getCell(j);
				String res = formatter.formatCellValue(currentCell);
				dataList.add(res);
			}
		}
		workbook.close();
		file.close();
		return dataList;
	}
	
	
	

}

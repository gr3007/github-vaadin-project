package com.example.crudwithvaadin;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtils(String excelPath, String sheetName){
        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception exp) {
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();

        }
    }

    public static int getRowCount() {
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("No of Rows: " + rowCount);
        return rowCount;
    }

    public static String getCellData(int rowNum, int cellNum) throws Exception{
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));
    }
}

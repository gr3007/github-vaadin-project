package com.example.crudwithvaadin;

public class ExcelUtilTest {
    public static void main(String[] args) throws Exception{
        String excelPath = "C:/Users/geeri/Desktop/my-excel.xlsx";
        String sheetName = "Sheet0";
        ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

        int row = excel.getRowCount();
        for (int i=1; i< row; i++){
            excel.getCellData(i,1);
            excel.getCellData(i,3);
            excel.getCellData(i,0);

        }
        //excel.getCellData(1,0);
    }

}

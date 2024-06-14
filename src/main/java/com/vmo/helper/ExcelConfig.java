package com.vmo.helper;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelConfig {
    private XSSFWorkbook wb;
    private XSSFSheet sh;
    private FileInputStream fileIn;
    private FileOutputStream fileOut;

    public ExcelConfig(String excelPath) {
        try {
            File file = new File(excelPath);
            fileIn = new FileInputStream(file);
            wb = new XSSFWorkbook(fileIn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ExcelConfig() {
        try {
            File file = new File("");
            fileIn = new FileInputStream(file);
            wb = new XSSFWorkbook(fileIn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getNumRow() {
        sh = wb.getSheet("Sheet1");
        return sh.getLastRowNum();
    }

    public int getColNum() {
        sh = wb.getSheet("Sheet1");
        return sh.getRow(0).getLastCellNum();
    }

    public String getDataValue(int rowNum, int colNum) {
        sh = wb.getSheet("Sheet1");
        DataFormatter df = new DataFormatter();
        try {
            return df.formatCellValue(sh.getRow(rowNum).getCell(colNum));
        } catch (NullPointerException npe) {
            return "";
        }
    }

    public Object[][] data(){
        int rowNum = getNumRow();
        int colNum = getColNum();
        System.out.println("Row num: " + rowNum);
        System.out.println("Col num: " + colNum);
        Object[][] obj = new Object[rowNum][colNum];
        int currentRow = 0;
        for(int i = 1; i<= rowNum; i++){
            for(int j = 0; j < colNum; j++){
                obj[currentRow][j] = getDataValue(i, j);
            }
            currentRow++;
        }
        return obj;
    }
}

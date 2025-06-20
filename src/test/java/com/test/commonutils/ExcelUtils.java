package com.test.commonutils;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Objects;


public class ExcelUtils {
    static FileInputStream fileInputStream = null;
    static FileOutputStream fileOutputStream = null;


    public static XSSFWorkbook getWorkbook() throws Exception {
        XSSFWorkbook workbook;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/ReadGradeData.xlsx");
            workbook = new XSSFWorkbook(fileInputStream);

        }
        catch (Exception e){
            throw new Exception("Failed to get the sheet \n" + e.getMessage());
        }
        return workbook;

    }

    public static String ReadExcelData() throws Exception {



      try {
          XSSFWorkbook workbook = ExcelUtils.getWorkbook();
          XSSFSheet worksheet = workbook.getSheet("Sheet1");


          // Iterate over rows
          for (Row row : worksheet) {
             if(row.getRowNum() >0) {
                 // Iterate over cells
                 for (Cell cell : row) {
                     // Read cell value based on cell type
                     System.out.println(cell.getStringCellValue() + "\t");
                 }
             }
          }
      } catch (Exception e) {
          throw new Exception("Failed to retrieve value from test data xlsx \n" + e.getMessage());
      } finally {
          fileInputStream.close();
      }
      return null;
  }



    public static ArrayList<Cell> getGradelist() throws Exception {

        ArrayList<Cell> gradeList = new ArrayList<>();

        try {
            XSSFWorkbook workbook = ExcelUtils.getWorkbook();
            XSSFSheet worksheet = workbook.getSheet("Sheet1");
            Row row = worksheet.getRow(0);
            for(Cell cell:row){
                if(!Objects.equals(cell.getStringCellValue(), "category_name") &&
                        !Objects.equals(cell.getStringCellValue(), "Brand_name") &&
                        !Objects.equals(cell.getStringCellValue(), "Asset Group") &&
                        !Objects.equals(cell.getStringCellValue(), "Asset name")&&
                        !Objects.equals(cell.getStringCellValue(), "Status")){
                    gradeList.add(cell);

                }


            }
            System.out.println(gradeList);

        } catch (Exception e) {
            throw new Exception("Failed to retrieve value from test data xlsx \n" + e.getMessage());
        } finally {
            fileInputStream.close();
        }
        return gradeList;
    }


    public static void setStatus(Row row, XSSFWorkbook workbook ) throws Exception {

        try {
                    Cell cell = row.getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cell.setCellValue("PASS");
                    CellStyle cellStyle = workbook.createCellStyle();
                    //To set the Font color
                    cellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
                    cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    // Apply the cell style to the cell
                    cell.setCellStyle(cellStyle);

                    fileOutputStream = new FileOutputStream(System.getProperty("user.dir") + "/src/test/resources/ReadGradeData.xlsx");
                    workbook.write(fileOutputStream);

        } catch (Exception e) {
            throw new Exception("Failed to retrieve value from test data xlsx \n" + e.getMessage());
        } finally {
            fileOutputStream.close();
        }

    }

}

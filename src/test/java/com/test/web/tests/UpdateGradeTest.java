package com.test.web.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.test.commonutils.ExcelUtils;
import com.test.commonutils.ExtentReport;
import com.test.commonutils.PropertyUtils;
import com.test.commonutils.TestUtils;
import com.test.web.base.BaseTest;
import com.test.web.pages.LoginIntoApps;
import com.test.web.pages.UpdateGrade;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class UpdateGradeTest extends BaseTest {

    UpdateGrade updateGrade;
    Properties properties;
    FileInputStream fileInputStream=null;
   




    public void navigateToTheAssetChecklist(String category,String brandName,String assetGroup,
                                            String storage,String checklist, String selectCondition,String conditionToSelect) throws IOException, InterruptedException {

        new UpdateGrade(getDriver()).selectCategory(category).selectBrand(brandName).
                                            selectAssetGroup(assetGroup).selectAssetStorge(storage);
        editTheAssetCheclist(checklist);
        selectItemConditionByName(selectCondition);
        updateItemConditionDetail(conditionToSelect);
    }

    private void navigateToTheAssetChecklist(String category, String brandName, String assetGroup, String storage,ArrayList<Cell> itemConditionList,Row row) throws Exception {

        new UpdateGrade(getDriver()).selectCategory(category).selectBrand(brandName).
                selectAssetGroup(assetGroup).selectAssetStorge(storage);
        editTheAssetCheclist(itemConditionList, row);
    }

    public void editTheAssetCheclist(String checklistValue) throws IOException {

        new UpdateGrade(getDriver()).selectChecklistName(checklistValue);
    }

    public void editTheAssetCheclist(ArrayList<Cell> itemConditionList, Row row) throws Exception {

        new UpdateGrade(getDriver()).selectAllChecklistName(itemConditionList,row);
    }

    public void selectItemConditionByName(String itemConditionName) throws IOException {

        new UpdateGrade(getDriver()).selectItemConditionByName(itemConditionName);
    }

    public void updateItemConditionDetail(String itemConditionDetail) throws IOException {

        new UpdateGrade(getDriver()).updateItemConditionDetail(itemConditionDetail);

    }
    @Test
    public void ReadExcelDatarUpgrade() throws Exception {
        properties = PropertyUtils.propertyLoader(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        upgradeTheGrade("Saudi Telecommunication Company", properties.getProperty("username"));
        ExtentTest extentTest = ExtentReport.startTest("Updating grades", "To update all the grades in B and C category", "Web");
        extentTest.log(Status.PASS, "Testing Extent logs");
        extentTest.pass("Reported properly.");
    }


    private void ReadExcelDataforUpgrade(String branchName,String testDataFile , String  sheetName, String userName) throws Exception {
        new LoginIntoApps(getDriver()).load().loginintoPrismApp(userName);
        new UpdateGrade(getDriver()).searchBranch(branchName).selectAssetChecklistoption(branchName);

        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/" + testDataFile + ".xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet worksheet = workbook.getSheet(sheetName);

            if (worksheet == null) {
                System.out.println("Sheet '" + sheetName + "' not found.");
                return;
            }
//            Row rows = (Row) worksheet;
            // Iterate over rows
            for (Row row : worksheet) {
                if (row.getRowNum() > 0) {
                    // Iterate over cells
//                    Cell cell1 = row.getCell(0);
//                    String branchName = cell1.getStringCellValue();
                    Cell cell2 = row.getCell(0);
                    String category = cell2.getStringCellValue();
                    Cell cell3 = row.getCell(1);
                    String brandName = cell3.getStringCellValue();
                    Cell cell4 = row.getCell(2);
                    String assetGroup = cell4.getStringCellValue();
                    Cell cell5 = row.getCell(3);
                    String storage = cell5.getStringCellValue();
                    Cell cell6 = row.getCell(4);
                    String checklist = cell6.getStringCellValue();
                    Cell cell7 = row.getCell(5);
                    String selectCondition = cell7.getStringCellValue();
                    Cell cell8 = row.getCell(6);
                    String conditionToSelect = cell8.getStringCellValue();

                    navigateToTheAssetChecklist(category, brandName, assetGroup, storage, checklist, selectCondition, conditionToSelect);
                    System.out.println("Changed the data for an assetGroup =  "+ assetGroup + ", storage = " + storage + ", checklist = " + checklist + ", selectCondition = " + selectCondition+", conditionToSelect = " + conditionToSelect);

                }
            }
        } catch (Exception e) {
            throw new Exception("Failed to retrieve value from test data xlsx \n" + e.getMessage());
        }finally {
            fileInputStream.close();
        }

    }

    public void upgradeTheGrade(String branchName, String userName) throws Exception {
        String category, brandName, assetGroup, storage, secondGradePercentage,thirdGradePercentage;
        DataFormatter dataFormatter = new DataFormatter();
        new LoginIntoApps(getDriver()).load().loginintoPrismApp(userName);
        TestUtils.log("web").info("Logged In successfully into the admin app");
        new UpdateGrade(getDriver()).searchBranch(branchName).selectAssetChecklistoption(branchName);

        try {
                ArrayList<Cell> gList = ExcelUtils.getGradelist();
                XSSFWorkbook workbook = ExcelUtils.getWorkbook();
                XSSFSheet worksheet = workbook.getSheet("Sheet1");
                for (Row row : worksheet) {
                    if (row.getRowNum() > 0) {
                        Cell cell2 = row.getCell(0);
                        category = cell2.getStringCellValue();
                        Cell cell3 = row.getCell(1);
                        brandName = cell3.getStringCellValue();
                        Cell cell4 = row.getCell(2);
                        assetGroup = cell4.getStringCellValue();
                        Cell cell5 = row.getCell(3);
                        storage = cell5.getStringCellValue();

                        navigateToTheAssetChecklist(category, brandName, assetGroup, storage,gList, row);
                        ExcelUtils.setStatus(row,workbook);

                        TestUtils.log("web").info("Executed the row number " + row.getRowNum() + " for the following records:- " +
                                "Category as  "+category+ " Brand as "+ brandName+" Asset Group as "+ assetGroup+" Storage as "
                                + storage+" And for the grades in the list "+gList);

                            }

                        }

        } catch (Exception e) {
            throw new Exception("The method has failed due to:-  \n" + e.getMessage());

        }finally {
            if(fileInputStream != null ) {
                fileInputStream.close();
            }
        }

    }


}

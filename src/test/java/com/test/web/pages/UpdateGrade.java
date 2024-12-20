package com.test.web.pages;

import com.test.commonutils.TestUtils;
import com.test.web.base.WebBasePage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UpdateGrade extends WebBasePage{

    private int i;
    private final By  searchBranch = By.xpath("//*[@name='search']");
    private final By  hoNamesList = By.xpath("//*[contains(@class, 'MuiTable-root')]/tbody/tr/td[1]");
    String  clickEditIcon1 = "//*[contains(@class, 'MuiTable-root')]/tbody/tr[";
    String  clickEditIcon2 = "]/td[2]/button";
    private final By  manageAssetChecklist = By.xpath("//*[@role='menu']/li[2]");
    private final By  clickCategory = By.xpath("//*[@role='combobox']");
    String  select1stString = ("//*[text()='");
    String  select2ndString = ("']");
    private final By  searchBrand = By.xpath("//*[contains(@class,'MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-spacing-xs-')]/div[2]/div/div/div/input");
    private final By  searchAssetGroup = By.xpath("//*[contains(@class,'MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-spacing-xs-')]/div[3]/div/div/div/input");
    private final By  selectAssetGroup = By.xpath("//ul[@id=':r7:-listbox']/li");
    private final By  searchAsset = By.xpath("//*[contains(@class,'MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-spacing-xs-')]/div[4]/div/div/div/input");
    private final By  getListOfChecklist = By.xpath("//table[contains(@class,'MuiTable-root css-')]/tbody/tr/td[1]");
    String getchecklistvalue1 = "//table[contains(@class,'MuiTable-root css-')]/tbody/tr[";
    String getchecklistvalue2 = "]/td[1]";
    String clickChecklistEdit = "]/td[5]/span[1]";
    private final By  getListOfItemCondition = By.xpath("//table[contains(@class,'MuiTable-root css-')]/tbody/tr/td[3]");
    String  getItemConditionValue = "]/td[3]";
    String  clickItemConditionEditicon = "]/td[8]/span[1]";
    String  clickItemConditionEditicon2 = "]/td[7]/span[1]";
    private final By  getListofItemConditionforEnglish = By.xpath("//ul[contains(@id,'-listbox')]/li");
    String  gettextListofItemConditionforEnglish1 = "//li[contains(@id,'-option-";
    String  gettextListofItemConditionforEnglish2 = "')]";
    private final By clickItemConditionDetailForEnglish = By.xpath("//input[@placeholder='Item Condition For English']");
    private final By  submitButton = By.xpath("//*[contains(@class ,'MuiCardActions-root MuiCardActions-spacing float-right')]/button");
    private final By  finalsubmitButton = By.xpath("//button[contains(@class,'float-right css-')]");
    private final By prismTab = By.xpath("//*[@class='ps-content']/ul[2]/li/a");
    private final By b2bMamgementTab = By.xpath("//*[contains(@class,'MuiListItemText-root css') ]/p[text() = 'B2B Management']");
    private final By automationAvailble = By.xpath("//*[contains(@class,'MuiFormControlLabel-root MuiFormControlLabel')]/span/input[@type='checkbox']");

    public UpdateGrade(RemoteWebDriver driver) {
        super(driver);
    }

    public UpdateGrade load(){
        load("");
        return this;
    }

    private UpdateGrade enterTextInSearchFld(String txt) throws InterruptedException {
        click(prismTab);
        Thread.sleep(3000);
        getWindowHandles();
        click(b2bMamgementTab);
        enterText(searchBranch,txt);
        Thread.sleep(3000);
        return this;
    }

    public UpdateGrade searchBranch(String branchName) throws InterruptedException {
        enterTextInSearchFld(branchName).clickSearchBtn();
        return this;
    }

    private void clickSearchBtn(){
        new WebDriverWait(driver, Duration.ofSeconds(1000));
        click(searchBranch);
        new WebDriverWait(driver, Duration.ofSeconds(1000));



    }

    public UpdateGrade selectAssetChecklistoption(String branchName) throws InterruptedException {
        int i = 0;
        List<WebElement> hoNames = driver.findElements(hoNamesList);
        for(WebElement hoName:hoNames) {
             if(hoName.getText().equalsIgnoreCase(branchName)) {
                By finalElement = By.xpath(clickEditIcon1+ (i + 1) + clickEditIcon2);
                wait.until(ExpectedConditions.elementToBeClickable(finalElement)).click();
                click(manageAssetChecklist);
           }
            i++;
        }
/*        By finalElement = By.xpath(clickEditIcon1+ (i + 1) + clickEditIcon2);
        selectAnElementFromTheList(hoNamesList,branchName,finalElement,manageAssetChecklist);*/

        return this;


    }

    public UpdateGrade selectCategory(String category) throws InterruptedException {
        Thread.sleep(3000);
        click(clickCategory);
        By finalElement = By.xpath(select1stString+category+select2ndString);
        click(finalElement);
        return this;

    }

    public UpdateGrade selectBrand(String brandName){
        By finalElement = By.xpath(select1stString+brandName+select2ndString);
        selectByEnteringText(searchBrand,brandName,finalElement);
        return this;
    }

    public UpdateGrade selectAssetGroup(String assetGroup){
        By finalElement = By.xpath(select1stString+assetGroup+select2ndString);
        selectByEnteringText(searchAssetGroup,assetGroup,finalElement);
        return this;

    }

    public UpdateGrade selectAssetStorge(String assetStrorage){
        By finalElement = By.xpath(select1stString+assetStrorage+select2ndString);
        selectByEnteringText(searchAsset,assetStrorage,finalElement);
        return this;

    }

    private void finalSave(){
        click(finalsubmitButton);

    }

    public void selectChecklistName(String checklistvalue) {
/*        List<WebElement> webElementsList = driver.findElements(getListOfChecklist);
        for (i = 0; i <= webElementsList.size(); i++) {
            String text = driver.findElement(By.xpath(getchecklistvalue1 + (i + 1) + getchecklistvalue2)).getText();
            if (text.equalsIgnoreCase(checklistvalue)) {
                click(By.xpath(getchecklistvalue1 + (i + 1) + clickChecklistEdit));
                break;
            }
        }*/

        selectAnElementFromTheList(getListOfChecklist,checklistvalue,getchecklistvalue1,getchecklistvalue2,clickChecklistEdit);
    }


    public void selectItemConditionByName(String itemConditionName){

/*        List<WebElement> webElementsList = driver.findElements(getListOfItemCondition);
            for (i = 0; i <= webElementsList.size(); i++) {
                String text = driver.findElement(By.xpath(getchecklistvalue1 + (i + 1) + getItemConditionValue)).getText();
                Reporter.log("Got the  item condition" + text);
                if (text.equalsIgnoreCase(itemConditionName)) {
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(getchecklistvalue1 + (i + 1) + clickItemConditionEditicon))).click();
                    break;
                }
            }*/

        selectAnElementFromTheList(getListOfItemCondition,itemConditionName,getchecklistvalue1,getItemConditionValue,clickItemConditionEditicon);
        }


    public void updateItemConditionDetail(String itemConditionDetail){
/*        wait.until(ExpectedConditions.elementToBeClickable(clickItemConditionDetailForEnglish)).click();
        List<WebElement> webElementsList = driver.findElements(getListofItemConditionforEnglish);
        for(i =0;i<= webElementsList.size();i++){
            String text = driver.findElement(By.xpath(gettextListofItemConditionforEnglish1+(i+1)+gettextListofItemConditionforEnglish2)).getText();
            if(text.equalsIgnoreCase(itemConditionDetail)){
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(gettextListofItemConditionforEnglish1+(i)+gettextListofItemConditionforEnglish2))).click();
                wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
                wait.until(ExpectedConditions.elementToBeClickable(finalsubmitButton)).click();
                break;
            }
        }*/
        wait.until(ExpectedConditions.elementToBeClickable(clickItemConditionDetailForEnglish)).click();
        selectAnElementFromTheList(getListOfItemCondition,itemConditionDetail,gettextListofItemConditionforEnglish1,gettextListofItemConditionforEnglish2,gettextListofItemConditionforEnglish2);
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(finalsubmitButton)).click();

    }

    public UpdateGrade selectAllChecklistName(ArrayList<Cell> itemConditionList,Row row) throws Exception {

        try {
            String secondGradePercentage, thirdGradePercentage;
            DataFormatter dataFormatter = new DataFormatter();
            Cell cell6 = row.getCell(4);
            secondGradePercentage = dataFormatter.formatCellValue(cell6);
            Cell cell7 = row.getCell(5);
            thirdGradePercentage = dataFormatter.formatCellValue(cell7);
       /* Cell cell8 = row.getCell(6);
        thirdGradePercentage = dataFormatter.formatCellValue(cell7);*/
            List<WebElement> webElementsList = driver.findElements(getListOfChecklist);
            for (int i = 0; i < webElementsList.size()-1; i++) {

//                logutils.log().info("Clicking on edit icon for the checklist:-> " + text);
                Thread.sleep(2000);
                String text = getText(By.xpath(getchecklistvalue1 + (i + 1) + getchecklistvalue2));
                if(!text.equalsIgnoreCase("Wifi Check") && !text.equalsIgnoreCase("Check Wifi")) {
                    TestUtils.log("web").info("Clicking on edit icon for the checklist:-> " + text);
                    click(By.xpath(getchecklistvalue1 + (i + 1) + clickChecklistEdit));

                    for (Cell grade : itemConditionList) {
                        switch (grade.getStringCellValue()) {
                            case "B" -> {
                                String itemConditionDetail = grade + " - " + secondGradePercentage;
                                TestUtils.log("web").info("Selecting the grade to change the %age to  " + itemConditionDetail);
                                selectItemCondition(grade.getStringCellValue(), itemConditionDetail);
                            }

                            case "C" -> {
                                String itemConditionDetail = grade + " - " + thirdGradePercentage;
                                TestUtils.log("web").info("Selecting the grade to change the %age to  " + itemConditionDetail);
                                selectItemCondition(grade.getStringCellValue(), itemConditionDetail);
                            }


                        }
                    }
                    finalSave();
                }


            }
        }catch(Exception e){
            TestUtils.log("web").error("Test failed to click the edit asset checklist"+getClass().getEnclosingMethod().getName());
            throw new Exception(e.getMessage());

        }
        return this;
    }

    public void selectItemCondition(String itemCondition,String itemConditionDetail) throws Exception {
        try {
            List<WebElement> webElementsList = driver.findElements(getListOfItemCondition);
            boolean checkbox = isSelected(automationAvailble);
            for (int j = 0; j < webElementsList.size(); j++) {
                String text = getText(By.xpath(getchecklistvalue1 + (j + 1) + getItemConditionValue));

                if (text.equalsIgnoreCase(itemCondition)) {
                    if (!checkbox) {
                        click(By.xpath(getchecklistvalue1 + (j + 1) + clickItemConditionEditicon2));
                        updateItemConditionDetails(itemConditionDetail);
                        break;
                    } else {
                        click(By.xpath(getchecklistvalue1 + (j + 1) + clickItemConditionEditicon));
                        updateItemConditionDetails(itemConditionDetail);
                        break;
                    }
                }
            }

        } catch (Exception e) {
            TestUtils.log("web").error("Test failed to select the asset checklist"+getClass().getEnclosingMethod().getName());
            throw new Exception(e.getMessage());
        }
    }


    public void updateItemConditionDetails(String itemConditionDetail){
        wait.until(ExpectedConditions.elementToBeClickable(clickItemConditionDetailForEnglish)).click();
        List<WebElement> webElementsList = driver.findElements(getListofItemConditionforEnglish);
        for(i =0;i<= webElementsList.size();i++){
            String text = getText(By.xpath(gettextListofItemConditionforEnglish1+(i)+gettextListofItemConditionforEnglish2));
            if(text.equalsIgnoreCase(itemConditionDetail)){
                click(By.xpath(gettextListofItemConditionforEnglish1+(i)+gettextListofItemConditionforEnglish2));
                click(submitButton);
                break;
                }
            }


    }
}



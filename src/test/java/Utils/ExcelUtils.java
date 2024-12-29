package Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class ExcelUtils {
    public static List<LinkedHashMap<String, String>> getExcelData(String excelName, String SheetName) throws IOException {
      String filepath=System.getProperty("user.dir")+"/src/test/resources/"+excelName+".xlsx" ;
      List<LinkedHashMap<String,String>> datafromexcel=new ArrayList<>();
      Workbook workbook= WorkbookFactory.create(new File(filepath));
      Sheet sheet=   workbook.getSheet(SheetName);
      int totalNumberofRows= sheet.getPhysicalNumberOfRows();
      List<String> allKeys=new ArrayList<>();
      DataFormatter dataFormatter=new DataFormatter();
      for(int i=0;i<totalNumberofRows;i++)
      {
      LinkedHashMap dataMap=new LinkedHashMap<>();
        if(i==0) {
            int totalCols = sheet.getRow(i).getPhysicalNumberOfCells();
            for (int j = 0; j<totalCols; j++) {
                allKeys.add(sheet.getRow(i).getCell(j).getStringCellValue());
            }
        }
        else
        {int totalCols = sheet.getRow(i).getPhysicalNumberOfCells();
            for (int j = 0; j < totalCols; j++) {
                String cellValue=dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
                dataMap.put(allKeys.get(j),cellValue);
            }
         datafromexcel.add(dataMap);
        }
      }
      //Arrays.sort(datafromexcel);
      return datafromexcel;
    }

}

package sample;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Vector;
import java.lang.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class excel_read {

    public static String [] readExcelFile(int zipCode) {
        /** --Define a Vector
         --Holds Vectors Of Cells
         */
        String[] Location = new String[2];
        String fileName = "C:\\Users\\OMARO\\IdeaProjects\\FxJDK9\\src\\zip_database.xls";
        int temp = 0;
        try {
            FileInputStream myInput = new FileInputStream(fileName);
            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
            /** Create a workbook using the File System**/
            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
            /** Get the first sheet from workbook**/
            HSSFSheet mySheet = myWorkBook.getSheetAt(0);
            /** We now need something to iterate through the cells.**/
            Iterator rowIter = mySheet.rowIterator();

            while (rowIter.hasNext()) {
                HSSFRow myRow = (HSSFRow) rowIter.next();
                Iterator cellIter = myRow.cellIterator();
                Vector cellStoreVector = new Vector();
                while (cellIter.hasNext()) {
                    HSSFCell myCell = (HSSFCell) cellIter.next();
                    if (myCell.getColumnIndex() == 0){               //if it is the first column
                        if (myCell.getNumericCellValue() == zipCode){    // if it is the right zip code
                            temp = 1;                               // Lock variable
                        }
                    }

                    if (myCell.getColumnIndex() == 1 && temp == 1){
                        Location[0] = myCell.getStringCellValue();
                    }
                    if (myCell.getColumnIndex() == 2 && temp == 1) {
                        Location[1] = myCell.getStringCellValue();
                        temp = 0;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Location;
    }
}





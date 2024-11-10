package ziua_49_50.ProiectComplet.Java.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtility {

    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public CellStyle style;
    String path;

//  avem aici, mai jos, un constructor
    public ExcelUtility(String path)
    {
        this.path = path;
    }
//  am generat un obiect in aceasta clasa - path - si il folosim peste tot mai jos

    public int getRowCount(String sheetName) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        int rowcount = sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowcount;
    }

    public int getCellCount(String sheetName, int row_num) throws IOException {
        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(row_num);
        int cellcount = sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return cellcount;
    }

        public String getCellData (String sheetName,int row_num, int col_num) throws IOException {
            fi = new FileInputStream(path);
            workbook = new XSSFWorkbook(fi);
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(row_num);
            cell = row.getCell(col_num);

            DataFormatter formatter = new DataFormatter();
            String data;
            try {
                data = formatter.formatCellValue(cell);     // returneaza valoarea celului ca un sir de caractere.
            } catch (Exception e) {
                data = "";
            }
            workbook.close();
            fi.close();
            return data;
        }

        public void setCellData (String sheetName,int row_num, int col_num, String data) throws IOException {
            File xlfile = new File(path);
//  daca pagina nu exista atunci creati o pagina noua!
            if (!xlfile.exists()) {
                workbook = new XSSFWorkbook();
                fo = new FileOutputStream(path);
                workbook.write(fo);
            }

            fi = new FileInputStream(path);
            workbook = new XSSFWorkbook(fi);

//  daca workbook-ul nu exista atunci creati unul nou!
            if (workbook.getSheetIndex(sheetName) == -1)
                workbook.createSheet(sheetName);
            sheet = workbook.getSheet(sheetName);

            if (sheet.getRow(row_num) == null)
                sheet.createRow(row_num);
            row = sheet.getRow(row_num);

            cell = row.createCell(col_num);
            cell.setCellValue(data);
            fo = new FileOutputStream(path);
            workbook.write(fo);
            workbook.close();
            fi.close();
            fo.close();
        }

        public void fillGreenColor(String sheetName,int row_num, int col_num) throws IOException{

            fi = new FileInputStream(path);
            workbook = new XSSFWorkbook(fi);
            sheet = workbook.getSheet(sheetName);

            row = sheet.getRow(row_num);
            cell=row.getCell(col_num);
            style = workbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            cell.setCellStyle(style);
            workbook.write(fo);
            workbook.close();
            fi.close();
            fo.close();
        }

    public void fillRedColor(String sheetName,int row_num, int col_num) throws IOException{

        fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);

        row = sheet.getRow(row_num);
        cell=row.getCell(col_num);
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }

}

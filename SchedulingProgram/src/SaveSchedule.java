import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oluwajayi
 */
public class SaveSchedule {

    public static void Writer (JTable jTable1, String Location) throws FileNotFoundException, IOException {

                HSSFWorkbook fWorkbook = new HSSFWorkbook();
                HSSFSheet fSheet = fWorkbook.createSheet("new Sheet");
                HSSFFont sheetTitleFont = fWorkbook.createFont();
                HSSFCellStyle cellStyle = fWorkbook.createCellStyle();
                //sheetTitleFont.setColor();
                TableModel model = jTable1.getModel();

                //Get Header
                TableColumnModel tcm = jTable1.getColumnModel();
                HSSFRow hRow = fSheet.createRow((short) 0);
                for(int j = 0; j < tcm.getColumnCount(); j++) {                       
                   HSSFCell cell = hRow.createCell((short) j);
            cell.setCellValue(tcm.getColumn(j).getHeaderValue().toString());
                   cell.setCellStyle(cellStyle);
                }

                //Get Other details
                for (int i = 0; i < model.getRowCount(); i++) {
                    HSSFRow fRow = fSheet.createRow((short) i+1);
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        HSSFCell cell = fRow.createCell((short) j);
                        cell.setCellValue(model.getValueAt(i, j).toString());
                        cell.setCellStyle(cellStyle);
                    }
                }
            FileOutputStream fileOutputStream;
            fileOutputStream = new FileOutputStream(Location);
    try (BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream)) {
        fWorkbook.write(bos);
    }
            fileOutputStream.close();
}
}
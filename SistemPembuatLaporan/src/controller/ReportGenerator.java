/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author angelynz95
 */
public class ReportGenerator {
    // Atribut
    private OrderController orderController;
    
    // Konstruktor
    public ReportGenerator() {
        orderController = new OrderController();
    }
    
    // Method
    public void generate(String month, String year, String fileName, String fileLocation) throws FileNotFoundException, IOException {
        Cell cell;
        CellStyle style;
        FileOutputStream out;
        int countDays = countDays(month, year), totalColumn = 24, totalValue;
        String[] tableHeaders, tableElements;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(month.toUpperCase() + "_" + year.substring(year.length() - 2, year.length()));
        XSSFRow row;
        
        style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        // Membuat bagian judul
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, totalColumn - 1));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, totalColumn - 1));
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, totalColumn - 1));
        row = sheet.createRow(0);
        cell = row.createCell(0);
        cell.setCellValue("DAILY SALES REPORT");
        cell.setCellStyle(style);
        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue("YAGAMI RAMEN HOUSE DAGO BANDUNG");
        cell.setCellStyle(style);
        row = sheet.createRow(2);
        cell = row.createCell(0);
        cell.setCellValue(month.toUpperCase().substring(0, 3) + "-" + year.substring(year.length() - 2, year.length()));
        cell.setCellStyle(style);
        // Membuat header tabel
        row = sheet.createRow(3);
        tableHeaders = createTableHeaders();
        for (int i = 0; i < totalColumn; i++) {
            cell = row.createCell(i);
            cell.setCellValue(tableHeaders[i]);
            cell.setCellStyle(style);
        }
        // Membuat isi tabel
        for (int i = 0; i < countDays; i++) {
            row = sheet.createRow(i + 4);
            tableElements = createTableElements(i, month, year);
            for (int j = 0; j < totalColumn; j++) {
                cell = row.createCell(j);
                cell.setCellValue(tableElements[j]);
                cell.setCellStyle(style);
            }
        }
        // Membuat footer tabel
        sheet.addMergedRegion(new CellRangeAddress(countDays + 4, countDays + 4, 0, 1));
        row = sheet.createRow(countDays + 4);
        cell = row.createCell(0);
        cell.setCellValue("JUMLAH");
        cell.setCellStyle(style);
        for (char i = 'C'; i < 'W'; i++) {
            totalValue = 0;
            for (int j = 4; j <= countDays + 3; j++) {
                row = sheet.getRow(j);
                cell = row.getCell(i - 65);
                if (!cell.getStringCellValue().equals("")) {
                    totalValue += Integer.parseInt(cell.getStringCellValue());
                }
            }
            row = sheet.getRow(countDays + 4);
            cell = row.createCell(i - 65);
            cell.setCellValue(totalValue);
            cell.setCellStyle(style);
        }
        // Save file
        out = new FileOutputStream(fileLocation + "/" + fileName + ".xlsx");
        workbook.write(out);
        out.close();
    }
    
    private int countDays(String month, String year) {
        int countDays;
        switch (month) {
            case "Januari":
            case "Maret":
            case "Mei":
            case "Juli":
            case "Agustus":
            case "Oktober":
            case "Desember":
                countDays = 31;
                break;
            case "April":
            case "Juni":
            case "September":
            case "November":
                countDays = 30;
                break;
            default:
                if (Integer.parseInt(year) % 4 == 0) {
                    countDays = 29;
                } else {
                    countDays = 28;
                }
                break;
        }
        
        return countDays;
    }
    
    private String[] createTableHeaders() {
        String[] headers = new String[24];
        
        headers[0] = "Tanggal";
        headers[1] = "HARI";
        headers[2] = "Target";
        headers[3] = "NET Sales";
        headers[4] = "Discount 5 - 50 %";
        headers[5] = "DISCOUNT REDEEM";
        headers[6] = "Invitation 15% + discount 20%";
        headers[7] = "SALES";
        headers[8] = "PB1";
        headers[9] = "Service Tax";
        headers[10] = "TOTAL SALES";
        headers[11] = "Bank BTN";
        headers[12] = "Kelebihan Uang";
        headers[13] = "Total Uang Setoran";
        headers[14] = "BILL";
        headers[15] = "PAX";
        headers[16] = "SOLD ITEM";
        headers[17] = "Ramen";
        headers[18] = "Nasi";
        headers[19] = "Toping";
        headers[20] = "Snack";
        headers[21] = "Dessert";
        headers[22] = "Minuman";
        headers[23] = "Keterangan";
        
        return headers;
    }
    
    private String[] createTableElements(int row, String month, String year) {
        int monthIndex = getMonthIndex(month) + 1, temp;
        String[] elements = new String[24];
        
        elements[0] = (row + 1) + "-" + month.substring(0, 3) + "-" + year.substring(year.length() - 2, year.length());
        elements[1] = getDay(Integer.toString(row + 1), month, year);
        elements[2] = "0";
        elements[3] = Integer.toString(orderController.countSales(row + 1, monthIndex, Integer.parseInt(year)));
        elements[4] = "0";
        elements[5] = Integer.toString(orderController.countDiscount(row + 1, monthIndex, Integer.parseInt(year)));
        elements[6] = "0";
        elements[7] = Integer.toString(Integer.parseInt(elements[3]) - Integer.parseInt(elements[4]) - Integer.parseInt(elements[5]) - Integer.parseInt(elements[6]));
        elements[8] = Integer.toString(Integer.parseInt(elements[7]) / 10);
        elements[9] = "0";
        elements[10] = Integer.toString(Integer.parseInt(elements[7]) + Integer.parseInt(elements[8]) + Integer.parseInt(elements[9]));
        elements[11] = "0";
        elements[12] = "0";
        elements[13] = Integer.toString(Integer.parseInt(elements[10]) - Integer.parseInt(elements[11]) + Integer.parseInt(elements[12]));
        elements[14] = Integer.toString(orderController.countBill(row + 1, monthIndex, Integer.parseInt(year)));
        elements[15] = Integer.toString(orderController.countPax(row + 1, monthIndex, Integer.parseInt(year)));
        elements[17] = Integer.toString(orderController.countRamenSold(row + 1, monthIndex, Integer.parseInt(year)));
        elements[18] = Integer.toString(orderController.countNasiSold(row + 1, monthIndex, Integer.parseInt(year)));
        elements[19] = Integer.toString(orderController.countToppingSold(row + 1, monthIndex, Integer.parseInt(year)));
        elements[20] = Integer.toString(orderController.countSnackSold(row + 1, monthIndex, Integer.parseInt(year)));
        elements[21] = Integer.toString(orderController.countDessertSold(row + 1, monthIndex, Integer.parseInt(year)));
        elements[22] = Integer.toString(orderController.countMinumanSold(row + 1, monthIndex, Integer.parseInt(year)));
        temp = 0;
        for (int i = 17; i <= 22; i++) {
            temp += Integer.parseInt(elements[i]);
        }
        elements[16] = Integer.toString(temp);
        elements[23] = "";
        
        return elements;
    }
    
    private String getDay(String date, String month, String year) {
        Calendar calendar = Calendar.getInstance();
        int dayIndex, monthIndex;
        String day;
        
        monthIndex = getMonthIndex(month);
        calendar.set(Integer.parseInt(year), monthIndex, Integer.parseInt(date));
        dayIndex = calendar.get(Calendar.DAY_OF_WEEK);
        switch (dayIndex) {
            case 1:
                day = "Minggu";
                break;
            case 2:
                day = "Senin";
                break;
            case 3:
                day = "Selasa";
                break;
            case 4:
                day = "Rabu";
                break;
            case 5:
                day = "Kamis";
                break;
            case 6:
                day = "Jumat";
                break;
            default:
                day = "Sabtu";
                break;
        }
        
        return day;
    }
    
    private int getMonthIndex(String month) {
        int monthIndex;
        
        switch (month) {
            case "Januari":
                monthIndex = 0;
                break;
            case "Maret":
                monthIndex = 2;
                break;
            case "Mei":
                monthIndex = 4;
                break;
            case "Juli":
                monthIndex = 6;
                break;
            case "Agustus":
                monthIndex = 7;
                break;
            case "Oktober":
                monthIndex = 9;
                break;
            case "Desember":
                monthIndex = 11;
                break;
            case "April":
                monthIndex = 3;
                break;
            case "Juni":
                monthIndex = 5;
                break;
            case "September":
                monthIndex = 8;
                break;
            case "November":
                monthIndex = 10;
                break;
            default:
                monthIndex = 1;
                break;
        }
        
        return monthIndex;
    }
}

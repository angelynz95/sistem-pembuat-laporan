/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Database;

/**
 *
 * @author angelynz95
 */
public class OrderController {
    // Atribut
    private Database database;
    
    // Konstruktor
    public OrderController() {
        database = new Database();
    }
    
    // Method
    public int countBill(int date, int month, int year) {
        int countBill = 0;
        
        database.connect(Database.PATH);
        String query =  "SELECT COUNT(*) bill FROM `order` " +
                        "WHERE DAY(waktu) = " + date +
                        " AND MONTH(waktu) = " + month +
                        " AND YEAR(waktu) = " + year + ";";
        ResultSet rs = database.fetchData(query);
        try {
            rs.next();
            countBill = rs.getInt("bill");
            database.closeDatabase();
        } catch (SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countBill;
    }
    
    public int countPax(int date, int month, int year) {
        int countPax = 0;
        
        database.connect(Database.PATH);
        String query =  "SELECT SUM(jumlah_tamu) pax FROM `order` " +
                        "WHERE DAY(waktu) = " + date +
                        " AND MONTH(waktu) = " + month +
                        " AND YEAR(waktu) = " + year + ";";
        ResultSet rs = database.fetchData(query);
        try {
            rs.next();
            countPax = rs.getInt("pax");
            database.closeDatabase();
        } catch (SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countPax;
    }
    
    public int countRamenSold(int date, int month, int year) {
        int countRamen = 0;
        
        database.connect(Database.PATH);
        String query =  "SELECT SUM(jumlah_ramen) ramen FROM (" +
                            "SELECT jumlah_ramen FROM list_ramen " +
                            "NATURAL JOIN `order` " +
                            "WHERE DAY(waktu) = " + date +
                            " AND MONTH(waktu) = " + month +
                            " AND YEAR(waktu) = " + year +
                        ") sold_ramen;";
        ResultSet rs = database.fetchData(query);
        try {
            rs.next();
            countRamen = rs.getInt("ramen");
            database.closeDatabase();
        } catch (SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countRamen;
    }
    
    public int countDiscount(int date, int month, int year) {
        int countDiscount = 0;
        
        database.connect(Database.PATH);
        String query =  "SELECT SUM(potongan) discount FROM `order` " +
                        "WHERE DAY(waktu) = " + date +
                        " AND MONTH(waktu) = " + month +
                        " AND YEAR(waktu) = " + year + ";";
        ResultSet rs = database.fetchData(query);
        try {
            rs.next();
            countDiscount = rs.getInt("discount");
            database.closeDatabase();
        } catch (SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countDiscount;
    }
    
    public int countNasiSold(int date, int month, int year) {
        int countNasi = 0;
        
        database.connect(Database.PATH);
        String query =  "SELECT SUM(jumlah_nasi) nasi FROM (" +
                            "SELECT jumlah_nasi FROM list_nasi " +
                            "NATURAL JOIN `order` " +
                            "WHERE DAY(waktu) = " + date +
                            " AND MONTH(waktu) = " + month +
                            " AND YEAR(waktu) = " + year +
                        ") sold_nasi;";
        ResultSet rs = database.fetchData(query);
        try {
            rs.next();
            countNasi = rs.getInt("nasi");
            database.closeDatabase();
        } catch (SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countNasi;
    }
    
    public int countToppingSold(int date, int month, int year) {
        int countTopping = 0;
        
        database.connect(Database.PATH);
        String query =  "SELECT SUM(jumlah_topping) topping FROM (" +
                            "SELECT jumlah_topping FROM list_topping " +
                            "NATURAL JOIN `order` " +
                            "WHERE DAY(waktu) = " + date +
                            " AND MONTH(waktu) = " + month +
                            " AND YEAR(waktu) = " + year +
                        ") sold_topping;";
        ResultSet rs = database.fetchData(query);
        try {
            rs.next();
            countTopping = rs.getInt("topping");
            database.closeDatabase();
        } catch (SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countTopping;
    }
    
    public int countSnackSold(int date, int month, int year) {
        int countSnack = 0;
        
        database.connect(Database.PATH);
        String query =  "SELECT SUM(jumlah_snack) snack FROM (" +
                            "SELECT jumlah_snack FROM list_snack " +
                            "NATURAL JOIN `order` " +
                            "WHERE DAY(waktu) = " + date +
                            " AND MONTH(waktu) = " + month +
                            " AND YEAR(waktu) = " + year +
                        ") sold_snack;";
        ResultSet rs = database.fetchData(query);
        try {
            rs.next();
            countSnack = rs.getInt("snack");
            database.closeDatabase();
        } catch (SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countSnack;
    }
    
    public int countDessertSold(int date, int month, int year) {
        int countDessert = 0;
        
        database.connect(Database.PATH);
        String query =  "SELECT SUM(jumlah_dessert) dessert FROM (" +
                            "SELECT jumlah_dessert FROM list_dessert " +
                            "NATURAL JOIN `order` " +
                            "WHERE DAY(waktu) = " + date +
                            " AND MONTH(waktu) = " + month +
                            " AND YEAR(waktu) = " + year +
                        ") sold_dessert;";
        ResultSet rs = database.fetchData(query);
        try {
            rs.next();
            countDessert = rs.getInt("dessert");
            database.closeDatabase();
        } catch (SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countDessert;
    }
    
    public int countMinumanSold(int date, int month, int year) {
        int countMinuman = 0;
        
        database.connect(Database.PATH);
        String query =  "SELECT SUM(jumlah_minuman) minuman FROM (" +
                            "SELECT jumlah_minuman FROM list_minuman " +
                            "NATURAL JOIN `order` " +
                            "WHERE DAY(waktu) = " + date +
                            " AND MONTH(waktu) = " + month +
                            " AND YEAR(waktu) = " + year +
                        ") sold_minuman;";
        ResultSet rs = database.fetchData(query);
        try {
            rs.next();
            countMinuman = rs.getInt("minuman");
            database.closeDatabase();
        } catch (SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countMinuman;
    }
    
    private int countRamenSales(int date, int month, int year) {
        int totalRamenSales = 0;
        
        database.connect(Database.PATH);
        String query =  "SELECT id_ramen, jumlah_ramen, harga_ramen FROM (" +
                            "SELECT id_ramen, jumlah_ramen FROM list_ramen " +
                            "NATURAL JOIN `order` " +
                            "WHERE DAY(waktu) = " + date +
                            " AND MONTH(waktu) = " + month +
                            " AND YEAR(waktu) = " + year +
                        ") sold_ramen " +
                        "NATURAL JOIN ramen;";
        ResultSet rs = database.fetchData(query);
        try {
            while (rs.next()) {
                totalRamenSales += rs.getInt("jumlah_ramen") * rs.getInt("harga_ramen");
            }
            database.closeDatabase();
        } catch (SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalRamenSales;
    }
    
    private int countNasiSales(int date, int month, int year) {
        int totalNasiSales = 0;
        
        database.connect(Database.PATH);
        String query =  "SELECT id_nasi, jumlah_nasi, harga_nasi FROM (" +
                            "SELECT id_nasi, jumlah_nasi FROM list_nasi " +
                            "NATURAL JOIN `order` " +
                            "WHERE DAY(waktu) = " + date +
                            " AND MONTH(waktu) = " + month +
                            " AND YEAR(waktu) = " + year +
                        ") sold_nasi " +
                        "NATURAL JOIN nasi;";
        ResultSet rs = database.fetchData(query);
        try {
            while (rs.next()) {
                totalNasiSales += rs.getInt("jumlah_nasi") * rs.getInt("harga_nasi");
            }
            database.closeDatabase();
        } catch (SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalNasiSales;
    }
    
    private int countToppingSales(int date, int month, int year) {
        int totalToppingSales = 0;
        
        database.connect(Database.PATH);
        String query =  "SELECT id_topping, jumlah_topping, harga_topping FROM (" +
                            "SELECT id_topping, jumlah_topping FROM list_topping " +
                            "NATURAL JOIN `order` " +
                            "WHERE DAY(waktu) = " + date +
                            " AND MONTH(waktu) = " + month +
                            " AND YEAR(waktu) = " + year +
                        ") sold_topping " +
                        "NATURAL JOIN topping;";
        ResultSet rs = database.fetchData(query);
        try {
            while (rs.next()) {
                totalToppingSales += rs.getInt("jumlah_topping") * rs.getInt("harga_topping");
            }
            database.closeDatabase();
        } catch (SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalToppingSales;
    }
    
    private int countSnackSales(int date, int month, int year) {
        int totalSnackSales = 0;
        
        database.connect(Database.PATH);
        String query =  "SELECT id_snack, jumlah_snack, harga_snack FROM (" +
                            "SELECT id_snack, jumlah_snack FROM list_snack " +
                            "NATURAL JOIN `order` " +
                            "WHERE DAY(waktu) = " + date +
                            " AND MONTH(waktu) = " + month +
                            " AND YEAR(waktu) = " + year +
                        ") sold_snack " +
                        "NATURAL JOIN snack;";
        ResultSet rs = database.fetchData(query);
        try {
            while (rs.next()) {
                totalSnackSales += rs.getInt("jumlah_snack") * rs.getInt("harga_snack");
            }
            database.closeDatabase();
        } catch (SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalSnackSales;
    }
    
    private int countDessertSales(int date, int month, int year) {
        int totalDessertSales = 0;
        
        database.connect(Database.PATH);
        String query =  "SELECT id_dessert, jumlah_dessert, harga_dessert FROM (" +
                            "SELECT id_dessert, jumlah_dessert FROM list_dessert " +
                            "NATURAL JOIN `order` " +
                            "WHERE DAY(waktu) = " + date +
                            " AND MONTH(waktu) = " + month +
                            " AND YEAR(waktu) = " + year +
                        ") sold_dessert " +
                        "NATURAL JOIN dessert;";
        ResultSet rs = database.fetchData(query);
        try {
            while (rs.next()) {
                totalDessertSales += rs.getInt("jumlah_dessert") * rs.getInt("harga_dessert");
            }
            database.closeDatabase();
        } catch (SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalDessertSales;
    }
    
    private int countMinumanSales(int date, int month, int year) {
        int totalMinumanSales = 0;
        
        database.connect(Database.PATH);
        String query =  "SELECT id_minuman, jumlah_minuman, harga_minuman FROM (" +
                            "SELECT id_minuman, jumlah_minuman FROM list_minuman " +
                            "NATURAL JOIN `order` " +
                            "WHERE DAY(waktu) = " + date +
                            " AND MONTH(waktu) = " + month +
                            " AND YEAR(waktu) = " + year +
                        ") sold_minuman " +
                        "NATURAL JOIN minuman;";
        ResultSet rs = database.fetchData(query);
        try {
            while (rs.next()) {
                totalMinumanSales += rs.getInt("jumlah_minuman") * rs.getInt("harga_minuman");
            }
            database.closeDatabase();
        } catch (SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalMinumanSales;
    }
    
    public int countSales(int date, int month, int year) {
        int countSales = 0;
        
        countSales += countRamenSales(date, month, year);
        countSales += countNasiSales(date, month, year);
        countSales += countToppingSales(date, month, year);
        countSales += countSnackSales(date, month, year);
        countSales += countDessertSales(date, month, year);
        countSales += countMinumanSales(date, month, year);
        
        return countSales;
    }
}
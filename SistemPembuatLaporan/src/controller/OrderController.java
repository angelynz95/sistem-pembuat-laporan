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
        String query =  "SELECT COUNT(*) count_bill FROM `order` " +
                        "WHERE DAY(waktu) = " + date +
                        " AND MONTH(waktu) = " + month +
                        " AND YEAR(waktu) = " + year + ";";
        ResultSet rs = database.fetchData(query);
        try {
            rs.next();
            countBill = rs.getInt("count_bill");
            database.closeDatabase();
        } catch (SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countBill;
    }
}

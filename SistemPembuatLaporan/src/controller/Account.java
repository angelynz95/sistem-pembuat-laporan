/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William Sentosa
 */
public class Account {
    private Database database;
    
    public Account() {
        database = new Database();
    }
    
    public boolean validateLogin(char[] password) {
        database.connect(Database.PATH);
        String query = "SELECT password FROM akun;";
        ResultSet rs = database.fetchData(query);
        try {
            rs.next();
            String db = rs.getString("password");
            char[] dbPassword = db.toCharArray();
            database.closeDatabase();
            if (dbPassword.length != password.length) {
                return false;
            } else {
                return Arrays.equals(dbPassword, password);
            }
        } catch (SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // Menangani pengubahan password
    public void changePassword(String newPassword) {
        database.connect(Database.PATH);
        String query = "UPDATE akun SET password = '" + newPassword + "';";
        database.changeData(query);
        database.closeDatabase();
    }
}

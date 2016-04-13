/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William Sentosa
 */
public class Ramen {
    private int id;
    private String nama;
    private long harga;
    
    public Ramen() {
        id = 0;
        nama = "";
        harga = 0;
    }
    
    public Ramen(int id, String nama, long harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNama() {
        return nama;
    }
    
    public long getHarga() {
        return harga;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public void setHarga(long harga) {
        this.harga = harga;
    }
    
    public void findById(int id) {
        Database database = new Database();
        database.connect(Database.PATH);
        String query = "SELECT * FROM ramen where id_ramen = " + id;
        ResultSet rs = database.fetchData(query);
        try {
            rs.next();
            this.id = rs.getInt("id_ramen");
            this.nama = rs.getString("nama_ramen");
            this.harga = rs.getLong("harga_ramen");
            database.closeDatabase();
        } catch (SQLException ex) {
            database.closeDatabase();
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

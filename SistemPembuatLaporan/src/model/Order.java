/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author William Sentosa
 */
public class Order {
    private int id;
    private String namaTamu;
    private int jumlahTamu;
    private Calendar waktu;
    private ArrayList<List_Dessert> listDessert;
    private ArrayList<List_Minuman> listMinuman;
    private ArrayList<List_Nasi> listNasi;
    private ArrayList<List_Ramen> listRamen;
    private ArrayList<List_Snack> listSnack;
    private ArrayList<List_Topping> listTopping;
    
    public Order() {
        id = 0;
        namaTamu = "";
        jumlahTamu = 0;
        waktu = null;
        listDessert = new ArrayList<>();
        listMinuman = new ArrayList<>();
        listNasi = new ArrayList<>();
        listRamen = new ArrayList<>();
        listSnack = new ArrayList<>();
        listTopping = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }
    
    public String getNamaTamu() {
        return namaTamu;
    }
    
    public int getJumlahTamu() {
        return jumlahTamu;
    }
    
    public Calendar getWaktu() {
        return waktu;
    }
    
    public ArrayList<List_Dessert> getListDessert() {
        return listDessert; 
    }
    
    public ArrayList<List_Minuman> getListMinuman() {
        return listMinuman; 
    }
    
    public ArrayList<List_Nasi> getListNasi() {
        return listNasi; 
    }
    
    public ArrayList<List_Ramen> getListRamen() {
        return listRamen; 
    }
    
    public ArrayList<List_Snack> getListSnack() {
        return listSnack; 
    }
    
    public ArrayList<List_Topping> getListTopping() {
        return listTopping; 
    }
    
    public void findById(int id) {
        
    }
    
    public void findByDate(Calendar date) {
        
    }
    
}

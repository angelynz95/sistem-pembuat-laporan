/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author William Sentosa
 */
public class List_Nasi {
    private int amount;
    private Nasi nasi;
    
    public List_Nasi() {
        amount = 0;
        nasi = new Nasi();
    }
    
    public int getAmount() {
        return amount;
    }
    
    public Nasi getNasi() {
        return nasi;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void setNasi(Nasi nasi) {
        this.nasi = nasi;
    }
    
}

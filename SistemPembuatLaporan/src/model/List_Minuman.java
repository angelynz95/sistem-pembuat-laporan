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
public class List_Minuman {
    private int amount;
    private Minuman minuman;
    
    public List_Minuman() {
        amount = 0;
        minuman = new Minuman();
    }
    
    public int getAmount() {
        return amount;
    }
    
    public Minuman getMinuman() {
        return minuman;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void setMinuman(Minuman minuman) {
        this.minuman = minuman;
    }
    
}

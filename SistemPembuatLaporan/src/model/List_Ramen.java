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
public class List_Ramen {
    private int amount;
    private Ramen ramen;
    
    public List_Ramen() {
        amount = 0;
        ramen = new Ramen();
    }
    
    public int getAmount() {
        return amount;
    }
    
    public Ramen getRamen() {
        return ramen;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void setRamen(Ramen ramen) {
        this.ramen = ramen;
    }
    
}

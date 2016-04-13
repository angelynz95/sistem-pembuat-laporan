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
    private Dessert dessert;
    
    public List_Minuman() {
        amount = 0;
        dessert = new Dessert();
    }
    
    public int getAmount() {
        return amount;
    }
    
    public Dessert getDessert() {
        return dessert;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }
    
}

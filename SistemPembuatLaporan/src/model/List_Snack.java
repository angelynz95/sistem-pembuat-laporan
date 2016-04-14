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
public class List_Snack {
    private int amount;
    private Snack snack;
    
    public List_Snack() {
        amount = 0;
        snack = new Snack();
    }
    
    public int getAmount() {
        return amount;
    }
    
    public Snack getSnack() {
        return snack;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void setSnack(Snack snack) {
        this.snack = snack;
    }
    
}

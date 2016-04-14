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
public class List_Topping {
    private int amount;
    private Topping topping;
    
    public List_Topping() {
        amount = 0;
        topping = new Topping();
    }
    
    public int getAmount() {
        return amount;
    }
    
    public Topping getTopping() {
        return topping;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void setTopping(Topping topping) {
        this.topping = topping;
    }
    
}

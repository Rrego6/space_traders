/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sarah
 */
public class Inventory{ 
    private String name;
    private ArrayList<TradeGood> tradeGoods;
    private int numGoods;
    private int totalSpace;
    
    public Inventory(String name) {
        this.name = name;
        this.numGoods = 0;
        tradeGoods = new ArrayList<TradeGood>();
    }
    
    public Inventory(String name, int totalSpace) {
        this.name = name;
        this.numGoods = 0;
        this.totalSpace = totalSpace;
        tradeGoods = new ArrayList<TradeGood>();
    }
    
    public void setName(String name) { //setter mathod. 
        this.name = name;
    }
    
    public void addTradeGood( List<TradeGood> list ) {
        if (!this.isFull()) {
            for (TradeGood a : list) {
                this.addTradeGood(a);
            }
        }
    }
        
    public void addTradeGood(TradeGood a) {
        if (!this.isFull()) {
            boolean itemFound = false;
            for (TradeGood good : tradeGoods) {
                if (good.getName().equals(a.getName())) {
                    itemFound = true;
                    good.add(1);
                    this.incrementNumGoods();
                }
            }
            if (!itemFound) {
                tradeGoods.add(a);
                this.incrementNumGoods();
            }
        }
    }
   
    public void removeTradeGood(TradeGood a) {
        boolean itemFound = false;
        for (TradeGood good : tradeGoods) {
            if (good.getName().equals(a.getName())) {
                if (good.getQuantity() > 0) {
                    itemFound = true;
                    good.remove(1);
                    this.decrementNumGoods();
                } else {
                    System.out.println("The Cargo Hold does not have this good."); //If quantity = 0
                }
            }
        }
        if (!itemFound) {
            System.out.println("The Cargo Hold does not have this good."); //If item not found
        }
    }
    
    /*@param:none.
    @return: name variable value.
    */ 
    public String getName() {  //getter method.
        return this.name;
    }
    
    public ArrayList<TradeGood> getList() {  //getter method.
        return this.tradeGoods;
    }
    
    private void incrementNumGoods() {
        this.numGoods++;
    }
    
    private void decrementNumGoods() {
        this.numGoods--;
    }
    
    private boolean isFull() {
        return numGoods == totalSpace;
    }
    
    @Override
    public String toString()
    {
        String string = new String();
        for( TradeGood tradeGood : tradeGoods ) {
            string += (tradeGood.toString() + "\n" );
        }
        return "Inventory: " + name + " " + string;
    }
}

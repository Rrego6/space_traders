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
    private ArrayList<OriginalTradeGood> tradeGoods;
    private int[] numGoodsList;
    private int numGoods;
    private int totalSpace;
    private int maxSpace;
    private int numWater;
    private int numFurs;
    private int numFood;
    private int numOre;
    private int numGames;
    private int numFirearms;
    private int numMedicine;
    private int numMachines;
    private int numNarcotics;
    private int numRobots;
    
    public Inventory(int maxSpace) {
        numWater = 0;
        numFurs = 0;
        numFood = 0;
        numOre = 0;
        numGames = 0;
        numFirearms = 0;
        numMedicine = 0;
        numMachines = 0;
        numNarcotics = 0;
        numRobots = 0;
        numGoodsList = new int[10];
        this.maxSpace = maxSpace;
    }
    
    public void setName(String name) { //setter mathod. 
        this.name = name;
    }
    
    /*@param:none.
    @return: name variable value.
    */ 
    public String getName() {  //getter method.
        return this.name;
    }
    
    public int getTotalSpace() {
        return maxSpace - numWater - numFurs - numFood - numOre - numGames - numFirearms - numMedicine - numMachines - numNarcotics - numRobots;
    }
    
    public int getMaxSpace() {
        return maxSpace;
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
    
    public void setNumGoodsList(int[] list) {
        numGoodsList = list;
        numWater = numGoodsList[0];
        numFurs = numGoodsList[1];
        numFood = numGoodsList[2];
        numOre = numGoodsList[3];
        numGames = numGoodsList[4];
        numFirearms = numGoodsList[5];
        numMedicine = numGoodsList[6];
        numMachines = numGoodsList[7];
        numNarcotics = numGoodsList[8];
        numRobots = numGoodsList[9];
        
    }
    
    public void addNumGoodsList(int[] list) {
        numWater += list[0];
        numFurs += list[1];
        numFood += list[2];
        numOre += list[3];
        numGames += list[4];
        numFirearms += list[5];
        numMedicine += list[6];
        numMachines += list[7];
        numNarcotics += list[8];
        numRobots += list[9];
    }
    
    public int[] getNumGoodsList() {
        return numGoodsList;
    }
    
    public void setNumWater(int numWater) {
        this.numWater = numWater;
    }
    
    public int getNumWater() {
        return numWater;
    }
    
    public void setNumFurs(int numFurs) {
        this.numFurs = numFurs;
    }
    
    public int getNumFurs() {
        return numFurs;
    }
    
    public void setNumFood(int numFood) {
        this.numFood = numFood;
    }
    
    public int getNumFood() {
        return numFood;
    }
    
    public void setNumOre(int numOre) {
        this.numOre = numOre;
    }
    
    public int getNumOre() {
        return numOre;
    }
    
    public void setNumGames(int numGames) {
        this.numGames = numGames;
    }
    
    public int getNumGames() {
        return numGames;
    }
    
    public void setNumFirearms(int numFirearms) {
        this.numFirearms = numFirearms;
    }
    
    public int getNumFirearms() {
        return numFirearms;
    }
    
    public void setNumMedicine(int numMedicine) {
        this.numMedicine = numMedicine;
    }
    
    public int getNumMedicine() {
        return numMedicine;
    }
    
    public void setNumMachines(int numMachines) {
        this.numMachines = numMachines;
    }
    
    public int getNumMachines() {
        return numMachines;
    }
    
    public void setNumNarcotics(int numNarcotics) {
        this.numNarcotics = numNarcotics;
    }
    
    public int getNumNarcotics() {
        return numNarcotics;
    }
    
    public void setNumRobots(int numRobots) {
        this.numRobots = numRobots;
    }
    
    public int getNumRobots() {
        return numRobots;
    }
    
    @Override
    public String toString()
    {
        String string = new String();
        for( OriginalTradeGood tradeGood : tradeGoods ) {
            string += (tradeGood.toString() + "\n" );
        }
        return "Inventory: " + name + " " + string;
    }
}

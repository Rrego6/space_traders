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
    
    /**
     *
     * @param maxSpace
     */
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
        this.maxSpace = maxSpace;
    }
    
    /**
     *
     * @param name
     */
    public void setName(String name) { //setter mathod. 
        this.name = name;
    }
    
    /**
     *
     * @return
     */
     
    public String getName() {  //getter method.
        return this.name;
    }
    
    /**
     *
     * @return
     */
    public int getTotalSpace() {
        return maxSpace - numWater - numFurs - numFood - numOre - numGames - numFirearms - numMedicine - numMachines - numNarcotics - numRobots;
    }
    
    /**
     *
     * @return
     */
    public int getMaxSpace() {
        return maxSpace;
    }
    public void increaseMaxSpace(int i){
        maxSpace += 5;
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
    
    /**
     *
     * @param numWater
     */
    public void setNumWater(int numWater) {
        this.numWater = numWater;
    }
    
    /**
     *
     * @return
     */
    public int getNumWater() {
        return numWater;
    }
    
    /**
     *
     * @param numFurs
     */
    public void setNumFurs(int numFurs) {
        this.numFurs = numFurs;
    }
    
    /**
     *
     * @return
     */
    public int getNumFurs() {
        return numFurs;
    }
    
    /**
     *
     * @param numFood
     */
    public void setNumFood(int numFood) {
        this.numFood = numFood;
    }
    
    /**
     *
     * @return
     */
    public int getNumFood() {
        return numFood;
    }
    
    /**
     *
     * @param numOre
     */
    public void setNumOre(int numOre) {
        this.numOre = numOre;
    }
    
    /**
     *
     * @return
     */
    public int getNumOre() {
        return numOre;
    }
    
    /**
     *
     * @param numGames
     */
    public void setNumGames(int numGames) {
        this.numGames = numGames;
    }
    
    /**
     *
     * @return
     */
    public int getNumGames() {
        return numGames;
    }
    
    /**
     *
     * @param numFirearms
     */
    public void setNumFirearms(int numFirearms) {
        this.numFirearms = numFirearms;
    }
    
    /**
     *
     * @return
     */
    public int getNumFirearms() {
        return numFirearms;
    }
    
    /**
     *
     * @param numMedicine
     */
    public void setNumMedicine(int numMedicine) {
        this.numMedicine = numMedicine;
    }
    
    /**
     *
     * @return
     */
    public int getNumMedicine() {
        return numMedicine;
    }
    
    /**
     *
     * @param numMachines
     */
    public void setNumMachines(int numMachines) {
        this.numMachines = numMachines;
    }
    
    /**
     *
     * @return
     */
    public int getNumMachines() {
        return numMachines;
    }
    
    /**
     *
     * @param numNarcotics
     */
    public void setNumNarcotics(int numNarcotics) {
        this.numNarcotics = numNarcotics;
    }
    
    /**
     *
     * @return
     */
    public int getNumNarcotics() {
        return numNarcotics;
    }
    
    /**
     *
     * @param numRobots
     */
    public void setNumRobots(int numRobots) {
        this.numRobots = numRobots;
    }
    
    /**
     *
     * @return
     */
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

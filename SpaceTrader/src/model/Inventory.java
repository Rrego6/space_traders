/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Sarah
 * @version 1.0
 */
public class Inventory {

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
     * makes the inventory with max space
     *
     * @param maxSpace the maximum space
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
     * sets the name of the inventory
     *
     * @param name the name of inventory
     */
    public void setName(String name) { //setter mathod.
        this.name = name;
    }

    /**
     * gets the name
     *
     * @return the name
     */
    public String getName() {  //getter method.
        return this.name;
    }

    /**
     * gets the total space left
     *
     * @return the total space
     */
    public int getTotalSpace() {
        return maxSpace - numWater - numFurs - numFood - numOre - numGames
            - numFirearms - numMedicine - numMachines - numNarcotics
            - numRobots;
    }

    /**
     * get the max space
     *
     * @return maxSpace the maximum space
     */
    public int getMaxSpace() {
        return maxSpace;
    }

    /**
     * increases the max space
     *
     * @param i the int to increase space by
     */
    public void increaseMaxSpace(int i) {
        maxSpace += 5;
    }

    /**
     * increments the goods
     */
    private void incrementNumGoods() {
        this.numGoods++;
    }

    /**
     * decrements the goods
     */
    private void decrementNumGoods() {
        this.numGoods--;
    }

    /**
     * checks to see if goods are full
     */
    private boolean isFull() {
        return numGoods == totalSpace;
    }

    /**
     * sets the water
     *
     * @param numWater the amount of water
     */
    public void setNumWater(int numWater) {
        this.numWater = numWater;
    }

    /**
     * gets the water
     *
     * @return the amount of water
     */
    public int getNumWater() {
        return numWater;
    }

    /**
     * sets the number of furs
     *
     * @param numFurs the number of furs
     */
    public void setNumFurs(int numFurs) {
        this.numFurs = numFurs;
    }

    /**
     * gets the number of furs
     *
     * @return the number of furs
     */
    public int getNumFurs() {
        return numFurs;
    }

    /**
     * sets the number of food
     *
     * @param numFood the number of food
     */
    public void setNumFood(int numFood) {
        this.numFood = numFood;
    }

    /**
     * gets the number of food
     *
     * @return the number of food
     */
    public int getNumFood() {
        return numFood;
    }

    /**
     * sets the number of ore
     *
     * @param numOre the number of ore
     */
    public void setNumOre(int numOre) {
        this.numOre = numOre;
    }

    /**
     * gets the number of ore
     *
     * @return the number of ore
     */
    public int getNumOre() {
        return numOre;
    }

    /**
     * sets the number of games
     *
     * @param numGames the number of games
     */
    public void setNumGames(int numGames) {
        this.numGames = numGames;
    }

    /**
     * gets the number of games
     *
     * @return the number of games
     */
    public int getNumGames() {
        return numGames;
    }

    /**
     * sets the number of firearms
     *
     * @param numFirearms the number of firearms
     */
    public void setNumFirearms(int numFirearms) {
        this.numFirearms = numFirearms;
    }

    /**
     * gets the number of firearms
     *
     * @return the number of firearms
     */
    public int getNumFirearms() {
        return numFirearms;
    }

    /**
     * sets the number of medicine
     *
     * @param numMedicine the number of medicine
     */
    public void setNumMedicine(int numMedicine) {
        this.numMedicine = numMedicine;
    }

    /**
     * gets the number of medicine
     *
     * @return the number of medicine
     */
    public int getNumMedicine() {
        return numMedicine;
    }

    /**
     * sets the number of machines
     *
     * @param numMachines the number of machines
     */
    public void setNumMachines(int numMachines) {
        this.numMachines = numMachines;
    }

    /**
     * gets the number of machines
     *
     * @return the number of machines
     */
    public int getNumMachines() {
        return numMachines;
    }

    /**
     * sets the number of narcotics
     *
     * @param numNarcotics the number of narcotics
     */
    public void setNumNarcotics(int numNarcotics) {
        this.numNarcotics = numNarcotics;
    }

    /**
     * gets the number of narcotics
     *
     * @return the number of narcotics
     */
    public int getNumNarcotics() {
        return numNarcotics;
    }

    /**
     * sets the number of robots
     *
     * @param numRobots the number of robots
     */
    public void setNumRobots(int numRobots) {
        this.numRobots = numRobots;
    }

    /**
     * gets the number of robots
     *
     * @return the number of robots
     */
    public int getNumRobots() {
        return numRobots;
    }

    /**
     * gets the inventory string
     *
     * @return the string of inventory
     */
    @Override
    public String toString() {
        String string = new String();
        for (OriginalTradeGood tradeGood : tradeGoods) {
            string += (tradeGood.toString() + "\n");
        }
        return "Inventory: " + name + " " + string;
    }
}

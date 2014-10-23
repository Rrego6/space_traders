/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import helper.*;
/**
 *
 * @author Ambrose Cheung <cheungambrose30@gmail.com>
 */
public class NPCShip extends Ship {
    
    public NPCShip() {
        maxCargo = 10;
        weaponSlots = 0;
        shieldSlots = 0;
        gadgetSlots = 0;
        crew = 1;
        fuel = 20;
        maxFuel = 20;
        minTechLevel = 4;
        fuelCost = 1;
        price = 2000;
        bounty = 5;
        hull = 25;
        createCargoHold();
    }
    
    public void createCargoHold() {
        cargoHold = new Inventory(maxCargo);
        int[] numCargo = cargoHold.getNumGoodsList();
        for(int i = 0; i < numCargo.length; i++) {
            //if(cargoHold.getTotalSpace() < cargoHold.getMaxSpace()) {
                numCargo[i] = CommonHelper.randInt(this.cargoHold.getTotalSpace());
            //}
        }
        cargoHold.setNumGoodsList(numCargo);
    }
}

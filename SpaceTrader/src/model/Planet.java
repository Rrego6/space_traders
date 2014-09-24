/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Ivan
 */
public class Planet {
    
    private String name;
    
    public Planet(String name) {
        this.name = name;
    }
    /*@param:name of the planet, String.
    @return: none,sets the name variable.
    */
    public void setName(String name) { //setter mathod. 
        this.name = name;
    }
    /*@param:none.
    @return: name of the planet, String.
    */
    public String getName() {  //getter method.
        return name;
    }
}

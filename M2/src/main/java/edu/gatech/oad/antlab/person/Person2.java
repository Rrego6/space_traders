package edu.gatech.oad.antlab.person;
import java.util.Random;

/**
 *  A simple class for person 2
 *  returns their name and a
 *  modified string 
 *
 * @author Ambrose Cheung
 * @version 1.1
 */
public class Person2 {
    /** Holds the persons real name */
    private String name;
    private Random rng = new Random();
	 	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
	 public Person2(String pname) {
	   name = "Ambrose Cheung";
	 }
	/**
	 * This method should take the string
	 * input and return its characters in
	 * random order.
	 * given "gtg123b" it should return
	 * something like "g3tb1g2".
	 *
	 * @param input the string to be modified
	 * @return the modified string
	 */
	private String calc(String input) {
	  //Person 2 put your implementation here
          String rearranged = "";
          int i = input.length();
          while(i > 0) {
              int random = rng.nextInt(i);
              char replaced = input.charAt(random);
              rearranged = rearranged + replaced;
              input = input.substring(0, random) + input.substring(random+1);
              i--;
          }
	  return rearranged;
	}
	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the 
	 *         object
	 */
	public String toString(String input) {
	  return name + calc("acheung30");
	}
}

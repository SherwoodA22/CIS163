package Project1;

import java.io.*;
import java.util.*;

/**
 *
 * The purpose this class is to simulate a change Jar.
 *
 *
 * 	 NOTE: MUCH MORE CODING IS NEEDED IN THESE METHODS, and you
 * 	 will need to comply with the Java Style Guide.
 * 	 HOWEVER,  HERE IS SOME STARTING CODE.
 *
 * @author Alek Sherwood and Matt B
 */

public class ChangeJar {


    /** The number of quarters in the current Jar */
    private int quarters;

    /** The number of dimes in the current Jar */
    private int dimes;

    // Now you do the rest of the instance variables using the
    // Java Style guide.
    /** The number of nickels in the current Jar */
    private int nickels;
    /** The number of pennies in the current Jar */
    private int pennies;
    /** An on off switch for the Jar */
    private static boolean mutate = true;

    /******************************************************************
     *  The is the default constuctor for ChangeJar
     */

    public ChangeJar() {
        quarters = 0;
        dimes = 0;
        nickels = 0;
        pennies = 0;
    }

    /******************************************************************
     *
     *   This constructor creates a Change Jar from an existing
     *    Change Jar.
     *
     * @param other is an existing Change Jar
     */

    public ChangeJar(ChangeJar other) {
        if(other.quarters >=0 && other.dimes>=0) {
            quarters = other.quarters;
            dimes = other.dimes;
        } else {
            throw new IllegalArgumentException();
        }
        if(other.nickels>=0 && other.pennies>=0) {
            nickels = other.nickels;
            pennies = other.pennies;
        } else{
            throw new IllegalArgumentException();
        }
    }

    /******************************************************************
     *
     *   This constructor creates a Change Jar from with some
     *   initial values for Quarters, Dimes, Nickels, and Pennies.
     **
     * @param quarters is the number of quarters to start with.
     * @param dimes is the number of dimes to start with.
     * @param nickels is the number of nicels to start with.
     * @param pennies is the number of pennies to start with.
     *
     */
    public ChangeJar(int quarters, int dimes, int nickels, int pennies) {
        super();

        if (quarters < 0||dimes<0 ||nickels < 0|| pennies<0)
            throw new IllegalArgumentException();

        this.quarters = quarters;
        this.dimes = dimes;
        this.nickels = nickels;
        this.pennies = pennies;
    }

    /******************************************************************
     *
     *      This constructor creates a Change Jar from a given
     *      amount of change.
     *
     * @param amount is a given change amount.
     */

    public ChangeJar(double amount) {
        if(amount>=0){
            double amt = amount * 100;
            quarters = (int) amt / 25;
            amt = amt % 25;
            dimes = (int) amt / 10;
            amt = amt % 10;
            nickels = (int) amt / 5;
            amt = amt % 10;
            pennies = (int) amt;
        }else{
            throw new IllegalArgumentException();
        }

    }

    /******************************************************************
     *
     *      Creates a ChangeJar using the change from a
     *      given string.
     *
     * @param amount is a given change amount in a string.
     */

    public ChangeJar(String amount) {
        boolean letter = false;
        for(int i = 0; i<amount.length(); i++){
            if(Character.isLetter(amount.charAt(i)))
                letter = true;
        }

        int temp = amount.indexOf(".");
        if(temp == amount.length()-1||amount.length()-temp >3||letter) {
            throw new IllegalArgumentException();
        }

        double amt = Double.parseDouble(amount);
        amt = amt * 100;
        quarters = (int) amt/25;
        amt = amt%25;
        dimes = (int) amt/10;
        amt = amt%10;
        nickels = (int) amt/5;
        amt = amt%10;
        pennies = (int) amt;
    }

// REMEBER to use the Java Style Guide for the rest of your code.

    /******************************************************************
     *
     *      Converts all coins into pennies from a given
     *      ChangeJar.
     *
     * @param temp a ChangeJar.
     * @return returns the number of pennies.
     */

    private static int convertToPennies (ChangeJar temp) {
        return (temp.quarters * 25) + (temp.dimes * 10) + (temp.nickels * 5) + temp.pennies;
    }

    /******************************************************************
     *
     *      Is an on/off switch for all of the mutate methods.
     *
     * @param on the status of the on/off switch for the ChangeJars.
     */

    public static void mutate(boolean on) {
        mutate = on;
    }

    /******************************************************************
     *
     *      Checks whether or not the ChangeJar in the parameter
     *      is equal to the "this" ChangeJar.
     *
     * @param other is a ChangeJar.
     * @return returns whether or not the ChangeJars are equal.
     */

    public boolean equals(ChangeJar other) {
        if(other.getAmount()<0||this.getAmount()<0) {
            throw new IllegalArgumentException();
        }
            if (this.getAmount() == other.getAmount()) {
                return true;
            } else {
                return false;
            }
    }

    /******************************************************************
     *
     *      Checks whether or not the given object in the parameter
     *      is equal to the "this" ChangeJar.
     *
     * @param other is an object.
     * @return returns whether the ChangeJars are equal.
     */

    public boolean equals(Object other) {
        if(other != null){
            if(other instanceof ChangeJar){
                ChangeJar temp = (ChangeJar) other;
                if(temp.getAmount()<0||this.getAmount()<0)
                    throw new IllegalArgumentException();
                if(temp.getAmount() == this.getAmount())
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    /******************************************************************
     *
     *      Checks whether or not the two ChangeJars in the
     *      parameters are equal.
     *
     * @param jar1 Is a ChangeJar.
     * @param jar2 Is a second ChangeJar.
     * @return returns if the ChangeJars are equal or not.
     */

    public static boolean equals(ChangeJar jar1, ChangeJar jar2) {
        if(jar1.getAmount()<0 || jar2.getAmount()<0){
            throw new IllegalArgumentException();
        }
        if(jar1.getAmount() == jar2.getAmount())
            return true;
        else
            return false;
    }

    /******************************************************************
     *
     *      Compares the "this" ChangeJar with the ChangeJar
     *      in the parameter.
     *
     * @param other is a ChangeJar.
     * @return returns whether the ChangeJars are equal or if one is higher.
     */

    public int compareTo(ChangeJar other) {
        if(other.getAmount()<0){
            throw new IllegalArgumentException();
        }
        if(this.getAmount() > other.getAmount())
            return 1;
        else if(this.getAmount() < other.getAmount())
            return -1;
        else
            return 0;
    }

    /******************************************************************
     *
     *      Compares the two ChangeJars in the parameters.
     *
     * @param jar1 is a ChangeJar.
     * @param jar2 is a second ChangeJar
     * @return returns whether the ChangeJars are equal or if one is higher.
     */

    public static int compareTo(ChangeJar jar1, ChangeJar jar2)  {
        if(jar1.getAmount()<0 || jar2.getAmount()<0){
            throw new IllegalArgumentException();
        }
        if(jar1.getAmount() > jar2.getAmount())
            return 1;
        else if(jar1.getAmount() < jar2.getAmount())
            return -1;
        else
            return 0;
    }

    /******************************************************************
     *
     *      Takes out the coins specified in the parameters from
     *      the "this" ChangeJar.
     *
     * @param quarters the amount of quarters to take out.
     * @param dimes the amount of dimes to take out.
     * @param nickels the amount of nickels to take out.
     * @param pennies the amount of pennies to take out.
     */

    public void takeOut(int quarters, int dimes, int nickels, int pennies) {
        if(mutate) {
            if (quarters < 0 || dimes < 0 || nickels < 0 || pennies < 0)
                throw new IllegalArgumentException();
            if (this.quarters < quarters || this.dimes < dimes)
                throw new IllegalArgumentException();

            if(this.nickels < nickels || this.pennies < pennies)
                throw new IllegalArgumentException();

                this.quarters -= quarters;
                this.dimes -= dimes;
                this.nickels -= nickels;
                this.pennies -= pennies;

        }else{
            throw new IllegalArgumentException();
        }

    }

    /******************************************************************
     *
     *     Takes out the coins from the "this" ChangeJar with the
     *     amount specified by the ChangeJar parameter.
     *
     * @param other is a ChangeJar.
     */

    public void takeOut(ChangeJar other) {
        if(mutate) {
            if (other.getAmount() < 0)
                throw new IllegalArgumentException();

            if (this.quarters < other.quarters || this.dimes < other.dimes)
                    throw new IllegalArgumentException();

            if(this.nickels < other.nickels || this.pennies < other.pennies)
                    throw new IllegalArgumentException();

                this.quarters -= other.quarters;
                this.dimes -= other.dimes;
                this.nickels -= other.nickels;
                this.pennies -= other.pennies;

        }else{
            throw new IllegalArgumentException();
        }
    }

    /******************************************************************
     *
     *      Takes out the coins from the "this" ChangeJar
     *      from a given amount of change in the parameters.
     *
     * @param amount an amount of change.
     * @return returns
     */

    public ChangeJar takeOut (double amount) {
        if(mutate) {
            if(this.getAmount()<amount||amount<0) {
                throw new IllegalArgumentException();
            }
            int quarters = 0;
            int dimes = 0;
            int nickels = 0;
            int pennies = 0;

              double amt = amount * 100;
              int total = 0;
                  for(quarters = this.quarters; quarters >=0&&total!=amt; quarters--){
                      total = quarters*25;
                      if(total!=amt){
                      for(dimes = this.dimes; dimes>=0&&total!=amt; dimes--) {
                          total = quarters * 25;
                          total += dimes * 10;
                          if (total != amt) {
                              for (nickels = this.nickels; nickels >= 0 && total != amt; nickels--) {
                                  total = quarters * 25 + dimes * 10;
                                  total += nickels * 5;
                                  if(total!=amt) {
                                      for (pennies = this.pennies; pennies >= 0 && total != amt; pennies--) {
                                          total = quarters * 25 + dimes * 10 + nickels * 5;
                                          total += pennies;
                                      }
                                  }
                              }
                          }
                      }
                      }
                  }

                    this.quarters -=quarters+1;
                    this.dimes-=dimes+1;
                    this.nickels -= nickels+1;
                    this.pennies-= pennies+1;
                    ChangeJar rtn = new ChangeJar(quarters+1,dimes+1,nickels+1,pennies+1);
                    return rtn;
        }else{
            throw new IllegalArgumentException();
        }
    }

    /******************************************************************
     *      Decreases the amount of pennies in the "this"
     *      ChangeJar by one.
     */

    public void dec(){
        if(mutate) {
            if (this.pennies > 0)
                this.pennies--;
            else
                throw new IllegalArgumentException();
        }else{
            throw new IllegalArgumentException();
        }
    }

    /******************************************************************
     *     Increases the amount of pennies in the "this"
     *     ChangeJar by one.
     */

    public void inc() {
        if(mutate) {
            this.pennies++;
        }else{
            throw new IllegalArgumentException();
        }
    }

    /******************************************************************
     *
     *      Adds to the "this" ChangeJar by the amount of coins
     *      specified in the parameters.
     *
     * @param quarters the amount of quarters to add.
     * @param dimes the amount of dimes to add.
     * @param nickels the amount of nickels to add.
     * @param pennies the amount of pennies to add.
     */

    public void add(int quarters, int dimes, int nickels, int pennies){
        if(mutate) {
            if (quarters >= 0 && dimes >= 0 && nickels >= 0 && pennies >= 0) {
                this.quarters += quarters;
                this.dimes += dimes;
                this.nickels += nickels;
                this.pennies += pennies;
            } else {
                throw new IllegalArgumentException();
            }
        }else{
            throw new IllegalArgumentException();
        }

    }

    /******************************************************************
     *
     *      Adds to the "this" ChangeJar the amount in the ChangeJar
     *      parameter.
     *
     * @param other a ChangJar with amounts to add to "this" ChangeJar
     */

    public void add(ChangeJar other){
        if(mutate) {
            if (other.quarters < 0 || other.dimes < 0 || other.nickels < 0 || other.pennies < 0)
                throw new IllegalArgumentException();

            this.quarters += other.quarters;
            this.dimes += other.dimes;
            this.nickels += other.nickels;
            this.pennies += other.pennies;
        }else{
            throw new IllegalArgumentException();
        }
    }

    /******************************************************************
     *
     *      Converts the amount of coins in "this" ChangeJar
     *      into a string.
     *
     * @return returns the string of the coins in "this" ChangeJar.
     */

    public String toString() {

        // here is a hint
        String s = this.quarters + " Quarter" + ((quarters != 1) ? "s" : "") + "\n";
        s = s + this.dimes + " Dime" + ((dimes != 1) ? "s" : "") + "\n";
        s = s + this.nickels + " Nickel" + ((nickels != 1) ? "s" : "") + "\n";
        s = s + this.pennies + " Penn" + ((pennies != 1) ? "ies" : "y")+ "\n";
        return s;
    }

    /******************************************************************
     *
     *      Saves the ChangeJar to a file.
     *
     * @param fileName the file to save to.
     */

    public void save(String fileName) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println(this.quarters);
        out.println(this.dimes);
        out.println(this.nickels);
        out.println(this.pennies);
        out.close();
    }

    /******************************************************************
     *
     *      Loads a ChangeJar from a file.
     *
     * @param fileName the file to load from.
     */

    public void load(String fileName) {
if(mutate) {
    Scanner scnr = null;
    try {
        scnr = new Scanner(new File(fileName));
        quarters = scnr.nextInt();
        dimes = scnr.nextInt();
        nickels = scnr.nextInt();
        pennies = scnr.nextInt();

        System.out.println(quarters);
        System.out.println(dimes);
        System.out.println(nickels);
        System.out.println(pennies);

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (Exception error) {
        System.out.println("Oops!  Something went wrong.");
    }
}else{
    throw new IllegalArgumentException();
}
    }

    /******************************************************************
     *
     *      Gets the amount of change in "this" ChangeJar.
     *
     * @return returns the amount of change in "this" ChangeJar.
     */

    public double getAmount () {
        return convertToPennies(this) / 100.0;
    }

    /******************************************************************
     *
     *      The main method.
     *
     * @param args
     */

    public static void main(String[] args) {
        mutate(true);
        ChangeJar s = new ChangeJar("2.82");
        System.out.println("2.82 Amount: \n" + s);

        s = new ChangeJar("8");
        System.out.println("8 Amount: \n" + s);

        s = new ChangeJar(".28");
        System.out.println(".28 Amount: \n" + s);

        ChangeJar s1 = new ChangeJar();
        System.out.println("0 Amount: \n" + s1);

        s1.add(1,1,1,100);
        System.out.println("1,1,1,100 Amount: \n" + s1);

        ChangeJar s2 = new ChangeJar(41.99);
        s2.add(0,0,0,99);
        for(int i = 0; i < 100; i++)
            s2.dec();
        System.out.println("amount: \n" +s2);

        s = new ChangeJar(0,0, 0,5);
        s.dec();
        System.out.println("pennies: \n" + s.getPennies());

        s = new ChangeJar(2,1,0,3);
        s1 = new ChangeJar(1,2,3,4);
        s.add(s1);
        System.out.println("Amount: \n" + s);

        s = new ChangeJar(4,3,5,7);
        s.takeOut(1,2,1,2);
        System.out.println("Amount: \n" + s);

        s = new ChangeJar(4, 5, 5, 5);
        s1 = new ChangeJar(1, 1, 1, 1);
        s.takeOut(s1);
        System.out.println("Amount: \n" + s);

        s = new ChangeJar(1,1,1,1);
        s1 = new ChangeJar(1,1,1,1);
        System.out.println("Result: \n" + s.compareTo(s1));

        s = new ChangeJar(2,1,4,5);
        s1 = new ChangeJar(2,1,1,1);
        System.out.println("Result: \n" + s.compareTo(s1));

        s = new ChangeJar(2,1,0,0);
        s1 = new ChangeJar(2,1,1,1);
        System.out.println("Result: \n" + s.compareTo(s1));

        s = new ChangeJar(1,1,1,1);
        s1 = new ChangeJar(1,1,1,1);
        System.out.println("Result: \n" + compareTo(s, s1));

        s = new ChangeJar(2,1,4,5);
        s1 = new ChangeJar(2,1,1,1);
        System.out.println("Result: \n" + compareTo(s, s1));

        s = new ChangeJar(2,1,0,0);
        s1 = new ChangeJar(2,1,1,1);
        System.out.println("Result: \n" + compareTo(s, s1));

        s = new ChangeJar(2,2,2,2);
        s1 = new ChangeJar(2,2,2,2);
        System.out.println("Result: \n" + s.equals(s1));

        s = new ChangeJar(2,2,2,2);
        s1 = new ChangeJar(2,2,3,2);
        System.out.println("Result: \n" + s.equals(s1));

        s = new ChangeJar(6,1,14,3);
        s1 = new ChangeJar();
        System.out.println("Result: \n" + s.equals(s1));

        s = new ChangeJar(1,2,2,1);
        s1 = new ChangeJar(1,2,2,1);
        System.out.println("Result: \n" + equals(s, s1));

        s = new ChangeJar(2,4,2,1);
        s1 = new ChangeJar(2,4,3,1);
        System.out.println("Result: \n" + equals(s, s1));

        s = new ChangeJar(2,3,1,2);
        s1 = new ChangeJar();
        System.out.println("Result: \n" + equals(s, s1));

        s = new ChangeJar(4,3,0,3);
        s.takeOut(.80);
        System.out.println("Amount: \n" + s);
    }

    /******************************************************************
     *
     *      Gets the amount of quarters in "this" ChangeJar.
     *
     * @return returns quarters in "this" ChangeJar.
     */

    public int getQuarters() {
        return quarters;
    }

    /******************************************************************
     *
     *      Sets the amount of quarters in "this" ChangeJar
     *      to the amount in the parameter.
     *
     *@param quarters amount of quarters to set.
     */

    public void setQuarters(int quarters) {
        if(quarters>=0)
            this.quarters = quarters;
        else
            throw new IllegalArgumentException();
    }

    /******************************************************************
     *
     *      Gets the amount of dimes in "this" ChangeJar.
     *
     * @return returns the amount of dimes in "this" ChangeJar.
     */

    public int getDimes() {
        return dimes;
    }

    /******************************************************************
     *
     *      Sets the amount of dimes in "this" ChangeJar to the
     *      amount in the parameter.
     *
     * @param dimes the dimes to set in "this" ChangeJar.
     */

    public void setDimes(int dimes) {
        if(dimes>=0)
            this.dimes = dimes;
        else
            throw new IllegalArgumentException();
    }

    /******************************************************************
     *
     *      Gets the amount of nickels in "this" ChangeJar.
     *
     * @return returns the amount of nickels in "this" ChangeJar.
     */

    public int getNickels() {
        return nickels;
    }

    /******************************************************************
     *
     *      Sets the amount of nickels in "this" ChangeJar to
     *      the amount in the parameter.
     *
     * @param nickels the amount of nickels to set.
     */

    public void setNickels(int nickels) {
        if(nickels>=0)
            this.nickels = nickels;
        else
            throw new IllegalArgumentException();
    }

    /******************************************************************
     *
     *      Gets the amount of pennies in "this" ChangeJar.
     *
     * @return returns the amount of pennies in "this" ChangeJar.
     */

    public int getPennies() {
        return pennies;
    }

    /******************************************************************
     *
     *      Sets pennies in "this" ChangeJar to the amount
     *      specified in the parameter.
     *
     * @param pennies the amount of pennies to set.
     */

    public void setPennies(int pennies) {
        if(pennies>=0)
            this.pennies = pennies;
        else
            throw new IllegalArgumentException();
    }

}
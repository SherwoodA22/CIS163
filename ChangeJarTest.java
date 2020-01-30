package Project1;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class ChangeJarTest {

    /**
     * Your assignment is to write many more test cases to
     * have a robust testing, more than just 100% coverage.
     * <p>
     * Some examples are provided to help you get started
     */


    // Testing valid constructors with wide range of values
    @Test
    public void testConstructor() {
        ChangeJar.mutate(true);
        ChangeJar jar1 = new ChangeJar(6, 5, 4, 2);

        assertEquals(6, jar1.getQuarters());
        assertEquals(5, jar1.getDimes());
        assertEquals(4, jar1.getNickels());
        assertEquals(2, jar1.getPennies());

        ChangeJar jar2 = new ChangeJar();
        assertEquals(0, jar2.getQuarters());
        assertEquals(0, jar2.getDimes());
        assertEquals(0, jar2.getNickels());
        assertEquals(0, jar2.getPennies());

        ChangeJar jar3 = new ChangeJar(jar1);
        assertEquals(6, jar3.getQuarters());
        assertEquals(5, jar3.getDimes());
        assertEquals(4, jar3.getNickels());
        assertEquals(2, jar3.getPennies());

        ChangeJar jar4 = new ChangeJar(1.23);
        assertEquals(4, jar4.getQuarters());
        assertEquals(2, jar4.getDimes());
        assertEquals(0, jar4.getNickels());
        assertEquals(3,jar4.getPennies());

        ChangeJar jar5 = new ChangeJar("1.23");
        assertEquals(4, jar4.getQuarters());
        assertEquals(2, jar4.getDimes());
        assertEquals(0, jar4.getNickels());
        assertEquals(3,jar4.getPennies());
    }

    //test constructor for false mutate
    @Test(expected = IllegalArgumentException.class)
    public void testFalseConstructor(){
        ChangeJar.mutate(false);
        ChangeJar jar = new ChangeJar();
    }

    //test constructor for false mutate for string
    @Test(expected = IllegalArgumentException.class)
    public void testFalseConstructorString(){
        ChangeJar.mutate(false);
        ChangeJar jar = new ChangeJar("1.00");
    }

    //test constructor for false mutate ChangeJar
    @Test(expected = IllegalArgumentException.class)
    public void testFalseConstructorJar(){
        ChangeJar.mutate(true);
        ChangeJar jar2 = new ChangeJar(1,1,1,1);
        ChangeJar.mutate(false);
        ChangeJar jar = new ChangeJar(jar2);
    }

    //test constructor for false mutate double
    @Test(expected = IllegalArgumentException.class)
    public void testFalseConstructorDouble(){
        ChangeJar.mutate(false);
        ChangeJar jar = new ChangeJar(1.22);
    }

    //test for letter in constructor
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorLetter(){
        ChangeJar.mutate(true);
        new ChangeJar("1.3a");
    }

    //tests for a negative string
    @Test(expected = IllegalArgumentException.class)
    public void testNegString(){
        ChangeJar.mutate(true);
        new ChangeJar("-1.34");
    }

    //test for decimal last in constructor
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorDecimal(){
        ChangeJar.mutate(true);
        new ChangeJar("10.");
    }

    //test for three or more digits after decimal
    @Test(expected = IllegalArgumentException.class)
    public void testDecimalDigits(){
        ChangeJar.mutate(true);
        new ChangeJar("1.000");
    }

    // testing negative nickels for constructor
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegNickels(){
        ChangeJar.mutate(true);
        new ChangeJar(0,3,-1,5);
    }

    // testing negative dimes for constructor
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegDimes(){
        ChangeJar.mutate(true);
        new ChangeJar(0,-3,1,5);
    }

    // testing negative number quarters for the constructor
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegQuarters() {
        ChangeJar.mutate(true);
        new ChangeJar(-300, 0, 0, 0);
    }

    // testing negative number pennies for the constructor
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegPennies() {
        ChangeJar.mutate(true);
        new ChangeJar(0, 0, 0, -13);
    }

    //testing negative amount for constructor
    @Test(expected = IllegalArgumentException.class)
    public void testNegAmount(){
        ChangeJar.mutate(true);
        new ChangeJar(-3.24);
    }

    // testing valid takeOut with wide range of
    // quarters, dimes, nickels, pennies
    @Test
    public void testTakeOut1() {
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(3, 3, 2, 2);
        jar.takeOut(1, 1, 1, 1);
        assertEquals(2, jar.getQuarters());
        assertEquals(2, jar.getDimes());
        assertEquals(1, jar.getNickels());
        assertEquals(1, jar.getPennies());
    }

    //testing takeout with ChangeJar
    @Test
    public void testTakeOutJar(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(5,5,5,5);
        ChangeJar jar1 = new ChangeJar(1,1,1,1);

        jar.takeOut(jar1);

        assertEquals(4, jar.getQuarters());
        assertEquals(4, jar.getDimes());
        assertEquals(4, jar.getNickels());
        assertEquals(4, jar.getPennies());

        jar1 = new ChangeJar();
        jar.takeOut(jar1);

        assertEquals(4, jar.getQuarters());
        assertEquals(4, jar.getDimes());
        assertEquals(4, jar.getNickels());
        assertEquals(4, jar.getPennies());
    }


    //testing takeout with larger parameter quarters
    @Test(expected = IllegalArgumentException.class)
    public void testLargeTakeoutQuarters(){
        ChangeJar jar1 = new ChangeJar(1,1,1,1);
        ChangeJar jar2 = new ChangeJar(2,1,1,1);
        jar1.takeOut(jar2);
    }

    //testing takeout with larger parameter dimes
    @Test(expected = IllegalArgumentException.class)
    public void testLargeTakeoutDimes(){
        ChangeJar jar1 = new ChangeJar(1,1,1,1);
        ChangeJar jar2 = new ChangeJar(1,2,1,1);
        jar1.takeOut(jar2);
    }

    //testing takeout with larger parameter nickels
    @Test(expected = IllegalArgumentException.class)
    public void testLargeTakeoutNickels(){
        ChangeJar jar1 = new ChangeJar(1,1,1,1);
        ChangeJar jar2 = new ChangeJar(1,1,2,1);
        jar1.takeOut(jar2);
    }

    //testing takeout with larger parameter pennies
    @Test(expected = IllegalArgumentException.class)
    public void testLargeTakeoutPennies(){
        ChangeJar jar1 = new ChangeJar(1,1,1,1);
        ChangeJar jar2 = new ChangeJar(1,1,1,2);
        jar1.takeOut(jar2);
    }

    //testing takeout with false mutate
    @Test(expected = IllegalArgumentException.class)
    public void testFalseTakeOut(){
        ChangeJar jar1 = new ChangeJar(1,1,1,1);
        ChangeJar jar2 = new ChangeJar(1,1,1,1);
        ChangeJar.mutate(false);
        jar1.takeOut(jar2);
    }

    // testing larger number for nickels in takeOut
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutLargeNickels() {
        ChangeJar.mutate(true);
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(1, 1, 4, 1);
    }

    // testing larger number for dimes in takeOut
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutLargeDimes() {
        ChangeJar.mutate(true);
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(1, 5, 1, 1);
    }

    // testing larger number for quarters in takeOut
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutLargeQuarters() {
        ChangeJar.mutate(true);
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(5, 1, 1, 1);
    }

    // testing large number for pennies in takeOut
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutLargePennies() {
        ChangeJar.mutate(true);
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(1, 1, 1, 5);
    }


    // testing negative number for nickels in takeOut
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutNegNickels() {
        ChangeJar.mutate(true);
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(1, 1, -4, 1);
    }

    // testing negative number for dimes in takeOut
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutNegDimes() {
        ChangeJar.mutate(true);
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(1, -1, 1, 1);
    }

    // testing negative number for quarters in takeOut
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutNegQuarters() {
        ChangeJar.mutate(true);
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(-1, 1, 1, 1);
    }

    // testing negative number for pennies in takeOut
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutNegPennies() {
        ChangeJar.mutate(true);
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(1, 1, 1, -1);
    }

    //testing false mutate takeout
    @Test(expected = IllegalArgumentException.class)
    public void testTakeOutFalse(){
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        ChangeJar.mutate(false);
        jar1.takeOut(1, 1, 1, 1);

    }

    //testing takeout
    @Test
    public void testTakeOut2() {
        ChangeJar.mutate(true);
        ChangeJar jar1 = new ChangeJar(5, 3, 4, 3);
        ChangeJar jar2 = jar1.takeOut(1.22);

        assertEquals(1, jar1.getQuarters());
        assertEquals(1, jar1.getDimes());
        assertEquals(4, jar1.getNickels());
        assertEquals(1, jar1.getPennies());

        assertEquals(4, jar2.getQuarters());
        assertEquals(2, jar2.getDimes());
        assertEquals(0, jar2.getNickels());
        assertEquals(2, jar2.getPennies());

        ChangeJar jar = new ChangeJar(3.23);
        ChangeJar.mutate(false);
        assertEquals(null,jar.takeOut(1.32));

        ChangeJar.mutate(true);
        ChangeJar jar3 = new ChangeJar(3,3,0,6);
        jar3.takeOut(.84);

        assertEquals(1,jar3.getQuarters());
        assertEquals(0, jar3.getDimes());
        assertEquals(0,jar3.getNickels());
        assertEquals(2, jar3.getPennies());

        jar3 = new ChangeJar(1,3,0,3);
        jar3.takeOut(.33);

        assertEquals(1,jar3.getQuarters());
        assertEquals(0, jar3.getDimes());
        assertEquals(0,jar3.getNickels());
        assertEquals(0, jar3.getPennies());

        jar3 = new ChangeJar(0,0,0,10);
        jar3.takeOut(.05);

        assertEquals(0,jar3.getQuarters());
        assertEquals(0, jar3.getDimes());
        assertEquals(0,jar3.getNickels());
        assertEquals(5, jar3.getPennies());

        jar3 = new ChangeJar(0,0,2,10);
        jar3.takeOut(.15);

        assertEquals(0,jar3.getQuarters());
        assertEquals(0, jar3.getDimes());
        assertEquals(0,jar3.getNickels());
        assertEquals(5, jar3.getPennies());

        jar3 = new ChangeJar(4,3,0,3);
        jar3.takeOut(.80);

        assertEquals(2,jar3.getQuarters());
        assertEquals(0, jar3.getDimes());
        assertEquals(0,jar3.getNickels());
        assertEquals(3, jar3.getPennies());

        jar3 = new ChangeJar(2,3,0,3);
        jar3.takeOut(.55);

        assertEquals(1,jar3.getQuarters());
        assertEquals(0, jar3.getDimes());
        assertEquals(0,jar3.getNickels());
        assertEquals(3, jar3.getPennies());

    }


    //testing negative takeout double
    @Test(expected = IllegalArgumentException.class)
    public void testNegTakeOut(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(1,1,1,1);
        jar.takeOut(-1.32);
    }

    //testing larger takeout double
    @Test(expected = IllegalArgumentException.class)
    public void testLargerTakeOut(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(1.23);
        jar.takeOut(2.31);
    }

    // testing add for valid low numbers
    @Test
    public void testAdd() {
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar();
        jar.add(2, 3, 4, 5);
        assertEquals(2, jar.getQuarters());
        assertEquals(3, jar.getDimes());
        assertEquals(4, jar.getNickels());
        assertEquals(5, jar.getPennies());

        ChangeJar jar2 = new ChangeJar(1,1,1,1);
        jar.add(jar2);
        assertEquals(3, jar.getQuarters());
        assertEquals(4, jar.getDimes());
        assertEquals(5, jar.getNickels());
        assertEquals(6, jar.getPennies());
    }

    //testing add for false mutate
    @Test(expected = IllegalArgumentException.class)
    public void testAddFalse(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(1,1,1,1);
        ChangeJar.mutate(false);
        jar.add(1,1,1,1);
    }

    //testing add for negative quarters
    @Test(expected = IllegalArgumentException.class)
    public void testNegAddQuarters(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(1,1,1,1);
        jar.add(-1,1,1,1);
    }

    //testing add for negative dimes
    @Test(expected = IllegalArgumentException.class)
    public void testNegAddDimes(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(1,1,1,1);
        jar.add(1,-1,1,1);
    }

    //testing add for negative nickels
    @Test(expected = IllegalArgumentException.class)
    public void testNegAddNickels(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(1,1,1,1);
        jar.add(1,1,-1,1);
    }

    //testing add for negative pennies
    @Test(expected = IllegalArgumentException.class)
    public void testNegAddPennies(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(1,1,1,1);
        jar.add(1,1,1,-1);
    }

    //testing add for false mutate
    @Test(expected = IllegalArgumentException.class)
    public void testFalseAdd(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(1.00);
        ChangeJar jar1 = new ChangeJar(1.20);
        ChangeJar.mutate(false);
        jar.add(jar1);
    }

    // Testing equals for valid numbers
    @Test
    public void testEqual() {
        ChangeJar.mutate(true);
        ChangeJar jar1 = new ChangeJar(2, 5, 4, 2);
        ChangeJar jar2 = new ChangeJar(6, 5, 4, 2);
        ChangeJar jar3 = new ChangeJar(2, 5, 4, 2);

        assertFalse(jar1.equals(jar2));
        assertTrue(jar1.equals(jar3));

        Object obj1 = new ChangeJar(2,5,4,2);
        Object obj2 = new ChangeJar(1,5,4,2);

        assertTrue(jar1.equals(obj1));
        assertFalse(jar1.equals(obj2));

        Object obj = new Object();
        assertFalse(jar1.equals(obj));

    }

    //testing equals with two parameters
    @Test
    public void testEqualsTwo(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(1,1,1,1);
        ChangeJar jar1 = new ChangeJar(1,1,1,1);

        assertTrue(ChangeJar.equals(jar,jar1));
        jar = new ChangeJar(1,2,3,4);
        assertFalse(ChangeJar.equals(jar,jar1));

    }

    // testing compareTo all returns
    @Test
    public void testCompareTo() {
        ChangeJar.mutate(true);
        ChangeJar jar1 = new ChangeJar(2, 5, 4, 2);
        ChangeJar jar2 = new ChangeJar(6, 5, 4, 2);
        ChangeJar jar3 = new ChangeJar(2, 3, 4, 2);
        ChangeJar jar4 = new ChangeJar(2, 5, 4, 2);

        assertTrue(jar2.compareTo(jar1) > 0);
        assertTrue(jar3.compareTo(jar1) < 0);
        assertTrue(jar1.compareTo(jar4) == 0);

        assertTrue(ChangeJar.compareTo(jar2,jar1)>0);
        assertTrue(ChangeJar.compareTo(jar3,jar1)<0);
        assertTrue(ChangeJar.compareTo(jar1,jar4)==0);
    }

    // load and save combined.
    @Test
    public void testLoadSave() {
        ChangeJar.mutate(true);
        ChangeJar jar1 = new ChangeJar(6, 5, 4, 2);
        ChangeJar jar2 = new ChangeJar(6, 5, 4, 2);

        jar1.save("file1");
        jar1 = new ChangeJar();  // resets to zero

        jar1.load("file1");
        assertTrue(jar1.equals(jar2));
    }

    //load mutate false
    @Test
            (expected = IllegalArgumentException.class)
    public void testLoadFalse(){
        ChangeJar.mutate(true);
        ChangeJar jar1 = new ChangeJar(1,1,1,1);
        ChangeJar jar2 = new ChangeJar(0,0,0,0);

        jar1.save("file1");

        ChangeJar.mutate(false);
        jar2.load("file1");
    }

    //testing dec
    @Test
    public void testDec() {
        ChangeJar.mutate(true);
        ChangeJar jar1 = new ChangeJar(1, 1, 1, 1);
        jar1.dec();
        assertEquals(0, jar1.getPennies());
    }


    //testing dec for false mutate
    @Test
            (expected = IllegalArgumentException.class)
    public void testFalseDec(){
        ChangeJar.mutate(true);
        ChangeJar jar1 = new ChangeJar(1,1,1,1);
        ChangeJar.mutate(false);
        jar1.dec();
    }

    //testing dec for subtracting from zero

    @Test
            (expected = IllegalArgumentException.class)
    public void testDecZero(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(0,0,0,0);
        jar.dec();
    }

    //testing inc
    @Test
    public void testInc() {
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(0, 0, 0, 0);
        jar.inc();
        assertEquals(1, jar.getPennies());
    }

    //testing inc for false mutate
    @Test
            (expected = IllegalArgumentException.class)
public void mutateFalseInc(){
        ChangeJar.mutate(true);
        ChangeJar  jar = new ChangeJar(1,1,1,1);
        ChangeJar.mutate(false);
        jar.inc();
    }

    //testing setting quarters
    @Test
    public void testSetQuarters(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(0,0,0,0);
        jar.setQuarters(5);
        assertEquals(5, jar.getQuarters());
    }

    //testing getting quarters
    @Test
    public void testGetQuarters(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(3,0,0,0);
        assertEquals(3, jar.getQuarters());
    }

    //testing neg quarters
    @Test
            (expected = IllegalArgumentException.class)
    public void testNegQuarters(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(1,1,1,1);
        jar.setQuarters(-3);
    }

    //testing setting quarters with false mutate.
    @Test(expected = IllegalArgumentException.class)
    public void testFalseMutateQuarters(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar();
        ChangeJar.mutate(false);
        jar.setQuarters(2);
    }

    //testing setting dimes
    @Test
    public void testSetDimes(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(0,0,0,0);
        jar.setDimes(5);
        assertEquals(5, jar.getDimes());
    }

    //testing getting dimes
    @Test
    public void testGetDimes(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(0,3,0,0);
        assertEquals(3, jar.getDimes());
    }

    //testing setting neg dimes
    @Test
            (expected = IllegalArgumentException.class)
    public void testNegDimes(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(1,1,1,1);
        jar.setDimes(-3);
    }

    //testing setting dimes with false mutate.
    @Test(expected = IllegalArgumentException.class)
    public void testFalseMutateDimes(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar();
        ChangeJar.mutate(false);
        jar.setDimes(2);
    }

    //testing setting nickels
    @Test
    public void testSetNickels(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(0,0,0,0);
        jar.setNickels(5);
        assertEquals(5, jar.getNickels());
    }

    //testing getting nickels
    @Test
    public void testGetNickels(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(0,0,3,0);
        assertEquals(3, jar.getNickels());
    }

    //testing setting negative nickels
    @Test
            (expected = IllegalArgumentException.class)
    public void testNegNickels(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(1,1,1,1);
        jar.setNickels(-3);
    }

    //testing setting nickels with false mutate.
    @Test(expected = IllegalArgumentException.class)
    public void testFalseMutateNickels(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar();
        ChangeJar.mutate(false);
        jar.setNickels(2);
    }

    //testing setting pennies
    @Test
    public void testSetPennies(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(0,0,0,0);
        jar.setPennies(5);
        assertEquals(5, jar.getPennies());
    }

    //testing getting pennies
    @Test
    public void testGetPennies(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(0,0,0,3);
        assertEquals(3, jar.getPennies());
    }

    //testing setting negative pennies
    @Test
            (expected = IllegalArgumentException.class)
    public void testNegPennies(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(1,1,1,1);
        jar.setPennies(-3);
    }

    //testing setting pennies with false mutate.
    @Test(expected = IllegalArgumentException.class)
    public void testFalseMutatePennies(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar();
        ChangeJar.mutate(false);
        jar.setPennies(2);
    }

    //testing toString
    @Test
    public void testToString(){
        ChangeJar.mutate(true);
        ChangeJar jar = new ChangeJar(1,1,1,1);
        String s = "1 Quarter" + "\n" + "1 Dime" + "\n" + "1 Nickel" + "\n" + "1 Penny" + "\n";
        assertEquals(s,jar.toString());

         jar = new ChangeJar(2,1,1,1);
         s = "2 Quarters" + "\n" + "1 Dime" + "\n" + "1 Nickel" + "\n" + "1 Penny" + "\n";
        assertEquals(s,jar.toString());

        jar = new ChangeJar(1,2,1,1);
        s = "1 Quarter" + "\n" + "2 Dimes" + "\n" + "1 Nickel" + "\n" + "1 Penny" + "\n";
        assertEquals(s,jar.toString());

        jar = new ChangeJar(1,1,2,1);
        s = "1 Quarter" + "\n" + "1 Dime" + "\n" + "2 Nickels" + "\n" + "1 Penny" + "\n";
        assertEquals(s,jar.toString());

        jar = new ChangeJar(1,1,1,2);
        s = "1 Quarter" + "\n" + "1 Dime" + "\n" + "1 Nickel" + "\n" + "2 Pennies" + "\n";
        assertEquals(s,jar.toString());
    }
}

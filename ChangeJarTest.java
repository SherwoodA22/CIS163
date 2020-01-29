package Project1;

import org.junit.Test;

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
    }


    // testing negative nickels for constructor
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegNickels(){
        new ChangeJar(0,3,-1,5);
    }

    // testing negative nickels for constructor
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegDimes(){
        new ChangeJar(0,-3,1,5);
    }

    // testing negative number quarters for the constructor
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegQuarters() {
        new ChangeJar(-300, 0, 0, 0);
    }

    // testing negative number pennies for the constructor
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegPennies() {
        new ChangeJar(0, 0, 0, -13);
    }

    // testing valid takeOut with wide range of
    // quarters, dimes, nickels, pennies
    @Test
    public void testTakeOut1() {
        ChangeJar jar = new ChangeJar(3, 3, 2, 2);
        jar.takeOut(1, 1, 1, 1);
        assertEquals(2, jar.getQuarters());
        assertEquals(2, jar.getDimes());
        assertEquals(1, jar.getNickels());
        assertEquals(1, jar.getPennies());
    }

    @Test
    public void testTakeOut2() {
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
    }

    // testing larger number for nickels in takeOut
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutLargeNickels() {
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(1, 1, 4, 1);
    }

    // testing larger number for dimes in takeOut
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutLargeDimes() {
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(1, 5, 1, 1);
    }

    // testing larger number for quarters in takeOut
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutLargeQuarters() {
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(5, 1, 1, 1);
    }

    // testing large number for pennies in takeOut
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutLargePennies() {
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(1, 1, 1, 5);
    }


    // testing negative number for nickels in takeOut
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutNegNickels() {
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(1, 1, -4, 1);
    }

    // testing negative number for dimes in takeOut
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutNegDimes() {
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(1, -1, 1, 1);
    }

    // testing negative number for quarters in takeOut
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutNegQuarters() {
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(-1, 1, 1, 1);
    }

    // testing negative number for pennies in takeOut
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutNegPennies() {
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(1, 1, 1, -1);
    }

    // testing putIn for valid low numbers
    @Test
    public void testAdd() {
        ChangeJar jar = new ChangeJar();
        jar.add(2, 3, 4, 5);
        assertEquals(2, jar.getQuarters());
        assertEquals(3, jar.getDimes());
        assertEquals(4, jar.getNickels());
        assertEquals(5, jar.getPennies());
    }

    // Testing equals for valid numbers
    @Test
    public void testEqual() {
        ChangeJar jar1 = new ChangeJar(2, 5, 4, 2);
        ChangeJar jar2 = new ChangeJar(6, 5, 4, 2);
        ChangeJar jar3 = new ChangeJar(2, 5, 4, 2);

        assertFalse(jar1.equals(jar2));
        assertTrue(jar1.equals(jar3));

        Object obj1 = new ChangeJar(2,5,4,2);
        Object obj2 = new ChangeJar(1,5,4,2);

        assertTrue(jar1.equals(obj1));
        assertFalse(jar1.equals(obj2));

        obj1 = new ChangeJar();
        assertFalse(jar1.equals(obj1));

    }

    // testing compareTo all returns
    @Test
    public void testCompareTo() {
        ChangeJar jar1 = new ChangeJar(2, 5, 4, 2);
        ChangeJar jar2 = new ChangeJar(6, 5, 4, 2);
        ChangeJar jar3 = new ChangeJar(2, 3, 4, 2);
        ChangeJar jar4 = new ChangeJar(2, 5, 4, 2);

        assertTrue(jar2.compareTo(jar1) > 0);
        assertTrue(jar3.compareTo(jar1) < 0);
        assertTrue(jar1.compareTo(jar4) == 0);
    }

    // load and save combined.
    @Test
    public void testLoadSave() {
        ChangeJar jar1 = new ChangeJar(6, 5, 4, 2);
        ChangeJar jar2 = new ChangeJar(6, 5, 4, 2);

        jar1.save("file1");
        jar1 = new ChangeJar();  // resets to zero

        jar1.load("file1");
        assertTrue(jar1.equals(jar2));
    }

    //testing dec
    @Test
    public void testDec(){
        ChangeJar jar1 = new ChangeJar(1,1,1,1);
        jar1.dec();
        assertEquals(0, jar1.getPennies());

       ChangeJar.mutate(false);
        jar1 = new ChangeJar(1,1,1,1);
        jar1.dec();
        assertEquals(1,jar1.getPennies());
        ChangeJar.mutate(true);
    }

    //testing dec for subtracting from zero

    @Test
            (expected = IllegalArgumentException.class)
    public void testDecZero(){
        ChangeJar jar = new ChangeJar(0,0,0,0);
        jar.dec();
    }

    //testing inc
    @Test
    public void testInc(){
        ChangeJar jar = new ChangeJar(0,0,0,0);
        jar.inc();
        assertEquals(1, jar.getPennies());

        ChangeJar.mutate(false);
        jar = new ChangeJar(1,1,1,1);
        jar.inc();
        assertEquals(1,jar.getPennies());
        ChangeJar.mutate(true);
    }

    //testing setting quarters
    @Test
    public void testSetQuarters(){
        ChangeJar jar = new ChangeJar(0,0,0,0);
        jar.setQuarters(5);
        assertEquals(5, jar.getQuarters());
    }

    //testing getting quarters
    @Test
    public void testGetQuarters(){
        ChangeJar jar = new ChangeJar(3,0,0,0);
        assertEquals(3, jar.getQuarters());
    }

    //testing neg quarters
    @Test
            (expected = IllegalArgumentException.class)
    public void testNegQuarters(){

    }

    //testing setting dimes
    @Test
    public void testSetDimes(){
        ChangeJar jar = new ChangeJar(0,0,0,0);
        jar.setDimes(5);
        assertEquals(5, jar.getDimes());
    }

    //testing getting dimes
    @Test
    public void testGetDimes(){
        ChangeJar jar = new ChangeJar(0,3,0,0);
        assertEquals(3, jar.getDimes());
    }

    //testing setting nickels
    @Test
    public void testSetNickels(){
        ChangeJar jar = new ChangeJar(0,0,0,0);
        jar.setNickels(5);
        assertEquals(5, jar.getNickels());
    }

    //testing getting nickels
    @Test
    public void testGetNickels(){
        ChangeJar jar = new ChangeJar(0,0,3,0);
        assertEquals(3, jar.getNickels());
    }

    //testing setting pennies
    @Test
    public void testSetPennies(){
        ChangeJar jar = new ChangeJar(0,0,0,0);
        jar.setPennies(5);
        assertEquals(5, jar.getPennies());
    }

    //testing getting pennies
    @Test
    public void testGetPennies(){
        ChangeJar jar = new ChangeJar(0,0,0,3);
        assertEquals(3, jar.getPennies());
    }
}

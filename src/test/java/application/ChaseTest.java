
package application;

import org.junit.Assert;
import org.junit.Test;


public class ChaseTest {
    Chase chase = new Chase(123456789112L , 987654321L); //create ne object in order to invoke methods of Chase

    public ChaseTest() throws Exception {
    }
    //will test behavior of chase obj

    //validating one objects behavior means all other objects created from this class will behave the same


    @Test
    public void depositPositive() {
        chase.deposit(1000); //depositing 1000
        //validating if the balance is 1000; bc newly created account doesnt have any deposit
        //delta -> forgiven . how much difference you're ok with

       // double actual = chase.getBalance(); we can use that way to make it cleaner
       Assert.assertEquals("depositing 1000" , 1000.0, chase.getBalance(),0); // always add message to the test

    }
    //after every test your instance vars reinitialized

    //all test cases must be in different tests bc if one test will fail you wont
    //be able to test others. but if they're under different test cases then all tests can be
    //tested independently

    @Test
    public void depositLessThen0() {
        chase.deposit(-100);
        Assert.assertEquals("deposit less then 0", 0.0, chase.getBalance(),0);
    }

    @Test
    public void depositMoreThen10000() {
        chase.deposit(20000);
        Assert.assertEquals("deposit more then 10000", 0.0, chase.getBalance(),0);

    }

    @Test
    public void withdrawPositive(){
        chase.deposit(1000);
        chase.withDraw(100);
        Assert.assertEquals("withdraw positive", 900, chase.getBalance(),0 );

    }
    @Test
    public void withdrawNegative(){
        chase.deposit(1000);
        chase.withDraw(-100);
        Assert.assertEquals("withdraw negative" , 1000, chase.getBalance(),0);

    }
    @Test
    public void withdrawMoreThen1000(){
        chase.deposit(2000);
        chase.withDraw(2000);
        Assert.assertEquals("withdraw more then 1000", 2000, chase.getBalance(), 0);

    }
    @Test
    public void withdrawMoreThenBalance(){
        chase.deposit(100);
        chase.withDraw(200);
        Assert.assertEquals("withdraw more then a balance", 100, chase.getBalance(),0);

    }

}


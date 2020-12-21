package application;

import org.junit.Assert;
import org.junit.Test;

public class BankOfAmericaTest {
    BankOfAmerica boa = new BankOfAmerica(123456789111L, 456811111);

    public BankOfAmericaTest() throws Exception {
    }

    @Test
    public void depositPositive(){
        boa.deposit(100);
        Assert.assertEquals( 300, boa.getBalance(),0);
    }

    @Test
    public void depositNegative(){
        boa.deposit(-100);
        Assert.assertEquals(200, boa.getBalance(),0);
    }
    @Test
    public void depositMoreThen20000(){
        boa.deposit(25000);
        Assert.assertEquals( 200, boa.getBalance(),0);

    }

    @Test
    public void withdrawNegative(){
        boa.withDraw(-100);
        Assert.assertEquals(200, boa.getBalance(),0);

    }

    @Test
    public void withdrawMoreThenBalance(){
        boa.withDraw(400);
        Assert.assertEquals(200, boa.getBalance(),0);

    }

    @Test
    public void withdrawMoreThen5000(){
        boa.deposit(6000);
        boa.withDraw(5500);
        Assert.assertEquals(6200, boa.getBalance(),0);

    }

    @Test
    public void withdrawPositive(){
        boa.withDraw(100);
        Assert.assertEquals(100, boa.getBalance(),0);

    }



}

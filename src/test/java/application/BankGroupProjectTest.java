package application;

import org.junit.Assert;
import org.junit.Test;

public class BankGroupProjectTest {


    @Test(expected = Exception.class)
    //proper way to write test that will throw exception // we are not checking data here , we ar checking the exception
    public void invalidRoutingNumChase() throws Exception {
        Chase chase1 = new Chase(1234567891123L, 12345678911L);

    }

    @Test // we are not checking data here , we ar checking the exception
    public void invalidAccountNum() {
        boolean exceptionCought = false;
        try {
            Chase chase2 = new Chase(123456789123111L, 123456789L);
        } catch (Exception e) {
            exceptionCought = true;
            System.out.println(e.getMessage());
        } finally {// finally block will ru no matter what, whether you cought the exception or not
            Assert.assertTrue(exceptionCought);
        }

    }

    @Test
    public void invalidAccountNumException() {
        String msg = "";
        try {
            Chase chase2 = new Chase(123456789123L, 123456789L);
        } catch (Exception e) {
            msg = e.getMessage();
            System.out.println(e.getMessage());
        }
            Assert.assertEquals("Account number should be 12 digits.", msg); // line checks if exception prints message

    }

}
//test set not empty when created account
//creat 2 acc w diff nums set should have it
//test if we create 2 acc w same acc num
//as many test cases as you can 
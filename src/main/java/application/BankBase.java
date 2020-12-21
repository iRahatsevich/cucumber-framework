package application;

import java.util.HashSet;
import java.util.Set;


public abstract class BankBase implements Bank {

    private long accountNumber;
    private long routingNum;

    public static Set<BankBase> accountStorage = new HashSet<>(); //make it static so it belongs to the class . adding value when we are creating object. the collection will belong to the class

    //set account that will hide var without getter / setter
    //cannot use getter and setter for account/routing bc it will be provided once and its not changable


    public BankBase(long accountNumber, long routingNum) throws Exception {
        if (Long.toString(accountNumber).length() != 12) { //convert long to wrapper class(Long) converted to string and check length
            throw new Exception("Account number must be 12 digits");
        } else if (Long.toString(routingNum).length() != 9) {
            throw new Exception("Routing number should be 9 digits.");
        } else {
            this.accountNumber = accountNumber;
            this.routingNum = routingNum;
        }
    }


    public static void addToAccountStorage(BankBase account) throws Exception { //using parent class and will check account for both chase nd BoA
      /*  if (!accountStorage.isEmpty()) {
            for (BankBase bb : accountStorage) {
                if (bb.accountNumber == account.accountNumber) {
                    throw new Exception("Account number " + account.accountNumber + " already exists");
                } else if (bb.routingNum == account.routingNum) {
                    throw new Exception("Routing number " + account.routingNum + " already exists");
                } else {
                    accountStorage.add(account);
                }
            }
        } else {
            accountStorage.add(account);
        }*/
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getRoutingNum() {
        return routingNum;
    }

    public void setRoutingNum(long routingNum) {
        this.routingNum = routingNum;
    }
}



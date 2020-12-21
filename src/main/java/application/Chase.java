package application;

public class Chase extends BankBase {
    private double balance = 0;



    public Chase(long accountNum, long routingNum) throws Exception{
        super(accountNum, routingNum);
        addToAccountStorage(this); // static method inside constructor , we use this. refering to current obj that will be created from this constructor
    }




    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0 || amount > 10000) {
            System.err.println("invalid amount, cannot be deposited");
        } else {
            balance += amount;
        }
    }

    @Override
    public void withDraw(double amount) {
        if (amount < 0 || amount > 1000) {
            System.err.println("invalid amount, cannot be withdraw");
        } else {
            if (balance < amount) {
                System.err.println("insufficient funds");

            } else {
                balance -= amount;
            }
        }
    }
}
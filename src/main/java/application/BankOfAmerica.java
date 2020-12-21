package application;

public class BankOfAmerica extends BankBase {
    private  double balance = 200;

    public BankOfAmerica(long accountNum, long routingNum) throws Exception{
        super(accountNum, routingNum);
        addToAccountStorage(this);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0 || amount > 20000) {
            System.err.println("invalid amount, cannot be deposited");
        } else {
            balance += amount;
        }
    }

    @Override
    public void withDraw(double amount) {
        if (amount < 0 || amount > 5000) {
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

package application;

public interface Bank {

    double getBalance();
    void deposit(double amount);
    void withDraw(double amount);


//create Chase class which will implement Bank interface
//it should have balance variable
//it should not let withdraw more then 1000
//not let deposit more then 10000
//not let withdraw negative values

    /**
     *  Putting interface types in params enable these Bank sender and reciepent params(arguments) to be able to be used with any class that implements
     *  Bank interface.
     * @param sender -> put bankAccount of a sender
     * @param recipient -> put bankAccout of a recipient
     */
    static void transferFunds(Bank sender, Bank recipient, double transferAmount) {
        sender.withDraw(transferAmount);
        recipient.deposit(transferAmount);
    }
}

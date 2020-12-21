package application;

import java.util.Scanner;

public class BankerDemo {

    //
    public static void main(String[] args) throws Exception {




        //polymorphism can be used in initializing an object when you decide which object to initialize at runtime
        Bank whateverBank = new BankOfAmerica(123456789112L, 123456789L);

        whateverBank.deposit(1256);
        System.out.println(whateverBank.getBalance());


        Bank whatever = new Chase(123456789111L, 123456789L);

        System.out.println("pls enter which bank account to use");
        String userChose = new Scanner(System.in).nextLine();

        /*
        switch(userChose.toLowerCase()){
            case "chase":
                whatever = new Chase();
                break;
            case "bank of america":
                whatever = new BankOfAmerica();
                break;
            default:
                whatever = null;
        }*/

        whatever.deposit(1000);
        System.out.println(whatever.getBalance());


        Chase alexChase = new Chase(123456789111L, 987654321L);
        alexChase.deposit(1000);

        Chase bellaChase = new Chase(123456789111L, 987654321L);
        bellaChase.deposit(2000);

        transferFunds(alexChase, bellaChase, 800);
        System.out.println(alexChase.getBalance());
        System.out.println(bellaChase.getBalance());

        BankOfAmerica johnBOA = new BankOfAmerica(123456789111L, 987654321L);
        johnBOA.deposit(2000);

        System.out.println();
        transferFunds(johnBOA, alexChase, 800);
        System.out.println(alexChase.getBalance());
        System.out.println(johnBOA.getBalance());
    }
    /*
     *by making params an interface type is good that i dont need to worry if its chase/BOA etc
     * its making it universal for banks we are using
     *
     * putting interface types in interface enable this Bank params to be able to be used with
     * any class that implements Bank interface
     * @param sender
     * @param recipient
     */
    public static void transferFunds (Bank sender, Bank recipient, double transferAmount){
     if (sender.getBalance() >= transferAmount){
        sender.withDraw(transferAmount);
     recipient.deposit(transferAmount);

    }else{
         System.out.println("insufficient funds");
     }
}}

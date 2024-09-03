

import java.util.Scanner;
public class BankingApp {

    public static void main(String arg[]) {
        // System.err.println("hello world");

        Scanner sc = new Scanner(System.in);
        System.out.println("how many members input you can add?");   
        int n = sc.nextInt();
        BankDetails C[] = new BankDetails[n];
        for(int i = 0; i < C.length; i++){
            C[i] = new BankDetails();
            C[i].openAccount();
        }
        int ch;
        do {
            System.out.println("\n *** Banking system application ***");
            System.out.println("1. Display all account deatails  \n 2. Search by account number \n 3. Deposit the amount \n 4. Withdraw the amount \n 5. enter your choice");
            System.out.println("enter your choice:");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                for(int i = 0; i < C.length; i++){
                       C[i].ShowAccount();
                }
                    
                    break;
                case 2:
                System.out.println("enter your account number you want to search");
                String ac_no = sc.next();
                boolean found = false;
                for(int i = 0; i < C.length; i++){
                    found = C[i].search(ac_no);
                    if (found){
                        break;
                    }

                }
                if(!found){
                    System.out.println("search failed account doesnot exist");
                }
                break;

                case 3:
                System.out.println("enter  account number ");
                 ac_no = sc.next();
                 found = false;
                for(int i = 0; i < C.length; i++){
                    found = C[i].search(ac_no);
                    if (found){
                        C[i].deposit();
                        break;
                    }

                }
                if(!found){
                    System.out.println("search failed account doesnot exist");
                }
                break;

                case 4:
                System.out.println("enter  account number :");
                 ac_no = sc.next();
                 found = false;
                for(int i = 0; i < C.length; i++){
                    found = C[i].search(ac_no);
                    if (found){
                        C[i].withdraw();
                        break;
                    }

                }
                if(!found){
                    System.out.println("search failed account doesnot exist");
                }
                break;
                 case 5:
                 System.out.println("see you soon....");
                 break;
                
            }
        }
        while (ch!=5);
    }
}
class BankDetails {
    private String accno;
    private String name;
    private String acctype;
    private long balance;

    Scanner sc = new Scanner(System.in);

    // Method to open new account
  public void openAccount(){
    System.out.println("enter Account number ");
    accno = sc.next();
    System.out.println("enter Account type ");
    acctype = sc.next();
    System.out.println("enter  name ");
    name = sc.next();
    System.out.println("enter  balance ");
    balance = sc.nextLong();
  }  
    // method to display 
    public void ShowAccount(){
       System.out.println("name of the account holder : " + name);
       System.out.println("account number : " + accno);
       System.out.println("accounttype : " + acctype);
       System.out.println("balance : " + balance);
    }
    // method to deposit
    public void deposit(){
        long amt;
        System.out.println("enter the amount you want to deposit");
        amt = sc.nextLong();
        balance = balance + amt;
    }
    // method to withdraw
    public void withdraw(){
        long amt;
        System.out.println("enter the amount you want to Withdraw");
        amt = sc.nextLong();
        if (balance >= amt) {
        balance = balance - amt;
            
        } else {
            System.out.println("insufficient balance your balance is"+ amt + "transaction failed");
        }
    }
    // method to search an account number
    public boolean search(String ac_no){
        if (accno.equals(ac_no)) {
            ShowAccount();
            return(true);
            
        } else {
            return(false);
            
        }
    }


}



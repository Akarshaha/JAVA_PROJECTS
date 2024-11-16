import java.util.Scanner;

class BankDetails {
    private String acc_no;
    private String name;
    private String acc_type;
    private long balance;
    Scanner scn = new Scanner(System.in);
    public void openAccount(){
        System.out.println("Enter Account NO: ");
        acc_no = scn.next();
        System.out.println("Enter Account type: ");
        acc_type = scn.next();
        System.out.println("Enter name: ");
        name = scn.next();
        System.out.println("Enter balance: ");
        balance = scn.nextLong();
    }

    public void showAccount() {
        System.out.println("name of the account_holder:" + name);
        System.out.println("Account number:" + acc_no);
        System.out.println("Account type:" + acc_type);
        System.out.println("Balance:" + balance);
    }
    public void deposit(){
        long amt;
        System.out.println("enter the amount to deposit");
        amt = scn.nextLong();
        balance = balance + amt;
    }
    public void withdraw(){
        long amt;
        System.out.println("enter the amount to withdraw");
        amt = scn.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
            System.out.println("balance after withdrawal" + balance);
        } else {
            System.out.println("your balance is less than " + amt + "transaction failed...!!");
        }
    }

    public boolean search(String ac_no){
        if (acc_no.equals(ac_no)) {
            showAccount();
            return(true);
        }
        return(false);
    }
}

public class App {
    public static void main(String[] args)  {
Scanner scn = new Scanner(System.in);
System.out.println("how many number of customers you want to input?");
int n = scn.nextInt();
BankDetails C[] = new BankDetails[n];
for (int i = 0; i < C.length; i++) {
    C[i] = new BankDetails();
    C[i].openAccount();
    
}
int ch;
do {
    System.out.println("\n ***BANKING SYSTEM APPLICATION***");
    System.out.println("1.Display all account details \n 2. search account number \n 3. Deposit the amount \n 4.withdraw the amount \n 5.exit");
    System.out.println("Enter your choice");
    ch = scn.nextInt();
    switch (ch) {
         case 1:
        for (int i = 0; i < C.length; i++) {
        C[i].showAccount();
        }
        break;
        case 2:
    System.out.println("enter account number you want to get");
    String ac_no = scn.next();
    boolean found = false;
        for (int i = 0; i < C.length; i++) {
           found = C[i].search(ac_no);
               if (found) {
                break;
            }
    }
    if(!found){
    System.out.println("Search failed account does not exist");
    }
    break;
        case 3:
    System.out.println("enter account number ");
    ac_no = scn.next();
    found = false;
    for (int i = 0; i < C.length; i++) {
    found = C[i].search(ac_no);
    if (found) {
    C[i].deposit();
    break;
    }
}
    if(!found){
    System.out.println("Search failed account does not exist");
    }
    break;
        case 4:
    System.out.println("enter account number ");
    ac_no = scn.next();
    found = false;
    for (int i = 0; i < C.length; i++) {
    found = C[i].search(ac_no);
    if (found) {
    C[i].withdraw();
    break;
    }
}
    if(!found){
    System.out.println("Search failed account does not exist");
    }
    break;
    case 5:
    System.out.println("see you soon...");
    break;
    }
} while (ch != 5);
    }
}

package app.ba.ui;
import app.ba.service.AccountService;
import app.ba.service.AccountServiceImpl;
import java.util.Scanner;
public class BankUi {
    public static void main(String[] args) {
        int t=1,choice,accNum,User,s = 1;
        double amount;
        AccountService accountService = new AccountServiceImpl();
        Scanner scanner = new Scanner(System.in);
        while(s == 1)
        {
            System.out.println("1. Existing");
            System.out.println("2. New User");
            User = scanner.nextInt();
            switch(User)
            {
                case 1:
                    while(t==1)
                    {
                        System.out.println("1. Check Balance");
                        System.out.println("2. Deposit");
                        System.out.println("3. Withdraw");
                        System.out.println("4. Transfer");
                        System.out.println("5. Last 10 Transactions");
                        System.out.println("6. Update Account Details");
                        System.out.println("7. Delete Account");
                        System.out.println("0. exit");
                        choice = scanner.nextInt();
                        if(choice == 0)
                        {
                            System.out.println("Application Exiting");
                            break;
                        }

                        switch(choice)
                        {
                            case 1:
                                System.out.println("Enter Account Number : ");
                                accNum = scanner.nextInt();
                                System.out.println(accountService.checkBalance(accNum));
                                break;
                            case 2:
                                System.out.println("Enter Account Number : ");
                                accNum = scanner.nextInt();
                                System.out.println("Enter Amount : ");
                                amount = scanner.nextDouble();
                                accountService.deposit(accNum,amount);
                                System.out.println("Current Balance : "+accountService.checkBalance(accNum));
                                break;
                            case 3:
                                System.out.println("Enter Account Number : ");
                                accNum = scanner.nextInt();
                                System.out.println("Enter Amount : ");
                                amount = scanner.nextDouble();
                                accountService.withdraw(accNum,amount);
                                System.out.println("Current Balance : "+accountService.checkBalance(accNum));
                                break;
                            case 4:
                                System.out.println("Enter Source Account Number : ");
                                accNum = scanner.nextInt();
                                System.out.println("Enter Destination Account Number : ");
                                int accNum1 = scanner.nextInt();
                                System.out.println("Enter Amount : ");
                                amount = scanner.nextDouble();
                                accountService.transfer(accNum,accNum1,amount);
                                System.out.println("Current Balance : "+accountService.checkBalance(accNum));
                                break;
                            case 5:
                                System.out.println("Enter Account Number : ");
                                accNum = scanner.nextInt();
                                accountService.getLast10Transactions(accNum);
                                break;
                            case 6:
                                System.out.println("Enter Account number : ");
                                accNum = scanner.nextInt();
                                System.out.println("Enter New Name : ");
                                String name = scanner.next();
                                System.out.println("Enter New Email : ");
                                String email = scanner.next();
                                accountService.updateAccount(accNum,name,email);
                            case 7:
                                System.out.println("Enter Account number");
                                accNum = scanner.nextInt();
                                accountService.deleteAccount(accNum);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;

                        }
                    }
                case 2:
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Email: ");
                    String email = scanner.next();
                    System.out.print("Enter Initial Deposit Amount: ");
                    double money = scanner.nextDouble();
                    System.out.println(accountService.createAccount(name,email,money));
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.println("Enter 1 to continue 0 to exit");
            s = scanner.nextInt();
        }
    }
}

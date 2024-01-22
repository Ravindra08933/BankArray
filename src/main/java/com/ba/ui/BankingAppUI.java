package com.ba.ui;
import com.ba.Service.AccountService;
import com.ba.bean.Account;
import com.ba.util.BankUtil;

import java.util.Scanner;

public class BankingAppUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankUtil bankUtil = new BankUtil();

        while(true)
        {
            System.out.println("1. Create Account");
            System.out.println("2. Delete Account");
            int choice = scanner.nextInt();
            switch (choice)
            {
                case 1:
                    bankUtil.addCustomer("DF",123,new Account(876,87654,"Current"));
                    break;
                case 2:
                    System.out.println(bankUtil.deleteCustomer(123));
            }


        }
    }
}



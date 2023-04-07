package com.it_academy.homework4.app_JDBC.scannerFromModel;

import com.it_academy.homework4.app_JDBC.model.Account;
import com.it_academy.homework4.app_JDBC.scannerMain.ScannerHelper;

import java.sql.Connection;

public class AccountScanner {
    public static Account inputAccount(Connection connection) {
        Account account = new Account();
        ScannerHelper scannerHelper = new ScannerHelper(connection);
        account.setUserIdFromAcc(scannerHelper.scanUserId());
        account.setBalance(scannerHelper.scanBalance());
        account.setCurrency(scannerHelper.scanNewCurrency(account.getUserIdFromAcc()));
        return account;
    }


}


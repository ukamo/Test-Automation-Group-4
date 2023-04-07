package com.it_academy.homework4.app_JDBC.scannerFromModel;

import com.it_academy.homework4.app_JDBC.model.Transaction;
import com.it_academy.homework4.app_JDBC.queryFromSQL.AccountQueryExecutor;
import com.it_academy.homework4.app_JDBC.scannerMain.ScannerHelper;

import java.sql.Connection;

public class TransactionScanner {
    public static Transaction changeBalanceAccount(Connection connection, boolean isBalanceIncrease) {
        Transaction transaction = new Transaction();
        AccountQueryExecutor checkAcc = new AccountQueryExecutor(connection);
        ScannerHelper scannerHelper = new ScannerHelper(connection);
        int userIdChecking = scannerHelper.scanUserId();
        if (isBalanceIncrease) {
            transaction.setAmount(scannerHelper.scanBalance());
        } else {
            int amount = scannerHelper.scanBalance();
            transaction.setAmount(-amount);
        }
        String currencyChecking = scannerHelper.scanExistCurrency(userIdChecking);
        int accIdTransaction = checkAcc.getAccountIdSql(userIdChecking, currencyChecking);
        transaction.setAccountId(accIdTransaction);
        return transaction;
    }
}

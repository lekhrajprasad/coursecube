package com.coursecube.springboot;

import java.util.List;

public interface AccountService {
    public void addAccount(Account acc);
    public Account getAccountByAccno(int accno);
    public void deposit(TxInfo txInfo);
    public void withdraw(TxInfo txInfo);
    public void deleteAccount(int accno);
    public List<Account> getAllAccounts();
}

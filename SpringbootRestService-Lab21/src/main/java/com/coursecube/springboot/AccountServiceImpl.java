package com.coursecube.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountDAO accountDAO;

    @Override
    public void addAccount(Account acc) {
        System.out.println(acc);
        Account account = accountDAO.save(acc);
        System.out.println(acc);
    }

    @Override
    public Account getAccountByAccno(int accno) {
        return null;
    }

    @Override
    public void deposit(TxInfo txInfo) {

    }

    @Override
    public void withdraw(TxInfo txInfo) {

    }

    @Override
    public void deleteAccount(int accno) {

    }

    @Override
    public List<Account> getAllAccounts() {
        return null;
    }
}

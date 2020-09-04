package com.coursecube.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        Optional<Account> accountOptional = accountDAO.findById(accno);
        if(accountOptional.isPresent()){
            return accountOptional.get();
        }
        return null;
    }

    @Override
    public void deposit(TxInfo txInfo) {
        Optional<Account> optionalAccount = accountDAO.findById(txInfo.getAccno());
        if (optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            double updateBal = account.getBalance() + txInfo.getAmount();
            account.setBalance(updateBal);
            accountDAO.save(account);
        }
    }

    @Override
    public void withdraw(TxInfo txInfo) {
        Optional<Account> optionalAccount = accountDAO.findById(txInfo.getAccno());
        if (optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            double updateBal = account.getBalance() - txInfo.getAmount();
            account.setBalance(updateBal);
            accountDAO.save(account);
        }
    }

    @Override
    public void deleteAccount(int accno) {
        accountDAO.deleteById(accno);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountDAO.findAll();
    }
}

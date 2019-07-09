package edu.mum.cs544.bank.dao;

import edu.mum.cs544.bank.EntityManagerHelper;
import edu.mum.cs544.bank.domain.Account;

import javax.persistence.EntityManager;
import java.util.Collection;

public class JPAAccountDAO implements IAccountDAO {

    public void saveAccount(Account account) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.persist(account);
    }

    public void updateAccount(Account account) {
        EntityManager  em = EntityManagerHelper.getCurrent();
        em.merge(account);
    }

    public Account loadAccount(long accountnumber) {
        EntityManager em = EntityManagerHelper.getCurrent();
       return em.find(Account.class,accountnumber);
    }

    public Collection<Account> getAccounts() {
        EntityManager em = EntityManagerHelper.getCurrent();
        return em.createQuery("select distinct a from Account a join fetch a.entryList",Account.class).getResultList();
    }
}

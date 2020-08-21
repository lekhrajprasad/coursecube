package com.coursecube.springboot;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Repository("custDAO")
@Transactional
public class CustomerDAOImpl implements CustomerDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addCustomer(Customer cust) {
        entityManager.persist(cust);
    }

    @Override
    public void updateCustomer(Customer cust) {
        entityManager.merge(cust);
    }

    @Override
    public void deleteCustomer(int cid) {
        Customer cust = entityManager.getReference(Customer.class, cid);
        entityManager.remove(cust);

    }

    @Override
    public Customer getCustomerByCid(int cid) {
        return entityManager.find(Customer.class, cid);
    }

    @Override
    public List<Customer> getAllCustomers() {
        String JPAQL="from Customer cust";
        List<Customer> list = entityManager.createQuery(JPAQL, Customer.class)
                .getResultList();
        return list;
    }

    @Override
    public List<Customer> getCustomersByCity(String city) {
        String JPAQL="from Customer cust where cust.city=?1";
        return entityManager.createQuery(JPAQL, Customer.class)
                .setParameter(1, city)
                .getResultList();
    }

    @Override
    public List<Customer> getCustomersByEmail(String email) {
        String sql="select * from mycustomers where email=?";
        return entityManager.createNativeQuery(sql, Customer.class).setParameter(1, email).getResultList();
    }

    @Override
    public List<Customer> getCustomersByEmailAndPhone(String email, long phone) {
        String jpaql = "from Customer cust where email=?1 and phone=?2";
        return entityManager.createQuery(jpaql, Customer.class)
                .setParameter(1,email)
                .setParameter(2,phone)
                .getResultList();
    }

    @Override
    public List<Customer> getCustomersByEmailOrPhone(String email, long phone) {
        String jpaql = "from Customer cust where email=?1 or phone=?2";
        return entityManager.createQuery(jpaql, Customer.class)
                .setParameter(1,email)
                .setParameter(2,phone)
                .getResultList();
    }

    @Override
    public BigInteger getCustomerCount() {
        String sql = "select count(*) from mycustomers";
        return (BigInteger)entityManager.createNativeQuery(sql).getSingleResult();
    }

    @Override
    public BigInteger getCustomerCountByCity(String city) {
        String sql = "select count(*) from mycustomers where city=?";
        return (BigInteger)entityManager.createNativeQuery(sql)
                .setParameter(1, city)
                .getSingleResult();
    }

    @Override
    public String getCityByEmail(String email) {
        String sql = "select city from mycustomers where email=?";
        return (String)entityManager.createNativeQuery(sql)
                .setParameter(1,email)
                .getSingleResult();
    }

    @Override
    public long getPhoneByEmail(String email) {
        String sql = "select phone from mycustomers where email=?";
        String str = (String)entityManager.createNativeQuery(sql)
                .setParameter(1,email)
                .getSingleResult();
        return Long.parseLong(str);
    }

    @Override
    public int getCidByPhone(long phone) {
        String sql = "select cid from mycustomers where phone=?";
        return (Integer)entityManager.createNativeQuery(sql)
                .setParameter(1,phone)
                .getSingleResult();
    }

    @Override
    public void deleteAllCustomersGrThenId(int id) {
        String JPAQL="delete from Customer cust where cust.id > ?1";
        Query query = entityManager.createQuery(JPAQL);
        query.setParameter(1, id);
        query.executeUpdate();
    }
}

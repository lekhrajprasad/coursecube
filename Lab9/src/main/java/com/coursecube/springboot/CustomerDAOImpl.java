package com.coursecube.springboot;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
    public List<Customer> getAllCustomers() {
        String JPAQL="from Customer cust";
        List<Customer> list = entityManager.createQuery(JPAQL, Customer.class)
                .getResultList();
        return list;
    }

    @Override
    public List<Customer> getCustomerByCity(String city) {
        String JPAQL="from Customer cust where cust.city=?1";
        List<Customer> list =  entityManager.createQuery(JPAQL, Customer.class)
                .setParameter(1, city)
                .getResultList();
        return list;
    }
}

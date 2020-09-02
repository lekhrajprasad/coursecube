package com.coursecube.springboot;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("custDAO")
@Transactional
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    HibernateTemplate hibernateTemplate;

    @Override
    public void addCustomer(Customer cust) {
        hibernateTemplate.save(cust);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> list = hibernateTemplate.loadAll(Customer.class);
        return list;
    }

    @Override
    public List<Customer> getCustomerByCity(String city) {
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        dc.add(Restrictions.eq("city",city));

        List<Customer> list = (List<Customer>) hibernateTemplate.findByCriteria(dc);
        return list;
    }
}

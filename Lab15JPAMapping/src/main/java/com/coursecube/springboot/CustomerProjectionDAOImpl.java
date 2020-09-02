package com.coursecube.springboot;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CustomerProjectionDAOImpl implements CustomerProjectionDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<String> getEmailProjectionByEmail(String email) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);
        Root<Customer> customer = query.from(Customer.class);
        query.select(customer.get(email));
        List<String> resultList = entityManager.createQuery(query).getResultList();
        return resultList;
    }

    @Override
    public List<Object[]> getCidNamePhoneProjection() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root<Customer> customer = query.from(Customer.class);
        query.multiselect(customer.get("cid"), customer.get("cname"), customer.get("phone"));
        List<Object[]> resultList = entityManager.createQuery(query).getResultList();
        return resultList;
    }


}

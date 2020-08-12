package com.coursecube.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("custDAO")
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	NamedParameterJdbcTemplate npjdbcTemp;

	@Override
	public void addCustomer(Customer cust) {
		String sql = "insert into mycustomers values(:mycid,:mycname,:myemail,:myphone,:mycity)";
		Map<String, Object> params = new HashMap<>();
		params.put("mycid", cust.getCid());
		params.put("mycname", cust.getCname());
		params.put("myemail", cust.getEmail());
		params.put("myphone", cust.getPhone());
		params.put("mycity", cust.getCity());
		npjdbcTemp.update(sql, params);
	}

	public List<Customer> getAllCustomers() {
		String sql = "select * from customers";
		List<Customer> list = npjdbcTemp.query(sql, new CustomerRowMapper());
		return list;
	}

	@Override
	public List<Customer> getCustomersByCity(String city) {
		String SQL="select * from mycustomers where city=:mycity";
		Map<String, Object> params = new HashMap<>();
		params.put("mycity", city);
		List<Customer> list= npjdbcTemp.query(SQL,params, new
				CustomerRowMapper());
		return list;
	}
}

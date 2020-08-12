package com.coursecube.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("custDAO")
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	NamedParameterJdbcTemplate npjdbcTemp;

	@Autowired
	JdbcTemplate jdbcTemp;

	@Override
	public void addCustomer(Customer cust) {
		//using namedParameter
		/*String sql = "insert into mycustomers values(:mycid,:mycname,:myemail,:myphone,:mycity)";
		Map<String, Object> params = new HashMap<>();
		params.put("mycid", cust.getCid());
		params.put("mycname", cust.getCname());
		params.put("myemail", cust.getEmail());
		params.put("myphone", cust.getPhone());
		params.put("mycity", cust.getCity());
		npjdbcTemp.update(sql, params);*/

		//placeholder must match with valiable name declared in cust
		String sql = "insert into mycustomers values(:cid,:cname,:email,:phone,:city)";
		npjdbcTemp.update(sql, new BeanPropertySqlParameterSource(cust));

		//using jdbcTemplate
		/*String sql4jdbcTemp = "insert into mycustomers values(?,?,?,?,?)";
		jdbcTemp.update(sql, cust.getCid(), cust.getCname(), cust.getEmail(), cust.getPhone(), cust.getCity());*/
	}

	public List<Customer> getAllCustomers() {
		String sql = "select * from mycustomers";
		List<Customer> list = npjdbcTemp.query(sql, new CustomerRowMapper());

		/*List<Customer> list = jdbcTemp.query(sql, new CustomerRowMapper());*/

		return list;
	}

	@Override
	public List<Customer> getCustomersByCity(String city) {
		String SQL="select * from mycustomers where city=:mycity";

		List<Customer> list= npjdbcTemp.query(SQL, new MapSqlParameterSource("mycity", city), new CustomerRowMapper());

		return list;
	}
}

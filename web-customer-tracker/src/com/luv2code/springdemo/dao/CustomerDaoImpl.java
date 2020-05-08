package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

//this is ued to impl Dao.
@Repository
public class CustomerDaoImpl implements CustomerDao {

	//Auttowired SessionFactory bean id is declared in .xml
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() 
	{
		 //get current session
		 Session currentSession = sessionFactory.getCurrentSession();
	  	
		 //create query to get list of customer
		 Query<Customer> theQuery = currentSession.createQuery("from Customer order by first_name", Customer.class);
		 
		 //execute query
		 List<Customer> customers = theQuery.getResultList();
		
		 //return results 
		 return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer using HQL
		currentSession.saveOrUpdate(theCustomer);
		
		
	}

	@Override
	public Customer getCustomers(int theId)
	{
		//get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//read/retrieve data from db
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		//return that customer
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) 
	{
		//get current hibernet session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete customer
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
	    
		theQuery.setParameter("customerId", theId);

		theQuery.executeUpdate();
	}

}

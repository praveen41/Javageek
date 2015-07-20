/**
 * 
 */
package com.pasm.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 * @author Peter
 *
 */
@Repository
public class ContactDAOImpl implements ContactDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

}

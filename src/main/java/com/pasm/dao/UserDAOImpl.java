/**
 * 
 */
package com.pasm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.pasm.model.User;

/**
 * @author Peter
 * 
 */
@Repository
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addPerson(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
	}

	@Override
	public void updatePerson(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> personsList = session.createQuery("from Person").list();
		for (User p : personsList) {
		}
		return personsList;
	}

	@Override
	public User getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, new Integer(id));
		return p;
	}

	@Override
	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}

	@Override
	public User loginAction(String email, String password) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(User.class);
		Criterion emailId = Restrictions.eq("emailId", email);
		Criterion pass = Restrictions.eq("password", password);
		LogicalExpression andExp = Restrictions.and(emailId, pass);
		cr.add(andExp);
		User user = (User) cr.uniqueResult();
		return user;
	}

}
